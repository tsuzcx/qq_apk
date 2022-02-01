import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class baff
  extends baev
{
  public baff(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a() {}
  
  public void a(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt == 42495)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLuckyCharacterReceiver", 2, "get apollo head update push.");
      }
      if (ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get() != 0) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "c2c online push, field id: 42495, changed troopLuckyCharacterSwitch: ", Boolean.valueOf(bool) });
      }
      bfyd.a(this.a, bool);
      return;
    }
  }
  
  public void a(long paramLong) {}
  
  public boolean a(int paramInt)
  {
    return paramInt == 42495;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baff
 * JD-Core Version:    0.7.0.1
 */