import java.util.concurrent.atomic.AtomicInteger;

public class blch
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private blce[] jdField_a_of_type_ArrayOfBlce;
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public blce a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    blce localblce;
    if (i < this.jdField_a_of_type_ArrayOfBlce.length) {
      if (this.jdField_a_of_type_ArrayOfBlce[i].b() == 0)
      {
        localblce = this.jdField_a_of_type_ArrayOfBlce[i];
        localblce.c();
      }
    }
    for (;;)
    {
      return localblce;
      i += 1;
      break;
      localblce = null;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBlce.length)
      {
        if (this.jdField_a_of_type_ArrayOfBlce[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public blce b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    blce localblce;
    if (i < this.jdField_a_of_type_ArrayOfBlce.length)
    {
      if (this.jdField_a_of_type_ArrayOfBlce[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBlce[i].a() != 0)
      {
        i += 1;
        break;
      }
      localblce = this.jdField_a_of_type_ArrayOfBlce[i];
      localblce.c();
    }
    for (;;)
    {
      return localblce;
      localblce = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     blch
 * JD-Core Version:    0.7.0.1
 */