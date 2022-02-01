import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bcio
  extends bciz
{
  public bcio(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected bcie<bcfj, bcnt> a(FaceDecoder paramFaceDecoder)
  {
    return new bcip(paramFaceDecoder);
  }
  
  public void a(bcfh parambcfh, bcns parambcns)
  {
    int i = 0;
    Object localObject = (bcfi)parambcfh;
    a(parambcns, (bcfi)localObject);
    int k = ((bcfi)localObject).a();
    parambcfh = parambcns.a();
    if ((parambcfh != null) && (parambcfh != null))
    {
      localObject = ((bcfi)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(parambcfh.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((bcnt)parambcfh.get(i)).a().setVisibility(0);
          ((bcnt)parambcfh.get(i)).a().setTag(2131381183, ((List)localObject).get(i));
          ((bcnt)parambcfh.get(i)).a().setTag(2131381188, parambcfh.get(i));
          ((bcnt)parambcfh.get(i)).a().setTag(2131381184, Integer.valueOf(i));
          ((bcnt)parambcfh.get(i)).a().setTag(2131381182, Integer.valueOf(parambcfh.size()));
          ((bcnt)parambcfh.get(i)).a().setTag(2131381185, this.a);
          bcnf.a((bcfj)((List)localObject).get(i), m, i);
          int n = ((bcfj)((List)localObject).get(i)).a();
          int i1 = ((bcfj)((List)localObject).get(i)).b();
          View localView = ((bcnt)parambcfh.get(i)).a();
          if ((((List)localObject).get(i) instanceof bcfk)) {}
          for (int j = ((bcfk)((List)localObject).get(i)).u;; j = 0)
          {
            bcnf.a(n, i1, localView, j);
            this.a.a((bcfh)((List)localObject).get(i), (bcnu)parambcfh.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < parambcfh.size())
        {
          ((bcnt)parambcfh.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < parambcfh.size())
      {
        ((bcnt)parambcfh.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (parambcns.b() != null) {
      parambcns.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcio
 * JD-Core Version:    0.7.0.1
 */