import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class bnbq
  implements View.OnClickListener
{
  bnbq(bnbp parambnbp) {}
  
  public void onClick(View paramView)
  {
    wta.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.a.a().g())
    {
      bnbp.a(this.a);
      return;
    }
    this.a.a().f(false);
    bnbp.a(this.a).setSelected(false);
    this.a.a().d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbq
 * JD-Core Version:    0.7.0.1
 */