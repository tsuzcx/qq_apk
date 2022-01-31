import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoiw
  extends aofy<aoix>
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
    aoix localaoix2 = (aoix)aogj.a().a(531);
    aoix localaoix1 = localaoix2;
    if (localaoix2 == null)
    {
      localaoix2 = new aoix();
      localaoix1 = localaoix2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localaoix1 = localaoix2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localaoix1);
    }
    return localaoix1.a();
  }
  
  public int a()
  {
    return 531;
  }
  
  @NonNull
  public aoix a(int paramInt)
  {
    return new aoix();
  }
  
  @Nullable
  public aoix a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfaogf[0].a);
      }
      return aoix.a(paramArrayOfaogf[0].a);
    }
    return new aoix();
  }
  
  public Class<aoix> a()
  {
    return aoix.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aoix paramaoix)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramaoix);
    }
    if (paramaoix != null) {
      a = paramaoix.a();
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
 * Qualified Name:     aoiw
 * JD-Core Version:    0.7.0.1
 */