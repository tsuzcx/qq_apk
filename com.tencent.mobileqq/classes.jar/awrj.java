import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class awrj
  extends awsa
{
  private awqj jdField_a_of_type_Awqj;
  private awqs jdField_a_of_type_Awqs;
  private awrf jdField_a_of_type_Awrf;
  private awrl jdField_a_of_type_Awrl;
  
  public awrj(baxy parambaxy)
  {
    super(parambaxy);
    this.jdField_a_of_type_Awrf = new awrf(parambaxy);
    this.jdField_a_of_type_Awqs = new awqs(parambaxy);
    this.jdField_a_of_type_Awqj = new awqj(parambaxy, 268435456);
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    if ((!(paramawoi instanceof awoe)) && (!(paramawoi instanceof awng))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((paramawoi instanceof awoe))
      {
        localObject = (awoe)paramawoi;
        int i = awpt.a(((awoe)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Awrf.b(paramawoi, paramawwr);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Awqs.b(paramawoi, paramawwr);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((awoe)localObject).e());
        return;
      }
    } while (!(paramawoi instanceof awng));
    Object localObject = (awng)paramawoi;
    if (awpt.a(((awng)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Awqj.b(paramawoi, paramawwr);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((awng)localObject).e());
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    if (this.jdField_a_of_type_Awrl != null)
    {
      if (paramawwr.a() != null) {
        paramawwr.a().setOnClickListener(new awrk(this));
      }
      return;
    }
    super.c(paramawoi, paramawwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrj
 * JD-Core Version:    0.7.0.1
 */