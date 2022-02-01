package com.tencent.mobileqq.avatar.dynamicavatar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import anni;
import apul;
import java.io.File;

class SelectCoverActivity$3
  implements Runnable
{
  SelectCoverActivity$3(SelectCoverActivity paramSelectCoverActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$0.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          this.this$0.jdField_b_of_type_JavaLangString = this.this$0.a(this.a);
        } while (this.this$0.jdField_b_of_type_Boolean);
        if (TextUtils.isEmpty(this.this$0.jdField_b_of_type_JavaLangString))
        {
          SelectCoverActivity.a(this.this$0, 2, anni.a(2131712482), 0);
          return;
        }
        SelectCoverActivity.a(this.this$0, 0, anni.a(2131712475), 0);
        if ((this.this$0.jdField_d_of_type_Int != 1) && (this.this$0.jdField_d_of_type_Int != 3)) {
          break;
        }
      } while ((TextUtils.isEmpty(this.this$0.jdField_a_of_type_Apul.a)) || (!new File(this.this$0.jdField_a_of_type_Apul.a).exists()) || (TextUtils.isEmpty(this.this$0.jdField_a_of_type_Apul.jdField_b_of_type_JavaLangString)) || (!new File(this.this$0.jdField_a_of_type_Apul.jdField_b_of_type_JavaLangString).exists()));
      SelectCoverActivity.b(this.this$0);
      return;
    } while (this.this$0.jdField_d_of_type_Int != 2);
    Intent localIntent = this.this$0.getIntent();
    localIntent.putExtra("key_photo_file_path", this.this$0.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_video_duration", this.this$0.f);
    localIntent.putExtra("key_video_has_voice", this.this$0.c);
    localIntent.putExtra("key_camera_id", this.this$0.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("key_photo_selected_by_user", this.this$0.jdField_a_of_type_Boolean);
    this.this$0.setResult(-1, localIntent);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.3
 * JD-Core Version:    0.7.0.1
 */