import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class awjo
  implements bfah
{
  public awjo(PicShareToWX paramPicShareToWX, int paramInt) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWX", 1, "onWXShareResp resp.errCode = " + paramBaseResp.errCode + ", fromType = " + this.jdField_a_of_type_Int);
    }
    if (paramBaseResp.errCode == 0)
    {
      PicShareToWX.a(this.jdField_a_of_type_Int, true);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, true, 0, 1);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      PicShareToWX.a(this.jdField_a_of_type_Int, false);
      PicShareToWX.a(this.jdField_a_of_type_ComTencentMobileqqPicPicShareToWX, false, paramBaseResp.errCode, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjo
 * JD-Core Version:    0.7.0.1
 */