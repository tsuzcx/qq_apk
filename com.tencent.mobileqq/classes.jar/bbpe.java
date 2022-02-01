import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class bbpe
  extends bbph
{
  private List<PhoneContact> a;
  
  public bbpe(aobu paramaobu, bbpl parambbpl, List<PhoneContact> paramList)
  {
    super(paramaobu, parambbpl);
    this.a = paramList;
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    boolean bool = true;
    super.b(parambbmy, parambbvg);
    int i;
    int j;
    if (parambbvg.c() != null)
    {
      parambbmy = (bblq)parambbmy;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != parambbmy.a.contactID) {
          break label197;
        }
        parambbvg.c().setText(anni.a(2131701318));
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
      if (!TextUtils.isEmpty(parambbmy.c()))
      {
        parambbvg.c().setText(parambbmy.c());
        j = 1;
      }
      parambbmy = parambbvg.c();
      if (j != 0)
      {
        i = 0;
        parambbmy.setVisibility(i);
        parambbmy = parambbvg.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        parambbmy.setClickable(bool);
        if (parambbvg.a() != null) {
          parambbvg.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(bbmy parambbmy, bbvg parambbvg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpe
 * JD-Core Version:    0.7.0.1
 */