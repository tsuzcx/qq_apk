import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class befq
{
  private andd jdField_a_of_type_Andd = new befr(this);
  public Context a;
  public Handler a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public String a;
  
  public befq(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private String a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.b(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Andd);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.e("RefreshMemberList", 4, "Prepare refreshMemberListFromServer");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    String str;
    do
    {
      return;
      str = a(this.jdField_a_of_type_JavaLangString);
    } while (TextUtils.isEmpty(str));
    long l1 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("last_update_time", 4).getLong("key_last_update_time" + str, 0L);
    long l2 = System.currentTimeMillis();
    if ((paramBoolean) || (l1 == 0L) || ((l1 > 0L) && (l2 - l1 > 300000L)))
    {
      ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).a(true, this.jdField_a_of_type_JavaLangString, str, 5);
      if (l1 == 0L)
      {
        QLog.e("RefreshMemberList", 4, "Not refresh now, will refresh.");
        return;
      }
      QLog.e("RefreshMemberList", 4, "> 5min, will refresh.");
      return;
    }
    QLog.e("RefreshMemberList", 4, "< 5min, Will not refresh.");
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befq
 * JD-Core Version:    0.7.0.1
 */