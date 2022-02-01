import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.wadl.WadlJsBridgeCall.1;
import com.tencent.open.wadl.WadlJsBridgeDownloadInfo;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.Pair;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjqu
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private static Map<String, Boolean> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Activity jdField_a_of_type_AndroidAppActivity;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  
  public bjqu(Activity paramActivity, WebView paramWebView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
  }
  
  private void a(WadlParams paramWadlParams)
  {
    bjqp.a("WadlJsBridgeCall", 2, "dispatchAction wadlParams:" + paramWadlParams);
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
      bmqk.a().a(paramWadlParams);
      if (this.jdField_a_of_type_AndroidAppActivity == null) {
        break;
      }
    }
    for (Object localObject = this.jdField_a_of_type_AndroidAppActivity.getIntent();; localObject = null)
    {
      Pair localPair = abuf.a((Intent)localObject);
      if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getUrl();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          localObject = this.jdField_a_of_type_ComTencentSmttSdkWebView.getOriginalUrl();
        }
      }
      for (;;)
      {
        abuf.a(null, "558", "205906", paramWadlParams.jdField_a_of_type_JavaLangString, "55801", "4", "430", new String[] { String.valueOf(localPair.first), (String)localPair.second, paramWadlParams.c, paramWadlParams.e, localObject });
        return;
        bmqk.a().a(paramWadlParams.d, paramWadlParams.jdField_a_of_type_JavaLangString);
        return;
        bmqk.a().b(paramWadlParams.d, paramWadlParams.jdField_a_of_type_JavaLangString);
        return;
        bmqk.a().b(paramWadlParams);
        return;
        continue;
        localObject = null;
      }
    }
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
      bmqk.a().a(localArrayList);
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
  
  public static void b(String paramString)
  {
    jdField_a_of_type_JavaUtilMap.put(paramString, new Boolean(false));
  }
  
  public int a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    bjqp.c("WadlJsBridgeCall", "doDownloadAction params:" + paramString1 + ",fromWeb:" + paramBoolean + ",from:" + paramInt + ",weburl:" + paramString2);
    WadlParams localWadlParams = new WadlParams(paramString1);
    if (localWadlParams.jdField_a_of_type_Boolean) {
      localWadlParams.a(1);
    }
    if (paramInt != 0)
    {
      localWadlParams.d = paramInt;
      localWadlParams.m = paramString2;
    }
    if ((paramInt == 1) || (paramInt == 2))
    {
      localWadlParams.b(8);
      if ((paramInt == 1) && (!localWadlParams.jdField_a_of_type_Boolean)) {
        localWadlParams.b(4);
      }
    }
    paramString2 = localWadlParams.jdField_a_of_type_JavaLangString;
    paramInt = localWadlParams.jdField_b_of_type_Int;
    if (paramBoolean) {}
    try
    {
      if (localWadlParams.jdField_b_of_type_Boolean)
      {
        abuf.c(paramString2, "DELAY_LIST");
        abuf.a(paramString2, paramString1, "DELAY_APPID_DETAIL_");
        abub.a();
        return 0;
      }
      if (!localWadlParams.jdField_a_of_type_Boolean)
      {
        abuf.b(paramString2, "DELAY_LIST");
        abuf.d(paramString2, "DELAY_APPID_DETAIL_");
      }
      if (localWadlParams.jdField_a_of_type_Boolean)
      {
        if (a(localWadlParams.h))
        {
          bjqp.c("WadlJsBridgeCall", "##@Operation for wadlParams.resName:" + localWadlParams.h + " is not returned! The opertion of action: " + paramInt + " is ignored!");
          return 1;
        }
        a(localWadlParams.h);
      }
      while ((TextUtils.isEmpty(localWadlParams.e)) && (!localWadlParams.jdField_a_of_type_Boolean))
      {
        abuf.a(null, "558", "202982", paramString2, "55801", "4", "430");
        bjqp.c("WadlJsBridgeCall", "invalid url:" + localWadlParams);
        return -1;
        if (a(paramString2))
        {
          bjqp.c("WadlJsBridgeCall", "##@Operation for appid:" + paramString2 + " is not returned! The opertion of action: " + paramInt + " is ignored!");
          return 1;
        }
        a(paramString2);
      }
      a(localWadlParams);
    }
    catch (Exception paramString1)
    {
      bjqp.a("WadlJsBridgeCall", "doDownloadAction:", paramString1);
      return -1;
    }
    return 0;
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
      bjqp.a("WadlJsBridgeCall", "getQueryDownloadAction(String,String)>>>", paramString1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    bjqp.c("WadlJsBridgeCall", "startDownload delay task" + paramString + " ," + paramBoolean + "," + paramInt + ",isWiFi=" + AppNetConnInfo.isWifiConn());
    if (1 == paramInt) {
      a(paramString, false, 1, "YUYUE");
    }
    while (2 != paramInt) {
      return;
    }
    a(paramString, false, 2, "YANCHI");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjqu
 * JD-Core Version:    0.7.0.1
 */