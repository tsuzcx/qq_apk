package com.tencent.mobileqq.activity.emogroupstore;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ImgPreviewAdapter$1
  implements View.OnClickListener
{
  ImgPreviewAdapter$1(ImgPreviewAdapter paramImgPreviewAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a;
    localObject = ((ImgPreviewAdapter)localObject).a(ImgPreviewAdapter.a((ImgPreviewAdapter)localObject).getCurrentItem());
    if (localObject != null)
    {
      if (((EmoticonFromGroupEntity)localObject).msg != null) {
        ImgPreviewAdapter.a(this.a).a(ImgPreviewAdapter.a(this.a), ((EmoticonFromGroupEntity)localObject).msg, paramView);
      } else {
        QLog.e("ImgPreviewAdapter.msgnull", 1, "img click msg is null.");
      }
    }
    else {
      QLog.e("ImgPreviewAdapter.emonull", 1, "img click emo is null.");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter.1
 * JD-Core Version:    0.7.0.1
 */