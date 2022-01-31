import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class atuq
  implements View.OnClickListener
{
  atuq(atup paramatup) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(atup.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", "http://nearby.qq.com/nearby-topic/topicTags.html");
    atup.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atuq
 * JD-Core Version:    0.7.0.1
 */