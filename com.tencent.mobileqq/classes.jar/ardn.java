import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ardn
  extends arac<ardo>
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
    ardo localardo2 = (ardo)aran.a().a(531);
    ardo localardo1 = localardo2;
    if (localardo2 == null)
    {
      localardo2 = new ardo();
      localardo1 = localardo2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localardo1 = localardo2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localardo1);
    }
    return localardo1.a();
  }
  
  @NonNull
  public ardo a(int paramInt)
  {
    return new ardo();
  }
  
  @Nullable
  public ardo a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfaraj[0].a);
      }
      return ardo.a(paramArrayOfaraj[0].a);
    }
    return new ardo();
  }
  
  public void a(ardo paramardo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramardo);
    }
    if (paramardo != null) {
      a = paramardo.a();
    }
  }
  
  public Class<ardo> clazz()
  {
    return ardo.class;
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
 * Qualified Name:     ardn
 * JD-Core Version:    0.7.0.1
 */