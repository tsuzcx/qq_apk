import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class bbpy
  extends bbqp
{
  private bboz jdField_a_of_type_Bboz;
  private bbph jdField_a_of_type_Bbph;
  private bbpu jdField_a_of_type_Bbpu;
  private bbqa jdField_a_of_type_Bbqa;
  
  public bbpy(aobu paramaobu)
  {
    super(paramaobu);
    this.jdField_a_of_type_Bbpu = new bbpu(paramaobu);
    this.jdField_a_of_type_Bbph = new bbph(paramaobu);
    this.jdField_a_of_type_Bboz = new bboz(paramaobu, 268435456);
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    if ((!(parambbmy instanceof bbmu)) && (!(parambbmy instanceof bblw))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((parambbmy instanceof bbmu))
      {
        localObject = (bbmu)parambbmy;
        int i = bboj.a(((bbmu)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Bbpu.b(parambbmy, parambbvg);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Bbph.b(parambbmy, parambbvg);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((bbmu)localObject).e());
        return;
      }
    } while (!(parambbmy instanceof bblw));
    Object localObject = (bblw)parambbmy;
    if (bboj.a(((bblw)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Bboz.b(parambbmy, parambbvg);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((bblw)localObject).e());
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    if (this.jdField_a_of_type_Bbqa != null)
    {
      if (parambbvg.a() != null) {
        parambbvg.a().setOnClickListener(new bbpz(this));
      }
      return;
    }
    super.c(parambbmy, parambbvg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbpy
 * JD-Core Version:    0.7.0.1
 */