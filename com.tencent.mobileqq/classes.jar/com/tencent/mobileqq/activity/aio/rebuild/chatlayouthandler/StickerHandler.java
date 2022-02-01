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
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.b.getRuntimeService(IEmoticonManagerService.class);
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
        StickerInfo localStickerInfo = EmojiStickerManager.d((MessageRecord)localObject2);
        j = paramInt;
        if (localStickerInfo == null) {
          break;
        }
        j = paramInt;
        if (!EmojiStickerManager.h((MessageRecord)localObject2)) {
          break;
        }
        i += 1;
        if (i > QVipStickerProcessor.c)
        {
          ((MessageRecord)localObject2).msgtype = -2006;
          paramInt += 1;
        }
        else
        {
          Object localObject1 = a(localIEmoticonManagerService, (MessageRecord)localObject2, null);
          if (localStickerInfo.x <= 1.0F) {
            j = (int)(localStickerInfo.x * paramHandleStickersParams.h);
          } else {
            j = paramHandleStickersParams.h;
          }
          int n;
          if (localStickerInfo.y <= 1.0F) {
            n = (int)(localStickerInfo.y * paramHandleStickersParams.h);
          } else {
            n = paramHandleStickersParams.h;
          }
          int m;
          if (localStickerInfo.width <= 1.0F) {
            m = (int)(localStickerInfo.width * paramHandleStickersParams.h);
          } else {
            m = paramHandleStickersParams.h;
          }
          int i1;
          if (localStickerInfo.height <= 1.0F) {
            i1 = (int)(localStickerInfo.height * paramHandleStickersParams.h);
          } else {
            i1 = paramHandleStickersParams.h;
          }
          int i2 = localStickerInfo.rotate;
          int i3 = a(paramViewHolder, paramHandleStickersParams, paramList, k, n);
          String str = "";
          if ((localObject1 instanceof IPicEmoticonInfo))
          {
            localObject2 = (IPicEmoticonInfo)localObject1;
            if (((IPicEmoticonInfo)localObject2).getEmoticon() != null)
            {
              if ((!EmojiStickerManager.u) && (FileUtils.getAvailableInnernalMemorySize() > 1.048576E+008F)) {
                n = 1;
              } else {
                n = 0;
              }
              if (n != 0) {
                localObject1 = ((IPicEmoticonInfo)localObject2).getLoadingDrawable("fromAIO", true, false, null, m, m);
              } else {
                localObject1 = ((IPicEmoticonInfo)localObject2).getDrawable(paramContext, paramHandleStickersParams.i);
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
          for (localObject1 = ((SystemAndEmojiEmoticonInfo)localObject1).getBigDrawable(paramContext, paramHandleStickersParams.i);; localObject1 = ((ISmallEmoticonInfo)localObject1).getBigDrawable(paramContext, paramHandleStickersParams.i))
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
            localObject2 = paramViewHolder.j;
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
    int i = paramHandleStickersParams.b.topMargin + paramInt2;
    paramInt2 = i;
    if (paramHandleStickersParams.g != null)
    {
      paramInt2 = AIOUtils.b(14.0F, this.b.getApp().getResources());
      paramInt2 = i + (paramHandleStickersParams.g.topMargin + paramHandleStickersParams.g.bottomMargin + paramInt2);
    }
    i = paramInt2;
    if (paramHandleStickersParams.e != null)
    {
      i = AIOUtils.b(14.0F, this.b.getApp().getResources());
      i = paramInt2 + (paramHandleStickersParams.e.topMargin + paramHandleStickersParams.e.bottomMargin + i);
    }
    paramInt2 = i;
    if (i < 0)
    {
      int j = -i;
      if (paramHandleStickersParams.c != null) {
        paramHandleStickersParams.c.topMargin += j;
      }
      if (paramHandleStickersParams.e != null) {
        paramHandleStickersParams.e.topMargin += j;
      } else {
        paramHandleStickersParams.b.topMargin += j;
      }
      if (paramHandleStickersParams.f != null) {
        paramHandleStickersParams.f.topMargin += j;
      }
      if (paramHandleStickersParams.d != null) {
        paramHandleStickersParams.d.topMargin += j;
      }
      i = 0;
      paramInt2 = i;
      if (paramInt1 != paramList.size() - 1)
      {
        paramViewHolder.j.g(j);
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
    if ((paramView != null) && (paramView.getId() == 2131430578) && (!bool) && (EmojiStickerManager.i(paramChatMessage)) && (paramChatMessage.fakeSenderType == 0))
    {
      StickerHandler.HandleStickersParams localHandleStickersParams = new StickerHandler.HandleStickersParams(this);
      a(paramContext, paramView, paramChatMessage, paramBaseChatItemLayout, localHandleStickersParams);
      if ((localHandleStickersParams.a != null) && (localHandleStickersParams.a.size() > 0) && (EmojiStickerManager.g(paramChatMessage)))
      {
        paramView = this.b.getMessageFacade().a(this.c.b, this.c.a, localHandleStickersParams.a);
        if (a(paramContext, paramViewHolder, localHandleStickersParams, paramView, 0) != paramView.size())
        {
          paramView = new Bundle();
          paramView.putBoolean("haveTimeStamp", localHandleStickersParams.v);
          paramView.putBoolean("haveNickName", localHandleStickersParams.w);
          paramView.putBoolean("havePendant", localHandleStickersParams.x);
          paramView.putBoolean("haveTroopMemberLevel", localHandleStickersParams.y);
          if (localHandleStickersParams.g != null)
          {
            paramView.putInt("timeStampTop", localHandleStickersParams.j);
            paramView.putInt("timeStampBottom", localHandleStickersParams.k);
          }
          if (localHandleStickersParams.b != null)
          {
            paramView.putInt("textViewTop", localHandleStickersParams.l);
            paramView.putInt("textViewBottom", localHandleStickersParams.m);
          }
          if (localHandleStickersParams.e != null)
          {
            paramView.putInt("nickNameViewTop", localHandleStickersParams.n);
            paramView.putInt("nickNameViewBottom", localHandleStickersParams.o);
          }
          if (localHandleStickersParams.c != null)
          {
            paramView.putInt("headViewTop", localHandleStickersParams.p);
            paramView.putInt("headViewBottom", localHandleStickersParams.q);
          }
          if (localHandleStickersParams.d != null)
          {
            paramView.putInt("pendantViewTop", localHandleStickersParams.r);
            paramView.putInt("pendantViewBottom", localHandleStickersParams.s);
          }
          if (localHandleStickersParams.f != null)
          {
            paramView.putInt("troopMemberLevelTop", localHandleStickersParams.t);
            paramView.putInt("troopMemberLevelBottom", localHandleStickersParams.u);
          }
          paramBaseChatItemLayout.setTag(2131442204, paramView);
        }
        paramBaseChatItemLayout.ar = new StickerHandler.1(this);
      }
      paramView = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
      if (paramView != null)
      {
        paramView = ((IHeadIconProcessor)paramView.a()).b();
        if (paramView != null)
        {
          paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
          paramView.addRule(6, 2131430587);
          paramView.topMargin = (-AIOUtils.b(1.0F, paramContext.getResources()));
        }
      }
    }
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, StickerHandler.HandleStickersParams paramHandleStickersParams)
  {
    paramHandleStickersParams.a = EmojiStickerManager.a().c(paramChatMessage);
    paramHandleStickersParams.b = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    paramHandleStickersParams.c = null;
    paramHandleStickersParams.d = null;
    paramView = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
    if (paramView != null)
    {
      paramView = paramView.c();
      if ((paramView != null) && (paramView.checkViewNonNull())) {
        paramHandleStickersParams.c = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
      }
    }
    if ((paramBaseChatItemLayout.ae != null) && (paramBaseChatItemLayout.ae.getVisibility() == 0)) {
      paramHandleStickersParams.d = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.ae.getLayoutParams());
    }
    paramView = (NickNameLayoutViewWrapper)paramBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
    if (paramView != null)
    {
      paramView = paramView.c();
      if ((paramView != null) && (paramView.checkViewNonNull())) {
        paramHandleStickersParams.e = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
      }
    }
    if ((paramBaseChatItemLayout.aa != null) && (paramBaseChatItemLayout.aa.getVisibility() == 0)) {
      paramHandleStickersParams.g = ((RelativeLayout.LayoutParams)paramBaseChatItemLayout.aa.getLayoutParams());
    }
    paramHandleStickersParams.h = paramContext.getResources().getDisplayMetrics().widthPixels;
    paramHandleStickersParams.i = paramContext.getResources().getDisplayMetrics().density;
    if (paramHandleStickersParams.g != null)
    {
      paramHandleStickersParams.v = true;
      paramHandleStickersParams.j = paramHandleStickersParams.g.topMargin;
      paramHandleStickersParams.k = paramHandleStickersParams.g.bottomMargin;
    }
    if (paramHandleStickersParams.b != null)
    {
      paramHandleStickersParams.l = paramHandleStickersParams.b.topMargin;
      paramHandleStickersParams.m = paramHandleStickersParams.b.bottomMargin;
    }
    if (paramHandleStickersParams.e != null)
    {
      paramHandleStickersParams.w = true;
      paramHandleStickersParams.n = paramHandleStickersParams.e.topMargin;
      paramHandleStickersParams.o = paramHandleStickersParams.e.bottomMargin;
    }
    if (paramHandleStickersParams.c != null)
    {
      paramHandleStickersParams.p = paramHandleStickersParams.c.topMargin;
      paramHandleStickersParams.q = paramHandleStickersParams.c.bottomMargin;
    }
    if (paramHandleStickersParams.d != null)
    {
      paramHandleStickersParams.x = true;
      paramHandleStickersParams.r = paramHandleStickersParams.d.topMargin;
      paramHandleStickersParams.s = paramHandleStickersParams.d.bottomMargin;
    }
    if (paramHandleStickersParams.f != null)
    {
      paramHandleStickersParams.y = true;
      paramHandleStickersParams.t = paramHandleStickersParams.f.topMargin;
      paramHandleStickersParams.u = paramHandleStickersParams.f.bottomMargin;
    }
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    paramViewHolder.j.f();
    StartupTracker.a(null, "AIO_Handle_Sticker_Cost");
    long l = System.currentTimeMillis();
    a(paramContext, paramViewHolder.h, paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.StickerHandler
 * JD-Core Version:    0.7.0.1
 */