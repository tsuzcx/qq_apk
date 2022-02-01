import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
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
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/limitchat/AioLimitColdPalaceHelper$Companion;", "", "()V", "LIMIT_CHAT_LIMIT", "", "TAG", "doOnBanishColdPalaceClick", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "context", "Landroid/content/Context;", "uinType", "", "frdUin", "iBanish", "Lcom/tencent/mobileqq/extendfriend/limitchat/IColdPalaceBanish;", "doOnColdPalaceLimitCancel", "doOnColdPalaceLimitConfirm", "activity", "Landroid/app/Activity;", "doOnReqThrowToColdPalace", "suc", "", "uin", "isUsedUp", "doOnShowBanishColdPalaceTipDialog", "doOnShowColdPalaceLimitTip", "onBanishColdPalaceGrayTipClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class armj
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
        if (!(localObject instanceof ahhp)) {
          break label96;
        }
        armh localarmh = (armh)((BaseChatPie)localObject).getHelper(77);
        if (localarmh != null)
        {
          QQAppInterface localQQAppInterface = ((FragmentActivity)paramContext).app;
          Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "context.app");
          localarmh.a(localQQAppInterface, paramContext, ((BaseChatPie)localObject).sessionInfo.curType, ((BaseChatPie)localObject).sessionInfo.curFriendUin);
        }
      }
    }
    for (;;)
    {
      return;
      label96:
      paramContext = QQToast.a(paramContext, (CharSequence)paramContext.getResources().getString(2131698151), 1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "baseChatPie");
      paramContext.b(((BaseChatPie)localObject).getTitleBarHeight());
    }
  }
  
  @JvmStatic
  public final void a(@NotNull arng paramarng)
  {
    Intrinsics.checkParameterIsNotNull(paramarng, "iBanish");
    paramarng = paramarng.a();
    if (paramarng != null) {
      paramarng.dismiss();
    }
    bcef.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 2, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull arng paramarng)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramarng, "iBanish");
    paramarng = paramarng.a();
    if (paramarng != null) {
      paramarng.dismiss();
    }
    aabc.a((BaseActivity)paramActivity, paramInt, paramString, paramQQAppInterface.getCurrentAccountUin(), "");
    bcef.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 1, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull arng paramarng)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramarng, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    Object localObject = paramarng.a();
    if (localObject != null) {
      ((Dialog)localObject).dismiss();
    }
    localObject = arom.a.a(paramQQAppInterface);
    paramarng.a((Dialog)new arpj(paramContext, paramQQAppInterface, paramString, paramInt));
    paramQQAppInterface = paramarng.a();
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.wiget.ColdPalaceTipDialog");
    }
    ((arpj)paramQQAppInterface).a(((arom)localObject).a(0));
    bcef.b(null, "dc00898", "", "", "0X800B2C6", "0X800B2C6", paramarng.a(), 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, @NotNull arng paramarng)
  {
    Intrinsics.checkParameterIsNotNull(paramarng, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    paramQQAppInterface = arom.a.a(paramQQAppInterface);
    String str = paramQQAppInterface.a(1);
    if ((paramContext instanceof ChatSettingActivity)) {
      QQToast.a(paramContext, (CharSequence)str, 1).a();
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800B2CA", "0X800B2CA", paramarng.a(), 0, "", "", "", "");
      return;
      Dialog localDialog = paramarng.a();
      if (localDialog != null) {
        localDialog.dismiss();
      }
      paramarng.a((Dialog)bfur.a(paramContext, 230, str, paramQQAppInterface.a(2), 2131690620, 2131698148, (DialogInterface.OnClickListener)new armk(paramarng), (DialogInterface.OnClickListener)new arml(paramarng)));
      paramQQAppInterface = paramarng.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.show();
      }
    }
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull arng paramarng)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramarng, "iBanish");
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
      paramarng = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramarng, "BaseApplicationImpl.getContext()");
      QQToast.a(paramQQAppInterface, 2, (CharSequence)paramarng.getResources().getString(2131698156), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
      ((BaseActivity)paramContext).finish();
      bcef.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 1, 0, "", "", "", "");
    }
    while (paramBoolean1)
    {
      QLog.d("AioLimitColdPalaceHelper", 1, "doOnReqThrowToColdPalace suc=" + paramBoolean1 + " uinType=" + paramInt + " uin=" + MobileQQ.getShortUinStr(paramString));
      return;
    }
    if (paramBoolean2) {
      ((armj)this).a(paramQQAppInterface, paramContext, paramarng);
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 2, 0, "", "", "", "");
      break;
      paramQQAppInterface = (Context)BaseApplicationImpl.getContext();
      paramarng = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramarng, "BaseApplicationImpl.getContext()");
      QQToast.a(paramQQAppInterface, 1, (CharSequence)paramarng.getResources().getString(2131698155), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
    }
  }
  
  @JvmStatic
  public final void b(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull arng paramarng)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramarng, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    arom localarom = arom.a.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnBanishColdPalaceClick skillTimesLeft:" + localarom.a() + " from:" + paramarng.a());
    }
    if ((localarom.a() > 0) || (localarom.a() == -2147483648)) {
      ((armj)this).a(paramQQAppInterface, paramContext, paramInt, paramString, paramarng);
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800B2C4", "0X800B2C4", paramarng.a(), 0, "", "", "", "");
      return;
      ((armj)this).a(paramQQAppInterface, paramContext, paramarng);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armj
 * JD-Core Version:    0.7.0.1
 */