import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class bgiq
  extends bghr
{
  public bgiq(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 22;
  }
  
  @Nullable
  public bghs a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong1);
    if ((localObject != null) && (a((MessageRecord)localObject, paramLong2, paramLong3)))
    {
      paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131697017);
      paramObject = bfpe.a(paramInt1, ((MessageRecord)localObject).shmsgseq, paramInt2);
      localObject = ((MessageRecord)localObject).senderuin;
      MessageForReplyText.reportReplyMsg(null, "AIOchat", "Appear_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
      return new bghs(true, paramList, paramObject, (String)localObject);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
    for (paramObject = "Grp_Dis_replyMsg";; paramObject = "Grp_AIO")
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", paramObject, "", "notice_center_new", "exp_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    MessageForReplyText.reportReplyMsg(null, "AIOchat", "Clk_topmsgcue_reply", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
    for (paramObject = "Grp_Dis_replyMsg";; paramObject = "Grp_AIO")
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", paramObject, "", "notice_center_new", "clk_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgiq
 * JD-Core Version:    0.7.0.1
 */