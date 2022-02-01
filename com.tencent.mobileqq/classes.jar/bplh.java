import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bplh
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
  
  public static Bundle a(@NonNull bplj parambplj)
  {
    Bundle localBundle = new Bundle();
    if (parambplj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      bqjh localbqjh = (bqjh)parambplj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bqjh.a);
      bqjf localbqjf = (bqjf)parambplj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("DynamicFaceLayer");
      bqjx localbqjx = (bqjx)parambplj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bqjx.a);
      localBundle.putBundle(bqjh.a, localbqjh.a());
      localBundle.putBundle("DynamicFaceLayer", localbqjf.a());
      if (localbqjx != null) {
        localBundle.putBundle(bqjx.a, localbqjx.a());
      }
      a(parambplj, localBundle);
      localBundle.putBundle("container", parambplj.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
  
  private static void a(bplj parambplj, Bundle paramBundle)
  {
    Object localObject = parambplj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
    bqkh localbqkh = ((bqkf)localObject).a();
    if (localbqkh == null)
    {
      localObject = parambplj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      parambplj = ((bqkf)localObject).a();
      if (parambplj == null) {
        break label83;
      }
      parambplj.jdField_a_of_type_Int = 1001;
    }
    label83:
    for (;;)
    {
      if (parambplj != null)
      {
        ((bpnf)bplq.a(15)).a(parambplj.jdField_a_of_type_AndroidGraphicsBitmap);
        paramBundle.putBundle("VoteLayer", ((bqkf)localObject).a());
      }
      return;
      localbqkh.jdField_a_of_type_Int = 1000;
      parambplj = localbqkh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bplh
 * JD-Core Version:    0.7.0.1
 */