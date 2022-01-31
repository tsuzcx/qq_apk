import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.open.appcommon.now.download.js.DownloadCallbackWebImpl.1;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bdfz
  implements bdfy
{
  protected static bdfz a;
  protected Handler a;
  
  protected bdfz()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static bdfz a()
  {
    if (jdField_a_of_type_Bdfz == null) {
      jdField_a_of_type_Bdfz = new bdfz();
    }
    return jdField_a_of_type_Bdfz;
  }
  
  protected String a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("nettype", paramInt);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        bdht.c("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", localJSONException);
      }
    }
  }
  
  protected String a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4, int paramInt5)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt1);
      localJSONObject.put("pro", paramInt2);
      localJSONObject.put("ismyapp", paramInt3);
      localJSONObject.put("errorMsg", paramString3);
      localJSONObject.put("errorCode", paramInt4);
      localJSONObject.put("writecodestate", paramInt5);
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        bdht.c("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", paramString1);
      }
    }
  }
  
  protected String a(String paramString1, int paramInt, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("packagename", paramString2);
      localJSONObject.put("appid", paramString1);
      localJSONObject.put("state", paramInt);
      localJSONObject.put("pro", 0);
      return localJSONObject.toString();
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        bdht.c("DownloadCallbackWebImpl", "getCallBackJsonObject >>> ", paramString1);
      }
    }
  }
  
  public JSONObject a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appid", paramDownloadInfo.jdField_c_of_type_JavaLangString);
      localJSONObject.put("state", paramDownloadInfo.a());
      localJSONObject.put("pro", paramDownloadInfo.f);
      localJSONObject.put("packagename", paramDownloadInfo.e);
      localJSONObject.put("ismyapp", paramDownloadInfo.jdField_c_of_type_Int);
      localJSONObject.put("download_from", paramDownloadInfo.jdField_h_of_type_Int);
      localJSONObject.put("realDownloadType", paramDownloadInfo.jdField_d_of_type_Int);
      localJSONObject.put("via", paramDownloadInfo.jdField_h_of_type_JavaLangString);
      localJSONObject.put("writecodestate", paramDownloadInfo.j);
      localJSONObject.put("extraInfo", paramDownloadInfo.o);
      localJSONObject.put("isAutoInstallBySDK", paramDownloadInfo.jdField_d_of_type_Boolean);
      localJSONObject.put("queryResult", paramInt);
      return localJSONObject;
    }
    catch (JSONException paramDownloadInfo)
    {
      bdht.c("DownloadCallbackWebImpl", "onNetworkConnect " + paramDownloadInfo.getMessage(), paramDownloadInfo);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt)
  {
    a(a(paramInt));
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo, paramInt).toString());
    }
  }
  
  protected void a(String paramString)
  {
    bdgd localbdgd = bdgd.a();
    for (;;)
    {
      int i;
      try
      {
        int j = localbdgd.a().size();
        i = 0;
        if (i < j)
        {
          Object localObject = (bdiy)localbdgd.a().get(i);
          WebView localWebView = ((bdiy)localObject).getWebview();
          if (localWebView != null) {
            if (TextUtils.isEmpty(((bdiy)localObject).getJsCallbackMethod()))
            {
              localObject = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + paramString + ");}void(0);";
              bdht.a("DownloadCallbackWebImpl", " commonJsCallBack >>> " + (String)localObject);
              this.jdField_a_of_type_AndroidOsHandler.post(new DownloadCallbackWebImpl.1(this, localWebView, (String)localObject));
            }
            else
            {
              localObject = "javascript:" + ((bdiy)localObject).getJsCallbackMethod() + "(" + paramString + ")";
              continue;
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramString)
      {
        bdht.c("DownloadCallbackWebImpl", "doJsCallback >>> ", paramString);
      }
      i += 1;
    }
  }
  
  public void a(List<DownloadInfo> paramList) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    a(a(paramString1, 6, paramString2));
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo, -1).toString());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramInt2, paramDownloadInfo.f, paramDownloadInfo.e, paramDownloadInfo.jdField_c_of_type_Int, paramString, paramInt1, paramDownloadInfo.j));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo, -1).toString());
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo, -1).toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList != null)
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put(a((DownloadInfo)paramList.next(), -1));
      }
      a(localJSONArray.toString());
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a(a(paramDownloadInfo, -1).toString());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    a(a(paramString1, 13, paramString2));
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    a(a(paramString1, 9, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdfz
 * JD-Core Version:    0.7.0.1
 */