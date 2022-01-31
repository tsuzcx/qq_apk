import com.tencent.mobileqq.data.LebaPluginInfo;
import java.util.Iterator;
import java.util.List;

public class andx
{
  public byte a;
  public int a;
  public long a;
  public LebaPluginInfo a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  
  public andx()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static String a(List<andx> paramList)
  {
    if (paramList == null) {
      return " print lebaData == null";
    }
    if (paramList.isEmpty()) {
      return " print lebaData.isEmpty()";
    }
    StringBuilder localStringBuilder = new StringBuilder(" print lebaData size = ").append(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      andx localandx = (andx)paramList.next();
      if (localandx == null)
      {
        localStringBuilder.append("|item = null");
      }
      else
      {
        localStringBuilder.append("|item = ").append(localandx.jdField_a_of_type_Long).append("|").append(localandx.jdField_a_of_type_JavaLangString).append("|").append(localandx.jdField_b_of_type_JavaLangString).append("|").append(localandx.jdField_a_of_type_Int).append("|").append(localandx.jdField_a_of_type_Byte).append("|").append(localandx.jdField_b_of_type_Long).append("|").append(localandx.jdField_a_of_type_Boolean).append("|");
        if (localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) {
          localStringBuilder.append("info=null");
        } else {
          localStringBuilder.append(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.toString());
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (this.jdField_a_of_type_Long == 0L)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      if (!(paramObject instanceof andx)) {
        break;
      }
      paramObject = (andx)paramObject;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long);
    return false;
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.jdField_a_of_type_Long).hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     andx
 * JD-Core Version:    0.7.0.1
 */