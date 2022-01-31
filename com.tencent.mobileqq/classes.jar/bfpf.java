import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.HashSet;

class bfpf
  implements View.OnClickListener
{
  bfpf(bfpc parambfpc) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((bfpc.a(this.a)) && ((bfpc.a(this.a) == null) || (!bfpc.a(this.a).contains(Integer.valueOf(i)))) && (bfpc.b(this.a) != -1) && (i != bfpc.b(this.a)))
    {
      localObject = (View)bfpc.a(this.a).get(bfpc.b(this.a));
      ((View)localObject).findViewById(2131361914).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131361913);
      bfpc.a(this.a, (TextView)localObject, false);
      localObject = (View)bfpc.a(this.a).get(i);
      ((View)localObject).findViewById(2131361914).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131361913);
      bfpc.a(this.a, (TextView)localObject, true);
      bfpc.a(this.a, i);
    }
    if (bfpc.a(this.a) != null) {
      bfpc.a(this.a).OnClick(paramView, i);
    }
    if (bfpc.a(this.a) != null)
    {
      localObject = (TextView)paramView.findViewById(2131361913);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        bfpc.a(this.a).a(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfpf
 * JD-Core Version:    0.7.0.1
 */