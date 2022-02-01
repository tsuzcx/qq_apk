package com.tencent.mobileqq.activity.aio.item;

import ahlt;
import ahmc;
import ahmg;
import android.widget.ImageView;
import askd;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class MarketFaceItemBuilder$6$3
  implements Runnable
{
  public MarketFaceItemBuilder$6$3(ahmc paramahmc, ahmg paramahmg, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ahmg != null) && (this.jdField_a_of_type_Ahmg.f != null))
    {
      if ((!this.jdField_a_of_type_Ahmc.a.f) || (!this.jdField_a_of_type_Ahmc.a.a.b())) {
        break label107;
      }
      this.jdField_a_of_type_Ahmg.f.setVisibility(0);
      this.jdField_a_of_type_Ahmg.f.setImageResource(2130838014);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and doesnot needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    return;
    label107:
    this.jdField_a_of_type_Ahmg.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6.3
 * JD-Core Version:    0.7.0.1
 */