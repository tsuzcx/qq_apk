import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class bbru
{
  public SparseArray<List<bbrt>> a;
  bbrt a;
  public List<bbrt> a;
  
  public bbru()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bbrt = bbrt.a();
  }
  
  public bbrt a(int paramInt)
  {
    bbrt localbbrt1 = this.jdField_a_of_type_Bbrt;
    int m = Color.red(paramInt);
    int n = Color.green(paramInt);
    int i1 = Color.blue(paramInt);
    paramInt = 128;
    byte b = 1;
    while (b <= 8)
    {
      int i;
      int j;
      label55:
      int k;
      label65:
      bbrt localbbrt2;
      boolean bool;
      if ((m & paramInt) == 0)
      {
        i = 0;
        if ((n & paramInt) != 0) {
          break label247;
        }
        j = 0;
        if ((i1 & paramInt) != 0) {
          break label253;
        }
        k = 0;
        i = i * 4 + j * 2 + k;
        if (localbbrt1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbbrt1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbbrt1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbbrt2 = bbrt.a(i, b);
          localbbrt1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbbrt2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbbrt2.jdField_a_of_type_Boolean = bool;
          if (!localbbrt2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbbrt2);
        }
      }
      for (;;)
      {
        localbbrt1 = (bbrt)localbbrt1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbbrt1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbbrt1.jdField_a_of_type_Long += m;
        localbbrt1.b += n;
        localbbrt1.c += i1;
        localbbrt1.jdField_a_of_type_Int += 1;
        return localbbrt1;
        i = 1;
        break;
        label247:
        j = 1;
        break label55;
        label253:
        k = 1;
        break label65;
        label259:
        bool = false;
        break label136;
        label265:
        if (this.jdField_a_of_type_AndroidUtilSparseArray.get(b) == null) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(b, new ArrayList());
        }
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbbrt2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbbrt1;
  }
  
  public void a()
  {
    int i = 7;
    while ((i > 0) && (((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).isEmpty())) {
      i -= 1;
    }
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      bbrt localbbrt = (bbrt)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbbrt);
      i = 0;
      while (i < 8)
      {
        localObject = (bbrt)localbbrt.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbbrt.jdField_a_of_type_Long += ((bbrt)localObject).jdField_a_of_type_Long;
          localbbrt.b += ((bbrt)localObject).b;
          localbbrt.c += ((bbrt)localObject).c;
          localbbrt.jdField_a_of_type_Int += ((bbrt)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbbrt.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbbrt.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbbrt.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbbrt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbru
 * JD-Core Version:    0.7.0.1
 */