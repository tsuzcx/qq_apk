package com.tencent.mobileqq.activity.aio.item;

import ahch;
import ahcq;
import ahcu;
import android.widget.ImageView;
import arup;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class MarketFaceItemBuilder$6$3
  implements Runnable
{
  public MarketFaceItemBuilder$6$3(ahcq paramahcq, ahcu paramahcu, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ahcu != null) && (this.jdField_a_of_type_Ahcu.f != null))
    {
      if ((!this.jdField_a_of_type_Ahcq.a.f) || (!this.jdField_a_of_type_Ahcq.a.a.b())) {
        break label107;
      }
      this.jdField_a_of_type_Ahcu.f.setVisibility(0);
      this.jdField_a_of_type_Ahcu.f.setImageResource(2130838005);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and doesnot needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    return;
    label107:
    this.jdField_a_of_type_Ahcu.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.3
 * JD-Core Version:    0.7.0.1
 */