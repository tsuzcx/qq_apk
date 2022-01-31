import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;
import java.io.File;

public class aold
  implements Runnable
{
  public aold(EditWebDanceMachineVideoActivity paramEditWebDanceMachineVideoActivity, int paramInt) {}
  
  public void run()
  {
    String str = EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity, EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity), EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity), this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity.getAppInterface().getCurrentNickname(), this.jdField_a_of_type_Int);
    int i;
    if (this.jdField_a_of_type_Int == 0)
    {
      i = EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity, str, EditWebDanceMachineVideoActivity.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity), EditWebDanceMachineVideoActivity.c(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity));
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "[DanceMachine Share]  shareToSinaResult : " + i);
      }
      if (i != 0) {
        this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity.runOnUiThread(new aole(this, i));
      }
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(EditWebDanceMachineVideoActivity.c(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity), (BitmapFactory.Options)localObject);
          if (((BitmapFactory.Options)localObject).outHeight != 0) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "decode bitmap failed, outHeight == 0");
        return;
        i = ((BitmapFactory.Options)localObject).outHeight / 120;
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject).inSampleSize = i;
        localObject = BitmapFactory.decodeFile(EditWebDanceMachineVideoActivity.c(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity), (BitmapFactory.Options)localObject);
        if (localObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "decode bitmap failed : iconBitmap is null");
      return;
      int j = ((Bitmap)localObject).getRowBytes();
      int k = ((Bitmap)localObject).getHeight();
      if (QLog.isColorLevel()) {
        QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "share to wechat bitmap ratio  : " + i + "   size : " + j * k / 1024 + "KB  fileSize : " + new File(EditWebDanceMachineVideoActivity.c(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity)).length());
      }
      if (EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity) == null) {
        EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity, new aolf(this, (Bitmap)localObject));
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        WXShareHelper.a().d(String.valueOf(System.currentTimeMillis()), str, (Bitmap)localObject, EditWebDanceMachineVideoActivity.d(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity), EditWebDanceMachineVideoActivity.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity));
        WXShareHelper.a().a(EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity));
        EditWebDanceMachineVideoActivity.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity, 1);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    WXShareHelper.a().c(String.valueOf(System.currentTimeMillis()), str, (Bitmap)localObject, EditWebDanceMachineVideoActivity.d(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity), EditWebDanceMachineVideoActivity.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity));
    WXShareHelper.a().a(EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity));
    EditWebDanceMachineVideoActivity.b(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aold
 * JD-Core Version:    0.7.0.1
 */