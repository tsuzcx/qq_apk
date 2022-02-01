package com.tencent.aelight.camera.aeeditor.view;

import android.os.CountDownTimer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class AEEditorLoadingView$4
  extends CountDownTimer
{
  AEEditorLoadingView$4(AEEditorLoadingView paramAEEditorLoadingView, long paramLong1, long paramLong2, int paramInt)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    AEEditorLoadingView.a(this.b);
    if (this.a == 4)
    {
      QQToast.makeText(BaseApplicationImpl.getContext(), 2064187560, 1).show();
      return;
    }
    QQToast.makeText(BaseApplicationImpl.getContext(), 2064187555, 1).show();
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView.4
 * JD-Core Version:    0.7.0.1
 */