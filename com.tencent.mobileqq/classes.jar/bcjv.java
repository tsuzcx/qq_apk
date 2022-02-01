import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Set;

public class bcjv
  extends bcia
{
  public bcjv(aoof paramaoof, bcie parambcie, Set<String> paramSet)
  {
    super(paramaoof, parambcie, paramSet);
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    boolean bool = true;
    super.b(parambcfr, parambcnz);
    if (parambcnz.c() != null)
    {
      parambcfr = (bcen)parambcfr;
      if ((this.a == null) || (!this.a.contains(parambcfr.b()))) {
        break label144;
      }
    }
    label138:
    label144:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(parambcfr.c()))
      {
        parambcnz.c().setText(parambcfr.c());
        i = 1;
      }
      parambcfr = parambcnz.c();
      int j;
      if (i != 0)
      {
        j = 0;
        parambcfr.setVisibility(j);
        parambcfr = parambcnz.a();
        if (i != 0) {
          break label138;
        }
      }
      for (;;)
      {
        parambcfr.setClickable(bool);
        if (parambcnz.a() != null) {
          parambcnz.a().setVisibility(8);
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
 * Qualified Name:     bcjv
 * JD-Core Version:    0.7.0.1
 */