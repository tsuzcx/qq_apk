import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import java.text.SimpleDateFormat;

public class bayw
  extends bayu
{
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy/MM/dd");
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private RecentUser jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  private CharSequence c;
  
  public bayw(QQAppInterface paramQQAppInterface, String paramString, RecentUser paramRecentUser, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = paramRecentUser;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public CharSequence a()
  {
    if (this.b == null) {
      if (!nmy.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord)) {
        break label60;
      }
    }
    label60:
    SessionInfo localSessionInfo;
    for (this.b = (BaseApplicationImpl.sApplication.getString(2131696698) + nmy.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).b);; this.b = ContactUtils.getNicknameInSession(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isSend(), this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin))
    {
      return this.b;
      localSessionInfo = new SessionInfo();
      localSessionInfo.curType = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
      localSessionInfo.curFriendUin = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    akms.jdField_a_of_type_Boolean = true;
    akms.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    akms.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType()), false);
    anap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    bbgk.a(this.jdField_a_of_type_JavaLangString, 40, paramView, true);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.c == null) {
      this.c = bbgk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg, this.jdField_a_of_type_JavaLangString);
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
      this.jdField_a_of_type_JavaLangCharSequence = bfzl.a(BaseApplicationImpl.sApplication, 3, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time * 1000L);
    }
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public CharSequence d()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayw
 * JD-Core Version:    0.7.0.1
 */