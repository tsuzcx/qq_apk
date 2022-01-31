import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class awsk
  extends awqq
{
  private Set<String> b;
  
  public awsk(baxk parambaxk, awqu paramawqu, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(parambaxk, paramawqu, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    super.b(paramawog, paramawwp);
    if (paramawwp.c() != null)
    {
      localObject = paramawog.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        paramawwp.c().setText(ajyc.a(2131713728));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = bahx.b((QQAppInterface)localObject, paramawog.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(paramawwp instanceof awwj)) {
        break label165;
      }
      ((awwj)paramawwp).a(bool);
    }
    for (;;)
    {
      if (paramawwp.a() != null)
      {
        if ((!(paramawog instanceof awnb)) && (!(paramawog instanceof awmo)) && (!(paramawog instanceof awmw))) {
          break;
        }
        if (paramawwp.c() != null) {
          paramawwp.c().setVisibility(8);
        }
        paramawwp.a().setVisibility(0);
      }
      return;
      label165:
      if ((paramawwp instanceof awyi)) {
        ((awyi)paramawwp).a(bool);
      }
    }
    if (paramawwp.c() != null) {
      paramawwp.c().setVisibility(0);
    }
    paramawwp.a().setVisibility(8);
  }
  
  public void d(awog paramawog, awwp paramawwp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsk
 * JD-Core Version:    0.7.0.1
 */