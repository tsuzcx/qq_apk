package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.troop.widget.TroopSignVideoView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import vkn;
import vkp;
import vkr;
import vks;
import vkt;

public class TroopSignItemBuilder$TroopSignVideoItemBuilder
  extends TroopSignItemBuilder
{
  public static HashMap a;
  protected static long c;
  public TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public TroopSignItemBuilder$TroopSignVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
  }
  
  public static void e()
  {
    if (System.currentTimeMillis() - c < 600000L) {
      return;
    }
    c = System.currentTimeMillis();
    HtmlOffline.a();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = HtmlOffline.a("2833");
    if (QLog.isColorLevel()) {
      QLog.d("TroopSignItemBuilder", 2, "checkOffline version = " + str);
    }
    HtmlOffline.a("2833", localQQAppInterface, new vkt(), true, 0, true);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder localSignVideoItemHolder = (TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder)paramViewHolder;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130971693, paramBaseChatItemLayout, false);
      localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewHolder);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364477));
      localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363527));
      localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375167));
      localSignVideoItemHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375168));
      localSignVideoItemHolder.jdField_b_of_type_AndroidViewView = localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375166);
      localSignVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375170));
      localSignVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375171));
      localSignVideoItemHolder.jdField_c_of_type_AndroidViewView = localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375169);
      localSignVideoItemHolder.jdField_d_of_type_AndroidViewView = localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362727);
      localSignVideoItemHolder.jdField_e_of_type_AndroidViewView = localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363452);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a(new vkn(this, localSignVideoItemHolder, paramBaseChatItemLayout));
      }
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new vkp(this, localSignVideoItemHolder));
    }
    for (;;)
    {
      boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      if (!bool)
      {
        localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
        paramView = localMessageForTroopSign.dynamicSource;
        if (paramView.equals(localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag())) {
          break label693;
        }
        localSignVideoItemHolder.jdField_d_of_type_AndroidViewView.setVisibility(0);
        localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
        localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
        paramOnLongClickAndTouchListener = OfflineEnvHelper.a("2833") + "2833" + "/troop_sign/" + paramView + ".mp4";
        if (!new File(paramOnLongClickAndTouchListener).exists()) {
          break label648;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.ac)) {
          break label635;
        }
        localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramOnLongClickAndTouchListener);
        label478:
        localSignVideoItemHolder.jdField_e_of_type_AndroidViewView.setVisibility(8);
        label488:
        a(localSignVideoItemHolder.jdField_d_of_type_AndroidViewView, "2833", paramView, bool);
        label502:
        a(localSignVideoItemHolder, localMessageForTroopSign);
        if ((AppSetting.b) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramViewHolder.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(localSignVideoItemHolder, paramBaseChatItemLayout);
        paramChatMessage = (FrameLayout.LayoutParams)localSignVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!localMessageForTroopSign.isSend()) {
          break label750;
        }
      }
      label648:
      label693:
      label750:
      for (paramChatMessage.leftMargin = (BaseChatItemLayout.j + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));; paramChatMessage.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F))
      {
        localSignVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
        return paramViewHolder;
        localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
        localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
        break;
        label635:
        localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramOnLongClickAndTouchListener);
        break label478;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new vkr(this, paramOnLongClickAndTouchListener, localSignVideoItemHolder));
          e();
        }
        localSignVideoItemHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
        break label488;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.ac))
        {
          jdField_a_of_type_AndroidOsHandler.postDelayed(new vks(this, localSignVideoItemHolder), 200L);
          break label502;
        }
        a(localSignVideoItemHolder.jdField_d_of_type_AndroidViewView, "2833", paramView, bool);
        break label502;
      }
      paramViewHolder = paramView;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder();
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    super.a();
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean) {}
  
  protected void a(View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = new StringBuilder().append(OfflineEnvHelper.a(paramString1)).append(paramString1).append("/troop_sign/").append(paramString2);
    if (paramBoolean) {}
    for (paramString1 = "_no_summary";; paramString1 = "")
    {
      paramString1 = new File(paramString1 + ".png");
      if (!paramString1.exists()) {
        break;
      }
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(0);
      paramString2.mFailedDrawable = localColorDrawable;
      paramString2.mLoadingDrawable = localColorDrawable;
      try
      {
        paramView.setBackgroundDrawable(URLDrawable.getDrawable(paramString1.toURL(), paramString2));
        return;
      }
      catch (MalformedURLException paramView)
      {
        paramView.printStackTrace();
        return;
      }
    }
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString2 = new ColorDrawable(0);
    paramString1.mFailedDrawable = paramString2;
    paramString1.mLoadingDrawable = paramString2;
    paramString1 = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/troop_sign_loading.png", paramString1);
    paramString1.setTag(URLDrawableDecodeHandler.a(287, 287, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(URLDrawableDecodeHandler.g);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */