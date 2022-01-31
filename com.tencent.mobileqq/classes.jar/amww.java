import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amww
  extends ampb<amwv>
{
  public int a()
  {
    return 158;
  }
  
  @NonNull
  public amwv a(int paramInt)
  {
    return new amwv();
  }
  
  @Nullable
  public amwv a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amwv localamwv = amwv.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVSecurityConfProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamwv;
    }
    return null;
  }
  
  public Class<amwv> a()
  {
    return amwv.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amwv paramamwv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVSecurityConfProcessor", 2, "onUpdate " + paramamwv.toString());
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
 * Qualified Name:     amww
 * JD-Core Version:    0.7.0.1
 */