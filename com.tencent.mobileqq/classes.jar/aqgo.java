import com.tencent.common.app.AppInterface;

public class aqgo
{
  public static final String a;
  public aqgq[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = aqgr.class.getSimpleName() + "." + aqgo.class.getSimpleName();
  }
  
  public aqgo()
  {
    this.jdField_a_of_type_ArrayOfAqgq = new aqgq[7];
  }
  
  public aqgq a(AppInterface paramAppInterface, int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt <= 7) {}
    }
    else
    {
      i = 0;
    }
    Object localObject = this.jdField_a_of_type_ArrayOfAqgq[i];
    paramAppInterface = (AppInterface)localObject;
    if (localObject == null)
    {
      paramAppInterface = (AppInterface)localObject;
      switch (i)
      {
      default: 
        paramAppInterface = (AppInterface)localObject;
      }
    }
    for (;;)
    {
      localObject = paramAppInterface;
      if (paramAppInterface == null) {
        localObject = new aqgp();
      }
      this.jdField_a_of_type_ArrayOfAqgq[i] = localObject;
      return localObject;
      paramAppInterface = new luo();
      continue;
      paramAppInterface = new apfv();
      continue;
      paramAppInterface = new mzy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgo
 * JD-Core Version:    0.7.0.1
 */