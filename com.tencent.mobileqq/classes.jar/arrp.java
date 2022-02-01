import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public final class arrp
  extends arac<arro>
{
  public static void a()
  {
    QLog.d("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "initConfig");
    arro.a(false, (arro)aran.a().a(501));
  }
  
  @NonNull
  public arro a(int paramInt)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "migrateOldOrDefaultContent type:" + paramInt);
    return new arro();
  }
  
  @Nullable
  public arro a(araj[] paramArrayOfaraj)
  {
    return arro.a(paramArrayOfaraj);
  }
  
  public void a(arro paramarro)
  {
    QLog.w("TdsReaderView_TdsReaderGrayConfigProcessor", 1, "onUpdate");
    arro.a(true, paramarro);
  }
  
  public Class<arro> clazz()
  {
    return arro.class;
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
 * Qualified Name:     arrp
 * JD-Core Version:    0.7.0.1
 */