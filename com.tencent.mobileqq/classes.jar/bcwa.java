import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController.1.1;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x962.oidb_0x962.RspBody;

public class bcwa
  extends bcoc
{
  public bcwa(TroopInteractGiftAnimationController.1.1 param1) {}
  
  public void a(int paramInt, oidb_0x962.RspBody paramRspBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInteractGiftAnimationController", 2, "startInteract: errorCode = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcwa
 * JD-Core Version:    0.7.0.1
 */