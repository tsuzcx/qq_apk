import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.qqmini.sdk.core.plugins.engine.JsPluginEngine;

public class beuv
  implements IJSEngine
{
  private beuy jdField_a_of_type_Beuy;
  private JsPluginEngine jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine;
  
  beuv(beuy parambeuy)
  {
    this.jdField_a_of_type_Beuy = parambeuy;
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
    if (this.jdField_a_of_type_Beuy.a(paramInt) != null) {
      return this.jdField_a_of_type_Beuy.a(paramInt).a;
    }
    return null;
  }
  
  public void onCreate(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine = new JsPluginEngine(paramContext);
    this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.onCreate(this.jdField_a_of_type_Beuy);
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
      beuw localbeuw = this.jdField_a_of_type_Beuy.a(paramInt2);
      localObject1 = localObject2;
      if (localbeuw != null) {
        localObject1 = this.jdField_a_of_type_ComTencentQqminiSdkCorePluginsEngineJsPluginEngine.handleNativeRequest(paramString1, paramString2, localbeuw, paramInt1);
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
 * Qualified Name:     beuv
 * JD-Core Version:    0.7.0.1
 */