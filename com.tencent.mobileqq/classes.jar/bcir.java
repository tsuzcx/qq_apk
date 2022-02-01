import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class bcir
  extends bcji
{
  private bchs jdField_a_of_type_Bchs;
  private bcia jdField_a_of_type_Bcia;
  private bcin jdField_a_of_type_Bcin;
  private bcit jdField_a_of_type_Bcit;
  
  public bcir(aoof paramaoof)
  {
    super(paramaoof);
    this.jdField_a_of_type_Bcin = new bcin(paramaoof);
    this.jdField_a_of_type_Bcia = new bcia(paramaoof);
    this.jdField_a_of_type_Bchs = new bchs(paramaoof, 268435456);
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    if ((!(parambcfr instanceof bcfn)) && (!(parambcfr instanceof bcep))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((parambcfr instanceof bcfn))
      {
        localObject = (bcfn)parambcfr;
        int i = bchc.a(((bcfn)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Bcin.b(parambcfr, parambcnz);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Bcia.b(parambcfr, parambcnz);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((bcfn)localObject).e());
        return;
      }
    } while (!(parambcfr instanceof bcep));
    Object localObject = (bcep)parambcfr;
    if (bchc.a(((bcep)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Bchs.b(parambcfr, parambcnz);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((bcep)localObject).e());
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    if (this.jdField_a_of_type_Bcit != null)
    {
      if (parambcnz.a() != null) {
        parambcnz.a().setOnClickListener(new bcis(this));
      }
      return;
    }
    super.c(parambcfr, parambcnz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcir
 * JD-Core Version:    0.7.0.1
 */