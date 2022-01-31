import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.pic.CompressInfo;
import java.io.IOException;

public class awko
  extends awkl
{
  awko(CompressInfo paramCompressInfo)
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
      if ((this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Boolean) && (awkr.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.f = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + alud.a(2131708568));
        awiw.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " compress()", alud.a(2131708569));
      }
      for (;;)
      {
        return bool1;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = awkr.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
        {
          awiw.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath is empty");
          return false;
        }
        if (bdhb.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
        {
          awiw.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath exist. return true");
          return true;
        }
        try
        {
          Bitmap localBitmap = bdhj.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, null);
          if (localBitmap == null)
          {
            awiw.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " bm == null, maybe is broken");
            return false;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
          awiw.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " decodeFile oom, execute commonCompress()");
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = "";
          return c();
        }
        boolean bool2 = awkr.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e, localOutOfMemoryError, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
        if (!JpegExifReader.isCrashJpeg(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)) {}
        try
        {
          if (!bdhj.a(new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c), new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))) {
            awiw.b(this.jdField_a_of_type_JavaLangString, "compress()", "Failed to save exif");
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
            awiw.b(this.jdField_a_of_type_JavaLangString, "compress()", "cannot read exif, " + localIOException.getMessage());
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awko
 * JD-Core Version:    0.7.0.1
 */