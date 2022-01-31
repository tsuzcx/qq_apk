import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class bdtd
{
  public static HashMap<String, bdtf> a;
  private static HashMap<Integer, String> b;
  public bdte a;
  public String a;
  public ArrayList<Object> a;
  public String b;
  public ArrayList<Object> b;
  public ArrayList<Object> c;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100001), "emoji");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100003), "bubble");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100002), "theme");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100011), "font");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100006), "pendant");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100012), "card");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100019), "call");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100020), "suit");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100021), "background");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100018), "ring");
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(100028), "hongbao");
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("1", new bdtf(2, true, 1, 1));
    jdField_a_of_type_JavaUtilHashMap.put("2", new bdtf(2, false, 1, 2));
    jdField_a_of_type_JavaUtilHashMap.put("3", new bdtf(3, true, 2, 3));
    jdField_a_of_type_JavaUtilHashMap.put("4", new bdtf(3, true, 1, 4));
    jdField_a_of_type_JavaUtilHashMap.put("5", new bdtf(3, true, 1, 5));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
    } while ((paramString1 == null) || (paramString2 == null));
    int m = Math.max(paramString1.length, paramString2.length);
    int k = 0;
    label50:
    if (k < m) {
      if (k >= paramString1.length) {
        break label150;
      }
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramString1[k]);
        if (k >= paramString2.length) {
          break label145;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          j = Integer.parseInt(paramString2[k]);
          if (k == m - 1) {
            break label131;
          }
          if (j > i)
          {
            return true;
            localException1 = localException1;
            i = 0;
          }
        }
        catch (Exception localException2)
        {
          j = 0;
          continue;
        }
      }
      if (j < i) {
        break;
      }
      label131:
      do
      {
        k += 1;
        break label50;
        break;
        if (j >= i) {
          return true;
        }
      } while (j >= i);
      return false;
      label145:
      int j = 0;
      continue;
      label150:
      int i = 0;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IndividuationConfigInfo: ").append("backgroudImgUrl=").append(this.jdField_a_of_type_JavaLangString).append("\r\n").append("pullBgColor=").append(this.jdField_b_of_type_JavaLangString).append("\r\n").append("bannerConfig=").append(this.jdField_a_of_type_Bdte).append("\r\n").append("activityConfigs=").append(this.jdField_a_of_type_JavaUtilArrayList).append("\r\n").append("recommendConfigs=").append(this.jdField_b_of_type_JavaUtilArrayList).append("\r\n").append("shapedImgConfigs=").append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtd
 * JD-Core Version:    0.7.0.1
 */