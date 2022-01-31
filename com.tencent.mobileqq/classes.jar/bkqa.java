import android.view.View;
import android.view.View.OnClickListener;

class bkqa
  implements View.OnClickListener
{
  bkqa(bkpy parambkpy) {}
  
  public void onClick(View paramView)
  {
    vel.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bkpy.a(this.a).q)
    {
      bkpy.b(this.a);
      return;
    }
    bkpy.a(this.a).q = false;
    bkpy.b(this.a).setSelected(false);
    bkpy.a(this.a).d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqa
 * JD-Core Version:    0.7.0.1
 */