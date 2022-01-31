import java.util.concurrent.atomic.AtomicInteger;

public class bnsu
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private bnsr[] jdField_a_of_type_ArrayOfBnsr;
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public bnsr a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bnsr localbnsr;
    if (i < this.jdField_a_of_type_ArrayOfBnsr.length) {
      if (this.jdField_a_of_type_ArrayOfBnsr[i].b() == 0)
      {
        localbnsr = this.jdField_a_of_type_ArrayOfBnsr[i];
        localbnsr.c();
      }
    }
    for (;;)
    {
      return localbnsr;
      i += 1;
      break;
      localbnsr = null;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBnsr.length)
      {
        if (this.jdField_a_of_type_ArrayOfBnsr[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public bnsr b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bnsr localbnsr;
    if (i < this.jdField_a_of_type_ArrayOfBnsr.length)
    {
      if (this.jdField_a_of_type_ArrayOfBnsr[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBnsr[i].a() != 0)
      {
        i += 1;
        break;
      }
      localbnsr = this.jdField_a_of_type_ArrayOfBnsr[i];
      localbnsr.c();
    }
    for (;;)
    {
      return localbnsr;
      localbnsr = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnsu
 * JD-Core Version:    0.7.0.1
 */