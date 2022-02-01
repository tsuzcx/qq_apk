package com.tencent.av.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.IToolProcStart;
import com.tencent.mobileqq.qrscan.api.IQRToolProcStartApi;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public final class QavSharpnessSVIPHelper
{
  private VideoController a;
  private Activity b;
  private Boolean c;
  private boolean d;
  private QQProgressDialog e;
  private Handler f;
  private final Runnable g = new QavSharpnessSVIPHelper.1(this);
  private IToolProcStart h;
  
  public QavSharpnessSVIPHelper(VideoController paramVideoController, AVActivity paramAVActivity)
  {
    this.a = paramVideoController;
    this.b = paramAVActivity;
    this.f = new Handler();
  }
  
  public void a() {}
  
  public void a(Activity paramActivity)
  {
    QLog.d("QavSharpnessSVIPHelper", 2, "launchQQPayFunction");
    long l = System.currentTimeMillis();
    if (this.h == null) {
      this.h = ((IQRToolProcStartApi)QRoute.api(IQRToolProcStartApi.class)).get();
    }
    Handler localHandler = this.f;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.g);
      this.f.postDelayed(this.g, 1000L);
    }
    this.h.a("doubleVideo", 5000L, new QavSharpnessSVIPHelper.2(this, paramActivity, l));
  }
  
  public void b(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavSharpnessSVIPHelper", 1, "doRealLaunchQQPayFuntion");
    }
    paramActivity = this.h;
    if (paramActivity != null)
    {
      paramActivity.a();
      this.h = null;
    }
    VasH5PayUtil.a(this.b, "https://h5.vip.qq.com/p/pay/index?_wv=17301507&aid=mvip.n.a.hdvcall&type=!svip&isAskFriendPay=0&isSend=0");
  }
  
  public boolean b()
  {
    if (this.c == null)
    {
      this.c = new Boolean(false);
      this.c = Boolean.valueOf(this.a.af());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSVIP:= ");
        localStringBuilder.append(this.c);
        QLog.w("QavSharpnessSVIPHelper", 1, localStringBuilder.toString());
      }
    }
    return this.c.booleanValue();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.w("QavSharpnessSVIPHelper", 1, "promotionSVIPSuccess");
    }
    this.c = new Boolean(true);
  }
  
  public void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showProgress mProgressShowing:");
      localStringBuilder.append(this.d);
      QLog.d("QavSharpnessSVIPHelper", 2, localStringBuilder.toString());
    }
    if (this.d) {
      return;
    }
    try
    {
      if (this.e == null)
      {
        this.e = new QQProgressDialog(this.b, this.b.getResources().getDimensionPixelSize(2131299920));
        this.e.a(HardCodeUtil.a(2131906700));
        this.e.c(false);
      }
      this.d = true;
      this.e.show();
      return;
    }
    catch (Exception localException)
    {
      label115:
      break label115;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavSharpnessSVIPHelper", 2, "");
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("hideProgress  mProgressShowing:");
      localStringBuilder1.append(this.d);
      QLog.d("QavSharpnessSVIPHelper", 2, localStringBuilder1.toString());
    }
    try
    {
      if (this.f != null) {
        this.f.removeCallbacks(this.g);
      }
      if ((this.e != null) && (this.e.isShowing())) {
        this.e.dismiss();
      }
      this.d = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("hide init check progress:");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("QavSharpnessSVIPHelper", 2, localStringBuilder2.toString());
      }
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    this.c = null;
    this.b = null;
    Object localObject = this.f;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.f = null;
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((IToolProcStart)localObject).a();
      this.h = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavSharpnessSVIPHelper
 * JD-Core Version:    0.7.0.1
 */