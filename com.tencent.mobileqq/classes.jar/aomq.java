import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aomq
  implements aokj<String>
{
  protected String a;
  public ArrayList<String> a;
  public ConcurrentHashMap<String, anon> a;
  public boolean a;
  public String b;
  public ArrayList<String> b;
  public ConcurrentHashMap<String, ArrayList<String>> b;
  public boolean b;
  public ArrayList<String> c;
  public boolean c;
  
  public aomq()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(8);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString))
    {
      ArkAppCenter.c("ArkPlatformConfig", "onParse,fileOrRes is null");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    int i;
    Object localObject2;
    boolean bool1;
    label127:
    Object localObject3;
    label181:
    label253:
    int j;
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
            break label937;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          QLog.d("ArkPlatformConfig", 1, new Object[] { "get config update app=", localObject2 });
          break label937;
        }
      }
      if (paramString.optInt("ark_url_check_enable", 1) != 1) {
        break label951;
      }
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      QLog.d("ArkPlatformConfig", 1, new Object[] { "mIsUrlCheckEnable = ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      localObject1 = paramString.optJSONArray("ark_url_check_disable_apps");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).optString(i);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label944;
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
          QLog.d("ArkPlatformConfig", 1, new Object[] { "get config disable app=", localObject2 });
          break label944;
        }
      }
      if (paramString.optInt("ark_memory_optimize", 0) != 1) {
        break label964;
      }
      bool1 = true;
      this.jdField_b_of_type_Boolean = bool1;
      QLog.d("ArkPlatformConfig", 1, new Object[] { "mIsOptimizeEnable = ", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      this.jdField_b_of_type_JavaLangString = paramString.optString("ark_toast_info_config", "");
      QLog.d("ArkPlatformConfig", 1, new Object[] { "mToastStr = ", this.jdField_b_of_type_JavaLangString });
      localObject1 = paramString.optJSONArray("predownload_cfg_list");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = 0;
        label341:
        if (i < ((JSONArray)localObject1).length())
        {
          localObject3 = ((JSONArray)localObject1).getJSONObject(i);
          localObject2 = ((JSONObject)localObject3).optString("app_name");
          j = ((JSONObject)localObject3).optInt("preload");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = new anon();
            ((anon)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((anon)localObject3).jdField_a_of_type_Int = j;
            QLog.d("ArkPlatformConfig", 1, "onParse predownload_cfg_list name = " + (String)localObject2 + ", preload = " + j);
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
    Object localObject1 = paramString.optJSONObject("app_global_url_config");
    if (localObject1 != null)
    {
      localObject2 = ((JSONObject)localObject1).optJSONArray("white");
      if (localObject2 != null)
      {
        j = ((JSONArray)localObject2).length();
        localObject3 = new ArrayList();
        i = 0;
        label546:
        if (i < j)
        {
          String str = ((JSONArray)localObject2).optString(i, "");
          if (TextUtils.isEmpty(str)) {
            break label970;
          }
          QLog.d("ArkPlatformConfig", 1, "onParse white url = " + str);
          ((ArrayList)localObject3).add(str);
          break label970;
        }
        QLog.d("ArkPlatformConfig", 1, new Object[] { "white list size =", Integer.valueOf(((ArrayList)localObject3).size()) });
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put("white", localObject3);
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("black");
      if (localObject1 != null)
      {
        j = ((JSONArray)localObject1).length();
        localObject2 = new ArrayList();
        i = 0;
        label672:
        if (i < j)
        {
          localObject3 = ((JSONArray)localObject1).optString(i, "");
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label977;
          }
          QLog.d("ArkPlatformConfig", 1, "onParse black url = " + (String)localObject3);
          ((ArrayList)localObject2).add(localObject3);
          break label977;
        }
        QLog.d("ArkPlatformConfig", 1, "black list size = " + ((ArrayList)localObject2).size());
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put("black", localObject2);
      }
    }
    QLog.d("ArkPlatformConfig", 1, "mGlobalUrlConfig list size = " + this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    localObject1 = paramString.optJSONArray("ark_download_ctrl_disable_list");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
      i = 0;
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optString(i);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
        }
      }
      else
      {
        QLog.d("ArkPlatformConfig", 1, new Object[] { "ark.dctrl get config disable download ctrl apps=", this.jdField_c_of_type_JavaUtilArrayList.toString() });
        bool1 = bool2;
        if (paramString.optInt("ark_vip_report_enable", 1) == 1) {
          bool1 = true;
        }
        this.jdField_c_of_type_Boolean = bool1;
        QLog.d("ArkPlatformConfig", 1, new Object[] { "ark VipReport enable=", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
        return;
        label937:
        i += 1;
        break;
        label944:
        i += 1;
        break label181;
        label951:
        bool1 = false;
        break label127;
        i += 1;
        break label341;
        label964:
        bool1 = false;
        break label253;
        label970:
        i += 1;
        break label546;
        label977:
        i += 1;
        break label672;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aomq
 * JD-Core Version:    0.7.0.1
 */