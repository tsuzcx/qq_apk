import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class bery
  extends beqz
{
  public bery(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 22;
  }
  
  @Nullable
  public bera a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramLong1);
    if ((localObject != null) && (a((MessageRecord)localObject, paramLong2, paramLong3)))
    {
      paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131697159);
      paramObject = bdyo.a(paramInt1, ((MessageRecord)localObject).shmsgseq, paramInt2);
      localObject = ((MessageRecord)localObject).senderuin;
      MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, null);
      return new bera(true, paramList, paramObject, (String)localObject);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {}
    for (paramObject = "Grp_Dis_replyMsg";; paramObject = "Grp_AIO")
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", paramObject, "", "notice_center_new", "exp_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      return;
    }
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType == 3000) {}
    for (paramObject = "Grp_Dis_replyMsg";; paramObject = "Grp_AIO")
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", paramObject, "", "notice_center_new", "clk_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bery
 * JD-Core Version:    0.7.0.1
 */