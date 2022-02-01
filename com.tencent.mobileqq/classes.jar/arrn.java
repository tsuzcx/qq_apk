import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class arrn
  extends arac<arrm>
{
  public static void a()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    arrm.a(false, (arrm)aran.a().a(482));
  }
  
  @NonNull
  public arrm a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new arrm();
  }
  
  @Nullable
  public arrm a(araj[] paramArrayOfaraj)
  {
    return arrm.a(paramArrayOfaraj);
  }
  
  public void a(arrm paramarrm)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    arrm.a(true, paramarrm);
  }
  
  public Class<arrm> clazz()
  {
    return arrm.class;
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
 * Qualified Name:     arrn
 * JD-Core Version:    0.7.0.1
 */