import java.util.Comparator;

class bcdf
  implements Comparator<bcdh>
{
  bcdf(bcdc parambcdc) {}
  
  public int a(bcdh parambcdh1, bcdh parambcdh2)
  {
    int j = Long.signum(parambcdh1.jdField_a_of_type_Int - parambcdh2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(parambcdh1.b - parambcdh2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(parambcdh1.c - parambcdh2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-parambcdh1.jdField_a_of_type_Long + parambcdh2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdf
 * JD-Core Version:    0.7.0.1
 */