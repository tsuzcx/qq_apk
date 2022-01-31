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

final class apjb
  implements View.OnClickListener
{
  apjb(apkq paramapkq, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new apuf();
      paramView.b = "file_forward";
      paramView.a = 9;
      apue.a(this.jdField_a_of_type_Apkq.a().getCurrentAccountUin(), paramView);
      if (bbfj.a(this.jdField_a_of_type_Apkq.getActivity()) == 0)
      {
        bajt.a(this.jdField_a_of_type_Apkq.getActivity(), this.jdField_a_of_type_Apkq.getActivity().getString(2131697863));
        return;
      }
      FileManagerEntity localFileManagerEntity = new FileManagerEntity();
      localFileManagerEntity.copyFrom(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      localFileManagerEntity.nSessionId = apug.a().longValue();
      localFileManagerEntity.status = 2;
      paramView = this.jdField_a_of_type_Apkq.a();
      if (paramView != null) {
        paramView.a().d(localFileManagerEntity);
      }
      azqv localazqv = bakx.a(this.jdField_a_of_type_Apkq.a(), localFileManagerEntity);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      if (!TextUtils.isEmpty(localFileManagerEntity.getFilePath())) {
        localForwardFileInfo.a(localazqv.jdField_a_of_type_JavaLangString);
      }
      localForwardFileInfo.d(localazqv.g);
      localForwardFileInfo.d(localazqv.jdField_c_of_type_Long);
      localForwardFileInfo.a(localFileManagerEntity.TroopUin);
      Object localObject = localazqv.d;
      paramView = (View)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramView = localazqv.jdField_c_of_type_JavaLangString;
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
        ((Intent)localObject).putExtra("forward_text", localazqv.g);
        ((Intent)localObject).putExtra("forward_from_troop_file", true);
        aqbe.a(this.jdField_a_of_type_Apkq.getActivity(), (Intent)localObject, 103);
        return;
        if (localazqv.jdField_a_of_type_JavaUtilUUID != null) {
          localForwardFileInfo.e(localazqv.jdField_a_of_type_JavaUtilUUID.toString());
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
 * Qualified Name:     apjb
 * JD-Core Version:    0.7.0.1
 */