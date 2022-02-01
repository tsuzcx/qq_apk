import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/Apollo644ReportUtil;", "", "()V", "REV_ACTION", "", "REV_BQ_ACTION", "TAG", "reportApolloRevAction", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "apollo", "Lcom/tencent/mobileqq/data/MessageForApollo;", "apolloManager", "Lcom/tencent/mobileqq/apollo/ApolloManager;", "reportApolloRevTroopMsg", "uMessageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anjt
{
  public static final anjt a = new anjt();
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull MessageForApollo paramMessageForApollo, @NotNull amme paramamme)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "apollo");
    Intrinsics.checkParameterIsNotNull(paramamme, "apolloManager");
    int i = paramamme.b(paramQQAppInterface.getCurrentUin());
    if (paramMessageForApollo.msgType == 0) {
      paramamme = String.valueOf(paramMessageForApollo.mApolloMessage.id);
    }
    for (;;)
    {
      VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "rev_action", String.valueOf(paramMessageForApollo.mApolloMessage.peer_uin), 0, paramMessageForApollo.msgType, new String[] { paramamme, Integer.toString(i), Integer.toString(amme.a((AppInterface)paramQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000) });
      if (paramMessageForApollo.msgType == 10)
      {
        i = paramMessageForApollo.mApolloMessage.flag;
        VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "y_rev_bq", "", 0, paramMessageForApollo.msgType, new String[] { String.valueOf(i >> 2 & 0x1), paramamme, String.valueOf(paramMessageForApollo.mApolloMessage.peer_uin) });
      }
      return;
      if (paramMessageForApollo.msgType == 2) {
        paramamme = "" + paramMessageForApollo.gameId;
      } else {
        paramamme = "";
      }
    }
  }
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull MessageRecord paramMessageRecord, @NotNull MessageForApollo paramMessageForApollo, @NotNull amme paramamme)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramMessageRecord, "uMessageRecord");
    Intrinsics.checkParameterIsNotNull(paramMessageForApollo, "apollo");
    Intrinsics.checkParameterIsNotNull(paramamme, "apolloManager");
    int j = paramamme.b(paramQQAppInterface.getCurrentUin());
    if (paramMessageForApollo.msgType == 0) {
      paramamme = String.valueOf(paramMessageForApollo.mApolloMessage.id);
    }
    for (;;)
    {
      int i;
      if (paramMessageRecord.istroop == 1)
      {
        i = 1;
        label63:
        HotChatManager localHotChatManager = paramQQAppInterface.getHotChatMng(false);
        Intrinsics.checkExpressionValueIsNotNull(localHotChatManager, "app.getHotChatMng(false)");
        if ((localHotChatManager == null) || (!localHotChatManager.b(paramMessageRecord.frienduin))) {
          break label278;
        }
        i = 3;
      }
      label278:
      for (;;)
      {
        VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "rev_action", paramMessageRecord.senderuin.toString(), i, paramMessageForApollo.msgType, new String[] { paramamme, Integer.toString(j), Integer.toString(amme.a((AppInterface)paramQQAppInterface)), String.valueOf(System.currentTimeMillis() / 1000) });
        if (paramMessageForApollo.msgType == 10)
        {
          j = paramMessageForApollo.mApolloMessage.flag;
          VipUtils.a((AppInterface)paramQQAppInterface, "cmshow", "Apollo", "y_rev_bq", "", i, paramMessageForApollo.msgType, new String[] { String.valueOf(j >> 2 & 0x1), paramamme, paramMessageRecord.senderuin.toString() });
        }
        return;
        if (!ApolloGameUtil.a(paramMessageForApollo.msgType)) {
          break label281;
        }
        paramamme = "" + paramMessageForApollo.gameId;
        break;
        i = 2;
        break label63;
      }
      label281:
      paramamme = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjt
 * JD-Core Version:    0.7.0.1
 */