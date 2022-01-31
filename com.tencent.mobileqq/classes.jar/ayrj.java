import android.view.View;
import android.widget.TextView;
import java.util.List;

public class ayrj
  implements ayqp<ayns, aywc>
{
  protected ayqo a;
  private bdbb a;
  
  public ayrj(bdbb parambdbb)
  {
    this.jdField_a_of_type_Bdbb = parambdbb;
    this.jdField_a_of_type_Ayqo = a(parambdbb);
  }
  
  public ayrj(bdbb parambdbb, int paramInt)
  {
    this.jdField_a_of_type_Bdbb = parambdbb;
    this.jdField_a_of_type_Ayqo = a(parambdbb, paramInt);
  }
  
  public ayrj(bdbb parambdbb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bdbb = parambdbb;
    this.jdField_a_of_type_Ayqo = a(parambdbb, paramBoolean);
  }
  
  public ayqo a()
  {
    return this.jdField_a_of_type_Ayqo;
  }
  
  protected ayqo<aynu, aywd> a(bdbb parambdbb)
  {
    return new ayrm(parambdbb);
  }
  
  protected ayqo<aynu, aywd> a(bdbb parambdbb, int paramInt)
  {
    return new aypv(parambdbb, paramInt);
  }
  
  protected ayqo<aynu, aywd> a(bdbb parambdbb, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(parambdbb);
    }
    return new ayqm(parambdbb);
  }
  
  public void a(ayns paramayns, aywc paramaywc)
  {
    int i = 0;
    Object localObject = (aynt)paramayns;
    a(paramaywc, (aynt)localObject);
    int n = ((aynt)localObject).a();
    paramayns = paramaywc.a();
    if ((paramayns != null) && (paramayns != null))
    {
      localObject = ((aynt)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < paramayns.size())
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
          ((aywd)paramayns.get(i)).a().setVisibility(0);
          ((aywd)paramayns.get(i)).a().setTag(2131379971, ((List)localObject).get(i));
          ((aywd)paramayns.get(i)).a().setTag(2131379976, paramayns.get(i));
          ((aywd)paramayns.get(i)).a().setTag(2131379972, Integer.valueOf(i));
          ((aywd)paramayns.get(i)).a().setTag(2131379970, Integer.valueOf(paramayns.size()));
          ((aywd)paramayns.get(i)).a().setTag(2131379973, this.jdField_a_of_type_Ayqo);
          this.jdField_a_of_type_Ayqo.a((ayns)((List)localObject).get(i), (aywe)paramayns.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
        while (i < paramayns.size())
        {
          ((aywd)paramayns.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramayns.size())
      {
        ((aywd)paramayns.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramaywc.b() != null) {
      paramaywc.b().setVisibility(8);
    }
  }
  
  protected void a(aywc paramaywc, aynt paramaynt)
  {
    if (paramaywc.a() != null) {
      paramaywc.a().setText(paramaynt.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrj
 * JD-Core Version:    0.7.0.1
 */