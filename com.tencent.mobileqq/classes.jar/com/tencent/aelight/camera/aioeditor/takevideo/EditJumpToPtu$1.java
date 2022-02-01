package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.biz.qqstory.support.logging.SLog;

class EditJumpToPtu$1
  implements Runnable
{
  EditJumpToPtu$1(EditJumpToPtu paramEditJumpToPtu) {}
  
  public void run()
  {
    EditJumpToPtu localEditJumpToPtu = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(EditPicConstants.a);
    localStringBuilder.append("qq_pic_Jump_");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(".png");
    EditJumpToPtu.a(localEditJumpToPtu, localStringBuilder.toString());
    localEditJumpToPtu = this.this$0;
    if (localEditJumpToPtu.a(EditJumpToPtu.a(localEditJumpToPtu)))
    {
      this.this$0.a.sendEmptyMessage(1);
      return;
    }
    EditJumpToPtu.a(this.this$0, null);
    SLog.e("EditJumpToPtu", "get rawBitmap error!");
    this.this$0.a.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditJumpToPtu.1
 * JD-Core Version:    0.7.0.1
 */