import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class ayry
  extends ayqe
{
  private Set<String> b;
  
  public ayry(bdbb parambdbb, ayqi paramayqi, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(parambdbb, paramayqi, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    super.b(paramaynu, paramaywd);
    if (paramaywd.c() != null)
    {
      localObject = paramaynu.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        paramaywd.c().setText(alud.a(2131714123));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = bclg.b((QQAppInterface)localObject, paramaynu.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(paramaywd instanceof ayvx)) {
        break label165;
      }
      ((ayvx)paramaywd).a(bool);
    }
    for (;;)
    {
      if (paramaywd.a() != null)
      {
        if ((!(paramaynu instanceof aymp)) && (!(paramaynu instanceof aymc)) && (!(paramaynu instanceof aymk))) {
          break;
        }
        if (paramaywd.c() != null) {
          paramaywd.c().setVisibility(8);
        }
        paramaywd.a().setVisibility(0);
      }
      return;
      label165:
      if ((paramaywd instanceof ayxw)) {
        ((ayxw)paramaywd).a(bool);
      }
    }
    if (paramaywd.c() != null) {
      paramaywd.c().setVisibility(0);
    }
    paramaywd.a().setVisibility(8);
  }
  
  public void d(aynu paramaynu, aywd paramaywd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayry
 * JD-Core Version:    0.7.0.1
 */