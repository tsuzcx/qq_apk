import android.view.animation.AnimationUtils;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class axod
  implements baky
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OutputStream jdField_a_of_type_JavaIoOutputStream;
  String jdField_a_of_type_JavaLangString = "ImageDownloaderProcesser";
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  
  public axod(OutputStream paramOutputStream, URLDrawableHandler paramURLDrawableHandler, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaIoOutputStream = paramOutputStream;
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Int == 0)
    {
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
      byte[] arrayOfByte = new byte[2];
      paramArrayOfByte.get(arrayOfByte);
      paramArrayOfByte = bace.a(arrayOfByte);
      bool1 = bool2;
      if (paramArrayOfByte != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte.length() > 0) {
          if (!paramArrayOfByte.contains(bace.jdField_a_of_type_JavaLangString)) {
            break label112;
          }
        }
      }
    }
    label112:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (!bool1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "verifyPhotofile verify:" + bool1);
        }
        this.jdField_b_of_type_Boolean = true;
        throw new RuntimeException("unKnownFileTypeMark");
      }
      return;
    }
  }
  
  public void a(bakw parambakw1, bakw parambakw2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "decode mHandler.isCancelled:" + this.jdField_a_of_type_ComTencentImageURLDrawableHandler.isCancelled());
      }
      if (this.jdField_a_of_type_ComTencentImageURLDrawableHandler.isCancelled())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(parambakw1);
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.doCancel();
        return;
      }
      if ((parambakw2.c() == 206) || (parambakw2.c() == 200))
      {
        parambakw1 = parambakw2.a();
        a(parambakw1);
        this.jdField_a_of_type_JavaIoOutputStream.write(parambakw1);
        this.jdField_a_of_type_JavaIoOutputStream.flush();
        this.jdField_a_of_type_Int += parambakw1.length;
        this.jdField_a_of_type_Long = parambakw2.a();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "dataLen:" + parambakw1.length + ",totalLen:" + parambakw2.a());
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.jdField_b_of_type_Long > 100L)
        {
          this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int / (float)this.jdField_a_of_type_Long * 8500.0F));
          this.jdField_a_of_type_ComTencentImageURLDrawableHandler.publishProgress(this.jdField_b_of_type_Int);
          return;
        }
      }
    }
    catch (IOException parambakw1)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_JavaLangString = parambakw1.getMessage();
      throw new RuntimeException();
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a(bakw parambakw1, bakw parambakw2, int paramInt)
  {
    return true;
  }
  
  public void b(bakw parambakw1, bakw parambakw2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axod
 * JD-Core Version:    0.7.0.1
 */