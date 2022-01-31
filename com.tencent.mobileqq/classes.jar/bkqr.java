import android.view.View;
import android.view.View.OnClickListener;

class bkqr
  implements View.OnClickListener
{
  bkqr(bkqp parambkqp) {}
  
  public void onClick(View paramView)
  {
    vei.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bkqp.a(this.a).q)
    {
      bkqp.b(this.a);
      return;
    }
    bkqp.a(this.a).q = false;
    bkqp.b(this.a).setSelected(false);
    bkqp.a(this.a).d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqr
 * JD-Core Version:    0.7.0.1
 */