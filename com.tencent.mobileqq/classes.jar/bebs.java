import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;

public abstract class bebs
  extends bebf
{
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    FromServiceMsg localFromServiceMsg = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    bebv localbebv = (bebv)parambdxe.a;
    beck localbeck = localbebv.a;
    anqe localanqe = parambdxf.jdField_a_of_type_Anqe;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      int i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject = MessageHandler.a(localFromServiceMsg);
        parambdxe = localFromServiceMsg.getBusinessFailMsg();
        parambdxf = parambdxe;
        if (parambdxe == null) {
          parambdxf = "";
        }
        a(-1, 9311, (String)localObject, parambdxf, localanqe, localbeck.a);
      }
    }
    for (;;)
    {
      bedb.a(localbebv, localbeck);
      return;
      localObject = MessageHandler.a(localFromServiceMsg);
      parambdxe = localFromServiceMsg.getBusinessFailMsg();
      parambdxf = parambdxe;
      if (parambdxe == null) {
        parambdxf = "";
      }
      a(-1, 9044, (String)localObject, parambdxf, localanqe, localbeck.a);
      continue;
      a(parambdxf, parambdxe, localFromServiceMsg, (byte[])localObject, localbebv, localbeck, localanqe);
    }
  }
  
  protected abstract void a(bdxf parambdxf, bdxe parambdxe, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, bebv parambebv, beck parambeck, anqe paramanqe);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebs
 * JD-Core Version:    0.7.0.1
 */