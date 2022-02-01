import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class bgzy
{
  public SparseArray<List<bgzx>> a;
  bgzx a;
  public List<bgzx> a;
  
  public bgzy()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bgzx = bgzx.a();
  }
  
  public bgzx a(int paramInt)
  {
    bgzx localbgzx1 = this.jdField_a_of_type_Bgzx;
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
      bgzx localbgzx2;
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
        if (localbgzx1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbgzx1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbgzx1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbgzx2 = bgzx.a(i, b);
          localbgzx1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbgzx2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbgzx2.jdField_a_of_type_Boolean = bool;
          if (!localbgzx2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbgzx2);
        }
      }
      for (;;)
      {
        localbgzx1 = (bgzx)localbgzx1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbgzx1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbgzx1.jdField_a_of_type_Long += m;
        localbgzx1.b += n;
        localbgzx1.c += i1;
        localbgzx1.jdField_a_of_type_Int += 1;
        return localbgzx1;
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
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbgzx2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbgzx1;
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
      bgzx localbgzx = (bgzx)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbgzx);
      i = 0;
      while (i < 8)
      {
        localObject = (bgzx)localbgzx.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbgzx.jdField_a_of_type_Long += ((bgzx)localObject).jdField_a_of_type_Long;
          localbgzx.b += ((bgzx)localObject).b;
          localbgzx.c += ((bgzx)localObject).c;
          localbgzx.jdField_a_of_type_Int += ((bgzx)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbgzx.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbgzx.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbgzx.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbgzx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgzy
 * JD-Core Version:    0.7.0.1
 */