import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class bcoj
{
  private static volatile bcoj jdField_a_of_type_Bcoj;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private bcoj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static bcoj a()
  {
    if (jdField_a_of_type_Bcoj == null) {}
    try
    {
      if (jdField_a_of_type_Bcoj == null) {
        jdField_a_of_type_Bcoj = new bcoj();
      }
      return jdField_a_of_type_Bcoj;
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
    return BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface;
  }
  
  public static boolean a(bcoc parambcoc)
  {
    if (parambcoc != null) {
      if (parambcoc.d()) {
        if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bcod.a()) >= 600000L) {}
      }
    }
    while (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bcod.a()) < 600000L)
    {
      do
      {
        return true;
        return false;
        if (!parambcoc.a()) {
          break;
        }
      } while (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bcod.a()) < 1800000L);
      return false;
    }
    return false;
  }
  
  public SoConfig.SoInfo a(String paramString, bcom parambcom, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ",isSync=" + paramBoolean + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.isValid(paramString))
    {
      if (paramBoolean) {
        return null;
      }
      ((bcoo)aqlk.a().a(526)).a(new bcok(this, parambcom, paramString));
      return null;
    }
    if (paramBoolean) {
      return a(paramString);
    }
    if (parambcom != null) {
      parambcom.a(0, a(paramString));
    }
    return null;
  }
  
  public void a(bcon parambcon)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(parambcon);
  }
  
  public void a(String paramString, bcoc parambcoc, bcom parambcom)
  {
    if (a(parambcoc))
    {
      if (parambcom != null) {
        parambcom.a(0, a(paramString));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "[getNewestConfig], name=" + paramString);
    }
    ((bcoo)aqlk.a().a(526)).a(new bcol(this, parambcom, paramString), false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    SoConfig.SoInfo localSoInfo = a(paramString1);
    if ((localSoInfo != null) && (TextUtils.equals(localSoInfo.ver, paramString2)))
    {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos.remove(paramString1);
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.saveConfig(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcoj
 * JD-Core Version:    0.7.0.1
 */