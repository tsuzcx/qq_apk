import android.view.View;
import android.widget.TextView;
import java.util.List;

public class ayna
  implements aymg<ayjj, ayrt>
{
  protected aymf a;
  private bcws a;
  
  public ayna(bcws parambcws)
  {
    this.jdField_a_of_type_Bcws = parambcws;
    this.jdField_a_of_type_Aymf = a(parambcws);
  }
  
  public ayna(bcws parambcws, int paramInt)
  {
    this.jdField_a_of_type_Bcws = parambcws;
    this.jdField_a_of_type_Aymf = a(parambcws, paramInt);
  }
  
  public ayna(bcws parambcws, boolean paramBoolean)
  {
    this.jdField_a_of_type_Bcws = parambcws;
    this.jdField_a_of_type_Aymf = a(parambcws, paramBoolean);
  }
  
  public aymf a()
  {
    return this.jdField_a_of_type_Aymf;
  }
  
  protected aymf<ayjl, ayru> a(bcws parambcws)
  {
    return new aynd(parambcws);
  }
  
  protected aymf<ayjl, ayru> a(bcws parambcws, int paramInt)
  {
    return new aylm(parambcws, paramInt);
  }
  
  protected aymf<ayjl, ayru> a(bcws parambcws, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(parambcws);
    }
    return new aymd(parambcws);
  }
  
  public void a(ayjj paramayjj, ayrt paramayrt)
  {
    int i = 0;
    Object localObject = (ayjk)paramayjj;
    a(paramayrt, (ayjk)localObject);
    int n = ((ayjk)localObject).a();
    paramayjj = paramayrt.a();
    if ((paramayjj != null) && (paramayjj != null))
    {
      localObject = ((ayjk)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < paramayjj.size())
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
          ((ayru)paramayjj.get(i)).a().setVisibility(0);
          ((ayru)paramayjj.get(i)).a().setTag(2131379913, ((List)localObject).get(i));
          ((ayru)paramayjj.get(i)).a().setTag(2131379918, paramayjj.get(i));
          ((ayru)paramayjj.get(i)).a().setTag(2131379914, Integer.valueOf(i));
          ((ayru)paramayjj.get(i)).a().setTag(2131379912, Integer.valueOf(paramayjj.size()));
          ((ayru)paramayjj.get(i)).a().setTag(2131379915, this.jdField_a_of_type_Aymf);
          this.jdField_a_of_type_Aymf.a((ayjj)((List)localObject).get(i), (ayrv)paramayjj.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
        while (i < paramayjj.size())
        {
          ((ayru)paramayjj.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramayjj.size())
      {
        ((ayru)paramayjj.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramayrt.b() != null) {
      paramayrt.b().setVisibility(8);
    }
  }
  
  protected void a(ayrt paramayrt, ayjk paramayjk)
  {
    if (paramayrt.a() != null) {
      paramayrt.a().setText(paramayjk.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayna
 * JD-Core Version:    0.7.0.1
 */