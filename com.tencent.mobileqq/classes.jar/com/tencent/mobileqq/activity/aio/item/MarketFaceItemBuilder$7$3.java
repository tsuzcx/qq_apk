package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.qphone.base.util.QLog;

class MarketFaceItemBuilder$7$3
  implements Runnable
{
  MarketFaceItemBuilder$7$3(MarketFaceItemBuilder.7 param7, MarketFaceItemBuilder.Holder paramHolder, Emoticon paramEmoticon) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder;
    if ((localObject != null) && (((MarketFaceItemBuilder.Holder)localObject).f != null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.f) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.a.isDPCSupportH5Magic()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setImageResource(2130837974);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("magicFaceIcon visible,h5source download sucess and doesnot needplay epId = ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
          QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.3
 * JD-Core Version:    0.7.0.1
 */