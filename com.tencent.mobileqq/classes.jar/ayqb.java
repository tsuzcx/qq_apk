import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class ayqb
  extends ayqe
{
  private List<PhoneContact> a;
  
  public ayqb(bdbb parambdbb, ayqi paramayqi, List<PhoneContact> paramList)
  {
    super(parambdbb, paramayqi);
    this.a = paramList;
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    boolean bool = true;
    super.b(paramaynu, paramaywd);
    int i;
    int j;
    if (paramaywd.c() != null)
    {
      paramaynu = (aymm)paramaynu;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != paramaynu.a.contactID) {
          break label197;
        }
        paramaywd.c().setText(alud.a(2131702911));
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
      if (!TextUtils.isEmpty(paramaynu.c()))
      {
        paramaywd.c().setText(paramaynu.c());
        j = 1;
      }
      paramaynu = paramaywd.c();
      if (j != 0)
      {
        i = 0;
        paramaynu.setVisibility(i);
        paramaynu = paramaywd.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        paramaynu.setClickable(bool);
        if (paramaywd.a() != null) {
          paramaywd.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(aynu paramaynu, aywd paramaywd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqb
 * JD-Core Version:    0.7.0.1
 */