import android.text.TextUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import java.io.File;
import java.net.HttpURLConnection;

public class arul
{
  public final int a;
  public final File a;
  public final String a;
  public HttpURLConnection a;
  public boolean a;
  public byte[] a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f = "";
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public arul(String paramString, File paramFile, int paramInt)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(HttpDownloadUtil.jdField_a_of_type_JavaLangString))) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + ".tmp";
  }
  
  public void a()
  {
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_Int = -1;
    this.jdField_e_of_type_Int = 0;
    this.h = null;
    this.i = null;
    this.g = null;
    this.k = null;
    this.j = null;
    this.d = null;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arul
 * JD-Core Version:    0.7.0.1
 */