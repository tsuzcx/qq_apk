import android.view.View;
import android.widget.TextView;
import java.util.List;

public class avsc
  implements avri<avol, avwv>
{
  protected avrh a;
  private azwg a;
  
  public avsc(azwg paramazwg)
  {
    this.jdField_a_of_type_Azwg = paramazwg;
    this.jdField_a_of_type_Avrh = a(paramazwg);
  }
  
  public avsc(azwg paramazwg, int paramInt)
  {
    this.jdField_a_of_type_Azwg = paramazwg;
    this.jdField_a_of_type_Avrh = a(paramazwg, paramInt);
  }
  
  public avsc(azwg paramazwg, boolean paramBoolean)
  {
    this.jdField_a_of_type_Azwg = paramazwg;
    this.jdField_a_of_type_Avrh = a(paramazwg, paramBoolean);
  }
  
  public avrh a()
  {
    return this.jdField_a_of_type_Avrh;
  }
  
  protected avrh<avon, avww> a(azwg paramazwg)
  {
    return new avsf(paramazwg);
  }
  
  protected avrh<avon, avww> a(azwg paramazwg, int paramInt)
  {
    return new avqo(paramazwg, paramInt);
  }
  
  protected avrh<avon, avww> a(azwg paramazwg, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramazwg);
    }
    return new avrf(paramazwg);
  }
  
  public void a(avol paramavol, avwv paramavwv)
  {
    int i = 0;
    Object localObject = (avom)paramavol;
    a(paramavwv, (avom)localObject);
    int n = ((avom)localObject).a();
    paramavol = paramavwv.a();
    if ((paramavol != null) && (paramavol != null))
    {
      localObject = ((avom)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < paramavol.size())
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
          ((avww)paramavol.get(i)).a().setVisibility(0);
          ((avww)paramavol.get(i)).a().setTag(2131313373, ((List)localObject).get(i));
          ((avww)paramavol.get(i)).a().setTag(2131313378, paramavol.get(i));
          ((avww)paramavol.get(i)).a().setTag(2131313374, Integer.valueOf(i));
          ((avww)paramavol.get(i)).a().setTag(2131313372, Integer.valueOf(paramavol.size()));
          ((avww)paramavol.get(i)).a().setTag(2131313375, this.jdField_a_of_type_Avrh);
          this.jdField_a_of_type_Avrh.a((avol)((List)localObject).get(i), (avwx)paramavol.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
        while (i < paramavol.size())
        {
          ((avww)paramavol.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramavol.size())
      {
        ((avww)paramavol.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramavwv.b() != null) {
      paramavwv.b().setVisibility(8);
    }
  }
  
  protected void a(avwv paramavwv, avom paramavom)
  {
    if (paramavwv.a() != null) {
      paramavwv.a().setText(paramavom.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsc
 * JD-Core Version:    0.7.0.1
 */