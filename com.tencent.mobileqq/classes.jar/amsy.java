import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsy
  extends ampb<amsx>
{
  public static amsx a()
  {
    amsx localamsx2 = (amsx)ampm.a().a(581);
    amsx localamsx1 = localamsx2;
    if (localamsx2 == null) {
      localamsx1 = new amsx();
    }
    return localamsx1;
  }
  
  public int a()
  {
    return 581;
  }
  
  @NonNull
  public amsx a(int paramInt)
  {
    return new amsx();
  }
  
  @Nullable
  public amsx a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amsx localamsx = amsx.a(paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfampi[0].jdField_a_of_type_JavaLangString);
      }
      return localamsx;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amsx> a()
  {
    return amsx.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amsx paramamsx)
  {
    if (paramamsx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramamsx.toString());
    }
    SharedPreferences.Editor localEditor = axnv.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramamsx.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramamsx.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramamsx.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramamsx.d);
    localEditor.putString("userratio_new", paramamsx.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramamsx.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramamsx.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramamsx.f);
    localEditor.commit();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amsy
 * JD-Core Version:    0.7.0.1
 */