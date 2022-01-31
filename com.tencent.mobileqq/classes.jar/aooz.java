import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aooz
  extends aokh<aooy>
{
  public static aooy a()
  {
    return (aooy)aoks.a().a(426);
  }
  
  public static boolean e()
  {
    aooy localaooy = a();
    if (localaooy != null) {}
    for (boolean bool = localaooy.c();; bool = false)
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
  public aooy a(int paramInt)
  {
    return new aooy();
  }
  
  @Nullable
  public aooy a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      new aooy();
      return aooy.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aooy> a()
  {
    return aooy.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aooy paramaooy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramaooy.toString());
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
 * Qualified Name:     aooz
 * JD-Core Version:    0.7.0.1
 */