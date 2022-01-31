import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class amsr
  extends ampa<amsq>
{
  public int a()
  {
    return 598;
  }
  
  @NonNull
  public amsq a(int paramInt)
  {
    return new amsq();
  }
  
  @Nullable
  public amsq a(amph[] paramArrayOfamph)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LebaRedTouchSwitchProcessor", 2, "[onParsed] config");
    }
    return amsq.a(paramArrayOfamph);
  }
  
  public Class<amsq> a()
  {
    return amsq.class;
  }
  
  public void a(int paramInt)
  {
    QLog.d("LebaRedTouchSwitchProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public void a(amsq paramamsq)
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
 * Qualified Name:     amsr
 * JD-Core Version:    0.7.0.1
 */