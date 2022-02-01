package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class ConversationTitleBtnCtrl$2
  implements URLDrawable.URLDrawableListener
{
  ConversationTitleBtnCtrl$2(ConversationTitleBtnCtrl paramConversationTitleBtnCtrl) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (ConversationTitleBtnCtrl.b(this.a) != null) {
      ConversationTitleBtnCtrl.b(this.a).setVisibility(0);
    }
    if (ConversationTitleBtnCtrl.c(this.a) != null) {
      ConversationTitleBtnCtrl.c(this.a).setVisibility(8);
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (ConversationTitleBtnCtrl.b(this.a) != null) {
      ConversationTitleBtnCtrl.b(this.a).setVisibility(0);
    }
    if (ConversationTitleBtnCtrl.c(this.a) != null) {
      ConversationTitleBtnCtrl.c(this.a).setVisibility(8);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (ConversationTitleBtnCtrl.d(this.a) != null) {
      ConversationTitleBtnCtrl.d(this.a).setVisibility(8);
    }
    if (ConversationTitleBtnCtrl.e(this.a) != null) {
      ConversationTitleBtnCtrl.e(this.a).setVisibility(8);
    }
    if (ConversationTitleBtnCtrl.c(this.a) != null) {
      ConversationTitleBtnCtrl.c(this.a).setVisibility(0);
    }
    QCircleHostConfig.setNeedShowMessageEntranceAnim(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.2
 * JD-Core Version:    0.7.0.1
 */