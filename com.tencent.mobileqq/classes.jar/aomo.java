import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aomo
  extends aofy<aomn>
{
  public int a()
  {
    return 546;
  }
  
  @NonNull
  public aomn a(int paramInt)
  {
    return new aomn();
  }
  
  @Nullable
  public aomn a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0) && (paramArrayOfaogf[0] != null))
    {
      aomn localaomn = aomn.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAuthorityConfProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localaomn;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public Class<aomn> a()
  {
    return aomn.class;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(aomn paramaomn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAuthorityConfProcessor", 2, "onUpdate " + paramaomn.toString());
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
 * Qualified Name:     aomo
 * JD-Core Version:    0.7.0.1
 */