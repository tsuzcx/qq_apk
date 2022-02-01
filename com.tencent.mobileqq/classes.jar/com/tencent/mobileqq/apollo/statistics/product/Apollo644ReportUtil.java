package com.tencent.mobileqq.apollo.statistics.product;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/Apollo644ReportUtil;", "", "()V", "ACTION_NEW_CLIK", "", "ACTION_REV", "ACTION_REV_BQ", "TAG", "reportApolloMsgClick", "", "context", "Landroid/content/Context;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "sessionInfo", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "holder", "Lcom/tencent/mobileqq/apollo/aio/item/ApolloItemBuilder$Holder;", "reportApolloRevAction", "Lmqq/app/AppRuntime;", "apollo", "Lcom/tencent/mobileqq/apollo/model/MessageForApollo;", "apolloManager", "Lcom/tencent/mobileqq/apollo/api/IApolloManagerService;", "reportApolloRevTroopMsg", "uMessageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportDeviceInfoTo644", "luaStatus", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class Apollo644ReportUtil
{
  public static final Apollo644ReportUtil a = new Apollo644ReportUtil();
  
  @JvmStatic
  public static final void a(long paramLong, @Nullable GL10 paramGL10)
  {
    if (paramGL10 == null) {
      return;
    }
    int i = CmGameUtil.c(paramLong);
    if (-1 == i) {
      return;
    }
    String str1 = paramGL10.glGetString(7936);
    String str2 = paramGL10.glGetString(7937);
    ThreadManager.post((Runnable)new Apollo644ReportUtil.reportDeviceInfoTo644.1(str1, paramGL10.glGetString(7938), str2, i), 5, null, true);
  }
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext, @NotNull QQAppInterface paramQQAppInterface, @NotNull SessionInfo paramSessionInfo, @NotNull ApolloItemBuilder.Holder paramHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramSessionInfo, "sessionInfo");
    Intrinsics.checkParameterIsNotNull(paramHolder, "holder");
    paramContext = (BaseActivity)paramContext;
    if (paramContext.getChatFragment() == null) {
      return;
    }
    paramContext = paramContext.getChatFragment();
    if (paramContext == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "(context as BaseActivity).chatFragment!!");
    paramContext = paramContext.k();
    if (paramContext != null) {
      VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "new_clk_action", paramSessionInfo.b, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramContext.F()), ((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramQQAppInterface.getCurrentUin(), (AppRuntime)paramQQAppInterface), new String[] { String.valueOf(paramHolder.a), "", "", String.valueOf(System.currentTimeMillis() / 1000) });
    }
  }
  
  @JvmStatic
  public static final void a(@NotNull AppRuntime paramAppRuntime, @NotNull MessageForApollo paramMessageForApollo, @NotNull IApolloManagerService paramIApolloManagerService)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "apollo");
    Intrinsics.checkParameterIsNotNull(paramIApolloManagerService, "apolloManager");
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    int i = paramIApolloManagerService.getApolloStatus(paramAppRuntime.getCurrentUin());
    int j = paramMessageForApollo.msgType;
    Object localObject = "";
    if (j == 0)
    {
      localObject = String.valueOf(paramMessageForApollo.mApolloMessage.id);
    }
    else if (paramMessageForApollo.msgType == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramMessageForApollo.gameId);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramAppRuntime = (AppInterface)paramAppRuntime;
    VipUtils.a(paramAppRuntime, "cmshow", "Apollo", "rev_action", String.valueOf(paramMessageForApollo.mApolloMessage.peerUin), 0, paramMessageForApollo.msgType, new String[] { localObject, Integer.toString(i), Integer.toString(paramIApolloManagerService.getWhiteListStatus()), String.valueOf(System.currentTimeMillis() / 1000) });
    if (paramMessageForApollo.msgType == 10)
    {
      i = paramMessageForApollo.mApolloMessage.flag;
      VipUtils.a(paramAppRuntime, "cmshow", "Apollo", "y_rev_bq", "", 0, paramMessageForApollo.msgType, new String[] { String.valueOf(i >> 2 & 0x1), localObject, String.valueOf(paramMessageForApollo.mApolloMessage.peerUin) });
    }
  }
  
  @JvmStatic
  public static final void a(@NotNull AppRuntime paramAppRuntime, @NotNull MessageRecord paramMessageRecord, @NotNull MessageForApollo paramMessageForApollo, @NotNull IApolloManagerService paramIApolloManagerService)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "app");
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "uMessageRecord");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "apollo");
    Intrinsics.checkParameterIsNotNull(paramIApolloManagerService, "apolloManager");
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    int k = paramIApolloManagerService.getApolloStatus(paramAppRuntime.getCurrentUin());
    String str;
    if (paramMessageForApollo.msgType == 0) {
      str = String.valueOf(paramMessageForApollo.mApolloMessage.id);
    } else {
      str = "";
    }
    int i;
    if (paramMessageRecord.istroop == 1) {
      i = 1;
    } else {
      i = 2;
    }
    HotChatManager localHotChatManager = ((QQAppInterface)paramAppRuntime).getHotChatMng(false);
    Intrinsics.checkExpressionValueIsNotNull(localHotChatManager, "app.getHotChatMng(false)");
    int j = i;
    if (localHotChatManager != null)
    {
      j = i;
      if (localHotChatManager.b(paramMessageRecord.frienduin)) {
        j = 3;
      }
    }
    paramAppRuntime = (AppInterface)paramAppRuntime;
    VipUtils.a(paramAppRuntime, "cmshow", "Apollo", "rev_action", paramMessageRecord.senderuin.toString(), j, paramMessageForApollo.msgType, new String[] { str, Integer.toString(k), Integer.toString(paramIApolloManagerService.getWhiteListStatus()), String.valueOf(System.currentTimeMillis() / 1000) });
    if (paramMessageForApollo.msgType == 10)
    {
      i = paramMessageForApollo.mApolloMessage.flag;
      VipUtils.a(paramAppRuntime, "cmshow", "Apollo", "y_rev_bq", "", j, paramMessageForApollo.msgType, new String[] { String.valueOf(i >> 2 & 0x1), str, paramMessageRecord.senderuin.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.Apollo644ReportUtil
 * JD-Core Version:    0.7.0.1
 */