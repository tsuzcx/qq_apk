import java.util.concurrent.atomic.AtomicInteger;

public class bnoi
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private bnof[] jdField_a_of_type_ArrayOfBnof;
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public bnof a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bnof localbnof;
    if (i < this.jdField_a_of_type_ArrayOfBnof.length) {
      if (this.jdField_a_of_type_ArrayOfBnof[i].b() == 0)
      {
        localbnof = this.jdField_a_of_type_ArrayOfBnof[i];
        localbnof.c();
      }
    }
    for (;;)
    {
      return localbnof;
      i += 1;
      break;
      localbnof = null;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBnof.length)
      {
        if (this.jdField_a_of_type_ArrayOfBnof[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public bnof b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bnof localbnof;
    if (i < this.jdField_a_of_type_ArrayOfBnof.length)
    {
      if (this.jdField_a_of_type_ArrayOfBnof[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBnof[i].a() != 0)
      {
        i += 1;
        break;
      }
      localbnof = this.jdField_a_of_type_ArrayOfBnof[i];
      localbnof.c();
    }
    for (;;)
    {
      return localbnof;
      localbnof = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoi
 * JD-Core Version:    0.7.0.1
 */