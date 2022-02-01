import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class bchx
  extends bcia
{
  private List<PhoneContact> a;
  
  public bchx(aoof paramaoof, bcie parambcie, List<PhoneContact> paramList)
  {
    super(paramaoof, parambcie);
    this.a = paramList;
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    boolean bool = true;
    super.b(parambcfr, parambcnz);
    int i;
    int j;
    if (parambcnz.c() != null)
    {
      parambcfr = (bcej)parambcfr;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != parambcfr.a.contactID) {
          break label197;
        }
        parambcnz.c().setText(anzj.a(2131701425));
        i = 1;
      }
    }
    label191:
    label197:
    for (;;)
    {
      break;
      j = 0;
      label101:
      if (!TextUtils.isEmpty(parambcfr.c()))
      {
        parambcnz.c().setText(parambcfr.c());
        j = 1;
      }
      parambcfr = parambcnz.c();
      if (j != 0)
      {
        i = 0;
        parambcfr.setVisibility(i);
        parambcfr = parambcnz.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        parambcfr.setClickable(bool);
        if (parambcnz.a() != null) {
          parambcnz.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(bcfr parambcfr, bcnz parambcnz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchx
 * JD-Core Version:    0.7.0.1
 */