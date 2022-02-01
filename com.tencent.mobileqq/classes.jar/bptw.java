import java.util.concurrent.atomic.AtomicInteger;

public class bptw
{
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private bptt[] jdField_a_of_type_ArrayOfBptt;
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1;
  }
  
  public bptt a()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bptt localbptt;
    if (i < this.jdField_a_of_type_ArrayOfBptt.length) {
      if (this.jdField_a_of_type_ArrayOfBptt[i].b() == 0)
      {
        localbptt = this.jdField_a_of_type_ArrayOfBptt[i];
        localbptt.c();
      }
    }
    for (;;)
    {
      return localbptt;
      i += 1;
      break;
      localbptt = null;
    }
  }
  
  public boolean a()
  {
    if (!b()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBptt.length)
      {
        if (this.jdField_a_of_type_ArrayOfBptt[i].a() == 3) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public bptt b()
  {
    if (!b()) {
      return null;
    }
    int i = 0;
    bptt localbptt;
    if (i < this.jdField_a_of_type_ArrayOfBptt.length)
    {
      if (this.jdField_a_of_type_ArrayOfBptt[i].c() == 0) {}
      while (this.jdField_a_of_type_ArrayOfBptt[i].a() != 0)
      {
        i += 1;
        break;
      }
      localbptt = this.jdField_a_of_type_ArrayOfBptt[i];
      localbptt.c();
    }
    for (;;)
    {
      return localbptt;
      localbptt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bptw
 * JD-Core Version:    0.7.0.1
 */