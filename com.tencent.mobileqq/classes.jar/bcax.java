import android.os.Bundle;
import android.util.LruCache;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xbcb.CheckUrlRsp;
import tencent.im.oidb.oidb_0xbcb.RspBody;
import tencent.im.oidb.oidb_0xbcb.UrlCheckResult;

class bcax
  extends mxm
{
  bcax(bcat parambcat, bcaz parambcaz, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("urlSecMgr", 2, "receive 0xbcb_0 code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (!QLog.isColorLevel()) {
        break label626;
      }
      if (paramArrayOfByte == null) {
        break label620;
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramBundle = ((oidb_0xbcb.RspBody)new oidb_0xbcb.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
        localObject = new StringBuilder().append("req error code=").append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ", data=null";
          QLog.i("urlSecMgr", 2, paramArrayOfByte);
          paramArrayOfByte = null;
          if (this.jdField_a_of_type_Bcaz != null)
          {
            paramBundle = new Bundle();
            if ((this.jdField_a_of_type_Int == 1) && (paramArrayOfByte != null))
            {
              paramBundle.putInt("result", paramArrayOfByte.jdField_a_of_type_Int);
              paramBundle.putInt("jumpResult", paramArrayOfByte.jdField_b_of_type_Int);
              paramBundle.putString("jumpUrl", paramArrayOfByte.jdField_a_of_type_JavaLangString);
              paramBundle.putInt("level", paramArrayOfByte.c);
              paramBundle.putInt("subLevel", paramArrayOfByte.d);
              paramBundle.putInt("umrType", paramArrayOfByte.e);
              paramBundle.putInt("retFrom", paramArrayOfByte.f);
              paramBundle.putLong("operationBit", paramArrayOfByte.jdField_b_of_type_Long);
            }
            this.jdField_a_of_type_Bcaz.a(paramBundle);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle = "";
        continue;
        paramArrayOfByte = ", msg=" + paramBundle;
        continue;
      }
      oidb_0xbcb.RspBody localRspBody = new oidb_0xbcb.RspBody();
      for (;;)
      {
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.i("urlSecMgr", 2, "parse 0xbcb_0 result msg=" + localRspBody.wording.get() + ", count=" + localRspBody.check_url_rsp.results.size());
          }
          l1 = NetConnInfoCenter.getServerTimeMillis();
          l2 = localRspBody.check_url_rsp.next_req_duration.get();
          int i = localRspBody.check_url_rsp.results.size();
          paramArrayOfByte = null;
          paramInt = 0;
          if (paramInt < i) {
            paramBundle = paramArrayOfByte;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          long l1;
          long l2;
          oidb_0xbcb.UrlCheckResult localUrlCheckResult;
          String str;
          paramBundle = null;
        }
        try
        {
          localUrlCheckResult = (oidb_0xbcb.UrlCheckResult)localRspBody.check_url_rsp.results.get(paramInt);
          paramBundle = paramArrayOfByte;
          str = localUrlCheckResult.url.get();
          paramBundle = paramArrayOfByte;
          localObject = new bcay(null);
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).jdField_a_of_type_Long = (l2 * 1000L + l1);
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).jdField_a_of_type_Int = localUrlCheckResult.result.get();
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).jdField_b_of_type_Int = localUrlCheckResult.jump_result.get();
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).jdField_a_of_type_JavaLangString = localUrlCheckResult.jump_url.get();
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).c = localUrlCheckResult.uint32_level.get();
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).d = localUrlCheckResult.uint32_sub_level.get();
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).e = localUrlCheckResult.uint32_umrtype.get();
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).f = localUrlCheckResult.ret_from.get();
          paramBundle = paramArrayOfByte;
          ((bcay)localObject).jdField_b_of_type_Long = localUrlCheckResult.operation_bit.get();
          if (paramInt == 0) {
            paramArrayOfByte = (byte[])localObject;
          }
          paramBundle = paramArrayOfByte;
          this.jdField_a_of_type_Bcat.a.put(str, localObject);
          paramInt += 1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          label592:
          break label592;
        }
      }
      continue;
      paramArrayOfByte = paramBundle;
      if (QLog.isColorLevel())
      {
        QLog.i("urlSecMgr", 2, "parse error", localInvalidProtocolBufferMicroException1);
        paramArrayOfByte = paramBundle;
        continue;
        label620:
        paramBundle = "";
        continue;
        label626:
        paramArrayOfByte = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcax
 * JD-Core Version:    0.7.0.1
 */