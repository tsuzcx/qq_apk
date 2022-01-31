import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class axye
  extends axxs
{
  private byte[] a(List<axyr> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (axyl)paramList.get(0);
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
  
  public void a(axtc paramaxtc, axtb paramaxtb)
  {
    axyg localaxyg = (axyg)paramaxtb.jdField_a_of_type_JavaLangObject;
    axyv localaxyv = localaxyg.jdField_a_of_type_Axyv;
    paramaxtb = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = paramaxtc.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    ajmn localajmn = paramaxtc.jdField_a_of_type_Ajmn;
    if (paramaxtb.getResultCode() == 1000) {}
    try
    {
      if (localaxyv.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        paramaxtc = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        paramaxtb = (axzd)localaxyv.jdField_a_of_type_JavaUtilList.get(0);
        paramaxtb.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo = ((mobileqq_mp.RetInfo)paramaxtc.ret_info.get());
        paramaxtb.jdField_a_of_type_JavaLangString = paramaxtc.str_url.get();
        paramaxtb.b = paramaxtc.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        axzm.a(localaxyg, localaxyv);
        return;
        int i = paramaxtb.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(paramaxtb);
          paramaxtb = paramaxtb.getBusinessFailMsg();
          paramaxtc = paramaxtb;
          if (paramaxtb == null) {
            paramaxtc = "";
          }
          a(-1, 9311, (String)localObject, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
        }
        else
        {
          localObject = MessageHandler.a(paramaxtb);
          paramaxtb = paramaxtb.getBusinessFailMsg();
          paramaxtc = paramaxtb;
          if (paramaxtb == null) {
            paramaxtc = "";
          }
          a(-1, 9044, (String)localObject, paramaxtc, localajmn, localaxyv.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    catch (Exception paramaxtc)
    {
      break label126;
    }
  }
  
  public void a(axyg paramaxyg)
  {
    if ((paramaxyg != null) && (paramaxyg.jdField_a_of_type_JavaUtilList != null) && (paramaxyg.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      axtb localaxtb = new axtb();
      localaxtb.jdField_a_of_type_JavaLangString = "PubAccountSvc.pull_long_msg_url";
      localaxtb.jdField_a_of_type_ArrayOfByte = a(paramaxyg.jdField_a_of_type_JavaUtilList);
      localaxtb.jdField_a_of_type_JavaLangObject = paramaxyg;
      localaxtb.jdField_a_of_type_Axta = this;
      a(paramaxyg, localaxtb);
    }
  }
  
  void b(axyg paramaxyg)
  {
    paramaxyg = paramaxyg.jdField_a_of_type_Axyv;
    paramaxyg.jdField_a_of_type_JavaUtilList.clear();
    axzd localaxzd = new axzd();
    paramaxyg.jdField_a_of_type_JavaUtilList.add(localaxzd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axye
 * JD-Core Version:    0.7.0.1
 */