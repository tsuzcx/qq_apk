import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

class blix
  implements View.OnClickListener
{
  blix(blir paramblir) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((blir.a(this.a)) && ((blir.a(this.a) == null) || (!blir.a(this.a).contains(Integer.valueOf(i)))) && (blir.b(this.a) != -1) && (i != blir.b(this.a)))
    {
      localObject = (View)blir.a(this.a).get(blir.b(this.a));
      ((View)localObject).findViewById(2131361971).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361970);
      blir.a(this.a, (TextView)localObject, false);
      localObject = (View)blir.a(this.a).get(i);
      ((View)localObject).findViewById(2131361971).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361970);
      blir.a(this.a, (TextView)localObject, true);
      blir.a(this.a, i);
    }
    if (blir.a(this.a) != null) {
      blir.a(this.a).OnClick(paramView, i);
    }
    if (blir.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361970);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        blir.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blix
 * JD-Core Version:    0.7.0.1
 */