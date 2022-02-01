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

public class WSUserAuthDialog
{
  private Dialog a;
  
  private Dialog a(Context paramContext, String paramString)
  {
    Dialog localDialog = new Dialog(paramContext, 2131756409);
    localDialog.setContentView(2131559996);
    View localView = localDialog.findViewById(2131365674);
    localView.findViewById(2131381241).setOnClickListener(new WSUserAuthDialog.2(this, paramContext, paramString));
    localDialog.setOnCancelListener(new WSUserAuthDialog.3(this, paramString));
    localView.findViewById(2131381240).setOnClickListener(new WSUserAuthDialog.4(this, paramString));
    return localDialog;
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
    if ((localstUserAuth.schema.type == 1) && (!TextUtils.isEmpty(localstUserAuth.schema.miniAppSchema)))
    {
      WSLog.a("WSUserAuthDialog", localstUserAuth.toString());
      return localstUserAuth.show_confirm;
    }
    WSLog.a("WSUserAuthDialog", "下发scheme不合法，不展示弹窗");
    return false;
  }
  
  private void b()
  {
    WSLog.a("WSUserAuthDialog", "dialog dismiss");
    Dialog localDialog = this.a;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.a.dismiss();
    }
  }
  
  public void b(Context paramContext, String paramString)
  {
    this.a = a(paramContext, paramString);
    paramContext = this.a;
    if (paramContext != null)
    {
      paramContext.setCanceledOnTouchOutside(true);
      this.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog
 * JD-Core Version:    0.7.0.1
 */