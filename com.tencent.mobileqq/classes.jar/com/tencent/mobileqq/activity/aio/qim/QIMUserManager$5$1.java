package com.tencent.mobileqq.activity.aio.qim;

import aifo;
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
      aifo localaifo = (aifo)localIterator.next();
      if (localaifo.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView != null) {
        localaifo.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setImageDrawable(localaifo.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      localaifo.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = null;
      localaifo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    this.a.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5.1
 * JD-Core Version:    0.7.0.1
 */