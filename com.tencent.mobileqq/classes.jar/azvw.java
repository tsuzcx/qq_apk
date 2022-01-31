import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class azvw
  implements View.OnClickListener
{
  azvw(azvv paramazvv) {}
  
  public void onClick(View paramView)
  {
    if (azvv.a(this.a) == null) {
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
        paramView = (View)azvv.a(this.a).get(i);
        if (paramView == null) {
          break label156;
        }
        if (i != j)
        {
          azus localazus = (azus)this.a.a.get(i);
          if ((localazus != null) && ((localazus instanceof azvx))) {
            ((azvx)localazus).a();
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
      paramView = (azus)this.a.a.get(i);
      if ((paramView != null) && ((paramView instanceof azvx))) {
        ((azvx)paramView).b();
      }
      label156:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvw
 * JD-Core Version:    0.7.0.1
 */