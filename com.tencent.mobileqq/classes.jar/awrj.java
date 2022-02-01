import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

final class awrj
  implements WXShareHelper.WXShareListener
{
  awrj(String paramString, awro paramawro) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.getInstance().removeObserver(this);
      if (paramBaseResp.errCode != 0) {
        break label50;
      }
      if (this.jdField_a_of_type_Awro != null) {
        this.jdField_a_of_type_Awro.a(true);
      }
    }
    label50:
    while (this.jdField_a_of_type_Awro == null) {
      return;
    }
    this.jdField_a_of_type_Awro.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrj
 * JD-Core Version:    0.7.0.1
 */