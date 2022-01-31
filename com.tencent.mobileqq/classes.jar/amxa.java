import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amxa
  extends ampb<amwz>
{
  public int a()
  {
    return 207;
  }
  
  @NonNull
  public amwz a(int paramInt)
  {
    return new amwz();
  }
  
  @Nullable
  public amwz a(ampi[] paramArrayOfampi)
  {
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0) && (paramArrayOfampi[0] != null))
    {
      amwz localamwz = amwz.a(paramArrayOfampi[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVWhiteListConfProcessor", 2, "onParsed  " + paramArrayOfampi[0].a);
      }
      return localamwz;
    }
    return null;
  }
  
  public Class<amwz> a()
  {
    return amwz.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amwz paramamwz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVWhiteListConfProcessor", 2, "onUpdate " + paramamwz.toString());
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
 * Qualified Name:     amxa
 * JD-Core Version:    0.7.0.1
 */