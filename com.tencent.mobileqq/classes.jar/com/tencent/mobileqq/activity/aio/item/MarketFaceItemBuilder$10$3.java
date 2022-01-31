package com.tencent.mobileqq.activity.aio.item;

import adje;
import adjg;
import adjt;
import android.widget.ImageView;
import anfj;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class MarketFaceItemBuilder$10$3
  implements Runnable
{
  public MarketFaceItemBuilder$10$3(adjg paramadjg, adjt paramadjt, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Adjt != null) && (this.jdField_a_of_type_Adjt.f != null))
    {
      if ((!this.jdField_a_of_type_Adjg.a.f) || (!this.jdField_a_of_type_Adjg.a.a.b())) {
        break label107;
      }
      this.jdField_a_of_type_Adjt.f.setVisibility(0);
      this.jdField_a_of_type_Adjt.f.setImageResource(2130837704);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and doesnot needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    return;
    label107:
    this.jdField_a_of_type_Adjt.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.10.3
 * JD-Core Version:    0.7.0.1
 */