import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdAppProxy.AppDownloadListener;
import cooperation.wadl.ipc.WadlParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

@ProxyService(proxy=ThirdAppProxy.class)
public class bjgg
  extends ThirdAppProxy
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bldr jdField_a_of_type_Bldr = new bjgh(this);
  private bldu jdField_a_of_type_Bldu;
  private HashMap<String, ThirdAppProxy.AppDownloadListener> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private HashMap<String, AsyncResult> b = new HashMap();
  private HashMap<String, AsyncResult> c = new HashMap();
  private HashMap<String, List<AsyncResult>> d = new HashMap();
  private HashMap<String, JSONObject> e = new HashMap();
  private HashMap<String, WadlParams> f = new HashMap();
  private HashMap<String, Integer> g = new HashMap();
  
  private WadlParams a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      WadlParams localWadlParams = new WadlParams();
      localWadlParams.l = "SmallGame";
      localWadlParams.c = "10036618";
      localWadlParams.d = 6;
      localWadlParams.jdField_e_of_type_JavaLangString = paramJSONObject.optString("android_download_url");
      localWadlParams.a = paramJSONObject.optString("appid");
      localWadlParams.jdField_e_of_type_Int = paramJSONObject.optInt("version_code");
      localWadlParams.f = paramJSONObject.optString("pkg_name");
      localWadlParams.j = paramJSONObject.optString("app_name");
      localWadlParams.k = paramJSONObject.optString("app_icon");
      localWadlParams.m = "interrupt";
      return localWadlParams;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.i("ThirdAppProxyImpl", 1, "createWadlParams exception happend:", paramJSONObject);
    }
    return null;
  }
  
  public void a(String paramString, ThirdAppProxy.AppDownloadListener paramAppDownloadListener)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramAppDownloadListener);
  }
  
  public void init()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Bldu = new bldu();
    this.jdField_a_of_type_Bldu.a(this.jdField_a_of_type_Bldr);
  }
  
  public boolean installApp(String paramString, AsyncResult paramAsyncResult)
  {
    if ((this.jdField_a_of_type_Bldu == null) || (TextUtils.isEmpty(paramString)) || (paramAsyncResult == null)) {
      return false;
    }
    WadlParams localWadlParams2 = a((JSONObject)this.e.get(paramString));
    WadlParams localWadlParams1 = localWadlParams2;
    if (localWadlParams2 == null) {
      localWadlParams1 = (WadlParams)this.f.get(paramString);
    }
    if (localWadlParams1 == null)
    {
      paramAsyncResult.onReceiveResult(false, null);
      return false;
    }
    localWadlParams1.b(2);
    localWadlParams1.b = 5;
    this.jdField_a_of_type_Bldu.b(localWadlParams1);
    paramAsyncResult.onReceiveResult(true, null);
    return true;
  }
  
  public void queryApkDownloadInfo(String paramString, AsyncResult paramAsyncResult)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramAsyncResult == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new bjgi(this, paramString, paramAsyncResult);
    blec.a().a(paramString);
    blec.a().a("10036618", localArrayList);
  }
  
  public void queryDownloadTask(String paramString, AsyncResult paramAsyncResult)
  {
    if (paramAsyncResult == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Bldu == null) || (TextUtils.isEmpty(paramString))) {
        paramAsyncResult.onReceiveResult(false, null);
      }
      this.b.put(paramString, paramAsyncResult);
      paramAsyncResult = new ArrayList();
      paramAsyncResult.add(paramString);
    } while (this.jdField_a_of_type_Bldu == null);
    this.jdField_a_of_type_Bldu.a(paramAsyncResult);
  }
  
  public void startDownload(String paramString, JSONObject paramJSONObject, boolean paramBoolean, ThirdAppProxy.AppDownloadListener paramAppDownloadListener)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJSONObject == null))
    {
      QLog.i("ThirdAppProxyImpl", 1, "startDownload, url is empty!");
      if (paramAppDownloadListener != null) {
        paramAppDownloadListener.onDownloadFailed(-1000, -1, "url is invalid");
      }
      return;
    }
    if (paramAppDownloadListener != null) {
      a(paramString, paramAppDownloadListener);
    }
    for (;;)
    {
      try
      {
        this.e.put(paramString, paramJSONObject);
        paramString = a(paramJSONObject);
        if (paramString == null) {
          break;
        }
        if (!paramBoolean) {
          break label124;
        }
        paramString.b(7);
        paramString.b = 2;
        this.jdField_a_of_type_Bldu.a(paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.i("ThirdAppProxyImpl", 1, "startDownload---exception happend:", paramString);
      }
      if (paramAppDownloadListener == null) {
        break;
      }
      paramAppDownloadListener.onDownloadFailed(-1000, -2, "url is invalid");
      return;
      label124:
      paramString.b(6);
    }
  }
  
  public boolean stopDownloadTask(String paramString)
  {
    if ((this.jdField_a_of_type_Bldu == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    WadlParams localWadlParams = a((JSONObject)this.e.get(paramString));
    if (localWadlParams == null) {
      return false;
    }
    localWadlParams.b(2);
    localWadlParams.b = 3;
    this.jdField_a_of_type_Bldu.a(6, paramString);
    return true;
  }
  
  public void unInit()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = null;
    if (this.jdField_a_of_type_Bldu != null)
    {
      this.jdField_a_of_type_Bldu.b(this.jdField_a_of_type_Bldr);
      this.jdField_a_of_type_Bldu.d();
      this.jdField_a_of_type_Bldu = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgg
 * JD-Core Version:    0.7.0.1
 */