package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import com.tribe.async.dispatch.Subscriber.SubscriberWrapper;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QQStoryBaseActivity
  extends IphoneTitleBarActivity
  implements IEventReceiver
{
  private static final int M_COUNT = 4;
  private static final int M_startActivity = 0;
  private static final int M_startActivityForResult = 2;
  private static final int M_startActivityForResult_opt = 3;
  private static final int M_startActivity_opt = 1;
  protected final boolean DEBUG = false;
  public final String TAG = "Q.qqstory.QQStoryBaseActivity";
  protected int animationTimes = 0;
  Animation.AnimationListener listener = new QQStoryBaseActivity.4(this);
  private QQStoryActivityManager mActivityHelper;
  protected Map<Subscriber, String> mActors = new HashMap();
  protected int[] mAnimationArgs = null;
  protected int mAnimationPlayedTimes = 0;
  public AppInterface mApp;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  private long[] mLastStartActTime = new long[4];
  protected Dialog mLoadingDialog;
  protected QQStoryBaseActivity.ProgressView mLoadingView;
  protected ImageView mMaskImageView = null;
  protected Bitmap mOriginViewBitmap = null;
  protected boolean mValidate = false;
  protected boolean needImageAnimation = true;
  
  private void initAnimation(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    int i = paramIntent.getIntExtra("positionX", 0);
    int j = paramIntent.getIntExtra("positionY", 0);
    int k = paramIntent.getIntExtra("viewWidth", -1);
    int m = paramIntent.getIntExtra("viewHeight", -1);
    this.needImageAnimation = paramIntent.getBooleanExtra("need_image_animation", true);
    paramIntent = paramIntent.getStringExtra("viewImageKey");
    if (k >= 0)
    {
      if (m < 0) {
        return;
      }
      this.mAnimationArgs = new int[4];
      Object localObject = this.mAnimationArgs;
      localObject[0] = i;
      localObject[1] = j;
      localObject[2] = k;
      localObject[3] = m;
      if (!TextUtils.isEmpty(paramIntent))
      {
        localObject = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.QQSTORY_MANAGER);
        SoftReference localSoftReference = (SoftReference)((QQStoryManager)localObject).a.get(paramIntent);
        if ((localSoftReference != null) && (localSoftReference.get() != null))
        {
          this.mOriginViewBitmap = ((Bitmap)localSoftReference.get());
          ((QQStoryManager)localObject).a.remove(paramIntent);
        }
      }
    }
  }
  
  private boolean isTooFastOpenActivity(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    long[] arrayOfLong = this.mLastStartActTime;
    l -= arrayOfLong[paramInt];
    if (l < 1000L)
    {
      SLog.d("Q.qqstory.QQStoryBaseActivity", "startActivity fail, open twice take time:%d", new Object[] { Long.valueOf(l) });
      return true;
    }
    arrayOfLong[paramInt] = SystemClock.elapsedRealtime();
    return false;
  }
  
  public <T extends View> T $(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public <T extends View> T $(View paramView, int paramInt)
  {
    return paramView.findViewById(paramInt);
  }
  
  public <T extends ViewGroup.LayoutParams> T $lp(View paramView)
  {
    return paramView.getLayoutParams();
  }
  
  public void dismissLoadingDialog()
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.post(new QQStoryBaseActivity.3(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doEnterAnimation()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QQStoryBaseActivity doEnterAnimation mAnimationPlayedTimes=");
      ((StringBuilder)localObject1).append(this.mAnimationPlayedTimes);
      QLog.d("Q.qqstory.pgc", 2, ((StringBuilder)localObject1).toString());
    }
    int i = this.animationTimes;
    this.animationTimes = (i + 1);
    if (i > 0) {
      return;
    }
    Object localObject1 = this.mAnimationArgs;
    if ((localObject1 != null) && (localObject1.length >= 4))
    {
      i = this.mAnimationPlayedTimes;
      if (i <= 0)
      {
        this.mAnimationPlayedTimes = (i + 1);
        i = localObject1[0];
        int j = localObject1[1];
        int k = localObject1[2];
        int m = localObject1[3];
        localObject1 = (ViewGroup)((ViewGroup)findViewById(16908290)).getChildAt(0);
        if ((this.mOriginViewBitmap != null) && (this.needImageAnimation))
        {
          this.mMaskImageView = new ImageView(this);
          this.mMaskImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          ((ViewGroup)localObject1).addView(this.mMaskImageView, (ViewGroup.LayoutParams)localObject2);
          this.mMaskImageView.setImageBitmap(this.mOriginViewBitmap);
        }
        int n = ((ViewGroup)localObject1).getMeasuredWidth();
        int i1 = ((ViewGroup)localObject1).getMeasuredHeight();
        float f1 = k * 1.0F / n;
        float f2 = m * 1.0F / i1;
        Object localObject2 = new AnimationSet(true);
        ((AnimationSet)localObject2).setInterpolator(new DecelerateInterpolator());
        ((AnimationSet)localObject2).setRepeatMode(1);
        ((AnimationSet)localObject2).setRepeatCount(0);
        ((AnimationSet)localObject2).setDuration(100L);
        ((AnimationSet)localObject2).addAnimation(new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.5F, 0.5F));
        ((AnimationSet)localObject2).addAnimation(new TranslateAnimation(i, 0.0F, j, 0.0F));
        if ((this.mOriginViewBitmap != null) && (this.mMaskImageView != null) && (this.needImageAnimation))
        {
          AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
          localAlphaAnimation.setRepeatMode(1);
          localAlphaAnimation.setRepeatCount(0);
          localAlphaAnimation.setDuration(100L);
          this.mMaskImageView.startAnimation(localAlphaAnimation);
          ((ViewGroup)localObject1).startAnimation((Animation)localObject2);
          localAlphaAnimation.setAnimationListener(this.listener);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.pgc", 2, "QQStoryBaseActivity doEnterAnimation animationSet start with origin view");
          }
        }
        else
        {
          ((ViewGroup)localObject1).startAnimation((Animation)localObject2);
          ((AnimationSet)localObject2).setAnimationListener(this.listener);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.pgc", 2, "QQStoryBaseActivity doEnterAnimation animationSet start without origin view");
          }
        }
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    logV("onActivityResult");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    QQStoryContext.a();
    Object localObject1 = new HashMap();
    onCreateSubscribers((Map)localObject1);
    this.mActors.clear();
    this.mActors.putAll((Map)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("register subscriber size : ");
    ((StringBuilder)localObject1).append(this.mActors.size());
    logD(((StringBuilder)localObject1).toString());
    localObject1 = this.mActors.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      StoryDispatcher.a().registerSubscriber((String)localObject2, localSubscriber);
    }
    super.doOnCreate(paramBundle);
    logV("onCreate");
    this.mValidate = true;
    this.mActivityHelper = ((QQStoryActivityManager)SuperManager.a(18));
    this.mActivityHelper.a(this);
    QQStoryContext.a();
    this.mApp = QQStoryContext.a();
    Bosses.get().postLightWeightJob(new QQStoryBaseActivity.1(this), 10);
    ((TrimmableManager)SuperManager.a(26)).a(0);
    initAnimation(getIntent());
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    logV("onDestroy");
    this.mValidate = false;
    this.mActivityHelper.b(this);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unregister subscriber size : ");
    ((StringBuilder)localObject).append(this.mActors.size());
    logD(((StringBuilder)localObject).toString());
    localObject = this.mActors.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)((Iterator)localObject).next()).getKey();
      StoryDispatcher.a().unRegisterSubscriber(localSubscriber);
    }
    localObject = this.mOriginViewBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.mOriginViewBitmap.recycle();
      this.mOriginViewBitmap = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    StoryReportor.a(StoryReportor.a(getClass(), 0), this.currentActivityStayTime, getActivityName());
    logV("onPause");
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    logV("onResume");
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    logV("onStart");
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    logV("onStop");
    this.mHandler.removeCallbacks(null);
  }
  
  public boolean isMainLooper()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public boolean isValidate()
  {
    return (this.mValidate) && (!isFinishing());
  }
  
  protected void logD(String paramString) {}
  
  protected void logV(String paramString) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreateSubscribers(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new Subscriber.SubscriberWrapper(Looper.getMainLooper(), new QQStoryBaseActivity.OutOfMemoryHandler(this, this)), "root_group");
  }
  
  protected void onOutOfMemory()
  {
    SLog.b("Q.qqstory.QQStoryBaseActivity", "onOutOfMemory");
  }
  
  public void setRightButton(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
    if (AppSetting.d)
    {
      paramString = this.rightViewText;
      paramOnClickListener = new StringBuilder();
      paramOnClickListener.append(this.rightViewText.getText());
      paramOnClickListener.append(HardCodeUtil.a(2131710756));
      paramString.setContentDescription(paramOnClickListener.toString());
    }
  }
  
  public void setRightButtonWithImage(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(paramInt);
    this.rightViewImg.setContentDescription(paramString);
    this.rightViewImg.setOnClickListener(paramOnClickListener);
  }
  
  public void showLoadingDialog(int paramInt)
  {
    showLoadingDialog(getString(paramInt), true, 0L);
  }
  
  public void showLoadingDialog(CharSequence paramCharSequence)
  {
    showLoadingDialog(paramCharSequence, true, 0L);
  }
  
  public void showLoadingDialog(CharSequence paramCharSequence, boolean paramBoolean)
  {
    showLoadingDialog(paramCharSequence, paramBoolean, 0L);
  }
  
  public void showLoadingDialog(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    showLoadingDialog(paramCharSequence, paramBoolean, paramLong, null);
  }
  
  public void showLoadingDialog(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.postDelayed(new QQStoryBaseActivity.2(this, this, paramOnDismissListener, paramBoolean, paramCharSequence), paramLong);
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (isTooFastOpenActivity(0)) {
      return;
    }
    super.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    if (isTooFastOpenActivity(1)) {
      return;
    }
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void startActivityDirectly(Intent paramIntent)
  {
    super.startActivityForResult(paramIntent, -1, null);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (isTooFastOpenActivity(2)) {
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (isTooFastOpenActivity(3)) {
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void startActivityForResultDirectly(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity
 * JD-Core Version:    0.7.0.1
 */