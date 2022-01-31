import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bllw
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
  
  public static Bundle a(@NonNull blly paramblly)
  {
    Bundle localBundle = new Bundle();
    if (paramblly.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      bmlu localbmlu = (bmlu)paramblly.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bmlu.a);
      bmls localbmls = (bmls)paramblly.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("DynamicFaceLayer");
      bmmk localbmmk = (bmmk)paramblly.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bmmk.a);
      localBundle.putBundle(bmlu.a, localbmlu.a());
      localBundle.putBundle("DynamicFaceLayer", localbmls.a());
      if (localbmmk != null) {
        localBundle.putBundle(bmmk.a, localbmmk.a());
      }
      a(paramblly, localBundle);
      localBundle.putBundle("container", paramblly.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
  
  private static void a(blly paramblly, Bundle paramBundle)
  {
    Object localObject = paramblly.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
    bmmu localbmmu = ((bmms)localObject).a();
    if (localbmmu == null)
    {
      localObject = paramblly.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      paramblly = ((bmms)localObject).a();
      if (paramblly == null) {
        break label83;
      }
      paramblly.jdField_a_of_type_Int = 1001;
    }
    label83:
    for (;;)
    {
      if (paramblly != null)
      {
        ((blnu)blmf.a(15)).a(paramblly.jdField_a_of_type_AndroidGraphicsBitmap);
        paramBundle.putBundle("VoteLayer", ((bmms)localObject).a());
      }
      return;
      localbmmu.jdField_a_of_type_Int = 1000;
      paramblly = localbmmu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllw
 * JD-Core Version:    0.7.0.1
 */