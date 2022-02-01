import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bfhm
{
  private int a;
  
  private int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = bfun.a(paramQQAppInterface.getCurrentAccountUin(), "troop_game_feed", paramSessionInfo.curFriendUin);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read game feed red dot, num=" + i);
    }
    if (i > 0) {
      return 1;
    }
    i = bfun.a(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.troopUin);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read album feed red dot, num=" + i);
    }
    if (i > 0) {
      return 6;
    }
    boolean bool = bezm.c(paramQQAppInterface, paramSessionInfo.curFriendUin);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShowRobotRedDot:" + bool);
    }
    if (bool) {
      return 2;
    }
    if (bddg.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false))
    {
      localObject = (aqde)apub.a().a(535);
      if ((localObject != null) && (((aqde)localObject).a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_WATCH_RED show");
        }
        return 3;
      }
      localObject = ((aqcu)apub.a().a(551)).a(4);
      if ((localObject != null) && (((aqcv)localObject).b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_SING_RED show");
        }
        return 4;
      }
    }
    Object localObject = (bdnn)apub.a().a(664);
    if ((localObject != null) && (((bdnn)localObject).a(paramSessionInfo.curFriendUin)) && (bfun.a(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curFriendUin, false)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopSettingRedInfo", 2, "TroopActiveRankingConfig: TROOPACTIVE_RANKING show");
      }
      return 7;
    }
    return 0;
  }
  
  public static bfhm a(View paramView)
  {
    bfhm localbfhm2 = (bfhm)paramView.getTag();
    bfhm localbfhm1 = localbfhm2;
    if (localbfhm2 == null)
    {
      localbfhm1 = new bfhm();
      paramView.setTag(localbfhm1);
    }
    return localbfhm1;
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
          boolean bool = bezm.c(paramQQAppInterface, paramSessionInfo.curFriendUin);
          if (QLog.isColorLevel()) {
            QLog.d("TroopSettingRedInfo", 2, "onClick:" + bool);
          }
          if (bool) {
            bezm.c(paramQQAppInterface, false);
          }
        }
      } while (!bddg.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false));
      paramSessionInfo = (aqde)apub.a().a(535);
      if ((paramSessionInfo != null) && (paramSessionInfo.a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_WATCH_RED clean");
        }
        bddg.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
      }
      paramSessionInfo = ((aqcu)apub.a().a(551)).a(4);
    } while ((paramSessionInfo == null) || (!paramSessionInfo.b));
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "SingTogetherConfigBean: TOGETHER_SING_RED clean");
    }
    bddg.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
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
 * Qualified Name:     bfhm
 * JD-Core Version:    0.7.0.1
 */