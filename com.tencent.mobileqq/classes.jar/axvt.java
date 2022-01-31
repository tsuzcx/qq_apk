import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class axvt
  implements View.OnClickListener
{
  axvt(axvs paramaxvs) {}
  
  public void onClick(View paramView)
  {
    if (axvs.a(this.a) == null) {
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
        paramView = (View)axvs.a(this.a).get(i);
        if (paramView == null) {
          break label156;
        }
        if (i != j)
        {
          axup localaxup = (axup)this.a.a.get(i);
          if ((localaxup != null) && ((localaxup instanceof axvu))) {
            ((axvu)localaxup).a();
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
      paramView = (axup)this.a.a.get(i);
      if ((paramView != null) && ((paramView instanceof axvu))) {
        ((axvu)paramView).b();
      }
      label156:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvt
 * JD-Core Version:    0.7.0.1
 */