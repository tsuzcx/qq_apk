import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amde
  extends alzl<amdd>
{
  private static amdd a;
  
  public static amdd a()
  {
    amdd localamdd2 = (amdd)alzw.a().a(524);
    amdd localamdd1 = localamdd2;
    if (localamdd2 == null) {
      localamdd1 = amdd.a();
    }
    return localamdd1;
  }
  
  public int a()
  {
    return 524;
  }
  
  @NonNull
  public amdd a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = amdd.a();
    return a;
  }
  
  @Nullable
  public amdd a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0))
    {
      paramArrayOfalzs = amdd.a(paramArrayOfalzs[0].a);
      a = null;
      return paramArrayOfalzs;
    }
    return amdd.a();
  }
  
  public Class<amdd> a()
  {
    return amdd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amdd paramamdd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramamdd);
    }
  }
  
  public int b()
  {
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
 * Qualified Name:     amde
 * JD-Core Version:    0.7.0.1
 */