import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class bgig
  extends bghr
{
  public bgig(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 26;
  }
  
  @Nullable
  public bghs a(int paramInt1, List<Long> paramList, long paramLong1, Object paramObject, long paramLong2, long paramLong3, int paramInt2)
  {
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong1);
    if ((paramList != null) && (a(paramList, paramLong2, paramLong3)))
    {
      paramObject = this.jdField_a_of_type_AndroidContentContext.getString(2131697009);
      bfpe localbfpe = bfpe.a(paramInt1, paramLong1, paramInt2);
      String str = paramList.senderuin;
      if (nlj.a(paramList)) {}
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_topmsgcue", paramInt1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        return new bghs(true, paramObject, localbfpe, str);
      }
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject, String paramString)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "exp_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
  }
  
  public void b(int paramInt, Object paramObject, String paramString)
  {
    if (nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    for (paramInt = 2;; paramInt = 1)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_topmsgcue", paramInt, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_AIO", "", "notice_center_new", "clk_gift", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgig
 * JD-Core Version:    0.7.0.1
 */