import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aosp
  extends aouc
{
  private Activity a;
  
  public aosp(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramQQAppInterface, paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public aosp(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    do
    {
      return;
      String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gameType");
      ncz localncz = (ncz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (localncz == null) {
        break;
      }
      try
      {
        localncz.a(this.jdField_a_of_type_AndroidAppActivity, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), Integer.parseInt(str));
        return;
      }
      catch (NumberFormatException localNumberFormatException) {}
    } while (!QLog.isColorLevel());
    QLog.d(AVGameRoomCenterFragment.a, 2, " gameType or fromType NumberFormatException");
    return;
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 2, 2131690467, 0).a();
  }
  
  public boolean a()
  {
    try
    {
      Intent localIntent = aojq.a().a(this.jdField_a_of_type_AndroidContentContext);
      if (localIntent == null)
      {
        QLog.e("AVGameShareCreateRoomAction", 1, "doAction error: intent is null");
        return true;
      }
      localIntent.putExtra("thridparty_av_game_type_key", "thridparty_av_game_type_create_room");
      String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("gameType");
      String str3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("fromType");
      String str1 = str2;
      if ("0".equals(str2)) {
        str1 = String.valueOf(1);
      }
      localIntent.putExtra("avgame_create_game_type_key", Integer.valueOf(str1));
      int i = 4;
      if (!TextUtils.isEmpty(str3)) {
        i = Integer.valueOf(str3).intValue();
      }
      localIntent.putExtra("avgame_from_type_key", i);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("AVGameShareCreateRoomAction", 1, "doAction error: " + localException.getMessage());
      a("AVGameShareCreateRoomAction");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosp
 * JD-Core Version:    0.7.0.1
 */