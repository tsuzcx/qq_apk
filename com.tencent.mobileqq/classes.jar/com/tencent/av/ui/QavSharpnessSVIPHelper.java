package com.tencent.av.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.biz.qrcode.ipc.PreCallUpToolProc;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public final class QavSharpnessSVIPHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private PreCallUpToolProc jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new QavSharpnessSVIPHelper.1(this);
  private boolean jdField_a_of_type_Boolean;
  
  public QavSharpnessSVIPHelper(VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
    this.jdField_a_of_type_AndroidAppActivity = paramAVActivity;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  public void a() {}
  
  public void a(Activity paramActivity)
  {
    QLog.d("QavSharpnessSVIPHelper", 2, "launchQQPayFunction");
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc == null) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc = new PreCallUpToolProc(paramActivity);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc.a("doubleVideo", 5000L, new QavSharpnessSVIPHelper.2(this, paramActivity, l));
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null)
    {
      this.jdField_a_of_type_JavaLangBoolean = new Boolean(false);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(this.jdField_a_of_type_ComTencentAvVideoController.n());
      if (QLog.isColorLevel()) {
        QLog.w("QavSharpnessSVIPHelper", 1, "isSVIP:= " + this.jdField_a_of_type_JavaLangBoolean);
      }
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavSharpnessSVIPHelper", 1, "promotionSVIPSuccess");
    }
    this.jdField_a_of_type_JavaLangBoolean = new Boolean(true);
  }
  
  public void b(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavSharpnessSVIPHelper", 1, "doRealLaunchQQPayFuntion");
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc != null)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc.a();
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc = null;
    }
    VasH5PayUtil.a(this.jdField_a_of_type_AndroidAppActivity, "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=17301507&aid=mvip.n.a.hdvcall&type=!svip&isAskFriendPay=0&isSend=0");
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSharpnessSVIPHelper", 2, "showProgress mProgressShowing:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131708927));
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavSharpnessSVIPHelper", 2, "");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSharpnessSVIPHelper", 2, "hideProgress  mProgressShowing:" + this.jdField_a_of_type_Boolean);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSharpnessSVIPHelper", 2, "hide init check progress:" + localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_JavaLangBoolean = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc != null)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc.a();
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavSharpnessSVIPHelper
 * JD-Core Version:    0.7.0.1
 */