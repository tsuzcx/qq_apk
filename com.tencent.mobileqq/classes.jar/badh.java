import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class badh
{
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public badh(badf parambadf, long paramLong, String paramString, Drawable paramDrawable)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public badh a()
  {
    String str;
    boolean bool;
    if (arli.c().a())
    {
      str = azrc.a(badf.a(this.jdField_a_of_type_Badf), this.jdField_a_of_type_Long) + "dynamicVideo.mp4";
      if (new File(str).exists()) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Badf.b(), 2, String.format("initProfileCardBackground videoPath=%s videoExists=%s", new Object[] { str, Boolean.valueOf(bool) }));
      }
      if (bool)
      {
        if ((badf.a(this.jdField_a_of_type_Badf) != null) && (TextUtils.equals(badf.a(this.jdField_a_of_type_Badf), str)) && (bhrj.a(badf.a(this.jdField_a_of_type_Badf))))
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_Badf.b(), 2, "initProfileCardBackground use old video-drawable");
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
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bhrj.a().a(new File(str), true);
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          bhrj.a().a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
          badf.a(this.jdField_a_of_type_Badf, str);
          if (QLog.isColorLevel()) {
            QLog.i(this.jdField_a_of_type_Badf.b(), 2, "initProfileCardBackground use new video-drawable");
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
 * Qualified Name:     badh
 * JD-Core Version:    0.7.0.1
 */