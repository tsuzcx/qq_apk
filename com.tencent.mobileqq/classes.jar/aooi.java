import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aooi
  extends aokh<aooh>
{
  public static aooh a()
  {
    aooh localaooh2 = (aooh)aoks.a().a(581);
    aooh localaooh1 = localaooh2;
    if (localaooh2 == null) {
      localaooh1 = new aooh();
    }
    return localaooh1;
  }
  
  public int a()
  {
    return 581;
  }
  
  @NonNull
  public aooh a(int paramInt)
  {
    return new aooh();
  }
  
  @Nullable
  public aooh a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aooh localaooh = aooh.a(paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfaoko[0].jdField_a_of_type_JavaLangString);
      }
      return localaooh;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aooh> a()
  {
    return aooh.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aooh paramaooh)
  {
    if (paramaooh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramaooh.toString());
    }
    SharedPreferences.Editor localEditor = aznp.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramaooh.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramaooh.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramaooh.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramaooh.d);
    localEditor.putString("userratio_new", paramaooh.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramaooh.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramaooh.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramaooh.f);
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
 * Qualified Name:     aooi
 * JD-Core Version:    0.7.0.1
 */