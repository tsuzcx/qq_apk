import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;

final class bjxi
  implements bjsb
{
  public void a(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(bjxh.jdField_a_of_type_JavaLangString)) && (bjxh.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)) {
      bjxh.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(bjxh.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      bjxh.jdField_a_of_type_JavaLangString = null;
      bjxh.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      bjsa.a().b(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        ybk.a(1, 2131720031);
        break;
      case 0: 
        ybk.a(2, 2131720050);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxi
 * JD-Core Version:    0.7.0.1
 */