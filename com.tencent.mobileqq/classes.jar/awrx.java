import android.view.View;
import android.widget.TextView;
import java.util.List;

public class awrx
  implements awrd<awog, awwq>
{
  protected awrc a;
  private baxy a;
  
  public awrx(baxy parambaxy)
  {
    this.jdField_a_of_type_Baxy = parambaxy;
    this.jdField_a_of_type_Awrc = a(parambaxy);
  }
  
  public awrx(baxy parambaxy, int paramInt)
  {
    this.jdField_a_of_type_Baxy = parambaxy;
    this.jdField_a_of_type_Awrc = a(parambaxy, paramInt);
  }
  
  public awrx(baxy parambaxy, boolean paramBoolean)
  {
    this.jdField_a_of_type_Baxy = parambaxy;
    this.jdField_a_of_type_Awrc = a(parambaxy, paramBoolean);
  }
  
  public awrc a()
  {
    return this.jdField_a_of_type_Awrc;
  }
  
  protected awrc<awoi, awwr> a(baxy parambaxy)
  {
    return new awsa(parambaxy);
  }
  
  protected awrc<awoi, awwr> a(baxy parambaxy, int paramInt)
  {
    return new awqj(parambaxy, paramInt);
  }
  
  protected awrc<awoi, awwr> a(baxy parambaxy, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(parambaxy);
    }
    return new awra(parambaxy);
  }
  
  public void a(awog paramawog, awwq paramawwq)
  {
    int i = 0;
    Object localObject = (awoh)paramawog;
    a(paramawwq, (awoh)localObject);
    int n = ((awoh)localObject).a();
    paramawog = paramawwq.a();
    if ((paramawog != null) && (paramawog != null))
    {
      localObject = ((awoh)localObject).a();
      if (localObject != null)
      {
        i = 0;
        int j;
        label68:
        int k;
        if (i < paramawog.size())
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
          ((awwr)paramawog.get(i)).a().setVisibility(0);
          ((awwr)paramawog.get(i)).a().setTag(2131379213, ((List)localObject).get(i));
          ((awwr)paramawog.get(i)).a().setTag(2131379218, paramawog.get(i));
          ((awwr)paramawog.get(i)).a().setTag(2131379214, Integer.valueOf(i));
          ((awwr)paramawog.get(i)).a().setTag(2131379212, Integer.valueOf(paramawog.size()));
          ((awwr)paramawog.get(i)).a().setTag(2131379215, this.jdField_a_of_type_Awrc);
          this.jdField_a_of_type_Awrc.a((awog)((List)localObject).get(i), (awws)paramawog.get(i));
          i += 1;
          break;
          j = 0;
          break label68;
          k = 0;
          break label82;
        }
        label308:
        i = Math.min(((List)localObject).size(), n);
        while (i < paramawog.size())
        {
          ((awwr)paramawog.get(i)).a().setVisibility(8);
          i += 1;
        }
      }
      while (i < paramawog.size())
      {
        ((awwr)paramawog.get(i)).a().setVisibility(8);
        i += 1;
      }
    }
    if (paramawwq.b() != null) {
      paramawwq.b().setVisibility(8);
    }
  }
  
  protected void a(awwq paramawwq, awoh paramawoh)
  {
    if (paramawwq.a() != null) {
      paramawwq.a().setText(paramawoh.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrx
 * JD-Core Version:    0.7.0.1
 */