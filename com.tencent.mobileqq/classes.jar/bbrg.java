import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class bbrg
{
  public SparseArray<List<bbrf>> a;
  bbrf a;
  public List<bbrf> a;
  
  public bbrg()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bbrf = bbrf.a();
  }
  
  public bbrf a(int paramInt)
  {
    bbrf localbbrf1 = this.jdField_a_of_type_Bbrf;
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
      bbrf localbbrf2;
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
        if (localbbrf1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbbrf1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbbrf1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbbrf2 = bbrf.a(i, b);
          localbbrf1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbbrf2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbbrf2.jdField_a_of_type_Boolean = bool;
          if (!localbbrf2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbbrf2);
        }
      }
      for (;;)
      {
        localbbrf1 = (bbrf)localbbrf1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbbrf1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbbrf1.jdField_a_of_type_Long += m;
        localbbrf1.b += n;
        localbbrf1.c += i1;
        localbbrf1.jdField_a_of_type_Int += 1;
        return localbbrf1;
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
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbbrf2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbbrf1;
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
      bbrf localbbrf = (bbrf)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbbrf);
      i = 0;
      while (i < 8)
      {
        localObject = (bbrf)localbbrf.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbbrf.jdField_a_of_type_Long += ((bbrf)localObject).jdField_a_of_type_Long;
          localbbrf.b += ((bbrf)localObject).b;
          localbbrf.c += ((bbrf)localObject).c;
          localbbrf.jdField_a_of_type_Int += ((bbrf)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbbrf.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbbrf.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbbrf.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbbrf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrg
 * JD-Core Version:    0.7.0.1
 */