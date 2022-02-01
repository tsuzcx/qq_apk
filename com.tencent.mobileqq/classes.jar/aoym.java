import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.mobileqq.app.BusinessObserver;

class aoym
  implements BusinessObserver
{
  aoym(aoyk paramaoyk, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onUpdate(paramInt, paramBoolean, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoym
 * JD-Core Version:    0.7.0.1
 */