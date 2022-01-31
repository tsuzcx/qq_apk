import java.util.Comparator;

class aylq
  implements Comparator<ayls>
{
  aylq(ayln paramayln) {}
  
  public int a(ayls paramayls1, ayls paramayls2)
  {
    int j = Long.signum(paramayls1.jdField_a_of_type_Int - paramayls2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramayls1.b - paramayls2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramayls1.c - paramayls2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramayls1.jdField_a_of_type_Long + paramayls2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylq
 * JD-Core Version:    0.7.0.1
 */