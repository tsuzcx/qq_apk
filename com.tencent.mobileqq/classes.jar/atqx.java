import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.pic.CompressInfo;
import java.io.IOException;

public class atqx
  extends atqu
{
  atqx(CompressInfo paramCompressInfo)
  {
    super(paramCompressInfo);
  }
  
  protected int a(CompressInfo paramCompressInfo)
  {
    switch (paramCompressInfo.jdField_g_of_type_Int)
    {
    default: 
      return -1;
    case 0: 
    case 1: 
      return 1;
    }
    return 2;
  }
  
  protected boolean d()
  {
    boolean bool1 = true;
    if (this.k == 1)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Boolean) && (atra.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.f = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + ajjy.a(2131642388));
        atpg.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " compress()", ajjy.a(2131642389));
      }
      for (;;)
      {
        return bool1;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = atra.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
        {
          atpg.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath is empty");
          return false;
        }
        if (bace.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
        {
          atpg.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath exist. return true");
          return true;
        }
        try
        {
          Bitmap localBitmap = bacm.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, null);
          if (localBitmap == null)
          {
            atpg.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " bm == null, maybe is broken");
            return false;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
          atpg.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " decodeFile oom, execute commonCompress()");
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = "";
          return c();
        }
        boolean bool2 = atra.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e, localOutOfMemoryError, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
        if (!JpegExifReader.isCrashJpeg(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)) {}
        try
        {
          if (!bacm.a(new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c), new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))) {
            atpg.b(this.jdField_a_of_type_JavaLangString, "compress()", "Failed to save exif");
          }
          bool1 = bool2;
          if (localOutOfMemoryError != null)
          {
            localOutOfMemoryError.recycle();
            return bool2;
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            atpg.b(this.jdField_a_of_type_JavaLangString, "compress()", "cannot read exif, " + localIOException.getMessage());
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqx
 * JD-Core Version:    0.7.0.1
 */