import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bchq
  extends bciz
{
  public bchq(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected bcie<bcfj, bcnt> a(FaceDecoder paramFaceDecoder)
  {
    return new bchu(paramFaceDecoder);
  }
  
  public void a(bcfh parambcfh, bcns parambcns)
  {
    parambcfh = (bcfi)parambcfh;
    LinearLayout localLinearLayout = ((bcnl)parambcns).a();
    if (localLinearLayout != null)
    {
      List localList = parambcfh.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), parambcfh.a());
        int i = 0;
        if (i < k)
        {
          bcfj localbcfj = (bcfj)localList.get(i);
          View localView = LayoutInflater.from(parambcns.a().getContext()).inflate(2131562826, null);
          bcnn localbcnn = new bcnn(localView);
          localView.setTag(2131381183, localbcfj);
          localView.setTag(2131381188, localbcnn);
          localView.setTag(2131381184, Integer.valueOf(i));
          localView.setTag(2131381182, Integer.valueOf(localList.size()));
          localView.setTag(2131381185, this.a);
          bfcs.a(localView, 1, localbcfj.b(), 2);
          bcnf.a(localbcfj, k, i);
          int m = localbcfj.a();
          int n = localbcfj.b();
          if ((localbcfj instanceof bcfk)) {}
          for (int j = ((bcfk)localbcfj).u;; j = 0)
          {
            bcnf.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localbcfj, localbcnn);
            i += 1;
            break;
          }
        }
      }
    }
    if (parambcns.b() != null) {
      parambcns.b().setVisibility(8);
    }
    if ((parambcfh instanceof bcet))
    {
      parambcfh = ((bcet)parambcfh).a();
      parambcns = ((bcnl)parambcns).a();
      if (parambcns != null)
      {
        if (parambcfh == null) {
          break label339;
        }
        parambcns.a().setVisibility(0);
        this.a.a(parambcfh, parambcns);
      }
    }
    return;
    label339:
    parambcns.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchq
 * JD-Core Version:    0.7.0.1
 */