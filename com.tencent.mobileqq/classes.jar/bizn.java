import android.view.View;
import android.view.View.OnClickListener;

class bizn
  implements View.OnClickListener
{
  bizn(bizm parambizm) {}
  
  public void onClick(View paramView)
  {
    if (!bizm.a(this.a).f)
    {
      bizm.a(this.a);
      return;
    }
    if (bizm.a(this.a).p)
    {
      bcec.a().a(2131652441);
      bizm.a(this.a).p = false;
      bizm.a(this.a).setSelected(false);
      bizm.a(this.a).m = false;
      bizm.a(this.a).d(3008);
      return;
    }
    bcec.a().a(2131652443);
    bizm.a(this.a).p = true;
    bizm.a(this.a).setSelected(true);
    bizm.a(this.a).m = true;
    bizm.a(this.a).d(3007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizn
 * JD-Core Version:    0.7.0.1
 */