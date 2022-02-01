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
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListenerController;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
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
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
    int k = 0;
    int j = paramList.size() - 1;
    int i = paramInt;
    paramInt = k;
    Object localObject2;
    if (j >= 0)
    {
      localObject2 = (MessageRecord)paramList.get(j);
      if (((MessageRecord)localObject2).extraflag == 32768) {
        paramInt += 1;
      }
    }
    for (;;)
    {
      j -= 1;
      break;
      EmojiStickerManager.StickerInfo localStickerInfo = EmojiStickerManager.a((MessageRecord)localObject2);
      if ((localStickerInfo != null) && (EmojiStickerManager.c((MessageRecord)localObject2)))
      {
        i += 1;
        if (i > EmojiStickerManager.jdField_f_of_type_Int)
        {
          ((MessageRecord)localObject2).msgtype = -2006;
          paramInt += 1;
        }
        else
        {
          Object localObject1 = a(localEmoticonManager, (MessageRecord)localObject2, null);
          label167:
          int n;
          label191:
          int m;
          label215:
          int i1;
          label239:
          int i2;
          int i3;
          if (localStickerInfo.x <= 1.0F)
          {
            k = (int)(localStickerInfo.x * paramHandleStickersParams.jdField_a_of_type_Int);
            if (localStickerInfo.y > 1.0F) {
              break label404;
            }
            n = (int)(localStickerInfo.y * paramHandleStickersParams.jdField_a_of_type_Int);
            if (localStickerInfo.width > 1.0F) {
              break label413;
            }
            m = (int)(localStickerInfo.width * paramHandleStickersParams.jdField_a_of_type_Int);
            if (localStickerInfo.height > 1.0F) {
              break label422;
            }
            i1 = (int)(localStickerInfo.height * paramHandleStickersParams.jdField_a_of_type_Int);
            i2 = localStickerInfo.rotate;
            i3 = a(paramViewHolder, paramHandleStickersParams, paramList, j, n);
            if (!(localObject1 instanceof PicEmoticonInfo)) {
              break label452;
            }
            localObject2 = (PicEmoticonInfo)localObject1;
            if (((PicEmoticonInfo)localObject2).emoticon == null) {
              break label574;
            }
            if ((EmojiStickerManager.g) || (FileUtils.a() <= 1.048576E+008F)) {
              break label431;
            }
            n = 1;
            label301:
            if (n == 0) {
              break label437;
            }
            localObject1 = ((PicEmoticonInfo)localObject2).getLoadingDrawable("fromAIO", true, false, null, m, m);
            label322:
            localObject2 = ((PicEmoticonInfo)localObject2).emoticon.epId;
          }
          for (;;)
          {
            label332:
            BaseChatItemLayout localBaseChatItemLayout;
            double d;
            boolean bool;
            if (localObject1 != null)
            {
              localBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
              d = i2;
              bool = localStickerInfo.isShown;
              if (!localStickerInfo.isShown) {
                break label554;
              }
            }
            label404:
            label413:
            label422:
            label554:
            for (float f = 1.0F;; f = 1.1F)
            {
              localBaseChatItemLayout.a((Drawable)localObject1, k, i3, m, i1, d, (String)localObject2, bool, f, localStickerInfo);
              break;
              k = paramHandleStickersParams.jdField_a_of_type_Int;
              break label167;
              n = paramHandleStickersParams.jdField_a_of_type_Int;
              break label191;
              m = paramHandleStickersParams.jdField_a_of_type_Int;
              break label215;
              i1 = paramHandleStickersParams.jdField_a_of_type_Int;
              break label239;
              label431:
              n = 0;
              break label301;
              label437:
              localObject1 = ((PicEmoticonInfo)localObject2).getDrawable(paramContext, paramHandleStickersParams.jdField_a_of_type_Float);
              break label322;
              label452:
              if ((localObject1 instanceof SystemAndEmojiEmoticonInfo))
              {
                localObject1 = ((SystemAndEmojiEmoticonInfo)localObject1).getBigDrawable(paramContext, paramHandleStickersParams.jdField_a_of_type_Float);
                localObject2 = "";
                break label332;
              }
              if ((localObject1 instanceof SmallEmoticonInfo))
              {
                localObject1 = ((SmallEmoticonInfo)localObject1).getBigDrawable(paramContext, paramHandleStickersParams.jdField_a_of_type_Float);
                localObject2 = "";
                break label332;
              }
              if (!(localObject2 instanceof MessageForPic)) {
                break label564;
              }
              localObject1 = PicItemBuilder.a(paramContext, (MessageForPic)localObject2);
              ThreadManager.post(new StickerHandler.2(this, (MessageRecord)localObject2), 5, null, true);
              localObject2 = "";
              break label332;
            }
            return paramInt;
            label564:
            localObject2 = "";
            localObject1 = null;
            continue;
            label574:
            localObject1 = null;
            localObject2 = "";
          }
        }
      }
    }
  }
  
  private int a(BaseBubbleBuilder.ViewHolder paramViewHolder, StickerHandler.HandleStickersParams paramHandleStickersParams, List<MessageRecord> paramList, int paramInt1, int paramInt2)
  {
    int i = paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramInt2;
    paramInt2 = i;
    if (paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
      paramInt2 = i + (AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramHandleStickersParams.jdField_f_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin));
    }
    i = paramInt2;
    if (paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
      i = paramInt2 + (AIOUtils.a(14.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources()) + (paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin + paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin));
    }
    paramInt2 = i;
    int j;
    if (i < 0)
    {
      j = -i;
      if (paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams != null) {
        paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;
      }
      if (paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams == null) {
        break label252;
      }
    }
    label252:
    for (paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j;; paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin += j)
    {
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
      return paramInt2;
    }
  }
  
  private EmoticonInfo a(EmoticonManager paramEmoticonManager, MessageRecord paramMessageRecord, EmoticonInfo paramEmoticonInfo)
  {
    if ((paramMessageRecord instanceof MessageForMarketFace)) {
      paramEmoticonManager = paramEmoticonManager.a(((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage);
    }
    do
    {
      do
      {
        return paramEmoticonManager;
        paramEmoticonManager = paramEmoticonInfo;
      } while (!(paramMessageRecord instanceof MessageForText));
      paramMessageRecord = (MessageForText)paramMessageRecord;
      paramEmoticonManager = paramEmoticonInfo;
    } while (TextUtils.isEmpty(paramMessageRecord.msg));
    return EmojiStickerManager.a().a(paramMessageRecord.msg);
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    boolean bool = paramBaseChatItemLayout.b();
    if ((paramView != null) && (paramView.getId() == 2131364634) && (!bool) && (EmojiStickerManager.d(paramChatMessage)) && (paramChatMessage.fakeSenderType == 0))
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
          paramBaseChatItemLayout.setTag(2131374571, paramView);
        }
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerDoubleClickListener = new StickerHandler.1(this);
      }
      if (paramBaseChatItemLayout.b != null)
      {
        paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.b.getLayoutParams();
        paramView.addRule(6, 2131364643);
        paramView.topMargin = (-AIOUtils.a(1.0F, paramContext.getResources()));
      }
    }
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, StickerHandler.HandleStickersParams paramHandleStickersParams)
  {
    paramHandleStickersParams.jdField_a_of_type_JavaUtilList = EmojiStickerManager.a().a(paramChatMessage);
    paramHandleStickersParams.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = null;
    if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar != null) {
      paramHandleStickersParams.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams());
    }
    if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView != null) && (paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getVisibility() == 0)) {
      paramHandleStickersParams.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
    }
    if (paramBaseChatItemLayout.a()) {
      paramHandleStickersParams.jdField_d_of_type_AndroidWidgetRelativeLayout$LayoutParams = paramBaseChatItemLayout.a();
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
    if (QLog.isColorLevel()) {
      QLog.d("StickerHandler", 2, "handleStickers time cost : " + (System.currentTimeMillis() - l) + " ms");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.StickerHandler
 * JD-Core Version:    0.7.0.1
 */