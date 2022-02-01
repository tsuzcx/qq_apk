import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.listener.ICmdListener;
import java.lang.ref.WeakReference;

public class bhdm
  implements ICmdManager
{
  private ICmdListener jdField_a_of_type_ComTencentVasUpdateCallbackListenerICmdListener;
  WeakReference<VasExtensionHandler> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ICmdListener a()
  {
    return this.jdField_a_of_type_ComTencentVasUpdateCallbackListenerICmdListener;
  }
  
  public void a(WeakReference<VasExtensionHandler> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
  }
  
  public boolean sendPbRequest(String paramString1, String paramString2, ICmdListener paramICmdListener)
  {
    this.jdField_a_of_type_ComTencentVasUpdateCallbackListenerICmdListener = paramICmdListener;
    paramICmdListener = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramICmdListener != null)
    {
      paramICmdListener = (VasExtensionHandler)paramICmdListener.get();
      if (paramICmdListener != null) {
        return paramICmdListener.a(paramString1, paramString2);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdm
 * JD-Core Version:    0.7.0.1
 */