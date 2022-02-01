import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.lyric.interaction.AESlidingUpPanelLayout;
import dov.com.qq.im.aeeditor.lyric.interaction.AESlidingUpPanelLayout.PanelState;

public class bpbz
  implements View.OnClickListener
{
  public bpbz(AESlidingUpPanelLayout paramAESlidingUpPanelLayout) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.isEnabled()) || (!this.a.a())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((AESlidingUpPanelLayout.a(this.a) != AESlidingUpPanelLayout.PanelState.EXPANDED) && (AESlidingUpPanelLayout.a(this.a) != AESlidingUpPanelLayout.PanelState.ANCHORED))
      {
        if (AESlidingUpPanelLayout.a(this.a) < 1.0F) {
          this.a.setPanelState(AESlidingUpPanelLayout.PanelState.ANCHORED);
        } else {
          this.a.setPanelState(AESlidingUpPanelLayout.PanelState.EXPANDED);
        }
      }
      else {
        this.a.setPanelState(AESlidingUpPanelLayout.PanelState.COLLAPSED);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpbz
 * JD-Core Version:    0.7.0.1
 */