import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class avqt
  extends avsc
{
  public avqt(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  protected avrh<avon, avww> a(azwg paramazwg)
  {
    return new avqx(paramazwg);
  }
  
  public void a(avol paramavol, avwv paramavwv)
  {
    paramavol = (avom)paramavol;
    LinearLayout localLinearLayout = ((avwo)paramavwv).a();
    if (localLinearLayout != null)
    {
      List localList = paramavol.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), paramavol.a());
        int i = 0;
        if (i < k)
        {
          avon localavon = (avon)localList.get(i);
          View localView = LayoutInflater.from(paramavwv.a().getContext()).inflate(2131496782, null);
          avwq localavwq = new avwq(localView);
          localView.setTag(2131313373, localavon);
          localView.setTag(2131313378, localavwq);
          localView.setTag(2131313374, Integer.valueOf(i));
          localView.setTag(2131313372, Integer.valueOf(localList.size()));
          localView.setTag(2131313375, this.a);
          avwi.a(localavon, k, i);
          int m = localavon.a();
          int n = localavon.b();
          if ((localavon instanceof avoo)) {}
          for (int j = ((avoo)localavon).r;; j = 0)
          {
            avwi.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localavon, localavwq);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramavwv.b() != null) {
      paramavwv.b().setVisibility(8);
    }
    if ((paramavol instanceof avnx))
    {
      paramavol = ((avnx)paramavol).a();
      paramavwv = ((avwo)paramavwv).a();
      if (paramavwv != null)
      {
        if (paramavol == null) {
          break label325;
        }
        paramavwv.a().setVisibility(0);
        this.a.a(paramavol, paramavwv);
      }
    }
    return;
    label325:
    paramavwv.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqt
 * JD-Core Version:    0.7.0.1
 */