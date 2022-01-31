import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class bccf
  extends WebViewPlugin
{
  protected AtomicBoolean a;
  protected ymk a;
  
  public bccf()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ((!"GroupAppPanel".equals(paramString2)) || (("launchGroupApp".equals(paramString3)) && (paramVarArgs.length > 0) && (this.jdField_a_of_type_Ymk != null))) {}
    try
    {
      paramString3 = new JSONObject(paramVarArgs[0]);
      paramJsBridgeListener = paramString3.getString("groupCode");
      paramString1 = paramString3.getString("appID");
      paramString2 = paramString3.getString("url");
      paramString3 = paramString3.getString("source");
      this.jdField_a_of_type_Ymk.a(paramJsBridgeListener, paramString1, paramString2, paramString3);
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
      this.jdField_a_of_type_Ymk = ymk.a();
      this.jdField_a_of_type_Ymk.a();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      this.jdField_a_of_type_Ymk.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccf
 * JD-Core Version:    0.7.0.1
 */