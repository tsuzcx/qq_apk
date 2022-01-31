import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amvj
  extends ampa<amvi>
{
  public int a()
  {
    return 546;
  }
  
  @NonNull
  public amvi a(int paramInt)
  {
    return new amvi();
  }
  
  @Nullable
  public amvi a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amvi localamvi = amvi.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAuthorityConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamvi;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amvi> a()
  {
    return amvi.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amvi paramamvi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onUpdate " + paramamvi.toString());
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "migrateOldVersion");
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
 * Qualified Name:     amvj
 * JD-Core Version:    0.7.0.1
 */