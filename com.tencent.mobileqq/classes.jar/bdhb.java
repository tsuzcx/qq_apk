import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class bdhb
{
  private static volatile bdhb jdField_a_of_type_Bdhb;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private bdhb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static bdhb a()
  {
    if (jdField_a_of_type_Bdhb == null) {}
    try
    {
      if (jdField_a_of_type_Bdhb == null) {
        jdField_a_of_type_Bdhb = new bdhb();
      }
      return jdField_a_of_type_Bdhb;
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
  
  public static boolean a(bdgu parambdgu)
  {
    if (parambdgu != null) {
      if (parambdgu.d()) {
        if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bdgv.a()) >= 600000L) {}
      }
    }
    while (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bdgv.a()) < 600000L)
    {
      do
      {
        return true;
        return false;
        if (!parambdgu.a()) {
          break;
        }
      } while (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bdgv.a()) < 1800000L);
      return false;
    }
    return false;
  }
  
  public SoConfig.SoInfo a(String paramString, bdhe parambdhe, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ",isSync=" + paramBoolean + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.isValid(paramString))
    {
      if (paramBoolean) {
        return null;
      }
      ((bdhg)aran.a().a(526)).a(new bdhc(this, parambdhe, paramString));
      return null;
    }
    if (paramBoolean) {
      return a(paramString);
    }
    if (parambdhe != null) {
      parambdhe.a(0, a(paramString));
    }
    return null;
  }
  
  public void a(bdhf parambdhf)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(parambdhf);
  }
  
  public void a(String paramString, bdgu parambdgu, bdhe parambdhe)
  {
    if (a(parambdgu))
    {
      if (parambdhe != null) {
        parambdhe.a(0, a(paramString));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "[getNewestConfig], name=" + paramString);
    }
    ((bdhg)aran.a().a(526)).a(new bdhd(this, parambdhe, paramString), false);
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
 * Qualified Name:     bdhb
 * JD-Core Version:    0.7.0.1
 */