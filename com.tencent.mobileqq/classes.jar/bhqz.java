import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;

final class bhqz
  implements bhls
{
  public void a(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(bhqy.jdField_a_of_type_JavaLangString)) && (bhqy.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null)) {
      bhqy.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(bhqy.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      bhqy.jdField_a_of_type_JavaLangString = null;
      bhqy.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
      bhlr.a().b(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        wim.a(1, 2131719476);
        break;
      case 0: 
        wim.a(2, 2131719495);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqz
 * JD-Core Version:    0.7.0.1
 */