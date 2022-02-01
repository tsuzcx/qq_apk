import java.util.Comparator;

class bawp
  implements Comparator<bawr>
{
  bawp(bawm parambawm) {}
  
  public int a(bawr parambawr1, bawr parambawr2)
  {
    int j = Long.signum(parambawr1.jdField_a_of_type_Int - parambawr2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(parambawr1.b - parambawr2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(parambawr1.c - parambawr2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-parambawr1.jdField_a_of_type_Long + parambawr2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawp
 * JD-Core Version:    0.7.0.1
 */