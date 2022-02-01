import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bcia
  implements View.OnClickListener
{
  bcia(bchz parambchz) {}
  
  public void onClick(View paramView)
  {
    if (bchz.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = Integer.parseInt(String.valueOf(paramView.getTag()));
        i = 0;
        if (i >= this.a.a.size()) {
          break;
        }
        View localView = (View)bchz.a(this.a).get(i);
        if (localView == null) {
          break label174;
        }
        if (i == j) {
          break label135;
        }
        bcgw localbcgw2 = (bcgw)this.a.a.get(i);
        if ((localbcgw2 != null) && ((localbcgw2 instanceof bcib))) {
          ((bcib)localbcgw2).a();
        } else {
          localView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      label135:
      bcgw localbcgw1 = (bcgw)this.a.a.get(i);
      if ((localbcgw1 != null) && ((localbcgw1 instanceof bcib))) {
        ((bcib)localbcgw1).b();
      }
      label174:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcia
 * JD-Core Version:    0.7.0.1
 */