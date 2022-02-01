import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class bfbd
  extends amop
{
  static
  {
    if (!bfbb.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bfbd(bfbb parambfbb) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof becp))) {
      return;
    }
    Object localObject2 = (becp)???;
    synchronized (this.jdField_a_of_type_Bfbb)
    {
      if (((becp)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Bfbb.jdField_a_of_type_Long) {
        return;
      }
    }
    bebc localbebc1 = (bebc)this.jdField_a_of_type_Bfbb.b.get(((becp)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localbebc1 == null)) {
      throw new AssertionError();
    }
    if (localbebc1 == null) {
      return;
    }
    int i = localbebc1.e;
    if ((localbebc1.b == null) && (((becp)localObject2).e != null)) {
      this.jdField_a_of_type_Bfbb.c.put(((becp)localObject2).e, localbebc1);
    }
    localbebc1.a((becp)localObject2, this.jdField_a_of_type_Bfbb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((becp)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (bebc)this.jdField_a_of_type_Bfbb.c.get(localbebc1.f);
      if (localObject2 != null) {
        ((bebc)localObject2).a(localbebc1);
      }
      this.jdField_a_of_type_Bfbb.d(localbebc1);
      return;
    }
    if (localbebc1.jdField_a_of_type_Boolean) {
      if (((becp)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localbebc1.jdField_a_of_type_Boolean = bool;; localbebc1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localbebc1.f))
          {
            bebc localbebc2 = (bebc)this.jdField_a_of_type_Bfbb.c.get(localbebc1.f);
            if ((localbebc2 != null) && ((localbebc1.e == 9) || (localbebc1.e == 10) || (localbebc1.e == 11))) {
              localbebc2.a(localbebc1);
            }
          }
          if ((((becp)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localbebc1.a((int)NetConnInfoCenter.getServerTime());
            localbebc1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Bfbb.e(localbebc1);
          }
          this.jdField_a_of_type_Bfbb.d(localbebc1);
          return;
        } while ((((becp)localObject2).jdField_b_of_type_Int != 11) || (localbebc1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfbd
 * JD-Core Version:    0.7.0.1
 */