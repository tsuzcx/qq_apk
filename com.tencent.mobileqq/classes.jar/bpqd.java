import com.tencent.qphone.base.util.QLog;

final class bpqd
  implements bpdr<Boolean, bpdw>
{
  bpqd(bpqe parambpqe) {}
  
  public Void a(Boolean paramBoolean, bpdw parambpdw)
  {
    if (parambpdw.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = parambpdw.jdField_a_of_type_AndroidGraphicsBitmap;
      this.a.jdField_a_of_type_Long = parambpdw.jdField_a_of_type_Long;
      QLog.e(bpqb.a(), 2, "MediaCodecThumbnailGenerator progress " + parambpdw.jdField_a_of_type_Long);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqd
 * JD-Core Version:    0.7.0.1
 */