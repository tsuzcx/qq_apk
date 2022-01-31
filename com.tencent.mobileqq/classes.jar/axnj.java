import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class axnj
{
  private static volatile axnj jdField_a_of_type_Axnj;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private axnj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static axnj a()
  {
    if (jdField_a_of_type_Axnj == null) {}
    try
    {
      if (jdField_a_of_type_Axnj == null) {
        jdField_a_of_type_Axnj = new axnj();
      }
      return jdField_a_of_type_Axnj;
    }
    finally {}
  }
  
  private SoConfig.SoInfo a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos != null)) {
      return (SoConfig.SoInfo)this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos.get(paramString);
    }
    return null;
  }
  
  private boolean a()
  {
    return BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface;
  }
  
  public void a(axnn paramaxnn)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(paramaxnn);
  }
  
  public void a(String paramString, axnm paramaxnm)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos == null) || (this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos.size() == 0)) {
        ((axno)ampm.a().a(526)).a(new axnk(this, paramaxnm, paramString));
      }
      while (paramaxnm == null) {
        return;
      }
      paramaxnm.a(a(paramString));
      return;
    }
    ahiq.a(paramString, new axnl(this, paramaxnm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnj
 * JD-Core Version:    0.7.0.1
 */