import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amug
  extends ampb<amuf>
{
  public int a()
  {
    return 442;
  }
  
  @NonNull
  public amuf a(int paramInt)
  {
    return new amuf();
  }
  
  @Nullable
  public amuf a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amuf localamuf = amuf.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("PttAutoChangeProcessor", 2, "onParsed " + paramArrayOfampi[0].a);
      }
      return localamuf;
    }
    return null;
  }
  
  public Class<amuf> a()
  {
    return amuf.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amuf paramamuf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttAutoChangeProcessor", 2, "onUpdate " + paramamuf.toString());
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
 * Qualified Name:     amug
 * JD-Core Version:    0.7.0.1
 */