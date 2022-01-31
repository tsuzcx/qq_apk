import java.util.concurrent.atomic.AtomicInteger;

public class bjlw
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private bjlt[] jdField_a_of_type_ArrayOfBjlt;
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public bjlt a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bjlt localbjlt;
    if (i < this.jdField_a_of_type_ArrayOfBjlt.length) {
      if (this.jdField_a_of_type_ArrayOfBjlt[i].b() == 0)
      {
        localbjlt = this.jdField_a_of_type_ArrayOfBjlt[i];
        localbjlt.c();
      }
    }
    for (;;)
    {
      return localbjlt;
      i += 1;
      break;
      localbjlt = null;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBjlt.length)
      {
        if (this.jdField_a_of_type_ArrayOfBjlt[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public bjlt b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bjlt localbjlt;
    if (i < this.jdField_a_of_type_ArrayOfBjlt.length)
    {
      if (this.jdField_a_of_type_ArrayOfBjlt[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBjlt[i].a() != 0)
      {
        i += 1;
        break;
      }
      localbjlt = this.jdField_a_of_type_ArrayOfBjlt[i];
      localbjlt.c();
    }
    for (;;)
    {
      return localbjlt;
      localbjlt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjlw
 * JD-Core Version:    0.7.0.1
 */