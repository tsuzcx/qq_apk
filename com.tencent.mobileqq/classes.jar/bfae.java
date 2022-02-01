import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class bfae
  implements bevw, bfcc
{
  int b = 0;
  
  public static int a()
  {
    return a(bevn.a().a());
  }
  
  public static int a(int paramInt)
  {
    int j = 6;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      String str = bevn.a().a();
      paramInt = i;
      if (str != null)
      {
        paramInt = i;
        if (str.contains("wap")) {
          paramInt = 5;
        }
      }
      return paramInt;
      i = 3;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, aock paramaock, bfbw parambfbw)
  {
    parambfbw.c = paramInt1;
    parambfbw.d = paramInt2;
    parambfbw.h = paramString1;
    parambfbw.g = paramString2;
    if (paramInt1 == 0)
    {
      parambfbw.e = 1;
      parambfbw.f = (paramaock.c - 1);
      return;
    }
    parambfbw.e = 0;
    parambfbw.f = paramaock.c;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, aock paramaock, List<bfbw> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramaock, (bfbw)paramList.next());
    }
  }
  
  public void a(bevy parambevy, bevx parambevx)
  {
    FromServiceMsg localFromServiceMsg = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bfau localbfau = (bfau)parambevx.a;
    bfbj localbfbj = localbfau.jdField_a_of_type_Bfbj;
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
  
  void a(bfau parambfau, bevx parambevx)
  {
    b(parambfau);
    parambfau.jdField_a_of_type_Bevx = parambevx;
    if (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambevx);
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bfau parambfau, bfbj parambfbj, aock paramaock, bevy parambevy, bevx parambevx) {}
  
  abstract void b(bfau parambfau);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfae
 * JD-Core Version:    0.7.0.1
 */