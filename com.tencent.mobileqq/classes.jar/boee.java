import java.util.concurrent.atomic.AtomicInteger;

public class boee
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private boeb[] jdField_a_of_type_ArrayOfBoeb;
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public boeb a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    boeb localboeb;
    if (i < this.jdField_a_of_type_ArrayOfBoeb.length) {
      if (this.jdField_a_of_type_ArrayOfBoeb[i].b() == 0)
      {
        localboeb = this.jdField_a_of_type_ArrayOfBoeb[i];
        localboeb.c();
      }
    }
    for (;;)
    {
      return localboeb;
      i += 1;
      break;
      localboeb = null;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBoeb.length)
      {
        if (this.jdField_a_of_type_ArrayOfBoeb[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public boeb b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    boeb localboeb;
    if (i < this.jdField_a_of_type_ArrayOfBoeb.length)
    {
      if (this.jdField_a_of_type_ArrayOfBoeb[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBoeb[i].a() != 0)
      {
        i += 1;
        break;
      }
      localboeb = this.jdField_a_of_type_ArrayOfBoeb[i];
      localboeb.c();
    }
    for (;;)
    {
      return localboeb;
      localboeb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boee
 * JD-Core Version:    0.7.0.1
 */