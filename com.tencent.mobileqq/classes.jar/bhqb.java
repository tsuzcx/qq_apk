import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class bhqb
  implements View.OnClickListener
{
  bhqb(bhpy parambhpy) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bhpy.a(this.a)) && ((bhpy.a(this.a) == null) || (!bhpy.a(this.a).contains(Integer.valueOf(i)))) && (bhpy.b(this.a) != -1) && (i != bhpy.b(this.a)))
    {
      localObject = (View)bhpy.a(this.a).get(bhpy.b(this.a));
      ((View)localObject).findViewById(2131361916).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361915);
      bhpy.a(this.a, (TextView)localObject, false);
      localObject = (View)bhpy.a(this.a).get(i);
      ((View)localObject).findViewById(2131361916).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361915);
      bhpy.a(this.a, (TextView)localObject, true);
      bhpy.a(this.a, i);
    }
    if (bhpy.a(this.a) != null) {
      bhpy.a(this.a).OnClick(paramView, i);
    }
    if (bhpy.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361915);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bhpy.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhqb
 * JD-Core Version:    0.7.0.1
 */