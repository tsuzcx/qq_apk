import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class aymm
  extends aynd
{
  private aylm jdField_a_of_type_Aylm;
  private aylv jdField_a_of_type_Aylv;
  private aymi jdField_a_of_type_Aymi;
  private aymo jdField_a_of_type_Aymo;
  
  public aymm(bcws parambcws)
  {
    super(parambcws);
    this.jdField_a_of_type_Aymi = new aymi(parambcws);
    this.jdField_a_of_type_Aylv = new aylv(parambcws);
    this.jdField_a_of_type_Aylm = new aylm(parambcws, 268435456);
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    if ((!(paramayjl instanceof ayjh)) && (!(paramayjl instanceof ayij))) {
      QLog.e("MostUsedResultPresenter", 2, "unresolved model");
    }
    do
    {
      return;
      if ((paramayjl instanceof ayjh))
      {
        localObject = (ayjh)paramayjl;
        int i = aykw.a(((ayjh)localObject).e());
        if (i == 2)
        {
          this.jdField_a_of_type_Aymi.b(paramayjl, paramayru);
          return;
        }
        if (i == 1)
        {
          this.jdField_a_of_type_Aylv.b(paramayjl, paramayru);
          return;
        }
        QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((ayjh)localObject).e());
        return;
      }
    } while (!(paramayjl instanceof ayij));
    Object localObject = (ayij)paramayjl;
    if (aykw.a(((ayij)localObject).e()) == 3)
    {
      this.jdField_a_of_type_Aylm.b(paramayjl, paramayru);
      return;
    }
    QLog.e("MostUsedResultPresenter", 2, "unresolved id type" + ((ayij)localObject).e());
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    if (this.jdField_a_of_type_Aymo != null)
    {
      if (paramayru.a() != null) {
        paramayru.a().setOnClickListener(new aymn(this));
      }
      return;
    }
    super.c(paramayjl, paramayru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymm
 * JD-Core Version:    0.7.0.1
 */