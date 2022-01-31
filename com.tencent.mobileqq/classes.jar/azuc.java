import java.util.ArrayList;
import java.util.List;

public class azuc
{
  public final azub a;
  public final List<azub> a;
  
  public azuc()
  {
    this.jdField_a_of_type_Azub = new azub();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a(azuc paramazuc)
  {
    int j;
    int i;
    label22:
    int k;
    if (paramazuc != null) {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        j = 0;
        if (paramazuc.jdField_a_of_type_JavaUtilList != null) {
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
        if (azzz.a((azub)this.jdField_a_of_type_JavaUtilList.get(k), (azub)paramazuc.jdField_a_of_type_JavaUtilList.get(k))) {
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
      i = paramazuc.jdField_a_of_type_JavaUtilList.size();
      break label22;
      label113:
      if (i != 0) {
        i = 0;
      }
      while (azzz.a(paramazuc.jdField_a_of_type_Azub, this.jdField_a_of_type_Azub)) {
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
    azuc localazuc = new azuc();
    localazuc.jdField_a_of_type_Azub.a(this.jdField_a_of_type_Azub);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      azub localazub = (azub)this.jdField_a_of_type_JavaUtilList.get(i);
      localazuc.jdField_a_of_type_JavaUtilList.add((azub)localazub.clone());
      i += 1;
    }
    return localazuc;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int j;
    if ((paramObject instanceof azuc))
    {
      paramObject = (azuc)paramObject;
      bool1 = bool2;
      if (azzz.a(paramObject.jdField_a_of_type_Azub, this.jdField_a_of_type_Azub)) {
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
          if (azzz.a((azub)this.jdField_a_of_type_JavaUtilList.get(j), (azub)paramObject.jdField_a_of_type_JavaUtilList.get(j))) {
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[head]").append("type = ").append(this.jdField_a_of_type_Azub.jdField_a_of_type_Int).append(", value = ").append(azzz.b(this.jdField_a_of_type_Azub.jdField_a_of_type_JavaLangString)).append("\r\n");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()))
    {
      int j = ((Integer)localObject).intValue();
      int i = 0;
      while (i < j)
      {
        localObject = (azub)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject != null) {
          localStringBuilder.append("[more item]").append("type = ").append(((azub)localObject).jdField_a_of_type_Int).append(", value = ").append(azzz.b(((azub)localObject).jdField_a_of_type_JavaLangString)).append("\r\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azuc
 * JD-Core Version:    0.7.0.1
 */