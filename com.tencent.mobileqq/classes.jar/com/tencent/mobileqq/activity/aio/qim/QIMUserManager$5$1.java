package com.tencent.mobileqq.activity.aio.qim;

import ahce;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.util.ArrayList;
import java.util.Iterator;

class QIMUserManager$5$1
  implements Runnable
{
  QIMUserManager$5$1(QIMUserManager.5 param5) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      ahce localahce = (ahce)localIterator.next();
      if (localahce.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView != null) {
        localahce.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setImageDrawable(localahce.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      localahce.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = null;
      localahce.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.a.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5.1
 * JD-Core Version:    0.7.0.1
 */