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
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.DoodleMsgLayoutListener;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView;
import com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.scribble.ScribbleDownloader;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  implements BaseBubbleBuilder.TouchDelegate, FileTransferManager.Callback, DoodleMsgLayout.DoodleMsgLayoutListener
{
  public static int c;
  protected static int d;
  public static int e;
  public static int f;
  protected View.OnClickListener a;
  private Handler b = new Handler();
  protected long c;
  
  static
  {
    jdField_c_of_type_Int = 0;
    d = 0;
    jdField_e_of_type_Int = 0;
    jdField_f_of_type_Int = 0;
  }
  
  public ScribbleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ScribbleItemBuilder.1(this);
    if (jdField_c_of_type_Int == 0)
    {
      jdField_f_of_type_Int = BaseChatItemLayout.k + paramContext.getResources().getDimensionPixelSize(2131296410);
      jdField_e_of_type_Int = BaseChatItemLayout.j + paramContext.getResources().getDimensionPixelSize(2131296411);
      d = BaseChatItemLayout.i + paramContext.getResources().getDimensionPixelSize(2131296412);
      jdField_c_of_type_Int = BaseChatItemLayout.h + paramContext.getResources().getDimensionPixelSize(2131296413);
    }
  }
  
  private int a(MessageForScribble paramMessageForScribble, ScribbleItemBuilder.Holder paramHolder, View paramView)
  {
    if (paramMessageForScribble.isSendFromLocal())
    {
      boolean bool = paramMessageForScribble.mExistInfo.mLocalPathExist;
      if (!paramMessageForScribble.mExistInfo.mInit) {
        bool = FileUtil.a(paramMessageForScribble.localFildPath);
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
          paramHolder = (BaseTransProcessor)((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq);
          FileTransferManager localFileTransferManager = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localFileTransferManager != null) {
            localFileTransferManager.a(paramView, this);
          }
          if (paramHolder != null)
          {
            i = paramHolder.getProgress();
            QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据进行中 progress 为：" + i);
            return 1;
          }
          QLog.d("ScribbleItemBuilder", 2, "status ==  MessageForScribble.TRANS_STAUS_UP_SENDING !STATUS_SEND_FAIL uniseq：" + paramMessageForScribble.uniseq);
          return 2;
        }
        QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据已发送完啦");
        return 3;
      }
      QLog.i("ScribbleItemBuilder", 2, "发送MessageForScribble NOT EXIST");
      paramHolder = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramHolder != null) {
        paramHolder.a(paramView, this);
      }
      QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据开始下载");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getScribbleDownloader().b(paramMessageForScribble);
      return 4;
    }
    if (ScribbleMsgUtils.a(paramMessageForScribble) == ScribbleMsgUtils.jdField_c_of_type_Int)
    {
      QLog.i("ScribbleItemBuilder", 2, "MessageForScribble EXIST");
      return 6;
    }
    QLog.i("ScribbleItemBuilder", 2, "MessageForScribble NOT EXIST");
    if (paramMessageForScribble.fileDownloadStatus == 2) {
      return 5;
    }
    paramHolder = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramHolder != null) {
      paramHolder.a(paramView, this);
    }
    QLog.i("ScribbleItemBuilder", 2, "涂鸦数据开始下载");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getScribbleDownloader().b(paramMessageForScribble);
    return 4;
  }
  
  private DoodleMsgLayout a(Context paramContext)
  {
    return new DoodleMsgLayout(paramContext, null);
  }
  
  private static ProgressPieDrawable a(Context paramContext, Handler paramHandler)
  {
    ProgressPieDrawable localProgressPieDrawable = new ProgressPieDrawable(paramContext);
    localProgressPieDrawable.a(AIOUtils.a(50.0F, paramContext.getResources()));
    localProgressPieDrawable.a(true);
    localProgressPieDrawable.c(false);
    localProgressPieDrawable.g(-1);
    localProgressPieDrawable.f(0);
    localProgressPieDrawable.d(-15550475);
    localProgressPieDrawable.i(3);
    localProgressPieDrawable.jdField_f_of_type_Boolean = true;
    localProgressPieDrawable.jdField_f_of_type_Int = 2;
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
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.addButton(2131690018, 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new ScribbleItemBuilder.2(this, paramView, paramMessageForScribble, localActionSheet));
    localActionSheet.show();
  }
  
  private void a(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramHolder == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      QLog.i("ScribbleItemBuilder", 2, "onRecvingState MessageForScribble NOT EXIST");
      PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble), paramHolder.b, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
    } while (paramBoolean);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void a(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramHolder == null) || (paramMessageForScribble == null)) {}
    label143:
    label145:
    label148:
    for (;;)
    {
      return;
      PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble), paramHolder.b, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        label61:
        if (paramBoolean) {
          break label143;
        }
        if (!PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(ScribbleMsgUtils.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break label61;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break label61;
        break;
      }
    }
  }
  
  protected static void a(MessageForScribble paramMessageForScribble, ScribbleItemBuilder.Holder paramHolder, int paramInt, boolean paramBoolean, Context paramContext, Handler paramHandler)
  {
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForScribble.frienduin + paramMessageForScribble.uniseq);
    paramContext = a(paramMessageForScribble, paramContext, paramHandler);
    paramContext.a();
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramInt = ShortVideoUtils.getDisplayProgress(paramInt, 10);
    if (paramBoolean) {
      paramContext.b(paramInt);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForScribble.uniseq + ", p:" + paramInt + ", current:" + paramContext.a());
      }
      paramContext.b(true);
      paramContext.d(false);
      paramContext.f(1426063360);
      paramContext.a(String.valueOf(paramInt) + "%");
      return;
      paramContext.c(paramInt);
    }
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
    if ((paramHolder == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble), paramHolder.b, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
      paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    } while (paramBoolean);
    paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void b(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramHolder == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble), paramHolder.b, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (paramBoolean) {
          continue;
        }
        if (!PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(ScribbleMsgUtils.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  private static void b(MessageForScribble paramMessageForScribble)
  {
    int i = Math.max(paramMessageForScribble.mRealProgress, 68);
    if ((NetworkUtil.d(BaseApplicationImpl.getContext())) && (paramMessageForScribble.mUiProgress < i)) {
      paramMessageForScribble.mUiProgress += 1;
    }
  }
  
  private void c(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramHolder == null) || (paramMessageForScribble == null)) {}
    label171:
    label174:
    for (;;)
    {
      return;
      QLog.d("ScribbleItemBuilder", 2, "onSendOkState:" + paramBoolean);
      PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble), paramHolder.b, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble))) {
          break label171;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(ScribbleMsgUtils.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label174;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  private void c(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble == null) {
      return;
    }
    this.b.removeCallbacks(paramMessageForScribble.mUpdateProgressRunnable);
    paramMessageForScribble.mUpdateProgressRunnable = null;
  }
  
  private void d(ScribbleItemBuilder.Holder paramHolder, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramHolder == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble), paramHolder.b, paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!PlayLastLogic.a().a(PlayLastLogic.b(paramMessageForScribble), PlayLastLogic.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(ScribbleMsgUtils.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    paramView = paramViewGroup;
    if ((paramViewGroup instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramViewGroup;
      paramView = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    try
    {
      paramBaseChatItemLayout = (ScribbleItemBuilder.Holder)paramViewHolder;
      if ((paramChatMessage instanceof MessageForScribble))
      {
        localMessageForScribble = (MessageForScribble)paramChatMessage;
        QLog.i("SCRIBBLEMSG", 2, "!!!ScribbleItemBuilder  uniseq:" + localMessageForScribble.uniseq);
        if (localMessageForScribble == null)
        {
          QLog.e("ScribbleItemBuilder", 2, "doodle msg type error!!");
          return paramView;
        }
      }
    }
    catch (Exception paramViewHolder)
    {
      for (;;)
      {
        QLog.e("ScribbleItemBuilder", 2, "scribbleitem holer Exception e= " + paramViewHolder);
        paramBaseChatItemLayout = null;
        continue;
        if (paramView == null)
        {
          paramViewHolder = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramViewHolder.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setId(2131362525);
          paramView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout = a(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setOperateListener(this, paramOnLongClickAndTouchListener, paramOnLongClickAndTouchListener, this);
          paramView.addView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
          paramViewHolder.addView(paramView);
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = paramView;
          paramOnLongClickAndTouchListener = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
          paramViewHolder.addView(paramOnLongClickAndTouchListener);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramOnLongClickAndTouchListener.getLayoutParams();
          localLayoutParams.addRule(8, 2131362525);
          localLayoutParams.addRule(5, 2131362525);
          localLayoutParams.addRule(6, 2131362525);
          localLayoutParams.addRule(7, 2131362525);
          paramOnLongClickAndTouchListener.setLayoutParams(localLayoutParams);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramOnLongClickAndTouchListener;
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
          paramView.setAddStatesFromChildren(true);
          label330:
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setTag(localMessageForScribble);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(paramChatMessage.isSend());
          if (localMessageForScribble.mUpdateProgressRunnable != null) {
            this.b.removeCallbacks(localMessageForScribble.mUpdateProgressRunnable);
          }
          localMessageForScribble.mUpdateProgressRunnable = new ScribbleItemBuilder.ProgressRunnable(localMessageForScribble, paramBaseChatItemLayout, this.b, this.jdField_a_of_type_AndroidContentContext);
          int i = a(localMessageForScribble, paramBaseChatItemLayout, paramViewHolder);
          if (QLog.isColorLevel()) {
            QLog.i("ScribbleItemBuilder", 2, "ScribbleItemBuilder pos:" + paramBaseChatItemLayout.b + " State:" + i);
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          paramView = paramViewHolder;
          if (!jdField_e_of_type_Boolean) {
            break;
          }
          paramViewHolder.setContentDescription(a(paramChatMessage));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(a(paramChatMessage));
          paramView = paramViewHolder;
          if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout == null) {
            break;
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setTalkBack(a(paramChatMessage));
          return paramViewHolder;
          paramOnLongClickAndTouchListener = (MessageForScribble)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag();
          paramViewHolder = paramView;
          if (paramOnLongClickAndTouchListener == null) {
            break label330;
          }
          paramViewHolder = paramView;
          if (paramOnLongClickAndTouchListener.mUpdateProgressRunnable == null) {
            break label330;
          }
          this.b.removeCallbacks(paramOnLongClickAndTouchListener.mUpdateProgressRunnable);
          paramOnLongClickAndTouchListener.mUpdateProgressRunnable = null;
          paramViewHolder = paramView;
          break label330;
          a(paramBaseChatItemLayout, localMessageForScribble, false, 1);
          this.b.post(localMessageForScribble.mUpdateProgressRunnable);
          continue;
          b(paramBaseChatItemLayout, localMessageForScribble, false, 1);
          a(paramBaseChatItemLayout);
          continue;
          c(paramBaseChatItemLayout, localMessageForScribble, false, 1);
          a(paramBaseChatItemLayout);
          continue;
          a(paramBaseChatItemLayout, localMessageForScribble, false);
          this.b.post(localMessageForScribble.mUpdateProgressRunnable);
          continue;
          b(paramBaseChatItemLayout, localMessageForScribble, false);
          a(paramBaseChatItemLayout);
          continue;
          d(paramBaseChatItemLayout, localMessageForScribble, false, 1);
          a(paramBaseChatItemLayout);
        }
        MessageForScribble localMessageForScribble = null;
      }
    }
  }
  
  public BaseBubbleBuilder.TouchDelegate a(View paramView)
  {
    return this;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ScribbleItemBuilder.Holder(this);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131713544);
  }
  
  public void a()
  {
    super.a();
    this.b.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.a(paramView).isMultiMsg) {}
    Object localObject;
    int i;
    do
    {
      MessageForScribble localMessageForScribble;
      do
      {
        return;
        localObject = (ScribbleItemBuilder.Holder)AIOUtils.a(paramView);
        localMessageForScribble = (MessageForScribble)((ScribbleItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        i = a(localMessageForScribble, (ScribbleItemBuilder.Holder)localObject, ((ScribbleItemBuilder.Holder)localObject).jdField_a_of_type_AndroidViewView);
        if (!localMessageForScribble.isSendFromLocal()) {
          break;
        }
        if (i == 2)
        {
          a(((ScribbleItemBuilder.Holder)localObject).jdField_a_of_type_AndroidViewView, localMessageForScribble);
          return;
        }
      } while ((i != 1) && (i != 3));
      ((ScribbleItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
      return;
      if (i == 5)
      {
        QLog.i("ScribbleItemBuilder", 2, "涂鸦数据重新下载");
        localObject = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject != null) {
          ((FileTransferManager)localObject).a(paramView, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getScribbleDownloader().b(localMessageForScribble);
        return;
      }
    } while ((i != 4) && (i != 6));
    ((ScribbleItemBuilder.Holder)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
  }
  
  public void a(View paramView, int paramInt)
  {
    ScribbleItemBuilder.Holder localHolder = (ScribbleItemBuilder.Holder)AIOUtils.a(paramView);
    if (localHolder == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder is null");
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage is null");
      return;
    }
    QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage state is: " + paramInt);
    switch (a(localMessageForScribble, localHolder, paramView))
    {
    default: 
      return;
    case 1: 
      a(localHolder, localMessageForScribble, true, paramInt);
      return;
    case 2: 
      b(localHolder, localMessageForScribble, true, paramInt);
      return;
    case 3: 
      c(localHolder, localMessageForScribble, true, paramInt);
      return;
    case 4: 
      a(localHolder, localMessageForScribble, true);
      return;
    case 5: 
      b(localHolder, localMessageForScribble, true);
      return;
    }
    d(localHolder, localMessageForScribble, true, paramInt);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent) {}
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_f_of_type_Int, jdField_c_of_type_Int, jdField_e_of_type_Int, d);
      return;
    }
    paramView.setPadding(jdField_e_of_type_Int, jdField_c_of_type_Int, jdField_f_of_type_Int, d);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ScribbleItemBuilder.Holder)AIOUtils.a(paramView);
    if (paramView == null) {
      QLog.e("ScribbleItemBuilder", 2, "handleMessage(): holder is null");
    }
    MessageForScribble localMessageForScribble;
    do
    {
      return;
      localMessageForScribble = (MessageForScribble)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
      {
        QLog.e("ScribbleItemBuilder", 2, "handleMessage(): holder.mMessage is null");
        return;
      }
    } while (localMessageForScribble.uniseq != paramFileMsg.uniseq);
    a(localMessageForScribble, paramFileMsg);
    QLog.e("ScribbleItemBuilder", 2, "handleMessage begin progress is: " + localMessageForScribble.mRealProgress + " status is: " + paramFileMsg.status + " uinSeq: " + localMessageForScribble.uniseq);
    paramInt1 = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
    if (localMessageForScribble.isSendFromLocal()) {
      switch (paramFileMsg.status)
      {
      default: 
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isSendFromLocal ：" + paramFileMsg.status);
        a(paramView, localMessageForScribble, true, paramInt1);
      }
    }
    for (;;)
    {
      QLog.i("ScribbleItemBuilder", 2, "Scribble file transfer status = " + paramFileMsg.status + " issendFromLocal " + localMessageForScribble.isSendFromLocal());
      QLog.i("ScribbleItemBuilder", 2, "handleMessage end");
      return;
      QLog.e("ScribbleItemBuilder", 2, "涂鸦数据开始发送");
      a(paramView, localMessageForScribble, true, paramInt1);
      continue;
      QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送完毕");
      c(paramView, localMessageForScribble, true, paramInt1);
      if (localMessageForScribble.mRealProgress != 100)
      {
        localMessageForScribble.mRealProgress = 100;
        localMessageForScribble.mUiProgress = 100;
        c(localMessageForScribble);
        a(localMessageForScribble, paramView, localMessageForScribble.mUiProgress, true, this.jdField_a_of_type_AndroidContentContext, this.b);
        continue;
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送错误");
        b(paramView, localMessageForScribble, true, paramInt1);
        this.b.removeCallbacks(localMessageForScribble.mUpdateProgressRunnable);
        a(paramView);
        continue;
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据发送取消");
        b(paramView, localMessageForScribble, true, paramInt1);
        c(localMessageForScribble);
        a(paramView);
        continue;
        switch (paramFileMsg.status)
        {
        case 2002: 
        case 2004: 
        default: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isNotSendFromLocal：" + paramFileMsg.status);
          a(paramView, localMessageForScribble, false);
          break;
        case 2001: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载开始");
          a(paramView, localMessageForScribble, true);
          break;
        case 2003: 
          if (FileUtil.a(ScribbleMsgUtils.b(localMessageForScribble))) {
            d(paramView, localMessageForScribble, false, 1);
          }
          while (localMessageForScribble.mRealProgress != 100)
          {
            localMessageForScribble.mRealProgress = 100;
            localMessageForScribble.mUiProgress = 100;
            c(localMessageForScribble);
            a(localMessageForScribble, paramView, localMessageForScribble.mUiProgress, true, this.jdField_a_of_type_AndroidContentContext, this.b);
            break;
            b(paramView, localMessageForScribble, false);
          }
        case 2005: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载失败");
          b(paramView, localMessageForScribble, false);
          c(localMessageForScribble);
          a(paramView);
        }
      }
    }
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = AIOUtils.a(paramView);
    Drawable localDrawable;
    if ((paramView instanceof ScribbleItemBuilder.Holder))
    {
      paramView = (ScribbleItemBuilder.Holder)paramView;
      if ((paramView != null) && (paramView.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
      {
        localDrawable = paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.getBackground();
        if (localDrawable != null) {
          if (!paramBoolean) {
            break label56;
          }
        }
      }
    }
    label56:
    for (paramView = null;; paramView = jdField_a_of_type_AndroidGraphicsColorFilter)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  protected void a(ScribbleItemBuilder.Holder paramHolder)
  {
    QLog.i("ScribbleItemBuilder", 2, "disProgress.");
    paramHolder.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    if (!(paramChatMessage instanceof MessageForScribble)) {}
    while (!(paramViewHolder instanceof ScribbleItemBuilder.Holder)) {
      return;
    }
    paramContext = (ScribbleItemBuilder.Holder)paramViewHolder;
    paramInt1 = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    paramInt2 = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int i = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int j = paramViewHolder.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    if (paramChatMessage.isSend())
    {
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850414);
      paramBaseChatItemLayout.topMargin = AIOUtils.a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    for (paramBaseChatItemLayout.bottomMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; paramBaseChatItemLayout.bottomMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramBaseChatItemLayout);
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt1, i, paramInt2, j);
      paramContext.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      return;
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850238);
      paramBaseChatItemLayout.topMargin = AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(false);
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
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
      paramBaseChatItemLayout = (BaseTransProcessor)((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if (paramBaseChatItemLayout != null)
      {
        i = paramBaseChatItemLayout.getProgress();
        QLog.d("ScribbleItemBuilder", 2, "isFailed 发送涂鸦数据进行中 progress 为：" + i);
        return false;
      }
      QLog.d("ScribbleItemBuilder", 2, "isFailed::  status ==  MessageForScribble.TRANS_STAUS_UP_SENDING !STATUS_SEND_FAIL uniseq：" + paramChatMessage.uniseq);
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
      if ((localMessageForScribble != null) && (localMessageForScribble.fileUploadStatus == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramView, new Bundle());
      }
    }
    if (paramView.istroop == 0) {
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131376927, paramView, null);
    }
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramView, new Bundle());
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
  
  public void onClick(View paramView)
  {
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (((paramView instanceof DoodleMsgView)) || ((paramView instanceof URLImageView)))
      {
        ScribbleItemBuilder.Holder localHolder = (ScribbleItemBuilder.Holder)AIOUtils.a(paramView);
        if (localHolder == null)
        {
          QLog.e("ScribbleItemBuilder", 2, "onclick(): holder is null");
          continue;
        }
        if ((localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout != null) && (localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(paramView)))
        {
          PlayLastLogic.a().a(localHolder.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout, true);
          continue;
        }
      }
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder
 * JD-Core Version:    0.7.0.1
 */