import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;

public class bnbh
  implements View.OnClickListener
{
  public bnbh(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(View paramView)
  {
    QzoneWebMusicJsPlugin.access$300(this.a, "buttonclick");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbh
 * JD-Core Version:    0.7.0.1
 */