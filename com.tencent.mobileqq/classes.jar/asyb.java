import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.biz.huiyin.ILiveProto.iLiveResponse;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huiyin.HuiyinUtilsImpl.3.1.1;
import com.tencent.mobileqq.intervideo.huiyin.proto.FalcoLoginProto.LoginCheckRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;

public class asyb
  implements BusinessObserver
{
  asyb(asya paramasya) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("huiyin", 2, "login rsp " + paramBoolean);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      paramBundle = new ILiveProto.iLiveResponse();
      try
      {
        paramBundle.mergeFrom((byte[])localObject);
        localObject = new FalcoLoginProto.LoginCheckRsp();
        ((FalcoLoginProto.LoginCheckRsp)localObject).mergeFrom(paramBundle.ex.get().toByteArray());
        this.a.a.jdField_a_of_type_Long = ((FalcoLoginProto.LoginCheckRsp)localObject).tinyid.get();
        this.a.a.jdField_a_of_type_JavaLangString = ((FalcoLoginProto.LoginCheckRsp)localObject).a2_key.get();
        this.a.a.jdField_b_of_type_JavaLangString = ((FalcoLoginProto.LoginCheckRsp)localObject).user_sig.get();
        this.a.a.jdField_a_of_type_Boolean = ((FalcoLoginProto.LoginCheckRsp)localObject).is_not_registered.get();
        this.a.a.jdField_a_of_type_ArrayOfByte = ((FalcoLoginProto.LoginCheckRsp)localObject).ex.get().toByteArray();
        this.a.a.jdField_b_of_type_Boolean = false;
        asxy.a(this.a.a).opType("huiyin").opName("loginresult").d1(String.valueOf(this.a.a.jdField_a_of_type_Long)).d2(String.valueOf(this.a.a.jdField_a_of_type_Boolean)).report();
        Log.i("huiyin.login", "login ok " + this.a.a.jdField_a_of_type_Long + ", " + this.a.a.jdField_b_of_type_JavaLangString);
        paramBundle = this.a.a.jdField_a_of_type_JavaUtilList.iterator();
        while (paramBundle.hasNext()) {
          ((asyf)paramBundle.next()).a();
        }
        this.a.a.jdField_a_of_type_JavaUtilList.clear();
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      new Handler(Looper.getMainLooper()).postDelayed(new HuiyinUtilsImpl.3.1.1(this), 7200000L);
      return;
    }
    if (paramBundle.containsKey("data_error_msg"))
    {
      localObject = paramBundle.getString("data_error_msg");
      IVPluginDataReporter localIVPluginDataReporter = asxy.a(this.a.a).opType("huiyin").opName("login_fail");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "null";
      }
      localIVPluginDataReporter.d1(paramBundle).report();
      return;
    }
    asxy.a(this.a.a).opType("huiyin").opName("login_fail").report();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyb
 * JD-Core Version:    0.7.0.1
 */