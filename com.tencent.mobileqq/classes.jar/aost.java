import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.parser.AVGameShareJoinRoomAction.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aost
  extends aouc
{
  public aost(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      if (TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("key"))) {
        return c();
      }
      boolean bool = b();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: " + localException.getMessage());
      a("AVGameShareJoinRoomAction");
    }
    return true;
  }
  
  protected boolean b()
  {
    QLog.d("AVGameShareJoinRoomAction", 1, "doAction getRoomInfoAndJoinRoom");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("key");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: key is empty");
      return true;
    }
    aojq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, new aosu(this));
    return false;
  }
  
  protected boolean c()
  {
    QLog.d("AVGameShareJoinRoomAction", 1, "doAction directJoinRoom");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("room");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: data is empty");
    }
    ncz localncz;
    do
    {
      return true;
      localncz = (ncz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    } while (localncz == null);
    ThreadManager.getUIHandler().post(new AVGameShareJoinRoomAction.2(this, localncz, str2, str1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aost
 * JD-Core Version:    0.7.0.1
 */