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
import vjw;

public class TroopFileVideoItemBuilder
  extends TroopFileItemBuilder
{
  private final String jdField_a_of_type_JavaLangString = "TroopFileVideoItemBuilder<FileAssistant>";
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  
  public TroopFileVideoItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private Drawable a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vjw paramvjw)
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
        a(paramMessageForTroopFile, paramvjw);
      }
      paramMessageForTroopFile = URLDrawable.URLDrawableOptions.obtain();
      paramMessageForTroopFile.mRequestWidth = paramvjw.jdField_e_of_type_Int;
      paramMessageForTroopFile.mRequestHeight = paramvjw.f;
      paramMessageForTroopFile.mLoadingDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramvjw.jdField_e_of_type_Int, paramvjw.f);
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
      return new EmptyDrawable(Color.rgb(214, 214, 214), paramvjw.jdField_e_of_type_Int, paramvjw.f);
      label224:
      localTroopFileTransferManager.a(paramContext.jdField_e_of_type_JavaLangString, paramContext.g, paramContext.jdField_e_of_type_Int, 383);
    }
  }
  
  private void a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vjw paramvjw)
  {
    if (paramvjw.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      paramvjw.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840645);
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492969));
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setText(2131430847);
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0);
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.topMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramContext.addRule(3, 2131366640);
      paramContext.addRule(5, 2131361963);
      ((RelativeLayout)paramvjw.jdField_a_of_type_AndroidViewView).addView(paramvjw.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    }
    if (paramMessageForTroopFile.isSend())
    {
      paramvjw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    paramvjw.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vjw paramvjw, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramContext = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if ((paramContext == null) && (QLog.isColorLevel())) {
      QLog.d("TroopFileVideoItemBuilder<FileAssistant>", 2, "updateItem, get fileStatusInfo fail");
    }
    boolean bool = b(paramMessageForTroopFile);
    int j = -1;
    if (bool)
    {
      a(paramContext, paramvjw);
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
        a(paramvjw, TroopFileUtils.a(paramContext.c, paramContext.jdField_b_of_type_Long));
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
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845584);
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription("恢复按钮");
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
      }
      else if (i == 3)
      {
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription("恢复按钮");
        if (paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
        {
          paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishResource(2130845584);
          paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        else
        {
          paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130845584);
          paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
        }
      }
      else if (paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
      {
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawFinishDefault(true);
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      }
      else
      {
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
      }
    }
    label565:
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
  }
  
  private void a(MessageForTroopFile paramMessageForTroopFile, vjw paramvjw)
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
        paramvjw.jdField_e_of_type_Int = paramMessageForTroopFile.width;
        paramvjw.f = paramMessageForTroopFile.height;
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
        paramMessageForTroopFile = paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
        if (paramMessageForTroopFile != null) {
          break label401;
        }
        paramMessageForTroopFile = new RelativeLayout.LayoutParams(i, j);
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramMessageForTroopFile);
      }
    }
    label401:
    do
    {
      for (;;)
      {
        paramMessageForTroopFile = paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
        if (paramMessageForTroopFile != null) {
          break;
        }
        paramMessageForTroopFile = new LinearLayout.LayoutParams(i, j);
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramMessageForTroopFile);
        return;
        if ((paramMessageForTroopFile.width != i) || (paramMessageForTroopFile.height != j))
        {
          paramMessageForTroopFile.width = i;
          paramMessageForTroopFile.height = j;
          paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramMessageForTroopFile);
        }
      }
    } while ((paramMessageForTroopFile.width == i) && (paramMessageForTroopFile.height == j));
    paramMessageForTroopFile.width = i;
    paramMessageForTroopFile.height = j;
    paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramMessageForTroopFile);
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo, vjw paramvjw)
  {
    if (paramvjw.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setVisibility(4);
    paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
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
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130845585, 0, 0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramvjw.jdField_e_of_type_Int, paramvjw.f);
      ((RelativeLayout)paramvjw.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = FileUtils.a(paramTroopFileStatusInfo.jdField_b_of_type_Long);
      a(paramTroopFileStatusInfo.g, (String)localObject, paramvjw, localRelativeLayout, true);
      paramvjw.jdField_b_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      return;
      localRelativeLayout.setBackgroundDrawable((Drawable)localObject);
      break;
      label263:
      ((TextView)localObject).setText("该视频格式已损坏");
    }
  }
  
  private void a(String paramString1, String paramString2, vjw paramvjw, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramvjw.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramvjw.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramvjw.jdField_a_of_type_AndroidViewView).removeView(paramvjw.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject1).setId(2131361963);
    ((RelativeLayout)localObject1).setBackgroundResource(2130838365);
    paramvjw.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    RelativeLayout.LayoutParams localLayoutParams;
    if (!paramBoolean)
    {
      ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131366640);
      ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131366640);
      ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131366640);
      if (paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d)
      {
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = QFileUtils.a(paramvjw.jdField_e_of_type_Int, paramvjw.f);
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
        localObject1 = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, i, paramvjw.jdField_e_of_type_Int, (TextView)localObject2, paramViewGroup, paramString1, paramString2);
        switch (i)
        {
        }
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramViewGroup.setText(paramString2);
      if (paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView != null) {
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(paramString1 + " " + paramString2);
      }
      if (paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView != null) {
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setContentDescription(paramString1 + " " + paramString2);
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
    vjw localvjw;
    if (vjw.class.isInstance(paramViewHolder)) {
      localvjw = (vjw)paramViewHolder;
    }
    for (paramViewHolder = paramView;; paramViewHolder = null)
    {
      this.jdField_a_of_type_AndroidContentContext.getResources();
      Object localObject = paramViewHolder;
      if (paramViewHolder == null)
      {
        localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        paramViewHolder.setId(2131366640);
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
        localvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramViewHolder;
        localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      }
      boolean bool = paramChatMessage.isSend();
      if (localvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool) {
        localvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setSend(bool);
      }
      localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnClickListener(this);
      localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnTouchListener(paramOnLongClickAndTouchListener);
      localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
      localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
      localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(bool);
      localvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
      localvjw.jdField_a_of_type_AndroidViewView = ((View)localObject);
      a(paramChatMessage, localvjw, paramView, paramBaseChatItemLayout);
      return localObject;
      localvjw = new vjw(this);
      localvjw.jdField_b_of_type_JavaLangStringBuilder = paramViewHolder.jdField_b_of_type_JavaLangStringBuilder;
      localvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localvjw.jdField_a_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidViewView;
      localvjw.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
      localvjw.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      localvjw.jdField_a_of_type_Int = paramViewHolder.jdField_a_of_type_Int;
      localvjw.jdField_b_of_type_Int = paramViewHolder.jdField_b_of_type_Int;
      localvjw.c = paramViewHolder.c;
      localvjw.d = paramViewHolder.d;
      localvjw.jdField_a_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if (paramView != null)
    {
      paramView = AIOUtils.a(paramView);
      if ((paramView != null) && (vjw.class.isInstance(paramView)))
      {
        paramView = (vjw)paramView;
        if (paramView != null) {
          return paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        }
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vjw(this);
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
    if (!vjw.class.isInstance(paramView))
    {
      QLog.e("TroopFileVideoItemBuilder<FileAssistant>", 1, "error item click holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (MessageForTroopFile)((vjw)paramView).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
  
  public void a(ChatMessage paramChatMessage, vjw paramvjw, View paramView, BaseChatItemLayout paramBaseChatItemLayout)
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
    localObject = paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
    if (localObject == null)
    {
      localObject = new RelativeLayout.LayoutParams(i, j);
      paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (localObject != null) {
        break label381;
      }
      localObject = new LinearLayout.LayoutParams(i, j);
      paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      paramvjw.jdField_e_of_type_Int = i;
      paramvjw.f = j;
      localObject = FileUtils.a(paramView.jdField_b_of_type_Long);
      a(paramView.g, (String)localObject, paramvjw, (RelativeLayout)paramvjw.jdField_a_of_type_AndroidViewView, false);
      paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      if (paramvjw.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
      {
        paramvjw.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
        ((RelativeLayout)paramvjw.jdField_a_of_type_AndroidViewView).removeView(paramvjw.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramvjw);
      a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramvjw, paramBaseChatItemLayout);
      paramView = a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramvjw);
      paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
      if (this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramChatMessage.getId()))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "exp_videoBubble", 0, 0, "", "", "", "");
      }
      return;
      if ((((ViewGroup.LayoutParams)localObject).width == i) && (((ViewGroup.LayoutParams)localObject).height == j)) {
        break;
      }
      ((ViewGroup.LayoutParams)localObject).width = i;
      ((ViewGroup.LayoutParams)localObject).height = j;
      paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      label381:
      if ((((ViewGroup.LayoutParams)localObject).width != i) || (((ViewGroup.LayoutParams)localObject).height != j))
      {
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = j;
        paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  protected void a(vjw paramvjw, int paramInt)
  {
    if (paramInt < 100)
    {
      paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramvjw.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvjw.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    AIOUtils.m = true;
    if ((paramView.getId() != 2131366640) && (paramView.getId() != 2131361903)) {}
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
        if (!vjw.class.isInstance(localObject))
        {
          QLog.e("TroopFileVideoItemBuilder<FileAssistant>", 1, "item click holder tag class[" + localObject.getClass().getName() + "] is not Holder");
          return;
        }
        localObject = (MessageForTroopFile)((vjw)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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