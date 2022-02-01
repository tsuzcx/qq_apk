import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bdgv
  implements View.OnClickListener
{
  public bdgv(SplashADView paramSplashADView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (!this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute()) {
        break label59;
      }
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850466);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label59:
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850467);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdgv
 * JD-Core Version:    0.7.0.1
 */