import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.matchmaker.MatchMakerFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axvc
  implements View.OnClickListener
{
  public axvc(MatchMakerFragment paramMatchMakerFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://qvideo.qq.com/qq/hongniang/personal-center.html?_wv=16778245&from=mp");
    localIntent.addFlags(536870912);
    this.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvc
 * JD-Core Version:    0.7.0.1
 */