import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aooo
  extends aokh<aoon>
{
  public static aoon a()
  {
    return (aoon)aoks.a().a(489);
  }
  
  public int a()
  {
    return 489;
  }
  
  @NonNull
  public aoon a(int paramInt)
  {
    return new aoon();
  }
  
  @Nullable
  public aoon a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0)) {
      return aoon.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aoon> a()
  {
    return aoon.class;
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
  
  public void a(aoon paramaoon)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onUpdate " + paramaoon.toString());
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
 * Qualified Name:     aooo
 * JD-Core Version:    0.7.0.1
 */