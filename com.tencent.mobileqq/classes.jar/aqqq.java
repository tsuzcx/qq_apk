import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqqq
  extends aqkz<aqqp>
{
  public static boolean a()
  {
    aqqp localaqqp = (aqqp)aqlk.a().a(632);
    if (localaqqp != null) {}
    for (boolean bool = localaqqp.a();; bool = false)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "isEnableFakeMsg = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public aqqp a(int paramInt)
  {
    return new aqqp();
  }
  
  @Nullable
  public aqqp a(aqlg[] paramArrayOfaqlg)
  {
    int i = 0;
    if (paramArrayOfaqlg == null) {}
    for (;;)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfaqlg == null) || (paramArrayOfaqlg.length <= 0)) {
        break;
      }
      new aqqp();
      return aqqp.a(paramArrayOfaqlg);
      i = paramArrayOfaqlg.length;
    }
    return null;
  }
  
  public void a(aqqp paramaqqp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 2, "onUpdate " + paramaqqp.toString());
    }
  }
  
  public Class<aqqp> clazz()
  {
    return aqqp.class;
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
    return 632;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqqq
 * JD-Core Version:    0.7.0.1
 */