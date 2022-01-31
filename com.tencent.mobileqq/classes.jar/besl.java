import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.soload.config.SoConfig;
import com.tencent.widget.soload.config.SoConfig.SoInfo;
import java.util.Map;

public class besl
{
  private static volatile besl jdField_a_of_type_Besl;
  SoConfig jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig;
  
  private besl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static besl a()
  {
    if (jdField_a_of_type_Besl == null) {}
    try
    {
      if (jdField_a_of_type_Besl == null) {
        jdField_a_of_type_Besl = new besl();
      }
      return jdField_a_of_type_Besl;
    }
    finally {}
  }
  
  private SoConfig.SoInfo a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig != null) && (this.jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig.mSoInfos != null)) {
      return (SoConfig.SoInfo)this.jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig.mSoInfos.get(paramString);
    }
    return null;
  }
  
  private boolean a()
  {
    return BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface;
  }
  
  public void a(besp parambesp)
  {
    this.jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig.update(parambesp);
  }
  
  public void a(String paramString, beso parambeso)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ", SoConfig=" + this.jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig.mSoInfos == null) || (this.jdField_a_of_type_ComTencentWidgetSoloadConfigSoConfig.mSoInfos.size() == 0)) {
        ((besq)alzw.a().a(526)).a(new besm(this, parambeso, paramString));
      }
      while (parambeso == null) {
        return;
      }
      parambeso.a(a(paramString));
      return;
    }
    agwb.a(paramString, new besn(this, parambeso));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besl
 * JD-Core Version:    0.7.0.1
 */