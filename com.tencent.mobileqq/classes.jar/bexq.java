public class bexq
{
  volatile int jdField_a_of_type_Int = 0;
  private bexr jdField_a_of_type_Bexr = new bexr();
  volatile int b = 0;
  
  public bexq(Class<? extends bexr> paramClass, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Bexr)
      {
        this.b = paramInt;
        this.jdField_a_of_type_Bexr.a = true;
        i = 0;
        if (i >= paramInt) {}
      }
      try
      {
        bexr localbexr2 = (bexr)paramClass.newInstance();
        localbexr2.a = true;
        localbexr2.a(this.jdField_a_of_type_Bexr.a(), false);
        this.jdField_a_of_type_Bexr.a(localbexr2, false);
        this.jdField_a_of_type_Int += 1;
        label102:
        i += 1;
        continue;
        return;
        paramClass = finally;
        throw paramClass;
      }
      catch (Throwable localThrowable)
      {
        break label102;
      }
    }
  }
  
  public bexr a(Class<? extends bexr> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    bexr localbexr;
    if (this.jdField_a_of_type_Int > 0)
    {
      localbexr = this.jdField_a_of_type_Bexr;
      localObject1 = localObject2;
      try
      {
        if (this.jdField_a_of_type_Int <= 0) {
          break label101;
        }
        localObject1 = this.jdField_a_of_type_Bexr.a();
        if (localObject1 == null) {
          throw new RuntimeException("WTF");
        }
      }
      finally {}
      if (!((bexr)localObject1).a) {
        throw new RuntimeException("WTF");
      }
      this.jdField_a_of_type_Bexr.a(bexr.a((bexr)localObject1), false);
      ((bexr)localObject1).a = false;
      this.jdField_a_of_type_Int -= 1;
    }
    label101:
    if (localObject1 == null) {
      try
      {
        paramClass = (bexr)paramClass.newInstance();
        return paramClass;
      }
      catch (Throwable paramClass)
      {
        return localObject1;
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bexq
 * JD-Core Version:    0.7.0.1
 */