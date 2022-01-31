import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;

final class bjtb
  implements bjnu
{
  public void a(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(bjta.jdField_a_of_type_JavaLangString)) && (bjta.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)) {
      bjta.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(bjta.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      bjta.jdField_a_of_type_JavaLangString = null;
      bjta.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      bjnt.a().b(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        xxb.a(1, 2131720019);
        break;
      case 0: 
        xxb.a(2, 2131720038);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjtb
 * JD-Core Version:    0.7.0.1
 */