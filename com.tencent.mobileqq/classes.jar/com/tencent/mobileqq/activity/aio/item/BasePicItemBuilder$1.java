package com.tencent.mobileqq.activity.aio.item;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.FileSaveToastUtils;
import com.tencent.mobileqq.multimsg.save.ISingleFileSaveCallBack;
import com.tencent.qphone.base.util.QLog;

class BasePicItemBuilder$1
  implements ISingleFileSaveCallBack
{
  BasePicItemBuilder$1(BasePicItemBuilder paramBasePicItemBuilder, BasePicItemBuilder.Holder paramHolder, String paramString) {}
  
  public void a()
  {
    if (this.a.b != null)
    {
      this.a.b.setVisibility(8);
      this.a.b.setProgressKey(this.b);
      this.a.b.b(this.b);
      this.a.b.setProcessor(null);
      ((RelativeLayout)this.a.h).removeView(this.a.b);
      this.a.b = null;
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicItemBuilder", 2, "dealFileSaveUI onSaveComplete");
    }
    if (paramFileSaveResult != null)
    {
      if (paramFileSaveResult.b == 0) {
        FileSaveToastUtils.a(this.c.e);
      } else {
        FileSaveToastUtils.b(this.c.e);
      }
      paramFileSaveResult.g.b(this);
    }
    if (this.a.b != null)
    {
      this.a.b.setVisibility(8);
      this.a.b.setProgressKey(this.b);
      this.a.b.b(this.b);
      this.a.b.setProcessor(null);
      ((RelativeLayout)this.a.h).removeView(this.a.b);
      this.a.b = null;
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    if (this.a.b != null)
    {
      this.a.b.setProgress(paramInt);
      this.a.b.invalidate();
    }
  }
  
  public void b(FileSaveResult paramFileSaveResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BasePicItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */