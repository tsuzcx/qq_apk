import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class bchw
  extends bcjf
{
  public bchw(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  protected bcik<bcfr, bcnz> a(aoof paramaoof)
  {
    return new bcia(paramaoof);
  }
  
  public void a(bcfp parambcfp, bcny parambcny)
  {
    parambcfp = (bcfq)parambcfp;
    LinearLayout localLinearLayout = ((bcnr)parambcny).a();
    if (localLinearLayout != null)
    {
      List localList = parambcfp.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), parambcfp.a());
        int i = 0;
        if (i < k)
        {
          bcfr localbcfr = (bcfr)localList.get(i);
          View localView = LayoutInflater.from(parambcny.a().getContext()).inflate(2131562876, null);
          bcnt localbcnt = new bcnt(localView);
          localView.setTag(2131381109, localbcfr);
          localView.setTag(2131381115, localbcnt);
          localView.setTag(2131381110, Integer.valueOf(i));
          localView.setTag(2131381108, Integer.valueOf(localList.size()));
          localView.setTag(2131381111, this.a);
          bfmf.a(localView, 1, localbcfr.b(), 2);
          bcnl.a(localbcfr, k, i);
          int m = localbcfr.a();
          int n = localbcfr.b();
          if ((localbcfr instanceof bcfs)) {}
          for (int j = ((bcfs)localbcfr).u;; j = 0)
          {
            bcnl.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localbcfr, localbcnt);
            i += 1;
            break;
          }
        }
      }
    }
    if (parambcny.b() != null) {
      parambcny.b().setVisibility(8);
    }
    if ((parambcfp instanceof bcfb))
    {
      parambcfp = ((bcfb)parambcfp).a();
      parambcny = ((bcnr)parambcny).a();
      if (parambcny != null)
      {
        if (parambcfp == null) {
          break label339;
        }
        parambcny.a().setVisibility(0);
        this.a.a(parambcfp, parambcny);
      }
    }
    return;
    label339:
    parambcny.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchw
 * JD-Core Version:    0.7.0.1
 */