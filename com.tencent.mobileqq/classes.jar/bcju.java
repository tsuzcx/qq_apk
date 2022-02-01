import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Set;

public class bcju
  extends bcia
{
  private Set<String> b;
  
  public bcju(aoof paramaoof, bcie parambcie, Set<String> paramSet1, Set<String> paramSet2)
  {
    super(paramaoof, parambcie, paramSet1);
    this.b = paramSet2;
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    super.b(parambcfr, parambcnz);
    if (parambcnz.c() != null)
    {
      localObject = parambcfr.b();
      if ((this.b != null) && (this.b.contains(localObject))) {
        parambcnz.c().setText(anzj.a(2131712604));
      }
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = bgpy.b((QQAppInterface)localObject, parambcfr.b());
    if ((localObject instanceof QQAppInterface))
    {
      if (!(parambcnz instanceof bcnt)) {
        break label165;
      }
      ((bcnt)parambcnz).a(bool);
    }
    for (;;)
    {
      if (parambcnz.a() != null)
      {
        if ((!(parambcfr instanceof bcem)) && (!(parambcfr instanceof bcdz)) && (!(parambcfr instanceof bceh))) {
          break;
        }
        if (parambcnz.c() != null) {
          parambcnz.c().setVisibility(8);
        }
        parambcnz.a().setVisibility(0);
      }
      return;
      label165:
      if ((parambcnz instanceof bcpq)) {
        ((bcpq)parambcnz).a(bool);
      }
    }
    if (parambcnz.c() != null) {
      parambcnz.c().setVisibility(0);
    }
    parambcnz.a().setVisibility(8);
  }
  
  public void d(bcfr parambcfr, bcnz parambcnz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcju
 * JD-Core Version:    0.7.0.1
 */