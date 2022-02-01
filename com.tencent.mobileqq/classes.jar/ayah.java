import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.qphone.base.util.QLog;

public class ayah
{
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.redtouch.util", 2, "onMedalConfigChanged configOn:" + paramBoolean + " refresh parents");
    }
    paramQQAppInterface = (axzw)paramQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem = paramQQAppInterface.a(10016);
    if (paramQQAppInterface.a(localRedTouchItem))
    {
      localRedTouchItem.isClosed = paramBoolean;
      paramQQAppInterface.d(10016);
    }
    localRedTouchItem = paramQQAppInterface.a(10015);
    if (paramQQAppInterface.a(localRedTouchItem))
    {
      localRedTouchItem.isClosed = paramBoolean;
      paramQQAppInterface.d(10015);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramQQAppInterface.getCurrentAccountUin(), 4).getBoolean("medal_switch_disable", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.redtouch.util", 2, "card.medalSwitchDisable=" + bool);
    }
    if (bgsg.W(paramQQAppInterface.getApplication(), paramQQAppInterface.getCurrentAccountUin()) != 1) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (QLog.isColorLevel())) {
        QLog.d("Q.redtouch.util", 2, "medal config off");
      }
      if ((bool) || (i != 0)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.redtouch.util", 2, "onLikeRankListConfigChanged configOn:" + paramBoolean + " refresh parents");
    }
    paramQQAppInterface = (axzw)paramQQAppInterface.getManager(160);
    RedTouchItem localRedTouchItem = paramQQAppInterface.a(100601);
    if (paramQQAppInterface.a(localRedTouchItem))
    {
      localRedTouchItem.isClosed = paramBoolean;
      paramQQAppInterface.d(100601);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return ((anpb)paramQQAppInterface.getManager(186)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayah
 * JD-Core Version:    0.7.0.1
 */