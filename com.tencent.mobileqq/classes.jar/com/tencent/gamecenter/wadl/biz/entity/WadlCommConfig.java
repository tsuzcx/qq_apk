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
  public String c = "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin";
  public int d = -1;
  public int e = 0;
  public int f = 0;
  public int g = 0;
  public String h = "";
  public String i = "";
  private HashSet<String> j = new HashSet();
  private List<MatchReg> k = new ArrayList();
  private HashMap<String, ApkInfo> l = new HashMap();
  private HashMap<Integer, String> m = new HashMap();
  
  private ApkInfo a(String paramString1, String paramString2, MatchReg paramMatchReg)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramMatchReg == null) {
        return null;
      }
      int n = paramString2.lastIndexOf("/") + 1;
      if (n < 2) {
        return null;
      }
      String str1 = paramString2.substring(n);
      paramString2 = paramString2.substring(0, n).split("/");
      String[] arrayOfString = str1.split(paramMatchReg.b);
      if ((paramString2.length >= paramMatchReg.c) && (arrayOfString.length >= paramMatchReg.f))
      {
        String str2 = paramString2[paramMatchReg.d];
        if (paramMatchReg.e > -1) {
          paramString2 = paramString2[paramMatchReg.e];
        } else {
          paramString2 = "";
        }
        if (paramMatchReg.g > -1) {
          str1 = arrayOfString[paramMatchReg.g];
        } else {
          str1 = "";
        }
        return new ApkInfo(str2, paramString2, str1, arrayOfString[paramMatchReg.h], paramString1);
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
  
  private void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int i1 = paramJSONArray.length();
      int n = 0;
      while (n < i1)
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(n);
        if (localJSONObject != null)
        {
          String str = localJSONObject.optString("content");
          int i2 = localJSONObject.optInt("type", -1);
          if ((i2 > -1) && (!TextUtils.isEmpty(str))) {
            this.m.put(Integer.valueOf(i2), str);
          }
        }
        n += 1;
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.h = paramJSONObject.optString("title");
      this.i = paramJSONObject.optString("content");
    }
  }
  
  private void b(JSONArray paramJSONArray)
  {
    int i1;
    if (paramJSONArray != null)
    {
      i1 = paramJSONArray.length();
      if (i1 <= 0) {}
    }
    for (;;)
    {
      int n;
      synchronized (this.j)
      {
        this.j.clear();
        n = 0;
        if (n < i1)
        {
          String str = paramJSONArray.optString(n);
          if (TextUtils.isEmpty(str)) {
            break label78;
          }
          this.j.add(str);
          break label78;
        }
        return;
      }
      return;
      label78:
      n += 1;
    }
  }
  
  private void c(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      try
      {
        int i1 = paramJSONArray.length();
        if (i1 > 0)
        {
          int n = 0;
          while (n < i1)
          {
            JSONObject localJSONObject = paramJSONArray.getJSONObject(n);
            MatchReg localMatchReg = new MatchReg();
            localMatchReg.a = localJSONObject.getString("pattern");
            localMatchReg.c = localJSONObject.getInt("path_node_num");
            localMatchReg.d = localJSONObject.getInt("appid_index");
            localMatchReg.e = localJSONObject.optInt("app_name_index", -1);
            localMatchReg.b = localJSONObject.getString("split_name_char");
            localMatchReg.f = localJSONObject.getInt("name_node_num");
            localMatchReg.g = localJSONObject.optInt("channel_index", -1);
            localMatchReg.h = localJSONObject.getInt("pkg_name_index");
            if ((localMatchReg.d < localMatchReg.c) && (localMatchReg.e < localMatchReg.c) && (localMatchReg.g < localMatchReg.f) && (localMatchReg.h < localMatchReg.f)) {
              this.k.add(localMatchReg);
            }
            n += 1;
          }
        }
        return;
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
    }
  }
  
  private void d(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int i1 = paramJSONArray.length();
      if (i1 > 0)
      {
        int n = 0;
        for (;;)
        {
          if (n < i1) {
            try
            {
              Object localObject = paramJSONArray.getJSONObject(n);
              String str1 = ((JSONObject)localObject).getString("url");
              String str2 = ((JSONObject)localObject).getString("appid");
              String str3 = ((JSONObject)localObject).optString("app_name", "");
              String str4 = ((JSONObject)localObject).optString("channel", "");
              String str5 = ((JSONObject)localObject).getString("pkg_name");
              localObject = ((JSONObject)localObject).optString("replace_url", "");
              this.l.put(str1, new ApkInfo(str2, str3, str4, str5, (String)localObject));
              n += 1;
            }
            catch (JSONException paramJSONArray)
            {
              paramJSONArray.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public String a(int paramInt)
  {
    return (String)this.m.get(Integer.valueOf(paramInt));
  }
  
  public HashSet<String> a()
  {
    return this.j;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    try
    {
      paramString = new JSONObject(new JSONObject(paramString).optString(this.a));
      this.c = paramString.optString("download_mgr_url", "https://speed.gamecenter.qq.com/pushgame/v1/downloadadmin");
      this.d = paramString.optInt("x5_log_seed", -1);
      this.f = paramString.optInt("clearFileSwitch", 0);
      this.e = paramString.optInt("authDialog", 0);
      this.g = paramString.optInt("dcReportType", 0);
      a(paramString.optJSONArray("tips_pre_info"));
      b(paramString.optJSONArray("websso_cmds"));
      a(paramString.optJSONObject("float_window_info"));
      paramString = paramString.optJSONObject("url_match_rule");
      if (paramString != null)
      {
        c(paramString.optJSONArray("reg_list"));
        d(paramString.optJSONArray("replace_list"));
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public ApkInfo b(String paramString)
  {
    Object localObject2;
    try
    {
      Object localObject1 = (ApkInfo)this.l.get(paramString);
      localObject3 = localObject1;
      if (localObject1 != null) {
        break label131;
      }
      localObject2 = localObject1;
      try
      {
        Iterator localIterator = this.k.iterator();
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
          Matcher localMatcher = Pattern.compile(localMatchReg.a).matcher(paramString);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig
 * JD-Core Version:    0.7.0.1
 */