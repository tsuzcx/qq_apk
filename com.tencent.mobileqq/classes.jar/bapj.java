import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class bapj
{
  public SparseArray<List<bapi>> a;
  bapi a;
  public List<bapi> a;
  
  public bapj()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bapi = bapi.a();
  }
  
  public bapi a(int paramInt)
  {
    bapi localbapi1 = this.jdField_a_of_type_Bapi;
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
      bapi localbapi2;
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
        if (localbapi1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbapi1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbapi1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbapi2 = bapi.a(i, b);
          localbapi1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbapi2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbapi2.jdField_a_of_type_Boolean = bool;
          if (!localbapi2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbapi2);
        }
      }
      for (;;)
      {
        localbapi1 = (bapi)localbapi1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbapi1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbapi1.jdField_a_of_type_Long += m;
        localbapi1.b += n;
        localbapi1.c += i1;
        localbapi1.jdField_a_of_type_Int += 1;
        return localbapi1;
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
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbapi2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbapi1;
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
      bapi localbapi = (bapi)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbapi);
      i = 0;
      while (i < 8)
      {
        localObject = (bapi)localbapi.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbapi.jdField_a_of_type_Long += ((bapi)localObject).jdField_a_of_type_Long;
          localbapi.b += ((bapi)localObject).b;
          localbapi.c += ((bapi)localObject).c;
          localbapi.jdField_a_of_type_Int += ((bapi)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbapi.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbapi.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbapi.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbapi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bapj
 * JD-Core Version:    0.7.0.1
 */