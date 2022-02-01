import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bgic
  extends bghr
{
  private String b;
  
  public bgic(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 21;
  }
  
  @Nullable
  public bghs a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong1);
    if ((paramObject != null) && (a(paramObject, paramLong2, paramLong3)))
    {
      if ((StructMsgForGeneralShare)bdow.a(paramObject.msgData) == null) {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showNavigateBarIfNeeded() :calendarMsg getStructMsg is null");
        }
      }
      for (paramList = this.jdField_a_of_type_AndroidContentContext.getString(2131696599);; paramList = StructMsgForGeneralShare.remindBrief)
      {
        bfpe localbfpe = bfpe.a(paramInt1, paramLong1, paramInt2);
        paramObject = paramObject.senderuin;
        this.b = StructMsgForGeneralShare.eventType;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.b, "", "");
        return new bghs(true, paramList, localbfpe, paramObject);
      }
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString) {}
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_calendar", "", "notice", "Clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.b, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgic
 * JD-Core Version:    0.7.0.1
 */