import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsx
  extends ampa<amsw>
{
  public static amsw a()
  {
    amsw localamsw2 = (amsw)ampl.a().a(581);
    amsw localamsw1 = localamsw2;
    if (localamsw2 == null) {
      localamsw1 = new amsw();
    }
    return localamsw1;
  }
  
  public int a()
  {
    return 581;
  }
  
  @NonNull
  public amsw a(int paramInt)
  {
    return new amsw();
  }
  
  @Nullable
  public amsw a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amsw localamsw = amsw.a(paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfamph[0].jdField_a_of_type_JavaLangString);
      }
      return localamsw;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amsw> a()
  {
    return amsw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amsw paramamsw)
  {
    if (paramamsw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramamsw.toString());
    }
    SharedPreferences.Editor localEditor = axnx.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramamsw.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramamsw.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramamsw.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramamsw.d);
    localEditor.putString("userratio_new", paramamsw.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramamsw.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramamsw.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramamsw.f);
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
 * Qualified Name:     amsx
 * JD-Core Version:    0.7.0.1
 */