package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

class MarketFaceItemBuilder$7$2
  implements Runnable
{
  MarketFaceItemBuilder$7$2(MarketFaceItemBuilder.7 param7, Emoticon paramEmoticon, String paramString, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
    if ((localObject1 != null) && (((Emoticon)localObject1).jobType == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.b != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.b instanceof BaseActivity)))
    {
      localObject1 = ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.b).getChatFragment();
      if (localObject1 != null)
      {
        localObject1 = ((ChatFragment)localObject1).a();
        if ((localObject1 != null) && (MagicfaceViewController.a()))
        {
          localObject1 = (AIOEmoticonUIHelper)((BaseChatPie)localObject1).a(105);
          if (localObject1 != null) {
            ((AIOEmoticonUIHelper)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 1, this.jdField_a_of_type_JavaLangString, false);
          }
        }
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, "", "", "", "");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
    if ((localObject1 != null) && (((Emoticon)localObject1).jobType == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.canPlayH5Magic()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.f)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setImageResource(2130837974);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("magicFaceIcon visible,h5source download sucess and needplay epId = ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
          QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.f.setVisibility(8);
      }
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.b, H5MagicPlayerActivity.class);
      ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("autoPlay", "1");
      ((Intent)localObject1).putExtra("senderUin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("selfUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("sessionInfo", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      ((Intent)localObject1).putExtra("emoticon", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      Object localObject2 = (IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
      EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)localObject2).syncFindEmoticonPackageById(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localEmoticonPackage != null)
      {
        localObject2 = ((IEmoticonManagerService)localObject2).syncGetSubEmoticonsByPackageId(localEmoticonPackage.childEpId);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$7.a.b.startActivity((Intent)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.2
 * JD-Core Version:    0.7.0.1
 */