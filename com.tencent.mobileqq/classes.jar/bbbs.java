import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bbbs
  extends bbch
{
  public bbbs(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected bbbm<bayt, bbhb> a(FaceDecoder paramFaceDecoder)
  {
    return new bbbt(paramFaceDecoder);
  }
  
  public void a(bayr parambayr, bbha parambbha)
  {
    parambayr = (bays)parambayr;
    LinearLayout localLinearLayout = ((bbhf)parambbha).a();
    List localList;
    int k;
    int i;
    bayp localbayp;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = parambayr.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          parambayr = (bayt)localList.get(i);
          if ((parambayr instanceof bayp))
          {
            localbayp = (bayp)parambayr;
            localObject2 = null;
            if (bbae.a(localbayp.e()) == 1)
            {
              localObject2 = LayoutInflater.from(parambbha.a().getContext()).inflate(2131562755, null);
              parambayr = ((View)localObject2).findViewById(2131368891);
              localObject1 = new bbgv((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (parambayr != null))
      {
        ((View)localObject2).setTag(2131380831, localbayp);
        ((View)localObject2).setTag(2131380836, localObject1);
        ((View)localObject2).setTag(2131380832, Integer.valueOf(i));
        ((View)localObject2).setTag(2131380830, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131380833, this.a);
        bdvp.a((View)localObject2, localbayp.d(), localbayp.b(), 1);
        bbgn.a(localbayp, k, i);
        int m = localbayp.a();
        int n = localbayp.b();
        if ((localbayp instanceof bayu))
        {
          j = localbayp.u;
          label256:
          bbgn.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localbayp, (bbhc)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (bbae.a(localbayp.e()) != 2) {
          break label554;
        }
        localObject2 = LayoutInflater.from(parambbha.a().getContext()).inflate(2131562762, null);
        parambayr = ((View)localObject2).findViewById(2131368891);
        localObject1 = new bbhe((View)localObject2);
        break label137;
        j = 0;
        break label256;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localbayp.e());
        continue;
        if ((parambayr instanceof baxr))
        {
          parambayr = (baxr)parambayr;
          localObject1 = new bbij(localLinearLayout, parambayr.d());
          localObject2 = ((bbij)localObject1).a();
          ((View)localObject2).setTag(2131380831, parambayr);
          ((View)localObject2).setTag(2131380836, localObject1);
          ((View)localObject2).setTag(2131380832, Integer.valueOf(i));
          ((View)localObject2).setTag(2131380830, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131380833, this.a);
          bbgn.a(parambayr, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((bbij)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(parambayr, (bbhc)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (parambbha.b() != null) {
        parambbha.b().setVisibility(8);
      }
      return;
      label554:
      parambayr = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbs
 * JD-Core Version:    0.7.0.1
 */