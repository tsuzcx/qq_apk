import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class bgjj
  extends anrc
{
  static
  {
    if (!bgjh.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bgjj(bgjh parambgjh) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof bfjs))) {
      return;
    }
    Object localObject2 = (bfjs)???;
    synchronized (this.jdField_a_of_type_Bgjh)
    {
      if (((bfjs)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Bgjh.jdField_a_of_type_Long) {
        return;
      }
    }
    bfif localbfif1 = (bfif)this.jdField_a_of_type_Bgjh.b.get(((bfjs)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localbfif1 == null)) {
      throw new AssertionError();
    }
    if (localbfif1 == null) {
      return;
    }
    int i = localbfif1.e;
    if ((localbfif1.b == null) && (((bfjs)localObject2).e != null)) {
      this.jdField_a_of_type_Bgjh.c.put(((bfjs)localObject2).e, localbfif1);
    }
    localbfif1.a((bfjs)localObject2, this.jdField_a_of_type_Bgjh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((bfjs)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (bfif)this.jdField_a_of_type_Bgjh.c.get(localbfif1.g);
      if (localObject2 != null) {
        ((bfif)localObject2).a(localbfif1);
      }
      this.jdField_a_of_type_Bgjh.d(localbfif1);
      return;
    }
    if (localbfif1.jdField_a_of_type_Boolean) {
      if (((bfjs)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localbfif1.jdField_a_of_type_Boolean = bool;; localbfif1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localbfif1.g))
          {
            bfif localbfif2 = (bfif)this.jdField_a_of_type_Bgjh.c.get(localbfif1.g);
            if ((localbfif2 != null) && ((localbfif1.e == 9) || (localbfif1.e == 10) || (localbfif1.e == 11))) {
              localbfif2.a(localbfif1);
            }
          }
          if ((((bfjs)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localbfif1.a((int)NetConnInfoCenter.getServerTime());
            localbfif1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Bgjh.e(localbfif1);
          }
          this.jdField_a_of_type_Bgjh.d(localbfif1);
          return;
        } while ((((bfjs)localObject2).jdField_b_of_type_Int != 11) || (localbfif1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjj
 * JD-Core Version:    0.7.0.1
 */