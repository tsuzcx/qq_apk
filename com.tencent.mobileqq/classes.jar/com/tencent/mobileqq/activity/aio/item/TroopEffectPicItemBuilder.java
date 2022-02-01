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
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troopgift.TroopInteractGiftAnimationController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectGuidePicActivity;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsController;
import com.tencent.mobileqq.trooppiceffects.TroopPicEffectsEditActivity;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
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
  protected static SparseArray<TroopEffectPicItemBuilder.ItemData> a;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    jdField_a_of_type_AndroidUtilSparseArray.put(40000, new TroopEffectPicItemBuilder.ItemData(40000, HardCodeUtil.a(2131715084), Color.parseColor("#F2836DE1")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40001, new TroopEffectPicItemBuilder.ItemData(40001, HardCodeUtil.a(2131715082), Color.parseColor("#F2EF7AEE")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40002, new TroopEffectPicItemBuilder.ItemData(40002, HardCodeUtil.a(2131715083), Color.parseColor("#F23FCCDF")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40003, new TroopEffectPicItemBuilder.ItemData(40003, HardCodeUtil.a(2131715080), Color.parseColor("#F2FFA02D")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40004, new TroopEffectPicItemBuilder.ItemData(40004, HardCodeUtil.a(2131715077), Color.parseColor("#F21CD28C")));
    jdField_a_of_type_AndroidUtilSparseArray.put(40005, new TroopEffectPicItemBuilder.ItemData(40005, HardCodeUtil.a(2131715076), Color.parseColor("#F2FF6EA2")));
  }
  
  public TroopEffectPicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramChatMessage;
    TroopEffectPicItemBuilder.TroopEffectPicMsgHolder localTroopEffectPicMsgHolder = (TroopEffectPicItemBuilder.TroopEffectPicMsgHolder)paramViewHolder;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562958, null);
      localTroopEffectPicMsgHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewHolder);
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramViewHolder.findViewById(2131379199));
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(12.0F);
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      localTroopEffectPicMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131377727));
      localTroopEffectPicMsgHolder.b = ((TextView)paramViewHolder.findViewById(2131379338));
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewHolder.findViewById(2131379198));
      localTroopEffectPicMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnClickListener(this);
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnTouchListener(paramOnLongClickAndTouchListener);
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramView = localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
    int i = CommonImgThumbHelper.getImgThumbMaxPx(false);
    int j = CommonImgThumbHelper.getImgThumbMinPx(false);
    paramView.setMaxWidth(i);
    paramView.setMaxHeight(i);
    paramView.setMinimumWidth(j);
    paramView.setMinimumHeight(j);
    if (e) {
      paramView.setContentDescription(HardCodeUtil.a(2131715075));
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
      if ((localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable != null) && (localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramOnLongClickAndTouchListener)))
      {
        paramView = localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable;
        paramBaseChatItemLayout[0] = localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth();
        paramBaseChatItemLayout[1] = localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight();
      }
      else
      {
        if (localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable != null)
        {
          paramView = new StringBuilder();
          paramView.append("holder.d=");
          paramView.append(localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable.getURL());
          paramView.append("==url=");
          paramView.append(paramOnLongClickAndTouchListener);
          QLog.d("tdrawable", 2, paramView.toString());
        }
        paramBaseChatItemLayout = PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, localMessageForTroopEffectPic, localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramBaseChatItemLayout);
        localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBaseChatItemLayout);
        localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable = paramBaseChatItemLayout;
        ((IPicPreDownload)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPicPreDownload.class, "")).productFromAIO(localMessageForTroopEffectPic, 2);
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
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLDrawable.setWatermarkVisibility(4);
      QLog.d("tdrawable", 2, "not isDynamic tag gone");
    }
    paramView = (TroopEffectPicItemBuilder.ItemData)jdField_a_of_type_AndroidUtilSparseArray.get(localMessageForTroopEffectPic.effectId, null);
    if (paramView != null)
    {
      localTroopEffectPicMsgHolder.b.setVisibility(0);
      localTroopEffectPicMsgHolder.b.setText(paramView.jdField_a_of_type_JavaLangString);
      paramBaseChatItemLayout = new GradientDrawable();
      paramBaseChatItemLayout.setShape(0);
      float f = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
      paramBaseChatItemLayout.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f });
      paramBaseChatItemLayout.setColor(paramView.b);
      localTroopEffectPicMsgHolder.b.setBackgroundDrawable(paramBaseChatItemLayout);
    }
    else
    {
      localTroopEffectPicMsgHolder.b.setVisibility(8);
    }
    if ((localMessageForTroopEffectPic.effectId >= 40003) && (localMessageForTroopEffectPic.effectId <= 40005))
    {
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramBaseChatItemLayout = new ColorDrawable(0);
      paramView.mFailedDrawable = paramBaseChatItemLayout;
      paramView.mLoadingDrawable = paramBaseChatItemLayout;
      paramBaseChatItemLayout = new StringBuilder();
      paramBaseChatItemLayout.append("https://pub.idqqimg.com/pc/misc/groupgift/troop_pic_effects_obj_");
      paramBaseChatItemLayout.append(localMessageForTroopEffectPic.effectId);
      paramBaseChatItemLayout.append(".png");
      paramView = URLDrawable.getDrawable(paramBaseChatItemLayout.toString(), paramView);
      paramView.setTag(URLDrawableDecodeHandler.b(190, 270, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
      paramView.setDecodeHandler(URLDrawableDecodeHandler.i);
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
    }
    else
    {
      localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
    localTroopEffectPicMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(paramChatMessage);
    localTroopEffectPicMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setTag(paramChatMessage);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopEffectPicItemBuilder.TroopEffectPicMsgHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131715081);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131365480)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = ((ChatItemBuilder.BaseHolder)AIOUtils.a(paramView)).a;
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376417, paramView, null);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376430, paramView, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i != 2131377727)
    {
      if (i != 2131379199)
      {
        super.onClick(paramView);
      }
      else
      {
        localObject = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if ((localObject instanceof TroopChatPie))
          {
            localObject = (TroopChatPie)localObject;
            if (!((TroopGiftPanelHelper)((TroopChatPie)localObject).a(136)).a().a())
            {
              AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
              MessageForTroopEffectPic localMessageForTroopEffectPic = (MessageForTroopEffectPic)paramView.getTag();
              localAIOAnimationControlManager.a(localMessageForTroopEffectPic.frienduin);
              localAIOAnimationControlManager.g();
              localAIOAnimationControlManager.a(localMessageForTroopEffectPic, false);
              localAIOAnimationControlManager.a((BaseChatPie)localObject);
              localAIOAnimationControlManager.f();
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
      if (SharedPreUtils.m(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        TroopPicEffectsEditActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
      }
      else
      {
        SharedPreUtils.p(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopPicEffectGuidePicActivity.class);
        ((Intent)localObject).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
      TroopPicEffectsController.a("obj_msg", "clk_tail    ");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopEffectPicItemBuilder
 * JD-Core Version:    0.7.0.1
 */