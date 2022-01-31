import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class avls
  implements View.OnClickListener
{
  avls(avlr paramavlr) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(avlr.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", "http://nearby.qq.com/nearby-topic/topicTags.html");
    avlr.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avls
 * JD-Core Version:    0.7.0.1
 */