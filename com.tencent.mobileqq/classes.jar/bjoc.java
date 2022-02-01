import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

class bjoc
  implements View.OnClickListener
{
  bjoc(bjnw parambjnw) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bjnw.a(this.a)) && ((bjnw.a(this.a) == null) || (!bjnw.a(this.a).contains(Integer.valueOf(i)))) && (bjnw.b(this.a) != -1) && (i != bjnw.b(this.a)))
    {
      localObject = (View)bjnw.a(this.a).get(bjnw.b(this.a));
      ((View)localObject).findViewById(2131361970).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361969);
      bjnw.a(this.a, (TextView)localObject, false);
      localObject = (View)bjnw.a(this.a).get(i);
      ((View)localObject).findViewById(2131361970).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361969);
      bjnw.a(this.a, (TextView)localObject, true);
      bjnw.a(this.a, i);
    }
    if (bjnw.a(this.a) != null) {
      bjnw.a(this.a).OnClick(paramView, i);
    }
    if (bjnw.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361969);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bjnw.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoc
 * JD-Core Version:    0.7.0.1
 */