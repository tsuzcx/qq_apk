package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class EditVideoSave$1
  implements Runnable
{
  EditVideoSave$1(EditVideoSave paramEditVideoSave, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.d();
    if (this.a == 222)
    {
      String str = this.b.getStringExtra("key_video_save_path");
      this.this$0.t.a(str);
      return;
    }
    QQToast.makeText(this.this$0.u.getContext(), 2, HardCodeUtil.a(2131901850), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */