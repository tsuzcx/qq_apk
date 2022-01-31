import java.util.Comparator;

class avmj
  implements Comparator<avml>
{
  avmj(avmg paramavmg) {}
  
  public int a(avml paramavml1, avml paramavml2)
  {
    int j = Long.signum(paramavml1.jdField_a_of_type_Int - paramavml2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramavml1.b - paramavml2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramavml1.c - paramavml2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramavml1.jdField_a_of_type_Long + paramavml2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmj
 * JD-Core Version:    0.7.0.1
 */