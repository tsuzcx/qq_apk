package com.tencent.mobileqq.activity.aio.qim;

import aeks;
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
      aeks localaeks = (aeks)localIterator.next();
      if (localaeks.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView != null) {
        localaeks.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setImageDrawable(localaeks.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      localaeks.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = null;
      localaeks.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.a.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5.1
 * JD-Core Version:    0.7.0.1
 */