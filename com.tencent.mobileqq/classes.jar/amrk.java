import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amrk
  implements ampd<String>
{
  protected String a;
  public ArrayList<String> a;
  public ConcurrentHashMap<String, altm> a;
  public boolean a;
  public String b;
  public ArrayList<String> b;
  public ConcurrentHashMap<String, ArrayList<String>> b;
  public boolean b;
  
  public amrk()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(8);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      ArkAppCenter.c("ArkPlatformConfig", "onParse,fileOrRes is null");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    Object localObject1;
    int i;
    Object localObject2;
    boolean bool;
    label126:
    Object localObject3;
    label180:
    label252:
    int k;
    try
    {
      paramString = new JSONObject(paramString);
      localObject1 = paramString.optJSONArray("ark_force_update_app_list");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(i);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label800;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          QLog.d("ArkPlatformConfig", 1, new Object[] { "get config update app=", localObject2 });
          break label800;
        }
      }
      if (paramString.optInt("ark_url_check_enable", 1) != 1) {
        break label814;
      }
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      QLog.d("ArkPlatformConfig", 1, new Object[] { "mIsUrlCheckEnable = ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      localObject1 = paramString.optJSONArray("ark_url_check_disable_apps");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(i);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label807;
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
          QLog.d("ArkPlatformConfig", 1, new Object[] { "get config disable app=", localObject2 });
          break label807;
        }
      }
      if (paramString.optInt("ark_memory_optimize", 0) != 1) {
        break label827;
      }
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      QLog.d("ArkPlatformConfig", 1, new Object[] { "mIsOptimizeEnable = ", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      this.jdField_b_of_type_JavaLangString = paramString.optString("ark_toast_info_config", "");
      QLog.d("ArkPlatformConfig", 1, new Object[] { "mToastStr = ", this.jdField_b_of_type_JavaLangString });
      localObject1 = paramString.optJSONArray("predownload_cfg_list");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = 0;
        label340:
        if (i < ((JSONArray)localObject1).length())
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = ((JSONObject)localObject3).optString("app_name");
          k = ((JSONObject)localObject3).optInt("preload");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = new altm();
            ((altm)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((altm)localObject3).jdField_a_of_type_Int = k;
            QLog.d("ArkPlatformConfig", 1, "onParse predownload_cfg_list name = " + (String)localObject2 + ", preload = " + k);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localObject3);
          }
          else
          {
            QLog.d("ArkPlatformConfig", 1, "onParse predownload_cfg_list app_name is empty");
          }
        }
      }
    }
    catch (JSONException paramString)
    {
      QLog.e("ArkPlatformConfig", 1, "onParse error e = ", paramString);
      return;
    }
    QLog.d("ArkPlatformConfig", 1, new Object[] { "onParse mPreDownload list size =", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
    paramString = paramString.optJSONObject("app_global_url_config");
    if (paramString != null)
    {
      localObject1 = paramString.optJSONArray("white");
      if (localObject1 != null)
      {
        k = ((JSONArray)localObject1).length();
        localObject2 = new ArrayList();
        i = 0;
        label546:
        if (i < k)
        {
          localObject3 = ((JSONArray)localObject1).optString(i, "");
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label833;
          }
          QLog.d("ArkPlatformConfig", 1, "onParse white url = " + (String)localObject3);
          ((ArrayList)localObject2).add(localObject3);
          break label833;
        }
        QLog.d("ArkPlatformConfig", 1, new Object[] { "white list size =", Integer.valueOf(((ArrayList)localObject2).size()) });
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put("white", localObject2);
      }
      paramString = paramString.optJSONArray("black");
      if (paramString != null)
      {
        k = paramString.length();
        localObject1 = new ArrayList();
        i = j;
      }
    }
    for (;;)
    {
      if (i < k)
      {
        localObject2 = paramString.optString(i, "");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          QLog.d("ArkPlatformConfig", 1, "onParse black url = " + (String)localObject2);
          ((ArrayList)localObject1).add(localObject2);
        }
      }
      else
      {
        QLog.d("ArkPlatformConfig", 1, "black list size = " + ((ArrayList)localObject1).size());
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put("black", localObject1);
        QLog.d("ArkPlatformConfig", 1, "mGlobalUrlConfig list size = " + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        return;
        label800:
        i += 1;
        break;
        label807:
        i += 1;
        break label180;
        label814:
        bool = false;
        break label126;
        i += 1;
        break label340;
        label827:
        bool = false;
        break label252;
        label833:
        i += 1;
        break label546;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amrk
 * JD-Core Version:    0.7.0.1
 */