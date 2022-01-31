package com.tencent.mobileqq.activity.aio.qim;

import aekq;
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
      aekq localaekq = (aekq)localIterator.next();
      if (localaekq.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView != null) {
        localaekq.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setImageDrawable(localaekq.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      localaekq.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = null;
      localaekq.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.a.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5.1
 * JD-Core Version:    0.7.0.1
 */