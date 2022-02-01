package com.tencent.mobileqq.activity.aio.item;

import admh;
import afqq;
import afqr;
import afsl;
import afsn;
import aftk;
import agcf;
import agdt;
import ahdy;
import ahfq;
import ahfr;
import ahfs;
import ahft;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anvx;
import bbxu;
import bbxw;
import bcrg;
import bhjq;
import bhjs;
import bisa;
import bkzi;
import bkzz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ScribbleItemBuilder
  extends ahdy
  implements afqq, afsn, agcf
{
  public static int c;
  protected static int d;
  public static int e;
  public static int f;
  protected View.OnClickListener a;
  private Handler b = new Handler();
  public long c;
  
  public ScribbleItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahfq(this);
    if (c == 0)
    {
      jdField_f_of_type_Int = BaseChatItemLayout.k + paramContext.getResources().getDimensionPixelSize(2131296394);
      jdField_e_of_type_Int = BaseChatItemLayout.j + paramContext.getResources().getDimensionPixelSize(2131296395);
      d = BaseChatItemLayout.i + paramContext.getResources().getDimensionPixelSize(2131296396);
      c = BaseChatItemLayout.h + paramContext.getResources().getDimensionPixelSize(2131296397);
    }
  }
  
  private int a(MessageForScribble paramMessageForScribble, ahft paramahft, View paramView)
  {
    if (paramMessageForScribble.isSendFromLocal())
    {
      boolean bool = paramMessageForScribble.mExistInfo.mLocalPathExist;
      if (!paramMessageForScribble.mExistInfo.mInit) {
        bool = FileUtil.isFileExists(paramMessageForScribble.localFildPath);
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
          paramahft = (BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq);
          afsl localafsl = afsl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localafsl != null) {
            localafsl.a(paramView, this);
          }
          if (paramahft != null)
          {
            i = paramahft.getProgress();
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
      paramahft = afsl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramahft != null) {
        paramahft.a(paramView, this);
      }
      QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据开始下载");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getScribbleDownloader().b(paramMessageForScribble);
      return 4;
    }
    if (bbxw.a(paramMessageForScribble) == bbxw.c)
    {
      QLog.i("ScribbleItemBuilder", 2, "MessageForScribble EXIST");
      return 6;
    }
    QLog.i("ScribbleItemBuilder", 2, "MessageForScribble NOT EXIST");
    if (paramMessageForScribble.fileDownloadStatus == 2) {
      return 5;
    }
    paramahft = afsl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramahft != null) {
      paramahft.a(paramView, this);
    }
    QLog.i("ScribbleItemBuilder", 2, "涂鸦数据开始下载");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getScribbleDownloader().b(paramMessageForScribble);
    return 4;
  }
  
  private static bisa a(Context paramContext, Handler paramHandler)
  {
    bisa localbisa = new bisa(paramContext);
    localbisa.a(AIOUtils.dp2px(50.0F, paramContext.getResources()));
    localbisa.a(true);
    localbisa.c(false);
    localbisa.g(-1);
    localbisa.f(0);
    localbisa.d(-15550475);
    localbisa.i(3);
    localbisa.jdField_f_of_type_Boolean = true;
    localbisa.jdField_f_of_type_Int = 2;
    localbisa.a(new ahfs(paramHandler));
    return localbisa;
  }
  
  public static bisa a(MessageForScribble paramMessageForScribble, Context paramContext, Handler paramHandler)
  {
    if (paramMessageForScribble.mProgressPie != null) {
      return paramMessageForScribble.mProgressPie;
    }
    paramContext = a(paramContext, paramHandler);
    paramMessageForScribble.mProgressPie = paramContext;
    return paramContext;
  }
  
  private DoodleMsgLayout a(Context paramContext)
  {
    return new DoodleMsgLayout(paramContext, null);
  }
  
  private void a(ahft paramahft, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramahft == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      QLog.i("ScribbleItemBuilder", 2, "onRecvingState MessageForScribble NOT EXIST");
      agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble), paramahft.b, paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
    } while (paramBoolean);
    paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void a(ahft paramahft, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramahft == null) || (paramMessageForScribble == null)) {}
    label143:
    label145:
    label148:
    for (;;)
    {
      return;
      agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble), paramahft.b, paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        label61:
        if (paramBoolean) {
          break label143;
        }
        if (!agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(bbxw.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break label61;
        }
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break label61;
        break;
      }
    }
  }
  
  private void a(View paramView, MessageForScribble paramMessageForScribble)
  {
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbkzi.a(2131689976, 5);
    localbkzi.c(2131690697);
    localbkzi.a(new ahfr(this, paramView, paramMessageForScribble, localbkzi));
    localbkzi.show();
  }
  
  protected static void a(MessageForScribble paramMessageForScribble, ahft paramahft, int paramInt, boolean paramBoolean, Context paramContext, Handler paramHandler)
  {
    paramahft.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramahft.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForScribble.frienduin + paramMessageForScribble.uniseq);
    paramContext = a(paramMessageForScribble, paramContext, paramHandler);
    paramContext.a();
    paramahft.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
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
  
  private void b(ahft paramahft, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramahft == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble), paramahft.b, paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
      paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    } while (paramBoolean);
    paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void b(ahft paramahft, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramahft == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble), paramahft.b, paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (paramBoolean) {
          continue;
        }
        if (!agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(bbxw.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  private static void b(MessageForScribble paramMessageForScribble)
  {
    int i = Math.max(paramMessageForScribble.mRealProgress, 68);
    if ((NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) && (paramMessageForScribble.mUiProgress < i)) {
      paramMessageForScribble.mUiProgress += 1;
    }
  }
  
  private void c(ahft paramahft, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramahft == null) || (paramMessageForScribble == null)) {}
    label171:
    label174:
    for (;;)
    {
      return;
      QLog.d("ScribbleItemBuilder", 2, "onSendOkState:" + paramBoolean);
      agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble), paramahft.b, paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble))) {
          break label171;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(bbxw.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label174;
        }
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
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
  
  private void d(ahft paramahft, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramahft == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble), paramahft.b, paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!agdt.a().a(agdt.b(paramMessageForScribble), agdt.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(bbxw.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqq a(View paramView)
  {
    return this;
  }
  
  public afqr a()
  {
    return new ahft(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    paramView = paramViewGroup;
    if ((paramViewGroup instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramViewGroup;
      paramView = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    try
    {
      paramBaseChatItemLayout = (ahft)paramafqr;
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
    catch (Exception paramafqr)
    {
      for (;;)
      {
        QLog.e("ScribbleItemBuilder", 2, "scribbleitem holer Exception e= " + paramafqr);
        paramBaseChatItemLayout = null;
        continue;
        if (paramView == null)
        {
          paramafqr = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramafqr.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setId(2131362495);
          paramView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout = a(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setOperateListener(this, paramaftk, paramaftk, this);
          paramView.addView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
          paramafqr.addView(paramView);
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = paramView;
          paramaftk = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
          paramafqr.addView(paramaftk);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramaftk.getLayoutParams();
          localLayoutParams.addRule(8, 2131362495);
          localLayoutParams.addRule(5, 2131362495);
          localLayoutParams.addRule(6, 2131362495);
          localLayoutParams.addRule(7, 2131362495);
          paramaftk.setLayoutParams(localLayoutParams);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramaftk;
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
          int i = a(localMessageForScribble, paramBaseChatItemLayout, paramafqr);
          if (QLog.isColorLevel()) {
            QLog.i("ScribbleItemBuilder", 2, "ScribbleItemBuilder pos:" + paramBaseChatItemLayout.b + " State:" + i);
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          paramView = paramafqr;
          if (!jdField_e_of_type_Boolean) {
            break;
          }
          paramafqr.setContentDescription(a(paramChatMessage));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(a(paramChatMessage));
          paramView = paramafqr;
          if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout == null) {
            break;
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setTalkBack(a(paramChatMessage));
          return paramafqr;
          paramaftk = (MessageForScribble)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag();
          paramafqr = paramView;
          if (paramaftk == null) {
            break label330;
          }
          paramafqr = paramView;
          if (paramaftk.mUpdateProgressRunnable == null) {
            break label330;
          }
          this.b.removeCallbacks(paramaftk.mUpdateProgressRunnable);
          paramaftk.mUpdateProgressRunnable = null;
          paramafqr = paramView;
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
  
  public String a(ChatMessage paramChatMessage)
  {
    return anvx.a(2131713048);
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
    case 2131365475: 
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(ahft paramahft)
  {
    QLog.i("ScribbleItemBuilder", 2, "disProgress.");
    paramahft.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (AIOUtils.getMessage(paramView).isMultiMsg) {}
    Object localObject;
    int i;
    do
    {
      MessageForScribble localMessageForScribble;
      do
      {
        return;
        localObject = (ahft)AIOUtils.getHolder(paramView);
        localMessageForScribble = (MessageForScribble)((ahft)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        i = a(localMessageForScribble, (ahft)localObject, ((ahft)localObject).jdField_a_of_type_AndroidViewView);
        if (!localMessageForScribble.isSendFromLocal()) {
          break;
        }
        if (i == 2)
        {
          a(((ahft)localObject).jdField_a_of_type_AndroidViewView, localMessageForScribble);
          return;
        }
      } while ((i != 1) && (i != 3));
      ((ahft)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
      return;
      if (i == 5)
      {
        QLog.i("ScribbleItemBuilder", 2, "涂鸦数据重新下载");
        localObject = afsl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject != null) {
          ((afsl)localObject).a(paramView, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getScribbleDownloader().b(localMessageForScribble);
        return;
      }
    } while ((i != 4) && (i != 6));
    ((ahft)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
  }
  
  public void a(View paramView, int paramInt)
  {
    ahft localahft = (ahft)AIOUtils.getHolder(paramView);
    if (localahft == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder is null");
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)localahft.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localahft.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage is null");
      return;
    }
    QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage state is: " + paramInt);
    switch (a(localMessageForScribble, localahft, paramView))
    {
    default: 
      return;
    case 1: 
      a(localahft, localMessageForScribble, true, paramInt);
      return;
    case 2: 
      b(localahft, localMessageForScribble, true, paramInt);
      return;
    case 3: 
      c(localahft, localMessageForScribble, true, paramInt);
      return;
    case 4: 
      a(localahft, localMessageForScribble, true);
      return;
    case 5: 
      b(localahft, localMessageForScribble, true);
      return;
    }
    d(localahft, localMessageForScribble, true, paramInt);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent) {}
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_f_of_type_Int, c, jdField_e_of_type_Int, d);
      return;
    }
    paramView.setPadding(jdField_e_of_type_Int, c, jdField_f_of_type_Int, d);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = (ahft)AIOUtils.getHolder(paramView);
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
          if (FileUtil.isFileExists(bbxw.b(localMessageForScribble))) {
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
    paramView = AIOUtils.getHolder(paramView);
    Drawable localDrawable;
    if ((paramView instanceof ahft))
    {
      paramView = (ahft)paramView;
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
    if (!(paramChatMessage instanceof MessageForScribble)) {}
    while (!(paramafqr instanceof ahft)) {
      return;
    }
    paramContext = (ahft)paramafqr;
    paramInt1 = paramafqr.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    paramInt2 = paramafqr.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int i = paramafqr.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int j = paramafqr.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    if (paramChatMessage.isSend())
    {
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850016);
      paramBaseChatItemLayout.topMargin = AIOUtils.dp2px(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    for (paramBaseChatItemLayout.bottomMargin = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; paramBaseChatItemLayout.bottomMargin = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramBaseChatItemLayout);
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt1, i, paramInt2, j);
      paramContext.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      return;
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849840);
      paramBaseChatItemLayout.topMargin = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = AIOUtils.dp2px(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
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
      paramBaseChatItemLayout = (BaseTransProcessor)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramChatMessage.frienduin, paramChatMessage.uniseq);
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
  
  public bhjs[] a(View paramView)
  {
    paramView = AIOUtils.getMessage(paramView);
    bhjq localbhjq = new bhjq();
    if ((paramView instanceof MessageForScribble))
    {
      MessageForScribble localMessageForScribble = (MessageForScribble)paramView;
      if ((localMessageForScribble != null) && (localMessageForScribble.fileUploadStatus == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
      }
    }
    if (paramView.istroop == 0) {
      a(paramView, localbhjq);
    }
    a(localbhjq, paramView);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
  
  public void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(false);
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
        ahft localahft = (ahft)AIOUtils.getHolder(paramView);
        if (localahft == null)
        {
          QLog.e("ScribbleItemBuilder", 2, "onclick(): holder is null");
          continue;
        }
        if ((localahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout != null) && (localahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(paramView)))
        {
          agdt.a().a(localahft.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout, true);
          continue;
        }
      }
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder
 * JD-Core Version:    0.7.0.1
 */