import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class badg
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public badg(badf parambadf, String paramString, File paramFile, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public badg a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (arli.c().b()))
    {
      String str = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      if ((badf.a(this.jdField_a_of_type_Badf) != null) && (TextUtils.equals(badf.a(this.jdField_a_of_type_Badf), str)) && (bhrj.a(badf.a(this.jdField_a_of_type_Badf))))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Badf.b(), 2, "initProfileCardBackground: use old etc-drawable");
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bhrj.a().a(this.jdField_a_of_type_JavaIoFile, true);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        bhrj.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        badf.a(this.jdField_a_of_type_Badf, str);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Badf.b(), 2, "initProfileCardBackground use new etc-drawable");
        }
      }
    }
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badg
 * JD-Core Version:    0.7.0.1
 */