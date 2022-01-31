public class bhbj
{
  volatile int jdField_a_of_type_Int = 0;
  private bhbk jdField_a_of_type_Bhbk = new bhbk();
  volatile int b = 0;
  
  public bhbj(Class<? extends bhbk> paramClass, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Bhbk)
      {
        this.b = paramInt;
        this.jdField_a_of_type_Bhbk.a = true;
        i = 0;
        if (i >= paramInt) {}
      }
      try
      {
        bhbk localbhbk2 = (bhbk)paramClass.newInstance();
        localbhbk2.a = true;
        localbhbk2.a(this.jdField_a_of_type_Bhbk.a(), false);
        this.jdField_a_of_type_Bhbk.a(localbhbk2, false);
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
  
  public bhbk a(Class<? extends bhbk> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    bhbk localbhbk;
    if (this.jdField_a_of_type_Int > 0)
    {
      localbhbk = this.jdField_a_of_type_Bhbk;
      localObject1 = localObject2;
      try
      {
        if (this.jdField_a_of_type_Int <= 0) {
          break label101;
        }
        localObject1 = this.jdField_a_of_type_Bhbk.a();
        if (localObject1 == null) {
          throw new RuntimeException("WTF");
        }
      }
      finally {}
      if (!((bhbk)localObject1).a) {
        throw new RuntimeException("WTF");
      }
      this.jdField_a_of_type_Bhbk.a(bhbk.a((bhbk)localObject1), false);
      ((bhbk)localObject1).a = false;
      this.jdField_a_of_type_Int -= 1;
    }
    label101:
    if (localObject1 == null) {
      try
      {
        paramClass = (bhbk)paramClass.newInstance();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhbj
 * JD-Core Version:    0.7.0.1
 */