import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.AccountPanel.15.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class ayzn
  implements Observer
{
  ayzn(ayzg paramayzg) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((ayzg.a(this.a) == null) || (ayzg.a(this.a).isFinishing()) || (ayzg.a(this.a) == null)) {
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
    } while ((paramObservable.length != 2) || (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramObservable[0])));
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "update() -> before update");
    }
    ayzg.a(this.a).runOnUiThread(new AccountPanel.15.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzn
 * JD-Core Version:    0.7.0.1
 */