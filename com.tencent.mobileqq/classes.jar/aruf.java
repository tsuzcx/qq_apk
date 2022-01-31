import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class aruf
{
  public static String b;
  protected int a;
  protected Object a;
  protected int b;
  protected long b;
  protected Object b;
  protected int c;
  protected final long c;
  protected Object c;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  static
  {
    jdField_b_of_type_JavaLangString = "UniformDownloaderAssinfo<FileAssistant>";
  }
  
  public aruf(long paramLong)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public int a(String paramString, Bundle paramBundle)
  {
    if (a()) {
      return 0;
    }
    if ((paramString == null) || (paramBundle == null)) {
      try
      {
        QLog.e(jdField_b_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "]. init param error");
        return -1;
      }
      finally {}
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    this.e = paramBundle.getString("_PARAM_FILEPATH");
    this.f = paramBundle.getString("_PARAM_TMP_FILEPATH");
    this.d = paramBundle.getString("_PARAM_FILENAME");
    this.jdField_b_of_type_Long = paramBundle.getLong("_PARAM_FILESIZE");
    this.g = paramBundle.getString("_PARAM_COOKIE");
    QLog.i(jdField_b_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] init. ST:" + e() + " PGR:" + h());
    c(1);
    return 0;
  }
  
  protected void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  protected boolean a()
  {
    return e() >= 1;
  }
  
  protected void b(int paramInt)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_Int = paramInt;
      return;
    }
  }
  
  protected void c(int paramInt)
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      QLog.i(jdField_b_of_type_JavaLangString, 1, "[UniformDL][" + this.jdField_c_of_type_Long + "] setStatus. " + this.jdField_c_of_type_Int + "->" + paramInt);
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
  }
  
  public int e()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      int i = this.jdField_c_of_type_Int;
      return i;
    }
  }
  
  protected int g()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      int i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public int h()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      int i = this.jdField_b_of_type_Int;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruf
 * JD-Core Version:    0.7.0.1
 */