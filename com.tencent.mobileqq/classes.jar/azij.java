import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class azij
  extends ajey
{
  static
  {
    if (!azih.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  azij(azih paramazih) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof ayqd))) {
      return;
    }
    Object localObject2 = (ayqd)???;
    synchronized (this.jdField_a_of_type_Azih)
    {
      if (((ayqd)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Azih.jdField_a_of_type_Long) {
        return;
      }
    }
    ayoq localayoq1 = (ayoq)this.jdField_a_of_type_Azih.b.get(((ayqd)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localayoq1 == null)) {
      throw new AssertionError();
    }
    if (localayoq1 == null) {
      return;
    }
    int i = localayoq1.e;
    if ((localayoq1.b == null) && (((ayqd)localObject2).e != null)) {
      this.jdField_a_of_type_Azih.c.put(((ayqd)localObject2).e, localayoq1);
    }
    localayoq1.a((ayqd)localObject2, this.jdField_a_of_type_Azih.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((ayqd)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (ayoq)this.jdField_a_of_type_Azih.c.get(localayoq1.f);
      if (localObject2 != null) {
        ((ayoq)localObject2).a(localayoq1);
      }
      this.jdField_a_of_type_Azih.d(localayoq1);
      return;
    }
    if (localayoq1.jdField_a_of_type_Boolean) {
      if (((ayqd)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localayoq1.jdField_a_of_type_Boolean = bool;; localayoq1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localayoq1.f))
          {
            ayoq localayoq2 = (ayoq)this.jdField_a_of_type_Azih.c.get(localayoq1.f);
            if ((localayoq2 != null) && ((localayoq1.e == 9) || (localayoq1.e == 10) || (localayoq1.e == 11))) {
              localayoq2.a(localayoq1);
            }
          }
          if ((((ayqd)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localayoq1.a((int)NetConnInfoCenter.getServerTime());
            localayoq1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Azih.e(localayoq1);
          }
          this.jdField_a_of_type_Azih.d(localayoq1);
          return;
        } while ((((ayqd)localObject2).jdField_b_of_type_Int != 11) || (localayoq1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azij
 * JD-Core Version:    0.7.0.1
 */