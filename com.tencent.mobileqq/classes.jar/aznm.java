import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class aznm
  implements View.OnClickListener
{
  public aznm(SplashADView paramSplashADView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getOutputMute())
      {
        this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(false);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849834);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(true);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aznm
 * JD-Core Version:    0.7.0.1
 */