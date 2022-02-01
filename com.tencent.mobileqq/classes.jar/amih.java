import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amih
  implements View.OnClickListener
{
  public amih(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class).putExtra("url", ShortVideoPlayActivity.a(this.a));
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amih
 * JD-Core Version:    0.7.0.1
 */