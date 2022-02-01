package com.tencent.gamecenter.wadl.biz.entity;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WadlCommConfig
  extends WadlBaseConfig
{
  public int a;
  private HashMap<String, ApkInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<MatchReg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private HashMap<Integer, String> b = new HashMap();
  public String c = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  
  public WadlCommConfig()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  private ApkInfo a(String paramString1, String paramString2, MatchReg paramMatchReg)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramMatchReg == null) {
        return null;
      }
      int i = paramString2.lastIndexOf("/") + 1;
      if (i < 2) {
        return null;
      }
      String str1 = paramString2.substring(i);
      paramString2 = paramString2.substring(0, i).split("/");
      String[] arrayOfString = str1.split(paramMatchReg.jdField_b_of_type_JavaLangString);
      if ((paramString2.length >= paramMatchReg.jdField_a_of_type_Int) && (arrayOfString.length >= paramMatchReg.d))
      {
        String str2 = paramString2[paramMatchReg.jdField_b_of_type_Int];
        if (paramMatchReg.c > -1) {
          paramString2 = paramString2[paramMatchReg.c];
        } else {
          paramString2 = "";
        }
        if (paramMatchReg.e > -1) {
          str1 = arrayOfString[paramMatchReg.e];
        } else {
          str1 = "";
        }
        return new ApkInfo(str2, paramString2, str1, arrayOfString[paramMatchReg.f], paramString1);
      }
      paramString1 = new StringBuilder();
      paramString1.append("interrupt url fail, pathInfo.length=");
      paramString1.append(paramString2.length);
      paramString1.append(",fileInfo.length=");
      paramString1.append(arrayOfString.length);
      QLog.d("Wadl_CommConfig", 1, paramString1.toString());
    }
    return null;
  }
  
  public ApkInfo a(String paramString)
  {
    Object localObject2;
    try
    {
      Object localObject1 = (ApkInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      localObject3 = localObject1;
      if (localObject1 != null) {
        break label131;
      }
      localObject2 = localObject1;
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          localObject2 = localObject1;
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = localObject1;
          MatchReg localMatchReg = (MatchReg)localIterator.next();
          localObject2 = localObject1;
          Matcher localMatcher = Pattern.compile(localMatchReg.jdField_a_of_type_JavaLangString).matcher(paramString);
          localObject3 = localObject1;
          localObject2 = localObject1;
          if (localMatcher.find())
          {
            localObject2 = localObject1;
            localObject3 = a(paramString, localMatcher.group(), localMatchReg);
          }
          localObject1 = localObject3;
        } while (localObject3 == null);
        return localObject3;
      }
      catch (Exception paramString) {}
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      localObject2 = null;
    }
    Object localObject3 = localObject2;
    label131:
    return localObject3;
  }
  
  public String a(int paramInt)
  {
    return (String)this.b.get(Integer.valueOf(paramInt));
  }
  
  public HashSet<String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashSet;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(new JSONObject(paramString).optString(this.jdField_a_of_type_JavaLangString));
        this.c = paramString.optString("download_mgr_url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
        this.jdField_a_of_type_Int = paramString.optInt("x5_log_seed", -1);
        ??? = paramString.optJSONArray("tips_pre_info");
        int j = 0;
        int k;
        Object localObject3;
        if (??? != null)
        {
          k = ((JSONArray)???).length();
          i = 0;
          if (i < k)
          {
            localObject2 = ((JSONArray)???).optJSONObject(i);
            if (localObject2 == null) {
              break label617;
            }
            localObject3 = ((JSONObject)localObject2).optString("content");
            int m = ((JSONObject)localObject2).optInt("type", -1);
            if ((m <= -1) || (TextUtils.isEmpty((CharSequence)localObject3))) {
              break label617;
            }
            this.b.put(Integer.valueOf(m), localObject3);
            break label617;
          }
        }
        Object localObject2 = paramString.optJSONArray("websso_cmds");
        if (localObject2 != null)
        {
          k = ((JSONArray)localObject2).length();
          if (k > 0) {
            synchronized (this.jdField_a_of_type_JavaUtilHashSet)
            {
              this.jdField_a_of_type_JavaUtilHashSet.clear();
              i = 0;
              if (i < k)
              {
                localObject3 = ((JSONArray)localObject2).optString(i);
                if (TextUtils.isEmpty((CharSequence)localObject3)) {
                  break label624;
                }
                this.jdField_a_of_type_JavaUtilHashSet.add(localObject3);
                break label624;
              }
            }
          }
        }
        paramString = paramString.optJSONObject("url_match_rule");
        if (paramString != null)
        {
          ??? = paramString.optJSONArray("reg_list");
          if (??? != null)
          {
            k = ((JSONArray)???).length();
            if (k > 0)
            {
              i = 0;
              if (i < k)
              {
                localObject2 = ((JSONArray)???).getJSONObject(i);
                localObject3 = new MatchReg();
                ((MatchReg)localObject3).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("pattern");
                ((MatchReg)localObject3).jdField_a_of_type_Int = ((JSONObject)localObject2).getInt("path_node_num");
                ((MatchReg)localObject3).jdField_b_of_type_Int = ((JSONObject)localObject2).getInt("appid_index");
                ((MatchReg)localObject3).c = ((JSONObject)localObject2).optInt("app_name_index", -1);
                ((MatchReg)localObject3).jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("split_name_char");
                ((MatchReg)localObject3).d = ((JSONObject)localObject2).getInt("name_node_num");
                ((MatchReg)localObject3).e = ((JSONObject)localObject2).optInt("channel_index", -1);
                ((MatchReg)localObject3).f = ((JSONObject)localObject2).getInt("pkg_name_index");
                if ((((MatchReg)localObject3).jdField_b_of_type_Int >= ((MatchReg)localObject3).jdField_a_of_type_Int) || (((MatchReg)localObject3).c >= ((MatchReg)localObject3).jdField_a_of_type_Int) || (((MatchReg)localObject3).e >= ((MatchReg)localObject3).d) || (((MatchReg)localObject3).f >= ((MatchReg)localObject3).d)) {
                  break label631;
                }
                this.jdField_a_of_type_JavaUtilList.add(localObject3);
                break label631;
              }
            }
          }
          paramString = paramString.optJSONArray("replace_list");
          if (paramString != null)
          {
            k = paramString.length();
            if (k > 0)
            {
              i = j;
              if (i < k)
              {
                Object localObject4 = paramString.getJSONObject(i);
                ??? = ((JSONObject)localObject4).getString("url");
                localObject2 = ((JSONObject)localObject4).getString("appid");
                localObject3 = ((JSONObject)localObject4).optString("app_name", "");
                String str1 = ((JSONObject)localObject4).optString("channel", "");
                String str2 = ((JSONObject)localObject4).getString("pkg_name");
                localObject4 = ((JSONObject)localObject4).optString("replace_url", "");
                this.jdField_a_of_type_JavaUtilHashMap.put(???, new ApkInfo((String)localObject2, (String)localObject3, str1, str2, (String)localObject4));
                i += 1;
                continue;
              }
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      label617:
      i += 1;
      continue;
      label624:
      i += 1;
      continue;
      label631:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig
 * JD-Core Version:    0.7.0.1
 */