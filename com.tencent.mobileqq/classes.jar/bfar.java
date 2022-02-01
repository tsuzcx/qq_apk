import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract class bfar
  extends bfae
{
  public void a(bevy parambevy, bevx parambevx)
  {
    FromServiceMsg localFromServiceMsg = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bfau localbfau = (bfau)parambevx.a;
    bfbj localbfbj = localbfau.a;
    aock localaock = parambevy.jdField_a_of_type_Aock;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      int i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject = MessageHandler.a(localFromServiceMsg);
        parambevx = localFromServiceMsg.getBusinessFailMsg();
        parambevy = parambevx;
        if (parambevx == null) {
          parambevy = "";
        }
        a(-1, 9311, (String)localObject, parambevy, localaock, localbfbj.a);
      }
    }
    for (;;)
    {
      bfca.a(localbfau, localbfbj);
      return;
      localObject = MessageHandler.a(localFromServiceMsg);
      parambevx = localFromServiceMsg.getBusinessFailMsg();
      parambevy = parambevx;
      if (parambevx == null) {
        parambevy = "";
      }
      a(-1, 9044, (String)localObject, parambevy, localaock, localbfbj.a);
      continue;
      a(parambevy, parambevx, localFromServiceMsg, (byte[])localObject, localbfau, localbfbj, localaock);
    }
  }
  
  protected abstract void a(bevy parambevy, bevx parambevx, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bfau parambfau, bfbj parambfbj, aock paramaock);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfar
 * JD-Core Version:    0.7.0.1
 */