import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;

public class aqkj
{
  private static aqkj jdField_a_of_type_Aqkj = new aqkj();
  private PluginProcessKiller jdField_a_of_type_ComTencentMobileqqIntervideoShadowPluginProcessKiller;
  private DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private String jdField_a_of_type_JavaLangString;
  
  public static aqkj a()
  {
    return jdField_a_of_type_Aqkj;
  }
  
  private void a(String paramString, DynamicPluginManager paramDynamicPluginManager, PluginProcessKiller paramPluginProcessKiller)
  {
    int j = 1;
    int i;
    if ((paramString != null) && (paramString.equals("Now")))
    {
      i = 1;
      if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals("Now"))) {
        break label55;
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0)) {
        break label61;
      }
      return;
      i = 0;
      break;
      label55:
      j = 0;
    }
    label61:
    if ((paramString != null) && (!paramString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager != null)
      {
        PluginProcessKiller localPluginProcessKiller = (PluginProcessKiller)this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager.getManagerImpl();
        if (localPluginProcessKiller != null) {
          localPluginProcessKiller.onKillPluginProcess();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoShadowPluginProcessKiller != null) {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoShadowPluginProcessKiller.onKillPluginProcess();
      }
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoShadowPluginProcessKiller = paramPluginProcessKiller;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(String paramString, PluginProcessKiller paramPluginProcessKiller)
  {
    a(paramString, null, paramPluginProcessKiller);
  }
  
  public void a(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    a(paramString, paramDynamicPluginManager, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqkj
 * JD-Core Version:    0.7.0.1
 */