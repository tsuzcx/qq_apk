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
  private static Boolean jdField_a_of_type_JavaLangBoolean = null;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private WTogetherRealNameVideoProcessHelper.RealNameAuthReceiver jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper$RealNameAuthReceiver;
  private RealNameAuthCallback jdField_a_of_type_ComTencentAvWtogetherCallbackRealNameAuthCallback;
  private String jdField_a_of_type_JavaLangString = null;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public WTogetherRealNameVideoProcessHelper(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper$RealNameAuthReceiver = new WTogetherRealNameVideoProcessHelper.RealNameAuthReceiver(this, null);
  }
  
  private void a(boolean paramBoolean)
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.i();
    c();
  }
  
  private void c()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.q2v.avReceiveRealNameMsg");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper$RealNameAuthReceiver, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "register");
    }
  }
  
  private void d()
  {
    try
    {
      QLog.d("WTogetherRealNameVideoProcessHelper", 1, "unRegister start ");
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper$RealNameAuthReceiver);
        this.jdField_a_of_type_Boolean = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameVideoProcessHelper", 2, "unRegister");
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("WTogetherRealNameVideoProcessHelper", 1, new Object[] { "unregisterReceiver error : ", localException.getMessage() });
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog");
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localObject1 = (Activity)((WeakReference)localObject1).get();
      if (localObject1 != null) {
        break label44;
      }
    }
    label44:
    do
    {
      do
      {
        return;
        localObject1 = null;
        break;
      } while (!(localObject1 instanceof AVActivity));
      localObject2 = (AVActivity)localObject1;
    } while ((((AVActivity)localObject2).isFinishing()) || (((AVActivity)localObject2).isDestroyed()));
    String str = ((Activity)localObject1).getString(2131690597);
    Object localObject2 = ((Activity)localObject1).getString(2131690596);
    if (this.jdField_a_of_type_JavaLangString != null) {
      localObject2 = this.jdField_a_of_type_JavaLangString;
    }
    localObject1 = DialogUtil.a((Context)localObject1, 230, str, (CharSequence)localObject2, ((Activity)localObject1).getString(2131699088), ((Activity)localObject1).getString(2131699090), new WTogetherRealNameVideoProcessHelper.1(this, (Activity)localObject1), new WTogetherRealNameVideoProcessHelper.2(this));
    ((QQCustomDialog)localObject1).setCancelable(false);
    ((QQCustomDialog)localObject1).show();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "onActivityResult");
    }
    if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackRealNameAuthCallback != null) {
      this.jdField_a_of_type_ComTencentAvWtogetherCallbackRealNameAuthCallback.a(jdField_a_of_type_JavaLangBoolean.booleanValue());
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void a(RealNameAuthCallback paramRealNameAuthCallback)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackRealNameAuthCallback = paramRealNameAuthCallback;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.h());
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public void b(RealNameAuthCallback paramRealNameAuthCallback)
  {
    if (a())
    {
      paramRealNameAuthCallback.a(true);
      return;
    }
    a(paramRealNameAuthCallback);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper
 * JD-Core Version:    0.7.0.1
 */