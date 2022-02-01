import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;

final class bmlt
  implements bmgl
{
  public void a(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(bmls.jdField_a_of_type_JavaLangString)) && (bmls.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)) {
      bmls.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(bmls.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      bmls.jdField_a_of_type_JavaLangString = null;
      bmls.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      bmgk.a().b(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        zvc.a(1, 2131718007);
        break;
      case 0: 
        zvc.a(2, 2131718025);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlt
 * JD-Core Version:    0.7.0.1
 */