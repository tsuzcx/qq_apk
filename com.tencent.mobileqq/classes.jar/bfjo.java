import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

class bfjo
  implements Comparator<ajtt>
{
  private final TroopInfo a;
  
  bfjo(TroopInfo paramTroopInfo)
  {
    this.a = paramTroopInfo;
  }
  
  public int a(ajtt paramajtt1, ajtt paramajtt2)
  {
    int j = 5;
    int i;
    if (bfjk.b(paramajtt1.jdField_a_of_type_JavaLangString, this.a)) {
      i = 5;
    }
    for (;;)
    {
      if (bfjk.b(paramajtt2.jdField_a_of_type_JavaLangString, this.a)) {}
      for (;;)
      {
        if (i != j)
        {
          return j - i;
          if (bfjk.a(paramajtt1.jdField_a_of_type_JavaLangString, this.a))
          {
            i = 3;
            break;
          }
          if (!paramajtt1.jdField_a_of_type_Boolean) {
            break label134;
          }
          i = 1;
          break;
          if (bfjk.a(paramajtt2.jdField_a_of_type_JavaLangString, this.a))
          {
            j = 3;
            continue;
          }
          if (!paramajtt2.jdField_a_of_type_Boolean) {
            break label128;
          }
          j = 1;
          continue;
        }
        return ChnToSpell.a(bfjk.c(paramajtt1), 1).compareToIgnoreCase(ChnToSpell.a(bfjk.c(paramajtt2), 1));
        label128:
        j = 0;
      }
      label134:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjo
 * JD-Core Version:    0.7.0.1
 */