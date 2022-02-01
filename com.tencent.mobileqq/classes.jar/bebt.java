import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract class bebt
  extends bebf
{
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    FromServiceMsg localFromServiceMsg = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bebv localbebv = (bebv)parambdxe.a;
    beck localbeck = localbebv.a;
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
  
  protected abstract void a(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bebv parambebv, beck parambeck, anqe paramanqe, bdxf parambdxf, bdxe parambdxe);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebt
 * JD-Core Version:    0.7.0.1
 */