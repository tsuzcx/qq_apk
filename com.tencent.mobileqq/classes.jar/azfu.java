import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.AccountPanel.15.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class azfu
  implements Observer
{
  azfu(azfn paramazfn) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((azfn.a(this.a) == null) || (azfn.a(this.a).isFinishing()) || (azfn.a(this.a) == null)) {
      QLog.d("AccountPanel", 1, String.format("mObserver update return", new Object[0]));
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "update");
        }
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!antf.x.equals(paramObservable[0])));
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "update() -> before update");
    }
    azfn.a(this.a).runOnUiThread(new AccountPanel.15.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfu
 * JD-Core Version:    0.7.0.1
 */