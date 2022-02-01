import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class bfro
  extends anif
{
  static
  {
    if (!bfrm.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bfro(bfrm parambfrm) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof bety))) {
      return;
    }
    Object localObject2 = (bety)???;
    synchronized (this.jdField_a_of_type_Bfrm)
    {
      if (((bety)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Bfrm.jdField_a_of_type_Long) {
        return;
      }
    }
    besl localbesl1 = (besl)this.jdField_a_of_type_Bfrm.b.get(((bety)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localbesl1 == null)) {
      throw new AssertionError();
    }
    if (localbesl1 == null) {
      return;
    }
    int i = localbesl1.e;
    if ((localbesl1.b == null) && (((bety)localObject2).e != null)) {
      this.jdField_a_of_type_Bfrm.c.put(((bety)localObject2).e, localbesl1);
    }
    localbesl1.a((bety)localObject2, this.jdField_a_of_type_Bfrm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((bety)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (besl)this.jdField_a_of_type_Bfrm.c.get(localbesl1.f);
      if (localObject2 != null) {
        ((besl)localObject2).a(localbesl1);
      }
      this.jdField_a_of_type_Bfrm.d(localbesl1);
      return;
    }
    if (localbesl1.jdField_a_of_type_Boolean) {
      if (((bety)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localbesl1.jdField_a_of_type_Boolean = bool;; localbesl1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localbesl1.f))
          {
            besl localbesl2 = (besl)this.jdField_a_of_type_Bfrm.c.get(localbesl1.f);
            if ((localbesl2 != null) && ((localbesl1.e == 9) || (localbesl1.e == 10) || (localbesl1.e == 11))) {
              localbesl2.a(localbesl1);
            }
          }
          if ((((bety)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localbesl1.a((int)NetConnInfoCenter.getServerTime());
            localbesl1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Bfrm.e(localbesl1);
          }
          this.jdField_a_of_type_Bfrm.d(localbesl1);
          return;
        } while ((((bety)localObject2).jdField_b_of_type_Int != 11) || (localbesl1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfro
 * JD-Core Version:    0.7.0.1
 */