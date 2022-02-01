package com.tencent.mobileqq.apollo.statistics.product;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.Holder;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloActionHelper;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/Apollo644ReportUtil;", "", "()V", "ACTION_NEW_CLIK", "", "ACTION_REV", "ACTION_REV_BQ", "TAG", "reportApolloMsgClick", "", "context", "Landroid/content/Context;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "sessionInfo", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "holder", "Lcom/tencent/mobileqq/apollo/api/aio/item/impl/ApolloItemBuilder$Holder;", "reportApolloRevAction", "apollo", "Lcom/tencent/mobileqq/apollo/api/model/MessageForApollo;", "apolloManager", "Lcom/tencent/mobileqq/apollo/api/IApolloManagerService;", "reportApolloRevTroopMsg", "uMessageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "reportDeviceInfoTo644", "luaStatus", "", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class Apollo644ReportUtil
{
  public static final Apollo644ReportUtil a = new Apollo644ReportUtil();
  
  @JvmStatic
  public static final void a(long paramLong, @Nullable GL10 paramGL10)
  {
    if (paramGL10 == null) {}
    int i;
    do
    {
      return;
      i = CmGameUtil.a(paramLong);
    } while (-1 == i);
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
    if (((FragmentActivity)paramContext).getChatFragment() == null) {}
    do
    {
      return;
      paramContext = ((FragmentActivity)paramContext).getChatFragment();
      if (paramContext == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "(context as FragmentActivity).chatFragment!!");
      paramContext = paramContext.a();
    } while (paramContext == null);
    VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "new_clk_action", paramSessionInfo.a, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(paramContext.b()), ((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(paramQQAppInterface.getCurrentUin(), paramQQAppInterface), new String[] { String.valueOf(paramHolder.e), "", "", String.valueOf(System.currentTimeMillis() / 1000) });
  }
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull MessageForApollo paramMessageForApollo, @NotNull IApolloManagerService paramIApolloManagerService)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "apollo");
    Intrinsics.checkParameterIsNotNull(paramIApolloManagerService, "apolloManager");
    int i = paramIApolloManagerService.getApolloStatus(paramQQAppInterface.getCurrentUin());
    String str;
    if (paramMessageForApollo.msgType == 0) {
      str = String.valueOf(paramMessageForApollo.mApolloMessage.id);
    }
    for (;;)
    {
      VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(paramMessageForApollo.mApolloMessage.peer_uin), 0, paramMessageForApollo.msgType, new String[] { str, Integer.toString(i), Integer.toString(paramIApolloManagerService.getWhiteListStatus((AppRuntime)paramQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000) });
      if (paramMessageForApollo.msgType == 10)
      {
        i = paramMessageForApollo.mApolloMessage.flag;
        VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "y_rev_bq", "", 0, paramMessageForApollo.msgType, new String[] { String.valueOf(i >> 2 & 0x1), str, String.valueOf(paramMessageForApollo.mApolloMessage.peer_uin) });
      }
      return;
      if (paramMessageForApollo.msgType == 2) {
        str = "" + paramMessageForApollo.gameId;
      } else {
        str = "";
      }
    }
  }
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull MessageRecord paramMessageRecord, @NotNull MessageForApollo paramMessageForApollo, @NotNull IApolloManagerService paramIApolloManagerService)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "uMessageRecord");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "apollo");
    Intrinsics.checkParameterIsNotNull(paramIApolloManagerService, "apolloManager");
    int j = paramIApolloManagerService.getApolloStatus(paramQQAppInterface.getCurrentUin());
    String str;
    if (paramMessageForApollo.msgType == 0) {
      str = String.valueOf(paramMessageForApollo.mApolloMessage.id);
    }
    for (;;)
    {
      int i;
      if (paramMessageRecord.istroop == 1)
      {
        i = 1;
        label66:
        HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(false);
        Intrinsics.checkExpressionValueIsNotNull(localHotChatManager, "app.getHotChatMng(false)");
        if ((localHotChatManager == null) || (!localHotChatManager.b(paramMessageRecord.frienduin))) {
          break label287;
        }
        i = 3;
      }
      label287:
      for (;;)
      {
        VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "rev_action", paramMessageRecord.senderuin.toString(), i, paramMessageForApollo.msgType, new String[] { str, Integer.toString(j), Integer.toString(paramIApolloManagerService.getWhiteListStatus((AppRuntime)paramQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000) });
        if (paramMessageForApollo.msgType == 10)
        {
          j = paramMessageForApollo.mApolloMessage.flag;
          VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "y_rev_bq", "", i, paramMessageForApollo.msgType, new String[] { String.valueOf(j >> 2 & 0x1), str, paramMessageRecord.senderuin.toString() });
        }
        return;
        if (!ApolloGameUtil.a(paramMessageForApollo.msgType)) {
          break label290;
        }
        str = "" + paramMessageForApollo.gameId;
        break;
        i = 2;
        break label66;
      }
      label290:
      str = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.Apollo644ReportUtil
 * JD-Core Version:    0.7.0.1
 */