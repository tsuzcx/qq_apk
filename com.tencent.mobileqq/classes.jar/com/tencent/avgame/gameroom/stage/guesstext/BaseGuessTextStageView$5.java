package com.tencent.avgame.gameroom.stage.guesstext;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.UiUtils;
import com.tencent.qphone.base.util.QLog;

class BaseGuessTextStageView$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseGuessTextStageView$5(BaseGuessTextStageView paramBaseGuessTextStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.b.e.getWidth() - this.b.e.getPaddingLeft() - this.b.e.getPaddingRight();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameTopicTips tip = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("BaseGuessTextStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameTopicTips tipWidth  = ");
      ((StringBuilder)localObject).append(this.b.e.getWidth());
      QLog.d("BaseGuessTextStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowGameTopicTips caluWidth  = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("BaseGuessTextStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      this.b.e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      StringBuilder localStringBuilder;
      if (UiUtils.a(this.b.e) > 1)
      {
        this.b.g.setBackgroundDrawable(this.b.c.a().f());
        localObject = this.b.g.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.b.g.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 130 / 478);
        this.b.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onShowMosaicImageGameTopicTips 130 w = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
          localStringBuilder.append(", h = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
          QLog.d("BaseGuessTextStageView", 2, localStringBuilder.toString());
        }
      }
      else
      {
        this.b.g.setBackgroundDrawable(this.b.c.a().e());
        localObject = this.b.g.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.b.g.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 110 / 478);
        this.b.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onShowMosaicImageGameTopicTips 110 w = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).width);
          localStringBuilder.append(", h = ");
          localStringBuilder.append(((ViewGroup.LayoutParams)localObject).height);
          QLog.d("BaseGuessTextStageView", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView.5
 * JD-Core Version:    0.7.0.1
 */