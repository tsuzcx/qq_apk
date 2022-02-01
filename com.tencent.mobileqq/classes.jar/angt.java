import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;

class angt
  implements WXShareHelper.WXShareListener
{
  angt(angs paramangs, int paramInt) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp == null) || (paramBaseResp.transaction == null))
    {
      QLog.e("AVGameShareBase", 1, "onWXShareResp: respData is null");
      return;
    }
    if (!paramBaseResp.transaction.equals(this.jdField_a_of_type_Angs.jdField_a_of_type_JavaLangString))
    {
      QLog.e("AVGameShareBase", 1, "onWXShareResp: mWXTransaction is wrong");
      return;
    }
    WXShareHelper.getInstance().removeObserver(this.jdField_a_of_type_Angs.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    this.jdField_a_of_type_Angs.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = null;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      this.jdField_a_of_type_Angs.d(this.jdField_a_of_type_Int);
      return;
    case 0: 
      this.jdField_a_of_type_Angs.b(this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Angs.c(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angt
 * JD-Core Version:    0.7.0.1
 */