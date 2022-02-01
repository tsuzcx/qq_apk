package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;

class PhotoGridAdapter$4
  implements View.OnClickListener
{
  PhotoGridAdapter$4(PhotoGridAdapter paramPhotoGridAdapter, LocalMediaInfo paramLocalMediaInfo, PhotoGridAdapter.PhotoVH paramPhotoVH, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.d.a(this.a))
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2064187570), 0).show();
      this.b.d.setChecked(false);
      return;
    }
    PhotoGridAdapter.a(this.d, this.c, this.b);
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.4
 * JD-Core Version:    0.7.0.1
 */