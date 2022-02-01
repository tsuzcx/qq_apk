import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class bgrp
  extends anua
{
  static
  {
    if (!bgrn.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bgrp(bgrn parambgrn) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof bftf))) {
      return;
    }
    Object localObject2 = (bftf)???;
    synchronized (this.jdField_a_of_type_Bgrn)
    {
      if (((bftf)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Bgrn.jdField_a_of_type_Long) {
        return;
      }
    }
    bfrs localbfrs1 = (bfrs)this.jdField_a_of_type_Bgrn.b.get(((bftf)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localbfrs1 == null)) {
      throw new AssertionError();
    }
    if (localbfrs1 == null) {
      return;
    }
    int i = localbfrs1.e;
    if ((localbfrs1.b == null) && (((bftf)localObject2).e != null)) {
      this.jdField_a_of_type_Bgrn.c.put(((bftf)localObject2).e, localbfrs1);
    }
    localbfrs1.a((bftf)localObject2, this.jdField_a_of_type_Bgrn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((bftf)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (bfrs)this.jdField_a_of_type_Bgrn.c.get(localbfrs1.f);
      if (localObject2 != null) {
        ((bfrs)localObject2).a(localbfrs1);
      }
      this.jdField_a_of_type_Bgrn.d(localbfrs1);
      return;
    }
    if (localbfrs1.jdField_a_of_type_Boolean) {
      if (((bftf)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localbfrs1.jdField_a_of_type_Boolean = bool;; localbfrs1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localbfrs1.f))
          {
            bfrs localbfrs2 = (bfrs)this.jdField_a_of_type_Bgrn.c.get(localbfrs1.f);
            if ((localbfrs2 != null) && ((localbfrs1.e == 9) || (localbfrs1.e == 10) || (localbfrs1.e == 11))) {
              localbfrs2.a(localbfrs1);
            }
          }
          if ((((bftf)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localbfrs1.a((int)NetConnInfoCenter.getServerTime());
            localbfrs1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Bgrn.e(localbfrs1);
          }
          this.jdField_a_of_type_Bgrn.d(localbfrs1);
          return;
        } while ((((bftf)localObject2).jdField_b_of_type_Int != 11) || (localbfrs1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrp
 * JD-Core Version:    0.7.0.1
 */