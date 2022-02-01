import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arfx
  extends aqwt<arfw>
{
  private static arfw a;
  
  public static arfw a()
  {
    arfw localarfw2 = (arfw)aqxe.a().a(436);
    arfw localarfw1 = localarfw2;
    if (localarfw2 == null) {
      localarfw1 = arfw.a();
    }
    return localarfw1;
  }
  
  @NonNull
  public arfw a(int paramInt)
  {
    if (a != null) {
      return a;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScannerQQCodeConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    a = arfw.a();
    return a;
  }
  
  @Nullable
  public arfw a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = arfw.a(paramArrayOfaqxa[0].a);
      a = null;
      return paramArrayOfaqxa;
    }
    return arfw.a();
  }
  
  public void a(arfw paramarfw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerQQCodeConfProcessor", 2, "onUpdate newConf:" + paramarfw);
    }
  }
  
  public Class<arfw> clazz()
  {
    return arfw.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerQQCodeConfProcessor", 2, "onReqFailed failCode:" + paramInt);
    }
  }
  
  public int type()
  {
    return 436;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arfx
 * JD-Core Version:    0.7.0.1
 */