import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class avrj
  extends avsc
{
  public avrj(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  protected avrh<avon, avww> a(azwg paramazwg)
  {
    return new avrk(paramazwg);
  }
  
  public void a(avol paramavol, avwv paramavwv)
  {
    Object localObject = (avom)paramavol;
    paramavol = ((avwy)paramavwv).a();
    if (paramavol != null)
    {
      List localList = ((avom)localObject).a();
      if (localList != null)
      {
        paramavol.removeAllViews();
        int k = Math.min(localList.size(), ((avom)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (avon)localList.get(i);
          View localView = LayoutInflater.from(paramavwv.a().getContext()).inflate(2131496790, null);
          avwz localavwz = new avwz(localView);
          localView.setTag(2131313373, localObject);
          localView.setTag(2131313378, localavwz);
          localView.setTag(2131313374, Integer.valueOf(i));
          localView.setTag(2131313372, Integer.valueOf(localList.size()));
          localView.setTag(2131313375, this.a);
          avwi.a((avon)localObject, k, i);
          int m = ((avon)localObject).a();
          int n = ((avon)localObject).b();
          if ((localObject instanceof avoo)) {}
          for (int j = ((avoo)localObject).r;; j = 0)
          {
            avwi.a(m, n, localView, j);
            paramavol.addView(localView);
            this.a.a((avol)localObject, localavwz);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramavwv.b() != null) {
      paramavwv.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrj
 * JD-Core Version:    0.7.0.1
 */