import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class asmm
  implements bbsh
{
  asmm(asml paramasml) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label59;
      }
      if (this.a.jdField_a_of_type_Asmo != null) {
        this.a.jdField_a_of_type_Asmo.a(true);
      }
    }
    label59:
    while (this.a.jdField_a_of_type_Asmo == null) {
      return;
    }
    this.a.jdField_a_of_type_Asmo.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asmm
 * JD-Core Version:    0.7.0.1
 */