import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Set;

public class bbrc
  extends bbph
{
  public bbrc(aobu paramaobu, bbpl parambbpl, Set<String> paramSet)
  {
    super(paramaobu, parambbpl, paramSet);
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    boolean bool = true;
    super.b(parambbmy, parambbvg);
    if (parambbvg.c() != null)
    {
      parambbmy = (bblu)parambbmy;
      if ((this.a == null) || (!this.a.contains(parambbmy.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(parambbmy.c()))
      {
        parambbvg.c().setText(parambbmy.c());
        i = 1;
      }
      parambbmy = parambbvg.c();
      int j;
      if (i != 0)
      {
        j = 0;
        parambbmy.setVisibility(j);
        parambbmy = parambbvg.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        parambbmy.setClickable(bool);
        if (parambbvg.a() != null) {
          parambbvg.a().setVisibility(8);
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
 * Qualified Name:     bbrc
 * JD-Core Version:    0.7.0.1
 */