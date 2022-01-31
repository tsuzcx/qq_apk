import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class avdx
  implements bfah
{
  avdx(String paramString, aved paramaved) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label50;
      }
      if (this.jdField_a_of_type_Aved != null) {
        this.jdField_a_of_type_Aved.a(true);
      }
    }
    label50:
    while (this.jdField_a_of_type_Aved == null) {
      return;
    }
    this.jdField_a_of_type_Aved.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avdx
 * JD-Core Version:    0.7.0.1
 */