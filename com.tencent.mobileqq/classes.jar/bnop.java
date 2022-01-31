import com.tencent.qphone.base.util.QLog;

final class bnop
  implements bmzq<Boolean, bmzv>
{
  bnop(bnoq parambnoq) {}
  
  public Void a(Boolean paramBoolean, bmzv parambmzv)
  {
    if (parambmzv.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = parambmzv.jdField_a_of_type_AndroidGraphicsBitmap;
      this.a.jdField_a_of_type_Long = parambmzv.jdField_a_of_type_Long;
      QLog.e(bnon.a(), 2, "MediaCodecThumbnailGenerator progress " + parambmzv.jdField_a_of_type_Long);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnop
 * JD-Core Version:    0.7.0.1
 */