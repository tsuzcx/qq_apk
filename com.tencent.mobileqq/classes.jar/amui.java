import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amui
  extends ampb<amuh>
{
  public int a()
  {
    return 488;
  }
  
  @NonNull
  public amuh a(int paramInt)
  {
    return new amuh();
  }
  
  @Nullable
  public amuh a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amuh localamuh = amuh.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttWithTextSwitchProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamuh;
    }
    return null;
  }
  
  public Class<amuh> a()
  {
    return amuh.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amuh paramamuh)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttWithTextSwitchProcessor", 2, "onUpdate " + paramamuh.toString());
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
 * Qualified Name:     amui
 * JD-Core Version:    0.7.0.1
 */