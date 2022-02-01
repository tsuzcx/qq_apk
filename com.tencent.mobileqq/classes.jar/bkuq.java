import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.qqreader.shadow.ReaderShadowImpl.1;

public class bkuq
  implements EnterCallback
{
  public bkuq(ReaderShadowImpl.1 param1, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onCloseLoadingView();
    }
    bkvd.c("ReaderShadowImpl", "[onCloseLoadingView] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
  }
  
  public void onEnterComplete()
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onEnterComplete();
    }
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long == 1002L) {
      bkvg.a(this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "0");
    }
    for (;;)
    {
      bkvd.c("ReaderShadowImpl", "[onEnterComplete] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long == 1003L) {
        bkvg.a(this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "1");
      }
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    if (this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback != null) {
      this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_ComTencentShadowDynamicHostEnterCallback.onShowLoadingView(paramView);
    }
    bkvd.c("ReaderShadowImpl", "[onShowLoadingView] formId = " + this.jdField_a_of_type_CooperationQqreaderShadowReaderShadowImpl$1.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuq
 * JD-Core Version:    0.7.0.1
 */