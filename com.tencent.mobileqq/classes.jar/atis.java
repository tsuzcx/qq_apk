import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class atis
  implements bcww
{
  atis(atir paramatir) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label59;
      }
      if (this.a.jdField_a_of_type_Atiu != null) {
        this.a.jdField_a_of_type_Atiu.a(true);
      }
    }
    label59:
    while (this.a.jdField_a_of_type_Atiu == null) {
      return;
    }
    this.a.jdField_a_of_type_Atiu.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atis
 * JD-Core Version:    0.7.0.1
 */