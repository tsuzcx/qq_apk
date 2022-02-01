package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.BaseDoodleMsgView;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayoutListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.doodle.IDoodlePanelHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.ProgressPieDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class ScribbleItemBuilder
  extends QIMTailItemBubbleBuilder
  implements BaseBubbleBuilder.TouchDelegate, Callback, DoodleMsgLayoutListener
{
  public static int w;
  protected static int x;
  public static int y;
  public static int z;
  protected View.OnClickListener A = new ScribbleItemBuilder.1(this);
  private Handler B = new Handler();
  protected long a = 0L;
  
  public ScribbleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    if (w == 0)
    {
      z = BaseChatItemLayout.getBubblePaddingAlignError() + paramContext.getResources().getDimensionPixelSize(2131296621);
      y = BaseChatItemLayout.getBubblePaddingAlignHead() + paramContext.getResources().getDimensionPixelSize(2131296622);
      x = BaseChatItemLayout.l + paramContext.getResources().getDimensionPixelSize(2131296623);
      w = BaseChatItemLayout.k + paramContext.getResources().getDimensionPixelSize(2131296624);
    }
  }
  
  private int a(MessageForScribble paramMessageForScribble, ScribbleItemBuilder.Holder paramHolder, View paramView)
  {
    if (paramMessageForScribble.isSendFromLocal())
    {
      boolean bool = paramMessageForScribble.mExistInfo.mLocalPathExist;
      if (!paramMessageForScribble.mExistInfo.mInit) {
        bool = FileUtil.d(paramMessageForScribble.localFildPath);
      }
      if (bool)
      {
        int i = paramMessageForScribble.fileUploadStatus;
        if (i == 1)
        {
          QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据已发送成功");
          return 3;
        }
        if (i == 2)
        {
          QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据发送失败");
          return 2;
        }
        if (i == 3)
        {
          QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据发送中");
          paramHolder = (BaseTransProcessor)((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq);
          FileTransferManager localFileTransferManager = FileTransferManager.a(this.d);
          if (localFileTransferManager != null) {
            localFileTransferManager.a(paramView, this);
          }
          if (paramHolder != null)
          {
            i = paramHolder.getProgress();
            paramMessageForScribble = new StringBuilder();
            paramMessageForScribble.append("发送涂鸦数据进行中 progress 为：");
            paramMessageForScribble.append(i);
            QLog.d("ScribbleItemBuilder", 2, paramMessageForScribble.toString());
            return 1;
          }
          paramHolder = new StringBuilder();
          paramHolder.append("status ==  MessageForScribble.TRANS_STAUS_UP_SENDING !STATUS_SEND_FAIL uniseq：");
          paramHolder.append(paramMessageForScribble.uniseq);
          QLog.d("ScribbleItemBuilder", 2, paramHolder.toString());
          return 2;
        }
        QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据已发送完啦");
        return 3;
      }
      QLog.i("ScribbleItemBuilder", 2, "发送MessageForScribble NOT EXIST");
      paramHolder = FileTransferManager.a(this.d);
      if (paramHolder != null) {
        paramHolder.a(paramView, this);
      }
      QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据开始下载");
      ((IScribbleDownloader)this.d.getRuntimeService(IScribbleDownloader.class)).DownloadFromAio(paramMessageForScribble);
      return 4;
    }
    if (((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).getScribbleDataReadyState(paramMessageForScribble) == ScribbleMsgConstants.c)
    {
      QLog.i("ScribbleItemBuilder", 2, "MessageForScribble EXIST");
      return 6;
    }
    QLog.i("ScribbleItemBuilder", 2, "MessageForScribble NOT EXIST");
    if (paramMessageForScribble.fileDownloadStatus == 2) {
      return 5;
    }
    paramHolder = FileTransferManager.a(this.d);
    if (paramHolder != null) {
      paramHolder.a(paramView, this);
    }
    QLog.i("ScribbleItemBuilder", 2, "涂鸦数据开始下载");
    ((IScribbleDownloader)this.d.getRuntimeService(IScribbleDownloader.class)).DownloadFromAio(paramMessageForScribble);
    return 4;
  }
  
  private BaseDoodleMsgLayout a(Context paramContext)
  {
    return ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).createMsgLayout(paramContext);
  }
  
  private static ProgressPieDrawable a(Context paramContext, Handler paramHandler)
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(paramContext);
    localProgressPieDrawable.a(AIOUtils.b(50.0F, paramContext.getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.h(-1);
    localProgressPieDrawable.g(0);
    localProgressPieDrawable.e(-15550475);
    localProgressPieDrawable.j(3);
    localProgressPieDrawable.D = true;
    localProgressPieDrawable.A = 2;
    localProgressPieDrawable.a(new ScribbleItemBuilder.3(paramHandler));
    return localProgressPieDrawable;
  }
  
  public static ProgressPieDrawable a(MessageForScribble paramMessageForScribble, Context paramContext, Handler paramHandler)
  {
    if (paramMessageForScribble.mProgressPie != null) {
      return paramMessageForScribble.mProgressPie;
    }
    paramContext = a(paramContext, paramHandler);
    paramMessageForScribble.mProgressPie = paramContext;
    return paramContext;
  }
  
  private void a(View paramView, MessageForScribble paramMessageForScribble)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.e, null);
    localActionSheet.addButton(2131886574, 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new ScribbleItemBuilder.2(this, paramView, paramMessageForScribble, localActionSheet));
    localActionSheet.show();
  }
  
  private void a(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if (paramHolder != null)
    {
      if (paramMessageForScribble == null) {
        return;
      }
      QLog.i("ScribbleItemBuilder", 2, "onRecvingState MessageForScribble NOT EXIST");
      long l1 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getUniID(paramMessageForScribble);
      long l2 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getMsgID(paramMessageForScribble);
      ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).registLayout(l1, l2, paramHolder.l, paramHolder.a);
      paramHolder.j.setFailedIconVisable(false, null);
      if (!paramBoolean) {
        paramHolder.a.a(null, 0, false);
      }
    }
  }
  
  private void a(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    if (paramHolder != null)
    {
      if (paramMessageForScribble == null) {
        return;
      }
      long l1 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getUniID(paramMessageForScribble);
      long l2 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getMsgID(paramMessageForScribble);
      ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).registLayout(l1, l2, paramHolder.l, paramHolder.a);
      paramHolder.j.setFailedIconVisable(false, null);
      if ((paramInt != 0) && (paramInt != -1))
      {
        if (paramInt == 1) {
          paramHolder.a.a();
        } else {
          paramHolder.a.a(false);
        }
      }
      else {
        paramHolder.a.b();
      }
      if (!paramBoolean)
      {
        paramBoolean = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).isNewMsgAndNotPlayed(l1, l2);
        if ((!paramHolder.a.a(((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).getScribbleDataFilePath(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean ^ true)) && (paramInt == 1)) {
          paramHolder.a.b();
        }
      }
    }
  }
  
  protected static void a(MessageForScribble paramMessageForScribble, ScribbleItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean, Context paramContext, Handler paramHandler)
  {
    paramHolder.b.setDrawStatus(1);
    MessageProgressView localMessageProgressView = paramHolder.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMessageForScribble.frienduin);
    localStringBuilder.append(paramMessageForScribble.uniseq);
    localMessageProgressView.setAnimProgress(paramInt, localStringBuilder.toString());
    paramContext = a(paramMessageForScribble, paramContext, paramHandler);
    paramContext.b();
    paramHolder.b.setVisibility(0);
    paramInt = ShortVideoUtils.getDisplayProgress(paramInt, 10);
    if (paramBoolean) {
      paramContext.c(paramInt);
    } else {
      paramContext.d(paramInt);
    }
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("[setProgress] uinseq:");
      paramHolder.append(paramMessageForScribble.uniseq);
      paramHolder.append(", p:");
      paramHolder.append(paramInt);
      paramHolder.append(", current:");
      paramHolder.append(paramContext.c());
      QLog.d("ScribbleItemBuilder", 2, paramHolder.toString());
    }
    paramContext.b(true);
    paramContext.d(false);
    paramContext.g(1426063360);
    paramMessageForScribble = new StringBuilder();
    paramMessageForScribble.append(String.valueOf(paramInt));
    paramMessageForScribble.append("%");
    paramContext.a(paramMessageForScribble.toString());
  }
  
  private static void a(MessageForScribble paramMessageForScribble, FileMsg paramFileMsg)
  {
    if ((paramFileMsg != null) && (paramFileMsg.fileSize > 0L))
    {
      paramMessageForScribble.mRealProgress = ((int)(paramFileMsg.transferedSize * 100L / paramFileMsg.fileSize));
      paramMessageForScribble.mUiProgress = paramMessageForScribble.mRealProgress;
    }
  }
  
  private void b(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if (paramHolder != null)
    {
      if (paramMessageForScribble == null) {
        return;
      }
      long l1 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getUniID(paramMessageForScribble);
      long l2 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getMsgID(paramMessageForScribble);
      ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).registLayout(l1, l2, paramHolder.l, paramHolder.a);
      paramHolder.a.a(false);
      paramHolder.j.setFailedIconVisable(true, this);
      if (!paramBoolean) {
        paramHolder.a.a(null, 0, false);
      }
    }
  }
  
  private void b(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    if ((paramHolder != null) && (paramMessageForScribble != null))
    {
      long l1 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getUniID(paramMessageForScribble);
      long l2 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getMsgID(paramMessageForScribble);
      ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).registLayout(l1, l2, paramHolder.l, paramHolder.a);
      if ((paramInt != 0) && (paramInt != -1))
      {
        if (paramInt == 1) {
          paramHolder.a.a();
        } else {
          paramHolder.a.a(false);
        }
      }
      else {
        paramHolder.a.b();
      }
      paramHolder.j.setFailedIconVisable(true, this);
      if (!paramBoolean)
      {
        paramBoolean = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).isNewMsgAndNotPlayed(l1, l2);
        if ((!paramHolder.a.a(((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).getScribbleDataFilePath(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean ^ true)) && (paramInt == 1)) {
          paramHolder.a.b();
        }
      }
      return;
    }
  }
  
  private static void b(MessageForScribble paramMessageForScribble)
  {
    int i = Math.max(paramMessageForScribble.mRealProgress, 68);
    if ((NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) && (paramMessageForScribble.mUiProgress < i)) {
      paramMessageForScribble.mUiProgress += 1;
    }
  }
  
  private void c(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    if (paramHolder != null)
    {
      if (paramMessageForScribble == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendOkState:");
      localStringBuilder.append(paramBoolean);
      QLog.d("ScribbleItemBuilder", 2, localStringBuilder.toString());
      long l1 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getUniID(paramMessageForScribble);
      long l2 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getMsgID(paramMessageForScribble);
      ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).registLayout(l1, l2, paramHolder.l, paramHolder.a);
      if ((paramInt != 0) && (paramInt != -1))
      {
        if (paramInt == 1) {
          paramHolder.a.a();
        } else {
          paramHolder.a.a(false);
        }
      }
      else {
        paramHolder.a.b();
      }
      paramHolder.j.setFailedIconVisable(false, null);
      if (!paramBoolean)
      {
        paramBoolean = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).isNewMsgAndNotPlayed(l1, l2);
        if ((!paramHolder.a.a(((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).getScribbleDataFilePath(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean ^ true)) && (paramInt == 1)) {
          paramHolder.a.b();
        }
      }
    }
  }
  
  private void c(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble == null) {
      return;
    }
    this.B.removeCallbacks(paramMessageForScribble.mUpdateProgressRunnable);
    paramMessageForScribble.mUpdateProgressRunnable = null;
  }
  
  private void d(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    if (paramHolder != null)
    {
      if (paramMessageForScribble == null) {
        return;
      }
      long l1 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getUniID(paramMessageForScribble);
      long l2 = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).getMsgID(paramMessageForScribble);
      ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).registLayout(l1, l2, paramHolder.l, paramHolder.a);
      if ((paramInt != 0) && (paramInt != -1))
      {
        if (paramInt == 1) {
          paramHolder.a.a();
        } else {
          paramHolder.a.a(false);
        }
      }
      else {
        paramHolder.a.b();
      }
      paramHolder.j.setFailedIconVisable(false, null);
      if (!paramBoolean)
      {
        paramBoolean = ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).isNewMsgAndNotPlayed(l1, l2);
        if ((!paramHolder.a.a(((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).getScribbleDataFilePath(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean ^ true)) && (paramInt == 1)) {
          paramHolder.a.b();
        }
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = paramViewGroup;
    if ((paramViewGroup instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramViewGroup;
      paramView = a(this.d, paramView, this.f, paramChatMessage, this.A);
    }
    return paramView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    try
    {
      paramViewHolder = (ScribbleItemBuilder.Holder)paramViewHolder;
    }
    catch (Exception paramViewHolder)
    {
      paramBaseChatItemLayout = new StringBuilder();
      paramBaseChatItemLayout.append("scribbleitem holer Exception e= ");
      paramBaseChatItemLayout.append(paramViewHolder);
      QLog.e("ScribbleItemBuilder", 2, paramBaseChatItemLayout.toString());
      paramViewHolder = null;
    }
    Object localObject;
    if ((paramChatMessage instanceof MessageForScribble))
    {
      paramBaseChatItemLayout = (MessageForScribble)paramChatMessage;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("!!!ScribbleItemBuilder  uniseq:");
      ((StringBuilder)localObject).append(paramBaseChatItemLayout.uniseq);
      QLog.i("SCRIBBLEMSG", 2, ((StringBuilder)localObject).toString());
    }
    else
    {
      paramBaseChatItemLayout = null;
    }
    if (paramBaseChatItemLayout == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "doodle msg type error!!");
      return paramView;
    }
    if (paramView == null)
    {
      paramView = new RelativeLayout(this.e);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      localObject = new RelativeLayout(this.e);
      ((RelativeLayout)localObject).setId(2131428090);
      ((RelativeLayout)localObject).setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      paramViewHolder.a = a(this.e);
      paramViewHolder.a.setOperateListener(this, paramOnLongClickAndTouchListener, paramOnLongClickAndTouchListener, this);
      ((RelativeLayout)localObject).addView(paramViewHolder.a);
      paramView.addView((View)localObject);
      paramViewHolder.c = ((RelativeLayout)localObject);
      paramOnLongClickAndTouchListener = new MessageProgressView(this.e);
      paramView.addView(paramOnLongClickAndTouchListener);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramOnLongClickAndTouchListener.getLayoutParams();
      localLayoutParams.addRule(8, 2131428090);
      localLayoutParams.addRule(5, 2131428090);
      localLayoutParams.addRule(6, 2131428090);
      localLayoutParams.addRule(7, 2131428090);
      paramOnLongClickAndTouchListener.setLayoutParams(localLayoutParams);
      paramViewHolder.b = paramOnLongClickAndTouchListener;
      paramOnLongClickAndTouchListener = paramViewHolder.b;
      float f;
      if (QQTheme.isNowSimpleUI()) {
        f = 8.0F;
      } else {
        f = 15.0F;
      }
      paramOnLongClickAndTouchListener.setRadius(f, true);
      paramViewHolder.b.setShowCorner(QQTheme.isNowSimpleUI() ^ true);
      paramViewHolder.b.setSharpCornerCor(BubbleImageView.d);
      ((RelativeLayout)localObject).setAddStatesFromChildren(true);
      paramOnLongClickAndTouchListener = paramView;
    }
    else
    {
      localObject = (MessageForScribble)paramViewHolder.b.getTag();
      paramOnLongClickAndTouchListener = paramView;
      if (localObject != null)
      {
        paramOnLongClickAndTouchListener = paramView;
        if (((MessageForScribble)localObject).mUpdateProgressRunnable != null)
        {
          this.B.removeCallbacks(((MessageForScribble)localObject).mUpdateProgressRunnable);
          ((MessageForScribble)localObject).mUpdateProgressRunnable = null;
          paramOnLongClickAndTouchListener = paramView;
        }
      }
    }
    paramViewHolder.b.setTag(paramBaseChatItemLayout);
    paramViewHolder.b.setCornerDirection(paramChatMessage.isSend());
    if (paramBaseChatItemLayout.mUpdateProgressRunnable != null) {
      this.B.removeCallbacks(paramBaseChatItemLayout.mUpdateProgressRunnable);
    }
    paramBaseChatItemLayout.mUpdateProgressRunnable = new ScribbleItemBuilder.ProgressRunnable(paramBaseChatItemLayout, paramViewHolder, this.B, this.e);
    int i = a(paramBaseChatItemLayout, paramViewHolder, paramOnLongClickAndTouchListener);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("ScribbleItemBuilder pos:");
      paramView.append(paramViewHolder.l);
      paramView.append(" State:");
      paramView.append(i);
      QLog.i("ScribbleItemBuilder", 2, paramView.toString());
    }
    switch (i)
    {
    default: 
      break;
    case 6: 
      d(paramViewHolder, paramBaseChatItemLayout, false, 1);
      a(paramViewHolder);
      break;
    case 5: 
      b(paramViewHolder, paramBaseChatItemLayout, false);
      a(paramViewHolder);
      break;
    case 4: 
      a(paramViewHolder, paramBaseChatItemLayout, false);
      this.B.post(paramBaseChatItemLayout.mUpdateProgressRunnable);
      break;
    case 3: 
      c(paramViewHolder, paramBaseChatItemLayout, false, 1);
      a(paramViewHolder);
      break;
    case 2: 
      b(paramViewHolder, paramBaseChatItemLayout, false, 1);
      a(paramViewHolder);
      break;
    case 1: 
      a(paramViewHolder, paramBaseChatItemLayout, false, 1);
      this.B.post(paramBaseChatItemLayout.mUpdateProgressRunnable);
    }
    if (v)
    {
      paramOnLongClickAndTouchListener.setContentDescription(d(paramChatMessage));
      paramViewHolder.b.setContentDescription(d(paramChatMessage));
      if (paramViewHolder.a != null) {
        paramViewHolder.a.setTalkBack(d(paramChatMessage));
      }
    }
    return paramOnLongClickAndTouchListener;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new ScribbleItemBuilder.Holder(this);
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
  
  public void a(View paramView, int paramInt)
  {
    ScribbleItemBuilder.Holder localHolder = (ScribbleItemBuilder.Holder)AIOUtils.b(paramView);
    if (localHolder == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder is null");
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)localHolder.q;
    if (localHolder.q == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResult: holder.mMessage state is: ");
    localStringBuilder.append(paramInt);
    QLog.e("ScribbleItemBuilder", 2, localStringBuilder.toString());
    switch (a(localMessageForScribble, localHolder, paramView))
    {
    default: 
      return;
    case 6: 
      d(localHolder, localMessageForScribble, true, paramInt);
      return;
    case 5: 
      b(localHolder, localMessageForScribble, true);
      return;
    case 4: 
      a(localHolder, localMessageForScribble, true);
      return;
    case 3: 
      c(localHolder, localMessageForScribble, true, paramInt);
      return;
    case 2: 
      b(localHolder, localMessageForScribble, true, paramInt);
      return;
    }
    a(localHolder, localMessageForScribble, true, paramInt);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent) {}
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(z, w, y, x);
      return;
    }
    paramView.setPadding(y, w, z, x);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = AIOUtils.b(paramView);
    if ((paramView instanceof ScribbleItemBuilder.Holder))
    {
      paramView = (ScribbleItemBuilder.Holder)paramView;
      if ((paramView != null) && (paramView.c != null))
      {
        Drawable localDrawable = paramView.c.getBackground();
        if (localDrawable != null)
        {
          if (paramBoolean) {
            paramView = null;
          } else {
            paramView = n;
          }
          localDrawable.setColorFilter(paramView);
          localDrawable.invalidateSelf();
        }
      }
    }
  }
  
  protected void a(ScribbleItemBuilder.Holder paramHolder)
  {
    QLog.i("ScribbleItemBuilder", 2, "disProgress.");
    paramHolder.b.setVisibility(8);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    if (!(paramChatMessage instanceof MessageForScribble)) {
      return;
    }
    if ((paramViewHolder instanceof ScribbleItemBuilder.Holder))
    {
      paramContext = (ScribbleItemBuilder.Holder)paramViewHolder;
      paramInt1 = paramViewHolder.h.getPaddingLeft();
      paramInt2 = paramViewHolder.h.getPaddingRight();
      int i = paramViewHolder.h.getPaddingTop();
      int j = paramViewHolder.h.getPaddingBottom();
      paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramContext.b.getLayoutParams();
      boolean bool = paramChatMessage.isSend();
      float f = 4.0F;
      if (bool)
      {
        paramContext.c.setBackgroundResource(2130852132);
        paramBaseChatItemLayout.topMargin = AIOUtils.b(9.0F, this.e.getResources());
        paramBaseChatItemLayout.leftMargin = AIOUtils.b(10.0F, this.e.getResources());
        if (QQTheme.isNowSimpleUI()) {
          f = 7.0F;
        }
        paramBaseChatItemLayout.rightMargin = AIOUtils.b(f, this.e.getResources());
        paramBaseChatItemLayout.bottomMargin = AIOUtils.b(8.0F, this.e.getResources());
      }
      else
      {
        paramContext.c.setBackgroundResource(2130851950);
        paramBaseChatItemLayout.topMargin = AIOUtils.b(8.0F, this.e.getResources());
        if (QQTheme.isNowSimpleUI()) {
          f = 8.0F;
        }
        paramBaseChatItemLayout.leftMargin = AIOUtils.b(f, this.e.getResources());
        paramBaseChatItemLayout.rightMargin = AIOUtils.b(10.0F, this.e.getResources());
        paramBaseChatItemLayout.bottomMargin = AIOUtils.b(8.0F, this.e.getResources());
      }
      paramContext.b.setLayoutParams(paramBaseChatItemLayout);
      paramContext.c.setPadding(paramInt1, i, paramInt2, j);
      paramContext.h.setPadding(0, 0, 0, 0);
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!paramChatMessage.isSendFromLocal()) {
      return false;
    }
    paramChatMessage = (MessageForScribble)paramChatMessage;
    int i = paramChatMessage.fileUploadStatus;
    if (i == 2)
    {
      QLog.d("ScribbleItemBuilder", 2, "isFailed 发送涂鸦数据发送失败");
      return true;
    }
    if (i == 3)
    {
      QLog.d("ScribbleItemBuilder", 2, "isFailed 发送涂鸦数据发送中");
      paramBaseChatItemLayout = (BaseTransProcessor)((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if (paramBaseChatItemLayout != null)
      {
        i = paramBaseChatItemLayout.getProgress();
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("isFailed 发送涂鸦数据进行中 progress 为：");
        paramChatMessage.append(i);
        QLog.d("ScribbleItemBuilder", 2, paramChatMessage.toString());
        return false;
      }
      paramBaseChatItemLayout = new StringBuilder();
      paramBaseChatItemLayout.append("isFailed::  status ==  MessageForScribble.TRANS_STAUS_UP_SENDING !STATUS_SEND_FAIL uniseq：");
      paramBaseChatItemLayout.append(paramChatMessage.uniseq);
      QLog.d("ScribbleItemBuilder", 2, paramBaseChatItemLayout.toString());
      return true;
    }
    return false;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView instanceof MessageForScribble))
    {
      MessageForScribble localMessageForScribble = (MessageForScribble)paramView;
      if ((localMessageForScribble != null) && (localMessageForScribble.fileUploadStatus == 1) && (!this.d.getMsgCache().f(paramView))) {
        a(localQQCustomMenu, this.e, 2131438943, paramView, new Bundle());
      }
    }
    if (paramView.istroop == 0) {
      a(localQQCustomMenu, this.e, 2131444634, paramView, null);
    }
    a(localQQCustomMenu, this.e, 2131431695, paramView, new Bundle());
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  public void b()
  {
    super.b();
    this.B.removeCallbacksAndMessages(null);
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    Object localObject = (ScribbleItemBuilder.Holder)AIOUtils.b(paramView);
    MessageForScribble localMessageForScribble = (MessageForScribble)((ScribbleItemBuilder.Holder)localObject).q;
    int i = a(localMessageForScribble, (ScribbleItemBuilder.Holder)localObject, ((ScribbleItemBuilder.Holder)localObject).h);
    if (localMessageForScribble.isSendFromLocal())
    {
      if (i == 2)
      {
        a(((ScribbleItemBuilder.Holder)localObject).h, localMessageForScribble);
        return;
      }
      if ((i == 1) || (i == 3)) {
        ((ScribbleItemBuilder.Holder)localObject).a.g();
      }
    }
    else
    {
      if (i == 5)
      {
        QLog.i("ScribbleItemBuilder", 2, "涂鸦数据重新下载");
        localObject = FileTransferManager.a(this.d);
        if (localObject != null) {
          ((FileTransferManager)localObject).a(paramView, this);
        }
        ((IScribbleDownloader)this.d.getRuntimeService(IScribbleDownloader.class)).DownloadFromAio(localMessageForScribble);
        return;
      }
      if ((i == 4) || (i == 6)) {
        ((ScribbleItemBuilder.Holder)localObject).a.g();
      }
    }
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(false);
  }
  
  public BaseBubbleBuilder.TouchDelegate d(View paramView)
  {
    return this;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131911060);
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    Object localObject = (ScribbleItemBuilder.Holder)AIOUtils.b(paramView);
    if (localObject == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "handleMessage(): holder is null");
      return;
    }
    paramView = (MessageForScribble)((ScribbleItemBuilder.Holder)localObject).q;
    if (((ScribbleItemBuilder.Holder)localObject).q == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "handleMessage(): holder.mMessage is null");
      return;
    }
    if (paramView.uniseq != paramFileMsg.uniseq) {
      return;
    }
    a(paramView, paramFileMsg);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage begin progress is: ");
    localStringBuilder.append(paramView.mRealProgress);
    localStringBuilder.append(" status is: ");
    localStringBuilder.append(paramFileMsg.status);
    localStringBuilder.append(" uinSeq: ");
    localStringBuilder.append(paramView.uniseq);
    QLog.e("ScribbleItemBuilder", 2, localStringBuilder.toString());
    paramInt1 = ((ScribbleItemBuilder.Holder)localObject).a.getDataState();
    if (paramView.isSendFromLocal()) {}
    switch (paramFileMsg.status)
    {
    default: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("涂鸦数据传输状态 isSendFromLocal ：");
      localStringBuilder.append(paramFileMsg.status);
      QLog.e("ScribbleItemBuilder", 2, localStringBuilder.toString());
      a((ScribbleItemBuilder.Holder)localObject, paramView, true, paramInt1);
      break;
    case 1005: 
      QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送错误");
      b((ScribbleItemBuilder.Holder)localObject, paramView, true, paramInt1);
      this.B.removeCallbacks(paramView.mUpdateProgressRunnable);
      a((ScribbleItemBuilder.Holder)localObject);
      break;
    case 1004: 
      QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送取消");
      b((ScribbleItemBuilder.Holder)localObject, paramView, true, paramInt1);
      c(paramView);
      a((ScribbleItemBuilder.Holder)localObject);
      break;
    case 1003: 
      QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送完毕");
      c((ScribbleItemBuilder.Holder)localObject, paramView, true, paramInt1);
      if (paramView.mRealProgress != 100)
      {
        paramView.mRealProgress = 100;
        paramView.mUiProgress = 100;
        c(paramView);
        a(paramView, (ScribbleItemBuilder.Holder)localObject, paramView.mUiProgress, true, this.e, this.B);
      }
      break;
    case 1001: 
      QLog.e("ScribbleItemBuilder", 2, "涂鸦数据开始发送");
      a((ScribbleItemBuilder.Holder)localObject, paramView, true, paramInt1);
      break;
      switch (paramFileMsg.status)
      {
      case 2004: 
      default: 
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("涂鸦数据传输状态 isNotSendFromLocal：");
        localStringBuilder.append(paramFileMsg.status);
        QLog.e("ScribbleItemBuilder", 2, localStringBuilder.toString());
        a((ScribbleItemBuilder.Holder)localObject, paramView, false);
        break;
      case 2005: 
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载失败");
        b((ScribbleItemBuilder.Holder)localObject, paramView, false);
        c(paramView);
        a((ScribbleItemBuilder.Holder)localObject);
        break;
      case 2003: 
        if (FileUtil.d(((IScribbleMsgUtils)QRoute.api(IScribbleMsgUtils.class)).getScribbleDataFilePath(paramView))) {
          d((ScribbleItemBuilder.Holder)localObject, paramView, false, 1);
        } else {
          b((ScribbleItemBuilder.Holder)localObject, paramView, false);
        }
        if (paramView.mRealProgress != 100)
        {
          paramView.mRealProgress = 100;
          paramView.mUiProgress = 100;
          c(paramView);
          a(paramView, (ScribbleItemBuilder.Holder)localObject, paramView.mUiProgress, true, this.e, this.B);
        }
        break;
      case 2001: 
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载开始");
        a((ScribbleItemBuilder.Holder)localObject, paramView, true);
      }
      break;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Scribble file transfer status = ");
    ((StringBuilder)localObject).append(paramFileMsg.status);
    ((StringBuilder)localObject).append(" issendFromLocal ");
    ((StringBuilder)localObject).append(paramView.isSendFromLocal());
    QLog.i("ScribbleItemBuilder", 2, ((StringBuilder)localObject).toString());
    QLog.i("ScribbleItemBuilder", 2, "handleMessage end");
  }
  
  public void onClick(View paramView)
  {
    if (!super.c())
    {
      if (((paramView instanceof BaseDoodleMsgView)) || ((paramView instanceof URLImageView)))
      {
        ScribbleItemBuilder.Holder localHolder = (ScribbleItemBuilder.Holder)AIOUtils.b(paramView);
        if (localHolder == null)
        {
          QLog.e("ScribbleItemBuilder", 2, "onclick(): holder is null");
          break label92;
        }
        if ((localHolder.a != null) && (localHolder.a.a(paramView)))
        {
          ((IDoodlePanelHelper)QRoute.api(IDoodlePanelHelper.class)).playLayout(localHolder.a, true);
          break label92;
        }
      }
      super.onClick(paramView);
    }
    label92:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder
 * JD-Core Version:    0.7.0.1
 */