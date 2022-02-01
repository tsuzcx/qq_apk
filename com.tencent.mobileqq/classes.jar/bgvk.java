import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class bgvk
{
  public final bgvj a;
  public final List<bgvj> a;
  
  public bgvk()
  {
    this.jdField_a_of_type_Bgvj = new bgvj();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a(bgvk parambgvk)
  {
    int j;
    int i;
    label22:
    int k;
    if (parambgvk != null) {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        j = 0;
        if (parambgvk.jdField_a_of_type_JavaUtilList != null) {
          break label100;
        }
        i = 0;
        if (j != i) {
          break label144;
        }
        k = 0;
        i = 1;
        label32:
        if ((i == 0) || (k >= j)) {
          break label113;
        }
        if (bhbx.a((bgvj)this.jdField_a_of_type_JavaUtilList.get(k), (bgvj)parambgvk.jdField_a_of_type_JavaUtilList.get(k))) {
          break label161;
        }
        i = 0;
      }
    }
    label144:
    label161:
    for (;;)
    {
      k += 1;
      break label32;
      j = this.jdField_a_of_type_JavaUtilList.size();
      break;
      label100:
      i = parambgvk.jdField_a_of_type_JavaUtilList.size();
      break label22;
      label113:
      if (i != 0) {
        i = 0;
      }
      while (bhbx.a(parambgvk.jdField_a_of_type_Bgvj, this.jdField_a_of_type_Bgvj)) {
        if (i == 0)
        {
          return 0;
          i = 3;
          continue;
          i = 3;
        }
        else
        {
          return 1;
        }
      }
      if (i == 0) {
        return 2;
      }
      return 3;
      return 3;
    }
  }
  
  public Object clone()
  {
    bgvk localbgvk = new bgvk();
    localbgvk.jdField_a_of_type_Bgvj.a(this.jdField_a_of_type_Bgvj);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bgvj localbgvj = (bgvj)this.jdField_a_of_type_JavaUtilList.get(i);
      localbgvk.jdField_a_of_type_JavaUtilList.add((bgvj)localbgvj.clone());
      i += 1;
    }
    return localbgvk;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int j;
    if ((paramObject instanceof bgvk))
    {
      paramObject = (bgvk)paramObject;
      bool1 = bool2;
      if (bhbx.a(paramObject.jdField_a_of_type_Bgvj, this.jdField_a_of_type_Bgvj)) {
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          i = 0;
          if (paramObject.jdField_a_of_type_JavaUtilList != null) {
            break label134;
          }
          j = 0;
          label55:
          bool1 = bool2;
          if (i != j) {
            break label147;
          }
          bool1 = true;
          j = 0;
          label69:
          if ((!bool1) || (j >= i)) {
            break label147;
          }
          if (bhbx.a((bgvj)this.jdField_a_of_type_JavaUtilList.get(j), (bgvj)paramObject.jdField_a_of_type_JavaUtilList.get(j))) {
            break label150;
          }
          bool1 = false;
        }
      }
    }
    label134:
    label147:
    label150:
    for (;;)
    {
      j += 1;
      break label69;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
      j = paramObject.jdField_a_of_type_JavaUtilList.size();
      break label55;
      return bool1;
    }
  }
  
  public String toString()
  {
    localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append(String.format("[head] type=%s value=%s\n", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bgvj.jdField_a_of_type_Int), bhbx.b(this.jdField_a_of_type_Bgvj.jdField_a_of_type_JavaLangString) }));
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        bgvj localbgvj = (bgvj)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localbgvj != null) {
          localStringBuilder.append(String.format("[more item] type=%s value=%s\n", new Object[] { Integer.valueOf(localbgvj.jdField_a_of_type_Int), bhbx.b(localbgvj.jdField_a_of_type_JavaLangString) }));
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (Exception localException)
    {
      QLog.e("MQQProfileName", 1, "toString fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvk
 * JD-Core Version:    0.7.0.1
 */