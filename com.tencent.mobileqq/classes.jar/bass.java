import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bass
{
  static String[] a;
  static String[] b;
  private static String[] d;
  public static String w = "defaultTag";
  public static String y = "richfile";
  public String A;
  public int a;
  public long a;
  public barf a;
  public bast a;
  public basu a;
  public File a;
  public InputStream a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public bast b;
  public basu b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public bast c;
  public String c;
  public String[] c;
  public int d;
  public long d;
  public String d;
  public int e;
  public long e;
  public String e;
  public int f;
  public long f;
  public String f;
  public int g;
  public long g;
  public String g;
  public int h = -1;
  public long h;
  public String h;
  public int i;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s = "";
  public String t = "";
  public String u;
  public String v = "";
  public String x = w;
  public String z = "";
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "up", "down", "down" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "file", "pic", "ptt", "video", "map", "thumbpic", "emo", "multimsg" };
    jdField_d_of_type_ArrayOfJavaLangString = new String[] { "LogEventSignalSigFinish", "LogEventSignalUrlFinish", "LogEventRetry", "LogEventFlowUp", "LogEventFlowDown" };
  }
  
  public bass()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bast = new bast();
    this.jdField_b_of_type_Bast = new bast();
    this.jdField_c_of_type_Bast = new bast();
    this.jdField_a_of_type_Basu = new basu();
    this.jdField_b_of_type_Basu = new basu();
    this.jdField_g_of_type_Long = System.currentTimeMillis();
  }
  
  public bass(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bast = new bast();
    this.jdField_b_of_type_Bast = new bast();
    this.jdField_c_of_type_Bast = new bast();
    this.jdField_a_of_type_Basu = new basu();
    this.jdField_b_of_type_Basu = new basu();
    try
    {
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      this.p = paramString1;
      this.jdField_a_of_type_Int = paramInt;
      if (paramString2 == null) {
        return;
      }
      if (paramInt == 0)
      {
        this.jdField_c_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_JavaIoFile = new File(this.jdField_c_of_type_JavaLangString);
        if (this.jdField_a_of_type_JavaIoFile.exists())
        {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
          paramInt = paramString2.lastIndexOf(".");
          if ((paramInt >= 0) && (paramInt < paramString2.length())) {
            this.jdField_b_of_type_JavaLangString = paramString2.substring(paramInt).toLowerCase();
          }
        }
        a(paramString2);
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    this.jdField_g_of_type_JavaLangString = paramString2;
  }
  
  public static String a()
  {
    try
    {
      Thread.sleep(10L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(paramString);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoInputStream != null) {
        this.jdField_a_of_type_JavaIoInputStream.close();
      }
      label14:
      this.jdField_a_of_type_JavaIoInputStream = null;
      return;
    }
    catch (IOException localIOException)
    {
      break label14;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    basu localbasu;
    switch (paramInt1)
    {
    default: 
      return;
    case 2: 
      localbasu = this.jdField_a_of_type_Basu;
      localbasu.jdField_b_of_type_Int += 1;
      return;
    case 4: 
      localbasu = this.jdField_a_of_type_Basu;
      localbasu.e += paramInt2;
      return;
    case 3: 
      localbasu = this.jdField_a_of_type_Basu;
      localbasu.d += paramInt2;
      return;
    }
    this.jdField_a_of_type_Basu.c = true;
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bass
 * JD-Core Version:    0.7.0.1
 */