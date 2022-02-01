package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.IHeadIconProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutViewWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListenerController;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class StickerHandler
  extends ChatLayoutHandler
{
  public StickerHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private int a(Context paramContext, BaseBubbleBuilder.ViewHolder paramViewHolder, StickerHandler.HandleStickersParams paramHandleStickersParams, List<MessageRecord> paramList, int paramInt)
  {
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IEmoticonManagerService.class);
    int k = paramList.size() - 1;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (k >= 0)
    {
      Object localObject2 = (MessageRecord)paramList.get(k);
      if (((MessageRecord)localObject2).extraflag == 32768)
      {
        j = paramInt + 1;
        paramInt = j;
      }
      for (;;)
      {
        break label592;
        StickerInfo localStickerInfo = EmojiStickerManager.a((MessageRecord)localObject2);
        j = paramInt;
        if (localStickerInfo == null) {
          break;
        }
        j = paramInt;
        if (!EmojiStickerManager.c((MessageRecord)localObject2)) {
          break;
        }
        i += 1;
        if (i > QVipStickerProcessor.jdField_c_of_type_Int)
        {
          ((MessageRecord)localObject2).msgtype = -2006;
          paramInt += 1;
        }
        else
        {
          Object localObject1 = a(localIEmoticonManagerService, (MessageRecord)localObject2, null);
          if (localStickerInfo.x <= 1.0F) {
            j = (int)(localStickerInfo.x * paramHandleStickersParams.jdField_a_of_type_Int);
          } else {
            j = paramHandleStickersParams.jdField_a_of_type_Int;
          }
          int n;
          if (localStickerInfo.y <= 1.0F) {
            n = (int)(localStickerInfo.y * paramHandleStickersParams.jdField_a_of_type_Int);
          } else {
            n = paramHandleStickersParams.jdField_a_of_type_Int;
          }
          int m;
          if (localStickerInfo.width <= 1.0F) {
            m = (int)(localStickerInfo.width * paramHandleStickersParams.jdField_a_of_type_Int);
          } else {
            m = paramHandleStickersParams.jdField_a_of_type_Int;
          }
          int i1;
          if (localStickerInfo.height <= 1.0F) {
            i1 = (int)(localStickerInfo.height * paramHandleStickersParams.jdField_a_of_type_Int);
          } else {
            i1 = paramHandleStickersParams.jdField_a_of_type_Int;
          }
          int i2 = localStickerInfo.rotate;
          int i3 = a(paramViewHolder, paramHandleStickersParams, paramList, k, n);
          String str = "";
          if ((localObject1 instanceof IPicEmoticonInfo))
          {
            localObject2 = (IPicEmoticonInfo)localObject1;
            if (((IPicEmoticonInfo)localObject2).getEmoticon() != null)
            {
              if ((!EmojiStickerManager.g) && (FileUtils.getAvailableInnernalMemorySize() > 1.048576E+008F)) {
                n = 1;
              } else {
                n = 0;
              }
              if (n != 0) {
                localObject1 = ((IPicEmoticonInfo)localObject2).getLoadingDrawable("fromAIO", true, false, null, m, m);
              } else {
                localObject1 = ((IPicEmoticonInfo)localObject2).getDrawable(paramContext, paramHandleStickersParams.jdField_a_of_type_Float);
              }
              str = ((IPicEmoticonInfo)localObject2).getEmoticon().epId;
            }
            else
            {
              localObject1 = null;
            }
          }
          else
          {
            if (!(localObject1 instanceof SystemAndEmojiEmoticonInfo)) {
              break label445;
            }
          }
          for (localObject1 = ((SystemAndEmojiEmoticonInfo)localObject1).getBigDrawable(paramContext, paramHandleStickersParams.jdField_a_of_type_Float);; localObject1 = ((ISmallEmoticonInfo)localObject1).getBigDrawable(paramContext, paramHandleStickersParams.jdField_a_of_type_Float))
          {
            str = "";
            break label522;
            label445:
            if (!(localObject1 instanceof ISmallEmoticonInfo)) {
              break;
            }
          }
          if ((localObject2 instanceof MessageForPic))
          {
            localObject1 = PicItemBuilder.a(paramContext, (MessageForPic)localObject2);
            ThreadManager.post(new StickerHandler.2(this, (MessageRecord)localObject2), 5, null, true);
            str = "";
          }
          else
          {
            str = "";
            localObject1 = null;
          }
          label522:
          if (localObject1 != null)
          {
            localObject2 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
            double d = i2;
            boolean bool = localStickerInfo.isShown;
            float f;
            if (localStickerInfo.isShown) {
              f = 1.0F;
            } else {
              f = 1.1F;
            }
            ((BaseChatItemLayout)localObject2).a((Drawable)localObject1, j, i3, m, i1, d, str, bool, f, localStickerInfo);
          }
        }
      }
      label592:
      k -= 1;
    }
    return paramInt;
  }
  
  private int a(BaseBubbleBuilder.ViewHolder paramViewHolder, StickerHandler.HandleStickersParams paramHandleStickersParams, List<MessageRecord> paramList, int paramInt1, int paramInt2)
  {
    int i = paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramInt2;
    paramInt2 = i;
    if (paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramInt2 = AIOUtils.b(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources());
      paramInt2 = i + (paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin + paramInt2);
    }
    i = paramInt2;
    if (paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      i = AIOUtils.b(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources());
      i = paramInt2 + (paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin + i);
    }
    paramInt2 = i;
    if (i < 0)
    {
      int j = -i;
      if (paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
        paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      }
      if (paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
        paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      } else {
        paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      }
      if (paramHandleStickersParams.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
        paramHandleStickersParams.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      }
      if (paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
        paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      }
      i = 0;
      paramInt2 = i;
      if (paramInt1 != paramList.size() - 1)
      {
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c(j);
        paramInt2 = i;
      }
    }
    return paramInt2;
  }
  
  private EmoticonInfo a(IEmoticonManagerService paramIEmoticonManagerService, MessageRecord paramMessageRecord, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramMessageRecord instanceof MessageForMarketFace)) {
      return paramIEmoticonManagerService.syncGetEmoticonInfo(((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage);
    }
    paramIEmoticonManagerService = paramEmoticonInfo;
    if ((paramMessageRecord instanceof MessageForText))
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      paramIEmoticonManagerService = paramEmoticonInfo;
      if (!TextUtils.isEmpty(paramMessageRecord.msg)) {
        paramIEmoticonManagerService = EmojiStickerManager.a().a(paramMessageRecord.msg);
      }
    }
    return paramIEmoticonManagerService;
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    boolean bool = paramBaseChatItemLayout.a();
    if ((paramView != null) && (paramView.getId() == 2131364521) && (!bool) && (EmojiStickerManager.d(paramChatMessage)) && (paramChatMessage.fakeSenderType == 0))
    {
      StickerHandler.HandleStickersParams localHandleStickersParams = new StickerHandler.HandleStickersParams(this);
      a(paramContext, paramView, paramChatMessage, paramBaseChatItemLayout, localHandleStickersParams);
      if ((localHandleStickersParams.jdField_a_of_type_JavaUtilList != null) && (localHandleStickersParams.jdField_a_of_type_JavaUtilList.size() > 0) && (EmojiStickerManager.b(paramChatMessage)))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localHandleStickersParams.jdField_a_of_type_JavaUtilList);
        if (a(paramContext, paramViewHolder, localHandleStickersParams, paramView, 0) != paramView.size())
        {
          paramView = new Bundle();
          paramView.putBoolean("haveTimeStamp", localHandleStickersParams.jdField_a_of_type_Boolean);
          paramView.putBoolean("haveNickName", localHandleStickersParams.jdField_b_of_type_Boolean);
          paramView.putBoolean("havePendant", localHandleStickersParams.jdField_c_of_type_Boolean);
          paramView.putBoolean("haveTroopMemberLevel", localHandleStickersParams.jdField_d_of_type_Boolean);
          if (localHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
          {
            paramView.putInt("timeStampTop", localHandleStickersParams.jdField_b_of_type_Int);
            paramView.putInt("timeStampBottom", localHandleStickersParams.jdField_c_of_type_Int);
          }
          if (localHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
          {
            paramView.putInt("textViewTop", localHandleStickersParams.jdField_d_of_type_Int);
            paramView.putInt("textViewBottom", localHandleStickersParams.jdField_e_of_type_Int);
          }
          if (localHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
          {
            paramView.putInt("nickNameViewTop", localHandleStickersParams.jdField_f_of_type_Int);
            paramView.putInt("nickNameViewBottom", localHandleStickersParams.g);
          }
          if (localHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
          {
            paramView.putInt("headViewTop", localHandleStickersParams.h);
            paramView.putInt("headViewBottom", localHandleStickersParams.i);
          }
          if (localHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
          {
            paramView.putInt("pendantViewTop", localHandleStickersParams.j);
            paramView.putInt("pendantViewBottom", localHandleStickersParams.k);
          }
          if (localHandleStickersParams.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
          {
            paramView.putInt("troopMemberLevelTop", localHandleStickersParams.l);
            paramView.putInt("troopMemberLevelBottom", localHandleStickersParams.m);
          }
          paramBaseChatItemLayout.setTag(2131374109, paramView);
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerDoubleClickListener = new StickerHandler.1(this);
      }
      paramView = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
      if (paramView != null)
      {
        paramView = ((IHeadIconProcessor)paramView.a()).b();
        if (paramView != null)
        {
          paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          paramView.addRule(6, 2131364530);
          paramView.topMargin = (-AIOUtils.b(1.0F, paramContext.getResources()));
        }
      }
    }
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, StickerHandler.HandleStickersParams paramHandleStickersParams)
  {
    paramHandleStickersParams.jdField_a_of_type_JavaUtilList = EmojiStickerManager.a().a(paramChatMessage);
    paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    paramView = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
    if (paramView != null)
    {
      paramView = paramView.a();
      if ((paramView != null) && (paramView.checkViewNonNull())) {
        paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
      }
    }
    if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0)) {
      paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
    }
    paramView = (NickNameLayoutViewWrapper)paramBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
    if (paramView != null)
    {
      paramView = paramView.a();
      if ((paramView != null) && (paramView.checkViewNonNull())) {
        paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
      }
    }
    if ((paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView != null) && (paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)) {
      paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
    }
    paramHandleStickersParams.jdField_a_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    paramHandleStickersParams.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    if (paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramHandleStickersParams.jdField_a_of_type_Boolean = true;
      paramHandleStickersParams.jdField_b_of_type_Int = paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramHandleStickersParams.jdField_c_of_type_Int = paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramHandleStickersParams.jdField_d_of_type_Int = paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramHandleStickersParams.jdField_e_of_type_Int = paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramHandleStickersParams.jdField_b_of_type_Boolean = true;
      paramHandleStickersParams.jdField_f_of_type_Int = paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramHandleStickersParams.g = paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramHandleStickersParams.h = paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramHandleStickersParams.i = paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramHandleStickersParams.jdField_c_of_type_Boolean = true;
      paramHandleStickersParams.j = paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramHandleStickersParams.k = paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
    if (paramHandleStickersParams.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams != null)
    {
      paramHandleStickersParams.jdField_d_of_type_Boolean = true;
      paramHandleStickersParams.l = paramHandleStickersParams.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
      paramHandleStickersParams.m = paramHandleStickersParams.jdField_e_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin;
    }
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.b();
    StartupTracker.a(null, "AIO_Handle_Sticker_Cost");
    long l = System.currentTimeMillis();
    a(paramContext, paramViewHolder.jdField_a_of_type_AndroidViewView, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
    StartupTracker.a("AIO_Handle_Sticker_Cost", null);
    if (QLog.isColorLevel())
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("handleStickers time cost : ");
      paramChatMessage.append(System.currentTimeMillis() - l);
      paramChatMessage.append(" ms");
      QLog.d("StickerHandler", 2, paramChatMessage.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.StickerHandler
 * JD-Core Version:    0.7.0.1
 */