import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atxl
  implements View.OnClickListener
{
  atxl(atxk paramatxk) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i = 4;
    if (atxk.a(this.a) == 1)
    {
      i = 2;
      label33:
      if (!atxk.a(this.a).equals(anhk.z)) {
        break label142;
      }
      i = 3;
    }
    label142:
    for (;;)
    {
      long l = athc.b();
      bcst.b(null, "dc00898", "", "", "0X800AA92", "0X800AA92", i, 0, "" + l, "0", "", "");
      if (atxk.a(this.a) == 1)
      {
        atxk.a(this.a);
        break;
        if (atxk.a(this.a) != 0) {
          break label33;
        }
        i = 1;
        break label33;
      }
      atxk.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxl
 * JD-Core Version:    0.7.0.1
 */