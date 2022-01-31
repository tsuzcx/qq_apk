import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amfe
  extends alzl<amfd>
{
  public int a()
  {
    return 546;
  }
  
  @NonNull
  public amfd a(int paramInt)
  {
    return new amfd();
  }
  
  @Nullable
  public amfd a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amfd localamfd = amfd.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAuthorityConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamfd;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<amfd> a()
  {
    return amfd.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(amfd paramamfd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onUpdate " + paramamfd.toString());
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
 * Qualified Name:     amfe
 * JD-Core Version:    0.7.0.1
 */