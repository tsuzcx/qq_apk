package com.tencent.mobileqq.activity.emogroupstore;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImgPreviewAdapter$1
  implements View.OnClickListener
{
  ImgPreviewAdapter$1(ImgPreviewAdapter paramImgPreviewAdapter) {}
  
  public void onClick(View paramView)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = this.a.a(ImgPreviewAdapter.a(this.a).getCurrentItem());
    if (localEmoticonFromGroupEntity != null) {
      if (localEmoticonFromGroupEntity.msg != null) {
        ImgPreviewAdapter.a(this.a).a(ImgPreviewAdapter.a(this.a), localEmoticonFromGroupEntity.msg, paramView);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("ImgPreviewAdapter.msgnull", 1, "img click msg is null.");
      continue;
      QLog.e("ImgPreviewAdapter.emonull", 1, "img click emo is null.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter.1
 * JD-Core Version:    0.7.0.1
 */