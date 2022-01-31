import java.util.Comparator;

class awme
  implements Comparator<awmg>
{
  awme(awmb paramawmb) {}
  
  public int a(awmg paramawmg1, awmg paramawmg2)
  {
    int j = Long.signum(paramawmg1.jdField_a_of_type_Int - paramawmg2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramawmg1.b - paramawmg2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramawmg1.c - paramawmg2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramawmg1.jdField_a_of_type_Long + paramawmg2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awme
 * JD-Core Version:    0.7.0.1
 */