import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arha
  extends aqwt<argz>
{
  @NonNull
  public argz a(int paramInt)
  {
    return new argz();
  }
  
  @Nullable
  public argz a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null))
    {
      argz localargz = argz.a(paramArrayOfaqxa[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return localargz;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(argz paramargz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, "onUpdate " + paramargz.toString());
    }
  }
  
  public Class<argz> clazz()
  {
    return argz.class;
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
      QLog.d("WVPreloadPskeyConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WVPreloadPskeyConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 585;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arha
 * JD-Core Version:    0.7.0.1
 */