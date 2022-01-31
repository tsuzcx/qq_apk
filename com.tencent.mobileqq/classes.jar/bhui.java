import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class bhui
  implements View.OnClickListener
{
  bhui(bhuf parambhuf) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bhuf.a(this.a)) && ((bhuf.a(this.a) == null) || (!bhuf.a(this.a).contains(Integer.valueOf(i)))) && (bhuf.b(this.a) != -1) && (i != bhuf.b(this.a)))
    {
      localObject = (View)bhuf.a(this.a).get(bhuf.b(this.a));
      ((View)localObject).findViewById(2131361916).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361915);
      bhuf.a(this.a, (TextView)localObject, false);
      localObject = (View)bhuf.a(this.a).get(i);
      ((View)localObject).findViewById(2131361916).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361915);
      bhuf.a(this.a, (TextView)localObject, true);
      bhuf.a(this.a, i);
    }
    if (bhuf.a(this.a) != null) {
      bhuf.a(this.a).OnClick(paramView, i);
    }
    if (bhuf.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361915);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bhuf.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhui
 * JD-Core Version:    0.7.0.1
 */