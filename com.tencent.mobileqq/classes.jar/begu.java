import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class begu
  implements View.OnClickListener
{
  begu(begr parambegr) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((begr.a(this.a)) && ((begr.a(this.a) == null) || (!begr.a(this.a).contains(Integer.valueOf(i)))) && (begr.b(this.a) != -1) && (i != begr.b(this.a)))
    {
      localObject = (View)begr.a(this.a).get(begr.b(this.a));
      ((View)localObject).findViewById(2131296379).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131296378);
      begr.a(this.a, (TextView)localObject, false);
      localObject = (View)begr.a(this.a).get(i);
      ((View)localObject).findViewById(2131296379).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131296378);
      begr.a(this.a, (TextView)localObject, true);
      begr.a(this.a, i);
    }
    if (begr.a(this.a) != null) {
      begr.a(this.a).OnClick(paramView, i);
    }
    if (begr.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131296378);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        begr.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     begu
 * JD-Core Version:    0.7.0.1
 */