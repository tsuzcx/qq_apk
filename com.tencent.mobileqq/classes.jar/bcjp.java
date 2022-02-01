import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.Set;

public class bcjp
  extends bchu
{
  public bcjp(FaceDecoder paramFaceDecoder, bchy parambchy, Set<String> paramSet)
  {
    super(paramFaceDecoder, parambchy, paramSet);
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    boolean bool = true;
    super.b(parambcfj, parambcnt);
    if (parambcnt.c() != null)
    {
      parambcfj = (bcef)parambcfj;
      if ((this.a == null) || (!this.a.contains(parambcfj.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(parambcfj.c()))
      {
        parambcnt.c().setText(parambcfj.c());
        i = 1;
      }
      parambcfj = parambcnt.c();
      int j;
      if (i != 0)
      {
        j = 0;
        parambcfj.setVisibility(j);
        parambcfj = parambcnt.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        parambcfj.setClickable(bool);
        if (parambcnt.a() != null) {
          parambcnt.a().setVisibility(8);
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
 * Qualified Name:     bcjp
 * JD-Core Version:    0.7.0.1
 */