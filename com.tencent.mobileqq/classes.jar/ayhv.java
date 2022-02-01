import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class ayhv
  implements bliz
{
  ayhv(ayhj paramayhj, BaseActivity paramBaseActivity, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Blir != null) {
          this.jdField_a_of_type_Blir.dismiss();
        }
        return;
        if (!ayhj.e(this.jdField_a_of_type_Ayhj)) {
          break;
        }
        ayhj.a(this.jdField_a_of_type_Ayhj, bhlq.a(this.jdField_a_of_type_Ayhj.jdField_a_of_type_AndroidViewView.getContext(), 230, anzj.a(2131707116), null, anzj.a(2131707124), anzj.a(2131707119), new ayhw(this), new ayhy(this)));
        ayhj.a(this.jdField_a_of_type_Ayhj).show();
        bdll.b(this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "delete_comment", 0, 0, "", "", "", "");
      }
    } while ((this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_Ayhj.b == null) || (this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    String str = String.valueOf(this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long);
    if ((TextUtils.isEmpty(str)) || ("0".equals(str)))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, anzj.a(2131707115), 0).a();
      return;
    }
    paramView = "";
    if (this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4) {
      if (this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0) == null) {}
    }
    for (paramView = ((aycu)this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaUtilArrayList.get(0)).a;; paramView = this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c)
    {
      paramView = new bhia().b(this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c).d(paramView).a(this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString).a();
      bhhz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0L, str, null, 20006, "", paramView);
      bdll.b(this.jdField_a_of_type_Ayhj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "grp_lbs", "", "comment", "report_comment", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhv
 * JD-Core Version:    0.7.0.1
 */