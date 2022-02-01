import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class bafe
  extends baev
{
  public bafe(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiReceiver", 2, "handlePaiYiPaiEffect() called with: bytesValue = [" + paramByteStringMicro + "]");
    }
    short s = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    ((afza)paramQQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).c(s);
  }
  
  private void b(ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiReceiver", 2, "handlePaiYiPaiAction() called with: bytesValue = [" + paramByteStringMicro + "]");
    }
    short s = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    ((afza)paramQQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).b(s);
  }
  
  private void c(ByteStringMicro paramByteStringMicro, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiReceiver", 2, "handlePaiYiPaiSwitch() called with: bytesValue = [" + paramByteStringMicro + "]");
    }
    short s = ByteBuffer.wrap(paramByteStringMicro.toByteArray()).asShortBuffer().get();
    ((afza)paramQQAppInterface.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).a(s);
  }
  
  public void a() {}
  
  public void a(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 42433: 
      c(paramByteStringMicro, this.a);
      return;
    case 42434: 
      b(paramByteStringMicro, this.a);
      return;
    }
    a(paramByteStringMicro, this.a);
  }
  
  public void a(long paramLong) {}
  
  public boolean a(int paramInt)
  {
    return (paramInt == 42433) || (paramInt == 42434) || (paramInt == 27390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafe
 * JD-Core Version:    0.7.0.1
 */