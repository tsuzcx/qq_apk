import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.Set;

public class bbcw
  extends bbbc
{
  private Set<String> b;
  
  public bbcw(FaceDecoder paramFaceDecoder, bbbg parambbbg, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(paramFaceDecoder, parambbbg, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    super.b(parambayt, parambbhb);
    if (parambbhb.c() != null)
    {
      localObject = parambayt.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        parambbhb.c().setText(amtj.a(2131712836));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = bezm.b((QQAppInterface)localObject, parambayt.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(parambbhb instanceof bbgv)) {
        break label165;
      }
      ((bbgv)parambbhb).a(bool);
    }
    for (;;)
    {
      if (parambbhb.a() != null)
      {
        if ((!(parambayt instanceof baxo)) && (!(parambayt instanceof baxb)) && (!(parambayt instanceof baxj))) {
          break;
        }
        if (parambbhb.c() != null) {
          parambbhb.c().setVisibility(8);
        }
        parambbhb.a().setVisibility(0);
      }
      return;
      label165:
      if ((parambbhb instanceof bbis)) {
        ((bbis)parambbhb).a(bool);
      }
    }
    if (parambbhb.c() != null) {
      parambbhb.c().setVisibility(0);
    }
    parambbhb.a().setVisibility(8);
  }
  
  public void d(bayt parambayt, bbhb parambbhb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcw
 * JD-Core Version:    0.7.0.1
 */