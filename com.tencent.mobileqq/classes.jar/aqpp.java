import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqpp
  extends aqkz<aqpo>
{
  public static aqpo a()
  {
    aqpo localaqpo2 = (aqpo)aqlk.a().a(581);
    aqpo localaqpo1 = localaqpo2;
    if (localaqpo2 == null) {
      localaqpo1 = new aqpo();
    }
    return localaqpo1;
  }
  
  @NonNull
  public aqpo a(int paramInt)
  {
    return new aqpo();
  }
  
  @Nullable
  public aqpo a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0) && (paramArrayOfaqlg[0] != null))
    {
      aqpo localaqpo = aqpo.a(paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfaqlg[0].jdField_a_of_type_JavaLangString);
      }
      return localaqpo;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(aqpo paramaqpo)
  {
    if (paramaqpo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramaqpo.toString());
    }
    SharedPreferences.Editor localEditor = bcow.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramaqpo.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramaqpo.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramaqpo.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramaqpo.d);
    localEditor.putString("userratio_new", paramaqpo.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramaqpo.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramaqpo.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramaqpo.f);
    localEditor.putBoolean("fake_enable_thread_suspend", paramaqpo.g);
    localEditor.putBoolean("suspendWhiteListOnly", paramaqpo.h);
    localEditor.commit();
  }
  
  public Class<aqpo> clazz()
  {
    return aqpo.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 581;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqpp
 * JD-Core Version:    0.7.0.1
 */