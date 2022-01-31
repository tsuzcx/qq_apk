package com.tencent.mobileqq.ark;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ArkMsgJsonParseUtils
{
  public static String a;
  protected static List a;
  protected static List b = new ArrayList();
  protected static List c = new ArrayList();
  protected static List d = new ArrayList();
  protected static List e = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "ArkMsgJsonParseUtils";
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static List a()
  {
    c.clear();
    int i = 0;
    while (i < b.size())
    {
      String str = (String)b.get(i);
      if (!TextUtils.isEmpty(str))
      {
        boolean bool1 = str.trim().toLowerCase().startsWith("http:");
        boolean bool2 = str.trim().toLowerCase().startsWith("https:");
        if ((bool1) || (bool2)) {
          c.add(str.trim());
        }
      }
      i += 1;
    }
    return c;
  }
  
  public static List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool2;
    String str2;
    String str1;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool1 = paramString.trim().toLowerCase().startsWith("http:");
      bool2 = paramString.trim().toLowerCase().startsWith("https:");
      if ((bool1) || (bool2))
      {
        str2 = Uri.parse(paramString).getHost();
        if (!TextUtils.isEmpty(str2)) {
          localArrayList.add(str2);
        }
        if (!bool1) {
          break label283;
        }
        if (!paramString.trim().toLowerCase().startsWith("http://")) {
          break label224;
        }
        str1 = paramString.replaceFirst("(?i)http://", "");
        if (!TextUtils.isEmpty(str2)) {
          break label390;
        }
        paramString = str1;
        if (!TextUtils.isEmpty(str1))
        {
          i = str1.indexOf("/");
          if (i == -1) {
            break label377;
          }
          str2 = str1.substring(0, i);
          localArrayList.add(str2);
          label157:
          paramString = str1;
          if (!TextUtils.isEmpty(str2)) {}
        }
      }
    }
    label390:
    for (paramString = str1.replaceFirst(str2, "");; paramString = str1.replaceFirst(str2, ""))
    {
      str1 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        i = paramString.indexOf("?");
        str1 = paramString;
        if (i != -1) {
          str1 = paramString.substring(0, i);
        }
      }
      localArrayList.add(str1);
      return localArrayList;
      label224:
      if (paramString.trim().toLowerCase().startsWith("http:/"))
      {
        str1 = paramString.replaceFirst("(?i)http:/", "");
        break;
      }
      str1 = paramString;
      if (!paramString.trim().toLowerCase().startsWith("http:")) {
        break;
      }
      str1 = paramString.replaceFirst("(?i)http:", "");
      break;
      label283:
      str1 = paramString;
      if (!bool2) {
        break;
      }
      if (paramString.trim().toLowerCase().startsWith("https://"))
      {
        str1 = paramString.replaceFirst("(?i)https://", "");
        break;
      }
      if (paramString.trim().toLowerCase().startsWith("https:/"))
      {
        str1 = paramString.replaceFirst("(?i)https:/", "");
        break;
      }
      str1 = paramString;
      if (!paramString.trim().toLowerCase().startsWith("https:")) {
        break;
      }
      str1 = paramString.replaceFirst("(?i)https:", "");
      break;
      label377:
      localArrayList.add("");
      break label157;
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilList.clear();
    b.clear();
    d.clear();
    e.clear();
    c.clear();
  }
  
  public static void a(String paramString)
  {
    
    try
    {
      paramString = new JSONTokener(paramString).nextValue();
      if ((paramString instanceof JSONObject))
      {
        a((JSONObject)paramString);
        return;
      }
      if ((paramString instanceof JSONArray))
      {
        a((JSONArray)paramString);
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "parseJeson e=" + paramString);
      }
    }
  }
  
  public static void a(JSONArray paramJSONArray)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i < paramJSONArray.length())
        {
          localObject = paramJSONArray.get(i);
          if ((localObject instanceof JSONObject)) {
            a((JSONObject)localObject);
          } else if ((localObject instanceof JSONArray)) {
            a((JSONArray)localObject);
          }
        }
      }
      catch (JSONException paramJSONArray)
      {
        paramJSONArray.printStackTrace();
      }
      return;
      if ((localObject instanceof String)) {
        b.add((String)localObject);
      }
      i += 1;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      jdField_a_of_type_JavaUtilList.add(str);
      Object localObject;
      try
      {
        localObject = paramJSONObject.get(str);
        if (!(localObject instanceof JSONObject)) {
          break label69;
        }
        a((JSONObject)paramJSONObject.get(str));
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      continue;
      label69:
      if ((localObject instanceof JSONArray)) {
        a((JSONArray)localObject);
      } else if ((localObject instanceof String)) {
        b.add((String)paramJSONObject.get(localJSONException));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkMsgJsonParseUtils
 * JD-Core Version:    0.7.0.1
 */