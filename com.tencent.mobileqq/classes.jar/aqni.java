import android.os.Bundle;
import com.tencent.biz.huiyin.HuiyinRedDotProto.RedDotGetRsp;
import com.tencent.biz.huiyin.ILiveProto.iLiveResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import mqq.observer.BusinessObserver;

class aqni
  implements BusinessObserver
{
  aqni(aqnd paramaqnd, aqnl paramaqnl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      paramBundle = new ILiveProto.iLiveResponse();
    }
    try
    {
      paramBundle.mergeFrom((byte[])localObject);
      localObject = new HuiyinRedDotProto.RedDotGetRsp();
      ((HuiyinRedDotProto.RedDotGetRsp)localObject).mergeFrom(paramBundle.ex.get().toByteArray());
      this.jdField_a_of_type_Aqnd.a = ((int)((HuiyinRedDotProto.RedDotGetRsp)localObject).totalNum.get());
      this.jdField_a_of_type_Aqnl.a(this.jdField_a_of_type_Aqnd.a);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqni
 * JD-Core Version:    0.7.0.1
 */