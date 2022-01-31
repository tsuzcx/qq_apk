import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class bdjh
  implements View.OnClickListener
{
  bdjh(bdje parambdje) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bdje.a(this.a)) && ((bdje.a(this.a) == null) || (!bdje.a(this.a).contains(Integer.valueOf(i)))) && (bdje.b(this.a) != -1) && (i != bdje.b(this.a)))
    {
      localObject = (View)bdje.a(this.a).get(bdje.b(this.a));
      ((View)localObject).findViewById(2131296379).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131296378);
      bdje.a(this.a, (TextView)localObject, false);
      localObject = (View)bdje.a(this.a).get(i);
      ((View)localObject).findViewById(2131296379).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131296378);
      bdje.a(this.a, (TextView)localObject, true);
      bdje.a(this.a, i);
    }
    if (bdje.a(this.a) != null) {
      bdje.a(this.a).OnClick(paramView, i);
    }
    if (bdje.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131296378);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bdje.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdjh
 * JD-Core Version:    0.7.0.1
 */