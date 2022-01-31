import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;

public class bgta
  implements SeekBar.OnSeekBarChangeListener
{
  private long jdField_a_of_type_Long;
  
  public bgta(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) || (MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer) == null)) {
      return;
    }
    this.jdField_a_of_type_Long = (MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).getDuration() * paramInt / paramSeekBar.getMax());
    MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setText(MiniAppVideoPlayer.a(this.jdField_a_of_type_Long));
    MiniAppVideoPlayer.b(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setText(MiniAppVideoPlayer.a(this.jdField_a_of_type_Long));
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer, true);
    MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setVisibility(0);
    MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setText("");
    MiniAppVideoPlayer.c(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer);
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer.u) && ("center".equals(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer.g))) {
      MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setVisibility(8);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer, false);
    if (MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer) != null) {
      MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).seekTo((int)this.jdField_a_of_type_Long);
    }
    MiniAppVideoPlayer.b(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setVisibility(0);
    MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setVisibility(8);
    MiniAppVideoPlayer.d(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer);
    MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer);
    if ((this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer.u) && ("center".equals(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer.g))) {
      MiniAppVideoPlayer.a(this.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgta
 * JD-Core Version:    0.7.0.1
 */