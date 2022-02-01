package com.tencent.biz.qqcircle.fragments.person;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import vpp;

public class QCirclePersonalBottomView$2$1
  implements Runnable
{
  public QCirclePersonalBottomView$2$1(vpp paramvpp) {}
  
  public void run()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView.getResources();
    if (this.a.jdField_a_of_type_Boolean) {}
    for (int i = 2130844019;; i = 2130844020)
    {
      localObject = ((Resources)localObject).getDrawable(i);
      QCirclePersonalBottomView.a(this.a.jdField_a_of_type_ComTencentBizQqcircleFragmentsPersonQCirclePersonalBottomView).setImageDrawable((Drawable)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonalBottomView.2.1
 * JD-Core Version:    0.7.0.1
 */