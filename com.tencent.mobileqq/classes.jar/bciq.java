import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bciq
  extends bcjf
{
  public bciq(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  protected bcik<bcfr, bcnz> a(aoof paramaoof)
  {
    return new bcir(paramaoof);
  }
  
  public void a(bcfp parambcfp, bcny parambcny)
  {
    parambcfp = (bcfq)parambcfp;
    LinearLayout localLinearLayout = ((bcod)parambcny).a();
    List localList;
    int k;
    int i;
    bcfn localbcfn;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = parambcfp.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          parambcfp = (bcfr)localList.get(i);
          if ((parambcfp instanceof bcfn))
          {
            localbcfn = (bcfn)parambcfp;
            localObject2 = null;
            if (bchc.a(localbcfn.e()) == 1)
            {
              localObject2 = LayoutInflater.from(parambcny.a().getContext()).inflate(2131562876, null);
              parambcfp = ((View)localObject2).findViewById(2131368866);
              localObject1 = new bcnt((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (parambcfp != null))
      {
        ((View)localObject2).setTag(2131381109, localbcfn);
        ((View)localObject2).setTag(2131381115, localObject1);
        ((View)localObject2).setTag(2131381110, Integer.valueOf(i));
        ((View)localObject2).setTag(2131381108, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131381111, this.a);
        bfmf.a((View)localObject2, localbcfn.d(), localbcfn.b(), 1);
        bcnl.a(localbcfn, k, i);
        int m = localbcfn.a();
        int n = localbcfn.b();
        if ((localbcfn instanceof bcfs))
        {
          j = localbcfn.u;
          label256:
          bcnl.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localbcfn, (bcoa)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (bchc.a(localbcfn.e()) != 2) {
          break label554;
        }
        localObject2 = LayoutInflater.from(parambcny.a().getContext()).inflate(2131562883, null);
        parambcfp = ((View)localObject2).findViewById(2131368866);
        localObject1 = new bcoc((View)localObject2);
        break label137;
        j = 0;
        break label256;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localbcfn.e());
        continue;
        if ((parambcfp instanceof bcep))
        {
          parambcfp = (bcep)parambcfp;
          localObject1 = new bcph(localLinearLayout, parambcfp.d());
          localObject2 = ((bcph)localObject1).a();
          ((View)localObject2).setTag(2131381109, parambcfp);
          ((View)localObject2).setTag(2131381115, localObject1);
          ((View)localObject2).setTag(2131381110, Integer.valueOf(i));
          ((View)localObject2).setTag(2131381108, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131381111, this.a);
          bcnl.a(parambcfp, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((bcph)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(parambcfp, (bcoa)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (parambcny.b() != null) {
        parambcny.b().setVisibility(8);
      }
      return;
      label554:
      parambcfp = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciq
 * JD-Core Version:    0.7.0.1
 */