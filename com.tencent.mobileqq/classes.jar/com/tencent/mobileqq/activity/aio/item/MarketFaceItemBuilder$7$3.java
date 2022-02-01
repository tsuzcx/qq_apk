package com.tencent.mobileqq.activity.aio.item;

import agif;
import agip;
import agis;
import android.widget.ImageView;
import areb;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class MarketFaceItemBuilder$7$3
  implements Runnable
{
  public MarketFaceItemBuilder$7$3(agip paramagip, agis paramagis, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Agis != null) && (this.jdField_a_of_type_Agis.f != null))
    {
      if ((!this.jdField_a_of_type_Agip.a.f) || (!this.jdField_a_of_type_Agip.a.a.b())) {
        break label107;
      }
      this.jdField_a_of_type_Agis.f.setVisibility(0);
      this.jdField_a_of_type_Agis.f.setImageResource(2130838039);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and doesnot needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    return;
    label107:
    this.jdField_a_of_type_Agis.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.3
 * JD-Core Version:    0.7.0.1
 */