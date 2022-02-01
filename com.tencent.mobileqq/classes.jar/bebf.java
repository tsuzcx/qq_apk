import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public abstract class bebf
  implements bdxd, bedd
{
  int b = 0;
  
  public static int a()
  {
    return a(bdwu.a().a());
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
      String str = bdwu.a().a();
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
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, anqe paramanqe, becx parambecx)
  {
    parambecx.c = paramInt1;
    parambecx.d = paramInt2;
    parambecx.h = paramString1;
    parambecx.g = paramString2;
    if (paramInt1 == 0)
    {
      parambecx.e = 1;
      parambecx.f = (paramanqe.c - 1);
      return;
    }
    parambecx.e = 0;
    parambecx.f = paramanqe.c;
    QLog.d("Q.richmedia.BaseHandler", 1, "result:" + paramInt1 + " errCode:" + paramInt2 + " reason:" + paramString1 + " errStr:" + paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, anqe paramanqe, List<becx> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInt1, paramInt2, paramString1, paramString2, paramanqe, (becx)paramList.next());
    }
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    FromServiceMsg localFromServiceMsg = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bebv localbebv = (bebv)parambdxe.a;
    beck localbeck = localbebv.jdField_a_of_type_Beck;
    anqe localanqe = parambdxf.jdField_a_of_type_Anqe;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      parambdxf = (String)localFromServiceMsg.getAttribute("_tag_socket_connerror", "");
      if ((parambdxf.equals("conSucc")) || (parambdxf.equals("")))
      {
        i = localFromServiceMsg.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.b(localFromServiceMsg);
          parambdxe = localFromServiceMsg.getBusinessFailMsg();
          parambdxf = parambdxe;
          if (parambdxe == null) {
            parambdxf = "";
          }
          a(-1, 9311, (String)localObject, parambdxf, localanqe, localbeck.a);
        }
      }
    }
    for (;;)
    {
      bedb.a(localbebv, localbeck);
      return;
      parambdxe = localFromServiceMsg.getBusinessFailMsg();
      parambdxf = parambdxe;
      if (parambdxe == null) {
        parambdxf = "";
      }
      a(-1, 9044, String.valueOf(i), parambdxf, localanqe, localbeck.a);
      continue;
      a(-1, 9313, parambdxf, localFromServiceMsg.getBusinessFailMsg(), localanqe, localbeck.a);
      continue;
      a(localFromServiceMsg, (byte[])localObject, localbebv, localbeck, localanqe, parambdxf, parambdxe);
    }
  }
  
  void a(bebv parambebv, bdxe parambdxe)
  {
    b(parambebv);
    parambebv.jdField_a_of_type_Bdxe = parambdxe;
    if (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null) {
      parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager.a(parambdxe);
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bebv parambebv, beck parambeck, anqe paramanqe, bdxf parambdxf, bdxe parambdxe) {}
  
  abstract void b(bebv parambebv);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebf
 * JD-Core Version:    0.7.0.1
 */