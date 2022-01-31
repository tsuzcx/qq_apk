import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.shadow.ReaderShadowImpl.1;

public class bgvs
  implements EnterCallback
{
  public bgvs(ReaderShadowImpl.1 param1, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onCloseLoadingView();
    }
    bgwf.c("ReaderShadowImpl", "[onCloseLoadingView] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
  }
  
  public void onEnterComplete()
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onEnterComplete();
    }
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long == 1002L) {
      bgwi.a(this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "0");
    }
    for (;;)
    {
      bgwf.c("ReaderShadowImpl", "[onEnterComplete] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long == 1003L) {
        bgwi.a(this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "1");
      }
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onShowLoadingView(paramView);
    }
    bgwf.c("ReaderShadowImpl", "[onShowLoadingView] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvs
 * JD-Core Version:    0.7.0.1
 */