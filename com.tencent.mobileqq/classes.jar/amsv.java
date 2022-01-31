import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsv
  extends ampa<amsu>
{
  public int a()
  {
    return 575;
  }
  
  @NonNull
  public amsu a(int paramInt)
  {
    return new amsu();
  }
  
  @Nullable
  public amsu a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amsu localamsu = amsu.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocationEasterEggConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamsu;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amsu> a()
  {
    return amsu.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amsu paramamsu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onUpdate " + paramamsu.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "migrateOldVersion");
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
 * Qualified Name:     amsv
 * JD-Core Version:    0.7.0.1
 */