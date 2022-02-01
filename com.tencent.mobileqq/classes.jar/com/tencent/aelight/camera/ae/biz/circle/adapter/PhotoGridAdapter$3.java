package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class PhotoGridAdapter$3
  implements View.OnClickListener
{
  PhotoGridAdapter$3(PhotoGridAdapter paramPhotoGridAdapter, LocalMediaInfo paramLocalMediaInfo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.c.a(this.a))
    {
      QQToast.makeText(paramView.getContext(), HardCodeUtil.a(2064187570), 0).show();
      return;
    }
    paramView = this.c;
    PhotoGridAdapter.a(paramView, paramView.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.3
 * JD-Core Version:    0.7.0.1
 */