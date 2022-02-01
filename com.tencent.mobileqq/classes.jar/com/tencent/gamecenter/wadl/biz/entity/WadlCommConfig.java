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
    if ((TextUtils.isEmpty(paramString2)) || (paramMatchReg == null)) {}
    String[] arrayOfString;
    do
    {
      int i;
      do
      {
        return null;
        i = paramString2.lastIndexOf("/") + 1;
      } while (i < 2);
      str1 = paramString2.substring(i);
      paramString2 = paramString2.substring(0, i).split("/");
      arrayOfString = str1.split(paramMatchReg.jdField_b_of_type_JavaLangString);
      if ((paramString2.length >= paramMatchReg.jdField_a_of_type_Int) && (arrayOfString.length >= paramMatchReg.d)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WadlCommConfig", 1, "interrupt url fail, pathInfo.length=" + paramString2.length + ",fileInfo.length=" + arrayOfString.length);
    return null;
    String str2 = paramString2[paramMatchReg.jdField_b_of_type_Int];
    if (paramMatchReg.c > -1)
    {
      paramString2 = paramString2[paramMatchReg.c];
      if (paramMatchReg.e <= -1) {
        break label192;
      }
    }
    label192:
    for (String str1 = arrayOfString[paramMatchReg.e];; str1 = "")
    {
      return new ApkInfo(str2, paramString2, str1, arrayOfString[paramMatchReg.f], paramString1);
      paramString2 = "";
      break;
    }
  }
  
  public ApkInfo a(String paramString)
  {
    Object localObject1;
    for (;;)
    {
      try
      {
        localObject1 = (ApkInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
      catch (Exception paramString)
      {
        Object localObject2;
        Iterator localIterator;
        Matcher localMatcher;
        localObject1 = null;
        paramString.printStackTrace();
        return localObject1;
      }
      try
      {
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      catch (Exception paramString)
      {
        continue;
      }
      try
      {
        if (!localIterator.hasNext()) {
          return localObject1;
        }
        localObject2 = (MatchReg)localIterator.next();
        localMatcher = Pattern.compile(((MatchReg)localObject2).jdField_a_of_type_JavaLangString).matcher(paramString);
        if (!localMatcher.find()) {
          break label113;
        }
        localObject2 = a(paramString, localMatcher.group(), (MatchReg)localObject2);
        localObject1 = localObject2;
      }
      catch (Exception paramString)
      {
        continue;
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        return localObject2;
      }
    }
    label113:
    return localObject1;
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
    int j;
    int i;
    Object localObject2;
    Object localObject3;
    try
    {
      paramString = new JSONObject(new JSONObject(paramString).optString(this.jdField_a_of_type_JavaLangString));
      this.c = paramString.optString("download_mgr_url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
      this.jdField_a_of_type_Int = paramString.optInt("x5_log_seed", -1);
      ??? = paramString.optJSONArray("tips_pre_info");
      if (??? != null)
      {
        j = ((JSONArray)???).length();
        i = 0;
        if (i < j)
        {
          localObject2 = ((JSONArray)???).optJSONObject(i);
          if (localObject2 == null) {
            break label602;
          }
          localObject3 = ((JSONObject)localObject2).optString("content");
          int k = ((JSONObject)localObject2).optInt("type", -1);
          if ((k <= -1) || (TextUtils.isEmpty((CharSequence)localObject3))) {
            break label602;
          }
          this.b.put(Integer.valueOf(k), localObject3);
          break label602;
        }
      }
      localObject2 = paramString.optJSONArray("websso_cmds");
      if (localObject2 != null)
      {
        j = ((JSONArray)localObject2).length();
        if (j > 0)
        {
          synchronized (this.jdField_a_of_type_JavaUtilHashSet)
          {
            this.jdField_a_of_type_JavaUtilHashSet.clear();
            i = 0;
            label182:
            if (i >= j) {
              break label231;
            }
            localObject3 = ((JSONArray)localObject2).optString(i);
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label609;
            }
            this.jdField_a_of_type_JavaUtilHashSet.add(localObject3);
          }
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    label230:
    label231:
    do
    {
      paramString = paramString.optJSONObject("url_match_rule");
    } while (paramString == null);
    ??? = paramString.optJSONArray("reg_list");
    if (??? != null)
    {
      j = ((JSONArray)???).length();
      if (j > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
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
        if ((((MatchReg)localObject3).jdField_b_of_type_Int < ((MatchReg)localObject3).jdField_a_of_type_Int) && (((MatchReg)localObject3).c < ((MatchReg)localObject3).jdField_a_of_type_Int) && (((MatchReg)localObject3).e < ((MatchReg)localObject3).d) && (((MatchReg)localObject3).f < ((MatchReg)localObject3).d)) {
          this.jdField_a_of_type_JavaUtilList.add(localObject3);
        }
      }
      else
      {
        paramString = paramString.optJSONArray("replace_list");
        if (paramString == null) {
          break label230;
        }
        j = paramString.length();
        if (j <= 0) {
          break label230;
        }
        i = 0;
        while (i < j)
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
        }
        break label230;
        label602:
        i += 1;
        break;
        label609:
        i += 1;
        break label182;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig
 * JD-Core Version:    0.7.0.1
 */