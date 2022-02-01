package com.tencent.mobileqq.activity.aio.item;

import ahaw;
import ahbg;
import ahbj;
import android.widget.ImageView;
import asih;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class MarketFaceItemBuilder$7$3
  implements Runnable
{
  public MarketFaceItemBuilder$7$3(ahbg paramahbg, ahbj paramahbj, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ahbj != null) && (this.jdField_a_of_type_Ahbj.f != null))
    {
      if ((!this.jdField_a_of_type_Ahbg.a.f) || (!this.jdField_a_of_type_Ahbg.a.a.b())) {
        break label107;
      }
      this.jdField_a_of_type_Ahbj.f.setVisibility(0);
      this.jdField_a_of_type_Ahbj.f.setImageResource(2130838053);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and doesnot needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    return;
    label107:
    this.jdField_a_of_type_Ahbj.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.3
 * JD-Core Version:    0.7.0.1
 */