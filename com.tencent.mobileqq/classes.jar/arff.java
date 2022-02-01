import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class arff
  extends arac<arfe>
{
  public static arfe a()
  {
    return (arfe)aran.a().a(489);
  }
  
  @NonNull
  public arfe a(int paramInt)
  {
    return new arfe();
  }
  
  @Nullable
  public arfe a(araj[] paramArrayOfaraj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0)) {
      return arfe.a(paramArrayOfaraj);
    }
    return null;
  }
  
  public void a(arfe paramarfe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramarfe.toString());
    }
  }
  
  public Class<arfe> clazz()
  {
    return arfe.class;
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
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqNoReceive ");
    }
  }
  
  public int type()
  {
    return 489;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arff
 * JD-Core Version:    0.7.0.1
 */