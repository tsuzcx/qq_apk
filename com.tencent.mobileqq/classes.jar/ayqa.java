import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class ayqa
  extends ayrj
{
  public ayqa(bdbb parambdbb)
  {
    super(parambdbb);
  }
  
  protected ayqo<aynu, aywd> a(bdbb parambdbb)
  {
    return new ayqe(parambdbb);
  }
  
  public void a(ayns paramayns, aywc paramaywc)
  {
    paramayns = (aynt)paramayns;
    LinearLayout localLinearLayout = ((ayvv)paramaywc).a();
    if (localLinearLayout != null)
    {
      List localList = paramayns.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), paramayns.a());
        int i = 0;
        if (i < k)
        {
          aynu localaynu = (aynu)localList.get(i);
          View localView = LayoutInflater.from(paramaywc.a().getContext()).inflate(2131562604, null);
          ayvx localayvx = new ayvx(localView);
          localView.setTag(2131379971, localaynu);
          localView.setTag(2131379976, localayvx);
          localView.setTag(2131379972, Integer.valueOf(i));
          localView.setTag(2131379970, Integer.valueOf(localList.size()));
          localView.setTag(2131379973, this.a);
          ayvp.a(localaynu, k, i);
          int m = localaynu.a();
          int n = localaynu.b();
          if ((localaynu instanceof aynv)) {}
          for (int j = ((aynv)localaynu).r;; j = 0)
          {
            ayvp.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localaynu, localayvx);
            i += 1;
            break;
          }
        }
      }
    }
    if (paramaywc.b() != null) {
      paramaywc.b().setVisibility(8);
    }
    if ((paramayns instanceof ayne))
    {
      paramayns = ((ayne)paramayns).a();
      paramaywc = ((ayvv)paramaywc).a();
      if (paramaywc != null)
      {
        if (paramayns == null) {
          break label325;
        }
        paramaywc.a().setVisibility(0);
        this.a.a(paramayns, paramaywc);
      }
    }
    return;
    label325:
    paramaywc.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqa
 * JD-Core Version:    0.7.0.1
 */