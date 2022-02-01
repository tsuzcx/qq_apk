package com.tencent.mobileqq.ark.config.config;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.config.PreloadItem;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkPlatformConfigParser
  extends ArkPlatformConfig
  implements IQStorageSafable<String>
{
  protected String b;
  
  public ArkPlatformConfigParser()
  {
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ArkApp.ArkPlatformConfig", 1, "onParse,fileOrRes is null");
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject1 = paramString.optJSONArray("ark_force_update_app_list");
        Object localObject2;
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1087;
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "get config update app=", localObject2 });
            break label1087;
          }
        }
        if (paramString.optInt("ark_url_check_enable", 1) != 1) {
          break label1094;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "mIsUrlCheckEnable = ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
        localObject1 = paramString.optJSONArray("ark_url_check_disable_apps");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1100;
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "get config disable app=", localObject2 });
            break label1100;
          }
        }
        if (paramString.optInt("ark_memory_optimize", 0) != 1) {
          break label1107;
        }
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "mIsOptimizeEnable = ", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
        if (paramString.optInt("wt_url_new_rule", 1) != 1) {
          break label1113;
        }
        bool = true;
        this.f = bool;
        this.jdField_a_of_type_JavaLangString = paramString.optString("ark_toast_info_config", "");
        QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "mToastStr = ", this.jdField_a_of_type_JavaLangString });
        localObject1 = paramString.optJSONArray("predownload_cfg_list");
        Object localObject3;
        int j;
        Object localObject4;
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            localObject2 = ((JSONObject)localObject3).optString("app_name");
            j = ((JSONObject)localObject3).optInt("preload");
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject3 = new PreloadItem();
              ((PreloadItem)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject2);
              ((PreloadItem)localObject3).jdField_a_of_type_Int = j;
              localObject4 = new StringBuilder("onParse predownload_cfg_list name = ");
              ((StringBuilder)localObject4).append((String)localObject2);
              ((StringBuilder)localObject4).append(", preload = ");
              ((StringBuilder)localObject4).append(j);
              QLog.d("ArkApp.ArkPlatformConfig", 1, ((StringBuilder)localObject4).toString());
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localObject3);
              break label1119;
            }
            QLog.d("ArkApp.ArkPlatformConfig", 1, "onParse predownload_cfg_list app_name is empty");
            break label1119;
          }
        }
        QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "onParse mPreDownload list size =", Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
        localObject1 = paramString.optJSONObject("app_global_url_config");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optJSONArray("white");
          if (localObject2 != null)
          {
            j = ((JSONArray)localObject2).length();
            localObject3 = new ArrayList();
            i = 0;
            if (i < j)
            {
              localObject4 = ((JSONArray)localObject2).optString(i, "");
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                break label1126;
              }
              StringBuilder localStringBuilder = new StringBuilder("onParse white url = ");
              localStringBuilder.append((String)localObject4);
              QLog.d("ArkApp.ArkPlatformConfig", 1, localStringBuilder.toString());
              ((ArrayList)localObject3).add(localObject4);
              break label1126;
            }
            QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "white list size =", Integer.valueOf(((ArrayList)localObject3).size()) });
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put("white", localObject3);
          }
          localObject2 = ((JSONObject)localObject1).optJSONArray("black");
          if (localObject2 != null)
          {
            j = ((JSONArray)localObject2).length();
            localObject1 = new ArrayList();
            i = 0;
            if (i < j)
            {
              localObject3 = ((JSONArray)localObject2).optString(i, "");
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label1133;
              }
              localObject4 = new StringBuilder("onParse black url = ");
              ((StringBuilder)localObject4).append((String)localObject3);
              QLog.d("ArkApp.ArkPlatformConfig", 1, ((StringBuilder)localObject4).toString());
              ((ArrayList)localObject1).add(localObject3);
              break label1133;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("black list size = ");
            ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
            QLog.d("ArkApp.ArkPlatformConfig", 1, ((StringBuilder)localObject2).toString());
            this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put("black", localObject1);
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mGlobalUrlConfig list size = ");
        ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size());
        QLog.d("ArkApp.ArkPlatformConfig", 1, ((StringBuilder)localObject1).toString());
        localObject1 = paramString.optJSONArray("ark_download_ctrl_disable_list");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break label1140;
            }
            this.jdField_c_of_type_JavaUtilArrayList.add(localObject2);
            break label1140;
          }
        }
        QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "ark.dctrl get config disable download ctrl apps=", this.jdField_c_of_type_JavaUtilArrayList.toString() });
        if (paramString.optInt("ark_vip_report_enable", 1) != 1) {
          break label1147;
        }
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
        if (paramString.optInt("back_to_file_scheme_enable", 1) != 1) {
          break label1153;
        }
        bool = true;
        this.d = bool;
        if (paramString.optInt("add_backslash_enable", 1) != 1) {
          break label1159;
        }
        bool = true;
        this.e = bool;
        QLog.d("ArkApp.ArkPlatformConfig", 1, new Object[] { "ark VipReport enable=", Boolean.valueOf(this.jdField_c_of_type_Boolean), ", mIsBackToFileSchemeEnable=", Boolean.valueOf(this.d), ", mAddBackslashEnable=", Boolean.valueOf(this.e) });
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("ArkApp.ArkPlatformConfig", 1, "onParse error e = ", paramString);
        return;
      }
      label1087:
      i += 1;
      continue;
      label1094:
      boolean bool = false;
      continue;
      label1100:
      i += 1;
      continue;
      label1107:
      bool = false;
      continue;
      label1113:
      bool = false;
      continue;
      label1119:
      i += 1;
      continue;
      label1126:
      i += 1;
      continue;
      label1133:
      i += 1;
      continue;
      label1140:
      i += 1;
      continue;
      label1147:
      bool = false;
      continue;
      label1153:
      bool = false;
      continue;
      label1159:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.config.ArkPlatformConfigParser
 * JD-Core Version:    0.7.0.1
 */