import java.util.Comparator;

class aobn
  implements Comparator<aobm>
{
  public int a(aobm paramaobm1, aobm paramaobm2)
  {
    if (paramaobm1.b < paramaobm2.b) {
      return -1;
    }
    if (paramaobm1.b > paramaobm2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aobn
 * JD-Core Version:    0.7.0.1
 */