import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class bawm
  extends bawa
{
  private byte[] a(List<bawz> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (bawt)paramList.get(0);
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
  
  public void a(bari parambari, barh parambarh)
  {
    bawo localbawo = (bawo)parambarh.jdField_a_of_type_JavaLangObject;
    baxd localbaxd = localbawo.jdField_a_of_type_Baxd;
    parambarh = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambari.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    alsj localalsj = parambari.jdField_a_of_type_Alsj;
    if (parambarh.getResultCode() == 1000) {}
    try
    {
      if (localbaxd.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        parambari = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        parambarh = (baxl)localbaxd.jdField_a_of_type_JavaUtilList.get(0);
        parambarh.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo = ((mobileqq_mp.RetInfo)parambari.ret_info.get());
        parambarh.jdField_a_of_type_JavaLangString = parambari.str_url.get();
        parambarh.b = parambari.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        baxu.a(localbawo, localbaxd);
        return;
        int i = parambarh.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(parambarh);
          parambarh = parambarh.getBusinessFailMsg();
          parambari = parambarh;
          if (parambarh == null) {
            parambari = "";
          }
          a(-1, 9311, (String)localObject, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
        }
        else
        {
          localObject = MessageHandler.a(parambarh);
          parambarh = parambarh.getBusinessFailMsg();
          parambari = parambarh;
          if (parambarh == null) {
            parambari = "";
          }
          a(-1, 9044, (String)localObject, parambari, localalsj, localbaxd.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    catch (Exception parambari)
    {
      break label126;
    }
  }
  
  public void a(bawo parambawo)
  {
    if ((parambawo != null) && (parambawo.jdField_a_of_type_JavaUtilList != null) && (parambawo.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      barh localbarh = new barh();
      localbarh.jdField_a_of_type_JavaLangString = "PubAccountSvc.pull_long_msg_url";
      localbarh.jdField_a_of_type_ArrayOfByte = a(parambawo.jdField_a_of_type_JavaUtilList);
      localbarh.jdField_a_of_type_JavaLangObject = parambawo;
      localbarh.jdField_a_of_type_Barg = this;
      a(parambawo, localbarh);
    }
  }
  
  void b(bawo parambawo)
  {
    parambawo = parambawo.jdField_a_of_type_Baxd;
    parambawo.jdField_a_of_type_JavaUtilList.clear();
    baxl localbaxl = new baxl();
    parambawo.jdField_a_of_type_JavaUtilList.add(localbaxl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bawm
 * JD-Core Version:    0.7.0.1
 */