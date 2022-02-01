import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePubAccountFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avcv
  implements View.OnClickListener
{
  public avcv(QQGamePubAccountFragment paramQQGamePubAccountFragment, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(QQGamePubAccountFragment.b(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment));
    QQGamePubAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterFragmentQQGamePubAccountFragment, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcv
 * JD-Core Version:    0.7.0.1
 */