import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import java.util.Set;

public class bcjo
  extends bchu
{
  private Set<String> b;
  
  public bcjo(FaceDecoder paramFaceDecoder, bchy parambchy, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(paramFaceDecoder, parambchy, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    super.b(parambcfj, parambcnt);
    if (parambcnt.c() != null)
    {
      localObject = parambcfj.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        parambcnt.c().setText(anvx.a(2131713183));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = bghs.b((QQAppInterface)localObject, parambcfj.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(parambcnt instanceof bcnn)) {
        break label165;
      }
      ((bcnn)parambcnt).a(bool);
    }
    for (;;)
    {
      if (parambcnt.a() != null)
      {
        if ((!(parambcfj instanceof bcee)) && (!(parambcfj instanceof bcdr)) && (!(parambcfj instanceof bcdz))) {
          break;
        }
        if (parambcnt.c() != null) {
          parambcnt.c().setVisibility(8);
        }
        parambcnt.a().setVisibility(0);
      }
      return;
      label165:
      if ((parambcnt instanceof bcpk)) {
        ((bcpk)parambcnt).a(bool);
      }
    }
    if (parambcnt.c() != null) {
      parambcnt.c().setVisibility(0);
    }
    parambcnt.a().setVisibility(8);
  }
  
  public void d(bcfj parambcfj, bcnt parambcnt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjo
 * JD-Core Version:    0.7.0.1
 */