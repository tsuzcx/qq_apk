import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

class bkzo
  implements View.OnClickListener
{
  bkzo(bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bkzi.a(this.a)) && ((bkzi.a(this.a) == null) || (!bkzi.a(this.a).contains(Integer.valueOf(i)))) && (bkzi.b(this.a) != -1) && (i != bkzi.b(this.a)))
    {
      localObject = (View)bkzi.a(this.a).get(bkzi.b(this.a));
      ((View)localObject).findViewById(2131361972).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361971);
      bkzi.a(this.a, (TextView)localObject, false);
      localObject = (View)bkzi.a(this.a).get(i);
      ((View)localObject).findViewById(2131361972).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361971);
      bkzi.a(this.a, (TextView)localObject, true);
      bkzi.a(this.a, i);
    }
    if (bkzi.a(this.a) != null) {
      bkzi.a(this.a).OnClick(paramView, i);
    }
    if (bkzi.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361971);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bkzi.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzo
 * JD-Core Version:    0.7.0.1
 */