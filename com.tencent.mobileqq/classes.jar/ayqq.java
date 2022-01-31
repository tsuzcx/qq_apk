import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class ayqq
  extends ayrj
{
  public ayqq(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  protected ayqo<aynu, aywd> a(bdbb parambdbb)
  {
    return new ayqr(parambdbb);
  }
  
  public void a(ayns paramayns, aywc paramaywc)
  {
    Object localObject = (aynt)paramayns;
    paramayns = ((aywf)paramaywc).a();
    if (paramayns != null)
    {
      List localList = ((aynt)localObject).a();
      if (localList != null)
      {
        paramayns.removeAllViews();
        int k = Math.min(localList.size(), ((aynt)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (aynu)localList.get(i);
          View localView = LayoutInflater.from(paramaywc.a().getContext()).inflate(2131562611, null);
          aywg localaywg = new aywg(localView);
          localView.setTag(2131379971, localObject);
          localView.setTag(2131379976, localaywg);
          localView.setTag(2131379972, Integer.valueOf(i));
          localView.setTag(2131379970, Integer.valueOf(localList.size()));
          localView.setTag(2131379973, this.a);
          ayvp.a((aynu)localObject, k, i);
          int m = ((aynu)localObject).a();
          int n = ((aynu)localObject).b();
          if ((localObject instanceof aynv)) {}
          for (int j = ((aynv)localObject).r;; j = 0)
          {
            ayvp.a(m, n, localView, j);
            paramayns.addView(localView);
            this.a.a((ayns)localObject, localaywg);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramaywc.b() != null) {
      paramaywc.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqq
 * JD-Core Version:    0.7.0.1
 */