import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aojz
  extends aofy<aojy>
{
  public static aojy a()
  {
    aojy localaojy2 = (aojy)aogj.a().a(581);
    aojy localaojy1 = localaojy2;
    if (localaojy2 == null) {
      localaojy1 = new aojy();
    }
    return localaojy1;
  }
  
  public int a()
  {
    return 581;
  }
  
  @NonNull
  public aojy a(int paramInt)
  {
    return new aojy();
  }
  
  @Nullable
  public aojy a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aojy localaojy = aojy.a(paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfaogf[0].jdField_a_of_type_JavaLangString);
      }
      return localaojy;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aojy> a()
  {
    return aojy.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aojy paramaojy)
  {
    if (paramaojy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramaojy.toString());
    }
    SharedPreferences.Editor localEditor = azjg.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramaojy.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramaojy.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramaojy.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramaojy.d);
    localEditor.putString("userratio_new", paramaojy.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramaojy.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramaojy.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramaojy.f);
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
 * Qualified Name:     aojz
 * JD-Core Version:    0.7.0.1
 */