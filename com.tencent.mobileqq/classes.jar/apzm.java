import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apzm
  extends aptq<apzl>
{
  public static boolean a()
  {
    apzl localapzl = (apzl)apub.a().a(613);
    if (localapzl != null) {}
    for (boolean bool = localapzl.a();; bool = false)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "isSwitchOpen = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public apzl a(int paramInt)
  {
    return new apzl();
  }
  
  @Nullable
  public apzl a(aptx[] paramArrayOfaptx)
  {
    int i = 0;
    if (paramArrayOfaptx == null) {}
    for (;;)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaptx == null) || (paramArrayOfaptx.length <= 0)) {
        break;
      }
      new apzl();
      return apzl.a(paramArrayOfaptx);
      i = paramArrayOfaptx.length;
    }
    return null;
  }
  
  public void a(apzl paramapzl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkD55Processor", 2, "onUpdate " + paramapzl.toString());
    }
  }
  
  public Class<apzl> clazz()
  {
    return apzl.class;
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
    return 613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apzm
 * JD-Core Version:    0.7.0.1
 */