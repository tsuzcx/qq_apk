import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.share.QZoneShareActivity;
import cooperation.qzone.share.QZoneShareActivity.5.1;
import cooperation.qzone.share.QZoneShareActivity.5.2;
import java.util.ArrayList;
import org.json.JSONObject;

public class bjru
  implements MiniAppCmdInterface
{
  public bjru(QZoneShareActivity paramQZoneShareActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, int paramInt4, String paramString6, MiniAppCmdInterface paramMiniAppCmdInterface) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (localMiniAppInfo != null)
      {
        paramJSONObject = this.jdField_a_of_type_JavaLangString;
        String str = this.jdField_b_of_type_JavaLangString;
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          paramJSONObject = localMiniAppInfo.name;
        }
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          str = localMiniAppInfo.desc;
        }
        if (QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity) != null)
        {
          QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity).jdField_b_of_type_JavaLangString = paramJSONObject;
          QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity).jdField_c_of_type_JavaLangString = str;
          if ((QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity).a != null) && (QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity).a.size() == 0)) {
            QZoneShareActivity.a(this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity).a.add(localMiniAppInfo.iconUrl);
          }
        }
        MiniProgramShareUtils.shareAsQzoneFeeds(this.jdField_c_of_type_JavaLangString, paramJSONObject, str, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString, null, this.e, localMiniAppInfo.iconUrl, this.jdField_d_of_type_Int, localMiniAppInfo.versionId, this.f, this.jdField_a_of_type_ComTencentMobileqqMiniReuseMiniAppCmdInterface);
        return;
      }
      this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.runOnUiThread(new QZoneShareActivity.5.1(this));
      return;
    }
    long l;
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      if (paramJSONObject == null) {
        break label260;
      }
    }
    label260:
    for (paramJSONObject = paramJSONObject.optString("errMsg");; paramJSONObject = "")
    {
      this.jdField_a_of_type_CooperationQzoneShareQZoneShareActivity.runOnUiThread(new QZoneShareActivity.5.2(this, paramJSONObject, l));
      return;
      l = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjru
 * JD-Core Version:    0.7.0.1
 */