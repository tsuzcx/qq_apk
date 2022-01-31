import android.view.View;
import android.view.View.OnClickListener;

class bngn
  implements View.OnClickListener
{
  bngn(bngl parambngl) {}
  
  public void onClick(View paramView)
  {
    wxj.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bngl.a(this.a).q)
    {
      bngl.b(this.a);
      return;
    }
    bngl.a(this.a).q = false;
    bngl.b(this.a).setSelected(false);
    bngl.a(this.a).d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngn
 * JD-Core Version:    0.7.0.1
 */