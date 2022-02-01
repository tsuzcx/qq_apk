import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bojm
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
  
  public static Bundle a(@NonNull bojo parambojo)
  {
    Bundle localBundle = new Bundle();
    if (parambojo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      bphm localbphm = (bphm)parambojo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bphm.a);
      bphk localbphk = (bphk)parambojo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("DynamicFaceLayer");
      bpic localbpic = (bpic)parambojo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bpic.a);
      localBundle.putBundle(bphm.a, localbphm.a());
      localBundle.putBundle("DynamicFaceLayer", localbphk.a());
      if (localbpic != null) {
        localBundle.putBundle(bpic.a, localbpic.a());
      }
      a(parambojo, localBundle);
      localBundle.putBundle("container", parambojo.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
  
  private static void a(bojo parambojo, Bundle paramBundle)
  {
    Object localObject = parambojo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
    bpim localbpim = ((bpik)localObject).a();
    if (localbpim == null)
    {
      localObject = parambojo.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      parambojo = ((bpik)localObject).a();
      if (parambojo == null) {
        break label83;
      }
      parambojo.jdField_a_of_type_Int = 1001;
    }
    label83:
    for (;;)
    {
      if (parambojo != null)
      {
        ((bolk)bojv.a(15)).a(parambojo.jdField_a_of_type_AndroidGraphicsBitmap);
        paramBundle.putBundle("VoteLayer", ((bpik)localObject).a());
      }
      return;
      localbpim.jdField_a_of_type_Int = 1000;
      parambojo = localbpim;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bojm
 * JD-Core Version:    0.7.0.1
 */