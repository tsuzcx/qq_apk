import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class axxo
  implements biyn
{
  axxo(axxn paramaxxn) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label59;
      }
      if (this.a.jdField_a_of_type_Axxq != null) {
        this.a.jdField_a_of_type_Axxq.a(true);
      }
    }
    label59:
    while (this.a.jdField_a_of_type_Axxq == null) {
      return;
    }
    this.a.jdField_a_of_type_Axxq.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxo
 * JD-Core Version:    0.7.0.1
 */