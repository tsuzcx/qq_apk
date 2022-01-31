import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aokf
  extends aofy<aoke>
{
  public static aoke a()
  {
    return (aoke)aogj.a().a(489);
  }
  
  public int a()
  {
    return 489;
  }
  
  @NonNull
  public aoke a(int paramInt)
  {
    return new aoke();
  }
  
  @Nullable
  public aoke a(aogf[] paramArrayOfaogf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0)) {
      return aoke.a(paramArrayOfaogf);
    }
    return null;
  }
  
  public Class<aoke> a()
  {
    return aoke.class;
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
  
  public void a(aoke paramaoke)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramaoke.toString());
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
 * Qualified Name:     aokf
 * JD-Core Version:    0.7.0.1
 */