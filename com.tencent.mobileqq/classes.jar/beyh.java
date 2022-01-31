public class beyh
{
  volatile int jdField_a_of_type_Int = 0;
  private beyi jdField_a_of_type_Beyi = new beyi();
  volatile int b = 0;
  
  public beyh(Class<? extends beyi> paramClass, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Beyi)
      {
        this.b = paramInt;
        this.jdField_a_of_type_Beyi.a = true;
        i = 0;
        if (i >= paramInt) {}
      }
      try
      {
        beyi localbeyi2 = (beyi)paramClass.newInstance();
        localbeyi2.a = true;
        localbeyi2.a(this.jdField_a_of_type_Beyi.a(), false);
        this.jdField_a_of_type_Beyi.a(localbeyi2, false);
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
  
  public beyi a(Class<? extends beyi> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    beyi localbeyi;
    if (this.jdField_a_of_type_Int > 0)
    {
      localbeyi = this.jdField_a_of_type_Beyi;
      localObject1 = localObject2;
      try
      {
        if (this.jdField_a_of_type_Int <= 0) {
          break label101;
        }
        localObject1 = this.jdField_a_of_type_Beyi.a();
        if (localObject1 == null) {
          throw new RuntimeException("WTF");
        }
      }
      finally {}
      if (!((beyi)localObject1).a) {
        throw new RuntimeException("WTF");
      }
      this.jdField_a_of_type_Beyi.a(beyi.a((beyi)localObject1), false);
      ((beyi)localObject1).a = false;
      this.jdField_a_of_type_Int -= 1;
    }
    label101:
    if (localObject1 == null) {
      try
      {
        paramClass = (beyi)paramClass.newInstance();
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
 * Qualified Name:     beyh
 * JD-Core Version:    0.7.0.1
 */