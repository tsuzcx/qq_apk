import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bcth
{
  private int a;
  private int b;
  
  private int a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = bdgg.a(paramQQAppInterface.getCurrentAccountUin(), "troop_game_feed", paramSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read game feed red dot, num=" + i);
    }
    if (i > 0) {
      return 1;
    }
    i = bdgg.a(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.b);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "read album feed red dot, num=" + i);
    }
    if (i > 0) {
      return 6;
    }
    boolean bool = bclg.c(paramQQAppInterface, paramSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("TroopSettingRedInfo", 2, "needShowRobotRedDot:" + bool);
    }
    if (bool) {
      return 2;
    }
    if (bapu.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", true, false))
    {
      Object localObject = (aorx)aoks.a().a(535);
      if ((localObject != null) && (((aorx)localObject).a)) {
        return 3;
      }
      localObject = ((aorn)aoks.a().a(551)).a(4);
      if ((localObject != null) && (((aoro)localObject).b)) {
        return 4;
      }
    }
    paramQQAppInterface = bdww.a(paramQQAppInterface).a(paramSessionInfo.a);
    if (paramQQAppInterface.a)
    {
      if (paramQQAppInterface.c == 2) {}
      for (i = 1;; i = 2)
      {
        this.b = i;
        azqs.b(null, "dc00898", "", paramSessionInfo.a, "qq_vip", "0X800A8F4", this.b, 1, 0, "", "", "", "");
        return 5;
      }
    }
    return 0;
  }
  
  public static bcth a(View paramView)
  {
    bcth localbcth2 = (bcth)paramView.getTag();
    bcth localbcth1 = localbcth2;
    if (localbcth2 == null)
    {
      localbcth1 = new bcth();
      paramView.setTag(localbcth1);
    }
    return localbcth1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.a = a(paramQQAppInterface, paramSessionInfo);
    switch (this.a)
    {
    default: 
      return;
    case 2: 
      bclg.c(paramQQAppInterface, false);
      return;
    case 3: 
    case 4: 
      bapu.a(paramQQAppInterface, "SP_KEY_WATCH_TOGETHER_TROOP_SETTING_RED_DOT_SHOW", false, false);
      return;
    case 5: 
      azqs.b(null, "dc00898", "", paramSessionInfo.a, "qq_vip", "0X800A8F5", this.b, 1, 0, "", "", "", "");
    }
    bdgg.a(paramQQAppInterface.getCurrentAccountUin(), "troop_album_feed", paramSessionInfo.b, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcth
 * JD-Core Version:    0.7.0.1
 */