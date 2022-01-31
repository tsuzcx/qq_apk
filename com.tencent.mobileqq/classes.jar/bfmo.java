import android.content.Context;
import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;

final class bfmo
  implements EnterCallback
{
  bfmo(EnterCallback paramEnterCallback, Context paramContext, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    bfne.d("ReaderPluginHelper", "startPluginActivity [onCloseLoadingView]");
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onCloseLoadingView();
    }
  }
  
  public void onEnterComplete()
  {
    bfne.d("ReaderPluginHelper", "startPluginActivity [onEnterComplete]");
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onEnterComplete();
    }
    bfnk.a(this.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "1");
  }
  
  public void onShowLoadingView(View paramView)
  {
    bfne.d("ReaderPluginHelper", "startPluginActivity [onShowLoadingView]");
    if (this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onShowLoadingView(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmo
 * JD-Core Version:    0.7.0.1
 */