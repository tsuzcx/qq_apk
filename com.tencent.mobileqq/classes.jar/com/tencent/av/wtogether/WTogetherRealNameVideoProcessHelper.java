package com.tencent.av.wtogether;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.wtogether.callback.RealNameAuthCallback;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class WTogetherRealNameVideoProcessHelper
{
  private static Boolean a;
  private VideoAppInterface b;
  private boolean c;
  private WTogetherRealNameVideoProcessHelper.RealNameAuthReceiver d;
  private RealNameAuthCallback e;
  private WeakReference<Activity> f;
  private String g = null;
  
  public WTogetherRealNameVideoProcessHelper(VideoAppInterface paramVideoAppInterface)
  {
    this.b = paramVideoAppInterface;
    this.d = new WTogetherRealNameVideoProcessHelper.RealNameAuthReceiver(this, null);
  }
  
  private void a(boolean paramBoolean)
  {
    a = Boolean.valueOf(paramBoolean);
  }
  
  private void c()
  {
    this.b.s();
    d();
  }
  
  private void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.q2v.avReceiveRealNameMsg");
    this.b.getApplication().registerReceiver(this.d, localIntentFilter);
    this.c = true;
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "register");
    }
  }
  
  private void e()
  {
    try
    {
      QLog.d("WTogetherRealNameVideoProcessHelper", 1, "unRegister start ");
      if (this.c)
      {
        this.b.getApplication().unregisterReceiver(this.d);
        this.c = false;
      }
    }
    catch (Exception localException)
    {
      QLog.d("WTogetherRealNameVideoProcessHelper", 1, new Object[] { "unregisterReceiver error : ", localException.getMessage() });
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "unRegister");
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "onActivityResult");
    }
    paramIntent = this.e;
    if (paramIntent != null) {
      paramIntent.a(a.booleanValue());
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.f = new WeakReference(paramActivity);
  }
  
  public void a(RealNameAuthCallback paramRealNameAuthCallback)
  {
    this.e = paramRealNameAuthCallback;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public boolean a()
  {
    a = Boolean.valueOf(this.b.r());
    return a.booleanValue();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog");
    }
    Object localObject1 = this.f;
    if (localObject1 != null) {
      localObject1 = (Activity)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    if ((localObject1 instanceof AVActivity))
    {
      Object localObject2 = (AVActivity)localObject1;
      if (!((AVActivity)localObject2).isFinishing())
      {
        if (((AVActivity)localObject2).isDestroyed()) {
          return;
        }
        String str2 = ((Activity)localObject1).getString(2131887436);
        localObject2 = ((Activity)localObject1).getString(2131887435);
        String str1 = this.g;
        if (str1 != null) {
          localObject2 = str1;
        }
        localObject1 = DialogUtil.a((Context)localObject1, 230, str2, (CharSequence)localObject2, ((Activity)localObject1).getString(2131897211), ((Activity)localObject1).getString(2131897213), new WTogetherRealNameVideoProcessHelper.1(this, (Activity)localObject1), new WTogetherRealNameVideoProcessHelper.2(this));
        ((QQCustomDialog)localObject1).setCancelable(false);
        ((QQCustomDialog)localObject1).show();
      }
    }
  }
  
  public void b(RealNameAuthCallback paramRealNameAuthCallback)
  {
    if (a())
    {
      paramRealNameAuthCallback.a(true);
      return;
    }
    a(paramRealNameAuthCallback);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper
 * JD-Core Version:    0.7.0.1
 */