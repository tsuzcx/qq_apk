import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import java.util.ArrayList;

class atkd
  implements View.OnClickListener
{
  atkd(atkc paramatkc) {}
  
  public void onClick(View paramView)
  {
    if (atkc.a(this.a).size() > 10) {
      bbmy.a(atkc.a(this.a), 1, 2131624759, 1).a();
    }
    while (atkc.a(this.a) == null) {
      return;
    }
    if (atkc.a(this.a).size() > 1) {}
    for (int i = atkc.a(this.a).size() - 1;; i = 0)
    {
      paramView = new AutoReplyText("", i);
      paramView.getExtra().putBoolean("addFlag", true);
      atkc.a(this.a).b(paramView, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atkd
 * JD-Core Version:    0.7.0.1
 */