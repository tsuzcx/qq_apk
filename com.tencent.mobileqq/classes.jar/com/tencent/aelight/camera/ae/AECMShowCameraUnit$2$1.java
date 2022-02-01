package com.tencent.aelight.camera.ae;

import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;

class AECMShowCameraUnit$2$1
  implements CMJoyEssentialDownloadCallback
{
  AECMShowCameraUnit$2$1(AECMShowCameraUnit.2 param2) {}
  
  public void a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      AECMShowCameraUnit.a(this.a.this$0, (String)paramHashMap.get("video_limishow_base"));
      if (AECMShowCameraUnit.a(this.a.this$0))
      {
        this.a.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.2.1.1(this));
        this.a.this$0.d = true;
        AEQLog.a(this.a.this$0.jdField_a_of_type_JavaLangString, "[fetchMaterialPath] onComplete: 完成设置素材");
      }
    }
    else
    {
      AEQLog.d(this.a.this$0.jdField_a_of_type_JavaLangString, "[fetchMaterialPath] onComplete: 请求base资源失败");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.2.1
 * JD-Core Version:    0.7.0.1
 */