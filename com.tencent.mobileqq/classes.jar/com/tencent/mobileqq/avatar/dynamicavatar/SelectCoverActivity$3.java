package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.File;

class SelectCoverActivity$3
  implements Runnable
{
  SelectCoverActivity$3(SelectCoverActivity paramSelectCoverActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Boolean) {
      return;
    }
    Object localObject = this.this$0;
    ((SelectCoverActivity)localObject).jdField_b_of_type_JavaLangString = ((SelectCoverActivity)localObject).a(this.a);
    if (this.this$0.jdField_b_of_type_Boolean) {
      return;
    }
    if (TextUtils.isEmpty(this.this$0.jdField_b_of_type_JavaLangString))
    {
      SelectCoverActivity.a(this.this$0, 2, HardCodeUtil.a(2131713624), 0);
      return;
    }
    SelectCoverActivity.a(this.this$0, 0, HardCodeUtil.a(2131713617), 0);
    if ((this.this$0.jdField_d_of_type_Int != 1) && (this.this$0.jdField_d_of_type_Int != 3))
    {
      if (this.this$0.jdField_d_of_type_Int == 2)
      {
        localObject = this.this$0.getIntent();
        ((Intent)localObject).putExtra("key_photo_file_path", this.this$0.jdField_b_of_type_JavaLangString);
        ((Intent)localObject).putExtra("key_video_duration", this.this$0.f);
        ((Intent)localObject).putExtra("key_video_has_voice", this.this$0.c);
        ((Intent)localObject).putExtra("key_camera_id", this.this$0.jdField_d_of_type_JavaLangString);
        ((Intent)localObject).putExtra("key_photo_selected_by_user", this.this$0.jdField_a_of_type_Boolean);
        this.this$0.setResult(-1, (Intent)localObject);
        this.this$0.finish();
      }
    }
    else if ((!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a)) && (new File(this.this$0.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a).exists()) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_b_of_type_JavaLangString)) && (new File(this.this$0.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_b_of_type_JavaLangString).exists())) {
      SelectCoverActivity.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.3
 * JD-Core Version:    0.7.0.1
 */