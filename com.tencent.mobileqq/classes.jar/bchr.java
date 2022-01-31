import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class bchr
  implements Comparator<aidf>
{
  private final TroopInfo a;
  
  bchr(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(aidf paramaidf1, aidf paramaidf2)
  {
    int j = 5;
    int i;
    if (bchn.b(paramaidf1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (bchn.b(paramaidf2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (bchn.a(paramaidf1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramaidf1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (bchn.a(paramaidf2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramaidf2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(bchn.c(paramaidf1), 1).compareToIgnoreCase(ChnToSpell.a(bchn.c(paramaidf2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchr
 * JD-Core Version:    0.7.0.1
 */