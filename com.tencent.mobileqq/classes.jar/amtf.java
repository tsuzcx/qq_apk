import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amtf
  extends ampa<amte>
{
  private static amte a;
  
  public static amte a()
  {
    amte localamte2 = (amte)ampl.a().a(524);
    amte localamte1 = localamte2;
    if (localamte2 == null) {
      localamte1 = amte.a();
    }
    return localamte1;
  }
  
  public int a()
  {
    return 524;
  }
  
  @NonNull
  public amte a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MutualMarkConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = amte.a();
    return a;
  }
  
  @Nullable
  public amte a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      paramArrayOfamph = amte.a(paramArrayOfamph[0].a);
      a = null;
      return paramArrayOfamph;
    }
    return amte.a();
  }
  
  public Class<amte> a()
  {
    return amte.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public void a(amte paramamte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkConfProcessor", 2, "onUpdate newConf:" + paramamte);
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
 * Qualified Name:     amtf
 * JD-Core Version:    0.7.0.1
 */