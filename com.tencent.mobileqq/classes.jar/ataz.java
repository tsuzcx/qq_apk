import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;

class ataz
  extends atgf
{
  ataz(atat paramatat, SubMsgType0x27.AppointmentNotify paramAppointmentNotify) {}
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      atbp.a("hasOnLinePush", new Object[] { "onNearbyProcStart" });
    }
    atat.a(this.jdField_a_of_type_Atat, 4101, new Object[] { this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x27SubMsgType0x27$AppointmentNotify.toByteArray() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ataz
 * JD-Core Version:    0.7.0.1
 */