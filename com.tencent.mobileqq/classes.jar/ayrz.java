import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Set;

public class ayrz
  extends ayqe
{
  public ayrz(bdbb parambdbb, ayqi paramayqi, Set<String> paramSet)
  {
    super(parambdbb, paramayqi, paramSet);
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    boolean bool = true;
    super.b(paramaynu, paramaywd);
    if (paramaywd.c() != null)
    {
      paramaynu = (aymq)paramaynu;
      if ((this.a == null) || (!this.a.contains(paramaynu.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramaynu.c()))
      {
        paramaywd.c().setText(paramaynu.c());
        i = 1;
      }
      paramaynu = paramaywd.c();
      int j;
      if (i != 0)
      {
        j = 0;
        paramaynu.setVisibility(j);
        paramaynu = paramaywd.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        paramaynu.setClickable(bool);
        if (paramaywd.a() != null) {
          paramaywd.a().setVisibility(8);
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
 * Qualified Name:     ayrz
 * JD-Core Version:    0.7.0.1
 */