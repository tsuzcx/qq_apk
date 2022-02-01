import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class banj
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
  
  protected void a(bhmr parambhmr, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return a(paramBaseActivity, a());
  }
  
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      banl.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent;
    if (paramBoolean) {
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    }
    for (;;)
    {
      localIntent.setFlags(67108864);
      banl.a(this, paramBoolean, localIntent);
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
      banl.a(this.g, this.f, 100);
      return false;
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
    a(paramQQAppInterface, paramContext);
    if (!b(paramQQAppInterface, paramContext))
    {
      banl.a(this.g, this.f, 3);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
      return false;
    }
    if ((bhsr.a(this.b)) && (bhsr.a(this.c)))
    {
      banl.a(this.g, this.f, 100);
      return false;
    }
    bhmr localbhmr2;
    bhmr localbhmr1;
    if (!bhsr.a(this.b))
    {
      localbhmr2 = bhni.a(paramQQAppInterface, paramContext, this.b);
      localbhmr1 = localbhmr2;
      if (localbhmr2 != null)
      {
        localbhmr1 = localbhmr2;
        if (!bhsr.a(this.e))
        {
          localbhmr1 = localbhmr2;
          if (!bhsr.a(this.e))
          {
            localbhmr2.c(this.e);
            localbhmr1 = localbhmr2;
          }
        }
      }
    }
    while (localbhmr1 == null)
    {
      banl.a(this.g, this.f, 102);
      return false;
      localbhmr2 = new bhmr(paramQQAppInterface, paramContext);
      localbhmr2.b = this.c;
      if ((!bhsr.a(this.d)) && (!bhsr.a(this.d))) {
        localbhmr2.c = this.d;
      }
      localbhmr1 = localbhmr2;
      if (!this.a.isEmpty())
      {
        localbhmr2.a(this.a);
        localbhmr1 = localbhmr2;
      }
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump ready Jump server = " + this.c);
    a(localbhmr1, paramQQAppInterface, paramContext);
    if (localbhmr1.a())
    {
      banl.a(this.g, this.f, 0);
      banl.a(this.f);
    }
    for (;;)
    {
      return true;
      banl.a(this.g, this.f, 103);
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
      int i = bhsi.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
      paramQQAppInterface = (asvi)paramQQAppInterface.getManager(264);
      if ((i != 1) || (!paramQQAppInterface.d())) {
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
    } while (((aqyp)paramQQAppInterface.getManager(269)).a() != null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banj
 * JD-Core Version:    0.7.0.1
 */