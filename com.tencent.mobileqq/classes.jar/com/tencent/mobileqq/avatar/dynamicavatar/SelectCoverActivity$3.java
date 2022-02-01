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
    if (this.this$0.F) {
      return;
    }
    Object localObject = this.this$0;
    ((SelectCoverActivity)localObject).A = ((SelectCoverActivity)localObject).a(this.a);
    if (this.this$0.F) {
      return;
    }
    if (TextUtils.isEmpty(this.this$0.A))
    {
      SelectCoverActivity.a(this.this$0, 2, HardCodeUtil.a(2131911169), 0);
      return;
    }
    SelectCoverActivity.a(this.this$0, 0, HardCodeUtil.a(2131911162), 0);
    if ((this.this$0.x != 1) && (this.this$0.x != 3))
    {
      if (this.this$0.x == 2)
      {
        localObject = this.this$0.getIntent();
        ((Intent)localObject).putExtra("key_photo_file_path", this.this$0.A);
        ((Intent)localObject).putExtra("key_video_duration", this.this$0.B);
        ((Intent)localObject).putExtra("key_video_has_voice", this.this$0.C);
        ((Intent)localObject).putExtra("key_camera_id", this.this$0.D);
        ((Intent)localObject).putExtra("key_photo_selected_by_user", this.this$0.E);
        this.this$0.setResult(-1, (Intent)localObject);
        this.this$0.finish();
      }
    }
    else if ((!TextUtils.isEmpty(this.this$0.G.b)) && (new File(this.this$0.G.b).exists()) && (!TextUtils.isEmpty(this.this$0.G.c)) && (new File(this.this$0.G.c).exists())) {
      SelectCoverActivity.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.3
 * JD-Core Version:    0.7.0.1
 */