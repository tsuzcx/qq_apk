package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;

class QCircleBaseMessagePresenter$5
  implements Runnable
{
  QCircleBaseMessagePresenter$5(QCircleBaseMessagePresenter paramQCircleBaseMessagePresenter) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.this$0.f.getHitRect((Rect)localObject);
    int i = ViewUtils.a(10.0F);
    ((Rect)localObject).left -= i;
    ((Rect)localObject).top -= i;
    ((Rect)localObject).right += i;
    ((Rect)localObject).bottom += i;
    localObject = new TouchDelegate((Rect)localObject, this.this$0.f);
    this.this$0.a.setTouchDelegate((TouchDelegate)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBaseMessagePresenter.5
 * JD-Core Version:    0.7.0.1
 */