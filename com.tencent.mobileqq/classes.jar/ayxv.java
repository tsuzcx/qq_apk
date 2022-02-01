import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ayxv
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ayxv(ayxu paramayxu, String paramString, File paramFile, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public ayxv a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (aqhy.c().b()))
    {
      String str = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      if ((ayxu.a(this.jdField_a_of_type_Ayxu) != null) && (TextUtils.equals(ayxu.a(this.jdField_a_of_type_Ayxu), str)) && (bgio.a(ayxu.a(this.jdField_a_of_type_Ayxu))))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Ayxu.b(), 2, "initProfileCardBackground: use old etc-drawable");
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bgio.a().a(this.jdField_a_of_type_JavaIoFile, true);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        bgio.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        ayxu.a(this.jdField_a_of_type_Ayxu, str);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Ayxu.b(), 2, "initProfileCardBackground use new etc-drawable");
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
 * Qualified Name:     ayxv
 * JD-Core Version:    0.7.0.1
 */