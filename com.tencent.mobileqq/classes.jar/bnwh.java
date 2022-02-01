import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.player.MoviePlayer;
import dov.com.qq.im.ae.play.AEVideoPreviewFragment;

public class bnwh
  implements SeekBar.OnSeekBarChangeListener
{
  public bnwh(AEVideoPreviewFragment paramAEVideoPreviewFragment) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    float f = paramInt / 1000.0F / 1000.0F;
    if (paramBoolean)
    {
      paramSeekBar = new CMTime(f);
      this.a.jdField_a_of_type_ComTencentTavcutPlayerMoviePlayer.seekToTime(paramSeekBar);
    }
    paramSeekBar = bojc.a((f * 1000.0F));
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramSeekBar);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    AEVideoPreviewFragment.a(this.a);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AEVideoPreviewFragment.b(this.a);
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwh
 * JD-Core Version:    0.7.0.1
 */