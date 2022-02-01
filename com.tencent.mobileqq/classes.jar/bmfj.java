import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;

class bmfj
  implements EnterCallback
{
  bmfj(bmfi parambmfi, EnterCallback paramEnterCallback, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onCloseLoadingView();
    }
    bmqw.c("IliveAuthShadowImpl", "[onCloseLoadingView] formId = " + this.jdField_a_of_type_Long);
  }
  
  public void onEnterComplete()
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onEnterComplete();
    }
    bmqw.c("IliveAuthShadowImpl", "[onEnterComplete] formId = " + this.jdField_a_of_type_Long);
  }
  
  public void onShowLoadingView(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onShowLoadingView(paramView);
    }
    bmqw.c("IliveAuthShadowImpl", "[onShowLoadingView] formId = " + this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfj
 * JD-Core Version:    0.7.0.1
 */