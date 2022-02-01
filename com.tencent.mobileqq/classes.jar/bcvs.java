import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp.1.1;

public class bcvs
  extends ContentObserver
{
  bcvs(bcvr parambcvr, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    ThreadManager.post(new QZoneManagerImp.1.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvs
 * JD-Core Version:    0.7.0.1
 */