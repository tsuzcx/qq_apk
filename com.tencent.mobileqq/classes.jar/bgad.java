import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class bgad
  implements Comparator<ajvr>
{
  private final TroopInfo a;
  
  bgad(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(ajvr paramajvr1, ajvr paramajvr2)
  {
    int j = 5;
    int i;
    if (bfzz.b(paramajvr1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (bfzz.b(paramajvr2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (bfzz.a(paramajvr1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramajvr1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (bfzz.a(paramajvr2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramajvr2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(bfzz.c(paramajvr1), 1).compareToIgnoreCase(ChnToSpell.a(bfzz.c(paramajvr2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgad
 * JD-Core Version:    0.7.0.1
 */