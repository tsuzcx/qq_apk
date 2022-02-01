import java.util.ArrayList;
import java.util.Iterator;

public class azui
  implements azue
{
  private azug jdField_a_of_type_Azug;
  private ArrayList<azue> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public azuf a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new azuf(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      azue localazue;
      azuf localazuf;
      if (localIterator.hasNext())
      {
        localazue = (azue)localIterator.next();
        if (this.jdField_a_of_type_Azug != null) {
          this.jdField_a_of_type_Azug.a(localazue, paramArrayOfByte);
        }
        localazuf = localazue.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localazuf;
        if (localazuf != null)
        {
          localObject = localazuf;
          if (localazuf.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localazuf.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localazuf;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localazuf;
      if (this.jdField_a_of_type_Azug != null)
      {
        this.jdField_a_of_type_Azug.b(localazue, localazuf);
        paramArrayOfByte = localazuf;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((azue)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((azue)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(azue paramazue)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramazue);
  }
  
  public void a(azug paramazug)
  {
    this.jdField_a_of_type_Azug = paramazug;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azui
 * JD-Core Version:    0.7.0.1
 */