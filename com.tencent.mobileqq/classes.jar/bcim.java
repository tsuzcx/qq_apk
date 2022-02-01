import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class bcim
  extends bcjf
{
  public bcim(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  protected bcik<bcfr, bcnz> a(aoof paramaoof)
  {
    return new bcin(paramaoof);
  }
  
  public void a(bcfp parambcfp, bcny parambcny)
  {
    Object localObject = (bcfq)parambcfp;
    parambcfp = ((bcob)parambcny).a();
    if (parambcfp != null)
    {
      List localList = ((bcfq)localObject).a();
      if (localList != null)
      {
        parambcfp.removeAllViews();
        int k = Math.min(localList.size(), ((bcfq)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (bcfr)localList.get(i);
          View localView = LayoutInflater.from(parambcny.a().getContext()).inflate(2131562883, null);
          bcoc localbcoc = new bcoc(localView);
          localView.setTag(2131381109, localObject);
          localView.setTag(2131381115, localbcoc);
          localView.setTag(2131381110, Integer.valueOf(i));
          localView.setTag(2131381108, Integer.valueOf(localList.size()));
          localView.setTag(2131381111, this.a);
          bcnl.a((bcfr)localObject, k, i);
          int m = ((bcfr)localObject).a();
          int n = ((bcfr)localObject).b();
          if ((localObject instanceof bcfs)) {}
          for (int j = ((bcfs)localObject).u;; j = 0)
          {
            bcnl.a(m, n, localView, j);
            parambcfp.addView(localView);
            this.a.a((bcfp)localObject, localbcoc);
            i += 1;
            break;
          }
        }
      }
    }
    if (parambcny.b() != null) {
      parambcny.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcim
 * JD-Core Version:    0.7.0.1
 */