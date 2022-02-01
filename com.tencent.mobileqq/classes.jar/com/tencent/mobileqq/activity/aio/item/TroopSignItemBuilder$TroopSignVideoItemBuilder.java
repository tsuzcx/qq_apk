package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
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

public class TroopSignItemBuilder$TroopSignVideoItemBuilder
  extends TroopSignItemBuilder
{
  protected static HashMap<ChatMessage, TroopSignItemBuilder.TroopSignVideoItemBuilder.IOnOfflineResCallback> a;
  protected static long c;
  protected TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  }
  
  public TroopSignItemBuilder$TroopSignVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, TroopChatPie paramTroopChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkOffline version = ");
      localStringBuilder.append(str);
      QLog.d("TroopSignItemBuilder", 2, localStringBuilder.toString());
    }
    HtmlOffline.a("2833", localQQAppInterface, new TroopSignItemBuilder.TroopSignVideoItemBuilder.5(), true, 0, true);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder localSignVideoItemHolder = (TroopSignItemBuilder.TroopSignVideoItemBuilder.SignVideoItemHolder)paramViewHolder;
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563002, paramBaseChatItemLayout, false);
      localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewHolder);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView = ((TroopSignVideoView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365284));
      localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378120));
      localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370668));
      localSignVideoItemHolder.b = ((TextView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370670));
      localSignVideoItemHolder.jdField_c_of_type_AndroidViewView = localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370669);
      localSignVideoItemHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370672));
      localSignVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370667));
      localSignVideoItemHolder.jdField_d_of_type_AndroidViewView = localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370671);
      localSignVideoItemHolder.jdField_e_of_type_AndroidViewView = localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370360);
      localSignVideoItemHolder.f = localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370387);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusable(false);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFocusableInTouchMode(false);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setClickable(false);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFps(30);
      paramViewHolder.setOnClickListener(this);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
      if (paramView != null) {
        paramView.a(new TroopSignItemBuilder.TroopSignVideoItemBuilder.1(this, localSignVideoItemHolder, paramBaseChatItemLayout));
      }
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setOnPlayedListener(new TroopSignItemBuilder.TroopSignVideoItemBuilder.2(this, localSignVideoItemHolder));
    }
    boolean bool = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
    if (!bool)
    {
      localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(true);
    }
    else
    {
      localSignVideoItemHolder.jdField_a_of_type_AndroidWidgetTextView.setText("");
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setShowCover(false);
    }
    paramView = localMessageForTroopSign.dynamicSource;
    if (!paramView.equals(localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.getTag()))
    {
      localSignVideoItemHolder.jdField_e_of_type_AndroidViewView.setVisibility(0);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setTag(paramView);
      localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a();
      paramOnLongClickAndTouchListener = new StringBuilder();
      paramOnLongClickAndTouchListener.append(OfflineEnvHelper.a("2833"));
      paramOnLongClickAndTouchListener.append("2833");
      paramOnLongClickAndTouchListener.append("/troop_sign/");
      paramOnLongClickAndTouchListener.append(paramView);
      paramOnLongClickAndTouchListener.append(".mp4");
      paramOnLongClickAndTouchListener = paramOnLongClickAndTouchListener.toString();
      if (new File(paramOnLongClickAndTouchListener).exists())
      {
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
        if ((paramChatMessage != null) && (paramChatMessage.S)) {
          localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.setFilePath(paramOnLongClickAndTouchListener);
        } else {
          localSignVideoItemHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopSignVideoView.a(paramOnLongClickAndTouchListener);
        }
        localSignVideoItemHolder.f.setVisibility(8);
      }
      else
      {
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(paramChatMessage))
        {
          jdField_a_of_type_JavaUtilHashMap.put(paramChatMessage, new TroopSignItemBuilder.TroopSignVideoItemBuilder.3(this, paramOnLongClickAndTouchListener, localSignVideoItemHolder));
          e();
        }
        localSignVideoItemHolder.f.setVisibility(0);
      }
      a(localSignVideoItemHolder.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
    }
    else
    {
      paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
      if ((paramChatMessage != null) && (!paramChatMessage.S)) {
        jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopSignItemBuilder.TroopSignVideoItemBuilder.4(this, localSignVideoItemHolder), 200L);
      } else {
        a(localSignVideoItemHolder.jdField_e_of_type_AndroidViewView, "2833", paramView, bool);
      }
    }
    a(localSignVideoItemHolder, localMessageForTroopSign);
    if ((AppSetting.d) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle)))
    {
      paramChatMessage = new StringBuilder();
      paramChatMessage.append("");
      paramChatMessage.append(localMessageForTroopSign.msgTitle);
      paramViewHolder.setContentDescription(paramChatMessage.toString());
    }
    a(localSignVideoItemHolder, paramBaseChatItemLayout);
    paramChatMessage = (FrameLayout.LayoutParams)localSignVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams();
    if (localMessageForTroopSign.isSend()) {
      paramChatMessage.leftMargin = (BaseChatItemLayout.k + DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    } else {
      paramChatMessage.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    }
    localSignVideoItemHolder.jdField_e_of_type_AndroidWidgetTextView.setLayoutParams(paramChatMessage);
    return paramViewHolder;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(OfflineEnvHelper.a(paramString1));
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("/troop_sign/");
    ((StringBuilder)localObject).append(paramString2);
    if (paramBoolean) {
      paramString1 = "_no_summary";
    } else {
      paramString1 = "";
    }
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(".png");
    paramString1 = new File(((StringBuilder)localObject).toString());
    if (paramString1.exists())
    {
      paramString2 = URLDrawable.URLDrawableOptions.obtain();
      localObject = new ColorDrawable(0);
      paramString2.mFailedDrawable = ((Drawable)localObject);
      paramString2.mLoadingDrawable = ((Drawable)localObject);
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
    paramString1 = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/troop_sign_loading.png", paramString1);
    paramString1.setTag(URLDrawableDecodeHandler.b(287, 287, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F)));
    paramString1.setDecodeHandler(URLDrawableDecodeHandler.i);
    paramView.setBackgroundDrawable(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */