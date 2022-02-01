import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;

public class bafc
  extends baev
{
  public bafc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a() {}
  
  public void a(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    if (paramInt == 27393)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CallPushReceiver", 2, "call_push ok");
      }
      ((bibs)this.a.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER)).a(1, new Bundle(), true);
    }
  }
  
  public void a(long paramLong) {}
  
  public boolean a(int paramInt)
  {
    return paramInt == 27393;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafc
 * JD-Core Version:    0.7.0.1
 */