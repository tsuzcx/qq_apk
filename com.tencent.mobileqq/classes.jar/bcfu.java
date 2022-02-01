import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import java.text.SimpleDateFormat;

public class bcfu
  extends bcfs
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy/MM/dd");
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private RecentUser jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  private CharSequence c;
  
  public bcfu(QQAppInterface paramQQAppInterface, String paramString, RecentUser paramRecentUser, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = paramRecentUser;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public CharSequence a()
  {
    if (this.b == null) {
      if (!nlj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label60;
      }
    }
    label60:
    SessionInfo localSessionInfo;
    for (this.b = (BaseApplicationImpl.sApplication.getString(2131696557) + nlj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).b);; this.b = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin))
    {
      return this.b;
      localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
      localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    alpb.jdField_a_of_type_Boolean = true;
    alpb.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    alpb.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType()), false);
    aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    bcni.a(this.jdField_a_of_type_JavaLangString, 40, paramView, true);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.c == null) {
      this.c = bcni.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg, this.jdField_a_of_type_JavaLangString);
    }
    return this.c;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
      this.jdField_a_of_type_JavaLangCharSequence = bhsw.a(BaseApplicationImpl.sApplication, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time * 1000L);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfu
 * JD-Core Version:    0.7.0.1
 */