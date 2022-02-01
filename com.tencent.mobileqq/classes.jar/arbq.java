import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbq
  extends aqwt<arbp>
{
  public static arbp a()
  {
    arbp localarbp2 = (arbp)aqxe.a().a(581);
    arbp localarbp1 = localarbp2;
    if (localarbp2 == null) {
      localarbp1 = new arbp();
    }
    return localarbp1;
  }
  
  @NonNull
  public arbp a(int paramInt)
  {
    return new arbp();
  }
  
  @Nullable
  public arbp a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      arbp localarbp = arbp.a(paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfaqxa[0].jdField_a_of_type_JavaLangString);
      }
      return localarbp;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(arbp paramarbp)
  {
    if (paramarbp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramarbp.toString());
    }
    SharedPreferences.Editor localEditor = bdgy.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramarbp.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramarbp.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramarbp.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramarbp.d);
    localEditor.putString("userratio_new", paramarbp.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramarbp.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramarbp.jdField_c_of_type_JavaLangString);
    localEditor.putBoolean("enable_thread_suspend", paramarbp.f);
    localEditor.putBoolean("fake_enable_thread_suspend", paramarbp.g);
    localEditor.putBoolean("suspendWhiteListOnly", paramarbp.h);
    localEditor.commit();
  }
  
  public Class<arbp> clazz()
  {
    return arbp.class;
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
 * Qualified Name:     arbq
 * JD-Core Version:    0.7.0.1
 */