import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class bgjp
  implements Comparator<akfc>
{
  private final TroopInfo a;
  
  bgjp(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(akfc paramakfc1, akfc paramakfc2)
  {
    int j = 5;
    int i;
    if (bgjl.b(paramakfc1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (bgjl.b(paramakfc2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (bgjl.a(paramakfc1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramakfc1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (bgjl.a(paramakfc2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramakfc2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(bgjl.c(paramakfc1), 1).compareToIgnoreCase(ChnToSpell.a(bgjl.c(paramakfc2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjp
 * JD-Core Version:    0.7.0.1
 */