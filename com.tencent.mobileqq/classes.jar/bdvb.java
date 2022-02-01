import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.studymode.ModeRadioGroup;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
public final class bdvb
  implements View.OnClickListener
{
  public bdvb(ModeRadioGroup paramModeRadioGroup, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.getContext())) {
      if (ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup) != this.jdField_a_of_type_Int) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.getContext(), 1, 2131694305, 1).a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Int == 2) && (ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup) != 2))
      {
        ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup, this.jdField_a_of_type_Int);
      }
      else
      {
        QLog.d("GeneralModeRadioGroup", 2, "click item, type= " + this.jdField_a_of_type_Int + ", old type= " + ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup) + ", enableCheck = " + ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup));
        if ((ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup)) && (this.jdField_a_of_type_Int != ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup))) {
          ModeRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup, this.jdField_a_of_type_Int, true, false, 4, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvb
 * JD-Core Version:    0.7.0.1
 */