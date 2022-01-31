import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amtd
  extends ampa<amtc>
{
  public static amtc a()
  {
    return (amtc)ampl.a().a(489);
  }
  
  public int a()
  {
    return 489;
  }
  
  @NonNull
  public amtc a(int paramInt)
  {
    return new amtc();
  }
  
  @Nullable
  public amtc a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0)) {
      return amtc.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<amtc> a()
  {
    return amtc.class;
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
  
  public void a(amtc paramamtc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramamtc.toString());
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
 * Qualified Name:     amtd
 * JD-Core Version:    0.7.0.1
 */