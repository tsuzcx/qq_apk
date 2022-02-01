package com.tencent.aelight.camera.aioeditor;

import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class EditVideoSmartMusicPart$5
  implements FrameVideoHelper.GetFrameByteArrayListener
{
  EditVideoSmartMusicPart$5(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(HardCodeUtil.a(2131901924));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    if (EditVideoSmartMusicPart.n(this.a) != null)
    {
      EditVideoSmartMusicPart localEditVideoSmartMusicPart = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131901846));
      localStringBuilder.append(EditVideoSmartMusicPart.n(this.a).b());
      localStringBuilder.append("ms\n抽取图片数：");
      int i;
      if (paramArrayList == null) {
        i = 0;
      } else {
        i = paramArrayList.size();
      }
      localStringBuilder.append(i);
      localStringBuilder.append("\n抽帧字节数：");
      localStringBuilder.append(EditVideoSmartMusicPart.n(this.a).c());
      localStringBuilder.append("KB");
      localEditVideoSmartMusicPart.a(localStringBuilder.toString());
    }
    EditVideoSmartMusicPart.a(this.a, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.5
 * JD-Core Version:    0.7.0.1
 */