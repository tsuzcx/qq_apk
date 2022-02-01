import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqof
  extends aqkz<aqog>
{
  public static boolean a;
  private static boolean b;
  
  public static boolean a()
  {
    if (b) {
      return a;
    }
    b = true;
    a = b();
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean isSwitchOpened = " + a);
    }
    return a;
  }
  
  private static boolean b()
  {
    aqog localaqog2 = (aqog)aqlk.a().a(531);
    aqog localaqog1 = localaqog2;
    if (localaqog2 == null)
    {
      localaqog2 = new aqog();
      localaqog1 = localaqog2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localaqog1 = localaqog2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localaqog1);
    }
    return localaqog1.a();
  }
  
  @NonNull
  public aqog a(int paramInt)
  {
    return new aqog();
  }
  
  @Nullable
  public aqog a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfaqlg[0].a);
      }
      return aqog.a(paramArrayOfaqlg[0].a);
    }
    return new aqog();
  }
  
  public void a(aqog paramaqog)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramaqog);
    }
    if (paramaqog != null) {
      a = paramaqog.a();
    }
  }
  
  public Class<aqog> clazz()
  {
    return aqog.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
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
    return 531;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqof
 * JD-Core Version:    0.7.0.1
 */