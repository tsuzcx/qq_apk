import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;

class awpt
  implements DialogInterface.OnClickListener
{
  awpt(awpq paramawpq, View paramView, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = (awpp)this.jdField_a_of_type_AndroidViewView.getTag(2131365065);
    if (paramDialogInterface != null) {
      this.jdField_a_of_type_Awpq.a.a(paramDialogInterface.e, this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelInfo.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awpt
 * JD-Core Version:    0.7.0.1
 */