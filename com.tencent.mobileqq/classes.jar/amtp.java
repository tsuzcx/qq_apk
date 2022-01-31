import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amtp
  extends ampb<amto>
{
  public static amto a()
  {
    return (amto)ampm.a().a(426);
  }
  
  public static boolean e()
  {
    amto localamto = a();
    if (localamto != null) {}
    for (boolean bool = localamto.c();; bool = false)
    {
      QLog.d("OpenSdkConfProcessor", 1, new Object[] { "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public int a()
  {
    return 426;
  }
  
  @NonNull
  public amto a(int paramInt)
  {
    return new amto();
  }
  
  @Nullable
  public amto a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      new amto();
      return amto.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<amto> a()
  {
    return amto.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amto paramamto)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramamto.toString());
    }
  }
  
  public boolean a()
  {
    return true;
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
 * Qualified Name:     amtp
 * JD-Core Version:    0.7.0.1
 */