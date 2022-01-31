import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.shadow.ReaderShadowImpl.1;

public class biwr
  implements EnterCallback
{
  public biwr(ReaderShadowImpl.1 param1, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onCloseLoadingView();
    }
    bixe.c("ReaderShadowImpl", "[onCloseLoadingView] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
  }
  
  public void onEnterComplete()
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onEnterComplete();
    }
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long == 1002L) {
      bixh.a(this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "0");
    }
    for (;;)
    {
      bixe.c("ReaderShadowImpl", "[onEnterComplete] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long == 1003L) {
        bixh.a(this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "1");
      }
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onShowLoadingView(paramView);
    }
    bixe.c("ReaderShadowImpl", "[onShowLoadingView] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biwr
 * JD-Core Version:    0.7.0.1
 */