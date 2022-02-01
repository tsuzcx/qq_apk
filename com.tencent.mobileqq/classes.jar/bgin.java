import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class bgin
  extends bghr
{
  public bgin(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 4;
  }
  
  @Nullable
  public bghs a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3))) {
      return new bghs(true, this.jdField_a_of_type_AndroidContentContext.getString(2131696939), bfpe.a(paramInt1, paramLong1, paramInt2), paramList.senderuin);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgin
 * JD-Core Version:    0.7.0.1
 */