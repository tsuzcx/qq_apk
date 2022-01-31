import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import java.util.ArrayList;

class auic
  implements View.OnClickListener
{
  auic(auib paramauib) {}
  
  public void onClick(View paramView)
  {
    if (auib.a(this.a).size() > 10) {
      bcpw.a(auib.a(this.a), 1, 2131690320, 1).a();
    }
    while (auib.a(this.a) == null) {
      return;
    }
    if (auib.a(this.a).size() > 1) {}
    for (int i = auib.a(this.a).size() - 1;; i = 0)
    {
      paramView = new AutoReplyText("", i);
      paramView.getExtra().putBoolean("addFlag", true);
      auib.a(this.a).b(paramView, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auic
 * JD-Core Version:    0.7.0.1
 */