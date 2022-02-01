import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axxl
  implements View.OnClickListener
{
  axxl(axxk paramaxxk) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(axxk.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-topic/topicTags.html");
    axxk.a(this.a).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxl
 * JD-Core Version:    0.7.0.1
 */