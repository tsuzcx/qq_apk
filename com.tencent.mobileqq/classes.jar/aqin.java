import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2.UploadVideoResponse;

class aqin
  implements UploadVideoRequesterV2
{
  aqin(aqil paramaqil) {}
  
  public void request(ReflectLiveReq paramReflectLiveReq, UploadVideoRequesterV2.UploadVideoResponse paramUploadVideoResponse)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.Model", 2, "YTAGReflectLiveCheckInterface setUploadVideoRequesterV2 request");
    }
    if (this.a.jdField_a_of_type_Aqit != null)
    {
      this.a.jdField_a_of_type_Aqit.a(7);
      this.a.jdField_a_of_type_Aqit.a();
    }
    this.a.jdField_a_of_type_Aqib.a(paramReflectLiveReq);
    paramUploadVideoResponse.onSuccess("{\"reflect_live_code\":0,\"reflect_live_msg\":\"OK\",\"picture_live_code\":0,\"picture_live_msg\":\"OK\",\"compare_code\":0,\"compare_msg\":\"OK\"}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqin
 * JD-Core Version:    0.7.0.1
 */