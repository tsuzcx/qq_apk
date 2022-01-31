import java.util.Comparator;

class awmc
  implements Comparator<awme>
{
  awmc(awlz paramawlz) {}
  
  public int a(awme paramawme1, awme paramawme2)
  {
    int j = Long.signum(paramawme1.jdField_a_of_type_Int - paramawme2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramawme1.b - paramawme2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramawme1.c - paramawme2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramawme1.jdField_a_of_type_Long + paramawme2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmc
 * JD-Core Version:    0.7.0.1
 */