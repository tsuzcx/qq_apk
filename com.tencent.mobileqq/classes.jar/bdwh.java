import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dualsim.common.IKingCardInterface.OnChangeListener;
import dualsim.common.OrderCheckResult;
import mqq.app.AppRuntime;

public class bdwh
  implements IKingCardInterface.OnChangeListener
{
  public void onChanged(OrderCheckResult paramOrderCheckResult)
  {
    if (QLog.isColorLevel()) {
      QLog.e("KC.KCWraperV2", 1, "state changed");
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((AppRuntime)localObject).getAccount())
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramOrderCheckResult != null)) {
        bdwd.a((String)localObject, paramOrderCheckResult);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwh
 * JD-Core Version:    0.7.0.1
 */