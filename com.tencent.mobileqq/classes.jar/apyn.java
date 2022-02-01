import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apyn
  extends aptq<apym>
{
  public static apym a()
  {
    apym localapym2 = (apym)apub.a().a(581);
    apym localapym1 = localapym2;
    if (localapym2 == null) {
      localapym1 = new apym();
    }
    return localapym1;
  }
  
  @NonNull
  public apym a(int paramInt)
  {
    return new apym();
  }
  
  @Nullable
  public apym a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0) && (paramArrayOfaptx[0] != null))
    {
      apym localapym = apym.a(paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfaptx[0].jdField_a_of_type_JavaLangString);
      }
      return localapym;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(apym paramapym)
  {
    if (paramapym == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramapym.toString());
    }
    SharedPreferences.Editor localEditor = bcad.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramapym.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramapym.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramapym.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramapym.d);
    localEditor.putString("userratio_new", paramapym.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramapym.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramapym.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramapym.f);
    localEditor.putBoolean("fake_enable_thread_suspend", paramapym.g);
    localEditor.putBoolean("suspendWhiteListOnly", paramapym.h);
    localEditor.commit();
  }
  
  public Class<apym> clazz()
  {
    return apym.class;
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
 * Qualified Name:     apyn
 * JD-Core Version:    0.7.0.1
 */