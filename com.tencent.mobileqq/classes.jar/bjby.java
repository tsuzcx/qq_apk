import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.qq.im.capture.data.ComboLockManager;

public class bjby
  extends QQUIEventReceiver<ComboLockManager, svy>
{
  boolean a = false;
  
  public bjby(@NonNull ComboLockManager paramComboLockManager)
  {
    super(paramComboLockManager);
  }
  
  public void a(@NonNull ComboLockManager paramComboLockManager, @NonNull svy paramsvy)
  {
    if (!this.a)
    {
      paramComboLockManager.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return svy.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjby
 * JD-Core Version:    0.7.0.1
 */