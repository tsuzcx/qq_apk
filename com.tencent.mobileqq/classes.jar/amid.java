public class amid
{
  public static int a;
  public static long a;
  public static String a;
  public static int b;
  public static String b;
  public static int c;
  public static String c;
  public static int d;
  public static String d;
  public static int e;
  public static String e;
  public static int f;
  public static int g;
  public static int h;
  public static int i;
  public static int j;
  public static int k;
  public static int l;
  public static int m;
  public static int n;
  public static int o;
  
  static
  {
    jdField_a_of_type_JavaLangString = "sp_msglrucache";
    jdField_b_of_type_JavaLangString = "sp_key_msglrucache_switch";
    jdField_c_of_type_JavaLangString = "sp_key_cacheinitadjust_switch";
    jdField_d_of_type_JavaLangString = "sp_key_report_aio_last_time";
    jdField_a_of_type_Int = 1600;
    jdField_b_of_type_Int = 1400;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = 2;
    jdField_e_of_type_Int = 40;
    f = 20;
    g = 10;
    i = 5;
    j = -1;
    k = 2;
    l = 1;
    m = 1;
    jdField_e_of_type_JavaLangString = "msglrucacheMoniterLogin";
    n = 100;
    o = 10;
    jdField_a_of_type_Long = 60000L;
  }
  
  public static int a(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.contains("&"))
        {
          paramString = paramString.split("&");
          if (paramString.length >= 2)
          {
            int i1 = Integer.valueOf(paramString[1]).intValue();
            return i1;
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("&")) {
        str = paramString.split("&")[0];
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amid
 * JD-Core Version:    0.7.0.1
 */