import android.view.View;
import android.view.View.OnClickListener;

class arjs
  implements View.OnClickListener
{
  arjs(arjr paramarjr) {}
  
  public void onClick(View paramView)
  {
    if (!arjr.a(this.a)) {
      return;
    }
    long l = aqxj.b();
    azmj.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", 4, 0, "" + l, "0", "", "");
    if ((1 == arjr.a(this.a)) && (!arjr.b(this.a)))
    {
      armv.a(arjr.a(this.a), 2131698703, 2131698702, new arjt(this));
      return;
    }
    arjr.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjs
 * JD-Core Version:    0.7.0.1
 */