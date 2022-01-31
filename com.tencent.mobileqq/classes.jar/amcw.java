import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amcw
  extends alzl<amcv>
{
  public static amcv a()
  {
    amcv localamcv2 = (amcv)alzw.a().a(581);
    amcv localamcv1 = localamcv2;
    if (localamcv2 == null) {
      localamcv1 = new amcv();
    }
    return localamcv1;
  }
  
  public int a()
  {
    return 581;
  }
  
  @NonNull
  public amcv a(int paramInt)
  {
    return new amcv();
  }
  
  @Nullable
  public amcv a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amcv localamcv = amcv.a(paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onParsed " + paramArrayOfalzs[0].jdField_a_of_type_JavaLangString);
      }
      return localamcv;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amcv> a()
  {
    return amcv.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amcv paramamcv)
  {
    if (paramamcv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "onUpdate but newConf==null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "onUpdate " + paramamcv.toString());
    }
    SharedPreferences.Editor localEditor = awoa.a().edit();
    localEditor.putBoolean("disablepreloadproc_new", paramamcv.jdField_a_of_type_Boolean);
    localEditor.putBoolean("disablegettrooplist_new", paramamcv.jdField_c_of_type_Boolean);
    localEditor.putBoolean("disablepredownload_new", paramamcv.jdField_b_of_type_Boolean);
    localEditor.putBoolean("enableautoperf_new", paramamcv.d);
    localEditor.putString("userratio_new", paramamcv.jdField_a_of_type_JavaLangString);
    localEditor.putString("extralsteps_new", paramamcv.jdField_b_of_type_JavaLangString);
    localEditor.putString("predownloadwhitelist_new", paramamcv.jdField_c_of_type_JavaLangString);
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
 * Qualified Name:     amcw
 * JD-Core Version:    0.7.0.1
 */