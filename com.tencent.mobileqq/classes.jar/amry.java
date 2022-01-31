import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amry
  extends ampa<amrz>
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
    amrz localamrz2 = (amrz)ampl.a().a(531);
    amrz localamrz1 = localamrz2;
    if (localamrz2 == null)
    {
      localamrz2 = new amrz();
      localamrz1 = localamrz2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localamrz1 = localamrz2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localamrz1);
    }
    return localamrz1.a();
  }
  
  public int a()
  {
    return 531;
  }
  
  @NonNull
  public amrz a(int paramInt)
  {
    return new amrz();
  }
  
  @Nullable
  public amrz a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfamph[0].a);
      }
      return amrz.a(paramArrayOfamph[0].a);
    }
    return new amrz();
  }
  
  public Class<amrz> a()
  {
    return amrz.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amrz paramamrz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramamrz);
    }
    if (paramamrz != null) {
      a = paramamrz.a();
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
 * Qualified Name:     amry
 * JD-Core Version:    0.7.0.1
 */