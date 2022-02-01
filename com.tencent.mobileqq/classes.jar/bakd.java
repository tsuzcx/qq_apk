import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class bakd
{
  public String a;
  public HashMap<String, String> a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public bakd()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static boolean a()
  {
    return false;
  }
  
  protected void a(bheh parambheh, QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext) {}
  
  public boolean a(BaseActivity paramBaseActivity)
  {
    return a(paramBaseActivity, a());
  }
  
  public boolean a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if (paramBaseActivity == null)
    {
      bakg.a(this.g, this.f, 100);
      return false;
    }
    Intent localIntent;
    if (paramBoolean) {
      localIntent = new Intent(paramBaseActivity, SplashActivity.class);
    }
    for (;;)
    {
      localIntent.setFlags(67108864);
      bakg.a(this, paramBoolean, localIntent);
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
      bakg.a(this.g, this.f, 100);
      return false;
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump start");
    a(paramQQAppInterface, paramContext);
    if (!b(paramQQAppInterface, paramContext))
    {
      bakg.a(this.g, this.f, 3);
      QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant checkIsSupportJump is false");
      return false;
    }
    if ((StringUtil.isEmpty(this.b)) && (StringUtil.isEmpty(this.c)))
    {
      bakg.a(this.g, this.f, 100);
      return false;
    }
    bheh localbheh2;
    bheh localbheh1;
    if (!StringUtil.isEmpty(this.b))
    {
      localbheh2 = bhey.a(paramQQAppInterface, paramContext, this.b);
      localbheh1 = localbheh2;
      if (localbheh2 != null)
      {
        localbheh1 = localbheh2;
        if (!StringUtil.isEmpty(this.e))
        {
          localbheh1 = localbheh2;
          if (!StringUtil.isEmpty(this.e))
          {
            localbheh2.c(this.e);
            localbheh1 = localbheh2;
          }
        }
      }
    }
    while (localbheh1 == null)
    {
      bakg.a(this.g, this.f, 102);
      return false;
      localbheh2 = new bheh(paramQQAppInterface, paramContext);
      localbheh2.b = this.c;
      if ((!StringUtil.isEmpty(this.d)) && (!StringUtil.isEmpty(this.d))) {
        localbheh2.c = this.d;
      }
      localbheh1 = localbheh2;
      if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
      {
        localbheh2.a(this.jdField_a_of_type_JavaUtilHashMap);
        localbheh1 = localbheh2;
      }
    }
    QLog.d("QAssistantConfigItem", 1, "mqqaudioassistant RealJump ready Jump server = " + this.c);
    a(localbheh1, paramQQAppInterface, paramContext);
    if (localbheh1.a())
    {
      bakg.a(this.g, this.f, 0);
      bakg.a(this.f);
    }
    for (;;)
    {
      return true;
      bakg.a(this.g, this.f, 103);
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
      int i = bhhr.a(paramQQAppInterface.getCurrentAccountUin(), "extend_friend_config_785").getInt("sp_extend_friend_entry_add_friend", 0);
      paramQQAppInterface = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
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
    } while (((aqvd)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a() != null);
    return false;
  }
  
  public String toString()
  {
    return "{\"strName\":\"" + this.jdField_a_of_type_JavaLangString + "\", \"strScheme\":\"" + this.b + "\", \"strServer\":\"" + this.c + "\", \"strAction\":\"" + this.d + "\", \"strPackage\":\"" + this.e + "\", \"isOpenEnable\":" + this.jdField_a_of_type_Boolean + ", \"openAction\":\"" + this.f + "\", \"host\":\"" + this.g + "\", \"attributes\":" + this.jdField_a_of_type_JavaUtilHashMap + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakd
 * JD-Core Version:    0.7.0.1
 */