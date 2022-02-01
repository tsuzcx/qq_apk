import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class aqln
  extends aptq<aqlm>
{
  public static void a()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    aqlm.a(false, (aqlm)apub.a().a(501));
  }
  
  @NonNull
  public aqlm a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new aqlm();
  }
  
  @Nullable
  public aqlm a(aptx[] paramArrayOfaptx)
  {
    return aqlm.a(paramArrayOfaptx);
  }
  
  public void a(aqlm paramaqlm)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    aqlm.a(true, paramaqlm);
  }
  
  public Class<aqlm> clazz()
  {
    return aqlm.class;
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
 * Qualified Name:     aqln
 * JD-Core Version:    0.7.0.1
 */