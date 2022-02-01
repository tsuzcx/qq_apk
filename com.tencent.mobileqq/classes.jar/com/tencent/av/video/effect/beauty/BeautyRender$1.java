package com.tencent.av.video.effect.beauty;

import com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyFilter;
import com.tencent.av.video.effect.filter.FilterFactory;
import java.io.File;

class BeautyRender$1
  implements Runnable
{
  BeautyRender$1(BeautyRender paramBeautyRender, String paramString) {}
  
  public void run()
  {
    BeautyRender.access$002(this.this$0, new QQAVImageBeautyFilter());
    QQAVImageBeautyFilter localQQAVImageBeautyFilter = BeautyRender.access$000(this.this$0);
    FilterFactory localFilterFactory = BeautyRender.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$resPath);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("SKINCOLOR");
    localQQAVImageBeautyFilter.setSkinColorFilter(localFilterFactory.getFilter(localStringBuilder.toString()));
    BeautyRender.access$000(this.this$0).init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.BeautyRender.1
 * JD-Core Version:    0.7.0.1
 */