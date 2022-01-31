import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aokq
  extends aofy<aokp>
{
  public static aokp a()
  {
    return (aokp)aogj.a().a(426);
  }
  
  public static boolean e()
  {
    aokp localaokp = a();
    if (localaokp != null) {}
    for (boolean bool = localaokp.c();; bool = false)
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
  public aokp a(int paramInt)
  {
    return new aokp();
  }
  
  @Nullable
  public aokp a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      new aokp();
      return aokp.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aokp> a()
  {
    return aokp.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aokp paramaokp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramaokp.toString());
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
 * Qualified Name:     aokq
 * JD-Core Version:    0.7.0.1
 */