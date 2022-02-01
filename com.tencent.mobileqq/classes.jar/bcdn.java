import java.util.Comparator;

class bcdn
  implements Comparator<bcdp>
{
  bcdn(bcdk parambcdk) {}
  
  public int a(bcdp parambcdp1, bcdp parambcdp2)
  {
    int j = Long.signum(parambcdp1.jdField_a_of_type_Int - parambcdp2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(parambcdp1.b - parambcdp2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(parambcdp1.c - parambcdp2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-parambcdp1.jdField_a_of_type_Long + parambcdp2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdn
 * JD-Core Version:    0.7.0.1
 */