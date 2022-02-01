package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryTask.Query;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;

class MarketFaceItemBuilder$3
  implements QueryTask.Query<MarkFaceMessage, Void>
{
  MarketFaceItemBuilder$3(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public Void a(MarkFaceMessage paramMarkFaceMessage)
  {
    paramMarkFaceMessage = (IPicEmoticonInfo)((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a.getRuntimeService(IEmoticonManagerService.class)).syncGetEmoticonInfo(paramMarkFaceMessage);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo = paramMarkFaceMessage;
    if ((paramMarkFaceMessage != null) && (paramMarkFaceMessage.getEmoticon() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = ((IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(paramMarkFaceMessage.getEmoticon().epId);
    }
    MagicfaceViewController.a();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */