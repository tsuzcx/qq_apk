import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aqpx
  extends aqkz<aqpw>
{
  public static aqpw a()
  {
    return (aqpw)aqlk.a().a(489);
  }
  
  @NonNull
  public aqpw a(int paramInt)
  {
    return new aqpw();
  }
  
  @Nullable
  public aqpw a(aqlg[] paramArrayOfaqlg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0)) {
      return aqpw.a(paramArrayOfaqlg);
    }
    return null;
  }
  
  public void a(aqpw paramaqpw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramaqpw.toString());
    }
  }
  
  public Class<aqpw> clazz()
  {
    return aqpw.class;
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
 * Qualified Name:     aqpx
 * JD-Core Version:    0.7.0.1
 */