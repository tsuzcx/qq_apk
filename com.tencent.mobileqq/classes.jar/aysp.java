import android.text.TextUtils;

public class aysp
{
  public double a;
  public int a;
  public long a;
  public String a;
  public double b;
  public String b;
  public double c;
  public String c;
  
  public aysp(double paramDouble1, double paramDouble2, String paramString1, String paramString2)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Double = paramDouble1;
    this.jdField_b_of_type_Double = paramDouble2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    if (a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, paramString2))
    {
      this.jdField_a_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2)
  {
    return (Math.abs(paramDouble1) > 0.0001D) && (Math.abs(paramDouble1) > 0.0001D);
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, String paramString)
  {
    return (Math.abs(paramDouble1) > 0.0001D) && (Math.abs(paramDouble2) > 0.0001D) && (!TextUtils.isEmpty(paramString));
  }
  
  public static boolean a(aysp paramaysp, double paramDouble1, double paramDouble2, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramaysp == null) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramString == null);
          if (!paramString.equals(paramaysp.jdField_c_of_type_JavaLangString)) {
            return true;
          }
          bool1 = bool2;
        } while (Math.abs(paramDouble1) < 0.0001D);
        bool1 = bool2;
      } while (Math.abs(paramDouble2) < 0.0001D);
      if (Math.abs(paramaysp.jdField_a_of_type_Double - paramDouble1) > 0.001D) {
        break;
      }
      bool1 = bool2;
    } while (Math.abs(paramaysp.jdField_b_of_type_Double - paramDouble2) <= 0.001D);
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("mLatitude:").append(this.jdField_a_of_type_Double);
    localStringBuilder.append(" mLongitude:").append(this.jdField_b_of_type_Double);
    localStringBuilder.append(" mDirection:").append(this.jdField_c_of_type_Double);
    localStringBuilder.append(" mPoiName:").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mPoiAddr:").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" adCode:").append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(" mUpdateTime:").append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mValidFlag:").append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysp
 * JD-Core Version:    0.7.0.1
 */