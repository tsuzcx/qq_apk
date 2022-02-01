import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class axxk
  implements biyn
{
  axxk(String paramString, axxq paramaxxq) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label50;
      }
      if (this.jdField_a_of_type_Axxq != null) {
        this.jdField_a_of_type_Axxq.a(true);
      }
    }
    label50:
    while (this.jdField_a_of_type_Axxq == null) {
      return;
    }
    this.jdField_a_of_type_Axxq.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxk
 * JD-Core Version:    0.7.0.1
 */