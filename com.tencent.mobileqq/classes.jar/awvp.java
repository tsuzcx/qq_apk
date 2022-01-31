import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class awvp
  implements View.OnClickListener
{
  awvp(awvo paramawvo) {}
  
  public void onClick(View paramView)
  {
    if (awvo.a(this.a) == null) {
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
        paramView = (View)awvo.a(this.a).get(i);
        if (paramView == null) {
          break label156;
        }
        if (i != j)
        {
          awul localawul = (awul)this.a.a.get(i);
          if ((localawul != null) && ((localawul instanceof awvq))) {
            ((awvq)localawul).a();
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
      paramView = (awul)this.a.a.get(i);
      if ((paramView != null) && ((paramView instanceof awvq))) {
        ((awvq)paramView).b();
      }
      label156:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awvp
 * JD-Core Version:    0.7.0.1
 */