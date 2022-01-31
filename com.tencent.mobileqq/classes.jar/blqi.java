import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class blqi
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
  
  public static Bundle a(@NonNull blqk paramblqk)
  {
    Bundle localBundle = new Bundle();
    if (paramblqk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      bmqg localbmqg = (bmqg)paramblqk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bmqg.a);
      bmqe localbmqe = (bmqe)paramblqk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("DynamicFaceLayer");
      bmqw localbmqw = (bmqw)paramblqk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bmqw.a);
      localBundle.putBundle(bmqg.a, localbmqg.a());
      localBundle.putBundle("DynamicFaceLayer", localbmqe.a());
      if (localbmqw != null) {
        localBundle.putBundle(bmqw.a, localbmqw.a());
      }
      a(paramblqk, localBundle);
      localBundle.putBundle("container", paramblqk.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
  
  private static void a(blqk paramblqk, Bundle paramBundle)
  {
    Object localObject = paramblqk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
    bmrg localbmrg = ((bmre)localObject).a();
    if (localbmrg == null)
    {
      localObject = paramblqk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      paramblqk = ((bmre)localObject).a();
      if (paramblqk == null) {
        break label83;
      }
      paramblqk.jdField_a_of_type_Int = 1001;
    }
    label83:
    for (;;)
    {
      if (paramblqk != null)
      {
        ((blsg)blqr.a(15)).a(paramblqk.jdField_a_of_type_AndroidGraphicsBitmap);
        paramBundle.putBundle("VoteLayer", ((bmre)localObject).a());
      }
      return;
      localbmrg.jdField_a_of_type_Int = 1000;
      paramblqk = localbmrg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqi
 * JD-Core Version:    0.7.0.1
 */