import android.view.View;
import android.widget.TextView;
import java.util.List;

public class bciu
  extends bcjf
{
  public bciu(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  protected bcik<bcfr, bcnz> a(aoof paramaoof)
  {
    return new bciv(paramaoof);
  }
  
  public void a(bcfp parambcfp, bcny parambcny)
  {
    int i = 0;
    Object localObject = (bcfq)parambcfp;
    a(parambcny, (bcfq)localObject);
    int k = ((bcfq)localObject).a();
    parambcfp = parambcny.a();
    if ((parambcfp != null) && (parambcfp != null))
    {
      localObject = ((bcfq)localObject).a();
      if (localObject != null)
      {
        int m = Math.min(Math.min(parambcfp.size(), ((List)localObject).size()), k);
        i = 0;
        if (i < m)
        {
          ((bcnz)parambcfp.get(i)).a().setVisibility(0);
          ((bcnz)parambcfp.get(i)).a().setTag(2131381109, ((List)localObject).get(i));
          ((bcnz)parambcfp.get(i)).a().setTag(2131381115, parambcfp.get(i));
          ((bcnz)parambcfp.get(i)).a().setTag(2131381110, Integer.valueOf(i));
          ((bcnz)parambcfp.get(i)).a().setTag(2131381108, Integer.valueOf(parambcfp.size()));
          ((bcnz)parambcfp.get(i)).a().setTag(2131381111, this.a);
          bcnl.a((bcfr)((List)localObject).get(i), m, i);
          int n = ((bcfr)((List)localObject).get(i)).a();
          int i1 = ((bcfr)((List)localObject).get(i)).b();
          View localView = ((bcnz)parambcfp.get(i)).a();
          if ((((List)localObject).get(i) instanceof bcfs)) {}
          for (int j = ((bcfs)((List)localObject).get(i)).u;; j = 0)
          {
            bcnl.a(n, i1, localView, j);
            this.a.a((bcfp)((List)localObject).get(i), (bcoa)parambcfp.get(i));
            i += 1;
            break;
          }
        }
        i = Math.min(((List)localObject).size(), k);
        while (i < parambcfp.size())
        {
          ((bcnz)parambcfp.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < parambcfp.size())
      {
        ((bcnz)parambcfp.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (parambcny.b() != null) {
      parambcny.b().setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bciu
 * JD-Core Version:    0.7.0.1
 */