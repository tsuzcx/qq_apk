import com.tencent.qqprotect.qsec.QSecPushServiceMgr;

public class amfi
  implements Runnable
{
  public amfi(QSecPushServiceMgr paramQSecPushServiceMgr, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    amfk localamfk = QSecPushServiceMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecPushServiceMgr, this.jdField_a_of_type_ArrayOfByte);
    if (localamfk != null) {
      QSecPushServiceMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecPushServiceMgr, localamfk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amfi
 * JD-Core Version:    0.7.0.1
 */