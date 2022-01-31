import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class benk
  implements View.OnClickListener
{
  benk(benh parambenh) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((benh.a(this.a)) && ((benh.a(this.a) == null) || (!benh.a(this.a).contains(Integer.valueOf(i)))) && (benh.b(this.a) != -1) && (i != benh.b(this.a)))
    {
      localObject = (View)benh.a(this.a).get(benh.b(this.a));
      ((View)localObject).findViewById(2131361915).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361914);
      benh.a(this.a, (TextView)localObject, false);
      localObject = (View)benh.a(this.a).get(i);
      ((View)localObject).findViewById(2131361915).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361914);
      benh.a(this.a, (TextView)localObject, true);
      benh.a(this.a, i);
    }
    if (benh.a(this.a) != null) {
      benh.a(this.a).OnClick(paramView, i);
    }
    if (benh.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361914);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        benh.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     benk
 * JD-Core Version:    0.7.0.1
 */