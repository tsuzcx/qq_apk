import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class baei
  implements Comparator<agau>
{
  private final TroopInfo a;
  
  baei(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(agau paramagau1, agau paramagau2)
  {
    int j = 5;
    int i;
    if (baee.b(paramagau1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (baee.b(paramagau2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (baee.a(paramagau1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramagau1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (baee.a(paramagau2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramagau2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(baee.c(paramagau1), 1).compareToIgnoreCase(ChnToSpell.a(baee.c(paramagau2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baei
 * JD-Core Version:    0.7.0.1
 */