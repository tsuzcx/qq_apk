import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bhfd
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
  
  public static Bundle a(@NonNull bhff parambhff)
  {
    Bundle localBundle = new Bundle();
    if (parambhff.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      biiy localbiiy = (biiy)parambhff.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(biiy.a);
      biiw localbiiw = (biiw)parambhff.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("DynamicFaceLayer");
      bijo localbijo = (bijo)parambhff.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bijo.a);
      localBundle.putBundle(biiy.a, localbiiy.a());
      localBundle.putBundle("DynamicFaceLayer", localbiiw.a());
      if (localbijo != null) {
        localBundle.putBundle(bijo.a, localbijo.a());
      }
      a(parambhff, localBundle);
      localBundle.putBundle("container", parambhff.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
  
  private static void a(bhff parambhff, Bundle paramBundle)
  {
    Object localObject = parambhff.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
    bijy localbijy = ((bijw)localObject).a();
    if (localbijy == null)
    {
      localObject = parambhff.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      parambhff = ((bijw)localObject).a();
      if (parambhff == null) {
        break label83;
      }
      parambhff.jdField_a_of_type_Int = 1001;
    }
    label83:
    for (;;)
    {
      if (parambhff != null)
      {
        ((bhhb)bhfm.a(15)).a(parambhff.jdField_a_of_type_AndroidGraphicsBitmap);
        paramBundle.putBundle("VoteLayer", ((bijw)localObject).a());
      }
      return;
      localbijy.jdField_a_of_type_Int = 1000;
      parambhff = localbijy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhfd
 * JD-Core Version:    0.7.0.1
 */