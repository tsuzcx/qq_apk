import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bcig
  extends bciz
{
  public bcig(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected bcie<bcfj, bcnt> a(FaceDecoder paramFaceDecoder)
  {
    return new bcih(paramFaceDecoder);
  }
  
  public void a(bcfh parambcfh, bcns parambcns)
  {
    Object localObject = (bcfi)parambcfh;
    parambcfh = ((bcnv)parambcns).a();
    if (parambcfh != null)
    {
      List localList = ((bcfi)localObject).a();
      if (localList != null)
      {
        parambcfh.removeAllViews();
        int k = Math.min(localList.size(), ((bcfi)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (bcfj)localList.get(i);
          View localView = LayoutInflater.from(parambcns.a().getContext()).inflate(2131562833, null);
          bcnw localbcnw = new bcnw(localView);
          localView.setTag(2131381183, localObject);
          localView.setTag(2131381188, localbcnw);
          localView.setTag(2131381184, Integer.valueOf(i));
          localView.setTag(2131381182, Integer.valueOf(localList.size()));
          localView.setTag(2131381185, this.a);
          bcnf.a((bcfj)localObject, k, i);
          int m = ((bcfj)localObject).a();
          int n = ((bcfj)localObject).b();
          if ((localObject instanceof bcfk)) {}
          for (int j = ((bcfk)localObject).u;; j = 0)
          {
            bcnf.a(m, n, localView, j);
            parambcfh.addView(localView);
            this.a.a((bcfh)localObject, localbcnw);
            i += 1;
            break;
          }
        }
      }
    }
    if (parambcns.b() != null) {
      parambcns.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcig
 * JD-Core Version:    0.7.0.1
 */