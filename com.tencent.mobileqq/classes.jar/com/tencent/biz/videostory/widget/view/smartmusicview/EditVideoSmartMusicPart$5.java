package com.tencent.biz.videostory.widget.view.smartmusicview;

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
      this.a.a(HardCodeUtil.a(2131703899));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    EditVideoSmartMusicPart localEditVideoSmartMusicPart;
    StringBuilder localStringBuilder;
    if (EditVideoSmartMusicPart.a(this.a) != null)
    {
      localEditVideoSmartMusicPart = this.a;
      localStringBuilder = new StringBuilder().append(HardCodeUtil.a(2131703788)).append(EditVideoSmartMusicPart.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localEditVideoSmartMusicPart.a(i + "\n抽帧字节数：" + EditVideoSmartMusicPart.a(this.a).b() + "KB");
      EditVideoSmartMusicPart.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.5
 * JD-Core Version:    0.7.0.1
 */