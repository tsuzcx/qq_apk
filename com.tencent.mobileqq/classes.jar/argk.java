import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argk
  extends aqwt<argl>
{
  @NonNull
  public argl a(int paramInt)
  {
    return new argl();
  }
  
  @Nullable
  public argl a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      argl localargl = argl.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherBusinessConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localargl;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(argl paramargl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "onUpdate " + paramargl.toString());
    }
  }
  
  public Class<argl> clazz()
  {
    return argl.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherBusinessConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 535;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argk
 * JD-Core Version:    0.7.0.1
 */