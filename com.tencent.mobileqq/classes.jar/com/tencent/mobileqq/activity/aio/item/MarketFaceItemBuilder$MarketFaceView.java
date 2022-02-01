package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MarketFaceItemBuilder$MarketFaceView
  extends URLImageView
{
  public MarketFaceItemBuilder$MarketFaceView(MarketFaceItemBuilder paramMarketFaceItemBuilder, Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(MarketFaceItemBuilder.Holder paramHolder)
  {
    if ((!EmoticonPanelUtils.a()) || (2 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) || (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.verifyMagicFacePackageIntact(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId)) || (!MagicfaceViewController.a()) || (EmoticonPanelUtils.c()))
    {
      float f = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.getEmoticonPackageLoadingProgress(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId);
      if ((f < 0.0F) || (1.0F == f))
      {
        paramHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setProgressVisable(false);
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 2, "onLoadSuccessed progressBar gone ");
        }
      }
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
    paramThrowable = (MarketFaceItemBuilder.Holder)AIOUtils.a(this);
    paramThrowable.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.a.a(paramThrowable, paramURLDrawable);
    if (AppSetting.d) {
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(HardCodeUtil.a(2131706521));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = (MarketFaceItemBuilder.Holder)AIOUtils.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLoadSuccessed  holder == null url=");
      ((StringBuilder)localObject).append(paramURLDrawable.getURL());
      QLog.e("MarketFaceItemBuilder", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo == null)
    {
      int j = -1;
      paramURLDrawable = ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      int i = j;
      if ((paramURLDrawable instanceof MessageForMarketFace))
      {
        paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
        i = j;
        if (paramURLDrawable != null) {
          i = paramURLDrawable.dwTabID;
        }
      }
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadSuccessed  emoticonInfo == null epId = ");
      paramURLDrawable.append(i);
      QLog.e("MarketFaceItemBuilder", 1, paramURLDrawable.toString());
      return;
    }
    a((MarketFaceItemBuilder.Holder)localObject);
    this.a.a((MarketFaceItemBuilder.Holder)localObject, paramURLDrawable);
    if ((2 == ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) && (MagicfaceViewController.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.verifyMagicFacePackageIntact(((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId))) {
      if (PngFrameUtil.a(((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().magicValue) == 1)
      {
        ((MarketFaceItemBuilder.Holder)localObject).f.setVisibility(8);
      }
      else if (!this.a.jdField_b_of_type_Boolean)
      {
        ((MarketFaceItemBuilder.Holder)localObject).f.setImageResource(2130837974);
        ((MarketFaceItemBuilder.Holder)localObject).f.setVisibility(0);
      }
    }
    if ((4 == ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().jobType) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.isDPCSupportH5Magic()) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonApiIEmojiManagerService.isH5MagicIntact(((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
    {
      ((MarketFaceItemBuilder.Holder)localObject).f.setImageResource(2130837974);
      ((MarketFaceItemBuilder.Holder)localObject).f.setVisibility(0);
    }
    if ((MarketFaceItemBuilder.c != 0L) && (MarketFaceItemBuilder.c == ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.isSound())) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695163, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      } else {
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
    }
    if (AppSetting.d) {
      ((MarketFaceItemBuilder.Holder)localObject).jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.MarketFaceView
 * JD-Core Version:    0.7.0.1
 */