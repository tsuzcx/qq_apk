import android.view.View;
import android.widget.TextView;
import java.util.List;

public class bcjf
  implements bcil<bcfp, bcny>
{
  private aoof a;
  protected bcik a;
  
  public bcjf(aoof paramaoof)
  {
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_Bcik = a(paramaoof);
  }
  
  public bcjf(aoof paramaoof, int paramInt)
  {
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_Bcik = a(paramaoof, paramInt);
  }
  
  public bcjf(aoof paramaoof, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aoof = paramaoof;
    this.jdField_a_of_type_Bcik = a(paramaoof, paramBoolean);
  }
  
  public bcik a()
  {
    return this.jdField_a_of_type_Bcik;
  }
  
  protected bcik<bcfr, bcnz> a(aoof paramaoof)
  {
    return new bcji(paramaoof);
  }
  
  protected bcik<bcfr, bcnz> a(aoof paramaoof, int paramInt)
  {
    return new bchs(paramaoof, paramInt);
  }
  
  protected bcik<bcfr, bcnz> a(aoof paramaoof, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramaoof);
    }
    return new bcii(paramaoof);
  }
  
  public void a(bcfp parambcfp, bcny parambcny)
  {
    int i = 0;
    Object localObject = (bcfq)parambcfp;
    a(parambcny, (bcfq)localObject);
    int n = ((bcfq)localObject).a();
    parambcfp = parambcny.a();
    if ((parambcfp != null) && (parambcfp != null))
    {
      localObject = ((bcfq)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < parambcfp.size())
        {
          j = 1;
          if (i >= ((List)localObject).size()) {
            break label296;
          }
          k = 1;
          label82:
          if (i >= n) {
            break label302;
          }
        }
        label296:
        label302:
        for (int m = 1;; m = 0)
        {
          if ((m & k & j) == 0) {
            break label308;
          }
          ((bcnz)parambcfp.get(i)).a().setVisibility(0);
          ((bcnz)parambcfp.get(i)).a().setTag(2131381109, ((List)localObject).get(i));
          ((bcnz)parambcfp.get(i)).a().setTag(2131381115, parambcfp.get(i));
          ((bcnz)parambcfp.get(i)).a().setTag(2131381110, Integer.valueOf(i));
          ((bcnz)parambcfp.get(i)).a().setTag(2131381108, Integer.valueOf(parambcfp.size()));
          ((bcnz)parambcfp.get(i)).a().setTag(2131381111, this.jdField_a_of_type_Bcik);
          this.jdField_a_of_type_Bcik.a((bcfp)((List)localObject).get(i), (bcoa)parambcfp.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
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
  
  protected void a(bcny parambcny, bcfq parambcfq)
  {
    if (parambcny.a() != null) {
      parambcny.a().setText(parambcfq.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcjf
 * JD-Core Version:    0.7.0.1
 */