import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class azot
{
  private int a;
  private int b;
  
  private int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = babl.a(paramQQAppInterface.getCurrentAccountUin(), "troop_game_feed", paramSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read game feed red dot, num=" + i);
    }
    if (i > 0) {
      return 1;
    }
    boolean bool = azgu.c(paramQQAppInterface, paramSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShowRobotRedDot:" + bool);
    }
    if (bool) {
      return 2;
    }
    if (axng.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false))
    {
      Object localObject = (amge)alzw.a().a(535);
      if ((localObject != null) && (((amge)localObject).a)) {
        return 3;
      }
      localObject = ((amfw)alzw.a().a(551)).a(4);
      if ((localObject != null) && (((amfx)localObject).b)) {
        return 4;
      }
    }
    paramQQAppInterface = bara.a(paramQQAppInterface).a(paramSessionInfo.a);
    if (paramQQAppInterface.a)
    {
      if (paramQQAppInterface.c == 2) {}
      for (i = 1;; i = 2)
      {
        this.b = i;
        awqx.b(null, "dc00898", "", paramSessionInfo.a, "qq_vip", "0X800A8F4", this.b, 1, 0, "", "", "", "");
        return 5;
      }
    }
    return 0;
  }
  
  public static azot a(View paramView)
  {
    azot localazot2 = (azot)paramView.getTag();
    azot localazot1 = localazot2;
    if (localazot2 == null)
    {
      localazot1 = new azot();
      paramView.setTag(localazot1);
    }
    return localazot1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    switch (this.a)
    {
    default: 
      return;
    case 2: 
      azgu.c(paramQQAppInterface, false);
      return;
    case 3: 
    case 4: 
      axng.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
      return;
    }
    awqx.b(null, "dc00898", "", paramSessionInfo.a, "qq_vip", "0X800A8F5", this.b, 1, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azot
 * JD-Core Version:    0.7.0.1
 */