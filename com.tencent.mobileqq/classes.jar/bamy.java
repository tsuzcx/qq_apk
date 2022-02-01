import java.util.ArrayList;
import java.util.Iterator;

public class bamy
  implements bamu
{
  private bamw jdField_a_of_type_Bamw;
  private ArrayList<bamu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bamv a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new bamv(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      bamu localbamu;
      bamv localbamv;
      if (localIterator.hasNext())
      {
        localbamu = (bamu)localIterator.next();
        if (this.jdField_a_of_type_Bamw != null) {
          this.jdField_a_of_type_Bamw.a(localbamu, paramArrayOfByte);
        }
        localbamv = localbamu.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localbamv;
        if (localbamv != null)
        {
          localObject = localbamv;
          if (localbamv.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localbamv.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localbamv;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localbamv;
      if (this.jdField_a_of_type_Bamw != null)
      {
        this.jdField_a_of_type_Bamw.b(localbamu, localbamv);
        paramArrayOfByte = localbamv;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bamu)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bamu)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(bamu parambamu)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambamu);
  }
  
  public void a(bamw parambamw)
  {
    this.jdField_a_of_type_Bamw = parambamw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamy
 * JD-Core Version:    0.7.0.1
 */