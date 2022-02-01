import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
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
public final class atac
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
        if (!(localObject instanceof aimd)) {
          break label96;
        }
        ataa localataa = (ataa)((BaseChatPie)localObject).a(77);
        if (localataa != null)
        {
          QQAppInterface localQQAppInterface = ((FragmentActivity)paramContext).app;
          Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "context.app");
          localataa.a(localQQAppInterface, paramContext, ((BaseChatPie)localObject).a.jdField_a_of_type_Int, ((BaseChatPie)localObject).a.jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      return;
      label96:
      paramContext = QQToast.a(paramContext, (CharSequence)paramContext.getResources().getString(2131697994), 1);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "baseChatPie");
      paramContext.b(((BaseChatPie)localObject).a());
    }
  }
  
  @JvmStatic
  public final void a(@NotNull atay paramatay)
  {
    Intrinsics.checkParameterIsNotNull(paramatay, "iBanish");
    paramatay = paramatay.a();
    if (paramatay != null) {
      paramatay.dismiss();
    }
    bdll.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 2, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull atay paramatay)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramatay, "iBanish");
    paramatay = paramatay.a();
    if (paramatay != null) {
      paramatay.dismiss();
    }
    aber.a((BaseActivity)paramActivity, paramInt, paramString, paramQQAppInterface.getCurrentAccountUin(), "");
    bdll.b(null, "dc00898", "", "", "0X800B2D0", "0X800B2D0", 1, 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull atay paramatay)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramatay, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    Object localObject = paramatay.a();
    if (localObject != null) {
      ((Dialog)localObject).dismiss();
    }
    localObject = atce.a.a(paramQQAppInterface);
    paramatay.a((Dialog)new atdb(paramContext, paramQQAppInterface, paramString, paramInt));
    paramQQAppInterface = paramatay.a();
    if (paramQQAppInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.wiget.ColdPalaceTipDialog");
    }
    ((atdb)paramQQAppInterface).a(((atce)localObject).a(0));
    bdll.b(null, "dc00898", "", "", "0X800B2C6", "0X800B2C6", paramatay.a(), 0, "", "", "", "");
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, @NotNull atay paramatay)
  {
    Intrinsics.checkParameterIsNotNull(paramatay, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    paramQQAppInterface = atce.a.a(paramQQAppInterface);
    String str = paramQQAppInterface.a(1);
    if ((paramContext instanceof ChatSettingActivity)) {
      QQToast.a(paramContext, (CharSequence)str, 1).a();
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800B2CA", "0X800B2CA", paramatay.a(), 0, "", "", "", "");
      return;
      Dialog localDialog = paramatay.a();
      if (localDialog != null) {
        localDialog.dismiss();
      }
      paramatay.a((Dialog)bhlq.a(paramContext, 230, str, paramQQAppInterface.a(2), 2131690580, 2131697991, (DialogInterface.OnClickListener)new atad(paramatay), (DialogInterface.OnClickListener)new atae(paramatay)));
      paramQQAppInterface = paramatay.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.show();
      }
    }
  }
  
  @JvmStatic
  public final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull atay paramatay)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramatay, "iBanish");
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
      paramatay = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramatay, "BaseApplicationImpl.getContext()");
      QQToast.a(paramQQAppInterface, 2, (CharSequence)paramatay.getResources().getString(2131697999), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
      ((BaseActivity)paramContext).finish();
      bdll.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 1, 0, "", "", "", "");
    }
    while (paramBoolean1)
    {
      QLog.d("AioLimitColdPalaceHelper", 1, "doOnReqThrowToColdPalace suc=" + paramBoolean1 + " uinType=" + paramInt + " uin=" + MobileQQ.getShortUinStr(paramString));
      return;
    }
    if (paramBoolean2) {
      ((atac)this).a(paramQQAppInterface, paramContext, paramatay);
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800B2C8", "0X800B2C8", 2, 0, "", "", "", "");
      break;
      paramQQAppInterface = (Context)BaseApplicationImpl.getContext();
      paramatay = BaseApplicationImpl.getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramatay, "BaseApplicationImpl.getContext()");
      QQToast.a(paramQQAppInterface, 1, (CharSequence)paramatay.getResources().getString(2131697998), 1).b(((BaseActivity)paramContext).getTitleBarHeight());
    }
  }
  
  @JvmStatic
  public final void b(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull atay paramatay)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "frdUin");
    Intrinsics.checkParameterIsNotNull(paramatay, "iBanish");
    if ((!(paramContext instanceof Activity)) || (((Activity)paramContext).isFinishing()) || (paramQQAppInterface == null)) {
      return;
    }
    atce localatce = atce.a.a(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnBanishColdPalaceClick skillTimesLeft:" + localatce.a() + " from:" + paramatay.a());
    }
    if ((localatce.a() > 0) || (localatce.a() == -2147483648)) {
      ((atac)this).a(paramQQAppInterface, paramContext, paramInt, paramString, paramatay);
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800B2C4", "0X800B2C4", paramatay.a(), 0, "", "", "", "");
      return;
      ((atac)this).a(paramQQAppInterface, paramContext, paramatay);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atac
 * JD-Core Version:    0.7.0.1
 */