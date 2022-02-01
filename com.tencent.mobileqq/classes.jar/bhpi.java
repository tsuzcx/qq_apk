import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class bhpi
{
  public SparseArray<List<bhph>> a;
  bhph a;
  public List<bhph> a;
  
  public bhpi()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bhph = bhph.a();
  }
  
  public bhph a(int paramInt)
  {
    bhph localbhph1 = this.jdField_a_of_type_Bhph;
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
      bhph localbhph2;
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
        if (localbhph1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbhph1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbhph1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbhph2 = bhph.a(i, b);
          localbhph1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbhph2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbhph2.jdField_a_of_type_Boolean = bool;
          if (!localbhph2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbhph2);
        }
      }
      for (;;)
      {
        localbhph1 = (bhph)localbhph1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbhph1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbhph1.jdField_a_of_type_Long += m;
        localbhph1.b += n;
        localbhph1.c += i1;
        localbhph1.jdField_a_of_type_Int += 1;
        return localbhph1;
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
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbhph2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbhph1;
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
      bhph localbhph = (bhph)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbhph);
      i = 0;
      while (i < 8)
      {
        localObject = (bhph)localbhph.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbhph.jdField_a_of_type_Long += ((bhph)localObject).jdField_a_of_type_Long;
          localbhph.b += ((bhph)localObject).b;
          localbhph.c += ((bhph)localObject).c;
          localbhph.jdField_a_of_type_Int += ((bhph)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbhph.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbhph.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbhph.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbhph);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpi
 * JD-Core Version:    0.7.0.1
 */