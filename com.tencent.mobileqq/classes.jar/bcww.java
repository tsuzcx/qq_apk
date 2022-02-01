import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class bcww
  implements View.OnClickListener
{
  bcww(bcwv parambcwv) {}
  
  public void onClick(View paramView)
  {
    if (bcwv.a(this.a) == null)
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
        View localView = (View)bcwv.a(this.a).get(i);
        if (localView == null) {
          break label174;
        }
        if (i == j) {
          break label135;
        }
        bcvs localbcvs2 = (bcvs)this.a.a.get(i);
        if ((localbcvs2 != null) && ((localbcvs2 instanceof bcwx))) {
          ((bcwx)localbcvs2).a();
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
      bcvs localbcvs1 = (bcvs)this.a.a.get(i);
      if ((localbcvs1 != null) && ((localbcvs1 instanceof bcwx))) {
        ((bcwx)localbcvs1).b();
      }
      label174:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcww
 * JD-Core Version:    0.7.0.1
 */