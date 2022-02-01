package com.tencent.aelight.camera.aeeditor.view;

import android.os.CountDownTimer;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class AEEditorLoadingView$4
  extends CountDownTimer
{
  AEEditorLoadingView$4(AEEditorLoadingView paramAEEditorLoadingView, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    AEEditorLoadingView.a(this.a);
    QQToast.a(BaseApplicationImpl.getContext(), 2064515209, 1).a();
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView.4
 * JD-Core Version:    0.7.0.1
 */