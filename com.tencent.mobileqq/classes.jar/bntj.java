import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.lyric.interaction.AESlidingUpPanelLayout;
import dov.com.qq.im.aeeditor.lyric.interaction.AESlidingUpPanelLayout.PanelState;
import dov.com.qq.im.aeeditor.lyric.interaction.MoreLyricLayout;

public class bntj
  implements View.OnClickListener
{
  public bntj(MoreLyricLayout paramMoreLyricLayout) {}
  
  public void onClick(View paramView)
  {
    MoreLyricLayout.a(this.a).setPanelState(AESlidingUpPanelLayout.PanelState.COLLAPSED);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bntj
 * JD-Core Version:    0.7.0.1
 */