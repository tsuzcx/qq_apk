import android.graphics.Color;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

public class bdqo
{
  public SparseArray<List<bdqn>> a;
  bdqn a;
  public List<bdqn> a;
  
  public bdqo()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Bdqn = bdqn.a();
  }
  
  public bdqn a(int paramInt)
  {
    bdqn localbdqn1 = this.jdField_a_of_type_Bdqn;
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
      bdqn localbdqn2;
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
        if (localbdqn1.jdField_a_of_type_AndroidUtilSparseArray == null) {
          localbdqn1.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
        }
        if (localbdqn1.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)
        {
          localbdqn2 = bdqn.a(i, b);
          localbdqn1.jdField_a_of_type_AndroidUtilSparseArray.put(i, localbdqn2);
          if (b != 8) {
            break label259;
          }
          bool = true;
          label136:
          localbdqn2.jdField_a_of_type_Boolean = bool;
          if (!localbdqn2.jdField_a_of_type_Boolean) {
            break label265;
          }
          this.jdField_a_of_type_JavaUtilList.add(localbdqn2);
        }
      }
      for (;;)
      {
        localbdqn1 = (bdqn)localbdqn1.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (!localbdqn1.jdField_a_of_type_Boolean) {
          break label313;
        }
        localbdqn1.jdField_a_of_type_Long += m;
        localbdqn1.b += n;
        localbdqn1.c += i1;
        localbdqn1.jdField_a_of_type_Int += 1;
        return localbdqn1;
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
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(b)).add(localbdqn2);
      }
      label313:
      b = (byte)(b + 1);
      paramInt >>= 1;
    }
    return localbdqn1;
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
      bdqn localbdqn = (bdqn)((List)localObject).get(((List)localObject).size() - 1);
      ((List)localObject).remove(localbdqn);
      i = 0;
      while (i < 8)
      {
        localObject = (bdqn)localbdqn.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject != null)
        {
          localbdqn.jdField_a_of_type_Long += ((bdqn)localObject).jdField_a_of_type_Long;
          localbdqn.b += ((bdqn)localObject).b;
          localbdqn.c += ((bdqn)localObject).c;
          localbdqn.jdField_a_of_type_Int += ((bdqn)localObject).jdField_a_of_type_Int;
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        i += 1;
      }
      localbdqn.jdField_a_of_type_AndroidUtilSparseArray.clear();
      localbdqn.jdField_a_of_type_AndroidUtilSparseArray = null;
      localbdqn.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilList.add(localbdqn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqo
 * JD-Core Version:    0.7.0.1
 */