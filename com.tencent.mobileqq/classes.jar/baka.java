import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class baka
  extends ajsy
{
  static
  {
    if (!bajy.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  baka(bajy parambajy) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof azqv))) {
      return;
    }
    Object localObject2 = (azqv)???;
    synchronized (this.jdField_a_of_type_Bajy)
    {
      if (((azqv)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Bajy.jdField_a_of_type_Long) {
        return;
      }
    }
    azpi localazpi1 = (azpi)this.jdField_a_of_type_Bajy.b.get(((azqv)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localazpi1 == null)) {
      throw new AssertionError();
    }
    if (localazpi1 == null) {
      return;
    }
    int i = localazpi1.e;
    if ((localazpi1.b == null) && (((azqv)localObject2).e != null)) {
      this.jdField_a_of_type_Bajy.c.put(((azqv)localObject2).e, localazpi1);
    }
    localazpi1.a((azqv)localObject2, this.jdField_a_of_type_Bajy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((azqv)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (azpi)this.jdField_a_of_type_Bajy.c.get(localazpi1.f);
      if (localObject2 != null) {
        ((azpi)localObject2).a(localazpi1);
      }
      this.jdField_a_of_type_Bajy.d(localazpi1);
      return;
    }
    if (localazpi1.jdField_a_of_type_Boolean) {
      if (((azqv)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localazpi1.jdField_a_of_type_Boolean = bool;; localazpi1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localazpi1.f))
          {
            azpi localazpi2 = (azpi)this.jdField_a_of_type_Bajy.c.get(localazpi1.f);
            if ((localazpi2 != null) && ((localazpi1.e == 9) || (localazpi1.e == 10) || (localazpi1.e == 11))) {
              localazpi2.a(localazpi1);
            }
          }
          if ((((azqv)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localazpi1.a((int)NetConnInfoCenter.getServerTime());
            localazpi1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Bajy.e(localazpi1);
          }
          this.jdField_a_of_type_Bajy.d(localazpi1);
          return;
        } while ((((azqv)localObject2).jdField_b_of_type_Int != 11) || (localazpi1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baka
 * JD-Core Version:    0.7.0.1
 */