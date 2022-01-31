import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class bdux
{
  public SparseArray<List<bduw>> a;
  bduw a;
  public List<bduw> a;
  
  public bdux()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bduw = bduw.a();
  }
  
  public bduw a(int paramInt)
  {
    bduw localbduw1 = this.jdField_a_of_type_Bduw;
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
      bduw localbduw2;
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
        if (localbduw1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbduw1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbduw1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbduw2 = bduw.a(i, b);
          localbduw1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbduw2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbduw2.jdField_a_of_type_Boolean = bool;
          if (!localbduw2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbduw2);
        }
      }
      for (;;)
      {
        localbduw1 = (bduw)localbduw1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbduw1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbduw1.jdField_a_of_type_Long += m;
        localbduw1.b += n;
        localbduw1.c += i1;
        localbduw1.jdField_a_of_type_Int += 1;
        return localbduw1;
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
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbduw2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbduw1;
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
      bduw localbduw = (bduw)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbduw);
      i = 0;
      while (i < 8)
      {
        localObject = (bduw)localbduw.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbduw.jdField_a_of_type_Long += ((bduw)localObject).jdField_a_of_type_Long;
          localbduw.b += ((bduw)localObject).b;
          localbduw.c += ((bduw)localObject).c;
          localbduw.jdField_a_of_type_Int += ((bduw)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbduw.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbduw.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbduw.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbduw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdux
 * JD-Core Version:    0.7.0.1
 */