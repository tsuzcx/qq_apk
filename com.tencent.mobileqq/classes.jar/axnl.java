import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class axnl
{
  private static volatile axnl jdField_a_of_type_Axnl;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private axnl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static axnl a()
  {
    if (jdField_a_of_type_Axnl == null) {}
    try
    {
      if (jdField_a_of_type_Axnl == null) {
        jdField_a_of_type_Axnl = new axnl();
      }
      return jdField_a_of_type_Axnl;
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
  
  public void a(axnp paramaxnp)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(paramaxnp);
  }
  
  public void a(String paramString, axno paramaxno)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos == null) || (this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos.size() == 0)) {
        ((axnq)ampl.a().a(526)).a(new axnm(this, paramaxno, paramString));
      }
      while (paramaxno == null) {
        return;
      }
      paramaxno.a(a(paramString));
      return;
    }
    ahio.a(paramString, new axnn(this, paramaxno));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnl
 * JD-Core Version:    0.7.0.1
 */