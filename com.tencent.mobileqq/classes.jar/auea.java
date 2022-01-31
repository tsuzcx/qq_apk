import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class auea
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
  
  protected void a(bacn parambacn, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return a(paramBaseActivity, a());
  }
  
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      auec.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent;
    if (paramBoolean) {
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    }
    for (;;)
    {
      localIntent.setFlags(67108864);
      auec.a(this, paramBoolean, localIntent);
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
      auec.a(this.g, this.f, 100);
      return false;
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
    a(paramQQAppInterface, paramContext);
    if (!b(paramQQAppInterface, paramContext))
    {
      auec.a(this.g, this.f, 3);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
      return false;
    }
    if ((baip.a(this.b)) && (baip.a(this.c)))
    {
      auec.a(this.g, this.f, 100);
      return false;
    }
    bacn localbacn2;
    bacn localbacn1;
    if (!baip.a(this.b))
    {
      localbacn2 = bade.a(paramQQAppInterface, paramContext, this.b);
      localbacn1 = localbacn2;
      if (localbacn2 != null)
      {
        localbacn1 = localbacn2;
        if (!baip.a(this.e))
        {
          localbacn1 = localbacn2;
          if (!baip.a(this.e))
          {
            localbacn2.b(this.e);
            localbacn1 = localbacn2;
          }
        }
      }
    }
    while (localbacn1 == null)
    {
      auec.a(this.g, this.f, 102);
      return false;
      localbacn2 = new bacn(paramQQAppInterface, paramContext);
      localbacn2.b = this.c;
      if ((!baip.a(this.d)) && (!baip.a(this.d))) {
        localbacn2.c = this.d;
      }
      localbacn1 = localbacn2;
      if (!this.a.isEmpty())
      {
        localbacn2.a(this.a);
        localbacn1 = localbacn2;
      }
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump ready Jump server = " + this.c);
    a(localbacn1, paramQQAppInterface, paramContext);
    if (localbacn1.c()) {
      auec.a(this.g, this.f, 0);
    }
    for (;;)
    {
      return true;
      auec.a(this.g, this.f, 103);
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
      int i = baig.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
      paramQQAppInterface = (anoe)paramQQAppInterface.getManager(264);
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
    } while (((alxy)paramQQAppInterface.getManager(269)).a() != null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auea
 * JD-Core Version:    0.7.0.1
 */