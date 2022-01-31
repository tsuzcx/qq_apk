import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aokh
  extends aofy<aokg>
{
  private static aokg a;
  
  public static aokg a()
  {
    aokg localaokg2 = (aokg)aogj.a().a(524);
    aokg localaokg1 = localaokg2;
    if (localaokg2 == null) {
      localaokg1 = aokg.a();
    }
    return localaokg1;
  }
  
  public int a()
  {
    return 524;
  }
  
  @NonNull
  public aokg a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = aokg.a();
    return a;
  }
  
  @Nullable
  public aokg a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      paramArrayOfaogf = aokg.a(paramArrayOfaogf[0].a);
      a = null;
      return paramArrayOfaogf;
    }
    return aokg.a();
  }
  
  public Class<aokg> a()
  {
    return aokg.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(aokg paramaokg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramaokg);
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
 * Qualified Name:     aokh
 * JD-Core Version:    0.7.0.1
 */