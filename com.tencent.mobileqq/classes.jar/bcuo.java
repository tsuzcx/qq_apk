import java.util.ArrayList;
import java.util.List;

public class bcuo
{
  public final bcun a;
  public final List<bcun> a;
  
  public bcuo()
  {
    this.jdField_a_of_type_Bcun = new bcun();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a(bcuo parambcuo)
  {
    int j;
    int i;
    label22:
    int k;
    if (parambcuo != null) {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        j = 0;
        if (parambcuo.jdField_a_of_type_JavaUtilList != null) {
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
        if (bdal.a((bcun)this.jdField_a_of_type_JavaUtilList.get(k), (bcun)parambcuo.jdField_a_of_type_JavaUtilList.get(k))) {
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
      i = parambcuo.jdField_a_of_type_JavaUtilList.size();
      break label22;
      label113:
      if (i != 0) {
        i = 0;
      }
      while (bdal.a(parambcuo.jdField_a_of_type_Bcun, this.jdField_a_of_type_Bcun)) {
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
    bcuo localbcuo = new bcuo();
    localbcuo.jdField_a_of_type_Bcun.a(this.jdField_a_of_type_Bcun);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      bcun localbcun = (bcun)this.jdField_a_of_type_JavaUtilList.get(i);
      localbcuo.jdField_a_of_type_JavaUtilList.add((bcun)localbcun.clone());
      i += 1;
    }
    return localbcuo;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    int j;
    if ((paramObject instanceof bcuo))
    {
      paramObject = (bcuo)paramObject;
      bool1 = bool2;
      if (bdal.a(paramObject.jdField_a_of_type_Bcun, this.jdField_a_of_type_Bcun)) {
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
          if (bdal.a((bcun)this.jdField_a_of_type_JavaUtilList.get(j), (bcun)paramObject.jdField_a_of_type_JavaUtilList.get(j))) {
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
    localStringBuilder.append("[head]").append("type = ").append(this.jdField_a_of_type_Bcun.jdField_a_of_type_Int).append(", value = ").append(bdal.b(this.jdField_a_of_type_Bcun.jdField_a_of_type_JavaLangString)).append("\r\n");
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (Object localObject = null;; localObject = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()))
    {
      int j = ((Integer)localObject).intValue();
      int i = 0;
      while (i < j)
      {
        localObject = (bcun)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject != null) {
          localStringBuilder.append("[more item]").append("type = ").append(((bcun)localObject).jdField_a_of_type_Int).append(", value = ").append(bdal.b(((bcun)localObject).jdField_a_of_type_JavaLangString)).append("\r\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcuo
 * JD-Core Version:    0.7.0.1
 */