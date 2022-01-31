package com.tencent.biz.qqstory.storyHome;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
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
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TrimmableManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
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
import nxv;
import nxw;
import nxx;
import nxy;
import nxz;

public class QQStoryBaseActivity
  extends IphoneTitleBarActivity
  implements IEventReceiver
{
  public Dialog a;
  public Bitmap a;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new nxy(this);
  private QQStoryActivityManager jdField_a_of_type_ComTencentBizQqstoryModelQQStoryActivityManager;
  public QQStoryBaseActivity.ProgressView a;
  public AppInterface a;
  protected Map a;
  public int[] a;
  private long[] jdField_a_of_type_ArrayOfLong = new long[4];
  protected Handler b = new Handler(Looper.getMainLooper());
  public ImageView c;
  public final String e = "Q.qqstory.QQStoryBaseActivity";
  protected final boolean h = false;
  public boolean i = true;
  protected boolean j;
  protected int n;
  protected int o;
  
  public QQStoryBaseActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    QQStoryManager localQQStoryManager;
    SoftReference localSoftReference;
    do
    {
      do
      {
        int k;
        int m;
        int i1;
        int i2;
        do
        {
          return;
          k = paramIntent.getIntExtra("positionX", 0);
          m = paramIntent.getIntExtra("positionY", 0);
          i1 = paramIntent.getIntExtra("viewWidth", -1);
          i2 = paramIntent.getIntExtra("viewHeight", -1);
          this.i = paramIntent.getBooleanExtra("need_image_animation", true);
          paramIntent = paramIntent.getStringExtra("viewImageKey");
        } while ((i1 < 0) || (i2 < 0));
        this.jdField_a_of_type_ArrayOfInt = new int[4];
        this.jdField_a_of_type_ArrayOfInt[0] = k;
        this.jdField_a_of_type_ArrayOfInt[1] = m;
        this.jdField_a_of_type_ArrayOfInt[2] = i1;
        this.jdField_a_of_type_ArrayOfInt[3] = i2;
      } while (TextUtils.isEmpty(paramIntent));
      localQQStoryManager = (QQStoryManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(180);
      localSoftReference = (SoftReference)localQQStoryManager.a.get(paramIntent);
    } while ((localSoftReference == null) || (localSoftReference.get() == null));
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localSoftReference.get());
    localQQStoryManager.a.remove(paramIntent);
  }
  
  private boolean a(int paramInt)
  {
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_ArrayOfLong[paramInt];
    if (l < 1000L)
    {
      SLog.d("Q.qqstory.QQStoryBaseActivity", "open twice take time:%d", new Object[] { Long.valueOf(l) });
      return true;
    }
    this.jdField_a_of_type_ArrayOfLong[paramInt] = SystemClock.elapsedRealtime();
    return false;
  }
  
  public View a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt, null);
  }
  
  public void a(CharSequence paramCharSequence)
  {
    a(paramCharSequence, true, 0L);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    a(paramCharSequence, paramBoolean, paramLong, null);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.b.removeCallbacksAndMessages(null);
    this.b.postDelayed(new nxw(this, this, paramOnDismissListener, paramBoolean, paramCharSequence), paramLong);
  }
  
  protected void a(String paramString) {}
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
    if (AppSetting.b) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + "按钮");
    }
  }
  
  public void a(@NonNull Map paramMap)
  {
    paramMap.put(new Subscriber.SubscriberWrapper(Looper.getMainLooper(), new nxz(this, this)), "root_group");
  }
  
  protected void b(String paramString) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    b("onActivityResult");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QQStoryContext.a();
    Object localObject1 = new HashMap();
    a((Map)localObject1);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.putAll((Map)localObject1);
    a("register subscriber size : " + this.jdField_a_of_type_JavaUtilMap.size());
    localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      Dispatchers.get().registerSubscriber((String)localObject2, localSubscriber);
    }
    super.doOnCreate(paramBundle);
    b("onCreate");
    this.j = true;
    this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryActivityManager = ((QQStoryActivityManager)SuperManager.a(18));
    this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryActivityManager.a(this);
    QQStoryContext.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
    Bosses.get().postLightWeightJob(new nxv(this), 10);
    ((TrimmableManager)SuperManager.a(26)).a(0);
    a(getIntent());
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    b("onDestroy");
    this.j = false;
    this.jdField_a_of_type_ComTencentBizQqstoryModelQQStoryActivityManager.b(this);
    a("unregister subscriber size : " + this.jdField_a_of_type_JavaUtilMap.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      Dispatchers.get().unRegisterSubscriber(localSubscriber);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    b("onPause");
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    b("onResume");
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    b("onStart");
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    b("onStop");
    this.b.removeCallbacks(null);
  }
  
  public void f()
  {
    this.b.removeCallbacksAndMessages(null);
    this.b.post(new nxx(this));
  }
  
  public void g()
  {
    SLog.b("Q.qqstory.QQStoryBaseActivity", "onOutOfMemory");
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.pgc", 2, "QQStoryBaseActivity doEnterAnimation mAnimationPlayedTimes=" + this.o);
    }
    int k = this.n;
    this.n = (k + 1);
    if (k > 0) {}
    do
    {
      ViewGroup localViewGroup;
      Object localObject;
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ArrayOfInt == null) || (this.jdField_a_of_type_ArrayOfInt.length < 4) || (this.o > 0));
        this.o += 1;
        k = this.jdField_a_of_type_ArrayOfInt[0];
        int m = this.jdField_a_of_type_ArrayOfInt[1];
        int i1 = this.jdField_a_of_type_ArrayOfInt[2];
        int i2 = this.jdField_a_of_type_ArrayOfInt[3];
        localViewGroup = (ViewGroup)((ViewGroup)findViewById(16908290)).getChildAt(0);
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.i))
        {
          this.c = new ImageView(this);
          this.c.setScaleType(ImageView.ScaleType.FIT_XY);
          localObject = new FrameLayout.LayoutParams(-1, -1);
          localViewGroup.addView(this.c, (ViewGroup.LayoutParams)localObject);
          this.c.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        int i3 = localViewGroup.getMeasuredWidth();
        int i4 = localViewGroup.getMeasuredHeight();
        float f1 = i1 * 1.0F / i3;
        float f2 = i2 * 1.0F / i4;
        localObject = new AnimationSet(true);
        ((AnimationSet)localObject).setInterpolator(new DecelerateInterpolator());
        ((AnimationSet)localObject).setRepeatMode(1);
        ((AnimationSet)localObject).setRepeatCount(0);
        ((AnimationSet)localObject).setDuration(100L);
        ((AnimationSet)localObject).addAnimation(new ScaleAnimation(f1, 1.0F, f2, 1.0F, 0.5F, 0.5F));
        ((AnimationSet)localObject).addAnimation(new TranslateAnimation(k, 0.0F, m, 0.0F));
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.c == null) || (!this.i)) {
          break;
        }
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
        localAlphaAnimation.setRepeatMode(1);
        localAlphaAnimation.setRepeatCount(0);
        localAlphaAnimation.setDuration(100L);
        this.c.startAnimation(localAlphaAnimation);
        localViewGroup.startAnimation((Animation)localObject);
        localAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.pgc", 2, "QQStoryBaseActivity doEnterAnimation animationSet start with origin view");
      return;
      localViewGroup.startAnimation((Animation)localObject);
      ((AnimationSet)localObject).setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.pgc", 2, "QQStoryBaseActivity doEnterAnimation animationSet start without origin view");
  }
  
  public boolean isValidate()
  {
    return (this.j) && (!isFinishing());
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (a(0)) {
      return;
    }
    super.startActivity(paramIntent);
  }
  
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    if (a(1)) {
      return;
    }
    super.startActivity(paramIntent, paramBundle);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (a(2)) {
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (a(3)) {
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity
 * JD-Core Version:    0.7.0.1
 */