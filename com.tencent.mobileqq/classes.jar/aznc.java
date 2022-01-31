import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class aznc
{
  private static volatile aznc jdField_a_of_type_Aznc;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private aznc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static aznc a()
  {
    if (jdField_a_of_type_Aznc == null) {}
    try
    {
      if (jdField_a_of_type_Aznc == null) {
        jdField_a_of_type_Aznc = new aznc();
      }
      return jdField_a_of_type_Aznc;
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
  
  public SoConfig.SoInfo a(String paramString, aznf paramaznf, int paramInt)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ",callType=" + paramInt + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.isValid(paramString))
      {
        if (paramInt == azms.b) {
          return null;
        }
        ((aznh)aoks.a().a(526)).a(new aznd(this, paramaznf, paramString));
        return null;
      }
      if (paramInt == azms.b) {
        return a(paramString);
      }
      if (paramaznf != null) {
        paramaznf.a(0, a(paramString));
      }
      return null;
    }
    if (paramInt == azms.b) {
      return ajem.a(paramString);
    }
    ajem.a(paramString, new azne(this, paramaznf), paramInt);
    return null;
  }
  
  public void a(azng paramazng)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(paramazng);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aznc
 * JD-Core Version:    0.7.0.1
 */