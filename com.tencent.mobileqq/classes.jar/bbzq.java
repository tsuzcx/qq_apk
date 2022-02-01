import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class bbzq
{
  private static volatile bbzq jdField_a_of_type_Bbzq;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private bbzq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static bbzq a()
  {
    if (jdField_a_of_type_Bbzq == null) {}
    try
    {
      if (jdField_a_of_type_Bbzq == null) {
        jdField_a_of_type_Bbzq = new bbzq();
      }
      return jdField_a_of_type_Bbzq;
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
  
  public static boolean a(bbzj parambbzj)
  {
    if (parambbzj != null) {
      if (parambbzj.d()) {
        if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bbzk.a()) >= 600000L) {}
      }
    }
    while (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bbzk.a()) < 600000L)
    {
      do
      {
        return true;
        return false;
        if (!parambbzj.a()) {
          break;
        }
      } while (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bbzk.a()) < 1800000L);
      return false;
    }
    return false;
  }
  
  public SoConfig.SoInfo a(String paramString, bbzt parambbzt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ",isSync=" + paramBoolean + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.isValid(paramString))
    {
      if (paramBoolean) {
        return null;
      }
      ((bbzv)apub.a().a(526)).a(new bbzr(this, parambbzt, paramString));
      return null;
    }
    if (paramBoolean) {
      return a(paramString);
    }
    if (parambbzt != null) {
      parambbzt.a(0, a(paramString));
    }
    return null;
  }
  
  public void a(bbzu parambbzu)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(parambbzu);
  }
  
  public void a(String paramString, bbzj parambbzj, bbzt parambbzt)
  {
    if (a(parambbzj))
    {
      if (parambbzt != null) {
        parambbzt.a(0, a(paramString));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "[getNewestConfig], name=" + paramString);
    }
    ((bbzv)apub.a().a(526)).a(new bbzs(this, parambbzt, paramString), false);
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
 * Qualified Name:     bbzq
 * JD-Core Version:    0.7.0.1
 */