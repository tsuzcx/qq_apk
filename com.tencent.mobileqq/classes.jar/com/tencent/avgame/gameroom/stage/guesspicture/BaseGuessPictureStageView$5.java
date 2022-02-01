package com.tencent.avgame.gameroom.stage.guesspicture;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.UiUtils;
import com.tencent.qphone.base.util.QLog;

class BaseGuessPictureStageView$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseGuessPictureStageView$5(BaseGuessPictureStageView paramBaseGuessPictureStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.b.f.getWidth() - this.b.f.getPaddingLeft() - this.b.f.getPaddingRight();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowMosaicImageGameTopicTips tip = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("BaseGuessPictureStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowMosaicImageGameTopicTips tipWidth  = ");
      ((StringBuilder)localObject).append(this.b.f.getWidth());
      QLog.d("BaseGuessPictureStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowMosaicImageGameTopicTips caluWidth  = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("BaseGuessPictureStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      this.b.f.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      StringBuilder localStringBuilder;
      if (UiUtils.a(this.b.f) > 1)
      {
        this.b.m.setBackgroundDrawable(this.b.d.a().f());
        localObject = this.b.m.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.b.m.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 130 / 478);
        this.b.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onShowMosaicImageGameTopicTips 130 w = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
          localStringBuilder.append(", h = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
          QLog.d("BaseGuessPictureStageView", 2, localStringBuilder.toString());
        }
      }
      else
      {
        this.b.m.setBackgroundDrawable(this.b.d.a().e());
        localObject = this.b.m.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.b.m.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 110 / 478);
        this.b.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onShowMosaicImageGameTopicTips 110 w = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
          localStringBuilder.append(", h = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
          QLog.d("BaseGuessPictureStageView", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView.5
 * JD-Core Version:    0.7.0.1
 */