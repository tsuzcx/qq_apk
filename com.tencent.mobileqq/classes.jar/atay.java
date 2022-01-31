import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class atay
{
  public static HashMap<Integer, Integer> a;
  public int a;
  public String a;
  public List<String> a;
  public int b;
  public int c;
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), Integer.valueOf(40));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), Integer.valueOf(60));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), Integer.valueOf(80));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1), Integer.valueOf(100));
  }
  
  public atay()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public void a(int paramInt)
  {
    if (((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue() < ((Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int))).intValue()) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    try
    {
      int j = Integer.valueOf(paramString).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("NearbyRedInfo", 1, localNumberFormatException, new Object[0]);
        this.jdField_a_of_type_JavaLangString = paramString;
      }
    }
    this.b = (i + this.b);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b(int paramInt)
  {
    this.b += paramInt;
  }
  
  public String toString()
  {
    return "[redType=" + this.jdField_a_of_type_Int + ", redNum=" + this.b + ", redTxt=" + this.jdField_a_of_type_JavaLangString + ", redAppIdType=" + this.d + ", url=" + this.jdField_a_of_type_JavaUtilList + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atay
 * JD-Core Version:    0.7.0.1
 */