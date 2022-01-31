import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class bgsl
  implements View.OnClickListener
{
  bgsl(bgsi parambgsi) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bgsi.a(this.a)) && ((bgsi.a(this.a) == null) || (!bgsi.a(this.a).contains(Integer.valueOf(i)))) && (bgsi.b(this.a) != -1) && (i != bgsi.b(this.a)))
    {
      localObject = (View)bgsi.a(this.a).get(bgsi.b(this.a));
      ((View)localObject).findViewById(2131361916).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361915);
      bgsi.a(this.a, (TextView)localObject, false);
      localObject = (View)bgsi.a(this.a).get(i);
      ((View)localObject).findViewById(2131361916).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361915);
      bgsi.a(this.a, (TextView)localObject, true);
      bgsi.a(this.a, i);
    }
    if (bgsi.a(this.a) != null) {
      bgsi.a(this.a).OnClick(paramView, i);
    }
    if (bgsi.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361915);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bgsi.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsl
 * JD-Core Version:    0.7.0.1
 */