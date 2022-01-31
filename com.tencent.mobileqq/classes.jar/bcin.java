import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class bcin
  extends alkl
{
  static
  {
    if (!bcil.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bcin(bcil parambcil) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof bbpe))) {
      return;
    }
    Object localObject2 = (bbpe)???;
    synchronized (this.jdField_a_of_type_Bcil)
    {
      if (((bbpe)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Bcil.jdField_a_of_type_Long) {
        return;
      }
    }
    bbnr localbbnr1 = (bbnr)this.jdField_a_of_type_Bcil.b.get(((bbpe)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localbbnr1 == null)) {
      throw new AssertionError();
    }
    if (localbbnr1 == null) {
      return;
    }
    int i = localbbnr1.e;
    if ((localbbnr1.b == null) && (((bbpe)localObject2).e != null)) {
      this.jdField_a_of_type_Bcil.c.put(((bbpe)localObject2).e, localbbnr1);
    }
    localbbnr1.a((bbpe)localObject2, this.jdField_a_of_type_Bcil.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((bbpe)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (bbnr)this.jdField_a_of_type_Bcil.c.get(localbbnr1.f);
      if (localObject2 != null) {
        ((bbnr)localObject2).a(localbbnr1);
      }
      this.jdField_a_of_type_Bcil.d(localbbnr1);
      return;
    }
    if (localbbnr1.jdField_a_of_type_Boolean) {
      if (((bbpe)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localbbnr1.jdField_a_of_type_Boolean = bool;; localbbnr1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localbbnr1.f))
          {
            bbnr localbbnr2 = (bbnr)this.jdField_a_of_type_Bcil.c.get(localbbnr1.f);
            if ((localbbnr2 != null) && ((localbbnr1.e == 9) || (localbbnr1.e == 10) || (localbbnr1.e == 11))) {
              localbbnr2.a(localbbnr1);
            }
          }
          if ((((bbpe)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localbbnr1.a((int)NetConnInfoCenter.getServerTime());
            localbbnr1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Bcil.e(localbbnr1);
          }
          this.jdField_a_of_type_Bcil.d(localbbnr1);
          return;
        } while ((((bbpe)localObject2).jdField_b_of_type_Int != 11) || (localbbnr1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcin
 * JD-Core Version:    0.7.0.1
 */