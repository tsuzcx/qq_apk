import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class bfoo
  implements View.OnClickListener
{
  bfoo(bfol parambfol) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bfol.a(this.a)) && ((bfol.a(this.a) == null) || (!bfol.a(this.a).contains(Integer.valueOf(i)))) && (bfol.b(this.a) != -1) && (i != bfol.b(this.a)))
    {
      localObject = (View)bfol.a(this.a).get(bfol.b(this.a));
      ((View)localObject).findViewById(2131361915).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361914);
      bfol.a(this.a, (TextView)localObject, false);
      localObject = (View)bfol.a(this.a).get(i);
      ((View)localObject).findViewById(2131361915).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361914);
      bfol.a(this.a, (TextView)localObject, true);
      bfol.a(this.a, i);
    }
    if (bfol.a(this.a) != null) {
      bfol.a(this.a).OnClick(paramView, i);
    }
    if (bfol.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361914);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bfol.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfoo
 * JD-Core Version:    0.7.0.1
 */