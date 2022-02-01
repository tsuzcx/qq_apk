import android.support.annotation.NonNull;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardExtendFriendView;
import com.tencent.mobileqq.widget.QQToast;

public class bhzu
  extends ClickableSpan
{
  public bhzu(ProfileCardExtendFriendView paramProfileCardExtendFriendView, Card paramCard) {}
  
  public void onClick(@NonNull View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard.authState == 1L) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardExtendFriendView.getContext(), 0, 2131697896, 1).a();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataCard.authState != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataCard.authState != 3L)) {
      return;
    }
    asme.a((FriendProfileCardActivity)ProfileCardExtendFriendView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardExtendFriendView), this.jdField_a_of_type_ComTencentMobileqqDataCard.idx, this.jdField_a_of_type_ComTencentMobileqqDataCard.schoolName, this.jdField_a_of_type_ComTencentMobileqqDataCard.schoolId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzu
 * JD-Core Version:    0.7.0.1
 */