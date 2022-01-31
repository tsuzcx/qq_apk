import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class azrn
  implements View.OnClickListener
{
  azrn(azrm paramazrm) {}
  
  public void onClick(View paramView)
  {
    if (azrm.a(this.a) == null) {
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
        paramView = (View)azrm.a(this.a).get(i);
        if (paramView == null) {
          break label156;
        }
        if (i != j)
        {
          azqj localazqj = (azqj)this.a.a.get(i);
          if ((localazqj != null) && ((localazqj instanceof azro))) {
            ((azro)localazqj).a();
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
      paramView = (azqj)this.a.a.get(i);
      if ((paramView != null) && ((paramView instanceof azro))) {
        ((azro)paramView).b();
      }
      label156:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azrn
 * JD-Core Version:    0.7.0.1
 */