import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amtg
  extends ampb<amtf>
{
  private static amtf a;
  
  public static amtf a()
  {
    amtf localamtf2 = (amtf)ampm.a().a(524);
    amtf localamtf1 = localamtf2;
    if (localamtf2 == null) {
      localamtf1 = amtf.a();
    }
    return localamtf1;
  }
  
  public int a()
  {
    return 524;
  }
  
  @NonNull
  public amtf a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = amtf.a();
    return a;
  }
  
  @Nullable
  public amtf a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      paramArrayOfampi = amtf.a(paramArrayOfampi[0].a);
      a = null;
      return paramArrayOfampi;
    }
    return amtf.a();
  }
  
  public Class<amtf> a()
  {
    return amtf.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amtf paramamtf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramamtf);
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
 * Qualified Name:     amtg
 * JD-Core Version:    0.7.0.1
 */