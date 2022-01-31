import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class bcdi
  implements Comparator<ahyq>
{
  private final TroopInfo a;
  
  bcdi(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(ahyq paramahyq1, ahyq paramahyq2)
  {
    int j = 5;
    int i;
    if (bcde.b(paramahyq1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (bcde.b(paramahyq2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (bcde.a(paramahyq1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramahyq1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (bcde.a(paramahyq2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramahyq2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(bcde.c(paramahyq1), 1).compareToIgnoreCase(ChnToSpell.a(bcde.c(paramahyq2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdi
 * JD-Core Version:    0.7.0.1
 */