import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class axws
{
  public static int a(String paramString1, String paramString2)
  {
    return ((Integer)a(paramString1, "nearby_event_file", 4, paramString2, Integer.valueOf(0))).intValue();
  }
  
  public static SharedPreferences a(String paramString1, String paramString2, int paramInt)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + paramString2, paramInt);
  }
  
  public static SosoInterface.SosoLbsInfo a(String paramString)
  {
    try
    {
      paramString = new JSONObject((String)a(paramString, "key_nearby_loc", ""));
      if ((paramString.has("lat")) && (paramString.has("lon")))
      {
        SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
        localSosoLbsInfo.a = new SosoInterface.SosoLocation();
        localSosoLbsInfo.a.a = paramString.getDouble("lat");
        localSosoLbsInfo.a.b = paramString.getDouble("lon");
        return localSosoLbsInfo;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbySPUtil", 2, "getNearbyLastLocation exp:" + paramString.toString());
      }
    }
    return null;
  }
  
  public static Object a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    Object localObject3;
    if ((paramSharedPreferences == null) || (TextUtils.isEmpty(paramString)) || (paramObject == null))
    {
      localObject3 = paramObject;
      return localObject3;
    }
    for (;;)
    {
      try
      {
        if (paramObject.getClass() != Boolean.class) {
          continue;
        }
        boolean bool = paramSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue());
        localObject1 = Boolean.valueOf(bool);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        axxb.a("getValue", new Object[] { localThrowable });
        Object localObject2 = paramObject;
        continue;
      }
      localObject3 = localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      axxb.a("getValue", new Object[] { paramSharedPreferences, paramString, paramObject, localObject1, paramObject.getClass() });
      return localObject1;
      if (paramObject.getClass() == Integer.class) {
        localObject1 = Integer.valueOf(paramSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
      } else if (paramObject.getClass() == Long.class) {
        localObject1 = Long.valueOf(paramSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
      } else if (paramObject.getClass() == Float.class) {
        localObject1 = Float.valueOf(paramSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue()));
      } else if (paramObject.getClass() == String.class) {
        localObject1 = paramSharedPreferences.getString(paramString, (String)paramObject);
      } else {
        localObject1 = paramObject;
      }
    }
  }
  
  public static Object a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    if (((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.isEmpty(paramString3)) || (paramObject == null) || (!a(paramInt))) {
      paramString2 = paramObject;
    }
    for (;;)
    {
      return paramString2;
      String str1 = paramString1;
      if (paramString1 == null) {
        str1 = "";
      }
      String str2 = paramString2;
      if (paramString2 == null) {
        str2 = "";
      }
      try
      {
        paramString1 = a(a(str2, str1, paramInt), paramString3, paramObject);
        paramString2 = paramString1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        axxb.a("getValue", new Object[] { str1, str2, paramString3, paramObject, paramString1, paramObject.getClass() });
        return paramString1;
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            axxb.a("getValue", new Object[] { paramString1 });
          }
          paramString1 = paramObject;
        }
      }
    }
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramObject;
    }
    return a(paramString1, "NEARBY_FLAG_SP", 4, paramString2, paramObject);
  }
  
  public static String a()
  {
    return a("nearby_url_params", BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getString("nearby_tab_url_params", "");
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramString.optString(str1);
        localStringBuilder.append("&");
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str2);
      }
      return localStringBuilder.toString();
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONObject localJSONObject = paramJSONObject1;
    if (paramJSONObject1 == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject1 = paramJSONObject2;
    if (paramJSONObject2 == null) {
      paramJSONObject1 = new JSONObject();
    }
    paramJSONObject2 = paramJSONObject1.keys();
    while (paramJSONObject2.hasNext())
    {
      String str1 = (String)paramJSONObject2.next();
      String str2 = paramJSONObject1.optString(str1);
      if ((TextUtils.isEmpty(str2)) || (str2.equals("null"))) {
        localJSONObject.remove(str1);
      } else {
        try
        {
          localJSONObject.put(str1, str2);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return localJSONObject;
  }
  
  public static void a(String paramString)
  {
    a(paramString, "key_nearby_red_dot_corner_text", "");
    a(paramString, "key_nearby_red_dot_assist_text", "");
  }
  
  public static void a(String paramString, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo == null) || (paramSosoLbsInfo.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("NearbySPUtil", 2, "setNearbyLastLocation, null return, sosoInfo=" + paramSosoLbsInfo);
      }
    }
    do
    {
      return;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("lat", paramSosoLbsInfo.a.a);
        localJSONObject.put("lon", paramSosoLbsInfo.a.b);
        a(paramString, "key_nearby_loc", localJSONObject.toString());
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("NearbySPUtil", 2, "setNearbyLastLocation exp:" + paramString.toString());
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean a(SharedPreferences paramSharedPreferences, String paramString, Object paramObject)
  {
    boolean bool2;
    if ((paramSharedPreferences == null) || (TextUtils.isEmpty(paramString)) || (paramObject == null)) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      try
      {
        SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
        if (paramObject.getClass() == Boolean.class) {
          localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        }
        for (;;)
        {
          bool1 = localEditor.commit();
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          axxb.a("setValue", new Object[] { paramSharedPreferences, paramString, paramObject, Boolean.valueOf(bool1), paramObject.getClass() });
          return bool1;
          if (paramObject.getClass() != Integer.class) {
            break label165;
          }
          localEditor.putInt(paramString, ((Integer)paramObject).intValue());
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            axxb.a("setValue", new Object[] { localThrowable });
          }
          boolean bool1 = false;
          continue;
          label165:
          if (paramObject.getClass() == Long.class) {
            localThrowable.putLong(paramString, ((Long)paramObject).longValue());
          } else if (paramObject.getClass() == Float.class) {
            localThrowable.putFloat(paramString, ((Float)paramObject).floatValue());
          } else if (paramObject.getClass() == String.class) {
            localThrowable.putString(paramString, (String)paramObject);
          }
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    return ((Boolean)a(paramString, BaseApplicationImpl.getApplication().getResources().getString(2131694425), Boolean.valueOf(false))).booleanValue();
  }
  
  public static boolean a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      bool = a("NEARBY_FLAG_SP", paramString, 4).edit().putLong("vote_count", paramLong).putInt("vote_increment", paramInt).commit();
      if (QLog.isColorLevel()) {
        axxb.a("setVoteInfo", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          axxb.a("setVoteInfo", new Object[] { localThrowable });
        }
        boolean bool = false;
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return a(paramString1, "NEARBY_FLAG_SP", 4, paramString2);
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    boolean bool2;
    if (((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.isEmpty(paramString3)) || (!a(paramInt))) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      try
      {
        bool1 = a(paramString1, str, paramInt).contains(paramString3);
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        axxb.a("contains", new Object[] { str, paramString1, paramString3 });
        return bool1;
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            axxb.a("contains", new Object[] { paramString2 });
          }
          boolean bool1 = false;
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject)
  {
    boolean bool2;
    if (((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) || (TextUtils.isEmpty(paramString3)) || (paramObject == null) || (!a(paramInt))) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      try
      {
        bool1 = a(a(paramString1, str, paramInt), paramString3, paramObject);
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        axxb.a("setValue", new Object[] { str, paramString3, paramObject, Boolean.valueOf(bool1), paramObject.getClass() });
        return bool1;
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            axxb.a("setValue", new Object[] { paramString1 });
          }
          boolean bool1 = false;
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    return a(paramString1, "NEARBY_FLAG_SP", 4, paramString2, paramObject);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a(paramString, BaseApplicationImpl.getApplication().getResources().getString(2131694425), Boolean.valueOf(paramBoolean));
  }
  
  public static String b()
  {
    return a("sp_nearby_live_tab_url_params", BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4).getString("nearby_live_tab_url_params", "");
  }
  
  public static void b(String paramString)
  {
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i = paramString.getInt("key_preload_fail_count", 0) + 1;
      paramString.edit().putInt("key_preload_fail_count", i).commit();
      if (QLog.isColorLevel()) {
        axxb.a("preloadNearbyprocessStart", new Object[] { "key_preload_fail_count", Integer.valueOf(i) });
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      bool = ((Boolean)a(paramString, BaseApplicationImpl.getApplication().getResources().getString(2131694433), Boolean.valueOf(false))).booleanValue();
      if (QLog.isColorLevel()) {
        axxb.a("getLocVisiblityForPeople", new Object[] { paramString, Boolean.valueOf(bool) });
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          axxb.a("getLocVisiblityForPeople", new Object[] { localThrowable });
        }
        boolean bool = false;
      }
    }
  }
  
  public static boolean b(String paramString, boolean paramBoolean)
  {
    try
    {
      String str = BaseApplicationImpl.getApplication().getResources().getString(2131694433);
      SharedPreferences.Editor localEditor = a("NEARBY_FLAG_SP", paramString, 4).edit();
      localEditor.putBoolean(str, paramBoolean);
      if (!paramBoolean) {
        localEditor.putLong("nearby_enter_time", 0L).commit();
      }
      bool = localEditor.commit();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          axxb.a("setVisibilityForPeople", new Object[] { localThrowable });
        }
        boolean bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      axxb.a("setVisibilityForPeople", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public static void c(String paramString)
  {
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i = paramString.getInt("key_preload_unhit_count", 0) + 1;
      paramString.edit().putInt("key_preload_fail_count", 0).putInt("key_preload_unhit_count", i).commit();
      if (QLog.isColorLevel()) {
        axxb.a("preloadNearbyProcessSuc", new Object[] { "key_preload_unhit_count", Integer.valueOf(i) });
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean c(String paramString)
  {
    return ((Boolean)a(paramString, "key_notify_switch_state", Boolean.valueOf(true))).booleanValue();
  }
  
  public static void d(String paramString)
  {
    try
    {
      a("nearby_process_preload_file", paramString, 4).edit().putInt("key_preload_fail_count", 0).putInt("key_preload_unhit_count", 0).commit();
      if (QLog.isColorLevel()) {
        axxb.a("enterNearbyProcess", new Object[0]);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static boolean d(String paramString)
  {
    return ((Boolean)a(paramString, "dating_recv_msg", Boolean.valueOf(true))).booleanValue();
  }
  
  public static void e(String paramString)
  {
    SharedPreferences localSharedPreferences = a("nearby_url_params", BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
    if (!TextUtils.isEmpty(paramString))
    {
      localSharedPreferences.edit().putString("nearby_tab_url_params", paramString).apply();
      if (QLog.isColorLevel()) {
        axxb.a("saveNearbyTabUrlParams", new Object[] { paramString });
      }
    }
  }
  
  public static boolean e(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = a("nearby_process_preload_file", paramString, 4);
      int i = paramString.getInt("key_preload_fail_count", 0);
      int j = paramString.getInt("key_preload_unhit_count", 0);
      bool1 = bool2;
      if (i < 2)
      {
        bool1 = bool2;
        if (j < 2) {
          bool1 = true;
        }
      }
      paramString.printStackTrace();
    }
    catch (Throwable paramString)
    {
      try
      {
        if (QLog.isColorLevel()) {
          axxb.a("checkPreload", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        }
        return bool1;
      }
      catch (Throwable paramString)
      {
        boolean bool1;
        break label87;
      }
      paramString = paramString;
      bool1 = true;
    }
    label87:
    return bool1;
  }
  
  public static void f(String paramString)
  {
    SharedPreferences localSharedPreferences = a("sp_nearby_live_tab_url_params", BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
    if (!TextUtils.isEmpty(paramString))
    {
      localSharedPreferences.edit().putString("nearby_live_tab_url_params", paramString).apply();
      if (QLog.isColorLevel()) {
        axxb.a("saveLiveTabWebViewUrlParam", new Object[] { paramString });
      }
    }
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool2 = ((Boolean)a(paramString, "nearby_need_show_guide", Boolean.valueOf(false))).booleanValue();
    boolean bool3 = ((Boolean)a(paramString, "sp_key_user_skip_guide", Boolean.valueOf(false))).booleanValue();
    if ((true == bool2) && (!bool3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        axxb.a("isNeedNearbyShowGuide", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axws
 * JD-Core Version:    0.7.0.1
 */