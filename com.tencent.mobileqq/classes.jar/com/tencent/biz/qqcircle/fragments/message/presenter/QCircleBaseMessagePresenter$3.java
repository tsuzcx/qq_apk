package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import bhtq;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import von;

public class QCircleBaseMessagePresenter$3
  implements Runnable
{
  public QCircleBaseMessagePresenter$3(von paramvon) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.this$0.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.getHitRect((Rect)localObject);
    int i = bhtq.b(10.0F);
    ((Rect)localObject).left -= i;
    ((Rect)localObject).top -= i;
    ((Rect)localObject).right += i;
    ((Rect)localObject).bottom = (i + ((Rect)localObject).bottom);
    localObject = new TouchDelegate((Rect)localObject, this.this$0.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView);
    this.this$0.jdField_a_of_type_AndroidViewView.setTouchDelegate((TouchDelegate)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBaseMessagePresenter.3
 * JD-Core Version:    0.7.0.1
 */