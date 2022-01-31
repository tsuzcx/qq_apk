import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aopb
  extends aokh<aopa>
{
  public static boolean e()
  {
    aopa localaopa = (aopa)aoks.a().a(613);
    if (localaopa != null) {}
    for (boolean bool = localaopa.a();; bool = false)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "isSwitchOpen = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  public int a()
  {
    return 613;
  }
  
  @NonNull
  public aopa a(int paramInt)
  {
    return new aopa();
  }
  
  @Nullable
  public aopa a(aoko[] paramArrayOfaoko)
  {
    int i = 0;
    if (paramArrayOfaoko == null) {}
    for (;;)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaoko == null) || (paramArrayOfaoko.length <= 0)) {
        break;
      }
      new aopa();
      return aopa.a(paramArrayOfaoko);
      i = paramArrayOfaoko.length;
    }
    return null;
  }
  
  public Class<aopa> a()
  {
    return aopa.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aopa paramaopa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkD55Processor", 2, "onUpdate " + paramaopa.toString());
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
 * Qualified Name:     aopb
 * JD-Core Version:    0.7.0.1
 */