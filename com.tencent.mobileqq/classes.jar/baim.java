import java.util.ArrayList;
import java.util.Iterator;

public class baim
  implements baii
{
  private baik jdField_a_of_type_Baik;
  private ArrayList<baii> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public baij a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new baij(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      baii localbaii;
      baij localbaij;
      if (localIterator.hasNext())
      {
        localbaii = (baii)localIterator.next();
        if (this.jdField_a_of_type_Baik != null) {
          this.jdField_a_of_type_Baik.a(localbaii, paramArrayOfByte);
        }
        localbaij = localbaii.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localbaij;
        if (localbaij != null)
        {
          localObject = localbaij;
          if (localbaij.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localbaij.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localbaij;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localbaij;
      if (this.jdField_a_of_type_Baik != null)
      {
        this.jdField_a_of_type_Baik.b(localbaii, localbaij);
        paramArrayOfByte = localbaij;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((baii)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((baii)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(baii parambaii)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(parambaii);
  }
  
  public void a(baik parambaik)
  {
    this.jdField_a_of_type_Baik = parambaik;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baim
 * JD-Core Version:    0.7.0.1
 */