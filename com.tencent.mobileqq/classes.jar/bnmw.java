import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;

final class bnmw
  implements bnhn
{
  public void a(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(bnmv.jdField_a_of_type_JavaLangString)) && (bnmv.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)) {
      bnmv.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(bnmv.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      bnmv.jdField_a_of_type_JavaLangString = null;
      bnmv.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      bnhm.a().b(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        zyx.a(1, 2131718139);
        break;
      case 0: 
        zyx.a(2, 2131718157);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmw
 * JD-Core Version:    0.7.0.1
 */