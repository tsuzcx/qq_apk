import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public abstract class aptq<T>
{
  public static final int DEFAULT = 1;
  public static final int FAIL_CODE_ERROR = -2;
  public static final int FAIL_CODE_REQ_TIMEOUT = -1;
  public static final int MIGRATE = 0;
  private static final String TAG = "IQConfigProcessor";
  
  public abstract Class<T> clazz();
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public abstract boolean isNeedCompressed();
  
  public abstract boolean isNeedStoreLargeFile();
  
  public boolean isNeedUpgradeReset()
  {
    return false;
  }
  
  @NonNull
  public abstract T migrateOldOrDefaultContent(int paramInt);
  
  public abstract int migrateOldVersion();
  
  @Nullable
  public abstract T onParsed(aptx[] paramArrayOfaptx);
  
  public abstract void onReqFailed(int paramInt);
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQConfigProcessor", 2, "onReqNoReceive: type=" + type());
    }
  }
  
  public int onSend(int paramInt)
  {
    return paramInt;
  }
  
  public abstract void onUpdate(T paramT);
  
  public abstract int type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aptq
 * JD-Core Version:    0.7.0.1
 */