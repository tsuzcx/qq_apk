import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class bkqg
  implements View.OnClickListener
{
  bkqg(bkqf parambkqf) {}
  
  public void onClick(View paramView)
  {
    vei.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.a.a().g())
    {
      bkqf.a(this.a);
      return;
    }
    this.a.a().f(false);
    bkqf.a(this.a).setSelected(false);
    this.a.a().d(3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkqg
 * JD-Core Version:    0.7.0.1
 */