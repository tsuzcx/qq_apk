import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class biae
{
  public SparseArray<List<biad>> a;
  biad a;
  public List<biad> a;
  
  public biae()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Biad = biad.a();
  }
  
  public biad a(int paramInt)
  {
    biad localbiad1 = this.jdField_a_of_type_Biad;
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
      biad localbiad2;
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
        if (localbiad1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbiad1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbiad1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbiad2 = biad.a(i, b);
          localbiad1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbiad2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbiad2.jdField_a_of_type_Boolean = bool;
          if (!localbiad2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbiad2);
        }
      }
      for (;;)
      {
        localbiad1 = (biad)localbiad1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbiad1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbiad1.jdField_a_of_type_Long += m;
        localbiad1.b += n;
        localbiad1.c += i1;
        localbiad1.jdField_a_of_type_Int += 1;
        return localbiad1;
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
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbiad2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbiad1;
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
      biad localbiad = (biad)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbiad);
      i = 0;
      while (i < 8)
      {
        localObject = (biad)localbiad.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbiad.jdField_a_of_type_Long += ((biad)localObject).jdField_a_of_type_Long;
          localbiad.b += ((biad)localObject).b;
          localbiad.c += ((biad)localObject).c;
          localbiad.jdField_a_of_type_Int += ((biad)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbiad.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbiad.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbiad.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbiad);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biae
 * JD-Core Version:    0.7.0.1
 */