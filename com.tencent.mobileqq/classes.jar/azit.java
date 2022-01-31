import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class azit
{
  private static volatile azit jdField_a_of_type_Azit;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private azit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static azit a()
  {
    if (jdField_a_of_type_Azit == null) {}
    try
    {
      if (jdField_a_of_type_Azit == null) {
        jdField_a_of_type_Azit = new azit();
      }
      return jdField_a_of_type_Azit;
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
  
  public SoConfig.SoInfo a(String paramString, aziw paramaziw, int paramInt)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ",callType=" + paramInt + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.isValid(paramString))
      {
        if (paramInt == azij.b) {
          return null;
        }
        ((aziy)aogj.a().a(526)).a(new aziu(this, paramaziw, paramString));
        return null;
      }
      if (paramInt == azij.b) {
        return a(paramString);
      }
      if (paramaziw != null) {
        paramaziw.a(0, a(paramString));
      }
      return null;
    }
    if (paramInt == azij.b) {
      return aizx.a(paramString);
    }
    aizx.a(paramString, new aziv(this, paramaziw), paramInt);
    return null;
  }
  
  public void a(azix paramazix)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(paramazix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azit
 * JD-Core Version:    0.7.0.1
 */