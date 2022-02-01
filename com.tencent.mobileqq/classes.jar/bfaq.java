import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.LongMsgUrlResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;

public class bfaq
  extends bfae
{
  private byte[] a(List<bfbf> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new byte[0];
    }
    paramList = (bfaz)paramList.get(0);
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
  
  public void a(bevy parambevy, bevx parambevx)
  {
    bfau localbfau = (bfau)parambevx.jdField_a_of_type_JavaLangObject;
    bfbj localbfbj = localbfau.jdField_a_of_type_Bfbj;
    parambevx = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = parambevy.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getWupBuffer();
    aock localaock = parambevy.jdField_a_of_type_Aock;
    if (parambevx.getResultCode() == 1000) {}
    try
    {
      if (localbfbj.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        parambevy = (mobileqq_mp.LongMsgUrlResponse)new mobileqq_mp.LongMsgUrlResponse().mergeFrom((byte[])localObject);
        parambevx = (bfbr)localbfbj.jdField_a_of_type_JavaUtilList.get(0);
        parambevx.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$RetInfo = ((mobileqq_mp.RetInfo)parambevy.ret_info.get());
        parambevx.jdField_a_of_type_JavaLangString = parambevy.str_url.get();
        parambevx.b = parambevy.str_file_md5.get();
      }
      for (;;)
      {
        label126:
        bfca.a(localbfau, localbfbj);
        return;
        int i = parambevx.getResultCode();
        if ((i == 1002) || (i == 1013))
        {
          localObject = MessageHandler.a(parambevx);
          parambevx = parambevx.getBusinessFailMsg();
          parambevy = parambevx;
          if (parambevx == null) {
            parambevy = "";
          }
          a(-1, 9311, (String)localObject, parambevy, localaock, localbfbj.jdField_a_of_type_JavaUtilList);
        }
        else
        {
          localObject = MessageHandler.a(parambevx);
          parambevx = parambevx.getBusinessFailMsg();
          parambevy = parambevx;
          if (parambevx == null) {
            parambevy = "";
          }
          a(-1, 9044, (String)localObject, parambevy, localaock, localbfbj.jdField_a_of_type_JavaUtilList);
        }
      }
    }
    catch (Exception parambevy)
    {
      break label126;
    }
  }
  
  public void a(bfau parambfau)
  {
    if ((parambfau != null) && (parambfau.jdField_a_of_type_JavaUtilList != null) && (parambfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager != null))
    {
      bevx localbevx = new bevx();
      localbevx.jdField_a_of_type_JavaLangString = "PubAccountSvc.pull_long_msg_url";
      localbevx.jdField_a_of_type_ArrayOfByte = a(parambfau.jdField_a_of_type_JavaUtilList);
      localbevx.jdField_a_of_type_JavaLangObject = parambfau;
      localbevx.jdField_a_of_type_Bevw = this;
      a(parambfau, localbevx);
    }
  }
  
  void b(bfau parambfau)
  {
    parambfau = parambfau.jdField_a_of_type_Bfbj;
    parambfau.jdField_a_of_type_JavaUtilList.clear();
    bfbr localbfbr = new bfbr();
    parambfau.jdField_a_of_type_JavaUtilList.add(localbfbr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfaq
 * JD-Core Version:    0.7.0.1
 */