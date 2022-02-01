import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bdoy
  implements View.OnClickListener
{
  bdoy(bdox parambdox) {}
  
  public void onClick(View paramView)
  {
    if (bdox.a(this.a) == null)
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
        View localView = (View)bdox.a(this.a).get(i);
        if (localView == null) {
          break label174;
        }
        if (i == j) {
          break label135;
        }
        bdnu localbdnu2 = (bdnu)this.a.a.get(i);
        if ((localbdnu2 != null) && ((localbdnu2 instanceof bdoz))) {
          ((bdoz)localbdnu2).a();
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
      bdnu localbdnu1 = (bdnu)this.a.a.get(i);
      if ((localbdnu1 != null) && ((localbdnu1 instanceof bdoz))) {
        ((bdoz)localbdnu1).b();
      }
      label174:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdoy
 * JD-Core Version:    0.7.0.1
 */