import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class awuv
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
  
  protected void a(bddb parambddb, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return a(paramBaseActivity, a());
  }
  
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      awux.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent;
    if (paramBoolean) {
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    }
    for (;;)
    {
      localIntent.setFlags(67108864);
      awux.a(this, paramBoolean, localIntent);
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
      awux.a(this.g, this.f, 100);
      return false;
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
    a(paramQQAppInterface, paramContext);
    if (!b(paramQQAppInterface, paramContext))
    {
      awux.a(this.g, this.f, 3);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
      return false;
    }
    if ((bdje.a(this.b)) && (bdje.a(this.c)))
    {
      awux.a(this.g, this.f, 100);
      return false;
    }
    bddb localbddb2;
    bddb localbddb1;
    if (!bdje.a(this.b))
    {
      localbddb2 = bdds.a(paramQQAppInterface, paramContext, this.b);
      localbddb1 = localbddb2;
      if (localbddb2 != null)
      {
        localbddb1 = localbddb2;
        if (!bdje.a(this.e))
        {
          localbddb1 = localbddb2;
          if (!bdje.a(this.e))
          {
            localbddb2.b(this.e);
            localbddb1 = localbddb2;
          }
        }
      }
    }
    while (localbddb1 == null)
    {
      awux.a(this.g, this.f, 102);
      return false;
      localbddb2 = new bddb(paramQQAppInterface, paramContext);
      localbddb2.b = this.c;
      if ((!bdje.a(this.d)) && (!bdje.a(this.d))) {
        localbddb2.c = this.d;
      }
      localbddb1 = localbddb2;
      if (!this.a.isEmpty())
      {
        localbddb2.a(this.a);
        localbddb1 = localbddb2;
      }
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump ready Jump server = " + this.c);
    a(localbddb1, paramQQAppInterface, paramContext);
    if (localbddb1.c())
    {
      awux.a(this.g, this.f, 0);
      awux.a(this.f);
    }
    for (;;)
    {
      return true;
      awux.a(this.g, this.f, 103);
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
      int i = bdiv.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
      paramQQAppInterface = (apwx)paramQQAppInterface.getManager(264);
      if ((i != 1) || (!paramQQAppInterface.c())) {
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
    } while (((aoel)paramQQAppInterface.getManager(269)).a() != null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awuv
 * JD-Core Version:    0.7.0.1
 */