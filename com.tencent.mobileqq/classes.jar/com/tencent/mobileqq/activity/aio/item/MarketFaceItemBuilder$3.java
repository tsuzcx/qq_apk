package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryTask.Query;

class MarketFaceItemBuilder$3
  implements QueryTask.Query<MarkFaceMessage, Void>
{
  MarketFaceItemBuilder$3(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public Void a(MarkFaceMessage paramMarkFaceMessage)
  {
    paramMarkFaceMessage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramMarkFaceMessage);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = paramMarkFaceMessage;
    if ((paramMarkFaceMessage != null) && (paramMarkFaceMessage.emoticon != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(paramMarkFaceMessage.emoticon.epId);
    }
    MagicfaceViewController.a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */