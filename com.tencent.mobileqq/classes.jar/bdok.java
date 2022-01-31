import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.open.wadl.WadlJsBridgeCallBack.1;
import com.tencent.open.wadl.WadlJsBridgeCallBack.2;
import com.tencent.smtt.sdk.WebView;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class bdok
  implements bibq, bicg
{
  public static String a;
  protected final int a;
  protected long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bdiy jdField_a_of_type_Bdiy;
  private ArrayList<WadlResult> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "WadlJsBridgeCallBack";
  }
  
  public bdok(boolean paramBoolean, bdiy parambdiy)
  {
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bdiy = parambdiy;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bdiy == null) {}
    while ((System.currentTimeMillis() - this.jdField_b_of_type_Long <= 1000L) && (!this.jdField_b_of_type_Boolean)) {
      return;
    }
    Object localObject1 = new JSONArray();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((JSONArray)localObject1).put(bdop.a((WadlResult)((Iterator)localObject2).next()));
    }
    localObject1 = ((JSONArray)localObject1).toString();
    localObject2 = this.jdField_a_of_type_Bdiy.getJsCallbackMethod();
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (localObject1 = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + (String)localObject1 + ");}void(0);";; localObject1 = "javascript:" + (String)localObject2 + "(" + (String)localObject1 + ")")
    {
      b((String)localObject1);
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  private void a(int paramInt, WadlParams paramWadlParams)
  {
    if (paramWadlParams == null) {
      return;
    }
    int j = 1;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i != 0)
    {
      a(bdop.a(paramInt));
      return;
      biby.a().c(0, paramWadlParams.jdField_a_of_type_JavaLangString);
      i = j;
      continue;
      biby.a().a(0, paramWadlParams.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsHandler.post(new WadlJsBridgeCallBack.2(this, paramWadlParams));
      i = 0;
    }
  }
  
  private void b(WadlResult paramWadlResult)
  {
    if (paramWadlResult != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WadlResult localWadlResult = (WadlResult)localIterator.next();
        if ((localWadlResult.a != null) && (paramWadlResult.a != null) && (TextUtils.equals(localWadlResult.a.jdField_a_of_type_JavaLangString, paramWadlResult.a.jdField_a_of_type_JavaLangString))) {
          localWadlResult.d = paramWadlResult.d;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramWadlResult);
      }
      if (paramWadlResult.d == 100) {
        this.jdField_b_of_type_Boolean = true;
      }
      return;
    }
  }
  
  private void b(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      bdoe.b(jdField_a_of_type_JavaLangString, "doJsCallBack loadJs=" + paramString);
      try
      {
        WebView localWebView = this.jdField_a_of_type_Bdiy.getWebview();
        if (localWebView != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.post(new WadlJsBridgeCallBack.1(this, localWebView, paramString));
          return;
        }
      }
      catch (Exception paramString)
      {
        bdoe.a(jdField_a_of_type_JavaLangString, "doJsCallback exception", paramString);
      }
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        WadlResult localWadlResult = (WadlResult)localIterator.next();
        if ((localWadlResult.a != null) && (TextUtils.equals(localWadlResult.a.jdField_a_of_type_JavaLangString, paramString))) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void a(WadlResult paramWadlResult)
  {
    String str;
    if ((paramWadlResult != null) && (this.jdField_a_of_type_Boolean))
    {
      paramWadlResult = bdop.a(paramWadlResult).toString();
      str = this.jdField_a_of_type_Bdiy.getJsCallbackMethod();
      if (!TextUtils.isEmpty(str)) {
        break label67;
      }
    }
    label67:
    for (paramWadlResult = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('loadProcess'," + paramWadlResult + ");}void(0);";; paramWadlResult = "javascript:" + str + "(" + paramWadlResult + ")")
    {
      b(paramWadlResult);
      return;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      if ((BaseActivity.sTopActivity.isResume()) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 1000L))
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        bdid.a().a(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      bdoe.a(jdField_a_of_type_JavaLangString, "showToast>>>", paramString);
    }
  }
  
  public HashSet<String> getFilterCmds()
  {
    bdog localbdog = (bdog)bdoh.a().a("comminfo");
    if (localbdog != null) {
      return localbdog.a();
    }
    return bich.a;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    bdoe.b(jdField_a_of_type_JavaLangString, "onCmdRsp cmd=" + paramString + ",isSucc");
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getStringExtra("webssoReqJson");; paramIntent = null)
    {
      paramJSONObject = paramIntent;
      if (paramIntent == null) {
        paramJSONObject = "";
      }
      paramIntent = localJSONObject.toString();
      b("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.requestWebSso',{\"cmd\": " + paramString + ", \"webssoReq\":" + paramJSONObject + ", \"ret\":" + paramLong + ", \"data\":" + paramIntent + "});}void(0);");
      return;
    }
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    bdoe.b(jdField_a_of_type_JavaLangString, "onQueryCallback params:" + paramArrayList);
    JSONArray localJSONArray;
    if (paramArrayList != null) {
      try
      {
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(bdop.a((WadlResult)paramArrayList.next()));
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        bdoe.a(jdField_a_of_type_JavaLangString, "onQueryCallback exception:" + paramArrayList.getMessage());
      }
    }
    b("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + "1" + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    bdoe.b(jdField_a_of_type_JavaLangString, "onQueryCallbackVia params:" + paramArrayList);
    JSONArray localJSONArray;
    if (paramArrayList != null) {
      try
      {
        localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(bdop.a((WadlResult)paramArrayList.next()));
          continue;
          return;
        }
      }
      catch (Exception paramArrayList)
      {
        bdoe.a(jdField_a_of_type_JavaLangString, "onQueryCallbackVia exception:" + paramArrayList.getMessage());
      }
    }
    b("javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadActionByVia',{\"guid\": " + "1" + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);");
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.a == null))
    {
      bdoe.a(jdField_a_of_type_JavaLangString, "onWadlTaskStatusChanged error wadlResult is null");
      return;
    }
    WadlParams localWadlParams = paramWadlResult.a;
    String str = localWadlParams.jdField_a_of_type_JavaLangString;
    int i = bdop.a(paramWadlResult.b);
    bdoj.b(localWadlParams.jdField_a_of_type_JavaLangString);
    bdoe.b(jdField_a_of_type_JavaLangString, "onWadlTaskStatusChanged:" + paramWadlResult + ",localStatus:" + i);
    switch (i)
    {
    default: 
      bdoe.a(jdField_a_of_type_JavaLangString, "download status not response!");
      return;
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 10: 
    case 13: 
    case 20: 
      c(str);
      a(paramWadlResult);
      return;
    case -2: 
      i = bdop.b(paramWadlResult.c);
      bdoe.a(jdField_a_of_type_JavaLangString, "onWadlTaskStatusChanged  error,wadlErrCode=" + i);
      c(str);
      a(i, localWadlParams);
      a(paramWadlResult);
      return;
    }
    b(paramWadlResult);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdok
 * JD-Core Version:    0.7.0.1
 */