import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bdpp
  implements View.OnClickListener
{
  bdpp(bdpo parambdpo) {}
  
  public void onClick(View paramView)
  {
    if (bdpo.a(this.a) == null)
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
        View localView = (View)bdpo.a(this.a).get(i);
        if (localView == null) {
          break label174;
        }
        if (i == j) {
          break label135;
        }
        bdol localbdol2 = (bdol)this.a.a.get(i);
        if ((localbdol2 != null) && ((localbdol2 instanceof bdpq))) {
          ((bdpq)localbdol2).a();
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
      bdol localbdol1 = (bdol)this.a.a.get(i);
      if ((localbdol1 != null) && ((localbdol1 instanceof bdpq))) {
        ((bdpq)localbdol1).b();
      }
      label174:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpp
 * JD-Core Version:    0.7.0.1
 */