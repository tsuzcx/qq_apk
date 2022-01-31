import java.util.ArrayList;
import java.util.Iterator;

public class avcv
  implements avcr
{
  private avct jdField_a_of_type_Avct;
  private ArrayList<avcr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public avcs a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new avcs(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      avcr localavcr;
      avcs localavcs;
      if (localIterator.hasNext())
      {
        localavcr = (avcr)localIterator.next();
        if (this.jdField_a_of_type_Avct != null) {
          this.jdField_a_of_type_Avct.a(localavcr, paramArrayOfByte);
        }
        localavcs = localavcr.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localavcs;
        if (localavcs != null)
        {
          localObject = localavcs;
          if (localavcs.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localavcs.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localavcs;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localavcs;
      if (this.jdField_a_of_type_Avct != null)
      {
        this.jdField_a_of_type_Avct.b(localavcr, localavcs);
        paramArrayOfByte = localavcs;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((avcr)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((avcr)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(avcr paramavcr)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramavcr);
  }
  
  public void a(avct paramavct)
  {
    this.jdField_a_of_type_Avct = paramavct;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avcv
 * JD-Core Version:    0.7.0.1
 */