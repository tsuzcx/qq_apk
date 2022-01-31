import java.util.Comparator;

class ayhh
  implements Comparator<ayhj>
{
  ayhh(ayhe paramayhe) {}
  
  public int a(ayhj paramayhj1, ayhj paramayhj2)
  {
    int j = Long.signum(paramayhj1.jdField_a_of_type_Int - paramayhj2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramayhj1.b - paramayhj2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramayhj1.c - paramayhj2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramayhj1.jdField_a_of_type_Long + paramayhj2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhh
 * JD-Core Version:    0.7.0.1
 */