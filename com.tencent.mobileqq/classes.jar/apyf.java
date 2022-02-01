import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apyf
  extends aptq<apye>
{
  @NonNull
  public apye a(int paramInt)
  {
    return new apye();
  }
  
  @Nullable
  public apye a(aptx[] paramArrayOfaptx)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onParsed] config");
    return apye.a(paramArrayOfaptx);
  }
  
  public void a(apye paramapye)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onUpdate]");
  }
  
  public Class<apye> clazz()
  {
    return apye.class;
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
 * Qualified Name:     apyf
 * JD-Core Version:    0.7.0.1
 */