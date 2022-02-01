import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bcik
  extends bciz
{
  public bcik(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected bcie<bcfj, bcnt> a(FaceDecoder paramFaceDecoder)
  {
    return new bcil(paramFaceDecoder);
  }
  
  public void a(bcfh parambcfh, bcns parambcns)
  {
    parambcfh = (bcfi)parambcfh;
    LinearLayout localLinearLayout = ((bcnx)parambcns).a();
    List localList;
    int k;
    int i;
    bcff localbcff;
    Object localObject2;
    Object localObject1;
    if (localLinearLayout != null)
    {
      localList = parambcfh.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        k = Math.min(localList.size(), 3);
        i = 0;
        if (i < k)
        {
          parambcfh = (bcfj)localList.get(i);
          if ((parambcfh instanceof bcff))
          {
            localbcff = (bcff)parambcfh;
            localObject2 = null;
            if (bcgu.a(localbcff.e()) == 1)
            {
              localObject2 = LayoutInflater.from(parambcns.a().getContext()).inflate(2131562826, null);
              parambcfh = ((View)localObject2).findViewById(2131369049);
              localObject1 = new bcnn((View)localObject2);
            }
          }
        }
      }
    }
    for (;;)
    {
      label137:
      int j;
      if ((localObject2 != null) && (parambcfh != null))
      {
        ((View)localObject2).setTag(2131381183, localbcff);
        ((View)localObject2).setTag(2131381188, localObject1);
        ((View)localObject2).setTag(2131381184, Integer.valueOf(i));
        ((View)localObject2).setTag(2131381182, Integer.valueOf(localList.size()));
        ((View)localObject2).setTag(2131381185, this.a);
        bfcs.a((View)localObject2, localbcff.d(), localbcff.b(), 1);
        bcnf.a(localbcff, k, i);
        int m = localbcff.a();
        int n = localbcff.b();
        if ((localbcff instanceof bcfk))
        {
          j = localbcff.u;
          label256:
          bcnf.a(m, n, (View)localObject2, j);
          localLinearLayout.addView((View)localObject2);
          this.a.a(localbcff, (bcnu)localObject1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (bcgu.a(localbcff.e()) != 2) {
          break label554;
        }
        localObject2 = LayoutInflater.from(parambcns.a().getContext()).inflate(2131562833, null);
        parambcfh = ((View)localObject2).findViewById(2131369049);
        localObject1 = new bcnw((View)localObject2);
        break label137;
        j = 0;
        break label256;
        QLog.e("MostUseResultGroupPresenter", 2, "unresolved id type" + localbcff.e());
        continue;
        if ((parambcfh instanceof bceh))
        {
          parambcfh = (bceh)parambcfh;
          localObject1 = new bcpb(localLinearLayout, parambcfh.d());
          localObject2 = ((bcpb)localObject1).a();
          ((View)localObject2).setTag(2131381183, parambcfh);
          ((View)localObject2).setTag(2131381188, localObject1);
          ((View)localObject2).setTag(2131381184, Integer.valueOf(i));
          ((View)localObject2).setTag(2131381182, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131381185, this.a);
          bcnf.a(parambcfh, k, i);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          localLinearLayout.addView(((bcpb)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(parambcfh, (bcnu)localObject1);
        }
        else
        {
          QLog.e("MostUseResultGroupPresenter", 2, "unknown type in MOST USED GROUP P");
        }
      }
      if (parambcns.b() != null) {
        parambcns.b().setVisibility(8);
      }
      return;
      label554:
      parambcfh = null;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcik
 * JD-Core Version:    0.7.0.1
 */