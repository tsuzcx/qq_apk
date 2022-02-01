import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aroy
  extends aqwt<arox>
{
  public static void a()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    arox.a(false, (arox)aqxe.a().a(501));
  }
  
  @NonNull
  public arox a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new arox();
  }
  
  @Nullable
  public arox a(aqxa[] paramArrayOfaqxa)
  {
    return arox.a(paramArrayOfaqxa);
  }
  
  public void a(arox paramarox)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    arox.a(true, paramarox);
  }
  
  public Class<arox> clazz()
  {
    return arox.class;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 501;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aroy
 * JD-Core Version:    0.7.0.1
 */