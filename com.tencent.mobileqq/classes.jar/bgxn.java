import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;

public class bgxn
  implements IJSEngine
{
  private bgxq jdField_a_of_type_Bgxq;
  private JsPluginEngine jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
  
  bgxn(bgxq parambgxq)
  {
    this.jdField_a_of_type_Bgxq = parambgxq;
  }
  
  public JsPluginEngine a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
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
    if (this.jdField_a_of_type_Bgxq.a(paramInt) != null) {
      return this.jdField_a_of_type_Bgxq.a(paramInt).a;
    }
    return null;
  }
  
  public void onCreate(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine = new JsPluginEngine(paramContext);
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onCreate(this.jdField_a_of_type_Bgxq);
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
      bgxo localbgxo = this.jdField_a_of_type_Bgxq.a(paramInt2);
      localObject1 = localObject2;
      if (localbgxo != null) {
        localObject1 = this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.handleNativeRequest(paramString1, paramString2, localbgxo, paramInt1);
      }
    }
    paramString1 = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString1 = "{}";
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxn
 * JD-Core Version:    0.7.0.1
 */