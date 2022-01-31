import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwx
  extends ampa<amww>
{
  public int a()
  {
    return 361;
  }
  
  @NonNull
  public amww a(int paramInt)
  {
    return new amww();
  }
  
  @Nullable
  public amww a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amww localamww = amww.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVStatisticsConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamww;
    }
    return null;
  }
  
  public Class<amww> a()
  {
    return amww.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amww paramamww)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVStatisticsConfProcessor", 2, "onUpdate " + paramamww.toString());
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
 * Qualified Name:     amwx
 * JD-Core Version:    0.7.0.1
 */