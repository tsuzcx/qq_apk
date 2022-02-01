import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class bggo
{
  public SparseArray<List<bggn>> a;
  bggn a;
  public List<bggn> a;
  
  public bggo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bggn = bggn.a();
  }
  
  public bggn a(int paramInt)
  {
    bggn localbggn1 = this.jdField_a_of_type_Bggn;
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
      bggn localbggn2;
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
        if (localbggn1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbggn1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbggn1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbggn2 = bggn.a(i, b);
          localbggn1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbggn2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbggn2.jdField_a_of_type_Boolean = bool;
          if (!localbggn2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbggn2);
        }
      }
      for (;;)
      {
        localbggn1 = (bggn)localbggn1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbggn1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbggn1.jdField_a_of_type_Long += m;
        localbggn1.b += n;
        localbggn1.c += i1;
        localbggn1.jdField_a_of_type_Int += 1;
        return localbggn1;
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
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbggn2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbggn1;
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
      bggn localbggn = (bggn)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbggn);
      i = 0;
      while (i < 8)
      {
        localObject = (bggn)localbggn.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbggn.jdField_a_of_type_Long += ((bggn)localObject).jdField_a_of_type_Long;
          localbggn.b += ((bggn)localObject).b;
          localbggn.c += ((bggn)localObject).c;
          localbggn.jdField_a_of_type_Int += ((bggn)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbggn.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbggn.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbggn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbggn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggo
 * JD-Core Version:    0.7.0.1
 */