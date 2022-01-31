import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class avqu
  extends avqx
{
  private List<PhoneContact> a;
  
  public avqu(azwg paramazwg, avrb paramavrb, List<PhoneContact> paramList)
  {
    super(paramazwg, paramavrb);
    this.a = paramList;
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    boolean bool = true;
    super.b(paramavon, paramavww);
    int i;
    int j;
    if (paramavww.c() != null)
    {
      paramavon = (avnf)paramavon;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != paramavon.a.contactID) {
          break label197;
        }
        paramavww.c().setText(ajjy.a(2131636732));
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
      if (!TextUtils.isEmpty(paramavon.c()))
      {
        paramavww.c().setText(paramavon.c());
        j = 1;
      }
      paramavon = paramavww.c();
      if (j != 0)
      {
        i = 0;
        paramavon.setVisibility(i);
        paramavon = paramavww.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        paramavon.setClickable(bool);
        if (paramavww.a() != null) {
          paramavww.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(avon paramavon, avww paramavww) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqu
 * JD-Core Version:    0.7.0.1
 */