import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper.addBanishColdPalaceGrayTip.1;
import com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper.doOnShowFirst.1;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/limitchat/AioLimitColdPalaceHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/ILifeCycleHelper;", "Lcom/tencent/mobileqq/extendfriend/limitchat/IColdPalaceBanish;", "Lcom/tencent/mobileqq/extendfriend/ExtendFriendObserver;", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "(Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "getMActivity", "()Lcom/tencent/mobileqq/app/BaseActivity;", "setMActivity", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "mApp", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getMApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "mChatPie", "getMChatPie", "()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "mColdPalaceGrayTipPosition", "", "getMColdPalaceGrayTipPosition", "()I", "setMColdPalaceGrayTipPosition", "(I)V", "mHasInitInsertColdPalaceGrayTip", "", "getMHasInitInsertColdPalaceGrayTip", "()Z", "setMHasInitInsertColdPalaceGrayTip", "(Z)V", "mHasInitLimitMatchFriendMsgCount", "getMHasInitLimitMatchFriendMsgCount", "setMHasInitLimitMatchFriendMsgCount", "mHasInsertColdPalaceGrayTip", "getMHasInsertColdPalaceGrayTip", "setMHasInsertColdPalaceGrayTip", "mLimitMatchFriendMsgCount", "getMLimitMatchFriendMsgCount", "setMLimitMatchFriendMsgCount", "mMsgObserver", "Lcom/tencent/mobileqq/app/MessageObserver;", "getMMsgObserver", "()Lcom/tencent/mobileqq/app/MessageObserver;", "mTipsDialog", "Landroid/app/Dialog;", "getMTipsDialog", "()Landroid/app/Dialog;", "setMTipsDialog", "(Landroid/app/Dialog;)V", "addBanishColdPalaceGrayTip", "", "doOnCreate", "doOnDestroy", "doOnShowFirst", "from", "getMsgTypeShouldNotInclude", "", "getTag", "getTipsDialog", "initHasInsertColdPalaceGrayTip", "initLimitMatchFriendMsgCount", "peerUin", "type", "interestedIn", "", "onBanishColdPalaceClick", "app", "context", "Landroid/content/Context;", "uinType", "uin", "onColdPalaceLimitCancel", "onColdPalaceLimitConfirm", "onMoveToState", "state", "onReqThrowToColdPalace", "suc", "isUsedUp", "preloadColdPalacePic", "setTipsDialog", "dialog", "shouldShowGrayTipEntry", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class asqn
  extends aslz
  implements agin, asrm
{
  public static final asqp a;
  private volatile int jdField_a_of_type_Int;
  @Nullable
  private Dialog jdField_a_of_type_AndroidAppDialog;
  @NotNull
  private final anyz jdField_a_of_type_Anyz;
  @NotNull
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  @NotNull
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  
  static
  {
    jdField_a_of_type_Asqp = new asqp(null);
  }
  
  public asqn(@NotNull BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "chatPie.app");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
    paramBaseChatPie = paramBaseChatPie.getActivity();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseChatPie, "chatPie.activity");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie;
    this.c = true;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_Anyz = ((anyz)new asqo(this));
  }
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext)
  {
    jdField_a_of_type_Asqp.a(paramContext);
  }
  
  @JvmStatic
  public static final void a(@NotNull asrm paramasrm)
  {
    jdField_a_of_type_Asqp.a(paramasrm);
  }
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull asrm paramasrm)
  {
    jdField_a_of_type_Asqp.a(paramQQAppInterface, paramActivity, paramInt, paramString, paramasrm);
  }
  
  @JvmStatic
  public static final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull asrm paramasrm)
  {
    jdField_a_of_type_Asqp.b(paramQQAppInterface, paramContext, paramInt, paramString, paramasrm);
  }
  
  @JvmStatic
  public static final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull asrm paramasrm)
  {
    jdField_a_of_type_Asqp.a(paramQQAppInterface, paramContext, paramBoolean1, paramInt, paramString, paramBoolean2, paramasrm);
  }
  
  private final void a(String paramString, int paramInt)
  {
    Object localObject1 = (asqn)this;
    String str = ((asqn)localObject1).a();
    localObject1 = ((asqn)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    Object localObject2 = StringCompanionObject.INSTANCE;
    localObject2 = new Object[2];
    localObject2[0] = Long.valueOf(9223372036854775807L);
    localObject2[1] = str;
    str = String.format("time < %d and issend = 0 and msgtype %s", Arrays.copyOf((Object[])localObject2, localObject2.length));
    Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
    paramString = ((EntityManager)localObject1).query(MessageRecord.class, MessageRecord.getTableName(paramString, paramInt), false, str, null, null, null, null, "20");
    if (paramString != null) {}
    for (;;)
    {
      this.jdField_a_of_type_Int = paramString.size();
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("AioLimitColdPalaceHelper", 2, "initLimitMatchFriendMsgCount: mHasInsertColdPalaceGrayTip = " + this.c + " mLimitMatchFriendMsgCount = " + this.jdField_a_of_type_Int + " mHasInitInsertGrayTip = " + this.jdField_b_of_type_Boolean + " mColdPalaceGrayTipPosition = " + this.jdField_b_of_type_Int);
      }
      if ((this.jdField_b_of_type_Boolean) && (!this.c) && (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int)) {
        f();
      }
      return;
      paramString = (List)new ArrayList();
    }
  }
  
  private final boolean c()
  {
    return (this.jdField_b_of_type_Int > 0) && (asss.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a());
  }
  
  private final void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "initHasInsertColdPalaceGrayTip");
    }
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((SessionInfo)localObject2).curFriendUin;
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo;
        if (localSessionInfo == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((QQMessageFacade)localObject1).getAllMessages((String)localObject2, localSessionInfo.curType, new int[] { -5020 });
        this.c = false;
        if (localObject1 == null) {
          break label225;
        }
        i = ((List)localObject1).size();
        label121:
        if (i > 0) {
          break label230;
        }
        this.c = false;
        label129:
        break label244;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("AioLimitColdPalaceHelper", 2, "initHasInsertColdPalaceGrayTip: mHasInsertColdPalaceGrayTip = " + this.c + " mLimitMatchFriendMsgCount = " + this.jdField_a_of_type_Int + " mColdPalaceGrayTipPosition = " + this.jdField_b_of_type_Int);
      }
      if ((!this.c) && (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int)) {
        f();
      }
      return;
      localObject1 = null;
      break;
      label225:
      i = 0;
      break label121;
      label230:
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((List)localObject1).iterator();
      label244:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((!(localObject2 instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)localObject2).tipParam.jdField_b_of_type_Int != 459802)) {
          break label129;
        }
        this.c = true;
        continue;
        this.c = true;
      }
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  @Nullable
  public Dialog a()
  {
    return this.jdField_a_of_type_AndroidAppDialog;
  }
  
  @NotNull
  public final BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  }
  
  @NotNull
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  @NotNull
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  @Nullable
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(acnh.h.length * 8);
    localStringBuilder.append("not in (");
    int i = 0;
    int[] arrayOfInt = acnh.h;
    Intrinsics.checkExpressionValueIsNotNull(arrayOfInt, "MsgProxyUtils.MSGTYPE_HISTORY_INVISIBLE");
    int j = arrayOfInt.length;
    while (i < j)
    {
      localStringBuilder.append(acnh.h[i]);
      localStringBuilder.append(",");
      i += 1;
    }
    localStringBuilder.append(-5020);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnCreate");
    }
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.ExtendFriendManager");
    }
    this.jdField_b_of_type_Int = ((aslo)localManager).f();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this.jdField_a_of_type_Anyz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      a();
      return;
    case 8: 
      b();
      return;
    }
    e();
  }
  
  public void a(@Nullable Dialog paramDialog)
  {
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
  }
  
  public void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Context paramContext, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    asqp localasqp = jdField_a_of_type_Asqp;
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    localasqp.b(paramQQAppInterface, paramContext, paramInt, paramString, (asrm)this);
  }
  
  protected void a(boolean paramBoolean1, @NotNull String paramString, int paramInt, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if (StringsKt.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, true)) {
      jdField_a_of_type_Asqp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramBoolean1, paramInt, paramString, paramBoolean2, (asrm)this);
    }
  }
  
  public final boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  @NotNull
  public int[] a()
  {
    return new int[] { 4, 8, 14 };
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnShowFirst mColdPalaceGrayTipPosition = " + this.jdField_b_of_type_Int);
    }
    if (!c()) {
      return;
    }
    ThreadManager.executeOnSubThread((Runnable)new AioLimitColdPalaceHelper.doOnShowFirst.1(this));
  }
  
  public final void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final boolean b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    asqp localasqp = jdField_a_of_type_Asqp;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      Intrinsics.throwNpe();
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    Intrinsics.checkExpressionValueIsNotNull(str, "mChatPie.sessionInfo.curFriendUin");
    localasqp.a(localQQAppInterface, localActivity, i, str, (asrm)this);
  }
  
  public void d()
  {
    jdField_a_of_type_Asqp.a((asrm)this);
  }
  
  public final void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnDestroy");
    }
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      localDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this.jdField_a_of_type_Anyz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this);
  }
  
  public final void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "addBanishColdPalaceGrayTip: " + this.c);
    }
    if (!this.c)
    {
      this.c = true;
      ThreadManager.executeOnSubThread((Runnable)new AioLimitColdPalaceHelper.addBanishColdPalaceGrayTip.1(this));
    }
  }
  
  public final void g()
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://downv6.qq.com/qq_relation/cold_palace/aio_limit_chat_cold_palace.png", null);
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawable, "URLDrawable.getDrawable(…D_PALACE_IMAGE_URL, null)");
    if (1 != localURLDrawable.getStatus())
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqn
 * JD-Core Version:    0.7.0.1
 */