import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Set;

public class awsl
  extends awqq
{
  public awsl(baxk parambaxk, awqu paramawqu, Set<String> paramSet)
  {
    super(parambaxk, paramawqu, paramSet);
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    boolean bool = true;
    super.b(paramawog, paramawwp);
    if (paramawwp.c() != null)
    {
      paramawog = (awnc)paramawog;
      if ((this.a == null) || (!this.a.contains(paramawog.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramawog.c()))
      {
        paramawwp.c().setText(paramawog.c());
        i = 1;
      }
      paramawog = paramawwp.c();
      int j;
      if (i != 0)
      {
        j = 0;
        paramawog.setVisibility(j);
        paramawog = paramawwp.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        paramawog.setClickable(bool);
        if (paramawwp.a() != null) {
          paramawwp.a().setVisibility(8);
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
 * Qualified Name:     awsl
 * JD-Core Version:    0.7.0.1
 */