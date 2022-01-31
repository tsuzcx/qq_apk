import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;

public class bdow
  implements IJSEngine
{
  private bdoz jdField_a_of_type_Bdoz;
  private JsPluginEngine jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
  
  bdow(bdoz parambdoz)
  {
    this.jdField_a_of_type_Bdoz = parambdoz;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onResume();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onPause();
    }
  }
  
  public boolean canHandleEvent(String paramString)
  {
    return true;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    if (this.jdField_a_of_type_Bdoz.a(paramInt) != null) {
      return this.jdField_a_of_type_Bdoz.a(paramInt).a;
    }
    return null;
  }
  
  public void onCreate(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine = new JsPluginEngine(paramContext);
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onCreate(this.jdField_a_of_type_Bdoz);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null) {
      this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onDestroy();
    }
  }
  
  public String onScriptCall(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine != null)
    {
      bdox localbdox = this.jdField_a_of_type_Bdoz.a(paramInt2);
      localObject1 = localObject2;
      if (localbdox != null) {
        localObject1 = this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.handleNativeRequest(paramString1, paramString2, localbdox, paramInt1);
      }
    }
    paramString1 = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString1 = "{}";
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdow
 * JD-Core Version:    0.7.0.1
 */