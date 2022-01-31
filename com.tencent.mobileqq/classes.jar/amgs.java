import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amgs
  extends alzl<amgr>
{
  public int a()
  {
    return 158;
  }
  
  @NonNull
  public amgr a(int paramInt)
  {
    return new amgr();
  }
  
  @Nullable
  public amgr a(alzs[] paramArrayOfalzs)
  {
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0) && (paramArrayOfalzs[0] != null))
    {
      amgr localamgr = amgr.a(paramArrayOfalzs[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVSecurityConfProcessor", 2, "onParsed " + paramArrayOfalzs[0].a);
      }
      return localamgr;
    }
    return null;
  }
  
  public Class<amgr> a()
  {
    return amgr.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amgr paramamgr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVSecurityConfProcessor", 2, "onUpdate " + paramamgr.toString());
    }
  }
  
  public boolean a()
  {
    return false;
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
 * Qualified Name:     amgs
 * JD-Core Version:    0.7.0.1
 */