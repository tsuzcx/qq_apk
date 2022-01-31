import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.util.Map;

class bajm
  extends ajta
{
  static
  {
    if (!bajk.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bajm(bajk parambajk) {}
  
  protected void a(Object arg1)
  {
    boolean bool = true;
    if ((??? == null) || (!(??? instanceof azqt))) {
      return;
    }
    Object localObject2 = (azqt)???;
    synchronized (this.jdField_a_of_type_Bajk)
    {
      if (((azqt)localObject2).jdField_b_of_type_Long != this.jdField_a_of_type_Bajk.jdField_a_of_type_Long) {
        return;
      }
    }
    azpg localazpg1 = (azpg)this.jdField_a_of_type_Bajk.b.get(((azqt)localObject2).a);
    if ((!jdField_a_of_type_Boolean) && (localazpg1 == null)) {
      throw new AssertionError();
    }
    if (localazpg1 == null) {
      return;
    }
    int i = localazpg1.e;
    if ((localazpg1.b == null) && (((azqt)localObject2).e != null)) {
      this.jdField_a_of_type_Bajk.c.put(((azqt)localObject2).e, localazpg1);
    }
    localazpg1.a((azqt)localObject2, this.jdField_a_of_type_Bajk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((azqt)localObject2).jdField_b_of_type_Int == 12)
    {
      localObject2 = (azpg)this.jdField_a_of_type_Bajk.c.get(localazpg1.f);
      if (localObject2 != null) {
        ((azpg)localObject2).a(localazpg1);
      }
      this.jdField_a_of_type_Bajk.d(localazpg1);
      return;
    }
    if (localazpg1.jdField_a_of_type_Boolean) {
      if (((azqt)localObject2).jdField_b_of_type_Int != 11) {
        break label399;
      }
    }
    for (;;)
    {
      for (localazpg1.jdField_a_of_type_Boolean = bool;; localazpg1.jdField_a_of_type_Boolean = true) {
        do
        {
          if (!"/".equals(localazpg1.f))
          {
            azpg localazpg2 = (azpg)this.jdField_a_of_type_Bajk.c.get(localazpg1.f);
            if ((localazpg2 != null) && ((localazpg1.e == 9) || (localazpg1.e == 10) || (localazpg1.e == 11))) {
              localazpg2.a(localazpg1);
            }
          }
          if ((((azqt)localObject2).jdField_b_of_type_Int == 6) && (i != 6))
          {
            localazpg1.a((int)NetConnInfoCenter.getServerTime());
            localazpg1.b((int)NetConnInfoCenter.getServerTime());
            this.jdField_a_of_type_Bajk.e(localazpg1);
          }
          this.jdField_a_of_type_Bajk.d(localazpg1);
          return;
        } while ((((azqt)localObject2).jdField_b_of_type_Int != 11) || (localazpg1.e == 11));
      }
      label399:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bajm
 * JD-Core Version:    0.7.0.1
 */