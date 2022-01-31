import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aojx
  extends aofy<aojw>
{
  public int a()
  {
    return 575;
  }
  
  @NonNull
  public aojw a(int paramInt)
  {
    return new aojw();
  }
  
  @Nullable
  public aojw a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aojw localaojw = aojw.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("LocationEasterEggConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaojw;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aojw> a()
  {
    return aojw.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aojw paramaojw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationEasterEggConfProcessor", 2, "onUpdate " + paramaojw.toString());
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
 * Qualified Name:     aojx
 * JD-Core Version:    0.7.0.1
 */