import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class awsm
  extends awqs
{
  private Set<String> b;
  
  public awsm(baxy parambaxy, awqw paramawqw, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(parambaxy, paramawqw, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    super.b(paramawoi, paramawwr);
    if (paramawwr.c() != null)
    {
      localObject = paramawoi.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        paramawwr.c().setText(ajya.a(2131713739));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = bail.b((QQAppInterface)localObject, paramawoi.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(paramawwr instanceof awwl)) {
        break label165;
      }
      ((awwl)paramawwr).a(bool);
    }
    for (;;)
    {
      if (paramawwr.a() != null)
      {
        if ((!(paramawoi instanceof awnd)) && (!(paramawoi instanceof awmq)) && (!(paramawoi instanceof awmy))) {
          break;
        }
        if (paramawwr.c() != null) {
          paramawwr.c().setVisibility(8);
        }
        paramawwr.a().setVisibility(0);
      }
      return;
      label165:
      if ((paramawwr instanceof awyk)) {
        ((awyk)paramawwr).a(bool);
      }
    }
    if (paramawwr.c() != null) {
      paramawwr.c().setVisibility(0);
    }
    paramawwr.a().setVisibility(8);
  }
  
  public void d(awoi paramawoi, awwr paramawwr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsm
 * JD-Core Version:    0.7.0.1
 */