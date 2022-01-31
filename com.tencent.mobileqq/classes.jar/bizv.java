import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bizv
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
  
  public static Bundle a(@NonNull bizx parambizx)
  {
    Bundle localBundle = new Bundle();
    if (parambizx.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      bjzt localbjzt = (bjzt)parambizx.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bjzt.a);
      bjzr localbjzr = (bjzr)parambizx.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("DynamicFaceLayer");
      bkaj localbkaj = (bkaj)parambizx.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bkaj.a);
      localBundle.putBundle(bjzt.a, localbjzt.a());
      localBundle.putBundle("DynamicFaceLayer", localbjzr.a());
      if (localbkaj != null) {
        localBundle.putBundle(bkaj.a, localbkaj.a());
      }
      a(parambizx, localBundle);
      localBundle.putBundle("container", parambizx.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
  
  private static void a(bizx parambizx, Bundle paramBundle)
  {
    Object localObject = parambizx.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
    bkat localbkat = ((bkar)localObject).a();
    if (localbkat == null)
    {
      localObject = parambizx.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      parambizx = ((bkar)localObject).a();
      if (parambizx == null) {
        break label83;
      }
      parambizx.jdField_a_of_type_Int = 1001;
    }
    label83:
    for (;;)
    {
      if (parambizx != null)
      {
        ((bjbt)bjae.a(15)).a(parambizx.jdField_a_of_type_AndroidGraphicsBitmap);
        paramBundle.putBundle("VoteLayer", ((bkar)localObject).a());
      }
      return;
      localbkat.jdField_a_of_type_Int = 1000;
      parambizx = localbkat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizv
 * JD-Core Version:    0.7.0.1
 */