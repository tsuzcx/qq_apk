import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class azdn
  implements Comparator<afou>
{
  private final TroopInfo a;
  
  azdn(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(afou paramafou1, afou paramafou2)
  {
    int j = 5;
    int i;
    if (azdj.b(paramafou1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (azdj.b(paramafou2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (azdj.a(paramafou1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramafou1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (azdj.a(paramafou2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramafou2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(azdj.c(paramafou1), 1).compareToIgnoreCase(ChnToSpell.a(azdj.c(paramafou2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdn
 * JD-Core Version:    0.7.0.1
 */