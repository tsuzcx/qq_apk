import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class besz
  implements View.OnClickListener
{
  public besz(ProfileCardMoreInfoView paramProfileCardMoreInfoView, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("key_jump_from", "5");
    tqs.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a.jdField_a_of_type_ComTencentMobileqqDataCard.uin, paramView);
    tzv.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.uin, 3, 1L, 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besz
 * JD-Core Version:    0.7.0.1
 */