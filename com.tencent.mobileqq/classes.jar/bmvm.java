import dov.com.qq.im.ae.AECMShowCameraUnit.2;
import dov.com.qq.im.ae.AECMShowCameraUnit.2.1.1;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import java.util.HashMap;

public class bmvm
  implements bnjf
{
  public bmvm(AECMShowCameraUnit.2 param2) {}
  
  public void a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      bmvk.a((String)paramHashMap.get("video_limishow_base"));
      bnrh.a(this.a.this$0.jdField_a_of_type_JavaLangString, "onComplete:  path = " + bmvk.a());
      if (bmvk.a(this.a.this$0))
      {
        this.a.this$0.jdField_a_of_type_DovComQqImAeCameraCoreAECameraGLSurfaceView.queueEvent(new AECMShowCameraUnit.2.1.1(this));
        this.a.this$0.d = true;
        bnrh.a(this.a.this$0.jdField_a_of_type_JavaLangString, "onComplete: 完成设置素材");
      }
      return;
    }
    bnrh.d(this.a.this$0.jdField_a_of_type_JavaLangString, "onComplete: 请求base资源失败");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvm
 * JD-Core Version:    0.7.0.1
 */