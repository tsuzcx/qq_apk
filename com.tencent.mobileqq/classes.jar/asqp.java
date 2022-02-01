import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/limitchat/AioLimitColdPalaceHelper$Companion;", "", "()V", "LIMIT_CHAT_LIMIT", "", "TAG", "doOnBanishColdPalaceClick", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "context", "Landroid/content/Context;", "uinType", "", "frdUin", "iBanish", "Lcom/tencent/mobileqq/extendfriend/limitchat/IColdPalaceBanish;", "doOnColdPalaceLimitCancel", "doOnColdPalaceLimitConfirm", "activity", "Landroid/app/Activity;", "doOnReqThrowToColdPalace", "suc", "", "uin", "isUsedUp", "doOnShowBanishColdPalaceTipDialog", "doOnShowColdPalaceLimitTip", "onBanishColdPalaceGrayTipClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class asqp
{
  @JvmStatic
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject;
    if ((paramContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)paramContext).getChatFragment();
      if ((localObject != null) && (((ChatFragment)localObject).a() != null))
      {
        localObject = ((ChatFragment)localObject).a();
        if (!(localObject instanceof aici)) {
          break label96;
        }
        asqn localasqn = (asqn)((BaseChatPie)localObject).getHelper(77);
        if (localasqn != null)
        {
          QQAppInterface localQQAppInterface = ((FragmentActivity)paramContext).app;
          Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "context.app");
          localasqn.a(localQQAppInterface, paramContext, ((BaseChatPie)localObject).sessionInfo.curType, ((BaseChatPie)localObject).sessionInfo.curFriendUin);
        }
      }
    }
    for (;;)
    {
      return;
      label96:
      paramContext = QQToast.a(paramContext, (CharSequence)paramContext.getResources().getString(2131698437), 1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "baseChatPie");
      paramContext.b(((BaseChatPie)localObject).getTitleBarHeight());
    }
  }
  
  @JvmStatic
  public final void a(@NotNull asrm paramasrm)
  {
    Intrinsics.checkParameterIsNotNull(paramasrm, "iBanish");
    paramasrm = paramasrm.a();
    if (paramasrm != null) {
      paramasrm.dismiss();
    }
    bdla.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 2, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull asrm paramasrm)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramasrm, "iBanish");
    paramasrm = paramasrm.a();
    if (paramasrm != null) {
      paramasrm.dismiss();
    }
    aaqo.a((BaseActivity)paramActivity, paramInt, paramString, paramQQAppInterface.getCurrentAccountUin(), "");
    bdla.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 1, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull asrm paramasrm)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramasrm, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    Object localObject = paramasrm.a();
    if (localObject != null) {
      ((Dialog)localObject).dismiss();
    }
    localObject = asss.a.a(paramQQAppInterface);
    paramasrm.a((Dialog)new astp(paramContext, paramQQAppInterface, paramString, paramInt));
    paramQQAppInterface = paramasrm.a();
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.wiget.ColdPalaceTipDialog");
    }
    ((astp)paramQQAppInterface).a(((asss)localObject).a(0));
    bdla.b(null, "dc00898", "", "", "0X800B2C6", "0X800B2C6", paramasrm.a(), 0, "", "", "", "");
    paramQQAppInterface = new HashMap();
    ((Map)paramQQAppInterface).put("frompage", String.valueOf(paramasrm.a()));
    ((Map)paramQQAppInterface).put("to_uid", paramString);
    UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#doghouse_page#doghouse", true, -1L, -1L, (Map)paramQQAppInterface, true, true);
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, @NotNull asrm paramasrm)
  {
    Intrinsics.checkParameterIsNotNull(paramasrm, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    paramQQAppInterface = asss.a.a(paramQQAppInterface);
    String str = paramQQAppInterface.a(1);
    if ((paramContext instanceof ChatSettingActivity)) {
      QQToast.a(paramContext, (CharSequence)str, 1).a();
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800B2CA", "0X800B2CA", paramasrm.a(), 0, "", "", "", "");
      return;
      Dialog localDialog = paramasrm.a();
      if (localDialog != null) {
        localDialog.dismiss();
      }
      paramasrm.a((Dialog)bhdj.a(paramContext, 230, str, paramQQAppInterface.a(2), 2131690697, 2131698434, (DialogInterface.OnClickListener)new asqq(paramasrm), (DialogInterface.OnClickListener)new asqr(paramasrm)));
      paramQQAppInterface = paramasrm.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.show();
      }
    }
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull asrm paramasrm)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramasrm, "iBanish");
    if ((!(paramQQAppInterface instanceof QQAppInterface)) || (!(paramContext instanceof BaseActivity))) {
      return;
    }
    if ((paramBoolean1) && ((Intrinsics.areEqual(BaseActivity.sTopActivity, paramContext) ^ true)))
    {
      ((BaseActivity)paramContext).finish();
      return;
    }
    if (paramBoolean1)
    {
      paramQQAppInterface = (Context)BaseApplicationImpl.getContext();
      paramasrm = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramasrm, "BaseApplicationImpl.getContext()");
      QQToast.a(paramQQAppInterface, 2, (CharSequence)paramasrm.getResources().getString(2131698442), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
      ((BaseActivity)paramContext).finish();
      bdla.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 1, 0, "", "", "", "");
    }
    while (paramBoolean1)
    {
      QLog.d("AioLimitColdPalaceHelper", 1, "doOnReqThrowToColdPalace suc=" + paramBoolean1 + " uinType=" + paramInt + " uin=" + MobileQQ.getShortUinStr(paramString));
      return;
    }
    if (paramBoolean2) {
      ((asqp)this).a(paramQQAppInterface, paramContext, paramasrm);
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 2, 0, "", "", "", "");
      break;
      paramQQAppInterface = (Context)BaseApplicationImpl.getContext();
      paramasrm = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramasrm, "BaseApplicationImpl.getContext()");
      QQToast.a(paramQQAppInterface, 1, (CharSequence)paramasrm.getResources().getString(2131698441), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
    }
  }
  
  @JvmStatic
  public final void b(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull asrm paramasrm)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramasrm, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    asss localasss = asss.a.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnBanishColdPalaceClick skillTimesLeft:" + localasss.a() + " from:" + paramasrm.a());
    }
    if ((localasss.a() > 0) || (localasss.a() == -2147483648)) {
      ((asqp)this).a(paramQQAppInterface, paramContext, paramInt, paramString, paramasrm);
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800B2C4", "0X800B2C4", paramasrm.a(), 0, "", "", "", "");
      return;
      ((asqp)this).a(paramQQAppInterface, paramContext, paramasrm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqp
 * JD-Core Version:    0.7.0.1
 */