import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class avrn
  extends avsc
{
  public avrn(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  protected avrh<avon, avww> a(azwg paramazwg)
  {
    return new avro(paramazwg);
  }
  
  public void a(avol paramavol, avwv paramavwv)
  {
    paramavol = (avom)paramavol;
    LinearLayout localLinearLayout = ((avxa)paramavwv).a();
    List localList;
    int k;
    int i;
    avoj localavoj;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = paramavol.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          paramavol = (avon)localList.get(i);
          if ((paramavol instanceof avoj))
          {
            localavoj = (avoj)paramavol;
            localObject2 = null;
            if (avpy.a(localavoj.e()) == 1)
            {
              localObject2 = LayoutInflater.from(paramavwv.a().getContext()).inflate(2131496782, null);
              paramavol = ((View)localObject2).findViewById(2131302703);
              localObject1 = new avwq((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (paramavol != null))
      {
        ((View)localObject2).setTag(2131313373, localavoj);
        ((View)localObject2).setTag(2131313378, localObject1);
        ((View)localObject2).setTag(2131313374, Integer.valueOf(i));
        ((View)localObject2).setTag(2131313372, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131313375, this.a);
        avwi.a(localavoj, k, i);
        int m = localavoj.a();
        int n = localavoj.b();
        if ((localavoj instanceof avoo))
        {
          j = localavoj.r;
          label240:
          avwi.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localavoj, (avwx)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (avpy.a(localavoj.e()) != 2) {
          break label538;
        }
        localObject2 = LayoutInflater.from(paramavwv.a().getContext()).inflate(2131496790, null);
        paramavol = ((View)localObject2).findViewById(2131302703);
        localObject1 = new avwz((View)localObject2);
        break label137;
        j = 0;
        break label240;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localavoj.e());
        continue;
        if ((paramavol instanceof avnl))
        {
          paramavol = (avnl)paramavol;
          localObject1 = new avye(localLinearLayout, paramavol.d());
          localObject2 = ((avye)localObject1).a();
          ((View)localObject2).setTag(2131313373, paramavol);
          ((View)localObject2).setTag(2131313378, localObject1);
          ((View)localObject2).setTag(2131313374, Integer.valueOf(i));
          ((View)localObject2).setTag(2131313372, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131313375, this.a);
          avwi.a(paramavol, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((avye)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(paramavol, (avwx)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (paramavwv.b() != null) {
        paramavwv.b().setVisibility(8);
      }
      return;
      label538:
      paramavol = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrn
 * JD-Core Version:    0.7.0.1
 */