import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arer
  extends arac<areq>
{
  @NonNull
  public areq a(int paramInt)
  {
    return new areq();
  }
  
  @Nullable
  public areq a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onParsed] config");
    }
    return areq.a(paramArrayOfaraj);
  }
  
  public void a(areq paramareq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<areq> clazz()
  {
    return areq.class;
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
    QLog.d("LebaRedTouchSwitchProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 598;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arer
 * JD-Core Version:    0.7.0.1
 */