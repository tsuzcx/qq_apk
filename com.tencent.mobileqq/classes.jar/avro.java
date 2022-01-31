import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class avro
  extends avsf
{
  private avqo jdField_a_of_type_Avqo;
  private avqx jdField_a_of_type_Avqx;
  private avrk jdField_a_of_type_Avrk;
  private avrq jdField_a_of_type_Avrq;
  
  public avro(azwg paramazwg)
  {
    super(paramazwg);
    this.jdField_a_of_type_Avrk = new avrk(paramazwg);
    this.jdField_a_of_type_Avqx = new avqx(paramazwg);
    this.jdField_a_of_type_Avqo = new avqo(paramazwg, 268435456);
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    if ((!(paramavon instanceof avoj)) && (!(paramavon instanceof avnl))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((paramavon instanceof avoj))
      {
        localObject = (avoj)paramavon;
        int i = avpy.a(((avoj)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Avrk.b(paramavon, paramavww);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Avqx.b(paramavon, paramavww);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((avoj)localObject).e());
        return;
      }
    } while (!(paramavon instanceof avnl));
    Object localObject = (avnl)paramavon;
    if (avpy.a(((avnl)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Avqo.b(paramavon, paramavww);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((avnl)localObject).e());
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    if (this.jdField_a_of_type_Avrq != null)
    {
      if (paramavww.a() != null) {
        paramavww.a().setOnClickListener(new avrp(this));
      }
      return;
    }
    super.c(paramavon, paramavww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avro
 * JD-Core Version:    0.7.0.1
 */