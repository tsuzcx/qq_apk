import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class awrn
  implements WXShareHelper.WXShareListener
{
  awrn(awrl paramawrl) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.getInstance().removeObserver(this);
      if (paramBaseResp.errCode != 0) {
        break label59;
      }
      if (this.a.jdField_a_of_type_Awro != null) {
        this.a.jdField_a_of_type_Awro.a(true);
      }
    }
    label59:
    while (this.a.jdField_a_of_type_Awro == null) {
      return;
    }
    this.a.jdField_a_of_type_Awro.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrn
 * JD-Core Version:    0.7.0.1
 */