import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class bbrb
  extends bbph
{
  private Set<String> b;
  
  public bbrb(aobu paramaobu, bbpl parambbpl, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(paramaobu, parambbpl, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    super.b(parambbmy, parambbvg);
    if (parambbvg.c() != null)
    {
      localObject = parambbmy.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        parambbvg.c().setText(anni.a(2131712495));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = bfpx.b((QQAppInterface)localObject, parambbmy.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(parambbvg instanceof bbva)) {
        break label165;
      }
      ((bbva)parambbvg).a(bool);
    }
    for (;;)
    {
      if (parambbvg.a() != null)
      {
        if ((!(parambbmy instanceof bblt)) && (!(parambbmy instanceof bblg)) && (!(parambbmy instanceof bblo))) {
          break;
        }
        if (parambbvg.c() != null) {
          parambbvg.c().setVisibility(8);
        }
        parambbvg.a().setVisibility(0);
      }
      return;
      label165:
      if ((parambbvg instanceof bbwz)) {
        ((bbwz)parambbvg).a(bool);
      }
    }
    if (parambbvg.c() != null) {
      parambbvg.c().setVisibility(0);
    }
    parambbvg.a().setVisibility(8);
  }
  
  public void d(bbmy parambbmy, bbvg parambbvg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrb
 * JD-Core Version:    0.7.0.1
 */