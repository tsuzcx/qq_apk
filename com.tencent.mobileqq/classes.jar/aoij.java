import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aoij
  extends aojs
{
  public aoij(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      Intent localIntent = aobd.a().a(this.jdField_a_of_type_AndroidContentContext);
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
 * Qualified Name:     aoij
 * JD-Core Version:    0.7.0.1
 */