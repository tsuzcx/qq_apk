import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class aynp
  extends aylv
{
  private Set<String> b;
  
  public aynp(bcws parambcws, aylz paramaylz, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(parambcws, paramaylz, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    super.b(paramayjl, paramayru);
    if (paramayru.c() != null)
    {
      localObject = paramayjl.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        paramayru.c().setText(alpo.a(2131714111));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = bcgx.b((QQAppInterface)localObject, paramayjl.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(paramayru instanceof ayro)) {
        break label165;
      }
      ((ayro)paramayru).a(bool);
    }
    for (;;)
    {
      if (paramayru.a() != null)
      {
        if ((!(paramayjl instanceof ayig)) && (!(paramayjl instanceof ayht)) && (!(paramayjl instanceof ayib))) {
          break;
        }
        if (paramayru.c() != null) {
          paramayru.c().setVisibility(8);
        }
        paramayru.a().setVisibility(0);
      }
      return;
      label165:
      if ((paramayru instanceof aytn)) {
        ((aytn)paramayru).a(bool);
      }
    }
    if (paramayru.c() != null) {
      paramayru.c().setVisibility(0);
    }
    paramayru.a().setVisibility(8);
  }
  
  public void d(ayjl paramayjl, ayru paramayru) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynp
 * JD-Core Version:    0.7.0.1
 */