import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arep
  extends arac<areo>
{
  @NonNull
  public areo a(int paramInt)
  {
    return new areo();
  }
  
  @Nullable
  public areo a(araj[] paramArrayOfaraj)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onParsed] config");
    return areo.a(paramArrayOfaraj);
  }
  
  public void a(areo paramareo)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onUpdate]");
  }
  
  public Class<areo> clazz()
  {
    return areo.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 614;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arep
 * JD-Core Version:    0.7.0.1
 */