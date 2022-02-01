import java.util.ArrayList;
import java.util.Iterator;

public class azcy
  implements azcu
{
  private azcw jdField_a_of_type_Azcw;
  private ArrayList<azcu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public azcv a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte = new azcv(paramArrayOfByte, paramInt1, paramInt2);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      azcu localazcu;
      azcv localazcv;
      if (localIterator.hasNext())
      {
        localazcu = (azcu)localIterator.next();
        if (this.jdField_a_of_type_Azcw != null) {
          this.jdField_a_of_type_Azcw.a(localazcu, paramArrayOfByte);
        }
        localazcv = localazcu.a(paramArrayOfByte.jdField_a_of_type_ArrayOfByte, paramArrayOfByte.b, paramArrayOfByte.jdField_a_of_type_Int);
        localObject = localazcv;
        if (localazcv != null)
        {
          localObject = localazcv;
          if (localazcv.jdField_a_of_type_ArrayOfByte != null)
          {
            if (localazcv.jdField_a_of_type_Int != 0) {
              break label121;
            }
            localObject = localazcv;
          }
        }
      }
      return localObject;
      label121:
      paramArrayOfByte = localazcv;
      if (this.jdField_a_of_type_Azcw != null)
      {
        this.jdField_a_of_type_Azcw.b(localazcu, localazcv);
        paramArrayOfByte = localazcv;
      }
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((azcu)localIterator.next()).a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((azcu)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(azcu paramazcu)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramazcu);
  }
  
  public void a(azcw paramazcw)
  {
    this.jdField_a_of_type_Azcw = paramazcw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azcy
 * JD-Core Version:    0.7.0.1
 */