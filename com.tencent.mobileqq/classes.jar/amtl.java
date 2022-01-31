import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amtl
  extends ampb<amtk>
{
  public static amtk a()
  {
    return (amtk)ampm.a().a(572);
  }
  
  public int a()
  {
    return 572;
  }
  
  @NonNull
  public amtk a(int paramInt)
  {
    return new amtk();
  }
  
  @Nullable
  public amtk a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0))
    {
      new amtk();
      return amtk.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<amtk> a()
  {
    return amtk.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amtk paramamtk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationBannerConfProcessor", 2, "onUpdate " + paramamtk.toString());
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
 * Qualified Name:     amtl
 * JD-Core Version:    0.7.0.1
 */