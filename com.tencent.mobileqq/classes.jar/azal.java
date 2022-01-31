import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class azal
  implements View.OnClickListener
{
  public azal(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.b))
    {
      if (!this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        break label125;
      }
      this.a.a(200);
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.a.c = true;
      paramView = (azbh)((View)this.a.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag();
      if ((paramView instanceof azbg))
      {
        paramView = ((azbg)paramView).a;
        this.a.a(paramView, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      }
    }
    return;
    label125:
    if (this.a.b)
    {
      paramView = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
      if (paramView != null)
      {
        ((ViewGroup)paramView).removeView(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      paramView = (azbh)((View)this.a.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag();
      this.a.a(paramView);
    }
    for (;;)
    {
      this.a.c = false;
      return;
      this.a.b(200);
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.a.b((azbh)((View)this.a.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).getTag());
      this.a.jdField_a_of_type_Long = this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azal
 * JD-Core Version:    0.7.0.1
 */