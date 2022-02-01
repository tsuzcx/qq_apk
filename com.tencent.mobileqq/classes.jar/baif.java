import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class baif
{
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public baif(baid parambaid, long paramLong, String paramString, Drawable paramDrawable)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public baif a()
  {
    String str;
    boolean bool;
    if (aroa.c().a())
    {
      str = azxs.a(baid.a(this.jdField_a_of_type_Baid), this.jdField_a_of_type_Long) + "dynamicVideo.mp4";
      if (new File(str).exists()) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Baid.b(), 2, String.format("initProfileCardBackground videoPath=%s videoExists=%s", new Object[] { str, Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        if ((baid.a(this.jdField_a_of_type_Baid) != null) && (TextUtils.equals(baid.a(this.jdField_a_of_type_Baid), str)) && (bicd.a(baid.a(this.jdField_a_of_type_Baid))))
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_Baid.b(), 2, "initProfileCardBackground use old video-drawable");
          }
          this.jdField_a_of_type_Boolean = true;
          return this;
          str = this.jdField_a_of_type_JavaLangString + "/video.mp4";
          if (!new File(str).exists()) {
            break label276;
          }
          bool = true;
          continue;
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bicd.a().a(new File(str), true);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          bicd.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
          baid.a(this.jdField_a_of_type_Baid, str);
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_Baid.b(), 2, "initProfileCardBackground use new video-drawable");
          }
        }
      }
      this.jdField_a_of_type_Boolean = false;
      return this;
      label276:
      bool = false;
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baif
 * JD-Core Version:    0.7.0.1
 */