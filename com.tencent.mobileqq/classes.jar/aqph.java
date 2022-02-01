import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqph
  extends aqkz<aqpg>
{
  @NonNull
  public aqpg a(int paramInt)
  {
    return new aqpg();
  }
  
  @Nullable
  public aqpg a(aqlg[] paramArrayOfaqlg)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onParsed] config");
    return aqpg.a(paramArrayOfaqlg);
  }
  
  public void a(aqpg paramaqpg)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onUpdate]");
  }
  
  public Class<aqpg> clazz()
  {
    return aqpg.class;
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
 * Qualified Name:     aqph
 * JD-Core Version:    0.7.0.1
 */