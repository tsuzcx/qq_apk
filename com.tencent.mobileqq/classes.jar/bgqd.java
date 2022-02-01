import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.TroopSettingRedInfo.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class bgqd
{
  private int a;
  
  private int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool1 = bggj.a(paramSessionInfo.curFriendUin);
    if (!bool1)
    {
      i = bhdf.a(paramQQAppInterface.getCurrentAccountUin(), "troop_game_feed", paramSessionInfo.curFriendUin);
      if (QLog.isColorLevel()) {
        QLog.d("TroopSettingRedInfo", 2, "read game feed red dot, num=" + i);
      }
      if (i > 0) {
        return 1;
      }
    }
    int i = bhdf.a(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.troopUin);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read album feed red dot, num=" + i);
    }
    if (i > 0) {
      return 6;
    }
    boolean bool2 = bghs.c(paramQQAppInterface, paramSessionInfo.curFriendUin);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShowRobotRedDot:" + bool2);
    }
    if (bool2) {
      return 2;
    }
    if ((beki.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false)) && (!bool1))
    {
      localObject = (argl)aqxe.a().a(535);
      if ((localObject != null) && (((argl)localObject).a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_WATCH_RED show");
        }
        return 3;
      }
      localObject = ((argb)aqxe.a().a(551)).a(4);
      if ((localObject != null) && (((argc)localObject).b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_SING_RED show");
        }
        return 4;
      }
    }
    Object localObject = (beuq)aqxe.a().a(664);
    if ((localObject != null) && (((beuq)localObject).a(paramSessionInfo.curFriendUin)) && (!bool1) && (bhdf.a(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curFriendUin, false)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopSettingRedInfo", 2, "TroopActiveRankingConfig: TROOPACTIVE_RANKING show");
      }
      return 7;
    }
    localObject = (bfya)aqxe.a().a(696);
    if ((localObject != null) && (((bfya)localObject).a(paramSessionInfo.curFriendUin)) && (bhdf.c(paramQQAppInterface.getCurrentAccountUin()))) {
      return 9;
    }
    if (bhdf.b(paramQQAppInterface.getCurrentAccountUin(), paramSessionInfo.curFriendUin, false)) {
      return 8;
    }
    return 0;
  }
  
  public static bgqd a(View paramView)
  {
    bgqd localbgqd2 = (bgqd)paramView.getTag();
    bgqd localbgqd1 = localbgqd2;
    if (localbgqd2 == null)
    {
      localbgqd1 = new bgqd();
      paramView.setTag(localbgqd1);
    }
    return localbgqd1;
  }
  
  private void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      boolean bool = bghs.c(paramQQAppInterface, paramSessionInfo.curFriendUin);
      if (QLog.isColorLevel()) {
        QLog.d("TroopSettingRedInfo", 2, "onClick:" + bool);
      }
      if (bool) {
        bghs.c(paramQQAppInterface, false);
      }
    }
    if (beki.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false))
    {
      localObject = (argl)aqxe.a().a(535);
      if ((localObject != null) && (((argl)localObject).a))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "togetherConfigureBean: TOGETHER_WATCH_RED clean");
        }
        beki.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
      }
      localObject = ((argb)aqxe.a().a(551)).a(4);
      if ((localObject != null) && (((argc)localObject).b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopSettingRedInfo", 2, "SingTogetherConfigBean: TOGETHER_SING_RED clean");
        }
        beki.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
      }
    }
    Object localObject = (bfya)aqxe.a().a(696);
    if ((localObject != null) && (((bfya)localObject).a(paramSessionInfo.curFriendUin))) {
      bhdf.c(paramQQAppInterface.getCurrentAccountUin(), false);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new TroopSettingRedInfo.1(this, paramQQAppInterface, paramSessionInfo));
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
 * Qualified Name:     bgqd
 * JD-Core Version:    0.7.0.1
 */