import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqqo
  extends aqkz<aqqn>
{
  public static boolean a()
  {
    aqqn localaqqn = (aqqn)aqlk.a().a(613);
    if (localaqqn != null) {}
    for (boolean bool = localaqqn.a();; bool = false)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "isSwitchOpen = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public aqqn a(int paramInt)
  {
    return new aqqn();
  }
  
  @Nullable
  public aqqn a(aqlg[] paramArrayOfaqlg)
  {
    int i = 0;
    if (paramArrayOfaqlg == null) {}
    for (;;)
    {
      QLog.d("OpenSdkD55Processor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
        break;
      }
      new aqqn();
      return aqqn.a(paramArrayOfaqlg);
      i = paramArrayOfaqlg.length;
    }
    return null;
  }
  
  public void a(aqqn paramaqqn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkD55Processor", 2, "onUpdate " + paramaqqn.toString());
    }
  }
  
  public Class<aqqn> clazz()
  {
    return aqqn.class;
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
 * Qualified Name:     aqqo
 * JD-Core Version:    0.7.0.1
 */