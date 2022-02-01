import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;

final class ayec
  implements bjig
{
  ayec(String paramString, ayeg paramayeg) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((paramBaseResp != null) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)))
    {
      WXShareHelper.a().b(this);
      if (paramBaseResp.errCode != 0) {
        break label50;
      }
      if (this.jdField_a_of_type_Ayeg != null) {
        this.jdField_a_of_type_Ayeg.a(true);
      }
    }
    label50:
    while (this.jdField_a_of_type_Ayeg == null) {
      return;
    }
    this.jdField_a_of_type_Ayeg.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayec
 * JD-Core Version:    0.7.0.1
 */