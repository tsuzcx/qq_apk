package com.tencent.biz.qqstory.storyHome;

import ajya;
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
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
import sst;
import stb;
import tcn;
import tcz;
import tdf;
import unq;
import unr;
import ved;
import vei;

public class QQStoryBaseActivity
  extends IphoneTitleBarActivity
  implements IEventReceiver
{
  protected Dialog a;
  protected Bitmap a;
  protected Handler a;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new unq(this);
  protected QQStoryBaseActivity.ProgressView a;
  public AppInterface a;
  protected Map<Subscriber, String> a;
  private tcn jdField_a_of_type_Tcn;
  protected int[] a;
  private long[] jdField_a_of_type_ArrayOfLong = new long[4];
  public ImageView c;
  public final String e = "Q.qqstory.QQStoryBaseActivity";
  protected final boolean h = false;
  protected boolean i = true;
  protected boolean j;
  
  public QQStoryBaseActivity()
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    sst localsst;
    SoftReference localSoftReference;
    do
    {
      do
      {
        int k;
        int m;
        int n;
        int i1;
        do
        {
          return;
          k = paramIntent.getIntExtra("positionX", 0);
          m = paramIntent.getIntExtra("positionY", 0);
          n = paramIntent.getIntExtra("viewWidth", -1);
          i1 = paramIntent.getIntExtra("viewHeight", -1);
          this.i = paramIntent.getBooleanExtra("need_image_animation", true);
          paramIntent = paramIntent.getStringExtra("viewImageKey");
        } while ((n < 0) || (i1 < 0));
        this.jdField_a_of_type_ArrayOfInt = new int[4];
        this.jdField_a_of_type_ArrayOfInt[0] = k;
        this.jdField_a_of_type_ArrayOfInt[1] = m;
        this.jdField_a_of_type_ArrayOfInt[2] = n;
        this.jdField_a_of_type_ArrayOfInt[3] = i1;
      } while (TextUtils.isEmpty(paramIntent));
      localsst = (sst)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(181);
      localSoftReference = (SoftReference)localsst.a.get(paramIntent);
    } while ((localSoftReference == null) || (localSoftReference.get() == null));
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localSoftReference.get());
    localsst.a.remove(paramIntent);
  }
  
  private boolean a(int paramInt)
  {
    long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_ArrayOfLong[paramInt];
    if (l < 1000L)
    {
      ved.d("Q.qqstory.QQStoryBaseActivity", "startActivity fail, open twice take time:%d", new Object[] { Long.valueOf(l) });
      return true;
    }
    this.jdField_a_of_type_ArrayOfLong[paramInt] = SystemClock.elapsedRealtime();
    return false;
  }
  
  public <T extends View> T a(int paramInt)
  {
    return findViewById(paramInt);
  }
  
  public <T extends ViewGroup.LayoutParams> T a(View paramView)
  {
    return paramView.getLayoutParams();
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
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new QQStoryBaseActivity.2(this, this, paramOnDismissListener, paramBoolean, paramCharSequence), paramLong);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramString);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
    if (AppSetting.d) {
      this.rightViewText.setContentDescription(this.rightViewText.getText() + ajya.a(2131710815));
    }
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new Subscriber.SubscriberWrapper(Looper.getMainLooper(), new unr(this, this)), "root_group");
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new QQStoryBaseActivity.3(this));
  }
  
  public void b(int paramInt)
  {
    a(getString(paramInt), true, 0L);
  }
  
  protected void b(String paramString) {}
  
  public void c()
  {
    ved.b("Q.qqstory.QQStoryBaseActivity", "onOutOfMemory");
  }
  
  protected void c(String paramString) {}
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    c("onActivityResult");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    QQStoryContext.a();
    Object localObject1 = new HashMap();
    a((Map)localObject1);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.putAll((Map)localObject1);
    b("register subscriber size : " + this.jdField_a_of_type_JavaUtilMap.size());
    localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      stb.a().registerSubscriber((String)localObject2, localSubscriber);
    }
    super.doOnCreate(paramBundle);
    c("onCreate");
    this.j = true;
    this.jdField_a_of_type_Tcn = ((tcn)tcz.a(18));
    this.jdField_a_of_type_Tcn.a(this);
    QQStoryContext.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
    Bosses.get().postLightWeightJob(new QQStoryBaseActivity.1(this), 10);
    ((tdf)tcz.a(26)).a(0);
    a(getIntent());
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    c("onDestroy");
    this.j = false;
    this.jdField_a_of_type_Tcn.b(this);
    b("unregister subscriber size : " + this.jdField_a_of_type_JavaUtilMap.size());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      stb.a().unRegisterSubscriber(localSubscriber);
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
    vei.a(vei.a(getClass(), 0), this.currentActivityStayTime, getActivityName());
    c("onPause");
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    c("onResume");
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    c("onStart");
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    c("onStop");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity
 * JD-Core Version:    0.7.0.1
 */