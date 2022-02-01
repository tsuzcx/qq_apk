package com.tencent.mobileqq.activity.aio.item;

import aean;
import agej;
import aggk;
import aggl;
import agid;
import agif;
import agjk;
import agph;
import agqv;
import ahov;
import ahqn;
import ahqo;
import ahqp;
import ahqq;
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
import anzj;
import auog;
import bbxk;
import bbxm;
import bcrg;
import berp;
import bete;
import beyb;
import bhnv;
import bhuk;
import bhum;
import bjbh;
import blir;
import blji;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ScribbleItemBuilder
  extends ahov
  implements aggk, agif, agph
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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahqn(this);
    if (c == 0)
    {
      jdField_f_of_type_Int = BaseChatItemLayout.k + paramContext.getResources().getDimensionPixelSize(2131296341);
      jdField_e_of_type_Int = BaseChatItemLayout.j + paramContext.getResources().getDimensionPixelSize(2131296342);
      d = BaseChatItemLayout.i + paramContext.getResources().getDimensionPixelSize(2131296343);
      c = BaseChatItemLayout.h + paramContext.getResources().getDimensionPixelSize(2131296344);
    }
  }
  
  private int a(MessageForScribble paramMessageForScribble, ahqq paramahqq, View paramView)
  {
    if (paramMessageForScribble.isSendFromLocal())
    {
      boolean bool = paramMessageForScribble.mExistInfo.mLocalPathExist;
      if (!paramMessageForScribble.mExistInfo.mInit) {
        bool = auog.a(paramMessageForScribble.localFildPath);
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
          paramahqq = (berp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForScribble.frienduin, paramMessageForScribble.uniseq);
          agid localagid = agid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (localagid != null) {
            localagid.a(paramView, this);
          }
          if (paramahqq != null)
          {
            i = paramahqq.f();
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
      paramahqq = agid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramahqq != null) {
        paramahqq.a(paramView, this);
      }
      QLog.d("ScribbleItemBuilder", 2, "发送涂鸦数据开始下载");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForScribble);
      return 4;
    }
    if (bbxm.a(paramMessageForScribble) == bbxm.c)
    {
      QLog.i("ScribbleItemBuilder", 2, "MessageForScribble EXIST");
      return 6;
    }
    QLog.i("ScribbleItemBuilder", 2, "MessageForScribble NOT EXIST");
    if (paramMessageForScribble.fileDownloadStatus == 2) {
      return 5;
    }
    paramahqq = agid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramahqq != null) {
      paramahqq.a(paramView, this);
    }
    QLog.i("ScribbleItemBuilder", 2, "涂鸦数据开始下载");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForScribble);
    return 4;
  }
  
  private static bjbh a(Context paramContext, Handler paramHandler)
  {
    bjbh localbjbh = new bjbh(paramContext);
    localbjbh.a(agej.a(50.0F, paramContext.getResources()));
    localbjbh.a(true);
    localbjbh.c(false);
    localbjbh.g(-1);
    localbjbh.f(0);
    localbjbh.d(-15550475);
    localbjbh.i(3);
    localbjbh.jdField_f_of_type_Boolean = true;
    localbjbh.jdField_f_of_type_Int = 2;
    localbjbh.a(new ahqp(paramHandler));
    return localbjbh;
  }
  
  public static bjbh a(MessageForScribble paramMessageForScribble, Context paramContext, Handler paramHandler)
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
  
  private void a(ahqq paramahqq, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramahqq == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      QLog.i("ScribbleItemBuilder", 2, "onRecvingState MessageForScribble NOT EXIST");
      agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble), paramahqq.b, paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
    } while (paramBoolean);
    paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void a(ahqq paramahqq, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramahqq == null) || (paramMessageForScribble == null)) {}
    label143:
    label145:
    label148:
    for (;;)
    {
      return;
      agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble), paramahqq.b, paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        label61:
        if (paramBoolean) {
          break label143;
        }
        if (!agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(bbxm.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break label61;
        }
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break label61;
        break;
      }
    }
  }
  
  private void a(View paramView, MessageForScribble paramMessageForScribble)
  {
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
    localblir.a(2131689933, 5);
    localblir.c(2131690580);
    localblir.a(new ahqo(this, paramView, paramMessageForScribble, localblir));
    localblir.show();
  }
  
  protected static void a(MessageForScribble paramMessageForScribble, ahqq paramahqq, int paramInt, boolean paramBoolean, Context paramContext, Handler paramHandler)
  {
    paramahqq.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramahqq.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForScribble.frienduin + paramMessageForScribble.uniseq);
    paramContext = a(paramMessageForScribble, paramContext, paramHandler);
    paramContext.a();
    paramahqq.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
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
      paramContext.f(1426063360);
      paramContext.a(String.valueOf(paramInt) + "%");
      return;
      paramContext.c(paramInt);
    }
  }
  
  private static void a(MessageForScribble paramMessageForScribble, bete parambete)
  {
    if ((parambete != null) && (parambete.a > 0L))
    {
      paramMessageForScribble.mRealProgress = ((int)(parambete.e * 100L / parambete.a));
      paramMessageForScribble.mUiProgress = paramMessageForScribble.mRealProgress;
    }
  }
  
  private void b(ahqq paramahqq, MessageForScribble paramMessageForScribble, boolean paramBoolean)
  {
    if ((paramahqq == null) || (paramMessageForScribble == null)) {}
    do
    {
      return;
      agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble), paramahqq.b, paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
      paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
    } while (paramBoolean);
    paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(null, 0, false);
  }
  
  private void b(ahqq paramahqq, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramahqq == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble), paramahqq.b, paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
        if (paramBoolean) {
          continue;
        }
        if (!agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(bbxm.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  private static void b(MessageForScribble paramMessageForScribble)
  {
    int i = Math.max(paramMessageForScribble.mRealProgress, 68);
    if ((bhnv.d(BaseApplicationImpl.getContext())) && (paramMessageForScribble.mUiProgress < i)) {
      paramMessageForScribble.mUiProgress += 1;
    }
  }
  
  private void c(ahqq paramahqq, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramahqq == null) || (paramMessageForScribble == null)) {}
    label171:
    label174:
    for (;;)
    {
      return;
      QLog.d("ScribbleItemBuilder", 2, "onSendOkState:" + paramBoolean);
      agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble), paramahqq.b, paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble))) {
          break label171;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(bbxm.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label174;
        }
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
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
  
  private void d(ahqq paramahqq, MessageForScribble paramMessageForScribble, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if ((paramahqq == null) || (paramMessageForScribble == null)) {}
    label145:
    label148:
    for (;;)
    {
      return;
      agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble), paramahqq.b, paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
      if ((paramInt == 0) || (paramInt == -1))
      {
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
        if (paramBoolean) {
          continue;
        }
        if (!agqv.a().a(agqv.b(paramMessageForScribble), agqv.a(paramMessageForScribble))) {
          break label145;
        }
      }
      for (paramBoolean = bool;; paramBoolean = true)
      {
        if ((paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(bbxm.b(paramMessageForScribble), paramMessageForScribble.gifId, paramBoolean)) || (paramInt != 1)) {
          break label148;
        }
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.b();
        return;
        if (paramInt == 1)
        {
          paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
          break;
        }
        paramahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(false);
        break;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggk a(View paramView)
  {
    return this;
  }
  
  public aggl a()
  {
    return new ahqq(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramViewGroup = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    paramView = paramViewGroup;
    if ((paramViewGroup instanceof BaseChatItemLayout))
    {
      paramView = (BaseChatItemLayout)paramViewGroup;
      paramView = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    try
    {
      paramBaseChatItemLayout = (ahqq)paramaggl;
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
    catch (Exception paramaggl)
    {
      for (;;)
      {
        QLog.e("ScribbleItemBuilder", 2, "scribbleitem holer Exception e= " + paramaggl);
        paramBaseChatItemLayout = null;
        continue;
        if (paramView == null)
        {
          paramaggl = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramaggl.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          paramView = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
          paramView.setId(2131362478);
          paramView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout = a(this.jdField_a_of_type_AndroidContentContext);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setOperateListener(this, paramagjk, paramagjk, this);
          paramView.addView(paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout);
          paramaggl.addView(paramView);
          paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetRelativeLayout = paramView;
          paramagjk = new MessageProgressView(this.jdField_a_of_type_AndroidContentContext);
          paramaggl.addView(paramagjk);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramagjk.getLayoutParams();
          localLayoutParams.addRule(8, 2131362478);
          localLayoutParams.addRule(5, 2131362478);
          localLayoutParams.addRule(6, 2131362478);
          localLayoutParams.addRule(7, 2131362478);
          paramagjk.setLayoutParams(localLayoutParams);
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = paramagjk;
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
          int i = a(localMessageForScribble, paramBaseChatItemLayout, paramaggl);
          if (QLog.isColorLevel()) {
            QLog.i("ScribbleItemBuilder", 2, "ScribbleItemBuilder pos:" + paramBaseChatItemLayout.b + " State:" + i);
          }
          switch (i)
          {
          }
        }
        for (;;)
        {
          paramView = paramaggl;
          if (!jdField_e_of_type_Boolean) {
            break;
          }
          paramaggl.setContentDescription(a(paramChatMessage));
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setContentDescription(a(paramChatMessage));
          paramView = paramaggl;
          if (paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout == null) {
            break;
          }
          paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.setTalkBack(a(paramChatMessage));
          return paramaggl;
          paramagjk = (MessageForScribble)paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getTag();
          paramaggl = paramView;
          if (paramagjk == null) {
            break label330;
          }
          paramaggl = paramView;
          if (paramagjk.mUpdateProgressRunnable == null) {
            break label330;
          }
          this.b.removeCallbacks(paramagjk.mUpdateProgressRunnable);
          paramagjk.mUpdateProgressRunnable = null;
          paramaggl = paramView;
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
    return anzj.a(2131712469);
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
    case 2131365352: 
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramChatMessage);
  }
  
  protected void a(ahqq paramahqq)
  {
    QLog.i("ScribbleItemBuilder", 2, "disProgress.");
    paramahqq.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (agej.a(paramView).isMultiMsg) {}
    Object localObject;
    int i;
    do
    {
      MessageForScribble localMessageForScribble;
      do
      {
        return;
        localObject = (ahqq)agej.a(paramView);
        localMessageForScribble = (MessageForScribble)((ahqq)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        i = a(localMessageForScribble, (ahqq)localObject, ((ahqq)localObject).jdField_a_of_type_AndroidViewView);
        if (!localMessageForScribble.isSendFromLocal()) {
          break;
        }
        if (i == 2)
        {
          a(((ahqq)localObject).jdField_a_of_type_AndroidViewView, localMessageForScribble);
          return;
        }
      } while ((i != 1) && (i != 3));
      ((ahqq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
      return;
      if (i == 5)
      {
        QLog.i("ScribbleItemBuilder", 2, "涂鸦数据重新下载");
        localObject = agid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject != null) {
          ((agid)localObject).a(paramView, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForScribble);
        return;
      }
    } while ((i != 4) && (i != 6));
    ((ahqq)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.e();
  }
  
  public void a(View paramView, int paramInt)
  {
    ahqq localahqq = (ahqq)agej.a(paramView);
    if (localahqq == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder is null");
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)localahqq.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localahqq.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)
    {
      QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage is null");
      return;
    }
    QLog.e("ScribbleItemBuilder", 2, "onResult: holder.mMessage state is: " + paramInt);
    switch (a(localMessageForScribble, localahqq, paramView))
    {
    default: 
      return;
    case 1: 
      a(localahqq, localMessageForScribble, true, paramInt);
      return;
    case 2: 
      b(localahqq, localMessageForScribble, true, paramInt);
      return;
    case 3: 
      c(localahqq, localMessageForScribble, true, paramInt);
      return;
    case 4: 
      a(localahqq, localMessageForScribble, true);
      return;
    case 5: 
      b(localahqq, localMessageForScribble, true);
      return;
    }
    d(localahqq, localMessageForScribble, true, paramInt);
  }
  
  public void a(View paramView, MotionEvent paramMotionEvent) {}
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    paramView = (ahqq)agej.a(paramView);
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
    } while (localMessageForScribble.uniseq != parambete.b);
    a(localMessageForScribble, parambete);
    QLog.e("ScribbleItemBuilder", 2, "handleMessage begin progress is: " + localMessageForScribble.mRealProgress + " status is: " + parambete.d + " uinSeq: " + localMessageForScribble.uniseq);
    paramInt1 = paramView.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a();
    if (localMessageForScribble.isSendFromLocal()) {
      switch (parambete.d)
      {
      default: 
        QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isSendFromLocal ：" + parambete.d);
        a(paramView, localMessageForScribble, true, paramInt1);
      }
    }
    for (;;)
    {
      QLog.i("ScribbleItemBuilder", 2, "Scribble file transfer status = " + parambete.d + " issendFromLocal " + localMessageForScribble.isSendFromLocal());
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
        switch (parambete.d)
        {
        case 2002: 
        case 2004: 
        default: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据传输状态 isNotSendFromLocal：" + parambete.d);
          a(paramView, localMessageForScribble, false);
          break;
        case 2001: 
          QLog.e("ScribbleItemBuilder", 2, "涂鸦数据下载开始");
          a(paramView, localMessageForScribble, true);
          break;
        case 2003: 
          if (auog.a(bbxm.b(localMessageForScribble))) {
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
    paramView = agej.a(paramView);
    Drawable localDrawable;
    if ((paramView instanceof ahqq))
    {
      paramView = (ahqq)paramView;
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
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aggl paramaggl, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaggl, paramInt1, paramInt2);
    if (!(paramChatMessage instanceof MessageForScribble)) {}
    while (!(paramaggl instanceof ahqq)) {
      return;
    }
    paramContext = (ahqq)paramaggl;
    paramInt1 = paramaggl.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    paramInt2 = paramaggl.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int i = paramaggl.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int j = paramaggl.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    paramBaseChatItemLayout = (RelativeLayout.LayoutParams)paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
    if (paramChatMessage.isSend())
    {
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130850006);
      paramBaseChatItemLayout.topMargin = agej.a(9.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = agej.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    for (paramBaseChatItemLayout.bottomMargin = agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; paramBaseChatItemLayout.bottomMargin = agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      paramContext.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramBaseChatItemLayout);
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(paramInt1, i, paramInt2, j);
      paramContext.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
      return;
      paramContext.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849830);
      paramBaseChatItemLayout.topMargin = agej.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.leftMargin = agej.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramBaseChatItemLayout.rightMargin = agej.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
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
      paramBaseChatItemLayout = (berp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
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
  
  public bhum[] a(View paramView)
  {
    paramView = agej.a(paramView);
    bhuk localbhuk = new bhuk();
    if ((paramView instanceof MessageForScribble))
    {
      MessageForScribble localMessageForScribble = (MessageForScribble)paramView;
      if ((localMessageForScribble != null) && (localMessageForScribble.fileUploadStatus == 1) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView))) {
        a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramView);
      }
    }
    if (paramView.istroop == 0) {
      a(paramView, localbhuk);
    }
    a(localbhuk, paramView);
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
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
        ahqq localahqq = (ahqq)agej.a(paramView);
        if (localahqq == null)
        {
          QLog.e("ScribbleItemBuilder", 2, "onclick(): holder is null");
          continue;
        }
        if ((localahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout != null) && (localahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout.a(paramView)))
        {
          agqv.a().a(localahqq.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout, true);
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