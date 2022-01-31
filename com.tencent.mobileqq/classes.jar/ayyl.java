import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class ayyl
  extends ayxz
{
  private byte[] a(List<ayyy> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (ayys)paramList.get(0);
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
  
  public void a(aytj paramaytj, ayti paramayti)
  {
    ayyn localayyn = (ayyn)paramayti.jdField_a_of_type_JavaLangObject;
    ayzc localayzc = localayyn.jdField_a_of_type_Ayzc;
    paramayti = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = paramaytj.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    akaw localakaw = paramaytj.jdField_a_of_type_Akaw;
    if (paramayti.getResultCode() == 1000) {}
    try
    {
      if (localayzc.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramaytj = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        paramayti = (ayzk)localayzc.jdField_a_of_type_JavaUtilList.get(0);
        paramayti.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo = ((mobileqq_mp.RetInfo)paramaytj.ret_info.get());
        paramayti.jdField_a_of_type_JavaLangString = paramaytj.str_url.get();
        paramayti.b = paramaytj.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        ayzt.a(localayyn, localayzc);
        return;
        int i = paramayti.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(paramayti);
          paramayti = paramayti.getBusinessFailMsg();
          paramaytj = paramayti;
          if (paramayti == null) {
            paramaytj = "";
          }
          a(-1, 9311, (String)localObject, paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
        }
        else
        {
          localObject = MessageHandler.a(paramayti);
          paramayti = paramayti.getBusinessFailMsg();
          paramaytj = paramayti;
          if (paramayti == null) {
            paramaytj = "";
          }
          a(-1, 9044, (String)localObject, paramaytj, localakaw, localayzc.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    catch (Exception paramaytj)
    {
      break label126;
    }
  }
  
  public void a(ayyn paramayyn)
  {
    if ((paramayyn != null) && (paramayyn.jdField_a_of_type_JavaUtilList != null) && (paramayyn.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      ayti localayti = new ayti();
      localayti.jdField_a_of_type_JavaLangString = "PubAccountSvc.pull_long_msg_url";
      localayti.jdField_a_of_type_ArrayOfByte = a(paramayyn.jdField_a_of_type_JavaUtilList);
      localayti.jdField_a_of_type_JavaLangObject = paramayyn;
      localayti.jdField_a_of_type_Ayth = this;
      a(paramayyn, localayti);
    }
  }
  
  void b(ayyn paramayyn)
  {
    paramayyn = paramayyn.jdField_a_of_type_Ayzc;
    paramayyn.jdField_a_of_type_JavaUtilList.clear();
    ayzk localayzk = new ayzk();
    paramayyn.jdField_a_of_type_JavaUtilList.add(localayzk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayyl
 * JD-Core Version:    0.7.0.1
 */