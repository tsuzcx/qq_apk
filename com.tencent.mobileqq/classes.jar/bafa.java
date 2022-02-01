import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;

public class bafa
  extends baeu
{
  public bafa(QQAppInterface paramQQAppInterface, baew parambaew)
  {
    super(paramQQAppInterface, parambaew);
  }
  
  public String a()
  {
    return "TroopLuckyCharacterProcessor";
  }
  
  public void a(boolean paramBoolean, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    boolean bool = paramUdcUinData.uint32_troop_lucky_character_switch.has();
    if (bool) {
      if (paramUdcUinData.uint32_troop_lucky_character_switch.get() == 0) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLuckyCharacterProcessor", 2, String.format("handleGetProfileInfoForLogin hasLuckyCharacterSwitch=%s luckyCharacterSwitch=%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) }));
      }
      bfyd.a(this.a, paramBoolean);
      return;
      paramBoolean = false;
      continue;
      paramBoolean = true;
    }
  }
  
  public boolean a(oidb_0x5eb.ReqBody paramReqBody)
  {
    paramReqBody.uint32_troop_lucky_character_switch.set(1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafa
 * JD-Core Version:    0.7.0.1
 */