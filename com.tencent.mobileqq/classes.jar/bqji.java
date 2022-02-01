import java.util.concurrent.atomic.AtomicInteger;

public class bqji
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private bqjf[] jdField_a_of_type_ArrayOfBqjf;
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public bqjf a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bqjf localbqjf;
    if (i < this.jdField_a_of_type_ArrayOfBqjf.length) {
      if (this.jdField_a_of_type_ArrayOfBqjf[i].b() == 0)
      {
        localbqjf = this.jdField_a_of_type_ArrayOfBqjf[i];
        localbqjf.c();
      }
    }
    for (;;)
    {
      return localbqjf;
      i += 1;
      break;
      localbqjf = null;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBqjf.length)
      {
        if (this.jdField_a_of_type_ArrayOfBqjf[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public bqjf b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bqjf localbqjf;
    if (i < this.jdField_a_of_type_ArrayOfBqjf.length)
    {
      if (this.jdField_a_of_type_ArrayOfBqjf[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBqjf[i].a() != 0)
      {
        i += 1;
        break;
      }
      localbqjf = this.jdField_a_of_type_ArrayOfBqjf[i];
      localbqjf.c();
    }
    for (;;)
    {
      return localbqjf;
      localbqjf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqji
 * JD-Core Version:    0.7.0.1
 */