package com.tencent.mobileqq.activity;

import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSimpleItem;

class PermisionPrivacyActivity$18
  implements URLDrawable.URLDrawableListener
{
  PermisionPrivacyActivity$18(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    if (PermisionPrivacyActivity.b(this.a) != null) {
      PermisionPrivacyActivity.b(this.a).postInvalidate();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, 0, 0);
    }
    if (PermisionPrivacyActivity.b(this.a) != null) {
      PermisionPrivacyActivity.b(this.a).postInvalidate();
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      paramURLDrawable.setBounds(0, 0, UIUtils.a(this.a.app.getApp(), 47.0F), UIUtils.a(this.a.app.getApp(), 14.0F));
    }
    if (PermisionPrivacyActivity.b(this.a) != null) {
      PermisionPrivacyActivity.b(this.a).postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.18
 * JD-Core Version:    0.7.0.1
 */