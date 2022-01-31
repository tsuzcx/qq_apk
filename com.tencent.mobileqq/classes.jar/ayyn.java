import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class ayyn
  extends ayyb
{
  private byte[] a(List<ayza> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (ayyu)paramList.get(0);
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
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    ayyp localayyp = (ayyp)paramaytk.jdField_a_of_type_JavaLangObject;
    ayze localayze = localayyp.jdField_a_of_type_Ayze;
    paramaytk = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = paramaytl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    akau localakau = paramaytl.jdField_a_of_type_Akau;
    if (paramaytk.getResultCode() == 1000) {}
    try
    {
      if (localayze.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramaytl = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        paramaytk = (ayzm)localayze.jdField_a_of_type_JavaUtilList.get(0);
        paramaytk.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo = ((mobileqq_mp.RetInfo)paramaytl.ret_info.get());
        paramaytk.jdField_a_of_type_JavaLangString = paramaytl.str_url.get();
        paramaytk.b = paramaytl.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        ayzv.a(localayyp, localayze);
        return;
        int i = paramaytk.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(paramaytk);
          paramaytk = paramaytk.getBusinessFailMsg();
          paramaytl = paramaytk;
          if (paramaytk == null) {
            paramaytl = "";
          }
          a(-1, 9311, (String)localObject, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
        }
        else
        {
          localObject = MessageHandler.a(paramaytk);
          paramaytk = paramaytk.getBusinessFailMsg();
          paramaytl = paramaytk;
          if (paramaytk == null) {
            paramaytl = "";
          }
          a(-1, 9044, (String)localObject, paramaytl, localakau, localayze.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    catch (Exception paramaytl)
    {
      break label126;
    }
  }
  
  public void a(ayyp paramayyp)
  {
    if ((paramayyp != null) && (paramayyp.jdField_a_of_type_JavaUtilList != null) && (paramayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      aytk localaytk = new aytk();
      localaytk.jdField_a_of_type_JavaLangString = "PubAccountSvc.pull_long_msg_url";
      localaytk.jdField_a_of_type_ArrayOfByte = a(paramayyp.jdField_a_of_type_JavaUtilList);
      localaytk.jdField_a_of_type_JavaLangObject = paramayyp;
      localaytk.jdField_a_of_type_Aytj = this;
      a(paramayyp, localaytk);
    }
  }
  
  void b(ayyp paramayyp)
  {
    paramayyp = paramayyp.jdField_a_of_type_Ayze;
    paramayyp.jdField_a_of_type_JavaUtilList.clear();
    ayzm localayzm = new ayzm();
    paramayyp.jdField_a_of_type_JavaUtilList.add(localayzm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyn
 * JD-Core Version:    0.7.0.1
 */