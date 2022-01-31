import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;

final class bhrq
  implements bhmj
{
  public void a(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(bhrp.jdField_a_of_type_JavaLangString)) && (bhrp.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)) {
      bhrp.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(bhrp.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      bhrp.jdField_a_of_type_JavaLangString = null;
      bhrp.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      bhmi.a().b(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        wij.a(1, 2131719487);
        break;
      case 0: 
        wij.a(2, 2131719506);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrq
 * JD-Core Version:    0.7.0.1
 */