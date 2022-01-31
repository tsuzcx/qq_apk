import android.view.View;
import android.view.View.OnClickListener;

class bkpz
  implements View.OnClickListener
{
  bkpz(bkpy parambkpy) {}
  
  public void onClick(View paramView)
  {
    if (!bkpy.a(this.a).f)
    {
      bkpy.a(this.a);
      return;
    }
    if (bkpy.a(this.a).p)
    {
      bdid.a().a(2131718260);
      bkpy.a(this.a).p = false;
      bkpy.a(this.a).setSelected(false);
      bkpy.a(this.a).m = false;
      bkpy.a(this.a).d(3008);
      return;
    }
    bdid.a().a(2131718262);
    bkpy.a(this.a).p = true;
    bkpy.a(this.a).setSelected(true);
    bkpy.a(this.a).m = true;
    bkpy.a(this.a).d(3007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkpz
 * JD-Core Version:    0.7.0.1
 */