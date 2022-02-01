import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract class bfas
  extends bfae
{
  public void a(bevy parambevy, bevx parambevx)
  {
    FromServiceMsg localFromServiceMsg = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bfau localbfau = (bfau)parambevx.a;
    bfbj localbfbj = localbfau.a;
    aock localaock = parambevy.jdField_a_of_type_Aock;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      parambevy = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((parambevy.equals("conSucc")) || (parambevy.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(localFromServiceMsg);
          parambevx = localFromServiceMsg.getBusinessFailMsg();
          parambevy = parambevx;
          if (parambevx == null) {
            parambevy = "";
          }
          a(-1, 9311, (String)localObject, parambevy, localaock, localbfbj.a);
        }
      }
    }
    for (;;)
    {
      bfca.a(localbfau, localbfbj);
      return;
      parambevx = localFromServiceMsg.getBusinessFailMsg();
      parambevy = parambevx;
      if (parambevx == null) {
        parambevy = "";
      }
      a(-1, 9044, String.valueOf(i), parambevy, localaock, localbfbj.a);
      continue;
      a(-1, 9313, parambevy, localFromServiceMsg.getBusinessFailMsg(), localaock, localbfbj.a);
      continue;
      a(localFromServiceMsg, (byte[])localObject, localbfau, localbfbj, localaock, parambevy, parambevx);
    }
  }
  
  protected abstract void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bfau parambfau, bfbj parambfbj, aock paramaock, bevy parambevy, bevx parambevx);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfas
 * JD-Core Version:    0.7.0.1
 */