import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class azpo
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public azpo(azpn paramazpn, String paramString, File paramFile, Drawable paramDrawable)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public azpo a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (aqyj.c().b()))
    {
      String str = this.jdField_a_of_type_JavaIoFile.getAbsolutePath();
      if ((azpn.a(this.jdField_a_of_type_Azpn) != null) && (TextUtils.equals(azpn.a(this.jdField_a_of_type_Azpn), str)) && (bhbt.a(azpn.a(this.jdField_a_of_type_Azpn))))
      {
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Azpn.b(), 2, "initProfileCardBackground: use old etc-drawable");
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bhbt.a().a(this.jdField_a_of_type_JavaIoFile, true);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        bhbt.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        azpn.a(this.jdField_a_of_type_Azpn, str);
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_Azpn.b(), 2, "initProfileCardBackground use new etc-drawable");
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
 * Qualified Name:     azpo
 * JD-Core Version:    0.7.0.1
 */