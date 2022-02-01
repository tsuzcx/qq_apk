import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfw
  extends arac<arfv>
{
  public static boolean a()
  {
    arfv localarfv = (arfv)aran.a().a(613);
    if (localarfv != null) {}
    for (boolean bool = localarfv.a();; bool = false)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "isSwitchOpen = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public arfv a(int paramInt)
  {
    return new arfv();
  }
  
  @Nullable
  public arfv a(araj[] paramArrayOfaraj)
  {
    int i = 0;
    if (paramArrayOfaraj == null) {}
    for (;;)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaraj == null) || (paramArrayOfaraj.length <= 0)) {
        break;
      }
      new arfv();
      return arfv.a(paramArrayOfaraj);
      i = paramArrayOfaraj.length;
    }
    return null;
  }
  
  public void a(arfv paramarfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkD55Processor", 2, "onUpdate " + paramarfv.toString());
    }
  }
  
  public Class<arfv> clazz()
  {
    return arfv.class;
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
 * Qualified Name:     arfw
 * JD-Core Version:    0.7.0.1
 */