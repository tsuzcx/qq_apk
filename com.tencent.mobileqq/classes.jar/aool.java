import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MiniAppConfBean.1;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

public class aool
{
  private int jdField_a_of_type_Int = 60;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new MiniAppConfBean.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  
  public static aool a(aoko[] paramArrayOfaoko)
  {
    aool localaool = new aool();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (i < paramArrayOfaoko.length)
        {
          String str1 = paramArrayOfaoko[i].jdField_a_of_type_JavaLangString;
          if (str1 == null) {
            break label671;
          }
          Object localObject = new JSONObject(str1);
          if (((JSONObject)localObject).has("aio_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("aio_mini_app_on", 1) != 1) {
              break label685;
            }
            bool = true;
            localaool.jdField_a_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("mini_app_local_search"))
          {
            if (((JSONObject)localObject).optInt("mini_app_local_search", 1) != 1) {
              break label691;
            }
            bool = true;
            localaool.jdField_b_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("mini_app_refresh_time")) {
            localaool.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("mini_app_refresh_time", 60);
          }
          if (((JSONObject)localObject).has("popBarShowMiniAppStore"))
          {
            if (((JSONObject)localObject).optInt("popBarShowMiniAppStore", 0) != 1) {
              break label697;
            }
            bool = true;
            localaool.jdField_c_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("minigame_splash")) {
            SplashMiniGameUtil.saveConfigData(str1);
          }
          if (((JSONObject)localObject).has("mini_app_entry_auto_show"))
          {
            if (((JSONObject)localObject).optInt("mini_app_entry_auto_show", 0) != 1) {
              break label703;
            }
            bool = true;
            localaool.jdField_d_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("contact_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("contact_mini_app_on", 0) != 1) {
              break label709;
            }
            bool = true;
            localaool.jdField_f_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("more_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("more_mini_app_on", 0) != 1) {
              break label715;
            }
            bool = true;
            localaool.jdField_e_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("group_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("group_mini_app_on", 0) != 1) {
              break label721;
            }
            bool = true;
            localaool.jdField_g_of_type_Boolean = bool;
          }
          if (((JSONObject)localObject).has("avatar_mini_app_on"))
          {
            if (((JSONObject)localObject).optInt("avatar_mini_app_on", 0) != 1) {
              break label727;
            }
            bool = true;
            localaool.h = bool;
            if (((JSONObject)localObject).has("avatar_mini_app_url")) {
              localaool.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("avatar_mini_app_url");
            }
          }
          if (((JSONObject)localObject).has("back_to_home_scene_list"))
          {
            if (localaool.jdField_a_of_type_JavaUtilArrayList == null) {
              localaool.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            localaool.jdField_a_of_type_JavaUtilArrayList.clear();
            String[] arrayOfString = ((JSONObject)localObject).optString("back_to_home_scene_list", "1044|1007|1008|2003").split("\\|");
            int k = arrayOfString.length;
            j = 0;
            if (j < k)
            {
              String str2 = arrayOfString[j];
              if (TextUtils.isEmpty(str2)) {
                break label678;
              }
              localaool.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(str2));
              break label678;
            }
          }
          if (1 == ((JSONObject)localObject).optInt("enable_c2c_plus_panel", 0))
          {
            localaool.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("url", "");
            localaool.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("icon", "");
            localaool.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("icon_night", "");
            localaool.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("simple_icon", "");
            localaool.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("simple_icon_night", "");
            localaool.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("name", BaseApplicationImpl.sApplication.getString(2131698806));
            localObject = BaseApplicationImpl.getApplication().getRuntime();
            if ((localObject instanceof QQAppInterface))
            {
              localObject = (QQAppInterface)localObject;
              aghf.a((QQAppInterface)localObject).a((QQAppInterface)localObject, localaool);
            }
          }
          localStringBuilder.append("config: ").append(str1).append(",");
        }
      }
      catch (Exception paramArrayOfaoko)
      {
        QLog.d("MiniAppConfProcessor", 2, "parse, failed!");
        paramArrayOfaoko.printStackTrace();
        return null;
      }
      QLog.e("MiniAppConfProcessor", 2, "parse, content:" + localStringBuilder.toString());
      return localaool;
      label671:
      i += 1;
      continue;
      label678:
      j += 1;
      continue;
      label685:
      boolean bool = false;
      continue;
      label691:
      bool = false;
      continue;
      label697:
      bool = false;
      continue;
      label703:
      bool = false;
      continue;
      label709:
      bool = false;
      continue;
      label715:
      bool = false;
      continue;
      label721:
      bool = false;
      continue;
      label727:
      bool = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<Integer> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public String e()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public boolean e()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public String f()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public boolean f()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public String g()
  {
    return this.jdField_g_of_type_JavaLangString;
  }
  
  public boolean g()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public String toString()
  {
    new StringBuilder().append("miniAppEntryEnable:").append(this.jdField_a_of_type_Boolean).append(", miniAppRefreshTime:").append(this.jdField_a_of_type_Int).append(",miniAppLocalSearchEnable").append(this.jdField_b_of_type_Boolean);
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aool
 * JD-Core Version:    0.7.0.1
 */