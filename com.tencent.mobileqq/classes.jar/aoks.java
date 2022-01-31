import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aoks
  extends aofy<aokr>
{
  public static boolean e()
  {
    aokr localaokr = (aokr)aogj.a().a(613);
    if (localaokr != null) {}
    for (boolean bool = localaokr.a();; bool = false)
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
  public aokr a(int paramInt)
  {
    return new aokr();
  }
  
  @Nullable
  public aokr a(aogf[] paramArrayOfaogf)
  {
    int i = 0;
    if (paramArrayOfaogf == null) {}
    for (;;)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaogf == null) || (paramArrayOfaogf.length <= 0)) {
        break;
      }
      new aokr();
      return aokr.a(paramArrayOfaogf);
      i = paramArrayOfaogf.length;
    }
    return null;
  }
  
  public Class<aokr> a()
  {
    return aokr.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aokr paramaokr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkD55Processor", 2, "onUpdate " + paramaokr.toString());
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
 * Qualified Name:     aoks
 * JD-Core Version:    0.7.0.1
 */