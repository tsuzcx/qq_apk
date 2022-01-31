import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class bkpp
  implements View.OnClickListener
{
  bkpp(bkpo parambkpo) {}
  
  public void onClick(View paramView)
  {
    vel.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.a.a().g())
    {
      bkpo.a(this.a);
      return;
    }
    this.a.a().f(false);
    bkpo.a(this.a).setSelected(false);
    this.a.a().d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpp
 * JD-Core Version:    0.7.0.1
 */