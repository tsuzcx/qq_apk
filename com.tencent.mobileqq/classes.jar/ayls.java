import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Iterator;
import java.util.List;

public class ayls
  extends aylv
{
  private List<PhoneContact> a;
  
  public ayls(bcws parambcws, aylz paramaylz, List<PhoneContact> paramList)
  {
    super(parambcws, paramaylz);
    this.a = paramList;
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    boolean bool = true;
    super.b(paramayjl, paramayru);
    int i;
    int j;
    if (paramayru.c() != null)
    {
      paramayjl = (ayid)paramayjl;
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label101;
        }
        if (((PhoneContact)localIterator.next()).contactID != paramayjl.a.contactID) {
          break label197;
        }
        paramayru.c().setText(alpo.a(2131702899));
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
      if (!TextUtils.isEmpty(paramayjl.c()))
      {
        paramayru.c().setText(paramayjl.c());
        j = 1;
      }
      paramayjl = paramayru.c();
      if (j != 0)
      {
        i = 0;
        paramayjl.setVisibility(i);
        paramayjl = paramayru.a();
        if (j != 0) {
          break label191;
        }
      }
      for (;;)
      {
        paramayjl.setClickable(bool);
        if (paramayru.a() != null) {
          paramayru.a().setVisibility(8);
        }
        return;
        i = 8;
        break;
        bool = false;
      }
    }
  }
  
  public void d(ayjl paramayjl, ayru paramayru) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayls
 * JD-Core Version:    0.7.0.1
 */