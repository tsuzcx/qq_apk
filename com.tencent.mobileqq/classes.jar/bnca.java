import android.view.View;
import android.view.View.OnClickListener;

class bnca
  implements View.OnClickListener
{
  bnca(bnbz parambnbz) {}
  
  public void onClick(View paramView)
  {
    if (!bnbz.a(this.a).f)
    {
      bnbz.a(this.a);
      return;
    }
    if (bnbz.a(this.a).p)
    {
      bfhq.a().a(2131718646);
      bnbz.a(this.a).p = false;
      bnbz.a(this.a).setSelected(false);
      bnbz.a(this.a).m = false;
      bnbz.a(this.a).d(3008);
      return;
    }
    bfhq.a().a(2131718648);
    bnbz.a(this.a).p = true;
    bnbz.a(this.a).setSelected(true);
    bnbz.a(this.a).m = true;
    bnbz.a(this.a).d(3007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnca
 * JD-Core Version:    0.7.0.1
 */