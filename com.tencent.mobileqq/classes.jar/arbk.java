import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arbk
  extends aqwt<arbj>
{
  @NonNull
  public arbj a(int paramInt)
  {
    return new arbj();
  }
  
  @Nullable
  public arbj a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onParsed] config");
    }
    return arbj.a(paramArrayOfaqxa);
  }
  
  public void a(arbj paramarbj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onUpdate]");
    }
  }
  
  public Class<arbj> clazz()
  {
    return arbj.class;
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
 * Qualified Name:     arbk
 * JD-Core Version:    0.7.0.1
 */