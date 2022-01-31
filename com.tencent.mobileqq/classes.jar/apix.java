import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.UUID;

final class apix
  implements View.OnClickListener
{
  apix(apkm paramapkm, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new apud();
      paramView.b = "file_forward";
      paramView.a = 9;
      apuc.a(this.jdField_a_of_type_Apkm.a().getCurrentAccountUin(), paramView);
      if (bbev.a(this.jdField_a_of_type_Apkm.getActivity()) == 0)
      {
        bajf.a(this.jdField_a_of_type_Apkm.getActivity(), this.jdField_a_of_type_Apkm.getActivity().getString(2131697853));
        return;
      }
      FileManagerEntity localFileManagerEntity = new FileManagerEntity();
      localFileManagerEntity.copyFrom(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      localFileManagerEntity.nSessionId = apue.a().longValue();
      localFileManagerEntity.status = 2;
      paramView = this.jdField_a_of_type_Apkm.a();
      if (paramView != null) {
        paramView.a().d(localFileManagerEntity);
      }
      azqt localazqt = bakj.a(this.jdField_a_of_type_Apkm.a(), localFileManagerEntity);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      if (!TextUtils.isEmpty(localFileManagerEntity.getFilePath())) {
        localForwardFileInfo.a(localazqt.jdField_a_of_type_JavaLangString);
      }
      localForwardFileInfo.d(localazqt.g);
      localForwardFileInfo.d(localazqt.jdField_c_of_type_Long);
      localForwardFileInfo.a(localFileManagerEntity.TroopUin);
      Object localObject = localazqt.d;
      paramView = (View)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramView = localazqt.jdField_c_of_type_JavaLangString;
      }
      localForwardFileInfo.f(paramView);
      if (localFileManagerEntity.isZipInnerFile)
      {
        localForwardFileInfo.b(10000);
        localForwardFileInfo.d(3);
      }
      for (;;)
      {
        localForwardFileInfo.a(2);
        paramView = new Bundle();
        paramView.putInt("forward_type", 0);
        paramView.putParcelable("fileinfo", localForwardFileInfo);
        paramView.putBoolean("not_forward", true);
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramView);
        ((Intent)localObject).putExtra("forward_text", localazqt.g);
        ((Intent)localObject).putExtra("forward_from_troop_file", true);
        aqbc.a(this.jdField_a_of_type_Apkm.getActivity(), (Intent)localObject, 103);
        return;
        if (localazqt.jdField_a_of_type_JavaUtilUUID != null) {
          localForwardFileInfo.e(localazqt.jdField_a_of_type_JavaUtilUUID.toString());
        }
        localForwardFileInfo.b(10006);
        localForwardFileInfo.d(4);
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apix
 * JD-Core Version:    0.7.0.1
 */