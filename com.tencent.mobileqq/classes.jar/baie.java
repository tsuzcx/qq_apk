import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class baie
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public baie(baid parambaid, String paramString, File paramFile, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public baie a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (aroa.c().b()))
    {
      String str = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      if ((baid.a(this.jdField_a_of_type_Baid) != null) && (TextUtils.equals(baid.a(this.jdField_a_of_type_Baid), str)) && (bicd.a(baid.a(this.jdField_a_of_type_Baid))))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Baid.b(), 2, "initProfileCardBackground: use old etc-drawable");
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bicd.a().a(this.jdField_a_of_type_JavaIoFile, true);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        bicd.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        baid.a(this.jdField_a_of_type_Baid, str);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Baid.b(), 2, "initProfileCardBackground use new etc-drawable");
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
 * Qualified Name:     baie
 * JD-Core Version:    0.7.0.1
 */