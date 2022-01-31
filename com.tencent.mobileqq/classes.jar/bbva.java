import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bbva
  extends Handler
{
  private WeakReference<BeginnerGuideFragment> a;
  
  public bbva(BeginnerGuideFragment paramBeginnerGuideFragment, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramBeginnerGuideFragment);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    BeginnerGuideFragment localBeginnerGuideFragment = (BeginnerGuideFragment)this.a.get();
    if (localBeginnerGuideFragment == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1110: 
        if (QLog.isColorLevel()) {
          QLog.d("BeginnerGuideFragment", 2, "parse config from network success");
        }
        break;
      }
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String)));
    BeginnerGuideFragment.a(localBeginnerGuideFragment, (String)paramMessage.obj, paramMessage.arg1);
    return;
    BeginnerGuideFragment.a(localBeginnerGuideFragment, paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbva
 * JD-Core Version:    0.7.0.1
 */