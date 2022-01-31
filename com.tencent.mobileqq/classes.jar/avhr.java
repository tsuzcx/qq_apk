import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class avhr
  implements bhuk
{
  avhr(avhf paramavhf, BaseActivity paramBaseActivity, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Bhuf != null) {
          this.jdField_a_of_type_Bhuf.dismiss();
        }
        return;
        if (!avhf.e(this.jdField_a_of_type_Avhf)) {
          break;
        }
        avhf.a(this.jdField_a_of_type_Avhf, bdgm.a(this.jdField_a_of_type_Avhf.jdField_a_of_type_AndroidViewView.getContext(), 230, alud.a(2131708631), null, alud.a(2131708639), alud.a(2131708634), new avhs(this), new avhu(this)));
        avhf.a(this.jdField_a_of_type_Avhf).show();
        azqs.b(this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
    } while ((this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_Avhf.b == null) || (this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    String str = String.valueOf(this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long);
    if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, alud.a(2131708630), 0).a();
      return;
    }
    paramView = "";
    if (this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4) {
      if (this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) == null) {}
    }
    for (paramView = ((avcr)this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).a;; paramView = this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c)
    {
      paramView = new bddg().b(this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c).d(paramView).a(this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString).a();
      bddf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, str, null, 20006, "", paramView);
      azqs.b(this.jdField_a_of_type_Avhf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhr
 * JD-Core Version:    0.7.0.1
 */