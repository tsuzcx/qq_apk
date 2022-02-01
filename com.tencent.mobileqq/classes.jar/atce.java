import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.EventObserver.1;
import java.util.Observable;
import java.util.Observer;

public class atce
  implements Observer
{
  private void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    paramObject = (Object[])paramObject[1];
    if (i == 1) {
      a(((Integer)paramObject[0]).intValue());
    }
    do
    {
      return;
      if (i == 2)
      {
        a((Bundle)paramObject[0]);
        return;
      }
    } while (i != 3);
    a(((Boolean)paramObject[0]).booleanValue(), (Bundle)paramObject[1]);
  }
  
  public void a(int paramInt) {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new QfileFavFileRecordProvider.EventObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atce
 * JD-Core Version:    0.7.0.1
 */