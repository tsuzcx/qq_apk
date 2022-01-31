package com.tencent.mobileqq.activity.aio.item;

import acex;
import aekt;
import aels;
import aelt;
import aenj;
import aenl;
import aeov;
import aevf;
import aewt;
import aftq;
import afvk;
import afvl;
import afvm;
import afvn;
import alpo;
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
import arof;
import ayca;
import aycc;
import ayvc;
import bamw;
import baoj;
import batw;
import bdee;
import bdkz;
import bdlb;
import bepe;
import bhpy;
import bhql;
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
  extends aftq
  implements aels, aenl, aevf
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afvk(this);
    if (c == 0)
    {
      jdField_f_of_type_Int = BaseChatItemLayout.j + paramContext.getResources().getDimensionPixelSize(2131296303);
      jdField_e_of_type_Int = BaseChatItemLayout.i + paramContext.getResources().getDimensionPixelSize(2131296304);
      d = BaseChatItemLayout.h + paramContext.getResources().getDimensionPixelSize(2131296305);
      c = BaseChatItemLayout.g + paramContext.getResources().getDimensionPixelSize(2131296306);
    }
  }
  
  private int a(MessageForScribble paramMessageForScribble, afvn paramafvn, View paramView)
  {
    if (paramMessageForScribble.isSendFromLocal())
    {
      boolean bool = paramMessageForScribble.mExistInfo.mLocalPathExist;
      if (!paramMessageForScribble.mExistInfo.mInit) {
        bool = arof.a(paramMessageForScribble.localFildPath);
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
          paramafvn = (bamw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq);
          aenj localaenj = aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localaenj != null) {
            localaenj.a(paramView, this);
          }
          if (paramafvn != null)
          {
            i = paramafvn.f();
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
      paramafvn = aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramafvn != null) {
        paramafvn.a(paramView, this);
      }
      QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据开始下载");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForScribble);
      return 4;
    }
    if (aycc.a(paramMessageForScribble) == aycc.c)
    {
      QLog.i("ScribbleItemBuilder", 2, "MessageForScribble EXIST");
      return 6;
    }
    QLog.i("ScribbleItemBuilder", 2, "MessageForScribble NOT EXIST");
    if (paramMessageForScribble.fileDownloadStatus == 2) {
      return 5;
    }
    paramafvn = aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramafvn != null) {
      paramafvn.a(paramView, this);
    }
    QLog.i("ScribbleItemBuilder", 2, "涂鸦数据开始下载");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForScribble);
    return 4;
  }
  
  private static bepe a(Context paramContext, Handler paramHandler)
  {
    bepe localbepe = new bepe(paramContext);
    localbepe.a(aekt.a(50.0F, paramContext.getResources()));
    localbepe.a(true);
    localbepe.c(false);
    localbepe.f(-1);
    localbepe.e(0);
    localbepe.d(-15550475);
    localbepe.g(3);
    localbepe.jdField_f_of_type_Boolean = true;
    localbepe.jdField_f_of_type_Int = 2;
    localbepe.a(new afvm(paramHandler));
    return localbepe;
  }
  
  public static bepe a(MessageForScribble paramMessageForScribble, Context paramContext, Handler paramHandler)
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
  
  private void a(afvn paramafvn, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramafvn == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      QLog.i("ScribbleItemBuilder", 2, "onRecvingState MessageForScribble NOT EXIST");
      aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble), paramafvn.b, paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
    } while (paramBoolean);
    paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void a(afvn paramafvn, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramafvn == null) || (paramMessageForScribble == null)) {}
    label143:
    label145:
    label148:
    for (;;)
    {
      return;
      aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble), paramafvn.b, paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        label61:
        if (paramBoolean) {
          break label143;
        }
        if (!aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(aycc.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break label61;
        }
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break label61;
        break;
      }
    }
  }
  
  private void a(View paramView, MessageForScribble paramMessageForScribble)
  {
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
    localbhpy.a(2131690042, 5);
    localbhpy.c(2131690648);
    localbhpy.a(new afvl(this, paramView, paramMessageForScribble, localbhpy));
    localbhpy.show();
  }
  
  protected static void a(MessageForScribble paramMessageForScribble, afvn paramafvn, int paramInt, boolean paramBoolean, Context paramContext, Handler paramHandler)
  {
    paramafvn.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramafvn.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForScribble.frienduin + paramMessageForScribble.uniseq);
    paramContext = a(paramMessageForScribble, paramContext, paramHandler);
    paramContext.a();
    paramafvn.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
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
  
  private static void a(MessageForScribble paramMessageForScribble, baoj parambaoj)
  {
    if ((parambaoj != null) && (parambaoj.a > 0L))
    {
      paramMessageForScribble.mRealProgress = ((int)(parambaoj.e * 100L / parambaoj.a));
      paramMessageForScribble.mUiProgress = paramMessageForScribble.mRealProgress;
    }
  }
  
  private void b(afvn paramafvn, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramafvn == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble), paramafvn.b, paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
      paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    } while (paramBoolean);
    paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void b(afvn paramafvn, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramafvn == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble), paramafvn.b, paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (paramBoolean) {
          continue;
        }
        if (!aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(aycc.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  private static void b(MessageForScribble paramMessageForScribble)
  {
    int i = Math.max(paramMessageForScribble.mRealProgress, 68);
    if ((bdee.d(BaseApplicationImpl.getContext())) && (paramMessageForScribble.mUiProgress < i)) {
      paramMessageForScribble.mUiProgress += 1;
    }
  }
  
  private void c(afvn paramafvn, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramafvn == null) || (paramMessageForScribble == null)) {}
    label171:
    label174:
    for (;;)
    {
      return;
      QLog.d("ScribbleItemBuilder", 2, "onSendOkState:" + paramBoolean);
      aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble), paramafvn.b, paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble))) {
          break label171;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(aycc.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label174;
        }
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
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
  
  private void d(afvn paramafvn, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramafvn == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble), paramafvn.b, paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!aewt.a().a(aewt.b(paramMessageForScribble), aewt.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(aycc.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aels a(View paramView)
  {
    return this;
  }
  
  public aelt a()
  {
    return new afvn(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    paramView = paramViewGroup;
    if ((paramViewGroup instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramViewGroup;
      paramView = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    try
    {
      paramBaseChatItemLayout = (afvn)paramaelt;
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
    catch (Exception paramaelt)
    {
      for (;;)
      {
        QLog.e("ScribbleItemBuilder", 2, "scribbleitem holer Exception e= " + paramaelt);
        paramBaseChatItemLayout = null;
        continue;
        if (paramView == null)
        {
          paramaelt = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramaelt.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setId(2131362378);
          paramView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout = a(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setOperateListener(this, paramaeov, paramaeov, this);
          paramView.addView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
          paramaelt.addView(paramView);
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = paramView;
          paramaeov = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
          paramaelt.addView(paramaeov);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramaeov.getLayoutParams();
          localLayoutParams.addRule(8, 2131362378);
          localLayoutParams.addRule(5, 2131362378);
          localLayoutParams.addRule(6, 2131362378);
          localLayoutParams.addRule(7, 2131362378);
          paramaeov.setLayoutParams(localLayoutParams);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramaeov;
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
          int i = a(localMessageForScribble, paramBaseChatItemLayout, paramaelt);
          if (QLog.isColorLevel()) {
            QLog.i("ScribbleItemBuilder", 2, "ScribbleItemBuilder pos:" + paramBaseChatItemLayout.b + " State:" + i);
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          paramView = paramaelt;
          if (!jdField_e_of_type_Boolean) {
            break;
          }
          paramaelt.setContentDescription(a(paramChatMessage));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(a(paramChatMessage));
          paramView = paramaelt;
          if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout == null) {
            break;
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setTalkBack(a(paramChatMessage));
          return paramaelt;
          paramaeov = (MessageForScribble)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag();
          paramaelt = paramView;
          if (paramaeov == null) {
            break label330;
          }
          paramaelt = paramView;
          if (paramaeov.mUpdateProgressRunnable == null) {
            break label330;
          }
          this.b.removeCallbacks(paramaeov.mUpdateProgressRunnable);
          paramaeov.mUpdateProgressRunnable = null;
          paramaelt = paramView;
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
    return alpo.a(2131713969);
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
    case 2131365069: 
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(afvn paramafvn)
  {
    QLog.i("ScribbleItemBuilder", 2, "disProgress.");
    paramafvn.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aekt.a(paramView).isMultiMsg) {}
    Object localObject;
    int i;
    do
    {
      MessageForScribble localMessageForScribble;
      do
      {
        return;
        localObject = (afvn)aekt.a(paramView);
        localMessageForScribble = (MessageForScribble)((afvn)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        i = a(localMessageForScribble, (afvn)localObject, ((afvn)localObject).jdField_a_of_type_AndroidViewView);
        if (!localMessageForScribble.isSendFromLocal()) {
          break;
        }
        if (i == 2)
        {
          a(((afvn)localObject).jdField_a_of_type_AndroidViewView, localMessageForScribble);
          return;
        }
      } while ((i != 1) && (i != 3));
      ((afvn)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
      return;
      if (i == 5)
      {
        QLog.i("ScribbleItemBuilder", 2, "涂鸦数据重新下载");
        localObject = aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject != null) {
          ((aenj)localObject).a(paramView, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForScribble);
        return;
      }
    } while ((i != 4) && (i != 6));
    ((afvn)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
  }
  
  public void a(View paramView, int paramInt)
  {
    afvn localafvn = (afvn)aekt.a(paramView);
    if (localafvn == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder is null");
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)localafvn.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localafvn.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage is null");
      return;
    }
    QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage state is: " + paramInt);
    switch (a(localMessageForScribble, localafvn, paramView))
    {
    default: 
      return;
    case 1: 
      a(localafvn, localMessageForScribble, true, paramInt);
      return;
    case 2: 
      b(localafvn, localMessageForScribble, true, paramInt);
      return;
    case 3: 
      c(localafvn, localMessageForScribble, true, paramInt);
      return;
    case 4: 
      a(localafvn, localMessageForScribble, true);
      return;
    case 5: 
      b(localafvn, localMessageForScribble, true);
      return;
    }
    d(localafvn, localMessageForScribble, true, paramInt);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent) {}
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    paramView = (afvn)aekt.a(paramView);
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
    } while (localMessageForScribble.uniseq != parambaoj.b);
    a(localMessageForScribble, parambaoj);
    QLog.e("ScribbleItemBuilder", 2, "handleMessage begin progress is: " + localMessageForScribble.mRealProgress + " status is: " + parambaoj.d + " uinSeq: " + localMessageForScribble.uniseq);
    paramInt1 = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
    if (localMessageForScribble.isSendFromLocal()) {
      switch (parambaoj.d)
      {
      default: 
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isSendFromLocal ：" + parambaoj.d);
        a(paramView, localMessageForScribble, true, paramInt1);
      }
    }
    for (;;)
    {
      QLog.i("ScribbleItemBuilder", 2, "Scribble file transfer status = " + parambaoj.d + " issendFromLocal " + localMessageForScribble.isSendFromLocal());
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
        switch (parambaoj.d)
        {
        case 2002: 
        case 2004: 
        default: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isNotSendFromLocal：" + parambaoj.d);
          a(paramView, localMessageForScribble, false);
          break;
        case 2001: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载开始");
          a(paramView, localMessageForScribble, true);
          break;
        case 2003: 
          if (arof.a(aycc.b(localMessageForScribble))) {
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
    paramView = aekt.a(paramView);
    Drawable localDrawable;
    if ((paramView instanceof afvn))
    {
      paramView = (afvn)paramView;
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
    if (!(paramChatMessage instanceof MessageForScribble)) {}
    while (!(paramaelt instanceof afvn)) {
      return;
    }
    paramContext = (afvn)paramaelt;
    paramInt1 = paramaelt.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    paramInt2 = paramaelt.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int i = paramaelt.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int j = paramaelt.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    if (paramChatMessage.isSend())
    {
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849371);
      paramBaseChatItemLayout.topMargin = aekt.a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = aekt.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = aekt.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    for (paramBaseChatItemLayout.bottomMargin = aekt.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; paramBaseChatItemLayout.bottomMargin = aekt.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramBaseChatItemLayout);
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt1, i, paramInt2, j);
      paramContext.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      return;
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849195);
      paramBaseChatItemLayout.topMargin = aekt.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = aekt.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = aekt.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
      paramBaseChatItemLayout = (bamw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
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
  
  public bdlb[] a(View paramView)
  {
    paramView = aekt.a(paramView);
    bdkz localbdkz = new bdkz();
    if ((paramView instanceof MessageForScribble))
    {
      MessageForScribble localMessageForScribble = (MessageForScribble)paramView;
      if ((localMessageForScribble != null) && (localMessageForScribble.fileUploadStatus == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
      }
    }
    if (paramView.istroop == 0) {
      a(paramView, localbdkz);
    }
    a(localbdkz, paramView);
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
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
      afvn localafvn = (afvn)aekt.a(paramView);
      if (localafvn == null)
      {
        QLog.e("ScribbleItemBuilder", 2, "onclick(): holder is null");
        return;
      }
      if ((localafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout != null) && (localafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(paramView)))
      {
        aewt.a().a(localafvn.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout, true);
        return;
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ScribbleItemBuilder
 * JD-Core Version:    0.7.0.1
 */