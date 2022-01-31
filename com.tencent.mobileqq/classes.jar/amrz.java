import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amrz
  extends ampb<amsa>
{
  public static boolean a;
  private static boolean b;
  
  public static boolean e()
  {
    if (b) {
      return a;
    }
    b = true;
    a = f();
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean isSwitchOpened = " + a);
    }
    return a;
  }
  
  private static boolean f()
  {
    amsa localamsa2 = (amsa)ampm.a().a(531);
    amsa localamsa1 = localamsa2;
    if (localamsa2 == null)
    {
      localamsa2 = new amsa();
      localamsa1 = localamsa2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localamsa1 = localamsa2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localamsa1);
    }
    return localamsa1.a();
  }
  
  public int a()
  {
    return 531;
  }
  
  @NonNull
  public amsa a(int paramInt)
  {
    return new amsa();
  }
  
  @Nullable
  public amsa a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfampi[0].a);
      }
      return amsa.a(paramArrayOfampi[0].a);
    }
    return new amsa();
  }
  
  public Class<amsa> a()
  {
    return amsa.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amsa paramamsa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramamsa);
    }
    if (paramamsa != null) {
      a = paramamsa.a();
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
 * Qualified Name:     amrz
 * JD-Core Version:    0.7.0.1
 */