import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.Set;

public class bbcx
  extends bbbc
{
  public bbcx(FaceDecoder paramFaceDecoder, bbbg parambbbg, Set<String> paramSet)
  {
    super(paramFaceDecoder, parambbbg, paramSet);
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    boolean bool = true;
    super.b(parambayt, parambbhb);
    if (parambbhb.c() != null)
    {
      parambayt = (baxp)parambayt;
      if ((this.a == null) || (!this.a.contains(parambayt.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(parambayt.c()))
      {
        parambbhb.c().setText(parambayt.c());
        i = 1;
      }
      parambayt = parambbhb.c();
      int j;
      if (i != 0)
      {
        j = 0;
        parambayt.setVisibility(j);
        parambayt = parambbhb.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        parambayt.setClickable(bool);
        if (parambbhb.a() != null) {
          parambbhb.a().setVisibility(8);
        }
        return;
        j = 8;
        break;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcx
 * JD-Core Version:    0.7.0.1
 */