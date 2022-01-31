import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class bcmw
  extends alpa
{
  static
  {
    if (!bcmu.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bcmw(bcmu parambcmu) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof bbtn))) {
      return;
    }
    Object localObject2 = (bbtn)???;
    synchronized (this.jdField_a_of_type_Bcmu)
    {
      if (((bbtn)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Bcmu.jdField_a_of_type_Long) {
        return;
      }
    }
    bbsa localbbsa1 = (bbsa)this.jdField_a_of_type_Bcmu.b.get(((bbtn)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localbbsa1 == null)) {
      throw new AssertionError();
    }
    if (localbbsa1 == null) {
      return;
    }
    int i = localbbsa1.e;
    if ((localbbsa1.b == null) && (((bbtn)localObject2).e != null)) {
      this.jdField_a_of_type_Bcmu.c.put(((bbtn)localObject2).e, localbbsa1);
    }
    localbbsa1.a((bbtn)localObject2, this.jdField_a_of_type_Bcmu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((bbtn)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (bbsa)this.jdField_a_of_type_Bcmu.c.get(localbbsa1.f);
      if (localObject2 != null) {
        ((bbsa)localObject2).a(localbbsa1);
      }
      this.jdField_a_of_type_Bcmu.d(localbbsa1);
      return;
    }
    if (localbbsa1.jdField_a_of_type_Boolean) {
      if (((bbtn)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localbbsa1.jdField_a_of_type_Boolean = bool;; localbbsa1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localbbsa1.f))
          {
            bbsa localbbsa2 = (bbsa)this.jdField_a_of_type_Bcmu.c.get(localbbsa1.f);
            if ((localbbsa2 != null) && ((localbbsa1.e == 9) || (localbbsa1.e == 10) || (localbbsa1.e == 11))) {
              localbbsa2.a(localbbsa1);
            }
          }
          if ((((bbtn)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localbbsa1.a((int)NetConnInfoCenter.getServerTime());
            localbbsa1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Bcmu.e(localbbsa1);
          }
          this.jdField_a_of_type_Bcmu.d(localbbsa1);
          return;
        } while ((((bbtn)localObject2).jdField_b_of_type_Int != 11) || (localbbsa1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmw
 * JD-Core Version:    0.7.0.1
 */