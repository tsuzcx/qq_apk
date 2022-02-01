import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class azhc
  implements BusinessObserver
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiObserver", 2, "onUpdate() called with: type = [" + paramInt + "], isSuccess = [" + paramBoolean + "], data = [" + paramObject + "]");
    }
    switch (paramInt)
    {
    case 1003: 
    case 1004: 
    case 1005: 
    default: 
      return;
    case 1001: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694497, 0).a();
      return;
    case 1002: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694492, 0).a();
      return;
    case 1006: 
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694493, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131694488, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhc
 * JD-Core Version:    0.7.0.1
 */