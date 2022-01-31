import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class ayqv
  extends ayrm
{
  private aypv jdField_a_of_type_Aypv;
  private ayqe jdField_a_of_type_Ayqe;
  private ayqr jdField_a_of_type_Ayqr;
  private ayqx jdField_a_of_type_Ayqx;
  
  public ayqv(bdbb parambdbb)
  {
    super(parambdbb);
    this.jdField_a_of_type_Ayqr = new ayqr(parambdbb);
    this.jdField_a_of_type_Ayqe = new ayqe(parambdbb);
    this.jdField_a_of_type_Aypv = new aypv(parambdbb, 268435456);
  }
  
  public void b(aynu paramaynu, aywd paramaywd)
  {
    if ((!(paramaynu instanceof aynq)) && (!(paramaynu instanceof ayms))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((paramaynu instanceof aynq))
      {
        localObject = (aynq)paramaynu;
        int i = aypf.a(((aynq)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Ayqr.b(paramaynu, paramaywd);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Ayqe.b(paramaynu, paramaywd);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((aynq)localObject).e());
        return;
      }
    } while (!(paramaynu instanceof ayms));
    Object localObject = (ayms)paramaynu;
    if (aypf.a(((ayms)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Aypv.b(paramaynu, paramaywd);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((ayms)localObject).e());
  }
  
  protected void c(aynu paramaynu, aywd paramaywd)
  {
    if (this.jdField_a_of_type_Ayqx != null)
    {
      if (paramaywd.a() != null) {
        paramaywd.a().setOnClickListener(new ayqw(this));
      }
      return;
    }
    super.c(paramaynu, paramaywd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqv
 * JD-Core Version:    0.7.0.1
 */