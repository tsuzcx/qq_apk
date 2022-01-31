import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Set;

public class avss
  extends avqx
{
  public avss(azwg paramazwg, avrb paramavrb, Set<String> paramSet)
  {
    super(paramazwg, paramavrb, paramSet);
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    boolean bool = true;
    super.b(paramavon, paramavww);
    if (paramavww.c() != null)
    {
      paramavon = (avnj)paramavon;
      if ((this.a == null) || (!this.a.contains(paramavon.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramavon.c()))
      {
        paramavww.c().setText(paramavon.c());
        i = 1;
      }
      paramavon = paramavww.c();
      int j;
      if (i != 0)
      {
        j = 0;
        paramavon.setVisibility(j);
        paramavon = paramavww.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        paramavon.setClickable(bool);
        if (paramavww.a() != null) {
          paramavww.a().setVisibility(8);
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
 * Qualified Name:     avss
 * JD-Core Version:    0.7.0.1
 */