import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.wadl.WadlJsBridgeCall.1;
import com.tencent.open.wadl.WadlJsBridgeDownloadInfo;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bcki
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected final String a;
  
  public bcki()
  {
    this.jdField_a_of_type_JavaLangString = "WadlJsBridgeCall";
  }
  
  private void a(WadlParams paramWadlParams)
  {
    bckd.a("WadlJsBridgeCall", 2, "dispatch wadlParams:" + paramWadlParams);
    switch (paramWadlParams.jdField_b_of_type_Int)
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      return;
    case 2: 
    case 12: 
      bgsw.a().a(paramWadlParams);
      return;
    case 3: 
    case 10: 
      bgsw.a().a(paramWadlParams.d, paramWadlParams.jdField_a_of_type_JavaLangString);
      return;
    case 4: 
      bgsw.a().b(paramWadlParams.d, paramWadlParams.jdField_a_of_type_JavaLangString);
      return;
    }
    bgsw.a().b(paramWadlParams);
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, new Boolean(true));
    jdField_a_of_type_AndroidOsHandler.postDelayed(new WadlJsBridgeCall.1(paramString), 2000L);
  }
  
  private void a(List<WadlJsBridgeDownloadInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((WadlJsBridgeDownloadInfo)paramList.next()).jdField_a_of_type_JavaLangString);
    }
    if (localArrayList.size() > 0) {
      bgsw.a().a(localArrayList);
    }
  }
  
  public static boolean a(String paramString)
  {
    paramString = (Boolean)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  private void b()
  {
    bgsw.a().b();
  }
  
  public static void b(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, new Boolean(false));
  }
  
  public int a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    bckd.b("WadlJsBridgeCall", "doDownloadAction params:" + paramString1 + ",fromWeb:" + paramBoolean + ",from:" + paramInt + ",weburl:" + paramString2);
    WadlParams localWadlParams = new WadlParams(paramString1);
    if (localWadlParams.jdField_b_of_type_Boolean) {
      localWadlParams.a(1);
    }
    if (paramInt != 0)
    {
      localWadlParams.d = paramInt;
      localWadlParams.n = paramString2;
    }
    if ((paramInt == 1) || (paramInt == 2))
    {
      localWadlParams.b(8);
      if ((paramInt == 1) && (!localWadlParams.jdField_b_of_type_Boolean)) {
        localWadlParams.b(4);
      }
    }
    paramString2 = localWadlParams.jdField_a_of_type_JavaLangString;
    paramInt = localWadlParams.jdField_b_of_type_Int;
    if (paramBoolean) {}
    try
    {
      if (localWadlParams.jdField_a_of_type_Boolean)
      {
        yez.c(paramString2, "DELAY_LIST");
        yez.a(paramString2, paramString1, "DELAY_APPID_DETAIL_");
        yev.a();
        return 0;
      }
      if (!localWadlParams.jdField_b_of_type_Boolean)
      {
        yez.b(paramString2, "DELAY_LIST");
        yez.d(paramString2, "DELAY_APPID_DETAIL_");
      }
      if (localWadlParams.jdField_b_of_type_Boolean)
      {
        if (a(localWadlParams.g))
        {
          bckd.b("WadlJsBridgeCall", "##@Operation for wadlParams.resName:" + localWadlParams.g + " is not returned! The opertion of action: " + paramInt + " is ignored!");
          return 1;
        }
        a(localWadlParams.g);
      }
      while ((TextUtils.isEmpty(localWadlParams.jdField_b_of_type_JavaLangString)) && (!localWadlParams.jdField_b_of_type_Boolean))
      {
        yez.a(null, "558", "202982", paramString2, "55801", "4", "430");
        bckd.b("WadlJsBridgeCall", "invalid url:" + localWadlParams);
        return -1;
        if (a(paramString2))
        {
          bckd.b("WadlJsBridgeCall", "##@Operation for appid:" + paramString2 + " is not returned! The opertion of action: " + paramInt + " is ignored!");
          return 1;
        }
        a(paramString2);
      }
      a(localWadlParams);
    }
    catch (Exception paramString1)
    {
      bckd.a("WadlJsBridgeCall", "doDownloadAction:", paramString1);
      return -1;
    }
    return 0;
  }
  
  public void a()
  {
    try
    {
      b();
      return;
    }
    catch (Exception localException)
    {
      bckd.a("WadlJsBridgeCall", "getQueryAllTask()>>>", localException);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    WadlParams localWadlParams = new WadlParams();
    try
    {
      localWadlParams.a(paramString2);
      bgsw.a().c(paramInt, paramString1);
      return;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONArray(paramString1);
      int j = paramString1.length();
      paramString2 = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString1.getJSONObject(i);
        WadlJsBridgeDownloadInfo localWadlJsBridgeDownloadInfo = new WadlJsBridgeDownloadInfo();
        localWadlJsBridgeDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("appid");
        localWadlJsBridgeDownloadInfo.h = localJSONObject.optString("myAppId");
        localWadlJsBridgeDownloadInfo.i = localJSONObject.optString("apkId");
        localWadlJsBridgeDownloadInfo.c = localJSONObject.optString("packageName");
        localWadlJsBridgeDownloadInfo.jdField_b_of_type_Int = localJSONObject.optInt("versionCode");
        paramString2.add(localWadlJsBridgeDownloadInfo);
        i += 1;
      }
      a(paramString2);
      return;
    }
    catch (JSONException paramString1)
    {
      bckd.a("WadlJsBridgeCall", "getQueryDownloadAction(String,String)>>>", paramString1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    bckd.b("WadlJsBridgeCall", "startDownload delay task" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (1 == paramInt) {
      a(paramString, false, 1, "YUYUE");
    }
    while (2 != paramInt) {
      return;
    }
    a(paramString, false, 2, "YANCHI");
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      bgsw.a().a(paramString);
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("infolist");
      ((JSONObject)localObject).getString("guid");
      int j = paramString.length();
      localObject = new ArrayList();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        WadlJsBridgeDownloadInfo localWadlJsBridgeDownloadInfo = new WadlJsBridgeDownloadInfo();
        localWadlJsBridgeDownloadInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("appid");
        localWadlJsBridgeDownloadInfo.h = localJSONObject.optString("myAppId");
        localWadlJsBridgeDownloadInfo.i = localJSONObject.optString("apkId");
        localWadlJsBridgeDownloadInfo.c = localJSONObject.optString("packageName");
        localWadlJsBridgeDownloadInfo.jdField_b_of_type_Int = localJSONObject.optInt("versionCode");
        ((List)localObject).add(localWadlJsBridgeDownloadInfo);
        i += 1;
      }
      a((List)localObject);
      return;
    }
    catch (Exception paramString)
    {
      bckd.a("WadlJsBridgeCall", "query getQueryDownloadAction>>>", paramString);
    }
  }
  
  public void e(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.getString("via");
      paramString.getString("guid");
      c(str);
      return;
    }
    catch (Exception paramString)
    {
      bckd.a("WadlJsBridgeCall", "query getQueryDownloadActionByVia>>>", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcki
 * JD-Core Version:    0.7.0.1
 */