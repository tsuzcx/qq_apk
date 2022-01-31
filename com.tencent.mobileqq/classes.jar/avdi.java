import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class avdi
{
  public String a;
  public HashMap<String, String> a = new HashMap();
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public static boolean a()
  {
    return false;
  }
  
  protected void a(bbeg parambbeg, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return a(paramBaseActivity, a());
  }
  
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      avdk.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent;
    if (paramBoolean) {
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    }
    for (;;)
    {
      localIntent.setFlags(67108864);
      avdk.a(this, paramBoolean, localIntent);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant QAssistantConfigItem.Jump item_server = " + this.c + "|" + paramBaseActivity.getClass().toString());
      paramBaseActivity.startActivity(localIntent);
      return true;
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.b);
      localIntent.putExtra("fragment_id", 1);
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null))
    {
      avdk.a(this.g, this.f, 100);
      return false;
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
    a(paramQQAppInterface, paramContext);
    if (!b(paramQQAppInterface, paramContext))
    {
      avdk.a(this.g, this.f, 3);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
      return false;
    }
    if ((bbkk.a(this.b)) && (bbkk.a(this.c)))
    {
      avdk.a(this.g, this.f, 100);
      return false;
    }
    bbeg localbbeg2;
    bbeg localbbeg1;
    if (!bbkk.a(this.b))
    {
      localbbeg2 = bbex.a(paramQQAppInterface, paramContext, this.b);
      localbbeg1 = localbbeg2;
      if (localbbeg2 != null)
      {
        localbbeg1 = localbbeg2;
        if (!bbkk.a(this.e))
        {
          localbbeg1 = localbbeg2;
          if (!bbkk.a(this.e))
          {
            localbbeg2.b(this.e);
            localbbeg1 = localbbeg2;
          }
        }
      }
    }
    while (localbbeg1 == null)
    {
      avdk.a(this.g, this.f, 102);
      return false;
      localbbeg2 = new bbeg(paramQQAppInterface, paramContext);
      localbbeg2.b = this.c;
      if ((!bbkk.a(this.d)) && (!bbkk.a(this.d))) {
        localbbeg2.c = this.d;
      }
      localbbeg1 = localbbeg2;
      if (!this.a.isEmpty())
      {
        localbbeg2.a(this.a);
        localbbeg1 = localbbeg2;
      }
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump ready Jump server = " + this.c);
    a(localbbeg1, paramQQAppInterface, paramContext);
    if (localbbeg1.c()) {
      avdk.a(this.g, this.f, 0);
    }
    for (;;)
    {
      return true;
      avdk.a(this.g, this.f, 103);
    }
  }
  
  protected boolean b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.f != null)
    {
      if (!this.f.equalsIgnoreCase("ecchat")) {
        break label79;
      }
      int i = bbkb.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
      paramQQAppInterface = (aoeu)paramQQAppInterface.getManager(264);
      if ((i != 1) || (!paramQQAppInterface.b())) {
        break label73;
      }
      bool1 = true;
    }
    label73:
    label79:
    do
    {
      do
      {
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
        bool1 = bool2;
      } while (!this.f.equalsIgnoreCase("confessmsg"));
      bool1 = bool2;
    } while (((amnn)paramQQAppInterface.getManager(269)).a() != null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdi
 * JD-Core Version:    0.7.0.1
 */