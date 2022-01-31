import java.util.ArrayList;
import java.util.Iterator;

public class awuk
  implements awug
{
  private awui jdField_a_of_type_Awui;
  private ArrayList<awug> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public awuh a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new awuh(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      awug localawug;
      awuh localawuh;
      if (localIterator.hasNext())
      {
        localawug = (awug)localIterator.next();
        if (this.jdField_a_of_type_Awui != null) {
          this.jdField_a_of_type_Awui.a(localawug, paramArrayOfByte);
        }
        localawuh = localawug.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localawuh;
        if (localawuh != null)
        {
          localObject = localawuh;
          if (localawuh.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localawuh.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localawuh;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localawuh;
      if (this.jdField_a_of_type_Awui != null)
      {
        this.jdField_a_of_type_Awui.b(localawug, localawuh);
        paramArrayOfByte = localawuh;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((awug)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((awug)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(awug paramawug)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramawug);
  }
  
  public void a(awui paramawui)
  {
    this.jdField_a_of_type_Awui = paramawui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awuk
 * JD-Core Version:    0.7.0.1
 */