import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class bgoe
  implements View.OnClickListener
{
  bgoe(bgob parambgob) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bgob.a(this.a)) && ((bgob.a(this.a) == null) || (!bgob.a(this.a).contains(Integer.valueOf(i)))) && (bgob.b(this.a) != -1) && (i != bgob.b(this.a)))
    {
      localObject = (View)bgob.a(this.a).get(bgob.b(this.a));
      ((View)localObject).findViewById(2131361916).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361915);
      bgob.a(this.a, (TextView)localObject, false);
      localObject = (View)bgob.a(this.a).get(i);
      ((View)localObject).findViewById(2131361916).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361915);
      bgob.a(this.a, (TextView)localObject, true);
      bgob.a(this.a, i);
    }
    if (bgob.a(this.a) != null) {
      bgob.a(this.a).OnClick(paramView, i);
    }
    if (bgob.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361915);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bgob.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgoe
 * JD-Core Version:    0.7.0.1
 */