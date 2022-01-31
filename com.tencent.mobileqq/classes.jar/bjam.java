import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class bjam
{
  public static Bundle a(@NonNull Intent paramIntent)
  {
    return paramIntent.getBundleExtra("state");
  }
  
  public static Bundle a(@NonNull bjao parambjao)
  {
    Bundle localBundle = new Bundle();
    if (parambjao.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout != null)
    {
      bkak localbkak = (bkak)parambjao.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bkak.a);
      bkai localbkai = (bkai)parambjao.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("DynamicFaceLayer");
      bkba localbkba = (bkba)parambjao.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a(bkba.a);
      localBundle.putBundle(bkak.a, localbkak.a());
      localBundle.putBundle("DynamicFaceLayer", localbkai.a());
      if (localbkba != null) {
        localBundle.putBundle(bkba.a, localbkba.a());
      }
      a(parambjao, localBundle);
      localBundle.putBundle("container", parambjao.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.a());
      return localBundle;
    }
    QLog.e("EditState", 1, "saveState mDoodleLayout is null");
    return localBundle;
  }
  
  private static void a(bjao parambjao, Bundle paramBundle)
  {
    Object localObject = parambjao.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
    bkbk localbkbk = ((bkbi)localObject).a();
    if (localbkbk == null)
    {
      localObject = parambjao.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
      parambjao = ((bkbi)localObject).a();
      if (parambjao == null) {
        break label83;
      }
      parambjao.jdField_a_of_type_Int = 1001;
    }
    label83:
    for (;;)
    {
      if (parambjao != null)
      {
        ((bjck)bjav.a(15)).a(parambjao.jdField_a_of_type_AndroidGraphicsBitmap);
        paramBundle.putBundle("VoteLayer", ((bkbi)localObject).a());
      }
      return;
      localbkbk.jdField_a_of_type_Int = 1000;
      parambjao = localbkbk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjam
 * JD-Core Version:    0.7.0.1
 */