import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import java.util.ArrayList;

class atmi
  implements bfph
{
  atmi(atlw paramatlw, BaseActivity paramBaseActivity, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Bfpc != null) {
          this.jdField_a_of_type_Bfpc.dismiss();
        }
        return;
        if (!atlw.e(this.jdField_a_of_type_Atlw)) {
          break;
        }
        atlw.a(this.jdField_a_of_type_Atlw, bbdj.a(this.jdField_a_of_type_Atlw.jdField_a_of_type_AndroidViewView.getContext(), 230, ajya.a(2131708247), null, ajya.a(2131708255), ajya.a(2131708250), new atmj(this), new atml(this)));
        atlw.a(this.jdField_a_of_type_Atlw).show();
        axqy.b(this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
    } while ((this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_Atlw.b == null) || (this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    String str = String.valueOf(this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long);
    if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
    {
      bcql.a(BaseApplicationImpl.getContext(), 2, ajya.a(2131708246), 0).a();
      return;
    }
    paramView = "";
    if (this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4) {
      if (this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) == null) {}
    }
    for (paramView = ((athj)this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).a;; paramView = this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c)
    {
      paramView = new bbad().b(this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c).d(paramView).a(this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString).a();
      bbac.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, str, null, 20006, "", paramView);
      axqy.b(this.jdField_a_of_type_Atlw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmi
 * JD-Core Version:    0.7.0.1
 */