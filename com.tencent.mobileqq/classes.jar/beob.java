import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class beob
  implements View.OnClickListener
{
  beob(beny parambeny) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((beny.a(this.a)) && ((beny.a(this.a) == null) || (!beny.a(this.a).contains(Integer.valueOf(i)))) && (beny.b(this.a) != -1) && (i != beny.b(this.a)))
    {
      localObject = (View)beny.a(this.a).get(beny.b(this.a));
      ((View)localObject).findViewById(2131361914).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361913);
      beny.a(this.a, (TextView)localObject, false);
      localObject = (View)beny.a(this.a).get(i);
      ((View)localObject).findViewById(2131361914).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361913);
      beny.a(this.a, (TextView)localObject, true);
      beny.a(this.a, i);
    }
    if (beny.a(this.a) != null) {
      beny.a(this.a).OnClick(paramView, i);
    }
    if (beny.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361913);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        beny.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beob
 * JD-Core Version:    0.7.0.1
 */