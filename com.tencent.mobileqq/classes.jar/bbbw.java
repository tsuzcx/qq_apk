import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bbbw
  extends bbch
{
  public bbbw(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected bbbm<bayt, bbhb> a(FaceDecoder paramFaceDecoder)
  {
    return new bbbx(paramFaceDecoder);
  }
  
  public void a(bayr parambayr, bbha parambbha)
  {
    int i = 0;
    Object localObject = (bays)parambayr;
    a(parambbha, (bays)localObject);
    int k = ((bays)localObject).a();
    parambayr = parambbha.a();
    if ((parambayr != null) && (parambayr != null))
    {
      localObject = ((bays)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(parambayr.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((bbhb)parambayr.get(i)).a().setVisibility(0);
          ((bbhb)parambayr.get(i)).a().setTag(2131380831, ((List)localObject).get(i));
          ((bbhb)parambayr.get(i)).a().setTag(2131380836, parambayr.get(i));
          ((bbhb)parambayr.get(i)).a().setTag(2131380832, Integer.valueOf(i));
          ((bbhb)parambayr.get(i)).a().setTag(2131380830, Integer.valueOf(parambayr.size()));
          ((bbhb)parambayr.get(i)).a().setTag(2131380833, this.a);
          bbgn.a((bayt)((List)localObject).get(i), m, i);
          int n = ((bayt)((List)localObject).get(i)).a();
          int i1 = ((bayt)((List)localObject).get(i)).b();
          View localView = ((bbhb)parambayr.get(i)).a();
          if ((((List)localObject).get(i) instanceof bayu)) {}
          for (int j = ((bayu)((List)localObject).get(i)).u;; j = 0)
          {
            bbgn.a(n, i1, localView, j);
            this.a.a((bayr)((List)localObject).get(i), (bbhc)parambayr.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < parambayr.size())
        {
          ((bbhb)parambayr.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < parambayr.size())
      {
        ((bbhb)parambayr.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (parambbha.b() != null) {
      parambbha.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbw
 * JD-Core Version:    0.7.0.1
 */