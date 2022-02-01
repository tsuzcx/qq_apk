import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class axpb
  implements bkhw
{
  axpb(axop paramaxop, BaseActivity paramBaseActivity, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Bkho != null) {
          this.jdField_a_of_type_Bkho.dismiss();
        }
        return;
        if (!axop.e(this.jdField_a_of_type_Axop)) {
          break;
        }
        axop.a(this.jdField_a_of_type_Axop, bglp.a(this.jdField_a_of_type_Axop.jdField_a_of_type_AndroidViewView.getContext(), 230, anni.a(2131707007), null, anni.a(2131707015), anni.a(2131707010), new axpc(this), new axpe(this)));
        axop.a(this.jdField_a_of_type_Axop).show();
        bcst.b(this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
    } while ((this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_Axop.b == null) || (this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    String str = String.valueOf(this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long);
    if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, anni.a(2131707006), 0).a();
      return;
    }
    paramView = "";
    if (this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4) {
      if (this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) == null) {}
    }
    for (paramView = ((axka)this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).a;; paramView = this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c)
    {
      paramView = new bghz().b(this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c).d(paramView).a(this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString).a();
      bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, str, null, 20006, "", paramView);
      bcst.b(this.jdField_a_of_type_Axop.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpb
 * JD-Core Version:    0.7.0.1
 */