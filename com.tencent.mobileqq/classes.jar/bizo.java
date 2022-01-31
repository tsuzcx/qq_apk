import android.view.View;
import android.view.View.OnClickListener;

class bizo
  implements View.OnClickListener
{
  bizo(bizm parambizm) {}
  
  public void onClick(View paramView)
  {
    urp.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bizm.a(this.a).q)
    {
      bizm.b(this.a);
      return;
    }
    bizm.a(this.a).q = false;
    bizm.b(this.a).setSelected(false);
    bizm.a(this.a).d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizo
 * JD-Core Version:    0.7.0.1
 */