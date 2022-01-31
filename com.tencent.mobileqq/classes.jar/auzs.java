import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class auzs
  implements bevy
{
  auzs(auzr paramauzr) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label59;
      }
      if (this.a.jdField_a_of_type_Auzu != null) {
        this.a.jdField_a_of_type_Auzu.a(true);
      }
    }
    label59:
    while (this.a.jdField_a_of_type_Auzu == null) {
      return;
    }
    this.a.jdField_a_of_type_Auzu.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auzs
 * JD-Core Version:    0.7.0.1
 */