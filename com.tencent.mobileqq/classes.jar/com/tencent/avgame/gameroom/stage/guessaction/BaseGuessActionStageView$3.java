package com.tencent.avgame.gameroom.stage.guessaction;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.util.UiUtils;
import com.tencent.qphone.base.util.QLog;

class BaseGuessActionStageView$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BaseGuessActionStageView$3(BaseGuessActionStageView paramBaseGuessActionStageView, String paramString) {}
  
  public void onGlobalLayout()
  {
    int i = this.b.c.getWidth() - this.b.c.getPaddingLeft() - this.b.c.getPaddingRight();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic content = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("BaseGuessActionStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic contentWidth  = ");
      ((StringBuilder)localObject).append(this.b.c.getWidth());
      QLog.d("BaseGuessActionStageView", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateCurTopic caluWidth  = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("BaseGuessActionStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      this.b.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      if (UiUtils.a(this.b.c) > 1)
      {
        this.b.f.setBackgroundDrawable(this.b.a.a().f());
        localObject = this.b.f.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = this.b.f.getWidth();
        ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 130 / 478);
        this.b.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      this.b.f.setBackgroundDrawable(this.b.a.a().e());
      localObject = this.b.f.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.b.f.getWidth();
      ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * 110 / 478);
      this.b.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guessaction.BaseGuessActionStageView.3
 * JD-Core Version:    0.7.0.1
 */