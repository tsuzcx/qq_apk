import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfu
  extends arac<arft>
{
  public static arft a()
  {
    return (arft)aran.a().a(426);
  }
  
  public static boolean a()
  {
    arft localarft = a();
    if (localarft != null) {}
    for (boolean bool = localarft.b();; bool = false)
    {
      QLog.d("OpenSdkConfProcessor", 1, new Object[] { "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public arft a(int paramInt)
  {
    return new arft();
  }
  
  @Nullable
  public arft a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      new arft();
      return arft.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arft paramarft)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramarft.toString());
    }
  }
  
  public Class<arft> clazz()
  {
    return arft.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 426;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfu
 * JD-Core Version:    0.7.0.1
 */