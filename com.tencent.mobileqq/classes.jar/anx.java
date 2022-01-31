import com.qq.im.poi.LbsPackShareOption;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class anx
  implements WXShareHelper.WXShareListener
{
  public anx(LbsPackShareOption paramLbsPackShareOption, int paramInt) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_ComQqImPoiLbsPackShareOption.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComQqImPoiLbsPackShareOption.jdField_a_of_type_JavaLangString.equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      QRUtils.a(1, 2131435319);
      return;
    }
    QRUtils.a(2, 2131435318);
    LbsPackShareOption.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComQqImPoiLbsPackShareOption.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anx
 * JD-Core Version:    0.7.0.1
 */