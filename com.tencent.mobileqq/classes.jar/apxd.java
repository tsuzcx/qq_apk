import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apxd
  extends aptq<apxe>
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
    apxe localapxe2 = (apxe)apub.a().a(531);
    apxe localapxe1 = localapxe2;
    if (localapxe2 == null)
    {
      localapxe2 = new apxe();
      localapxe1 = localapxe2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localapxe1 = localapxe2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localapxe1);
    }
    return localapxe1.a();
  }
  
  @NonNull
  public apxe a(int paramInt)
  {
    return new apxe();
  }
  
  @Nullable
  public apxe a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfaptx[0].a);
      }
      return apxe.a(paramArrayOfaptx[0].a);
    }
    return new apxe();
  }
  
  public void a(apxe paramapxe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramapxe);
    }
    if (paramapxe != null) {
      a = paramapxe.a();
    }
  }
  
  public Class<apxe> clazz()
  {
    return apxe.class;
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
 * Qualified Name:     apxd
 * JD-Core Version:    0.7.0.1
 */