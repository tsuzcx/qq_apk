import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

abstract class betk
{
  private final INTERFACE.GuardInstruction jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$GuardInstruction;
  private INTERFACE.StJudgeTimingRsp jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StJudgeTimingRsp;
  private final Context jdField_a_of_type_AndroidContentContext;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  private final MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  
  betk(INTERFACE.GuardInstruction paramGuardInstruction, Context paramContext, MiniAppInfo paramMiniAppInfo)
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
          localObject1 = new bety((INTERFACE.GuardInstruction)localObject1, paramContext, paramMiniAppInfo);
          if (localObject1 == null) {
            continue;
          }
          ((betk)localObject1).a(paramStJudgeTimingRsp);
          ((betk)localObject1).a(new betl(paramContext, paramMiniAppInfo, paramStJudgeTimingRsp, paramInt));
          ((betk)localObject1).a();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          besl.d("GameGrowthGuardianManager", "tryBuildAndShow", localException);
          Object localObject2 = null;
          continue;
          if (((INTERFACE.GuardInstruction)localObject2).type.get() == 2)
          {
            localObject2 = new betq((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 3)
          {
            localObject2 = new bets((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 6)
          {
            localObject2 = new beto((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else if (((INTERFACE.GuardInstruction)localObject2).type.get() == 7)
          {
            localObject2 = new betv((INTERFACE.GuardInstruction)localObject2, paramContext, paramMiniAppInfo);
          }
          else
          {
            besl.c("GameGrowthGuardianManager", "tryBuildAndShow not create and show dialog for " + ((INTERFACE.GuardInstruction)localObject2).type.get());
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
  
  protected betj a()
  {
    return null;
  }
  
  public MiniAppInfo a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  }
  
  void a()
  {
    if ((a() == null) || (a() == null)) {
      return;
    }
    bemn localbemn = bekm.a(a(), 230).a(a().title.get()).a(a().msg.get());
    if (a() != null) {
      localbemn.b(a().a(), a().a());
    }
    if (b() != null) {
      localbemn.a(b().a(), b().a());
    }
    localbemn.setOnShowListener(new betm(this));
    localbemn.setOnDismissListener(new betn(this));
    localbemn.setCancelable(false);
    localbemn.show();
  }
  
  public void a(INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp)
  {
    this.jdField_a_of_type_NS_MINI_INTERFACEINTERFACE$StJudgeTimingRsp = paramStJudgeTimingRsp;
  }
  
  public void a(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = paramOnDismissListener;
  }
  
  protected betj b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     betk
 * JD-Core Version:    0.7.0.1
 */