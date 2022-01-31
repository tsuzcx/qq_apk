import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.qq.im.capture.data.ComboLockManager;

public class bjcp
  extends QQUIEventReceiver<ComboLockManager, svv>
{
  boolean a = false;
  
  public bjcp(@NonNull ComboLockManager paramComboLockManager)
  {
    super(paramComboLockManager);
  }
  
  public void a(@NonNull ComboLockManager paramComboLockManager, @NonNull svv paramsvv)
  {
    if (!this.a)
    {
      paramComboLockManager.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return svv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjcp
 * JD-Core Version:    0.7.0.1
 */