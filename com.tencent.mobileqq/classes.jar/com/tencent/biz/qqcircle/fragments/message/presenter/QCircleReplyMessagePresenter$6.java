package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;

class QCircleReplyMessagePresenter$6
  implements Runnable
{
  QCircleReplyMessagePresenter$6(QCircleReplyMessagePresenter paramQCircleReplyMessagePresenter, View paramView, int[] paramArrayOfInt, int paramInt) {}
  
  public void run()
  {
    this.a.getLocationOnScreen(this.b);
    Object localObject = this.b;
    localObject[1] += this.a.getHeight();
    if (this.b[1] > this.c)
    {
      QCircleReplyMessagePresenter.f(this.this$0).scrollBy(0, this.b[1] - this.c);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scrollItemToVisbleAboveInputLayout  postDelayed scrollBy: ");
      ((StringBuilder)localObject).append(this.b[1] - this.c);
      QLog.i("QCircleReplyMessagePresenter", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter.6
 * JD-Core Version:    0.7.0.1
 */