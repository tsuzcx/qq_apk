import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;

final class bgig
  implements bgdf
{
  public void a(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(bgif.jdField_a_of_type_JavaLangString)) && (bgif.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)) {
      bgif.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(bgif.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      bgif.jdField_a_of_type_JavaLangString = null;
      bgif.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      bgde.a().b(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        vvp.a(1, 2131653595);
        break;
      case 0: 
        vvp.a(2, 2131653612);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgig
 * JD-Core Version:    0.7.0.1
 */