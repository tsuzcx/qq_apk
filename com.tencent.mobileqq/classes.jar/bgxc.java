public class bgxc
{
  volatile int jdField_a_of_type_Int = 0;
  private bgxd jdField_a_of_type_Bgxd = new bgxd();
  volatile int b = 0;
  
  public bgxc(Class<? extends bgxd> paramClass, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_Bgxd)
      {
        this.b = paramInt;
        this.jdField_a_of_type_Bgxd.a = true;
        i = 0;
        if (i >= paramInt) {}
      }
      try
      {
        bgxd localbgxd2 = (bgxd)paramClass.newInstance();
        localbgxd2.a = true;
        localbgxd2.a(this.jdField_a_of_type_Bgxd.a(), false);
        this.jdField_a_of_type_Bgxd.a(localbgxd2, false);
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
  
  public bgxd a(Class<? extends bgxd> paramClass)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    bgxd localbgxd;
    if (this.jdField_a_of_type_Int > 0)
    {
      localbgxd = this.jdField_a_of_type_Bgxd;
      localObject1 = localObject2;
      try
      {
        if (this.jdField_a_of_type_Int <= 0) {
          break label101;
        }
        localObject1 = this.jdField_a_of_type_Bgxd.a();
        if (localObject1 == null) {
          throw new RuntimeException("WTF");
        }
      }
      finally {}
      if (!((bgxd)localObject1).a) {
        throw new RuntimeException("WTF");
      }
      this.jdField_a_of_type_Bgxd.a(bgxd.a((bgxd)localObject1), false);
      ((bgxd)localObject1).a = false;
      this.jdField_a_of_type_Int -= 1;
    }
    label101:
    if (localObject1 == null) {
      try
      {
        paramClass = (bgxd)paramClass.newInstance();
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
 * Qualified Name:     bgxc
 * JD-Core Version:    0.7.0.1
 */