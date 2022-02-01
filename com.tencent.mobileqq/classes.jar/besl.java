import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;

public class besl
  implements View.OnClickListener
{
  public besl(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.b))
    {
      if (!this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()) {
        break label132;
      }
      this.a.a(200);
      this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      this.a.c = true;
      localObject = (betg)((View)this.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
      if ((localObject instanceof betf))
      {
        localObject = ((betf)localObject).a;
        this.a.a((betw)localObject, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
    return;
    label132:
    if (this.a.b)
    {
      localObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
      if (localObject != null)
      {
        ((ViewGroup)localObject).removeView(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
        this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      }
      localObject = (betg)((View)this.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
      this.a.a((betg)localObject);
    }
    for (;;)
    {
      this.a.c = false;
      break;
      this.a.b(200);
      this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      this.a.b((betg)((View)this.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag());
      this.a.jdField_a_of_type_Long = this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besl
 * JD-Core Version:    0.7.0.1
 */