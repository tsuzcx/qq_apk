import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.ilive_feeds_like.FeedsUnLikeRsp;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xada.oidb_0xada.RspBody;

final class aylg
  implements axxd
{
  aylg(aylk paramaylk) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    bool3 = true;
    boolean bool2 = true;
    int j = 0;
    int k = 0;
    i = 0;
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0xada.RspBody();
    }
    for (;;)
    {
      try
      {
        paramBundle.mergeFrom(paramArrayOfByte);
        if (paramBundle.busi_buf.has())
        {
          paramArrayOfByte = new ilive_feeds_like.FeedsUnLikeRsp();
          paramArrayOfByte.mergeFrom(paramBundle.busi_buf.get().toByteArray());
          if (paramArrayOfByte.ret.has())
          {
            paramInt = paramArrayOfByte.ret.get();
            if (paramInt == 0) {
              i = k;
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        bool1 = false;
        paramInt = j;
      }
      try
      {
        j = paramArrayOfByte.total.get();
        paramInt = j;
        bool1 = bool2;
        i = j;
        if (QLog.isColorLevel())
        {
          i = j;
          QLog.i("NearbyMomentProtocol", 2, "unlike success, total:   " + j);
          bool1 = bool2;
          paramInt = j;
        }
        if (this.a != null) {
          this.a.a(bool1, paramInt);
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramInt = i;
          bool1 = bool3;
        }
      }
      QLog.i("NearbyMomentProtocol", 1, "unlike error, ret=" + paramArrayOfByte.ret.get() + ",err_msg=" + paramBundle.err_msg.get());
      bool1 = false;
      paramInt = i;
      continue;
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylg
 * JD-Core Version:    0.7.0.1
 */