import com.tencent.qphone.base.util.QLog;

final class bkyt
  implements bkju<Boolean, bkjz>
{
  bkyt(bkyu parambkyu) {}
  
  public Void a(Boolean paramBoolean, bkjz parambkjz)
  {
    if (parambkjz.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = parambkjz.jdField_a_of_type_AndroidGraphicsBitmap;
      this.a.jdField_a_of_type_Long = parambkjz.jdField_a_of_type_Long;
      QLog.e(bkyr.a(), 2, "MediaCodecThumbnailGenerator progress " + parambkjz.jdField_a_of_type_Long);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkyt
 * JD-Core Version:    0.7.0.1
 */