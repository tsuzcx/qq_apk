import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amte
  extends ampb<amtd>
{
  public static amtd a()
  {
    return (amtd)ampm.a().a(489);
  }
  
  public int a()
  {
    return 489;
  }
  
  @NonNull
  public amtd a(int paramInt)
  {
    return new amtd();
  }
  
  @Nullable
  public amtd a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfampi != null) && (paramArrayOfampi.length > 0)) {
      return amtd.a(paramArrayOfampi);
    }
    return null;
  }
  
  public Class<amtd> a()
  {
    return amtd.class;
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
  
  public void a(amtd paramamtd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramamtd.toString());
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
 * Qualified Name:     amte
 * JD-Core Version:    0.7.0.1
 */