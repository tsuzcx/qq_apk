import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amto
  extends ampa<amtn>
{
  public static amtn a()
  {
    return (amtn)ampl.a().a(426);
  }
  
  public static boolean e()
  {
    amtn localamtn = a();
    if (localamtn != null) {}
    for (boolean bool = localamtn.c();; bool = false)
    {
      QLog.d("OpenSdkConfProcessor", 1, new Object[] { "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public int a()
  {
    return 426;
  }
  
  @NonNull
  public amtn a(int paramInt)
  {
    return new amtn();
  }
  
  @Nullable
  public amtn a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      new amtn();
      return amtn.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<amtn> a()
  {
    return amtn.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amtn paramamtn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramamtn.toString());
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
 * Qualified Name:     amto
 * JD-Core Version:    0.7.0.1
 */