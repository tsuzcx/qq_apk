import com.tencent.mobileqq.magicface.DecoderUtil;
import com.tencent.mobileqq.magicface.model.MagicFaceSuperBigDecoder.1;
import com.tencent.qphone.base.util.QLog;

public class atyh
  extends atyn
{
  private Runnable a;
  
  public atyh()
  {
    this.jdField_a_of_type_JavaLangRunnable = new MagicFaceSuperBigDecoder.1(this);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func MagicFaceSuperBigDecoder [Constructor] begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = new DecoderUtil();
    int i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createVideoDecoder();
    int j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.createAlphaDecoder();
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func MagicFaceSuperBigDecoder [Constructor] ends, videoRet:" + i + ",alphaRet:" + j);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder begins");
    }
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Atyj.b;
    if (this.jdField_a_of_type_ArrayOfByte == null) {}
    do
    {
      do
      {
        return;
        this.d = this.jdField_a_of_type_Atyj.jdField_a_of_type_ArrayOfByte;
      } while (this.d == null);
      b();
      this.jdField_a_of_type_JavaLangRunnable.run();
    } while (!QLog.isColorLevel());
    QLog.d("MagicFaceSuperBigDecoder", 2, "func maigcfaceDecoder ends");
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig begins");
    }
    try
    {
      this.c = new byte[817920];
      this.f = new byte[817920];
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceSuperBigDecoder", 2, "func initXbig ends");
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceSuperBigDecoder", 2, "func release begins.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseAlphaDecoder();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil.releaseVideoDecoder();
      label37:
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceDecoderUtil = null;
      super.c();
      if (QLog.isColorLevel()) {
        QLog.d("MagicFaceSuperBigDecoder", 2, "func release ends.");
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atyh
 * JD-Core Version:    0.7.0.1
 */