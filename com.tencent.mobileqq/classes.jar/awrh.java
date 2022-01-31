import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class awrh
  extends awry
{
  private awqh jdField_a_of_type_Awqh;
  private awqq jdField_a_of_type_Awqq;
  private awrd jdField_a_of_type_Awrd;
  private awrj jdField_a_of_type_Awrj;
  
  public awrh(baxk parambaxk)
  {
    super(parambaxk);
    this.jdField_a_of_type_Awrd = new awrd(parambaxk);
    this.jdField_a_of_type_Awqq = new awqq(parambaxk);
    this.jdField_a_of_type_Awqh = new awqh(parambaxk, 268435456);
  }
  
  public void b(awog paramawog, awwp paramawwp)
  {
    if ((!(paramawog instanceof awoc)) && (!(paramawog instanceof awne))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((paramawog instanceof awoc))
      {
        localObject = (awoc)paramawog;
        int i = awpr.a(((awoc)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Awrd.b(paramawog, paramawwp);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Awqq.b(paramawog, paramawwp);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((awoc)localObject).e());
        return;
      }
    } while (!(paramawog instanceof awne));
    Object localObject = (awne)paramawog;
    if (awpr.a(((awne)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Awqh.b(paramawog, paramawwp);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((awne)localObject).e());
  }
  
  protected void c(awog paramawog, awwp paramawwp)
  {
    if (this.jdField_a_of_type_Awrj != null)
    {
      if (paramawwp.a() != null) {
        paramawwp.a().setOnClickListener(new awri(this));
      }
      return;
    }
    super.c(paramawog, paramawwp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrh
 * JD-Core Version:    0.7.0.1
 */