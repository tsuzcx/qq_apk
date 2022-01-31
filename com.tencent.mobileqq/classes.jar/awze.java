import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class awze
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
  
  protected void a(bdhk parambdhk, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return a(paramBaseActivity, a());
  }
  
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      awzg.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent;
    if (paramBoolean) {
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    }
    for (;;)
    {
      localIntent.setFlags(67108864);
      awzg.a(this, paramBoolean, localIntent);
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
      awzg.a(this.g, this.f, 100);
      return false;
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
    a(paramQQAppInterface, paramContext);
    if (!b(paramQQAppInterface, paramContext))
    {
      awzg.a(this.g, this.f, 3);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
      return false;
    }
    if ((bdnn.a(this.b)) && (bdnn.a(this.c)))
    {
      awzg.a(this.g, this.f, 100);
      return false;
    }
    bdhk localbdhk2;
    bdhk localbdhk1;
    if (!bdnn.a(this.b))
    {
      localbdhk2 = bdib.a(paramQQAppInterface, paramContext, this.b);
      localbdhk1 = localbdhk2;
      if (localbdhk2 != null)
      {
        localbdhk1 = localbdhk2;
        if (!bdnn.a(this.e))
        {
          localbdhk1 = localbdhk2;
          if (!bdnn.a(this.e))
          {
            localbdhk2.b(this.e);
            localbdhk1 = localbdhk2;
          }
        }
      }
    }
    while (localbdhk1 == null)
    {
      awzg.a(this.g, this.f, 102);
      return false;
      localbdhk2 = new bdhk(paramQQAppInterface, paramContext);
      localbdhk2.b = this.c;
      if ((!bdnn.a(this.d)) && (!bdnn.a(this.d))) {
        localbdhk2.c = this.d;
      }
      localbdhk1 = localbdhk2;
      if (!this.a.isEmpty())
      {
        localbdhk2.a(this.a);
        localbdhk1 = localbdhk2;
      }
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump ready Jump server = " + this.c);
    a(localbdhk1, paramQQAppInterface, paramContext);
    if (localbdhk1.c())
    {
      awzg.a(this.g, this.f, 0);
      awzg.a(this.f);
    }
    for (;;)
    {
      return true;
      awzg.a(this.g, this.f, 103);
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
      int i = bdne.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
      paramQQAppInterface = (aqbg)paramQQAppInterface.getManager(264);
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
    } while (((aoiu)paramQQAppInterface.getManager(269)).a() != null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awze
 * JD-Core Version:    0.7.0.1
 */