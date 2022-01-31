import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class anla
{
  private static HashMap<String, anld> a = new HashMap();
  
  static
  {
    a.put("qq", new anlf());
    a.put("tel", new anlh());
    a.put("app", new anlb());
    a.put("mqzone", new anlg());
    a.put("miniapp", new anle());
  }
  
  public static List<Object> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject2 = paramJSONArray.get(i);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = a((JSONArray)localObject2);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = a((JSONObject)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<String, Object> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramJSONObject.get(str);
      Object localObject1;
      if ((localObject2 instanceof JSONArray)) {
        localObject1 = a((JSONArray)localObject2);
      }
      for (;;)
      {
        localHashMap.put(str, localObject1);
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONObject)) {
          localObject1 = a((JSONObject)localObject2);
        }
      }
    }
    return localHashMap;
  }
  
  public static boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    QLog.e("ArkApp", 2, "navigate url: " + paramString1);
    Object localObject = paramString1.split(":");
    if (localObject.length <= 1) {
      return false;
    }
    if (MiniAppLauncher.isMiniAppUrl(paramString1)) {
      try
      {
        i = Integer.parseInt((String)bhsz.b(paramString1.substring(paramString1.indexOf("?") + 1)).get("scene"));
        paramString2 = b();
        MiniAppLauncher.startMiniApp(BaseActivity.sTopActivity, paramString1, i, paramString2, null);
        return true;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          QLog.e("ArkApp", 1, "Ark parse miniapp scene failed.", paramString2);
          int i = 2059;
        }
      }
    }
    localObject = localObject[0];
    anld localanld = (anld)a.get(localObject);
    if (localanld == null) {
      return false;
    }
    localObject = paramString1.substring(((String)localObject).length() + 1);
    paramString1 = (String)localObject;
    if (((String)localObject).startsWith("//")) {
      paramString1 = ((String)localObject).substring(2);
    }
    localanld.a(paramString1, paramString2, paramJSONObject, paramLong, paramString3);
    return true;
  }
  
  private static EntryModel b()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = (FragmentActivity)localObject;
      if (((FragmentActivity)localObject).getChatFragment() != null)
      {
        localObject = ((FragmentActivity)localObject).getChatFragment().a();
        if ((localObject instanceof TroopChatPie)) {
          return ((BaseChatPie)localObject).a();
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anla
 * JD-Core Version:    0.7.0.1
 */