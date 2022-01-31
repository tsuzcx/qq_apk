import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class axvr
  implements View.OnClickListener
{
  axvr(axvq paramaxvq) {}
  
  public void onClick(View paramView)
  {
    if (axvq.a(this.a) == null) {
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
        paramView = (View)axvq.a(this.a).get(i);
        if (paramView == null) {
          break label156;
        }
        if (i != j)
        {
          axun localaxun = (axun)this.a.a.get(i);
          if ((localaxun != null) && ((localaxun instanceof axvs))) {
            ((axvs)localaxun).a();
          } else {
            paramView.setVisibility(8);
          }
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      paramView = (axun)this.a.a.get(i);
      if ((paramView != null) && ((paramView instanceof axvs))) {
        ((axvs)paramView).b();
      }
      label156:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvr
 * JD-Core Version:    0.7.0.1
 */