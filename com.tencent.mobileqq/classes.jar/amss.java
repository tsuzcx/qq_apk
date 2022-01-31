import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amss
  extends ampb<amsr>
{
  public int a()
  {
    return 598;
  }
  
  @NonNull
  public amsr a(int paramInt)
  {
    return new amsr();
  }
  
  @Nullable
  public amsr a(ampi[] paramArrayOfampi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onParsed] config");
    }
    return amsr.a(paramArrayOfampi);
  }
  
  public Class<amsr> a()
  {
    return amsr.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("LebaRedTouchSwitchProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public void a(amsr paramamsr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onUpdate]");
    }
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
 * Qualified Name:     amss
 * JD-Core Version:    0.7.0.1
 */