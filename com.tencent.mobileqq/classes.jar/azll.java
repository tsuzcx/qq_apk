import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.IOException;

public class azll
  extends azli
{
  azll(CompressInfo paramCompressInfo)
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
      if ((this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Boolean) && (azlo.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)))
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.f = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + anvx.a(2131707632));
        azjq.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " compress()", anvx.a(2131707633));
      }
      for (;;)
      {
        return bool1;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = azlo.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_g_of_type_Int);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
        {
          azjq.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath is empty");
          return false;
        }
        if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))
        {
          azjq.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " destPath exist. return true");
          return true;
        }
        try
        {
          Bitmap localBitmap = bheg.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c, null);
          if (localBitmap == null)
          {
            azjq.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " bm == null, maybe is broken");
            return false;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
          azjq.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " decodeFile oom, execute commonCompress()");
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e = "";
          return c();
        }
        boolean bool2 = azlo.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e, localOutOfMemoryError, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
        if (!JpegExifReader.isCrashJpeg(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c)) {}
        try
        {
          if (!bheg.a(new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.c), new ExifInterface(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.e))) {
            azjq.b(this.jdField_a_of_type_JavaLangString, "compress()", "Failed to save exif");
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
            azjq.b(this.jdField_a_of_type_JavaLangString, "compress()", "cannot read exif, " + localIOException.getMessage());
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azll
 * JD-Core Version:    0.7.0.1
 */