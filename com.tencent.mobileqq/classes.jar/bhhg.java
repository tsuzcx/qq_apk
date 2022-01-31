import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;
import dov.com.qq.im.capture.data.ComboLockManager;

public class bhhg
  extends QQUIEventReceiver<ComboLockManager, sjc>
{
  boolean a = false;
  
  public bhhg(@NonNull ComboLockManager paramComboLockManager)
  {
    super(paramComboLockManager);
  }
  
  public void a(@NonNull ComboLockManager paramComboLockManager, @NonNull sjc paramsjc)
  {
    if (!this.a)
    {
      paramComboLockManager.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return sjc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhhg
 * JD-Core Version:    0.7.0.1
 */