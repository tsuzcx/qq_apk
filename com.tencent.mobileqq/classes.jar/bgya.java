import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bgya
{
  private int a;
  
  private int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = bhlk.a(paramQQAppInterface.getCurrentAccountUin(), "troop_game_feed", paramSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read game feed red dot, num=" + i);
    }
    if (i > 0) {
      return 1;
    }
    i = bhlk.a(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.b);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read album feed red dot, num=" + i);
    }
    if (i > 0) {
      return 6;
    }
    boolean bool = bgpy.c(paramQQAppInterface, paramSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShowRobotRedDot:" + bool);
    }
    if (bool) {
      return 2;
    }
    if (bekk.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false))
    {
      localObject = (arjl)aran.a().a(535);
      if ((localObject != null) && (((arjl)localObject).a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_WATCH_RED show");
        }
        return 3;
      }
      localObject = ((arjb)aran.a().a(551)).a(4);
      if ((localObject != null) && (((arjc)localObject).b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_SING_RED show");
        }
        return 4;
      }
    }
    Object localObject = (bfez)aran.a().a(664);
    if ((localObject != null) && (((bfez)localObject).a(paramSessionInfo.a)) && (bhlk.a(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.a, false)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopSettingRedInfo", 2, "TroopActiveRankingConfig: TROOPACTIVE_RANKING show");
      }
      return 7;
    }
    return 0;
  }
  
  public static bgya a(View paramView)
  {
    bgya localbgya2 = (bgya)paramView.getTag();
    bgya localbgya1 = localbgya2;
    if (localbgya2 == null)
    {
      localbgya1 = new bgya();
      paramView.setTag(localbgya1);
    }
    return localbgya1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return;
        if (paramSessionInfo != null)
        {
          boolean bool = bgpy.c(paramQQAppInterface, paramSessionInfo.a);
          if (QLog.isColorLevel()) {
            QLog.d("TroopSettingRedInfo", 2, "onClick:" + bool);
          }
          if (bool) {
            bgpy.c(paramQQAppInterface, false);
          }
        }
      } while (!bekk.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false));
      paramSessionInfo = (arjl)aran.a().a(535);
      if ((paramSessionInfo != null) && (paramSessionInfo.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_WATCH_RED clean");
        }
        bekk.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
      }
      paramSessionInfo = ((arjb)aran.a().a(551)).a(4);
    } while ((paramSessionInfo == null) || (!paramSessionInfo.b));
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "SingTogetherConfigBean: TOGETHER_SING_RED clean");
    }
    bekk.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.a = a(paramQQAppInterface, paramSessionInfo);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShow: " + this.a);
    }
    return this.a != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgya
 * JD-Core Version:    0.7.0.1
 */