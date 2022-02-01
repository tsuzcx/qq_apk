import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arag
  extends aqwt<arah>
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
    arah localarah2 = (arah)aqxe.a().a(531);
    arah localarah1 = localarah2;
    if (localarah2 == null)
    {
      localarah2 = new arah();
      localarah1 = localarah2;
      if (QLog.isColorLevel())
      {
        QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean = null, general new bean, so switch default");
        localarah1 = localarah2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "DarkModeConfigBean switch isOpened = " + localarah1);
    }
    return localarah1.a();
  }
  
  @NonNull
  public arah a(int paramInt)
  {
    return new arah();
  }
  
  @Nullable
  public arah a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DarkModeConfigProcessor", 2, "onParsed : " + paramArrayOfaqxa[0].a);
      }
      return arah.a(paramArrayOfaqxa[0].a);
    }
    return new arah();
  }
  
  public void a(arah paramarah)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DarkModeConfigProcessor", 2, "onUpdate : " + paramarah);
    }
    if (paramarah != null) {
      a = paramarah.a();
    }
  }
  
  public Class<arah> clazz()
  {
    return arah.class;
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
 * Qualified Name:     arag
 * JD-Core Version:    0.7.0.1
 */