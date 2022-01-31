import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class beht
  implements behy<oidb_0x8ed.RspBody>
{
  beht(behr parambehr, behy parambehy) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    if (paramInt == 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WerewolvesHandler", 2, "startAnotherRound, quitFailed: errorCode :" + paramInt);
    }
    this.jdField_a_of_type_Behy.a(-1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beht
 * JD-Core Version:    0.7.0.1
 */