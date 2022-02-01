import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ayzq
  extends ayzk
{
  public ayzq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a() {}
  
  public void a(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("KidModeReceiver", 2, "handler push fot theme switch");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("KidModeReceiver", 2, "handler push fot setting change");
      }
      paramByteStringMicro = (amov)this.a.getBusinessHandler(2);
    } while (paramByteStringMicro == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)paramInt));
    paramByteStringMicro.a(localArrayList, null);
  }
  
  public void a(long paramLong) {}
  
  public boolean a(int paramInt)
  {
    return (paramInt == 42362) || (paramInt == 42432) || (paramInt == 42285) || (paramInt == 42490) || (paramInt == 42430) || (paramInt == 42429) || (paramInt == 42428) || (paramInt == 42482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzq
 * JD-Core Version:    0.7.0.1
 */