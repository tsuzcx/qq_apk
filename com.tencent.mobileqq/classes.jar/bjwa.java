import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class bjwa
{
  public static Bundle a(Bundle paramBundle, String paramString)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("key_setting_raw_json", paramString);
    try
    {
      paramString = new JSONObject(paramString);
      i = paramString.getInt("id");
      switch (i)
      {
      case 1: 
        localBundle.putInt("permission_code", 1);
      }
    }
    catch (Exception paramBundle)
    {
      label86:
      Iterator localIterator;
      localBundle.putInt("permission_code", 1);
      localBundle.putString("key_parse_json_status", paramBundle.getMessage());
      paramBundle.printStackTrace();
    }
    paramBundle = "";
    if (paramString.has("msg")) {
      paramBundle = paramString.optString("msg");
    }
    localBundle.putString("key_selected_tag", paramBundle);
    paramBundle = new StringBuilder();
    if (i == 4) {
      paramBundle.append("除了 ");
    }
    paramString = paramString.getJSONObject("uinList");
    Object localObject = new ArrayList();
    localIterator = paramString.keys();
    for (int i = 1;; i = 0)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((ArrayList)localObject).add(str);
        if (i == 0) {
          paramBundle.append("、");
        }
        if (paramBundle.length() >= 15) {
          continue;
        }
        paramBundle.append(paramString.getString(str));
        continue;
        localBundle.putInt("permission_code", 4);
      }
      label404:
      do
      {
        return localBundle;
        localBundle.putInt("permission_code", 64);
        break label404;
        localBundle.putInt("permission_code", 16);
        break label404;
        localBundle.putInt("permission_code", 128);
        break label404;
        localBundle.putInt("permission_code", 9999);
        paramBundle = paramString.optString("question");
        localObject = paramString.optString("answer");
        localBundle.putString("key_question", paramBundle);
        localBundle.putString("key_answer", (String)localObject);
        break label404;
        localBundle.putInt("permission_code", 512);
        break label404;
        paramString = paramBundle.toString();
        paramBundle = paramString;
        if (paramString.length() > 15) {
          paramBundle = paramString.substring(0, 15) + "...";
        }
        localBundle.putStringArrayList("uin_list", (ArrayList)localObject);
        localBundle.putString("key_nicknames", paramBundle);
        return localBundle;
        break;
        if (i == 3) {
          break label86;
        }
      } while (i != 4);
      break label86;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "公开";
    case 1: 
      return "公开";
    case 4: 
      return "好友";
    case 16: 
      return "指定人";
    case 64: 
      return "私密";
    }
    return "指定人";
  }
  
  public static String a(Bundle paramBundle)
  {
    int i = 1;
    int j = 0;
    if (paramBundle == null) {
      return "";
    }
    Object localObject = paramBundle.getString("key_setting_raw_json");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    switch (paramBundle.getInt("permission_code", 1))
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("id", i);
        if ((i == 3) || (i == 4))
        {
          ArrayList localArrayList = paramBundle.getStringArrayList("uin_list");
          paramBundle = paramBundle.getStringArrayList("key_nicknames");
          if ((localArrayList == null) || (localArrayList.isEmpty())) {
            return ((JSONObject)localObject).toString();
          }
          if ((paramBundle == null) || (paramBundle.size() != localArrayList.size())) {
            return ((JSONObject)localObject).toString();
          }
          JSONObject localJSONObject = new JSONObject();
          int k = localArrayList.size();
          i = j;
          while (i < k)
          {
            localJSONObject.put((String)localArrayList.get(i), paramBundle.get(i));
            i += 1;
          }
          ((JSONObject)localObject).put("uinList", localJSONObject);
        }
        for (;;)
        {
          return ((JSONObject)localObject).toString();
          if (i == 5)
          {
            ((JSONObject)localObject).put("question", paramBundle.getString("key_question"));
            ((JSONObject)localObject).put("answer", paramBundle.getString("key_answer"));
          }
        }
        i = 0;
      }
      catch (Exception paramBundle)
      {
        return "";
      }
      continue;
      i = 2;
      continue;
      i = 5;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 6;
    }
  }
  
  public static Bundle b(Bundle paramBundle, String paramString)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("key_setting_raw_json", paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localBundle.putInt("permission_flag", paramString.getInt("flag"));
        paramBundle = "";
        if (paramString.has("msg")) {
          paramBundle = paramString.optString("msg");
        }
        localBundle.putString("key_selected_tag", paramBundle);
        paramBundle = paramString.getJSONObject("uinList");
        ArrayList localArrayList = new ArrayList();
        paramString = paramBundle.keys();
        i = 1;
        if (paramString.hasNext())
        {
          String str = (String)paramString.next();
          localArrayList.add(str);
          if (i == 0) {
            localStringBuilder.append("、");
          }
          if (localStringBuilder.length() < 15) {
            localStringBuilder.append(paramBundle.getString(str));
          }
        }
        else
        {
          paramString = localStringBuilder.toString();
          paramBundle = paramString;
          if (paramString.length() > 15) {
            paramBundle = paramString.substring(0, 15) + "...";
          }
          localBundle.putStringArrayList("uin_list", localArrayList);
          localBundle.putString("key_nicknames", paramBundle);
          return localBundle;
        }
      }
      catch (Exception paramBundle)
      {
        localBundle.putInt("permission_flag", 1);
        localBundle.putString("key_parse_json_status", paramBundle.getMessage());
        paramBundle.printStackTrace();
        return localBundle;
      }
      int i = 0;
    }
  }
  
  public static String b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = paramBundle.getString("key_setting_raw_json");
      localObject1 = localObject2;
    } while (!TextUtils.isEmpty((CharSequence)localObject2));
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("flag", paramBundle.getInt("permission_flag"));
      localObject2 = paramBundle.getStringArrayList("uin_list");
      paramBundle = paramBundle.getStringArrayList("key_nicknames");
      if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
        return ((JSONObject)localObject1).toString();
      }
      if ((paramBundle == null) || (paramBundle.size() != ((ArrayList)localObject2).size())) {
        return ((JSONObject)localObject1).toString();
      }
      JSONObject localJSONObject = new JSONObject();
      int j = ((ArrayList)localObject2).size();
      int i = 0;
      while (i < j)
      {
        localJSONObject.put((String)((ArrayList)localObject2).get(i), paramBundle.get(i));
        i += 1;
      }
      ((JSONObject)localObject1).put("uinList", localJSONObject);
      return ((JSONObject)localObject1).toString();
    }
    catch (Exception paramBundle) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjwa
 * JD-Core Version:    0.7.0.1
 */