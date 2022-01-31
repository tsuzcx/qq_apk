import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class bngc
  implements View.OnClickListener
{
  bngc(bngb parambngb) {}
  
  public void onClick(View paramView)
  {
    wxj.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.a.a().g())
    {
      bngb.a(this.a);
      return;
    }
    this.a.a().f(false);
    bngb.a(this.a).setSelected(false);
    this.a.a().d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngc
 * JD-Core Version:    0.7.0.1
 */