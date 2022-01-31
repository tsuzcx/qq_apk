import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class avqb
  implements View.OnClickListener
{
  avqb(avqa paramavqa) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(avqa.a(this.a), QQBrowserActivity.class);
    paramView.putExtra("url", "http://nearby.qq.com/nearby-topic/topicTags.html");
    avqa.a(this.a).startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avqb
 * JD-Core Version:    0.7.0.1
 */