import android.view.View;
import android.view.View.OnClickListener;

class bncb
  implements View.OnClickListener
{
  bncb(bnbz parambnbz) {}
  
  public void onClick(View paramView)
  {
    wta.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!bnbz.a(this.a).q)
    {
      bnbz.b(this.a);
      return;
    }
    bnbz.a(this.a).q = false;
    bnbz.b(this.a).setSelected(false);
    bnbz.a(this.a).d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncb
 * JD-Core Version:    0.7.0.1
 */