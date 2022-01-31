import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

abstract class bgsi
{
  private final INTERFACE.GuardInstruction jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$GuardInstruction;
  private INTERFACE.StJudgeTimingRsp jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StJudgeTimingRsp;
  private final Context jdField_a_of_type_AndroidContentContext;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  private final MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  
  bgsi(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$GuardInstruction = paramGuardInstruction;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  static void a(Context paramContext, MiniAppInfo paramMiniAppInfo, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, int paramInt)
  {
    if ((paramContext == null) || (paramStJudgeTimingRsp == null) || (paramStJudgeTimingRsp.timingInstructions.isEmpty())) {}
    for (;;)
    {
      return;
      try
      {
        if (paramInt >= paramStJudgeTimingRsp.timingInstructions.size()) {
          continue;
        }
        Object localObject1 = (INTERFACE.GuardInstruction)paramStJudgeTimingRsp.timingInstructions.get(paramInt);
        if (localObject1 == null) {
          continue;
        }
        if (((INTERFACE.GuardInstruction)localObject1).type.get() == 1)
        {
          localObject1 = new bgsz((INTERFACE.GuardInstruction)localObject1, paramContext, paramMiniAppInfo);
          if (localObject1 == null) {
            continue;
          }
          ((bgsi)localObject1).a(paramStJudgeTimingRsp);
          ((bgsi)localObject1).a(new bgsj(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt));
          ((bgsi)localObject1).a();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QMLog.e("GameGrowthGuardianManager", "tryBuildAndShow", localException);
          Object localObject2 = null;
          continue;
          if (((INTERFACE.GuardInstruction)localObject2).type.get() == 2)
          {
            localObject2 = new bgsp((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 3)
          {
            localObject2 = new bgsr((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 6)
          {
            localObject2 = new bgsn((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 7)
          {
            QMLog.d("GameGrowthGuardianManager", "tryBuildAndShow() called with: modal = " + ((INTERFACE.GuardInstruction)localObject2).modal.get());
            if (((INTERFACE.GuardInstruction)localObject2).modal.get() == 0) {
              localObject2 = new bgsx((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
            } else {
              localObject2 = new bgsu((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
            }
          }
          else
          {
            QMLog.w("GameGrowthGuardianManager", "tryBuildAndShow not create and show dialog for " + ((INTERFACE.GuardInstruction)localObject2).type.get());
            a(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt + 1);
            localObject2 = null;
          }
        }
      }
    }
  }
  
  INTERFACE.GuardInstruction a()
  {
    return this.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$GuardInstruction;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  protected bgsh a()
  {
    return null;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  String a()
  {
    return "sys_alert";
  }
  
  void a()
  {
    if ((a() == null) || (a() == null)) {
      return;
    }
    bgmu localbgmu = bgkp.a(a(), 230).a(a().title.get()).a(a().msg.get());
    if (a() != null) {
      localbgmu.b(a().a(), a().a());
    }
    if (b() != null) {
      localbgmu.a(b().a(), b().a());
    }
    localbgmu.setOnShowListener(new bgsl(this, new bgsk(this)));
    localbgmu.setOnDismissListener(new bgsm(this));
    localbgmu.setCancelable(false);
    localbgmu.show();
  }
  
  public void a(INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp)
  {
    this.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StJudgeTimingRsp = paramStJudgeTimingRsp;
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  protected void a(DialogInterface paramDialogInterface) {}
  
  protected void a(String paramString)
  {
    String str1;
    String str2;
    String str3;
    String str4;
    if (a() != null)
    {
      str1 = a().ruleName.get();
      str2 = String.valueOf(a().type.get());
      str3 = String.valueOf(a().modal.get());
      str4 = a().msg.get();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StJudgeTimingRsp != null) {}
      for (String str5 = String.valueOf(this.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StJudgeTimingRsp.nextDuration.get());; str5 = null)
      {
        if (a() != null) {}
        for (String str6 = bgyg.a(a());; str6 = null)
        {
          bgyg.a(a(), str6, null, a(), b(), paramString, str1, str2, str3, str4, str5);
          QMLog.d("GameGrowthGuardianManager", "performReport called with action = " + a() + ",subaction = " + b() + ",reserves = " + paramString + ",reverses2 = " + str1 + ",reverses3 = " + str2 + ",reverses4 = " + str3 + ",reverses5 = " + str4 + ",reserves6 = " + str5);
          return;
        }
      }
      str4 = null;
      str3 = null;
      str2 = null;
      str1 = null;
    }
  }
  
  protected bgsh b()
  {
    return null;
  }
  
  protected String b()
  {
    return null;
  }
  
  protected void b()
  {
    QMLog.d("GameGrowthGuardianManager", "onBackgroundForReport() called");
    a("hide");
  }
  
  protected void b(DialogInterface paramDialogInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsi
 * JD-Core Version:    0.7.0.1
 */