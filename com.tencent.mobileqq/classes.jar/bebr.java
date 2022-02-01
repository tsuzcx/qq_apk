import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class bebr
  extends bebf
{
  private byte[] a(List<becg> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (beca)paramList.get(0);
    mobileqq_mp.LongMsgUrlRequest localLongMsgUrlRequest = new mobileqq_mp.LongMsgUrlRequest();
    try
    {
      l = Long.parseLong(paramList.d);
      localLongMsgUrlRequest.puin.set(l);
      localLongMsgUrlRequest.str_fileid.set(paramList.jdField_a_of_type_JavaLangString);
      return localLongMsgUrlRequest.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
      }
    }
  }
  
  public void a(bdxf parambdxf, bdxe parambdxe)
  {
    bebv localbebv = (bebv)parambdxe.jdField_a_of_type_JavaLangObject;
    beck localbeck = localbebv.jdField_a_of_type_Beck;
    parambdxe = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambdxf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    anqe localanqe = parambdxf.jdField_a_of_type_Anqe;
    if (parambdxe.getResultCode() == 1000) {}
    try
    {
      if (localbeck.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        parambdxf = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        parambdxe = (becs)localbeck.jdField_a_of_type_JavaUtilList.get(0);
        parambdxe.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo = ((mobileqq_mp.RetInfo)parambdxf.ret_info.get());
        parambdxe.jdField_a_of_type_JavaLangString = parambdxf.str_url.get();
        parambdxe.b = parambdxf.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        bedb.a(localbebv, localbeck);
        return;
        int i = parambdxe.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(parambdxe);
          parambdxe = parambdxe.getBusinessFailMsg();
          parambdxf = parambdxe;
          if (parambdxe == null) {
            parambdxf = "";
          }
          a(-1, 9311, (String)localObject, parambdxf, localanqe, localbeck.jdField_a_of_type_JavaUtilList);
        }
        else
        {
          localObject = MessageHandler.a(parambdxe);
          parambdxe = parambdxe.getBusinessFailMsg();
          parambdxf = parambdxe;
          if (parambdxe == null) {
            parambdxf = "";
          }
          a(-1, 9044, (String)localObject, parambdxf, localanqe, localbeck.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    catch (Exception parambdxf)
    {
      break label126;
    }
  }
  
  public void a(bebv parambebv)
  {
    if ((parambebv != null) && (parambebv.jdField_a_of_type_JavaUtilList != null) && (parambebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bdxe localbdxe = new bdxe();
      localbdxe.jdField_a_of_type_JavaLangString = "PubAccountSvc.pull_long_msg_url";
      localbdxe.jdField_a_of_type_ArrayOfByte = a(parambebv.jdField_a_of_type_JavaUtilList);
      localbdxe.jdField_a_of_type_JavaLangObject = parambebv;
      localbdxe.jdField_a_of_type_Bdxd = this;
      a(parambebv, localbdxe);
    }
  }
  
  void b(bebv parambebv)
  {
    parambebv = parambebv.jdField_a_of_type_Beck;
    parambebv.jdField_a_of_type_JavaUtilList.clear();
    becs localbecs = new becs();
    parambebv.jdField_a_of_type_JavaUtilList.add(localbecs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebr
 * JD-Core Version:    0.7.0.1
 */