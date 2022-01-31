package com.tencent.mobileqq.activity.aio.item;

import aanz;
import actj;
import acui;
import acuj;
import acvz;
import acwb;
import acxj;
import addd;
import ader;
import adxd;
import adyw;
import adyx;
import adyy;
import adyz;
import ajya;
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
import apvd;
import awgw;
import awgy;
import awzy;
import aypb;
import ayqo;
import ayvx;
import bbfj;
import bbmf;
import bbmh;
import bcpu;
import bfpc;
import bfpp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout;
import com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForScribble.FileExistInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class ScribbleItemBuilder
  extends adxd
  implements acui, acwb, addd
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adyw(this);
    if (c == 0)
    {
      jdField_f_of_type_Int = BaseChatItemLayout.j + paramContext.getResources().getDimensionPixelSize(2131296297);
      jdField_e_of_type_Int = BaseChatItemLayout.i + paramContext.getResources().getDimensionPixelSize(2131296298);
      d = BaseChatItemLayout.h + paramContext.getResources().getDimensionPixelSize(2131296299);
      c = BaseChatItemLayout.g + paramContext.getResources().getDimensionPixelSize(2131296300);
    }
  }
  
  private int a(MessageForScribble paramMessageForScribble, adyz paramadyz, View paramView)
  {
    if (paramMessageForScribble.isSendFromLocal())
    {
      boolean bool = paramMessageForScribble.mExistInfo.mLocalPathExist;
      if (!paramMessageForScribble.mExistInfo.mInit) {
        bool = apvd.a(paramMessageForScribble.localFildPath);
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
          paramadyz = (aypb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq);
          acvz localacvz = acvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localacvz != null) {
            localacvz.a(paramView, this);
          }
          if (paramadyz != null)
          {
            i = paramadyz.f();
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
      paramadyz = acvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramadyz != null) {
        paramadyz.a(paramView, this);
      }
      QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据开始下载");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForScribble);
      return 4;
    }
    if (awgy.a(paramMessageForScribble) == awgy.c)
    {
      QLog.i("ScribbleItemBuilder", 2, "MessageForScribble EXIST");
      return 6;
    }
    QLog.i("ScribbleItemBuilder", 2, "MessageForScribble NOT EXIST");
    if (paramMessageForScribble.fileDownloadStatus == 2) {
      return 5;
    }
    paramadyz = acvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramadyz != null) {
      paramadyz.a(paramView, this);
    }
    QLog.i("ScribbleItemBuilder", 2, "涂鸦数据开始下载");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForScribble);
    return 4;
  }
  
  private static bcpu a(Context paramContext, Handler paramHandler)
  {
    bcpu localbcpu = new bcpu(paramContext);
    localbcpu.a(actj.a(50.0F, paramContext.getResources()));
    localbcpu.a(true);
    localbcpu.c(false);
    localbcpu.f(-1);
    localbcpu.e(0);
    localbcpu.d(-15550475);
    localbcpu.g(3);
    localbcpu.jdField_f_of_type_Boolean = true;
    localbcpu.jdField_f_of_type_Int = 2;
    localbcpu.a(new adyy(paramHandler));
    return localbcpu;
  }
  
  public static bcpu a(MessageForScribble paramMessageForScribble, Context paramContext, Handler paramHandler)
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
  
  private void a(adyz paramadyz, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramadyz == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      QLog.i("ScribbleItemBuilder", 2, "onRecvingState MessageForScribble NOT EXIST");
      ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble), paramadyz.b, paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
    } while (paramBoolean);
    paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void a(adyz paramadyz, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramadyz == null) || (paramMessageForScribble == null)) {}
    label143:
    label145:
    label148:
    for (;;)
    {
      return;
      ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble), paramadyz.b, paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        label61:
        if (paramBoolean) {
          break label143;
        }
        if (!ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(awgy.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break label61;
        }
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break label61;
        break;
      }
    }
  }
  
  private void a(View paramView, MessageForScribble paramMessageForScribble)
  {
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbfpc.a(2131689995, 5);
    localbfpc.c(2131690596);
    localbfpc.a(new adyx(this, paramView, paramMessageForScribble, localbfpc));
    localbfpc.show();
  }
  
  protected static void a(MessageForScribble paramMessageForScribble, adyz paramadyz, int paramInt, boolean paramBoolean, Context paramContext, Handler paramHandler)
  {
    paramadyz.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramadyz.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForScribble.frienduin + paramMessageForScribble.uniseq);
    paramContext = a(paramMessageForScribble, paramContext, paramHandler);
    paramContext.a();
    paramadyz.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramInt = ShortVideoUtils.a(paramInt, 10);
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
      paramContext.e(1426063360);
      paramContext.a(String.valueOf(paramInt) + "%");
      return;
      paramContext.c(paramInt);
    }
  }
  
  private static void a(MessageForScribble paramMessageForScribble, ayqo paramayqo)
  {
    if ((paramayqo != null) && (paramayqo.a > 0L))
    {
      paramMessageForScribble.mRealProgress = ((int)(paramayqo.e * 100L / paramayqo.a));
      paramMessageForScribble.mUiProgress = paramMessageForScribble.mRealProgress;
    }
  }
  
  private void b(adyz paramadyz, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramadyz == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble), paramadyz.b, paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
      paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    } while (paramBoolean);
    paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void b(adyz paramadyz, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramadyz == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble), paramadyz.b, paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (paramBoolean) {
          continue;
        }
        if (!ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(awgy.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  private static void b(MessageForScribble paramMessageForScribble)
  {
    int i = Math.max(paramMessageForScribble.mRealProgress, 68);
    if ((bbfj.d(BaseApplicationImpl.getContext())) && (paramMessageForScribble.mUiProgress < i)) {
      paramMessageForScribble.mUiProgress += 1;
    }
  }
  
  private void c(adyz paramadyz, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramadyz == null) || (paramMessageForScribble == null)) {}
    label171:
    label174:
    for (;;)
    {
      return;
      QLog.d("ScribbleItemBuilder", 2, "onSendOkState:" + paramBoolean);
      ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble), paramadyz.b, paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble))) {
          break label171;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(awgy.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label174;
        }
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
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
  
  private void d(adyz paramadyz, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramadyz == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble), paramadyz.b, paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!ader.a().a(ader.b(paramMessageForScribble), ader.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(awgy.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acui a(View paramView)
  {
    return this;
  }
  
  public acuj a()
  {
    return new adyz(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    paramView = paramViewGroup;
    if ((paramViewGroup instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramViewGroup;
      paramView = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    try
    {
      paramBaseChatItemLayout = (adyz)paramacuj;
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
    catch (Exception paramacuj)
    {
      for (;;)
      {
        QLog.e("ScribbleItemBuilder", 2, "scribbleitem holer Exception e= " + paramacuj);
        paramBaseChatItemLayout = null;
        continue;
        if (paramView == null)
        {
          paramacuj = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramacuj.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setId(2131362357);
          paramView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout = a(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setOperateListener(this, paramacxj, paramacxj, this);
          paramView.addView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
          paramacuj.addView(paramView);
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = paramView;
          paramacxj = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
          paramacuj.addView(paramacxj);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramacxj.getLayoutParams();
          localLayoutParams.addRule(8, 2131362357);
          localLayoutParams.addRule(5, 2131362357);
          localLayoutParams.addRule(6, 2131362357);
          localLayoutParams.addRule(7, 2131362357);
          paramacxj.setLayoutParams(localLayoutParams);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramacxj;
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
          int i = a(localMessageForScribble, paramBaseChatItemLayout, paramacuj);
          if (QLog.isColorLevel()) {
            QLog.i("ScribbleItemBuilder", 2, "ScribbleItemBuilder pos:" + paramBaseChatItemLayout.b + " State:" + i);
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          paramView = paramacuj;
          if (!jdField_e_of_type_Boolean) {
            break;
          }
          paramacuj.setContentDescription(a(paramChatMessage));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(a(paramChatMessage));
          paramView = paramacuj;
          if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout == null) {
            break;
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setTalkBack(a(paramChatMessage));
          return paramacuj;
          paramacxj = (MessageForScribble)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag();
          paramacuj = paramView;
          if (paramacxj == null) {
            break label330;
          }
          paramacuj = paramView;
          if (paramacxj.mUpdateProgressRunnable == null) {
            break label330;
          }
          this.b.removeCallbacks(paramacxj.mUpdateProgressRunnable);
          paramacxj.mUpdateProgressRunnable = null;
          paramacuj = paramView;
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
    return ajya.a(2131713597);
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
    case 2131364984: 
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(adyz paramadyz)
  {
    QLog.i("ScribbleItemBuilder", 2, "disProgress.");
    paramadyz.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (actj.a(paramView).isMultiMsg) {}
    Object localObject;
    int i;
    do
    {
      MessageForScribble localMessageForScribble;
      do
      {
        return;
        localObject = (adyz)actj.a(paramView);
        localMessageForScribble = (MessageForScribble)((adyz)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        i = a(localMessageForScribble, (adyz)localObject, ((adyz)localObject).jdField_a_of_type_AndroidViewView);
        if (!localMessageForScribble.isSendFromLocal()) {
          break;
        }
        if (i == 2)
        {
          a(((adyz)localObject).jdField_a_of_type_AndroidViewView, localMessageForScribble);
          return;
        }
      } while ((i != 1) && (i != 3));
      ((adyz)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
      return;
      if (i == 5)
      {
        QLog.i("ScribbleItemBuilder", 2, "涂鸦数据重新下载");
        localObject = acvz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject != null) {
          ((acvz)localObject).a(paramView, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForScribble);
        return;
      }
    } while ((i != 4) && (i != 6));
    ((adyz)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
  }
  
  public void a(View paramView, int paramInt)
  {
    adyz localadyz = (adyz)actj.a(paramView);
    if (localadyz == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder is null");
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)localadyz.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localadyz.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage is null");
      return;
    }
    QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage state is: " + paramInt);
    switch (a(localMessageForScribble, localadyz, paramView))
    {
    default: 
      return;
    case 1: 
      a(localadyz, localMessageForScribble, true, paramInt);
      return;
    case 2: 
      b(localadyz, localMessageForScribble, true, paramInt);
      return;
    case 3: 
      c(localadyz, localMessageForScribble, true, paramInt);
      return;
    case 4: 
      a(localadyz, localMessageForScribble, true);
      return;
    case 5: 
      b(localadyz, localMessageForScribble, true);
      return;
    }
    d(localadyz, localMessageForScribble, true, paramInt);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent) {}
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    paramView = (adyz)actj.a(paramView);
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
    } while (localMessageForScribble.uniseq != paramayqo.b);
    a(localMessageForScribble, paramayqo);
    QLog.e("ScribbleItemBuilder", 2, "handleMessage begin progress is: " + localMessageForScribble.mRealProgress + " status is: " + paramayqo.d + " uinSeq: " + localMessageForScribble.uniseq);
    paramInt1 = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
    if (localMessageForScribble.isSendFromLocal()) {
      switch (paramayqo.d)
      {
      default: 
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isSendFromLocal ：" + paramayqo.d);
        a(paramView, localMessageForScribble, true, paramInt1);
      }
    }
    for (;;)
    {
      QLog.i("ScribbleItemBuilder", 2, "Scribble file transfer status = " + paramayqo.d + " issendFromLocal " + localMessageForScribble.isSendFromLocal());
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
        switch (paramayqo.d)
        {
        case 2002: 
        case 2004: 
        default: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isNotSendFromLocal：" + paramayqo.d);
          a(paramView, localMessageForScribble, false);
          break;
        case 2001: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载开始");
          a(paramView, localMessageForScribble, true);
          break;
        case 2003: 
          if (apvd.a(awgy.b(localMessageForScribble))) {
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
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_f_of_type_Int, c, jdField_e_of_type_Int, d);
      return;
    }
    paramView.setPadding(jdField_e_of_type_Int, c, jdField_f_of_type_Int, d);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    paramView = actj.a(paramView);
    Drawable localDrawable;
    if ((paramView instanceof adyz))
    {
      paramView = (adyz)paramView;
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acuj paramacuj, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacuj, paramInt1, paramInt2);
    if (!(paramChatMessage instanceof MessageForScribble)) {}
    while (!(paramacuj instanceof adyz)) {
      return;
    }
    paramContext = (adyz)paramacuj;
    paramInt1 = paramacuj.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    paramInt2 = paramacuj.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int i = paramacuj.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int j = paramacuj.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    if (paramChatMessage.isSend())
    {
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848940);
      paramBaseChatItemLayout.topMargin = actj.a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    for (paramBaseChatItemLayout.bottomMargin = actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; paramBaseChatItemLayout.bottomMargin = actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramBaseChatItemLayout);
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt1, i, paramInt2, j);
      paramContext.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      return;
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848764);
      paramBaseChatItemLayout.topMargin = actj.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = actj.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = actj.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
      paramBaseChatItemLayout = (aypb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if (paramBaseChatItemLayout != null)
      {
        i = paramBaseChatItemLayout.f();
        QLog.d("ScribbleItemBuilder", 2, "isFailed 发送涂鸦数据进行中 progress 为：" + i);
        return false;
      }
      QLog.d("ScribbleItemBuilder", 2, "isFailed::  status ==  MessageForScribble.TRANS_STAUS_UP_SENDING !STATUS_SEND_FAIL uniseq：" + paramChatMessage.uniseq);
      return true;
    }
    return false;
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = actj.a(paramView);
    bbmf localbbmf = new bbmf();
    if ((paramView instanceof MessageForScribble))
    {
      MessageForScribble localMessageForScribble = (MessageForScribble)paramView;
      if ((localMessageForScribble != null) && (localMessageForScribble.fileUploadStatus == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
      }
    }
    if (paramView.istroop == 0) {
      a(paramView, localbbmf);
    }
    a(localbbmf, paramView);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
  
  public void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setProgressVisable(false);
  }
  
  public void onClick(View paramView)
  {
    if (super.a()) {
      return;
    }
    if (((paramView instanceof DoodleMsgView)) || ((paramView instanceof URLImageView)))
    {
      adyz localadyz = (adyz)actj.a(paramView);
      if (localadyz == null)
      {
        QLog.e("ScribbleItemBuilder", 2, "onclick(): holder is null");
        return;
      }
      if ((localadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout != null) && (localadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(paramView)))
      {
        ader.a().a(localadyz.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout, true);
        return;
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder
 * JD-Core Version:    0.7.0.1
 */