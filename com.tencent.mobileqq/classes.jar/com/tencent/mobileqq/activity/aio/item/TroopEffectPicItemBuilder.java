package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopGiftPanelHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;

public class TroopEffectPicItemBuilder
  extends BaseBubbleBuilder
  implements View.OnClickListener, Callback
{
  protected static SparseArray<TroopEffectPicItemBuilder.ItemData> a = new SparseArray(3);
  
  static
  {
    a.put(40000, new TroopEffectPicItemBuilder.ItemData(40000, HardCodeUtil.a(2131912572), Color.parseColor("#F2836DE1")));
    a.put(40001, new TroopEffectPicItemBuilder.ItemData(40001, HardCodeUtil.a(2131912570), Color.parseColor("#F2EF7AEE")));
    a.put(40002, new TroopEffectPicItemBuilder.ItemData(40002, HardCodeUtil.a(2131912571), Color.parseColor("#F23FCCDF")));
    a.put(40003, new TroopEffectPicItemBuilder.ItemData(40003, HardCodeUtil.a(2131912568), Color.parseColor("#F2FFA02D")));
    a.put(40004, new TroopEffectPicItemBuilder.ItemData(40004, HardCodeUtil.a(2131912565), Color.parseColor("#F21CD28C")));
    a.put(40005, new TroopEffectPicItemBuilder.ItemData(40005, HardCodeUtil.a(2131912564), Color.parseColor("#F2FF6EA2")));
  }
  
  public TroopEffectPicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramChatMessage;
    TroopEffectPicItemBuilder.TroopEffectPicMsgHolder localTroopEffectPicMsgHolder = (TroopEffectPicItemBuilder.TroopEffectPicMsgHolder)paramViewHolder;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.e).inflate(2131629566, null);
      localTroopEffectPicMsgHolder.a = ((RelativeLayout)paramViewHolder);
      localTroopEffectPicMsgHolder.b = ((BubbleImageView)paramViewHolder.findViewById(2131447936));
      localTroopEffectPicMsgHolder.b.setRadius(12.0F);
      localTroopEffectPicMsgHolder.b.c(false);
      localTroopEffectPicMsgHolder.d = ((TextView)paramViewHolder.findViewById(2131446185));
      localTroopEffectPicMsgHolder.f = ((TextView)paramViewHolder.findViewById(2131448075));
      localTroopEffectPicMsgHolder.c = ((URLImageView)paramViewHolder.findViewById(2131447935));
      localTroopEffectPicMsgHolder.d.setOnClickListener(this);
      localTroopEffectPicMsgHolder.b.setOnClickListener(this);
      localTroopEffectPicMsgHolder.b.setOnTouchListener(paramOnLongClickAndTouchListener);
      localTroopEffectPicMsgHolder.b.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramView = localTroopEffectPicMsgHolder.b;
    int i = CommonImgThumbHelper.getImgThumbMaxPx(false);
    int j = CommonImgThumbHelper.getImgThumbMinPx(false);
    paramView.setMaxWidth(i);
    paramView.setMaxHeight(i);
    paramView.setMinimumWidth(j);
    paramView.setMinimumHeight(j);
    if (v) {
      paramView.setContentDescription(HardCodeUtil.a(2131912563));
    }
    if (!localMessageForTroopEffectPic.isSendFromLocal())
    {
      paramOnLongClickAndTouchListener = URLDrawableHelper.getURL(localMessageForTroopEffectPic, 65537);
      paramBaseChatItemLayout = new int[2];
      BaseChatItemLayout tmp250_248 = paramBaseChatItemLayout;
      tmp250_248[0] = 0;
      BaseChatItemLayout tmp254_250 = tmp250_248;
      tmp254_250[1] = 0;
      tmp254_250;
      if ((localTroopEffectPicMsgHolder.e != null) && (localTroopEffectPicMsgHolder.e.getURL().equals(paramOnLongClickAndTouchListener)))
      {
        paramView = localTroopEffectPicMsgHolder.e;
        paramBaseChatItemLayout[0] = localTroopEffectPicMsgHolder.b.getWidth();
        paramBaseChatItemLayout[1] = localTroopEffectPicMsgHolder.b.getHeight();
      }
      else
      {
        if (localTroopEffectPicMsgHolder.e != null)
        {
          paramView = new StringBuilder();
          paramView.append("holder.d=");
          paramView.append(localTroopEffectPicMsgHolder.e.getURL());
          paramView.append("==url=");
          paramView.append(paramOnLongClickAndTouchListener);
          QLog.d("tdrawable", 2, paramView.toString());
        }
        paramBaseChatItemLayout = PicItemBuilder.a(this.e, localMessageForTroopEffectPic, localTroopEffectPicMsgHolder.b, paramBaseChatItemLayout);
        localTroopEffectPicMsgHolder.b.setImageDrawable(paramBaseChatItemLayout);
        localTroopEffectPicMsgHolder.e = paramBaseChatItemLayout;
        ((IPicPreDownload)this.d.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(localMessageForTroopEffectPic, 2);
        paramView = paramBaseChatItemLayout;
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("show receive pic uniseq=");
          paramView.append(localMessageForTroopEffectPic.uniseq);
          paramView.append(" url=");
          paramView.append(paramOnLongClickAndTouchListener);
          QLog.d("ChatItemBuilder", 2, paramView.toString());
          paramView = paramBaseChatItemLayout;
        }
      }
      if (paramView == null) {
        QLog.d("tdrawable", 2, "d==null");
      }
      localTroopEffectPicMsgHolder.e.setWatermarkVisibility(4);
      QLog.d("tdrawable", 2, "not isDynamic tag gone");
    }
    paramView = (TroopEffectPicItemBuilder.ItemData)a.get(localMessageForTroopEffectPic.effectId, null);
    if (paramView != null)
    {
      localTroopEffectPicMsgHolder.f.setVisibility(0);
      localTroopEffectPicMsgHolder.f.setText(paramView.b);
      paramBaseChatItemLayout = new GradientDrawable();
      paramBaseChatItemLayout.setShape(0);
      float f = DisplayUtil.a(this.e, 12.0F);
      paramBaseChatItemLayout.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
      paramBaseChatItemLayout.setColor(paramView.c);
      localTroopEffectPicMsgHolder.f.setBackgroundDrawable(paramBaseChatItemLayout);
    }
    else
    {
      localTroopEffectPicMsgHolder.f.setVisibility(8);
    }
    if ((localMessageForTroopEffectPic.effectId >= 40003) && (localMessageForTroopEffectPic.effectId <= 40005))
    {
      localTroopEffectPicMsgHolder.c.setVisibility(0);
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramBaseChatItemLayout = new ColorDrawable(0);
      paramView.mFailedDrawable = paramBaseChatItemLayout;
      paramView.mLoadingDrawable = paramBaseChatItemLayout;
      paramBaseChatItemLayout = new StringBuilder();
      paramBaseChatItemLayout.append("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_obj_");
      paramBaseChatItemLayout.append(localMessageForTroopEffectPic.effectId);
      paramBaseChatItemLayout.append(".png");
      paramView = URLDrawable.getDrawable(paramBaseChatItemLayout.toString(), paramView);
      paramView.setTag(URLDrawableDecodeHandler.b(190, 270, DisplayUtil.a(this.e, 12.0F)));
      paramView.setDecodeHandler(URLDrawableDecodeHandler.j);
      localTroopEffectPicMsgHolder.c.setImageDrawable(paramView);
    }
    else
    {
      localTroopEffectPicMsgHolder.c.setVisibility(8);
    }
    localTroopEffectPicMsgHolder.b.setTag(paramChatMessage);
    localTroopEffectPicMsgHolder.d.setTag(paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopEffectPicItemBuilder.TroopEffectPicMsgHolder();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131431695)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.e, this.d, paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = ((ChatItemBuilder.BaseHolder)AIOUtils.b(paramView)).q;
    a(localQQCustomMenu, this.e, 2131444634, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    a(localQQCustomMenu, this.e, 2131444651, paramView, null);
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131912569);
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131446185)
    {
      if (i != 2131447936)
      {
        super.onClick(paramView);
      }
      else
      {
        localObject = ((BaseActivity)this.e).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          if ((localObject instanceof TroopChatPie))
          {
            localObject = (TroopChatPie)localObject;
            if (!((TroopGiftPanelHelper)((TroopChatPie)localObject).q(136)).g().b())
            {
              AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.d.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
              MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramView.getTag();
              localAIOAnimationControlManager.b(localMessageForTroopEffectPic.frienduin);
              localAIOAnimationControlManager.k();
              localAIOAnimationControlManager.a(localMessageForTroopEffectPic, false);
              localAIOAnimationControlManager.a((BaseChatPie)localObject);
              localAIOAnimationControlManager.j();
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("ChatItemBuilder", 2, "[EffectPic] curPie is null.");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ChatItemBuilder", 2, "[EffectPic] chatFragment is null.");
        }
        TroopPicEffectsController.a("obj_msg", "clk_play");
      }
    }
    else
    {
      if (SharedPreUtils.bf(this.e, this.d.getCurrentAccountUin()))
      {
        TroopPicEffectsEditActivity.a((Activity)this.e, this.f.b, this.f.c);
      }
      else
      {
        SharedPreUtils.bg(this.e, this.d.getCurrentAccountUin());
        localObject = new Intent(this.e, TroopPicEffectGuidePicActivity.class);
        ((Intent)localObject).putExtra("friendUin", this.f.b);
        ((Intent)localObject).putExtra("troopUin", this.f.c);
        this.e.startActivity((Intent)localObject);
      }
      TroopPicEffectsController.a("obj_msg", "clk_tail    ");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopEffectPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */