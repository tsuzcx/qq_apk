import java.util.ArrayList;
import java.util.Iterator;

public class avcx
  implements avct
{
  private avcv jdField_a_of_type_Avcv;
  private ArrayList<avct> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public avcu a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new avcu(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      avct localavct;
      avcu localavcu;
      if (localIterator.hasNext())
      {
        localavct = (avct)localIterator.next();
        if (this.jdField_a_of_type_Avcv != null) {
          this.jdField_a_of_type_Avcv.a(localavct, paramArrayOfByte);
        }
        localavcu = localavct.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localavcu;
        if (localavcu != null)
        {
          localObject = localavcu;
          if (localavcu.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localavcu.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localavcu;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localavcu;
      if (this.jdField_a_of_type_Avcv != null)
      {
        this.jdField_a_of_type_Avcv.b(localavct, localavcu);
        paramArrayOfByte = localavcu;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((avct)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((avct)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(avct paramavct)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramavct);
  }
  
  public void a(avcv paramavcv)
  {
    this.jdField_a_of_type_Avcv = paramavcv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avcx
 * JD-Core Version:    0.7.0.1
 */