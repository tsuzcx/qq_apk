import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Set;

public class aynq
  extends aylv
{
  public aynq(bcws parambcws, aylz paramaylz, Set<String> paramSet)
  {
    super(parambcws, paramaylz, paramSet);
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    boolean bool = true;
    super.b(paramayjl, paramayru);
    if (paramayru.c() != null)
    {
      paramayjl = (ayih)paramayjl;
      if ((this.a == null) || (!this.a.contains(paramayjl.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(paramayjl.c()))
      {
        paramayru.c().setText(paramayjl.c());
        i = 1;
      }
      paramayjl = paramayru.c();
      int j;
      if (i != 0)
      {
        j = 0;
        paramayjl.setVisibility(j);
        paramayjl = paramayru.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        paramayjl.setClickable(bool);
        if (paramayru.a() != null) {
          paramayru.a().setVisibility(8);
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
 * Qualified Name:     aynq
 * JD-Core Version:    0.7.0.1
 */