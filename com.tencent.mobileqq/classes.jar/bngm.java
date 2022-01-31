import android.view.View;
import android.view.View.OnClickListener;

class bngm
  implements View.OnClickListener
{
  bngm(bngl parambngl) {}
  
  public void onClick(View paramView)
  {
    if (!bngl.a(this.a).f)
    {
      bngl.a(this.a);
      return;
    }
    if (bngl.a(this.a).p)
    {
      bflz.a().a(2131718658);
      bngl.a(this.a).p = false;
      bngl.a(this.a).setSelected(false);
      bngl.a(this.a).m = false;
      bngl.a(this.a).d(3008);
      return;
    }
    bflz.a().a(2131718660);
    bngl.a(this.a).p = true;
    bngl.a(this.a).setSelected(true);
    bngl.a(this.a).m = true;
    bngl.a(this.a).d(3007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngm
 * JD-Core Version:    0.7.0.1
 */