import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class bdgl
{
  private static volatile bdgl jdField_a_of_type_Bdgl;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private bdgl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static bdgl a()
  {
    if (jdField_a_of_type_Bdgl == null) {}
    try
    {
      if (jdField_a_of_type_Bdgl == null) {
        jdField_a_of_type_Bdgl = new bdgl();
      }
      return jdField_a_of_type_Bdgl;
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
  
  public static boolean a(bdge parambdge)
  {
    if (parambdge != null) {
      if (parambdge.d()) {
        if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bdgf.a()) >= 600000L) {}
      }
    }
    while (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bdgf.a()) < 600000L)
    {
      do
      {
        return true;
        return false;
        if (!parambdge.a()) {
          break;
        }
      } while (Math.abs(NetConnInfoCenter.getServerTimeMillis() - bdgf.a()) < 1800000L);
      return false;
    }
    return false;
  }
  
  public SoConfig.SoInfo a(String paramString, bdgo parambdgo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ",isSync=" + paramBoolean + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.isValid(paramString))
    {
      if (paramBoolean) {
        return null;
      }
      ((bdgq)aqxe.a().a(526)).a(new bdgm(this, parambdgo, paramString));
      return null;
    }
    if (paramBoolean) {
      return a(paramString);
    }
    if (parambdgo != null) {
      parambdgo.a(0, a(paramString));
    }
    return null;
  }
  
  public void a(bdgp parambdgp)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(parambdgp);
  }
  
  public void a(String paramString, bdge parambdge, bdgo parambdgo)
  {
    if (a(parambdge))
    {
      if (parambdgo != null) {
        parambdgo.a(0, a(paramString));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "[getNewestConfig], name=" + paramString);
    }
    ((bdgq)aqxe.a().a(526)).a(new bdgn(this, parambdgo, paramString), false);
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
 * Qualified Name:     bdgl
 * JD-Core Version:    0.7.0.1
 */