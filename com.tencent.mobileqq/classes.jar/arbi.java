import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbi
  extends aqwt<arbh>
{
  @NonNull
  public arbh a(int paramInt)
  {
    return new arbh();
  }
  
  @Nullable
  public arbh a(aqxa[] paramArrayOfaqxa)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onParsed] config");
    return arbh.a(paramArrayOfaqxa);
  }
  
  public void a(arbh paramarbh)
  {
    QLog.i("LebaQzoneStyleProcessor", 1, "[onUpdate]");
  }
  
  public Class<arbh> clazz()
  {
    return arbh.class;
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
 * Qualified Name:     arbi
 * JD-Core Version:    0.7.0.1
 */