import java.util.ArrayList;
import java.util.Iterator;

public class awyt
  implements awyp
{
  private awyr jdField_a_of_type_Awyr;
  private ArrayList<awyp> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public awyq a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new awyq(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      awyp localawyp;
      awyq localawyq;
      if (localIterator.hasNext())
      {
        localawyp = (awyp)localIterator.next();
        if (this.jdField_a_of_type_Awyr != null) {
          this.jdField_a_of_type_Awyr.a(localawyp, paramArrayOfByte);
        }
        localawyq = localawyp.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localawyq;
        if (localawyq != null)
        {
          localObject = localawyq;
          if (localawyq.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localawyq.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localawyq;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localawyq;
      if (this.jdField_a_of_type_Awyr != null)
      {
        this.jdField_a_of_type_Awyr.b(localawyp, localawyq);
        paramArrayOfByte = localawyq;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((awyp)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((awyp)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(awyp paramawyp)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramawyp);
  }
  
  public void a(awyr paramawyr)
  {
    this.jdField_a_of_type_Awyr = paramawyr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awyt
 * JD-Core Version:    0.7.0.1
 */