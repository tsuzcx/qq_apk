import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aosl
  extends aokh<aosk>
{
  public int a()
  {
    return 158;
  }
  
  @NonNull
  public aosk a(int paramInt)
  {
    return new aosk();
  }
  
  @Nullable
  public aosk a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0) && (paramArrayOfaoko[0] != null))
    {
      aosk localaosk = aosk.a(paramArrayOfaoko[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVSecurityConfProcessor", 2, "onParsed " + paramArrayOfaoko[0].a);
      }
      return localaosk;
    }
    return null;
  }
  
  public Class<aosk> a()
  {
    return aosk.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aosk paramaosk)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVSecurityConfProcessor", 2, "onUpdate " + paramaosk.toString());
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
 * Qualified Name:     aosl
 * JD-Core Version:    0.7.0.1
 */