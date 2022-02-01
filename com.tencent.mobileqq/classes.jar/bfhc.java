import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class bfhc
  extends WebViewPlugin
{
  protected aanz a;
  protected AtomicBoolean a;
  
  public bfhc()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ((!"GroupAppPanel".equals(paramString2)) || (("launchGroupApp".equals(paramString3)) && (paramVarArgs.length > 0) && (this.jdField_a_of_type_Aanz != null))) {}
    try
    {
      paramString3 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString3.getString("groupCode");
      paramString1 = paramString3.getString("appID");
      paramString2 = paramString3.getString("url");
      paramString3 = paramString3.getString("source");
      this.jdField_a_of_type_Aanz.a(paramJsBridgeListener, paramString1, paramString2, paramString3);
      bool = true;
      return bool;
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
        QLog.e("TroopAppPanelJsPlugin", 2, "launchGroupApp: args error");
      }
    }
  }
  
  public void onCreate()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      this.jdField_a_of_type_Aanz = aanz.a();
      this.jdField_a_of_type_Aanz.a();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_Aanz.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhc
 * JD-Core Version:    0.7.0.1
 */