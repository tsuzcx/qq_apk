import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bfxz
{
  private int a;
  private int b;
  
  private int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = bglj.a(paramQQAppInterface.getCurrentAccountUin(), "troop_game_feed", paramSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read game feed red dot, num=" + i);
    }
    if (i > 0) {
      return 1;
    }
    i = bglj.a(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.b);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read album feed red dot, num=" + i);
    }
    if (i > 0) {
      return 6;
    }
    boolean bool = bfpx.c(paramQQAppInterface, paramSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShowRobotRedDot:" + bool);
    }
    if (bool) {
      return 2;
    }
    if (bdro.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false))
    {
      paramQQAppInterface = (aqtz)aqlk.a().a(535);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.a)) {
        return 3;
      }
      paramQQAppInterface = ((aqtp)aqlk.a().a(551)).a(4);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.b)) {
        return 4;
      }
    }
    return 0;
  }
  
  public static bfxz a(View paramView)
  {
    bfxz localbfxz2 = (bfxz)paramView.getTag();
    bfxz localbfxz1 = localbfxz2;
    if (localbfxz2 == null)
    {
      localbfxz1 = new bfxz();
      paramView.setTag(localbfxz1);
    }
    return localbfxz1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.a = a(paramQQAppInterface, paramSessionInfo);
    switch (this.a)
    {
    default: 
      return;
    case 2: 
      bfpx.c(paramQQAppInterface, false);
      return;
    case 3: 
    case 4: 
      bdro.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
      return;
    case 5: 
      bcst.b(null, "dc00898", "", paramSessionInfo.a, "qq_vip", "0X800A8F5", this.b, 1, 0, "", "", "", "");
    }
    bglj.a(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.b, 0);
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
 * Qualified Name:     bfxz
 * JD-Core Version:    0.7.0.1
 */