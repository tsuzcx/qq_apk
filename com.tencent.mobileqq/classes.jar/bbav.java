import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class bbav
  extends bbaj
{
  private byte[] a(List<bbbi> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (bbbc)paramList.get(0);
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
  
  public void a(bavr parambavr, bavq parambavq)
  {
    bbax localbbax = (bbax)parambavq.jdField_a_of_type_JavaLangObject;
    bbbm localbbbm = localbbax.jdField_a_of_type_Bbbm;
    parambavq = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambavr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    alwy localalwy = parambavr.jdField_a_of_type_Alwy;
    if (parambavq.getResultCode() == 1000) {}
    try
    {
      if (localbbbm.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        parambavr = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        parambavq = (bbbu)localbbbm.jdField_a_of_type_JavaUtilList.get(0);
        parambavq.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo = ((mobileqq_mp.RetInfo)parambavr.ret_info.get());
        parambavq.jdField_a_of_type_JavaLangString = parambavr.str_url.get();
        parambavq.b = parambavr.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        bbcd.a(localbbax, localbbbm);
        return;
        int i = parambavq.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(parambavq);
          parambavq = parambavq.getBusinessFailMsg();
          parambavr = parambavq;
          if (parambavq == null) {
            parambavr = "";
          }
          a(-1, 9311, (String)localObject, parambavr, localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
        }
        else
        {
          localObject = MessageHandler.a(parambavq);
          parambavq = parambavq.getBusinessFailMsg();
          parambavr = parambavq;
          if (parambavq == null) {
            parambavr = "";
          }
          a(-1, 9044, (String)localObject, parambavr, localalwy, localbbbm.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    catch (Exception parambavr)
    {
      break label126;
    }
  }
  
  public void a(bbax parambbax)
  {
    if ((parambbax != null) && (parambbax.jdField_a_of_type_JavaUtilList != null) && (parambbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bavq localbavq = new bavq();
      localbavq.jdField_a_of_type_JavaLangString = "PubAccountSvc.pull_long_msg_url";
      localbavq.jdField_a_of_type_ArrayOfByte = a(parambbax.jdField_a_of_type_JavaUtilList);
      localbavq.jdField_a_of_type_JavaLangObject = parambbax;
      localbavq.jdField_a_of_type_Bavp = this;
      a(parambbax, localbavq);
    }
  }
  
  void b(bbax parambbax)
  {
    parambbax = parambbax.jdField_a_of_type_Bbbm;
    parambbax.jdField_a_of_type_JavaUtilList.clear();
    bbbu localbbbu = new bbbu();
    parambbax.jdField_a_of_type_JavaUtilList.add(localbbbu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbav
 * JD-Core Version:    0.7.0.1
 */