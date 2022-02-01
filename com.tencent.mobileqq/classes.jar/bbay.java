import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bbay
  extends bbch
{
  public bbay(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  protected bbbm<bayt, bbhb> a(FaceDecoder paramFaceDecoder)
  {
    return new bbbc(paramFaceDecoder);
  }
  
  public void a(bayr parambayr, bbha parambbha)
  {
    parambayr = (bays)parambayr;
    LinearLayout localLinearLayout = ((bbgt)parambbha).a();
    if (localLinearLayout != null)
    {
      List localList = parambayr.a();
      if (localList != null)
      {
        localLinearLayout.removeAllViews();
        int k = Math.min(localList.size(), parambayr.a());
        int i = 0;
        if (i < k)
        {
          bayt localbayt = (bayt)localList.get(i);
          View localView = LayoutInflater.from(parambbha.a().getContext()).inflate(2131562755, null);
          bbgv localbbgv = new bbgv(localView);
          localView.setTag(2131380831, localbayt);
          localView.setTag(2131380836, localbbgv);
          localView.setTag(2131380832, Integer.valueOf(i));
          localView.setTag(2131380830, Integer.valueOf(localList.size()));
          localView.setTag(2131380833, this.a);
          bdvp.a(localView, 1, localbayt.b(), 2);
          bbgn.a(localbayt, k, i);
          int m = localbayt.a();
          int n = localbayt.b();
          if ((localbayt instanceof bayu)) {}
          for (int j = ((bayu)localbayt).u;; j = 0)
          {
            bbgn.a(m, n, localView, j);
            localLinearLayout.addView(localView);
            this.a.a(localbayt, localbbgv);
            i += 1;
            break;
          }
        }
      }
    }
    if (parambbha.b() != null) {
      parambbha.b().setVisibility(8);
    }
    if ((parambayr instanceof bayd))
    {
      parambayr = ((bayd)parambayr).a();
      parambbha = ((bbgt)parambbha).a();
      if (parambbha != null)
      {
        if (parambayr == null) {
          break label339;
        }
        parambbha.a().setVisibility(0);
        this.a.a(parambayr, parambbha);
      }
    }
    return;
    label339:
    parambbha.a().setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbay
 * JD-Core Version:    0.7.0.1
 */