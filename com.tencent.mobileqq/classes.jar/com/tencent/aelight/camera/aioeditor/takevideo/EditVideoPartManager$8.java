package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Intent;
import com.tencent.mobileqq.editor.params.EditVideoParams;

class EditVideoPartManager$8
  implements Runnable
{
  EditVideoPartManager$8(EditVideoPartManager paramEditVideoPartManager, Intent paramIntent) {}
  
  public void run()
  {
    if (this.this$0.I.h() != 14)
    {
      String str = this.a.getStringExtra("key_video_save_path");
      EditVideoPartManager.a(this.this$0, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.8
 * JD-Core Version:    0.7.0.1
 */