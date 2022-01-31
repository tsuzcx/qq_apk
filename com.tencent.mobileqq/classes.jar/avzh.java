import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class avzh
  implements View.OnClickListener
{
  avzh(avzg paramavzg) {}
  
  public void onClick(View paramView)
  {
    if (avzg.a(this.a).size() > 10) {
      QQToast.a(avzg.a(this.a), 1, 2131690371, 1).a();
    }
    while (avzg.a(this.a) == null) {
      return;
    }
    if (avzg.a(this.a).size() > 1) {}
    for (int i = avzg.a(this.a).size() - 1;; i = 0)
    {
      paramView = new AutoReplyText("", i);
      paramView.getExtra().putBoolean("addFlag", true);
      avzg.a(this.a).b(paramView, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avzh
 * JD-Core Version:    0.7.0.1
 */