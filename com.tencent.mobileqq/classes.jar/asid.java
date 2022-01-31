import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;

public class asid
  implements View.OnClickListener
{
  public asid(QQGamePubAccountFragment paramQQGamePubAccountFragment, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(QQGamePubAccountFragment.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment));
    QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asid
 * JD-Core Version:    0.7.0.1
 */