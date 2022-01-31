import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import cooperation.qqreader.QRBridgeUtil;
import cooperation.qqreader.js.ReaderJsPlugin.1;
import cooperation.qqreader.js.ReaderJsPlugin.2;
import cooperation.qqreader.proxy.ReaderJsCallback;
import cooperation.qqreader.proxy.ReaderJsPluginProxy;
import cooperation.qqreader.ui.ReaderContentPageActivity;
import cooperation.qqreader.ui.ReaderHomePageActivity;
import cooperation.qqreader.utils.QRDebugEnvUrlUtils;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class bfmb
  extends VasWebviewJsPlugin
  implements bayu
{
  public static final Handler a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "JSRoot", "JSToast", "JSBookDir", "JSPublicAccount", "JSTopRightButton", "JSTittlebarAction", "JSPay", "JSPublicAccountUtil", "JSRedTouch", "JSBookDetailForQQ", "JSbookshelf", "JSContent", "readonline", "JSPopupList", "JSTypeface" };
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private JsBridgeListener jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener;
  private ReaderJsCallback jdField_a_of_type_CooperationQqreaderProxyReaderJsCallback = new bfmc(this);
  private ReaderJsPluginProxy jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("ReaderJsPluginDeamon", 0);
    localHandlerThread.start();
    jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
  }
  
  private void a(JsBridgeListener paramJsBridgeListener, String paramString)
  {
    paramJsBridgeListener = new JSONObject(paramString).optString("callback");
    if (!TextUtils.isEmpty(paramJsBridgeListener))
    {
      paramString = new JSONObject();
      paramString.put("graylevel", bflt.a());
      paramString.put("is_update_newstyle", bflt.a());
      paramString.put("result", 0);
      paramString.put("message", "success");
      callJs(paramJsBridgeListener, new String[] { paramString.toString() });
    }
  }
  
  private void a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, long paramLong, String... paramVarArgs)
  {
    jdField_a_of_type_AndroidOsHandler.post(new ReaderJsPlugin.2(this, paramLong, paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs));
  }
  
  private void a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QRBridgeUtil.isPluginReady())
    {
      ThreadManager.getUIHandler().post(new ReaderJsPlugin.1(this, paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs));
      return;
    }
    bfne.d("ReaderJsPlugin", "js plugin is not ready...");
    a(paramJsBridgeListener, paramString1, paramString2, paramString3, 3000L, paramVarArgs);
  }
  
  private void a(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("visible");
      paramString = Message.obtain();
      paramString.what = 109;
      paramString.obj = Boolean.valueOf(bool);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1 = new JSONObject(paramString);
    paramString = ((JSONObject)localObject1).getString("book_name");
    String str1 = ((JSONObject)localObject1).getString("chapter_name");
    String str2 = ((JSONObject)localObject1).getString("nbid");
    localObject1 = ((JSONObject)localObject1).optString("callback");
    Object localObject2 = this.mRuntime.a();
    if ((localObject2 instanceof ReaderHomePageActivity)) {
      localObject2 = (ReaderHomePageActivity)localObject2;
    }
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      return;
    case 4: 
      ((ReaderHomePageActivity)localObject2).a(paramString, str1, str2);
      return;
    case 6: 
      ((ReaderHomePageActivity)localObject2).b(paramString, str1, str2);
      return;
    }
    boolean bool = ((ReaderHomePageActivity)localObject2).a(paramString, str1, str2);
    paramString = new JSONObject();
    if (bool) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramString.put("result", paramInt);
      callJs((String)localObject1, new String[] { paramString.toString() });
      return;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    Log.i("ReaderJsPlugin", "registerWebSearch");
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("callback");
  }
  
  private static boolean a(String[] paramArrayOfString, String paramString)
  {
    return Arrays.asList(paramArrayOfString).contains(paramString);
  }
  
  private void b(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy == null)
    {
      bfne.c("ReaderJsPlugin", "create a new js plugin");
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy = QRBridgeUtil.getJsPlugin(this.mRuntime, this.jdField_a_of_type_CooperationQqreaderProxyReaderJsCallback);
    }
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy != null)
    {
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy.setHandler(this.jdField_b_of_type_AndroidOsHandler);
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy.call(paramString1, paramString2, paramString3, paramVarArgs);
      bfne.c("ReaderJsPlugin", "create a new js ,method=" + paramString3);
    }
    do
    {
      return;
      bfne.a("ReaderJsPlugin", "handleJsCall mJsPlugin is null!");
    } while (!QRDebugEnvUrlUtils.isDebugEnv());
    Toast.makeText(BaseApplicationImpl.getApplication(), "ReaderRunTime 未创建！", 0).show();
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent(this.mRuntime.a(), ReaderContentPageActivity.class);
    localIntent.putExtras(bflh.a(localIntent));
    localIntent.putExtra("url", paramString);
    this.mRuntime.a().startActivity(localIntent);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(114, paramJSONObject);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramJSONObject);
    }
  }
  
  public bfmb a(Handler paramHandler)
  {
    this.jdField_b_of_type_AndroidOsHandler = paramHandler;
    return this;
  }
  
  public void a(TextView paramTextView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    if (paramString1.trim().length() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bfmd(this));
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":\"0\"}" });
    }
    for (;;)
    {
      Log.i("ReaderJsPlugin", "registerWebSearch callWebSearch=" + bool);
      return bool;
      bool = false;
    }
  }
  
  public String[] getMultiNameSpace()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public Object handleEvent(String paramString, long paramLong)
  {
    return super.handleEvent(paramString, paramLong);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    bfne.d("ReaderJsPlugin", "handleJsRequest, url=" + paramString1 + " ,pakName=" + paramString2 + " ,method=" + paramString3);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftJsBridgeListener = paramJsBridgeListener;
    if (!a(jdField_a_of_type_ArrayOfJavaLangString, paramString2)) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    if ("JSTittlebarAction".equals(paramString2))
    {
      if ("setLoadingVisible".equals(paramString3))
      {
        if (paramVarArgs.length > 0)
        {
          a(paramVarArgs[0]);
          if (paramJsBridgeListener != null) {
            paramJsBridgeListener.a(null);
          }
        }
        return true;
      }
      if ("addDeskShortcutEvent".equals(paramString3))
      {
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
      a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    for (;;)
    {
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      if ("JSContent".equals(paramString2))
      {
        if ("registerWebSearch".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            a(new JSONObject(paramVarArgs[0]));
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              Log.e("ReaderJsPlugin", "Failed to parse json str,json=" + paramVarArgs[0]);
            }
          }
        }
        if ("showRedPoint".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            b(new JSONObject(paramVarArgs[0]));
            return true;
          }
          catch (JSONException paramJsBridgeListener)
          {
            for (;;)
            {
              Log.e("ReaderJsPlugin", "Failed to parse json str,json=" + paramVarArgs[0]);
            }
          }
        }
        if ("openDetailMore".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
            b(paramVarArgs[0]);
          }
          return true;
        }
        a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      else if ("JSbookshelf".equals(paramString2))
      {
        if ("getGrayUpdateData".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            a(paramJsBridgeListener, paramVarArgs[0]);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              bfne.d("ReaderJsPlugin", paramJsBridgeListener.getMessage());
            }
          }
        }
        if ("addColorfulTab".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            a(paramVarArgs[0], 4);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              bfne.d("ReaderJsPlugin", paramJsBridgeListener.getMessage());
            }
          }
        }
        if ("removeColorfulTab".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            a(paramVarArgs[0], 6);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              bfne.d("ReaderJsPlugin", paramJsBridgeListener.getMessage());
            }
          }
        }
        if ("isExitsInColorfulTab".equals(paramString3))
        {
          if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
          try
          {
            a(paramVarArgs[0], 8);
            return true;
          }
          catch (Exception paramJsBridgeListener)
          {
            for (;;)
            {
              bfne.d("ReaderJsPlugin", paramJsBridgeListener.getMessage());
            }
          }
        }
        a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      else if ("JSTopRightButton".equals(paramString2))
      {
        if ("showRightButton".equals(paramString3))
        {
          if (paramVarArgs.length > 1)
          {
            a(paramVarArgs[0], paramVarArgs[1]);
            if (paramJsBridgeListener != null) {
              paramJsBridgeListener.a(null);
            }
          }
          return true;
        }
        a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      else
      {
        a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy != null) {
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy.onCreate();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy != null) {
      this.jdField_a_of_type_CooperationQqreaderProxyReaderJsPluginProxy.onDestroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmb
 * JD-Core Version:    0.7.0.1
 */