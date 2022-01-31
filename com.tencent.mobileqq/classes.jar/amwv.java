import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amwv
  extends ampa<amwu>
{
  public int a()
  {
    return 158;
  }
  
  @NonNull
  public amwu a(int paramInt)
  {
    return new amwu();
  }
  
  @Nullable
  public amwu a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0) && (paramArrayOfamph[0] != null))
    {
      amwu localamwu = amwu.a(paramArrayOfamph[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVSecurityConfProcessor", 2, "onParsed " + paramArrayOfamph[0].a);
      }
      return localamwu;
    }
    return null;
  }
  
  public Class<amwu> a()
  {
    return amwu.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amwu paramamwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVSecurityConfProcessor", 2, "onUpdate " + paramamwu.toString());
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
 * Qualified Name:     amwv
 * JD-Core Version:    0.7.0.1
 */