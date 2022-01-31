import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import java.util.ArrayList;

class auie
  implements View.OnClickListener
{
  auie(auid paramauid) {}
  
  public void onClick(View paramView)
  {
    if (auid.a(this.a).size() > 10) {
      bcql.a(auid.a(this.a), 1, 2131690320, 1).a();
    }
    while (auid.a(this.a) == null) {
      return;
    }
    if (auid.a(this.a).size() > 1) {}
    for (int i = auid.a(this.a).size() - 1;; i = 0)
    {
      paramView = new AutoReplyText("", i);
      paramView.getExtra().putBoolean("addFlag", true);
      auid.a(this.a).b(paramView, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auie
 * JD-Core Version:    0.7.0.1
 */