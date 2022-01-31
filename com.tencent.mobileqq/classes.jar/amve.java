import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amve
  extends ampb<amvc>
{
  public int a()
  {
    return 534;
  }
  
  @NonNull
  public amvc a(int paramInt)
  {
    return new amvc();
  }
  
  @Nullable
  public amvc a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amvc localamvc = amvc.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfProcessor", 2, "onParsed  " + paramArrayOfampi[0].a);
      }
      return localamvc;
    }
    return null;
  }
  
  public Class<amvc> a()
  {
    return amvc.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amvc paramamvc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onUpdate " + paramamvc.toString());
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
 * Qualified Name:     amve
 * JD-Core Version:    0.7.0.1
 */