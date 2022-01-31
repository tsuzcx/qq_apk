package com.tencent.mobileqq.activity.aio.item;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.drawable.BitmapDrawableWithMargin;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.AIOImgInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.lightReply.FacePicDectect;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.troop.TroopFileProxyActivity;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import vgt;

public class TroopFilePicItemBuilder
  extends TroopFileItemBuilder
{
  private final String jdField_a_of_type_JavaLangString = "TroopFilePicItemBuilder<FileAssistant>";
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private float b = 0.5625F;
  private int e;
  private int f = this.g;
  private int g = BaseChatItemLayout.jdField_e_of_type_Int;
  private int h = (int)(BaseChatItemLayout.jdField_e_of_type_Int * this.b);
  
  public TroopFilePicItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_e_of_type_Int = this.h;
  }
  
  private Drawable a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vgt paramvgt)
  {
    paramContext = null;
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(paramMessageForTroopFile.frienduin));
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      paramMessageForTroopFile = paramContext;
      if (QLog.isDevelopLevel())
      {
        QLog.d("TroopFilePicItemBuilder<FileAssistant>", 4, "get fileStatusInfo fail ");
        paramMessageForTroopFile = paramContext;
      }
      return paramMessageForTroopFile;
    }
    int i = paramvgt.jdField_e_of_type_Int;
    int j = paramvgt.f;
    if ((URLDrawableHelper.b() instanceof SkinnableBitmapDrawable)) {
      paramContext = ((SkinnableBitmapDrawable)URLDrawableHelper.b()).getBitmap();
    }
    for (;;)
    {
      if (paramContext != null) {}
      for (paramContext = new BitmapDrawableWithMargin(this.jdField_a_of_type_AndroidContentContext.getResources(), paramContext, i, j, -921103);; paramContext = URLDrawableHelper.b())
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mLoadingDrawable = paramContext;
        localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.a();
        localURLDrawableOptions.mGifRoundCorner = 12.0F;
        localURLDrawableOptions.mPlayGifImage = false;
        if (!FileUtils.b(localTroopFileStatusInfo.d)) {
          break label232;
        }
        paramContext = URLDrawable.getDrawable(new File(localTroopFileStatusInfo.d), localURLDrawableOptions);
        paramContext.setAutoDownload(true);
        paramvgt.jdField_a_of_type_Boolean = true;
        return paramContext;
        if (!(URLDrawableHelper.b() instanceof BitmapDrawable)) {
          break label335;
        }
        paramContext = ((BitmapDrawable)URLDrawableHelper.b()).getBitmap();
        break;
      }
      label232:
      j = 383;
      i = j;
      if (FilePicURLDrawlableHelper.b(paramMessageForTroopFile.width, paramMessageForTroopFile.height))
      {
        i = j;
        if (!FileUtil.b(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
          i = 640;
        }
      }
      paramMessageForTroopFile = paramContext;
      if (localTroopFileStatusInfo.jdField_b_of_type_Int == 12) {
        break;
      }
      if (localTroopFileStatusInfo.a != null)
      {
        localTroopFileTransferManager.a(localTroopFileStatusInfo.a, i);
        return paramContext;
      }
      localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_e_of_type_Int, i);
      return paramContext;
      label335:
      paramContext = null;
    }
  }
  
  private void a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vgt paramvgt)
  {
    paramContext = LightReplyMenuManager.a();
    if (paramvgt.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      paramvgt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramvgt.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      paramvgt.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
    }
    if ((paramContext.d()) && (!a(paramvgt)) && (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (PicItemBuilder.a(this.jdField_a_of_type_AndroidContentContext)))
    {
      boolean bool = a(paramMessageForTroopFile);
      if ((!paramMessageForTroopFile.isSend()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!bool) && (paramContext != null) && (paramContext.d()) && (paramContext.a(paramMessageForTroopFile)))
      {
        if (paramvgt.jdField_a_of_type_AndroidWidgetImageView != null) {
          break label308;
        }
        paramContext = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramContext.setImageResource(2130841406);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(36.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        localLayoutParams.addRule(8, 2131366616);
        localLayoutParams.addRule(1, 2131366616);
        localLayoutParams.leftMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramContext.setId(2131361956);
        ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).addView(paramContext, localLayoutParams);
        paramContext.setOnClickListener(this);
        paramvgt.jdField_a_of_type_AndroidWidgetImageView = paramContext;
      }
    }
    for (;;)
    {
      if (paramvgt.jdField_a_of_type_Long != paramMessageForTroopFile.shmsgseq)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_replyPic", "", "Grp_AIO", "exp_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        paramvgt.jdField_a_of_type_Long = paramMessageForTroopFile.shmsgseq;
      }
      return;
      label308:
      paramvgt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      paramvgt.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
  }
  
  private void a(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vgt paramvgt, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int k = 0;
    int j = -1;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFilePicItemBuilder<FileAssistant>", 4, "get fileStatusInfo fail ");
      }
      return;
    }
    int i = k;
    if (paramMessageForTroopFile.lastTime != 0L)
    {
      i = k;
      if (paramMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime()) {
        i = 1;
      }
    }
    if (localTroopFileStatusInfo.jdField_b_of_type_Int == 12) {
      i = 1;
    }
    if ((i != 0) && (!a(localTroopFileStatusInfo)))
    {
      paramvgt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
      paramvgt.jdField_a_of_type_ComTencentImageURLDrawable = null;
      a(paramvgt);
      paramvgt.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramvgt.jdField_a_of_type_AndroidViewView.setOnTouchListener(null);
      paramvgt.jdField_a_of_type_AndroidViewView.setOnLongClickListener(null);
      return;
    }
    a(paramContext, paramMessageForTroopFile, paramvgt);
    i = j;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      i = j;
    case 4: 
      if (i == 2) {
        if (paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
        {
          paramContext = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
          paramContext.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
          paramContext.setSharpCornerCor(BubbleImageView.a);
          paramContext.setShowCorner(false);
          paramContext.setProgressBackgroudColor(2130706432);
          paramContext.a(paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          paramMessageForTroopFile = new RelativeLayout.LayoutParams(-2, -2);
          paramMessageForTroopFile.addRule(6, 2131366616);
          paramMessageForTroopFile.addRule(8, 2131366616);
          paramMessageForTroopFile.addRule(5, 2131366616);
          paramMessageForTroopFile.addRule(7, 2131366616);
          ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).addView(paramContext, paramMessageForTroopFile);
          paramContext.setProgress(0);
          paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = paramContext;
          paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          label417:
          paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
        }
      }
      break;
    }
    for (;;)
    {
      if ((i != 0) || (localTroopFileStatusInfo.jdField_b_of_type_Int != 3)) {
        break label777;
      }
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
      i = -1;
      break;
      i = -1;
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
      i = 0;
      break;
      paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(TroopFileUtils.a(localTroopFileStatusInfo.jdField_c_of_type_Long, localTroopFileStatusInfo.jdField_b_of_type_Long));
      break label417;
      if (i == 0)
      {
        if (paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
          if (!paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
          {
            ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).removeView(paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          else
          {
            paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
          }
        }
      }
      else if (i == 3)
      {
        if (paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
          if (!paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
          {
            ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).removeView(paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
            paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
          }
          else
          {
            paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
          }
        }
      }
      else if (paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView != null) {
        if (!paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramvgt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
        {
          ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).removeView(paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
          paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
        }
        else
        {
          paramvgt.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
        }
      }
    }
    label777:
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
  }
  
  private void a(String paramString1, String paramString2, vgt paramvgt)
  {
    if (paramvgt.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramvgt.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).removeView(paramvgt.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131361958);
    localRelativeLayout.setBackgroundResource(2130838361);
    paramvgt.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131366616);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131366616);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131366616);
    ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = QFileUtils.a(paramvgt.jdField_e_of_type_Int, paramvgt.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131361963);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131361962);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131361963);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, i, paramvgt.jdField_e_of_type_Int, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
      switch (i)
      {
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramString1);
      ((TextView)localObject1).setText(paramString2);
      return;
      localLayoutParams.addRule(12);
      break;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject1).setGravity(5);
    }
  }
  
  @TargetApi(16)
  private void a(vgt paramvgt)
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    float f1 = this.jdField_a_of_type_Float;
    Object localObject = new AIOFilePicMask(Color.parseColor("#D8DAE0"), 255, f1 * 14.0F);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground((Drawable)localObject);
    }
    for (;;)
    {
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextColor(Color.rgb(178, 182, 195));
      ((TextView)localObject).setText(2131433434);
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 2130845457, 0, 0);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 17;
      localFrameLayout.addView((View)localObject, localLayoutParams);
      localObject = new RelativeLayout.LayoutParams(paramvgt.jdField_e_of_type_Int, paramvgt.f);
      ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).addView(localFrameLayout, (ViewGroup.LayoutParams)localObject);
      paramvgt.jdField_a_of_type_AndroidWidgetFrameLayout = localFrameLayout;
      return;
      localFrameLayout.setBackgroundDrawable((Drawable)localObject);
    }
  }
  
  private boolean a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    return false;
  }
  
  private boolean a(vgt paramvgt)
  {
    return (paramvgt.jdField_a_of_type_AndroidWidgetImageView != null) && (paramvgt.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0);
  }
  
  private void b(Context paramContext, View paramView, MessageForTroopFile paramMessageForTroopFile)
  {
    if (!(paramContext instanceof MultiForwardActivity)) {}
    for (boolean bool = true;; bool = false)
    {
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramView, paramMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool);
      return;
    }
  }
  
  private void b(Context paramContext, MessageForTroopFile paramMessageForTroopFile, vgt paramvgt)
  {
    if (paramvgt.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      paramvgt.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130840623);
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492968));
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setText(2131430830);
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setPadding(DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F), 0);
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.topMargin = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramContext.addRule(3, 2131366616);
      paramContext.addRule(5, 2131366616);
      ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).addView(paramvgt.jdField_a_of_type_AndroidWidgetTextView, paramContext);
    }
    if (paramMessageForTroopFile.isSend())
    {
      paramvgt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    paramvgt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)paramChatMessage;
    if (vgt.class.isInstance(paramViewHolder)) {
      paramViewHolder = (vgt)paramViewHolder;
    }
    for (paramChatMessage = paramView;; paramChatMessage = null)
    {
      paramView = paramChatMessage;
      if (paramChatMessage == null)
      {
        paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setId(2131366616);
        paramChatMessage.setAdjustViewBounds(true);
        paramChatMessage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramChatMessage.setRadius(15.0F);
        paramChatMessage.d(false);
        paramChatMessage.setShowEdge(true);
        paramView.addView(paramChatMessage, new RelativeLayout.LayoutParams(-2, -2));
        paramViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramChatMessage;
        paramView.setOnClickListener(this);
        paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
        paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      }
      paramViewHolder.jdField_a_of_type_AndroidViewView = paramView;
      a(paramBaseChatItemLayout, localMessageForTroopFile, paramViewHolder);
      return paramView;
      paramChatMessage = new vgt(this);
      paramChatMessage.jdField_b_of_type_JavaLangStringBuilder = paramViewHolder.jdField_b_of_type_JavaLangStringBuilder;
      paramChatMessage.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramChatMessage.jdField_a_of_type_AndroidViewView = paramViewHolder.jdField_a_of_type_AndroidViewView;
      paramChatMessage.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo = paramViewHolder.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo;
      paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramChatMessage.jdField_a_of_type_Int = paramViewHolder.jdField_a_of_type_Int;
      paramChatMessage.jdField_b_of_type_Int = paramViewHolder.jdField_b_of_type_Int;
      paramChatMessage.c = paramViewHolder.c;
      paramChatMessage.d = paramViewHolder.d;
      paramChatMessage.jdField_a_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      paramViewHolder = paramChatMessage;
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (vgt.class.isInstance(paramView))) {
        return ((vgt)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new vgt(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (MsgUtils.a(paramChatMessage.issend)) {
      return "发出图片文件";
    }
    return "发来图片文件";
  }
  
  protected void a(View paramView)
  {
    paramView = AIOUtils.a((View)paramView.getParent());
    if (paramView == null)
    {
      QLog.w("TroopFilePicItemBuilder<FileAssistant>", 1, "error item click holder tag is null");
      return;
    }
    if (!vgt.class.isInstance(paramView))
    {
      QLog.e("TroopFilePicItemBuilder<FileAssistant>", 1, "error item click holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (MessageForTroopFile)((vgt)paramView).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Object localObject = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
    if (localObject == null)
    {
      QLog.e("TroopFilePicItemBuilder<FileAssistant>", 1, "error item click class but can not find.");
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
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForTroopFile paramMessageForTroopFile, vgt paramvgt)
  {
    paramMessageForTroopFile.doParse();
    if (!paramMessageForTroopFile.bReported)
    {
      paramMessageForTroopFile.bReported = true;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_appear_AIO", 0, 0, "", paramMessageForTroopFile.frienduin, "", "");
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFilePicItemBuilder<FileAssistant>", 4, "Build TroopFileItem");
      }
    }
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopFilePicItemBuilder<FileAssistant>", 4, "get fileStatusInfo fail ");
      }
      return;
    }
    if (paramvgt.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      paramvgt.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      ((RelativeLayout)paramvgt.jdField_a_of_type_AndroidViewView).removeView(paramvgt.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
    Object localObject = FilePicURLDrawlableHelper.a(paramMessageForTroopFile.width, paramMessageForTroopFile.height, localTroopFileStatusInfo.d);
    int i = ((FilePicURLDrawlableHelper.AIOImgInfo)localObject).jdField_a_of_type_Int;
    int j = ((FilePicURLDrawlableHelper.AIOImgInfo)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramvgt.jdField_e_of_type_Int = i;
      paramvgt.f = j;
      label180:
      localObject = paramvgt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label353;
      }
      localObject = new RelativeLayout.LayoutParams(paramvgt.jdField_e_of_type_Int, paramvgt.f);
      paramvgt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    for (;;)
    {
      b(this.jdField_a_of_type_AndroidContentContext, paramMessageForTroopFile, paramvgt);
      a(localTroopFileStatusInfo.g, FileUtils.a(localTroopFileStatusInfo.jdField_b_of_type_Long), paramvgt);
      a(this.jdField_a_of_type_AndroidContentContext, paramMessageForTroopFile, paramvgt, paramBaseChatItemLayout);
      paramBaseChatItemLayout = a(this.jdField_a_of_type_AndroidContentContext, paramMessageForTroopFile, paramvgt);
      paramvgt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBaseChatItemLayout);
      if (!this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramMessageForTroopFile.getId()))) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "exp_picBubble", 0, 0, "", "", "", "");
      return;
      paramvgt.jdField_e_of_type_Int = this.jdField_e_of_type_Int;
      paramvgt.f = this.f;
      break label180;
      label353:
      if ((((ViewGroup.LayoutParams)localObject).width != paramvgt.jdField_e_of_type_Int) || (((ViewGroup.LayoutParams)localObject).height != paramvgt.f))
      {
        ((ViewGroup.LayoutParams)localObject).width = paramvgt.jdField_e_of_type_Int;
        ((ViewGroup.LayoutParams)localObject).height = paramvgt.f;
        paramvgt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131361877)
    {
      AIOUtils.m = true;
      paramView = AIOUtils.a(paramView);
      if (paramView == null) {
        QLog.w("TroopFilePicItemBuilder<FileAssistant>", 1, "item click holder tag is null");
      }
    }
    while (paramView.getId() != 2131361956)
    {
      return;
      if (!vgt.class.isInstance(paramView))
      {
        QLog.e("TroopFilePicItemBuilder<FileAssistant>", 1, "item click holder tag class[" + paramView.getClass().getName() + "] is not Holder");
        return;
      }
      localObject1 = (vgt)paramView;
      paramView = (MessageForTroopFile)((vgt)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      localObject2 = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      if (localObject2 == null)
      {
        QLog.e("TroopFilePicItemBuilder<FileAssistant>", 1, "item click class but can not find.");
        return;
      }
      switch (((TroopFileStatusInfo)localObject2).jdField_b_of_type_Int)
      {
      default: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, paramView.frienduin + "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, paramView.frienduin + "", "", "", "");
        if (c(paramView)) {
          b(this.jdField_a_of_type_AndroidContentContext, ((vgt)localObject1).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, paramView);
        }
        break;
      }
      while (QLog.isColorLevel())
      {
        QLog.i("TroopFilePicItemBuilder<FileAssistant>", 1, "troop aio picture file is click");
        return;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, paramView.frienduin);
        TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        continue;
        new TroopFileItemOperation(Long.valueOf(paramView.frienduin).longValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext).a((TroopFileStatusInfo)localObject2, paramView.senderuin, paramView.lastTime, 3);
      }
    }
    Object localObject1 = AIOUtils.a(paramView);
    Object localObject2 = (vgt)AIOUtils.a(paramView);
    localObject1 = (MessageForTroopFile)localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a();
      this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.e();
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_replyPic", "", "Grp_AIO", "clk_reply", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a.a())) {
        this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a.a();
      }
      if ((LightReplyMenuManager.a().c()) && (localObject1 != null))
      {
        Object localObject3 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject3 != null)
        {
          localObject3 = ((ChatFragment)localObject3).a();
          if (localObject3 != null)
          {
            localObject2 = ((vgt)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getDrawable();
            int[] arrayOfInt = new int[2];
            paramView.getLocationOnScreen(arrayOfInt);
            int i = arrayOfInt[1];
            int j = AIOUtils.a(58.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            if (this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqLightReplyLightReplyMenuManager.a(this.jdField_a_of_type_AndroidContentContext, ((BaseChatPie)localObject3).a(), ((MessageForTroopFile)localObject1).istroop, ((MessageForTroopFile)localObject1).frienduin, ((MessageForTroopFile)localObject1).shmsgseq, 0, (Drawable)localObject2, this, true, 0, i - j);
            }
          }
        }
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, -1, "出错了，请稍后重试！", 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFilePicItemBuilder
 * JD-Core Version:    0.7.0.1
 */