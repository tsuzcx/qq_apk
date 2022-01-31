import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

public class bdcw
{
  private static String a(String paramString)
  {
    return paramString;
  }
  
  public static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("history_chat_msg_search_key", 0).edit();
    localEditor.remove(a(paramString));
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    int j = 0;
    if ((paramString2 == null) || (paramString2.length() == 0)) {
      return;
    }
    Object localObject1 = paramString2.toLowerCase();
    String str1 = a(paramString1);
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("history_chat_msg_search_key", 0);
    paramString1 = localSharedPreferences.getString(str1, "");
    if (QLog.isColorLevel()) {
      QLog.d("HistoryChatMsgSearchKeyUtil", 2, "in storeKeyword(),content is:" + paramString1 + ",keyword is:" + paramString2);
    }
    int i;
    if ((paramString1 != null) && (paramString1.trim().length() > 0))
    {
      try
      {
        localObject2 = new JSONArray(paramString1);
        HashMap localHashMap = new HashMap();
        k = ((JSONArray)localObject2).length();
        paramString1 = new ArrayList();
        i = 0;
        if (i < k)
        {
          String str2 = ((JSONArray)localObject2).optString(i, "");
          if ((str2 == null) || (str2.length() <= 0)) {
            break label506;
          }
          paramString1.add(str2);
          break label506;
        }
        k = paramString1.size();
        i = 0;
        while (i < k)
        {
          localHashMap.put(((String)paramString1.get(i)).toLowerCase(), Integer.valueOf(i));
          i += 1;
        }
        localObject2 = (Integer)localHashMap.get(localObject1);
        if (localObject2 != null) {
          break label359;
        }
        j = k - 10 + 1;
        i = j;
        if (j < 0) {
          i = 0;
        }
        localObject1 = new JSONArray();
        while (i < k)
        {
          ((JSONArray)localObject1).put((String)paramString1.get(i));
          i += 1;
        }
        ((JSONArray)localObject1).put(paramString2);
        paramString1 = ((JSONArray)localObject1).toString();
      }
      catch (JSONException paramString1)
      {
        for (;;)
        {
          Object localObject2;
          int k;
          label302:
          label359:
          int m;
          if (QLog.isColorLevel()) {
            QLog.d("HistoryChatMsgSearchKeyUtil", 2, "storeKeyword(),parse string failed,error msg is:" + paramString1.getMessage(), paramString1);
          }
          paramString1 = new JSONArray();
          paramString1.put(paramString2);
          paramString1 = paramString1.toString();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("HistoryChatMsgSearchKeyUtil", 2, "lastSaveContent is:" + paramString1);
      }
      paramString2 = localSharedPreferences.edit();
      paramString2.putString(str1, paramString1);
      paramString2.commit();
      return;
      localObject1 = new JSONArray();
      m = ((Integer)localObject2).intValue();
      i = j;
    }
    for (;;)
    {
      if (i < k)
      {
        localObject2 = (String)paramString1.get(i);
        if (i != m) {
          ((JSONArray)localObject1).put(localObject2);
        }
      }
      else
      {
        ((JSONArray)localObject1).put(paramString2);
        paramString1 = ((JSONArray)localObject1).toString();
        break label302;
        paramString1 = new JSONArray();
        paramString1.put(paramString2);
        paramString1 = paramString1.toString();
        break label302;
        label506:
        i += 1;
        break;
      }
      i += 1;
    }
  }
  
  public static String[] a(String paramString)
  {
    paramString = a(paramString);
    paramString = BaseApplication.getContext().getSharedPreferences("history_chat_msg_search_key", 0).getString(paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("HistoryChatMsgSearchKeyUtil", 2, "in getKeywords(),content is:" + paramString);
    }
    if ((paramString != null) && (paramString.trim().length() > 0)) {}
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = paramString.length();
        ArrayList localArrayList = new ArrayList(i);
        if (i >= 0)
        {
          String str = paramString.optString(i, "");
          if ((str == null) || (str.length() <= 0)) {
            break label177;
          }
          localArrayList.add(str);
          break label177;
        }
        paramString = (String[])localArrayList.toArray(new String[0]);
        return paramString;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HistoryChatMsgSearchKeyUtil", 2, "getKeywords(),parse string failed,error msg is:" + paramString.getMessage(), paramString);
        }
        return null;
      }
      return null;
      label177:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcw
 * JD-Core Version:    0.7.0.1
 */