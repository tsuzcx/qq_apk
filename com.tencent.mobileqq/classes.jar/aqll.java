import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aqll
  extends aptq<aqlk>
{
  public static void a()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    aqlk.a(false, (aqlk)apub.a().a(482));
  }
  
  @NonNull
  public aqlk a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aqlk();
  }
  
  @Nullable
  public aqlk a(aptx[] paramArrayOfaptx)
  {
    return aqlk.a(paramArrayOfaptx);
  }
  
  public void a(aqlk paramaqlk)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    aqlk.a(true, paramaqlk);
  }
  
  public Class<aqlk> clazz()
  {
    return aqlk.class;
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
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.e("TdsReaderView_TdsReaderConfigProcessor", 1, "onReqFailed: " + paramInt);
  }
  
  public int type()
  {
    return 482;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqll
 * JD-Core Version:    0.7.0.1
 */