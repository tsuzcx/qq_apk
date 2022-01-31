import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_read.ReadNearUserFeedsRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

final class aszw
  implements aslt
{
  aszw(int paramInt, atac paramatac) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool3 = false;
    bool2 = false;
    bool1 = true;
    paramBundle = new ArrayList();
    int i = this.jdField_a_of_type_Int;
    ilive_feeds_read.ReadNearUserFeedsRsp localReadNearUserFeedsRsp;
    if (paramInt == 0) {
      localReadNearUserFeedsRsp = new ilive_feeds_read.ReadNearUserFeedsRsp();
    }
    for (;;)
    {
      try
      {
        localReadNearUserFeedsRsp.mergeFrom(paramArrayOfByte);
        if (!localReadNearUserFeedsRsp.result.has())
        {
          QLog.i("NearbyMomentProtocol", 1, "getMomentList, don't has result");
          paramInt = i;
          if (this.jdField_a_of_type_Atac != null) {
            this.jdField_a_of_type_Atac.a(bool2, paramBundle, bool1, paramInt);
          }
          return;
        }
        if (localReadNearUserFeedsRsp.result.get() == 0) {
          if (QLog.isColorLevel()) {
            QLog.i("NearbyMomentProtocol", 2, "endFlag=" + localReadNearUserFeedsRsp.end_flag.get() + ",size=" + localReadNearUserFeedsRsp.infos.size() + ",total=" + localReadNearUserFeedsRsp.total.get());
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        bool2 = false;
        bool1 = true;
      }
      try
      {
        paramBundle.addAll(localReadNearUserFeedsRsp.infos.get());
        paramInt = localReadNearUserFeedsRsp.end_flag.get();
        bool1 = bool3;
        if (paramInt == 1) {
          bool1 = true;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          bool2 = true;
          bool1 = true;
        }
      }
      try
      {
        paramInt = localReadNearUserFeedsRsp.pos.get();
        bool2 = true;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        bool2 = true;
        break label281;
      }
      QLog.i("NearbyMomentProtocol", 1, "getMomentList error, result =" + localReadNearUserFeedsRsp.result.get() + ",errMsg=" + localReadNearUserFeedsRsp.err_msg.get());
      paramInt = i;
      continue;
      label281:
      QLog.i("NearbyMomentProtocol", 1, "getMomentList, e=" + paramArrayOfByte.toString());
      paramInt = i;
      continue;
      QLog.i("NearbyMomentProtocol", 1, "getMomentList, 0xada_0 errorCode=" + paramInt);
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aszw
 * JD-Core Version:    0.7.0.1
 */