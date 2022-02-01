import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bbbo
  extends bbch
{
  public bbbo(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected bbbm<bayt, bbhb> a(FaceDecoder paramFaceDecoder)
  {
    return new bbbp(paramFaceDecoder);
  }
  
  public void a(bayr parambayr, bbha parambbha)
  {
    Object localObject = (bays)parambayr;
    parambayr = ((bbhd)parambbha).a();
    if (parambayr != null)
    {
      List localList = ((bays)localObject).a();
      if (localList != null)
      {
        parambayr.removeAllViews();
        int k = Math.min(localList.size(), ((bays)localObject).a());
        int i = 0;
        if (i < k)
        {
          localObject = (bayt)localList.get(i);
          View localView = LayoutInflater.from(parambbha.a().getContext()).inflate(2131562762, null);
          bbhe localbbhe = new bbhe(localView);
          localView.setTag(2131380831, localObject);
          localView.setTag(2131380836, localbbhe);
          localView.setTag(2131380832, Integer.valueOf(i));
          localView.setTag(2131380830, Integer.valueOf(localList.size()));
          localView.setTag(2131380833, this.a);
          bbgn.a((bayt)localObject, k, i);
          int m = ((bayt)localObject).a();
          int n = ((bayt)localObject).b();
          if ((localObject instanceof bayu)) {}
          for (int j = ((bayu)localObject).u;; j = 0)
          {
            bbgn.a(m, n, localView, j);
            parambayr.addView(localView);
            this.a.a((bayr)localObject, localbbhe);
            i += 1;
            break;
          }
        }
      }
    }
    if (parambbha.b() != null) {
      parambbha.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbo
 * JD-Core Version:    0.7.0.1
 */