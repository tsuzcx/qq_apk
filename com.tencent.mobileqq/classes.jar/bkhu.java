import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

class bkhu
  implements View.OnClickListener
{
  bkhu(bkho parambkho) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bkho.a(this.a)) && ((bkho.a(this.a) == null) || (!bkho.a(this.a).contains(Integer.valueOf(i)))) && (bkho.b(this.a) != -1) && (i != bkho.b(this.a)))
    {
      localObject = (View)bkho.a(this.a).get(bkho.b(this.a));
      ((View)localObject).findViewById(2131361971).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361970);
      bkho.a(this.a, (TextView)localObject, false);
      localObject = (View)bkho.a(this.a).get(i);
      ((View)localObject).findViewById(2131361971).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361970);
      bkho.a(this.a, (TextView)localObject, true);
      bkho.a(this.a, i);
    }
    if (bkho.a(this.a) != null) {
      bkho.a(this.a).OnClick(paramView, i);
    }
    if (bkho.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361970);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bkho.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhu
 * JD-Core Version:    0.7.0.1
 */