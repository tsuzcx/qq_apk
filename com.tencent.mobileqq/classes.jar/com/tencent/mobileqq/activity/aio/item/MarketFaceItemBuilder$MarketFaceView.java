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
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
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
    if ((!EmoticonUtils.isWifiOrG3OrG4()) || (2 != paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) || (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.f(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)) || (!MagicfaceViewController.a()) || (EmoticonUtils.needDisableAutoReceiveMagicFace()))
    {
      float f = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId);
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
      paramThrowable.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(HardCodeUtil.a(2131706474));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    MarketFaceItemBuilder.Holder localHolder = (MarketFaceItemBuilder.Holder)AIOUtils.a(this);
    super.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    super.setImageDrawable(paramURLDrawable);
    if (localHolder == null)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  holder == null url=" + paramURLDrawable.getURL());
      return;
    }
    if (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
    {
      paramURLDrawable = localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!(paramURLDrawable instanceof MessageForMarketFace)) {
        break label433;
      }
      paramURLDrawable = ((MessageForMarketFace)paramURLDrawable).mMarkFaceMessage;
      if (paramURLDrawable == null) {
        break label433;
      }
    }
    label412:
    label431:
    label433:
    for (int i = paramURLDrawable.dwTabID;; i = -1)
    {
      QLog.e("MarketFaceItemBuilder", 1, "onLoadSuccessed  emoticonInfo == null epId = " + i);
      return;
      a(localHolder);
      this.a.a(localHolder, paramURLDrawable);
      if ((2 == localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (MagicfaceViewController.a()) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.f(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId)))
      {
        if (PngFrameUtil.a(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.magicValue) == 1) {
          localHolder.f.setVisibility(8);
        }
      }
      else
      {
        if ((4 == localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.b()) && (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, true, true)) && (!this.a.jdField_b_of_type_Boolean))
        {
          localHolder.f.setImageResource(2130838125);
          localHolder.f.setVisibility(0);
        }
        if ((MarketFaceItemBuilder.c != 0L) && (MarketFaceItemBuilder.c == localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) && (localHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.isSound()))
        {
          if (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isVideoChatting()) {
            break label412;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131695173, 0).b(this.a.jdField_b_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
        }
      }
      for (;;)
      {
        if (!AppSetting.d) {
          break label431;
        }
        localHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription("");
        return;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        localHolder.f.setImageResource(2130838125);
        localHolder.f.setVisibility(0);
        break;
        MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.MarketFaceView
 * JD-Core Version:    0.7.0.1
 */