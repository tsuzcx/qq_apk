import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class ariu
  implements arkl
{
  protected int a;
  protected arhz a;
  protected String a;
  protected int b;
  protected String b;
  protected int c;
  
  public ariu(arhz paramarhz)
  {
    this.jdField_a_of_type_Arhz = paramarhz;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = -1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public arhz a()
  {
    return this.jdField_a_of_type_Arhz;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public URL a()
  {
    String str = this.jdField_a_of_type_Arhz.f();
    if (TextUtils.isEmpty(str))
    {
      str = this.jdField_a_of_type_Arhz.h();
      if (str == null)
      {
        a(1);
        return null;
      }
      this.jdField_a_of_type_Int = 2;
    }
    while (arso.b(str)) {
      if (this.jdField_a_of_type_Int == 1)
      {
        return AsyncImageView.a(str);
        this.jdField_a_of_type_Int = 1;
      }
      else
      {
        return AsyncImageView.a(str, -1, -1, new File(str), false, false, false);
      }
    }
    a(1);
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Arhz.a(paramString);
    }
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (this.jdField_a_of_type_Arhz == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    } while (localFileManagerEntity == null);
    if (localFileManagerEntity.isZipInnerFile)
    {
      if (localFileManagerEntity.status == 2) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
    if (this.jdField_b_of_type_Int == 1) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Arhz.a() != null) && (this.jdField_a_of_type_Arhz.a().isZipInnerFile)) {
      return paramString.equalsIgnoreCase(String.valueOf(this.jdField_a_of_type_Arhz.a()));
    }
    return (paramString.equalsIgnoreCase(this.jdField_a_of_type_Arhz.c())) || (paramString.equalsIgnoreCase(this.jdField_a_of_type_Arhz.e()));
  }
  
  public int b()
  {
    if (this.c == -1) {}
    try
    {
      String str = this.jdField_a_of_type_Arhz.f();
      if (arso.b(str))
      {
        this.c = JpegExifReader.readOrientation(str);
        return this.c;
      }
      return 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.c = 0;
      }
    }
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_Arhz.f();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.equals("")) {}
    }
    else
    {
      str1 = this.jdField_a_of_type_Arhz.h();
      if (str1 != null) {
        break label44;
      }
      str1 = "";
    }
    return str1;
    label44:
    this.jdField_a_of_type_Int = 2;
    return str1;
  }
  
  public void b(String paramString)
  {
    if (arso.b(paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("DefaultImageInfo", 2, "setImageOriginPath error  : can not find origin file [path] =  " + paramString);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Arhz.b() < arbp.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ariu
 * JD-Core Version:    0.7.0.1
 */