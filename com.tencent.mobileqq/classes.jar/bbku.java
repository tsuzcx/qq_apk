import java.util.Comparator;

class bbku
  implements Comparator<bbkw>
{
  bbku(bbkr parambbkr) {}
  
  public int a(bbkw parambbkw1, bbkw parambbkw2)
  {
    int j = Long.signum(parambbkw1.jdField_a_of_type_Int - parambbkw2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(parambbkw1.b - parambbkw2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(parambbkw1.c - parambbkw2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-parambbkw1.jdField_a_of_type_Long + parambbkw2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbku
 * JD-Core Version:    0.7.0.1
 */