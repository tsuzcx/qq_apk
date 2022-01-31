import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class atus
  implements View.OnClickListener
{
  atus(atur paramatur) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(atur.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", "http://nearby.qq.com/nearby-topic/topicTags.html");
    atur.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atus
 * JD-Core Version:    0.7.0.1
 */