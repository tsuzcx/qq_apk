import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/extendfriend/limitchat/AioLimitColdPalaceHelper$1", "Lcom/tencent/mobileqq/app/MessageObserver;", "onMessageRecordAdded", "", "list", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "onUpdateSendMsgError", "uin", "", "uinType", "", "replyCode", "sendMessageHandler", "Lcom/tencent/mobileqq/utils/SendMessageHandler;", "timeOut", "", "dbid", "errMsg", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class atab
  extends aocj
{
  protected void a(@Nullable String paramString1, int paramInt1, int paramInt2, @Nullable SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, @Nullable String paramString2)
  {
    QLog.d("AioLimitColdPalaceHelper", 1, "onUpdateSendMsgError uinType=" + paramInt1 + " uin=" + MobileQQ.getShortUinStr(paramString1));
    if (paramInt2 == 69)
    {
      paramSendMessageHandler = atce.a;
      paramString2 = this.a.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "mChatPie.app");
      paramSendMessageHandler = paramSendMessageHandler.a(paramString2);
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      paramSendMessageHandler.a(paramString1, paramInt1);
    }
  }
  
  public void a(@Nullable List<MessageRecord> paramList)
  {
    if (ataa.a(this.a)) {}
    Object localObject2;
    Object localObject1;
    label93:
    label98:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("onMessageRecordAdded msg size is ");
          if (paramList == null) {
            break label93;
          }
        }
        for (localObject1 = Integer.valueOf(paramList.size());; localObject1 = null)
        {
          QLog.i("AioLimitColdPalaceHelper", 2, localObject1);
          if ((!this.a.a()) || (!this.a.b())) {
            break label98;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("AioLimitColdPalaceHelper", 2, "onMessageRecordAdded: has insert ");
          return;
        }
      } while (this.a.a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null);
      localObject1 = this.a.a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
    } while ((TextUtils.isEmpty((CharSequence)((SessionInfo)localObject1).a)) || (paramList == null));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (MessageRecord)paramList.next();
      localObject2 = adak.h;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "MsgProxyUtils.MSGTYPE_HISTORY_INVISIBLE");
      if (!ArraysKt.contains((int[])localObject2, ((MessageRecord)localObject1).msgtype))
      {
        localObject2 = this.a.a().jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        if (Intrinsics.areEqual(((SessionInfo)localObject2).a, ((MessageRecord)localObject1).senderuin))
        {
          localObject1 = this.a;
          ((ataa)localObject1).b(((ataa)localObject1).b() + 1);
          if ((this.a.a()) && (!this.a.b()) && (this.a.b() >= this.a.c())) {
            this.a.f();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atab
 * JD-Core Version:    0.7.0.1
 */