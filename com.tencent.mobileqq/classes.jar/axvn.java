public class axvn
{
  public static int d;
  public static int e;
  public static int f;
  public int a;
  public long a;
  public Object a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  static
  {
    jdField_e_of_type_Int = jdField_d_of_type_Int + 1;
    jdField_f_of_type_Int = 10;
  }
  
  public static String a(String paramString1, long paramLong, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, int paramInt3)
  {
    return axwb.a(paramString1, paramLong, paramInt1, paramBoolean, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramInt2, paramInt3);
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if ((paramString != null) && (paramString.length() > 0) && (paramString.charAt(0) == '\026'))
    {
      localObject = paramString.split("\\|");
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          if ((localObject[i] != null) && (localObject[i].equals("null"))) {
            localObject[i] = null;
          }
          i += 1;
        }
        if (localObject.length >= 1) {
          this.jdField_a_of_type_JavaLangString = localObject[0].trim();
        }
        if (localObject.length < 2) {}
      }
    }
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(localObject[1]);
      if (localObject.length < 3) {}
    }
    catch (NumberFormatException localException3)
    {
      try
      {
        this.jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
        if (localObject.length < 4) {}
      }
      catch (NumberFormatException localException3)
      {
        try
        {
          this.jdField_a_of_type_Boolean = Boolean.parseBoolean(localObject[3]);
          if (localObject.length >= 5) {
            this.jdField_b_of_type_JavaLangString = localObject[4];
          }
          if (localObject.length >= 6) {
            this.jdField_c_of_type_JavaLangString = localObject[5];
          }
          if (localObject.length >= 7) {
            this.jdField_d_of_type_JavaLangString = localObject[6];
          }
          if (localObject.length >= 8) {
            this.jdField_e_of_type_JavaLangString = localObject[7];
          }
          if (localObject.length >= 9) {
            this.jdField_f_of_type_JavaLangString = localObject[8];
          }
          if (localObject.length >= 10) {
            this.g = localObject[9];
          }
          if (localObject.length < 11) {}
        }
        catch (Exception localException3)
        {
          try
          {
            this.jdField_b_of_type_Int = Integer.parseInt(localObject[10]);
            if (localObject.length < 12) {}
          }
          catch (Exception localException3)
          {
            try
            {
              for (;;)
              {
                this.jdField_c_of_type_Int = Integer.parseInt(localObject[11]);
                if (this.jdField_c_of_type_Int == jdField_f_of_type_Int)
                {
                  localObject = new axsx();
                  ((axsx)localObject).a(paramString);
                  this.jdField_a_of_type_JavaLangObject = localObject;
                }
                return;
                localNumberFormatException1 = localNumberFormatException1;
                this.jdField_a_of_type_Long = 0L;
                localNumberFormatException1.printStackTrace();
                continue;
                localNumberFormatException2 = localNumberFormatException2;
                this.jdField_a_of_type_Int = 0;
                localNumberFormatException2.printStackTrace();
                continue;
                localException2 = localException2;
                this.jdField_a_of_type_Boolean = false;
                localException2.printStackTrace();
              }
              localException3 = localException3;
              this.jdField_b_of_type_Int = 0;
              localException3.printStackTrace();
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                this.jdField_c_of_type_Int = 0;
                localException1.printStackTrace();
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axvn
 * JD-Core Version:    0.7.0.1
 */