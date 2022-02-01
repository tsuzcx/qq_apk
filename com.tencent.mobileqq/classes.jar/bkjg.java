import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;

class bkjg
  implements EnterCallback
{
  bkjg(bkjf parambkjf, EnterCallback paramEnterCallback, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onCloseLoadingView();
    }
    bkvd.c("IliveAuthShadowImpl", "[onCloseLoadingView] formId = " + this.jdField_a_of_type_Long);
  }
  
  public void onEnterComplete()
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onEnterComplete();
    }
    bkvd.c("IliveAuthShadowImpl", "[onEnterComplete] formId = " + this.jdField_a_of_type_Long);
  }
  
  public void onShowLoadingView(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onShowLoadingView(paramView);
    }
    bkvd.c("IliveAuthShadowImpl", "[onShowLoadingView] formId = " + this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjg
 * JD-Core Version:    0.7.0.1
 */