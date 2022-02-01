import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arex
  extends arac<arew>
{
  public static arew a()
  {
    arew localarew2 = (arew)aran.a().a(581);
    arew localarew1 = localarew2;
    if (localarew2 == null) {
      localarew1 = new arew();
    }
    return localarew1;
  }
  
  @NonNull
  public arew a(int paramInt)
  {
    return new arew();
  }
  
  @Nullable
  public arew a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0) && (paramArrayOfaraj[0] != null))
    {
      arew localarew = arew.a(paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfaraj[0].jdField_a_of_type_JavaLangString);
      }
      return localarew;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arew paramarew)
  {
    if (paramarew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramarew.toString());
    }
    SharedPreferences.Editor localEditor = bdho.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramarew.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramarew.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramarew.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramarew.d);
    localEditor.putString("userratio_new", paramarew.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramarew.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramarew.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramarew.f);
    localEditor.putBoolean("fake_enable_thread_suspend", paramarew.g);
    localEditor.putBoolean("suspendWhiteListOnly", paramarew.h);
    localEditor.commit();
  }
  
  public Class<arew> clazz()
  {
    return arew.class;
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
 * Qualified Name:     arex
 * JD-Core Version:    0.7.0.1
 */