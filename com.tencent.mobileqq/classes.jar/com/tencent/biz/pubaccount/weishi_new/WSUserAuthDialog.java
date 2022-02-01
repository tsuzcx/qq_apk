package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.eConfigBit;
import UserGrowth.stSchema;
import UserGrowth.stUserAuth;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.request.UserAuthRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class WSUserAuthDialog
{
  private Dialog a;
  
  private Dialog a(Context paramContext, String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131756058);
    localReportDialog.setContentView(2131560124);
    View localView = localReportDialog.findViewById(2131365837);
    localView.findViewById(2131382036).setOnClickListener(new WSUserAuthDialog.2(this, paramContext, paramString));
    localReportDialog.setOnCancelListener(new WSUserAuthDialog.3(this, paramString));
    localView.findViewById(2131382035).setOnClickListener(new WSUserAuthDialog.4(this, paramString));
    return localReportDialog;
  }
  
  private static void a()
  {
    WSLog.a("WSUserAuthDialog", "doTask: UserConfig request");
    WeishiTask localWeishiTask = new WeishiTask(new UserAuthRequest(eConfigBit.eShowConfirmWindow), null, new WSUserAuthDialog.1(), 4010);
    WeishiBusinessLooper.a().a(localWeishiTask);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", paramString, "authorized_window", 0);
    a();
    new WSUserAuthDialog().b(paramContext, paramString);
  }
  
  public static boolean a()
  {
    stUserAuth localstUserAuth = WSGlobalConfig.a().a();
    WSLog.a("WSUserAuthDialog", "判断是否需要弹窗");
    if (localstUserAuth == null)
    {
      WSLog.a("WSUserAuthDialog", "没有授权弹窗结构体");
      return false;
    }
    if (localstUserAuth.schema == null)
    {
      WSLog.a("WSUserAuthDialog", "user_auth.schema == null");
      return false;
    }
    if ((localstUserAuth.schema.type != 1) || (TextUtils.isEmpty(localstUserAuth.schema.miniAppSchema)))
    {
      WSLog.a("WSUserAuthDialog", "下发scheme不合法，不展示弹窗");
      return false;
    }
    WSLog.a("WSUserAuthDialog", localstUserAuth.toString());
    return localstUserAuth.show_confirm;
  }
  
  private void b()
  {
    WSLog.a("WSUserAuthDialog", "dialog dismiss");
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public void b(Context paramContext, String paramString)
  {
    this.a = a(paramContext, paramString);
    if (this.a != null)
    {
      this.a.setCanceledOnTouchOutside(true);
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog
 * JD-Core Version:    0.7.0.1
 */