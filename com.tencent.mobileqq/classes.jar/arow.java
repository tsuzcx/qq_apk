import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class arow
  extends aqwt<arov>
{
  public static void a()
  {
    QLog.d("TdsReaderView_TdsReaderConfigProcessor", 1, "initConfig");
    arov.a(false, (arov)aqxe.a().a(482));
  }
  
  @NonNull
  public arov a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new arov();
  }
  
  @Nullable
  public arov a(aqxa[] paramArrayOfaqxa)
  {
    return arov.a(paramArrayOfaqxa);
  }
  
  public void a(arov paramarov)
  {
    QLog.w("TdsReaderView_TdsReaderConfigProcessor", 1, "onUpdate");
    arov.a(true, paramarov);
  }
  
  public Class<arov> clazz()
  {
    return arov.class;
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
 * Qualified Name:     arow
 * JD-Core Version:    0.7.0.1
 */