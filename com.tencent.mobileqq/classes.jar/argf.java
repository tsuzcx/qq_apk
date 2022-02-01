import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class argf
  extends aqwt<argg>
{
  @NonNull
  public argg a(int paramInt)
  {
    return new argg();
  }
  
  @Nullable
  public argg a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0) && (paramArrayOfaqxa[0] != null)) {
      return argg.a(paramArrayOfaqxa[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onParsed is null");
    }
    return null;
  }
  
  public void a(argg paramargg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, "onUpdate " + paramargg.toString());
    }
  }
  
  public Class<argg> clazz()
  {
    return argg.class;
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
      QLog.d("SubAccountConfProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountConfProcessor", 2, new Object[] { "onReqFailed ", Integer.valueOf(paramInt) });
    }
  }
  
  public int type()
  {
    return 607;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     argf
 * JD-Core Version:    0.7.0.1
 */