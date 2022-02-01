import android.view.View;
import android.widget.TextView;
import java.util.List;

public class bbqm
  implements bbps<bbmw, bbvf>
{
  private aobu a;
  protected bbpr a;
  
  public bbqm(aobu paramaobu)
  {
    this.jdField_a_of_type_Aobu = paramaobu;
    this.jdField_a_of_type_Bbpr = a(paramaobu);
  }
  
  public bbqm(aobu paramaobu, int paramInt)
  {
    this.jdField_a_of_type_Aobu = paramaobu;
    this.jdField_a_of_type_Bbpr = a(paramaobu, paramInt);
  }
  
  public bbqm(aobu paramaobu, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aobu = paramaobu;
    this.jdField_a_of_type_Bbpr = a(paramaobu, paramBoolean);
  }
  
  public bbpr a()
  {
    return this.jdField_a_of_type_Bbpr;
  }
  
  protected bbpr<bbmy, bbvg> a(aobu paramaobu)
  {
    return new bbqp(paramaobu);
  }
  
  protected bbpr<bbmy, bbvg> a(aobu paramaobu, int paramInt)
  {
    return new bboz(paramaobu, paramInt);
  }
  
  protected bbpr<bbmy, bbvg> a(aobu paramaobu, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramaobu);
    }
    return new bbpp(paramaobu);
  }
  
  public void a(bbmw parambbmw, bbvf parambbvf)
  {
    int i = 0;
    Object localObject = (bbmx)parambbmw;
    a(parambbvf, (bbmx)localObject);
    int n = ((bbmx)localObject).a();
    parambbmw = parambbvf.a();
    if ((parambbmw != null) && (parambbmw != null))
    {
      localObject = ((bbmx)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < parambbmw.size())
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
          ((bbvg)parambbmw.get(i)).a().setVisibility(0);
          ((bbvg)parambbmw.get(i)).a().setTag(2131380929, ((List)localObject).get(i));
          ((bbvg)parambbmw.get(i)).a().setTag(2131380935, parambbmw.get(i));
          ((bbvg)parambbmw.get(i)).a().setTag(2131380930, Integer.valueOf(i));
          ((bbvg)parambbmw.get(i)).a().setTag(2131380928, Integer.valueOf(parambbmw.size()));
          ((bbvg)parambbmw.get(i)).a().setTag(2131380931, this.jdField_a_of_type_Bbpr);
          this.jdField_a_of_type_Bbpr.a((bbmw)((List)localObject).get(i), (bbvh)parambbmw.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
        while (i < parambbmw.size())
        {
          ((bbvg)parambbmw.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < parambbmw.size())
      {
        ((bbvg)parambbmw.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (parambbvf.b() != null) {
      parambbvf.b().setVisibility(8);
    }
  }
  
  protected void a(bbvf parambbvf, bbmx parambbmx)
  {
    if (parambbvf.a() != null) {
      parambbvf.a().setText(parambbmx.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqm
 * JD-Core Version:    0.7.0.1
 */