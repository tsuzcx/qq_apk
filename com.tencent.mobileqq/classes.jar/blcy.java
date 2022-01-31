import java.util.concurrent.atomic.AtomicInteger;

public class blcy
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private blcv[] jdField_a_of_type_ArrayOfBlcv;
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public blcv a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    blcv localblcv;
    if (i < this.jdField_a_of_type_ArrayOfBlcv.length) {
      if (this.jdField_a_of_type_ArrayOfBlcv[i].b() == 0)
      {
        localblcv = this.jdField_a_of_type_ArrayOfBlcv[i];
        localblcv.c();
      }
    }
    for (;;)
    {
      return localblcv;
      i += 1;
      break;
      localblcv = null;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBlcv.length)
      {
        if (this.jdField_a_of_type_ArrayOfBlcv[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public blcv b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    blcv localblcv;
    if (i < this.jdField_a_of_type_ArrayOfBlcv.length)
    {
      if (this.jdField_a_of_type_ArrayOfBlcv[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBlcv[i].a() != 0)
      {
        i += 1;
        break;
      }
      localblcv = this.jdField_a_of_type_ArrayOfBlcv[i];
      localblcv.c();
    }
    for (;;)
    {
      return localblcv;
      localblcv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     blcy
 * JD-Core Version:    0.7.0.1
 */