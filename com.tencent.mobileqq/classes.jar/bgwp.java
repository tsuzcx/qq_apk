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

abstract class bgwp
{
  private final INTERFACE.GuardInstruction jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$GuardInstruction;
  private INTERFACE.StJudgeTimingRsp jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StJudgeTimingRsp;
  private final Context jdField_a_of_type_AndroidContentContext;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  private final MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  
  bgwp(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
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
          localObject1 = new bgxg((INTERFACE.GuardInstruction)localObject1, paramContext, paramMiniAppInfo);
          if (localObject1 == null) {
            continue;
          }
          ((bgwp)localObject1).a(paramStJudgeTimingRsp);
          ((bgwp)localObject1).a(new bgwq(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt));
          ((bgwp)localObject1).a();
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
            localObject2 = new bgww((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 3)
          {
            localObject2 = new bgwy((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 6)
          {
            localObject2 = new bgwu((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 7)
          {
            QMLog.d("GameGrowthGuardianManager", "tryBuildAndShow() called with: modal = " + ((INTERFACE.GuardInstruction)localObject2).modal.get());
            if (((INTERFACE.GuardInstruction)localObject2).modal.get() == 0) {
              localObject2 = new bgxe((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
            } else {
              localObject2 = new bgxb((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
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
  
  protected bgwo a()
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
    bgrb localbgrb = bgow.a(a(), 230).a(a().title.get()).a(a().msg.get());
    if (a() != null) {
      localbgrb.b(a().a(), a().a());
    }
    if (b() != null) {
      localbgrb.a(b().a(), b().a());
    }
    localbgrb.setOnShowListener(new bgws(this, new bgwr(this)));
    localbgrb.setOnDismissListener(new bgwt(this));
    localbgrb.setCancelable(false);
    localbgrb.show();
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
        for (String str6 = bhcn.a(a());; str6 = null)
        {
          bhcn.a(a(), str6, null, a(), b(), paramString, str1, str2, str3, str4, str5);
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
  
  protected bgwo b()
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
 * Qualified Name:     bgwp
 * JD-Core Version:    0.7.0.1
 */