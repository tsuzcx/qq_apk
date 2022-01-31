package com.tencent.mobileqq.activity.aio.item;

import afvg;
import afvs;
import afvu;
import android.widget.ImageView;
import apro;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class MarketFaceItemBuilder$9$3
  implements Runnable
{
  public MarketFaceItemBuilder$9$3(afvs paramafvs, afvu paramafvu, Emoticon paramEmoticon) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Afvu != null) && (this.jdField_a_of_type_Afvu.f != null))
    {
      if ((!this.jdField_a_of_type_Afvs.a.f) || (!this.jdField_a_of_type_Afvs.a.a.b())) {
        break label107;
      }
      this.jdField_a_of_type_Afvu.f.setVisibility(0);
      this.jdField_a_of_type_Afvu.f.setImageResource(2130837911);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 2, "magicFaceIcon visible,h5source download sucess and doesnot needplay epId = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
    }
    return;
    label107:
    this.jdField_a_of_type_Afvu.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.9.3
 * JD-Core Version:    0.7.0.1
 */