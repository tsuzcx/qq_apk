import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class baew
  implements Comparator<agas>
{
  private final TroopInfo a;
  
  baew(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(agas paramagas1, agas paramagas2)
  {
    int j = 5;
    int i;
    if (baes.b(paramagas1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (baes.b(paramagas2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (baes.a(paramagas1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramagas1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (baes.a(paramagas2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramagas2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(baes.c(paramagas1), 1).compareToIgnoreCase(ChnToSpell.a(baes.c(paramagas2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baew
 * JD-Core Version:    0.7.0.1
 */