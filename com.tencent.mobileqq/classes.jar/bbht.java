import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.QQToast;

public class bbht
  implements bhuk
{
  public bbht(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, bhuf parambhuf, URLDrawable paramURLDrawable, String paramString1, String paramString2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bhuf.a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131693497).equals(paramView))
    {
      TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      bddf.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, Long.parseLong(this.jdField_a_of_type_JavaLangString), "0", null, 20006);
    }
    for (;;)
    {
      azqs.b(null, "dc00899", "grp_lbs", this.jdField_a_of_type_JavaLangString, "video", "clk_rep", 0, 0, "", "", "", "");
      break;
      if ((TextUtils.isEmpty(this.b)) || ("0".equals(this.b))) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, 2, alud.a(2131715605), 0).a();
      } else {
        bddf.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, 0L, this.b, null, 20006);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbht
 * JD-Core Version:    0.7.0.1
 */