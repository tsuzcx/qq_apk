import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amdc
  extends alzl<amdb>
{
  public static amdb a()
  {
    return (amdb)alzw.a().a(489);
  }
  
  public int a()
  {
    return 489;
  }
  
  @NonNull
  public amdb a(int paramInt)
  {
    return new amdb();
  }
  
  @Nullable
  public amdb a(alzs[] paramArrayOfalzs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfalzs != null) && (paramArrayOfalzs.length > 0)) {
      return amdb.a(paramArrayOfalzs);
    }
    return null;
  }
  
  public Class<amdb> a()
  {
    return amdb.class;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqNoReceive ");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public void a(amdb paramamdb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramamdb.toString());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdc
 * JD-Core Version:    0.7.0.1
 */