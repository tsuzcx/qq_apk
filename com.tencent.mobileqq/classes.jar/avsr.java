import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class avsr
  extends avqx
{
  private Set<String> b;
  
  public avsr(azwg paramazwg, avrb paramavrb, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(paramazwg, paramavrb, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    super.b(paramavon, paramavww);
    if (paramavww.c() != null)
    {
      localObject = paramavon.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        paramavww.c().setText(ajjy.a(2131647941));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = azgu.b((QQAppInterface)localObject, paramavon.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(paramavww instanceof avwq)) {
        break label165;
      }
      ((avwq)paramavww).a(bool);
    }
    for (;;)
    {
      if (paramavww.a() != null)
      {
        if ((!(paramavon instanceof avni)) && (!(paramavon instanceof avmv)) && (!(paramavon instanceof avnd))) {
          break;
        }
        if (paramavww.c() != null) {
          paramavww.c().setVisibility(8);
        }
        paramavww.a().setVisibility(0);
      }
      return;
      label165:
      if ((paramavww instanceof avyp)) {
        ((avyp)paramavww).a(bool);
      }
    }
    if (paramavww.c() != null) {
      paramavww.c().setVisibility(0);
    }
    paramavww.a().setVisibility(8);
  }
  
  public void d(avon paramavon, avww paramavww) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsr
 * JD-Core Version:    0.7.0.1
 */