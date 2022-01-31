public class bdru
{
  volatile int jdField_a_of_type_Int = 0;
  private bdrv jdField_a_of_type_Bdrv = new bdrv();
  volatile int b = 0;
  
  public bdru(Class<? extends bdrv> paramClass, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Bdrv)
      {
        this.b = paramInt;
        this.jdField_a_of_type_Bdrv.a = true;
        i = 0;
        if (i >= paramInt) {}
      }
      try
      {
        bdrv localbdrv2 = (bdrv)paramClass.newInstance();
        localbdrv2.a = true;
        localbdrv2.a(this.jdField_a_of_type_Bdrv.a(), false);
        this.jdField_a_of_type_Bdrv.a(localbdrv2, false);
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
  
  public bdrv a(Class<? extends bdrv> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    bdrv localbdrv;
    if (this.jdField_a_of_type_Int > 0)
    {
      localbdrv = this.jdField_a_of_type_Bdrv;
      localObject1 = localObject2;
      try
      {
        if (this.jdField_a_of_type_Int <= 0) {
          break label101;
        }
        localObject1 = this.jdField_a_of_type_Bdrv.a();
        if (localObject1 == null) {
          throw new RuntimeException("WTF");
        }
      }
      finally {}
      if (!((bdrv)localObject1).a) {
        throw new RuntimeException("WTF");
      }
      this.jdField_a_of_type_Bdrv.a(bdrv.a((bdrv)localObject1), false);
      ((bdrv)localObject1).a = false;
      this.jdField_a_of_type_Int -= 1;
    }
    label101:
    if (localObject1 == null) {
      try
      {
        paramClass = (bdrv)paramClass.newInstance();
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
 * Qualified Name:     bdru
 * JD-Core Version:    0.7.0.1
 */