import android.view.View;
import android.view.View.OnClickListener;

class apxh
  implements View.OnClickListener
{
  apxh(apxg paramapxg) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a) {
      return;
    }
    int i = 4;
    if (apxg.a(this.a) == 1)
    {
      i = 2;
      if (!apxg.a(this.a).equals(ajsf.z)) {
        break label131;
      }
      i = 3;
    }
    label131:
    for (;;)
    {
      long l = apeh.b();
      axqw.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      if (apxg.a(this.a) == 1)
      {
        apxg.a(this.a);
        return;
        if (apxg.a(this.a) != 0) {
          break;
        }
        i = 1;
        break;
      }
      apxg.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apxh
 * JD-Core Version:    0.7.0.1
 */