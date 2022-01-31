import android.view.View;
import android.widget.TextView;
import java.util.List;

public class awrv
  implements awrb<awoe, awwo>
{
  protected awra a;
  private baxk a;
  
  public awrv(baxk parambaxk)
  {
    this.jdField_a_of_type_Baxk = parambaxk;
    this.jdField_a_of_type_Awra = a(parambaxk);
  }
  
  public awrv(baxk parambaxk, int paramInt)
  {
    this.jdField_a_of_type_Baxk = parambaxk;
    this.jdField_a_of_type_Awra = a(parambaxk, paramInt);
  }
  
  public awrv(baxk parambaxk, boolean paramBoolean)
  {
    this.jdField_a_of_type_Baxk = parambaxk;
    this.jdField_a_of_type_Awra = a(parambaxk, paramBoolean);
  }
  
  public awra a()
  {
    return this.jdField_a_of_type_Awra;
  }
  
  protected awra<awog, awwp> a(baxk parambaxk)
  {
    return new awry(parambaxk);
  }
  
  protected awra<awog, awwp> a(baxk parambaxk, int paramInt)
  {
    return new awqh(parambaxk, paramInt);
  }
  
  protected awra<awog, awwp> a(baxk parambaxk, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(parambaxk);
    }
    return new awqy(parambaxk);
  }
  
  public void a(awoe paramawoe, awwo paramawwo)
  {
    int i = 0;
    Object localObject = (awof)paramawoe;
    a(paramawwo, (awof)localObject);
    int n = ((awof)localObject).a();
    paramawoe = paramawwo.a();
    if ((paramawoe != null) && (paramawoe != null))
    {
      localObject = ((awof)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < paramawoe.size())
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
          ((awwp)paramawoe.get(i)).a().setVisibility(0);
          ((awwp)paramawoe.get(i)).a().setTag(2131379208, ((List)localObject).get(i));
          ((awwp)paramawoe.get(i)).a().setTag(2131379213, paramawoe.get(i));
          ((awwp)paramawoe.get(i)).a().setTag(2131379209, Integer.valueOf(i));
          ((awwp)paramawoe.get(i)).a().setTag(2131379207, Integer.valueOf(paramawoe.size()));
          ((awwp)paramawoe.get(i)).a().setTag(2131379210, this.jdField_a_of_type_Awra);
          this.jdField_a_of_type_Awra.a((awoe)((List)localObject).get(i), (awwq)paramawoe.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
        while (i < paramawoe.size())
        {
          ((awwp)paramawoe.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramawoe.size())
      {
        ((awwp)paramawoe.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramawwo.b() != null) {
      paramawwo.b().setVisibility(8);
    }
  }
  
  protected void a(awwo paramawwo, awof paramawof)
  {
    if (paramawwo.a() != null) {
      paramawwo.a().setText(paramawof.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrv
 * JD-Core Version:    0.7.0.1
 */