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

final class aorm
  implements View.OnClickListener
{
  aorm(aotc paramaotc, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new apcj();
      paramView.b = "file_forward";
      paramView.a = 9;
      apci.a(this.jdField_a_of_type_Aotc.a().getCurrentAccountUin(), paramView);
      if (badq.a(this.jdField_a_of_type_Aotc.getActivity()) == 0)
      {
        azic.a(this.jdField_a_of_type_Aotc.getActivity(), this.jdField_a_of_type_Aotc.getActivity().getString(2131632133));
        return;
      }
      FileManagerEntity localFileManagerEntity = new FileManagerEntity();
      localFileManagerEntity.copyFrom(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      localFileManagerEntity.nSessionId = apck.a().longValue();
      localFileManagerEntity.status = 2;
      paramView = this.jdField_a_of_type_Aotc.a();
      if (paramView != null) {
        paramView.a().d(localFileManagerEntity);
      }
      ayqd localayqd = azjg.a(this.jdField_a_of_type_Aotc.a(), localFileManagerEntity);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      if (!TextUtils.isEmpty(localFileManagerEntity.getFilePath())) {
        localForwardFileInfo.a(localayqd.jdField_a_of_type_JavaLangString);
      }
      localForwardFileInfo.d(localayqd.g);
      localForwardFileInfo.d(localayqd.jdField_c_of_type_Long);
      localForwardFileInfo.a(localFileManagerEntity.TroopUin);
      Object localObject = localayqd.d;
      paramView = (View)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramView = localayqd.jdField_c_of_type_JavaLangString;
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
        ((Intent)localObject).putExtra("forward_text", localayqd.g);
        ((Intent)localObject).putExtra("forward_from_troop_file", true);
        aphp.a(this.jdField_a_of_type_Aotc.getActivity(), (Intent)localObject, 103);
        return;
        if (localayqd.jdField_a_of_type_JavaUtilUUID != null) {
          localForwardFileInfo.e(localayqd.jdField_a_of_type_JavaUtilUUID.toString());
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
 * Qualified Name:     aorm
 * JD-Core Version:    0.7.0.1
 */