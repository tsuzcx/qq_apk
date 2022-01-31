import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.share.FilterComboSharePlugin;

public class anqj
  implements WXShareHelper.WXShareListener
{
  public anqj(FilterComboSharePlugin paramFilterComboSharePlugin, int paramInt) {}
  
  public void a(BaseResp paramBaseResp)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.b == null) || (!this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.b.equals(paramBaseResp.transaction)))
    {
      if (!QLog.isColorLevel()) {
        break label162;
      }
      QLog.i("FilterComboShare", 2, "on share null");
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FilterComboShare", 2, "on share code " + paramBaseResp.errCode + " result " + bool);
      }
      if (bool)
      {
        FilterComboSharePlugin.a(this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin, this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.a, bool);
        this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.a(bool, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_DovComQqImCaptureViewShareFilterComboSharePlugin.a();
      }
      return;
      switch (paramBaseResp.errCode)
      {
      case -1: 
      default: 
        QRUtils.a(1, 2131435303);
        bool = false;
        break;
      case 0: 
        QRUtils.a(2, 2131435302);
        break;
      case -2: 
        label162:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqj
 * JD-Core Version:    0.7.0.1
 */