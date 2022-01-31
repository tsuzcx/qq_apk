import java.util.ArrayList;
import java.util.Iterator;

public class audp
  implements audl
{
  private audn jdField_a_of_type_Audn;
  private ArrayList<audl> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public audm a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new audm(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      audl localaudl;
      audm localaudm;
      if (localIterator.hasNext())
      {
        localaudl = (audl)localIterator.next();
        if (this.jdField_a_of_type_Audn != null) {
          this.jdField_a_of_type_Audn.a(localaudl, paramArrayOfByte);
        }
        localaudm = localaudl.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localaudm;
        if (localaudm != null)
        {
          localObject = localaudm;
          if (localaudm.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localaudm.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localaudm;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localaudm;
      if (this.jdField_a_of_type_Audn != null)
      {
        this.jdField_a_of_type_Audn.b(localaudl, localaudm);
        paramArrayOfByte = localaudm;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((audl)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((audl)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(audl paramaudl)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramaudl);
  }
  
  public void a(audn paramaudn)
  {
    this.jdField_a_of_type_Audn = paramaudn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     audp
 * JD-Core Version:    0.7.0.1
 */