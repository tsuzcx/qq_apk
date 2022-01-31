package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopFileProxyActivity;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import vgu;

public class TroopFileVideoItemBuilder
  extends TroopFileItemBuilder
{
  private final String jdField_a_of_type_JavaLangString = "TroopFileVideoItemBuilder<FileAssistant>";
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public TroopFileVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vgu paramvgu)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    paramContext = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (paramContext == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFileVideoItemBuilder<FileAssistant>", 4, "get fileStatusInfo fail ");
      }
      return null;
    }
    if (FileUtils.b(paramContext.d))
    {
      if ((paramMessageForTroopFile.width == 0) || (paramMessageForTroopFile.height == 0)) {
        a(paramMessageForTroopFile, paramvgu);
      }
      paramMessageForTroopFile = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForTroopFile.mRequestWidth = paramvgu.jdField_e_of_type_Int;
      paramMessageForTroopFile.mRequestHeight = paramvgu.f;
      paramMessageForTroopFile.mLoadingDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramvgu.jdField_e_of_type_Int, paramvgu.f);
      paramMessageForTroopFile.mFailedDrawable = URLDrawableHelper.a();
      paramMessageForTroopFile.mGifRoundCorner = 12.0F;
      paramMessageForTroopFile.mPlayGifImage = false;
      paramContext = URLDrawable.getDrawable(new File(paramContext.d), paramMessageForTroopFile);
      paramContext.setAutoDownload(true);
      return paramContext;
    }
    if (paramContext.jdField_b_of_type_Int != 12)
    {
      if (paramContext.a == null) {
        break label224;
      }
      localTroopFileTransferManager.a(paramContext.a, 383);
    }
    for (;;)
    {
      return new EmptyDrawable(Color.rgb(214, 214, 214), paramvgu.jdField_e_of_type_Int, paramvgu.f);
      label224:
      localTroopFileTransferManager.a(paramContext.jdField_e_of_type_JavaLangString, paramContext.g, paramContext.jdField_e_of_type_Int, 383);
    }
  }
  
  private void a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vgu paramvgu)
  {
    if (paramvgu.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      paramvgu.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840623);
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492968));
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setText(2131430830);
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.topMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramContext.addRule(3, 2131366616);
      paramContext.addRule(5, 2131361963);
      ((RelativeLayout)paramvgu.jdField_a_of_type_AndroidViewView).addView(paramvgu.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    }
    if (paramMessageForTroopFile.isSend())
    {
      paramvgu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    paramvgu.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vgu paramvgu, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramContext = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if ((paramContext == null) && (QLog.isColorLevel())) {
      QLog.d("TroopFileVideoItemBuilder<FileAssistant>", 2, "updateItem, get fileStatusInfo fail");
    }
    boolean bool = b(paramMessageForTroopFile);
    int j = -1;
    if (bool)
    {
      a(paramContext, paramvgu);
      return;
    }
    int i = j;
    switch (paramContext.jdField_b_of_type_Int)
    {
    default: 
      i = j;
    case 0: 
    case 4: 
      if (i == 2) {
        a(paramvgu, TroopFileUtils.a(paramContext.c, paramContext.jdField_b_of_type_Long));
      }
      break;
    }
    for (;;)
    {
      if ((i != 0) || (paramContext.jdField_b_of_type_Int != 3)) {
        break label565;
      }
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
      i = j;
      if (paramMessageForTroopFile.msgtype != -2017) {
        break;
      }
      if (paramMessageForTroopFile.extraflag != 32772)
      {
        i = j;
        if (paramMessageForTroopFile.extraflag != 32768) {
          break;
        }
      }
      i = j;
      if (!paramMessageForTroopFile.isSendFromLocal()) {
        break;
      }
      i = j;
      if (!TextUtils.isEmpty(paramMessageForTroopFile.FromUin)) {
        break;
      }
      i = j;
      if (!TextUtils.isEmpty(paramContext.jdField_e_of_type_JavaLangString)) {
        break;
      }
      e(paramMessageForTroopFile);
      i = j;
      break;
      e(paramMessageForTroopFile);
      i = 0;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 1;
      break;
      i = 0;
      break;
      if (i == 0)
      {
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845456);
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription("恢复按钮");
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      }
      else if (i == 3)
      {
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription("恢复按钮");
        if (paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
        {
          paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130845456);
          paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        else
        {
          paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845456);
          paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        }
      }
      else if (paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      else
      {
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      }
    }
    label565:
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile, vgu paramvgu)
  {
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    int i;
    int j;
    if (FileUtils.b(localTroopFileStatusInfo.d))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      ImageUtil.a(localTroopFileStatusInfo.d, localOptions);
      if ((paramMessageForTroopFile.width == 0) || (paramMessageForTroopFile.height == 0))
      {
        paramMessageForTroopFile.width = localOptions.outWidth;
        paramMessageForTroopFile.height = localOptions.outHeight;
        i = URLDrawableHelper.a(localTroopFileStatusInfo.d);
        if ((i == 90) || (i == 270))
        {
          paramMessageForTroopFile.height = localOptions.outWidth;
          paramMessageForTroopFile.width = localOptions.outHeight;
        }
        paramvgu.jdField_e_of_type_Int = paramMessageForTroopFile.width;
        paramvgu.f = paramMessageForTroopFile.height;
        localObject = (TroopFileTransferManager.Item)((TroopFileTransferManager)localObject).b.get(localTroopFileStatusInfo.a);
        if ((paramMessageForTroopFile.duration == 0) && (localObject != null) && (((TroopFileTransferManager.Item)localObject).duration != 0)) {
          paramMessageForTroopFile.duration = ((TroopFileTransferManager.Item)localObject).duration;
        }
        paramMessageForTroopFile.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForTroopFile.frienduin, 1, paramMessageForTroopFile.uniseq, paramMessageForTroopFile.msgData);
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileVideoItemBuilder<FileAssistant>", 2, "updateItem, update MessageForTroopFile, w=" + paramMessageForTroopFile.width + ", h=" + paramMessageForTroopFile.height + ", duration=" + paramMessageForTroopFile.duration);
        }
        i = 480;
        j = 640;
        if (paramMessageForTroopFile.height > 0) {
          i = paramMessageForTroopFile.height;
        }
        if (paramMessageForTroopFile.width > 0) {
          j = paramMessageForTroopFile.width;
        }
        paramMessageForTroopFile = ShortVideoUtils.a(j, i);
        i = paramMessageForTroopFile[0];
        j = paramMessageForTroopFile[1];
        paramMessageForTroopFile = paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
        if (paramMessageForTroopFile != null) {
          break label401;
        }
        paramMessageForTroopFile = new RelativeLayout.LayoutParams(i, j);
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramMessageForTroopFile);
      }
    }
    label401:
    do
    {
      for (;;)
      {
        paramMessageForTroopFile = paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
        if (paramMessageForTroopFile != null) {
          break;
        }
        paramMessageForTroopFile = new LinearLayout.LayoutParams(i, j);
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramMessageForTroopFile);
        return;
        if ((paramMessageForTroopFile.width != i) || (paramMessageForTroopFile.height != j))
        {
          paramMessageForTroopFile.width = i;
          paramMessageForTroopFile.height = j;
          paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramMessageForTroopFile);
        }
      }
    } while ((paramMessageForTroopFile.width == i) && (paramMessageForTroopFile.height == j));
    paramMessageForTroopFile.width = i;
    paramMessageForTroopFile.height = j;
    paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramMessageForTroopFile);
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo, vgu paramvgu)
  {
    if (paramvgu.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    float f = this.jdField_a_of_type_Float;
    Object localObject = new AIOFilePicMask(Color.parseColor("#D8DAE0"), 255, f * 8.0F);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localRelativeLayout.setBackground((Drawable)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      if (paramTroopFileStatusInfo.jdField_b_of_type_Int != 12) {
        break label263;
      }
      ((TextView)localObject).setText("视频已失效");
    }
    for (;;)
    {
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130845457, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramvgu.jdField_e_of_type_Int, paramvgu.f);
      ((RelativeLayout)paramvgu.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = FileUtils.a(paramTroopFileStatusInfo.jdField_b_of_type_Long);
      a(paramTroopFileStatusInfo.g, (String)localObject, paramvgu, localRelativeLayout, true);
      paramvgu.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable((Drawable)localObject);
      break;
      label263:
      ((TextView)localObject).setText("该视频格式已损坏");
    }
  }
  
  private void a(String paramString1, String paramString2, vgu paramvgu, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramvgu.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramvgu.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramvgu.jdField_a_of_type_AndroidViewView).removeView(paramvgu.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131361963);
    ((RelativeLayout)localObject1).setBackgroundResource(2130838361);
    paramvgu.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131366616);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131366616);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131366616);
      if (paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = QFileUtils.a(paramvgu.jdField_e_of_type_Int, paramvgu.f);
        paramViewGroup = new TextView(this.jdField_a_of_type_AndroidContentContext);
        paramViewGroup.setId(2131361963);
        paramViewGroup.setTextSize(2, 12.0F);
        paramViewGroup.setTextColor(-1);
        localObject2 = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout)localObject1).addView(paramViewGroup, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
        ((TextView)localObject2).setId(2131361962);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        ((TextView)localObject2).setTextColor(-1);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        if (i != 1) {
          break label606;
        }
        localLayoutParams.addRule(12);
        localLayoutParams.addRule(2, 2131361963);
        label424:
        ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject1 = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, i, paramvgu.jdField_e_of_type_Int, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
      }
      return;
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
      break;
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      break;
      label606:
      localLayoutParams.addRule(12);
      break label424;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      paramViewGroup.setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      paramViewGroup.setGravity(5);
    }
  }
  
  private boolean b(MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null) {}
    boolean bool1;
    do
    {
      return true;
      bool1 = bool2;
      if (paramMessageForTroopFile.lastTime != 0L)
      {
        bool1 = bool2;
        if (paramMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime()) {
          bool1 = true;
        }
      }
    } while (localTroopFileStatusInfo.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    vgu localvgu;
    if (vgu.class.isInstance(paramViewHolder)) {
      localvgu = (vgu)paramViewHolder;
    }
    for (paramViewHolder = paramView;; paramViewHolder = null)
    {
      this.jdField_a_of_type_AndroidContentContext.getResources();
      Object localObject = paramViewHolder;
      if (paramViewHolder == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder.setId(2131366616);
        paramViewHolder.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramViewHolder.setRadius(15.0F);
        paramViewHolder.d(true);
        paramViewHolder.setSharpCornerCor(BubbleImageView.a);
        ((RelativeLayout)localObject).addView(paramViewHolder);
        MessageProgressView localMessageProgressView = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
        localMessageProgressView.setId(2131361903);
        ((RelativeLayout)localObject).addView(localMessageProgressView);
        paramViewHolder.setOnClickListener(this);
        paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
        localvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewHolder;
        localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      boolean bool = paramChatMessage.isSend();
      if (localvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool) {
        localvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
      }
      localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnTouchListener(paramOnLongClickAndTouchListener);
      localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
      localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
      localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      localvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
      localvgu.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramChatMessage, localvgu, paramView, paramBaseChatItemLayout);
      return localObject;
      localvgu = new vgu(this);
      localvgu.jdField_b_of_type_JavaLangStringBuilder = paramViewHolder.jdField_b_of_type_JavaLangStringBuilder;
      localvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localvgu.jdField_a_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidViewView;
      localvgu.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
      localvgu.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localvgu.jdField_a_of_type_Int = paramViewHolder.jdField_a_of_type_Int;
      localvgu.jdField_b_of_type_Int = paramViewHolder.jdField_b_of_type_Int;
      localvgu.c = paramViewHolder.c;
      localvgu.d = paramViewHolder.d;
      localvgu.jdField_a_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (paramView != null)
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (vgu.class.isInstance(paramView)))
      {
        paramView = (vgu)paramView;
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vgu(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出视频文件";
    }
    return "发来视频文件";
  }
  
  protected void a(View paramView)
  {
    paramView = AIOUtils.a((View)paramView.getParent());
    if (paramView == null)
    {
      QLog.w("TroopFileVideoItemBuilder<FileAssistant>", 1, "error item click holder tag is null");
      return;
    }
    if (!vgu.class.isInstance(paramView))
    {
      QLog.e("TroopFileVideoItemBuilder<FileAssistant>", 1, "error item click holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (MessageForTroopFile)((vgu)paramView).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (localObject == null)
    {
      QLog.e("TroopFileVideoItemBuilder<FileAssistant>", 1, "error item click class but can not find.");
      return;
    }
    switch (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int)
    {
    default: 
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramView.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558623);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, i, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public void a(ChatMessage paramChatMessage, vgu paramvgu, View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramChatMessage = (MessageForTroopFile)paramChatMessage;
    paramView = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    if ((paramView == null) && (QLog.isColorLevel())) {
      QLog.d("TroopFileVideoItemBuilder<FileAssistant>", 2, "updateItem, get fileStatusInfo fail");
    }
    int i = 480;
    int j = 640;
    if (paramChatMessage.height > 0) {
      i = paramChatMessage.height;
    }
    if (paramChatMessage.width > 0) {
      j = paramChatMessage.width;
    }
    Object localObject = ShortVideoUtils.a(j, i);
    i = localObject[0];
    j = localObject[1];
    localObject = paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
    if (localObject == null)
    {
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label381;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramvgu.jdField_e_of_type_Int = i;
      paramvgu.f = j;
      localObject = FileUtils.a(paramView.jdField_b_of_type_Long);
      a(paramView.g, (String)localObject, paramvgu, (RelativeLayout)paramvgu.jdField_a_of_type_AndroidViewView, false);
      paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      if (paramvgu.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramvgu.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        ((RelativeLayout)paramvgu.jdField_a_of_type_AndroidViewView).removeView(paramvgu.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramvgu);
      a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramvgu, paramBaseChatItemLayout);
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramvgu);
      paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
      if (this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramChatMessage.getId()))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "exp_videoBubble", 0, 0, "", "", "", "");
      }
      return;
      if ((((ViewGroup.LayoutParams)localObject).width == i) && (((ViewGroup.LayoutParams)localObject).height == j)) {
        break;
      }
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      label381:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  protected void a(vgu paramvgu, int paramInt)
  {
    if (paramInt < 100)
    {
      paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramvgu.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    AIOUtils.m = true;
    if ((paramView.getId() != 2131366616) && (paramView.getId() != 2131361903)) {}
    TroopFileStatusInfo localTroopFileStatusInfo;
    TroopFileItemOperation localTroopFileItemOperation;
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = AIOUtils.a(paramView);
        if (localObject == null)
        {
          QLog.w("TroopFileVideoItemBuilder<FileAssistant>", 1, "item click holder tag is null");
          return;
        }
        if (!vgu.class.isInstance(localObject))
        {
          QLog.e("TroopFileVideoItemBuilder<FileAssistant>", 1, "item click holder tag class[" + localObject.getClass().getName() + "] is not Holder");
          return;
        }
        localObject = (MessageForTroopFile)((vgu)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForTroopFile)localObject);
        localTroopFileItemOperation = new TroopFileItemOperation(Long.parseLong(((MessageForTroopFile)localObject).frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
        if (localTroopFileStatusInfo == null)
        {
          QLog.e("TroopFileVideoItemBuilder<FileAssistant>", 1, "item click class but can not find.");
          return;
        }
        switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
        {
        case 4: 
        case 5: 
        default: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, ((MessageForTroopFile)localObject).frienduin + "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, ((MessageForTroopFile)localObject).frienduin + "", "", "", "");
        }
      } while (b((MessageForTroopFile)localObject));
      new TroopFileItemOperation(Long.valueOf(((MessageForTroopFile)localObject).frienduin).longValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)paramView.getContext()).a(localTroopFileStatusInfo, ((MessageForTroopFile)localObject).senderuin, ((MessageForTroopFile)localObject).lastTime, 3);
      return;
      paramView = new Intent();
      paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, ((MessageForTroopFile)localObject).frienduin);
      TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    } while (paramView.getId() != 2131361903);
    localTroopFileItemOperation.a(localTroopFileStatusInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileVideoItemBuilder
 * JD-Core Version:    0.7.0.1
 */