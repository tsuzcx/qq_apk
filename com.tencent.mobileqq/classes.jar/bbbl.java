import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.List;

public class bbbl
  extends bbch
{
  public bbbl(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder, 268435456);
  }
  
  public void a(bayr parambayr, bbha parambbha)
  {
    Object localObject1 = (bays)parambayr;
    parambayr = ((bbgy)parambbha).a();
    if (parambayr != null)
    {
      List localList = ((bays)localObject1).a();
      if (localList != null)
      {
        parambayr.removeAllViews();
        int j = Math.min(localList.size(), ((bays)localObject1).a());
        int i = 0;
        while (i < j)
        {
          localObject1 = new bbij(((bbgy)parambbha).a(), 268435456);
          Object localObject2 = ((bbij)localObject1).a();
          bayt localbayt = (bayt)localList.get(i);
          ((View)localObject2).setTag(2131380831, localbayt);
          ((View)localObject2).setTag(2131380836, localObject1);
          ((View)localObject2).setTag(2131380832, Integer.valueOf(i));
          ((View)localObject2).setTag(2131380830, Integer.valueOf(localList.size()));
          ((View)localObject2).setTag(2131380833, this.a);
          if ((localbayt instanceof baxr)) {
            bbgn.a((baxr)localbayt, j, i);
          }
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          parambayr.addView(((bbij)localObject1).a(), (ViewGroup.LayoutParams)localObject2);
          this.a.a(localbayt, (bbhc)localObject1);
          i += 1;
        }
      }
    }
    if (parambbha.b() != null) {
      parambbha.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbl
 * JD-Core Version:    0.7.0.1
 */