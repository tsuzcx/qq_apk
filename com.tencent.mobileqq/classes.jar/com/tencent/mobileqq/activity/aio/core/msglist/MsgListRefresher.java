package com.tencent.mobileqq.activity.aio.core.msglist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.handler.Report;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor;
import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor.Config;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import mqq.os.MqqHandler;

public class MsgListRefresher
  implements Handler.Callback
{
  @NonNull
  protected final AIOContext a;
  long b = -1L;
  long c = -1L;
  boolean d = false;
  boolean e = true;
  private final QQAppInterface f;
  private final BaseSessionInfo g;
  private ListUI h;
  private boolean i;
  private int j = 131075;
  private long k = -1L;
  private int l = 0;
  private long m = 0L;
  
  public MsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.f = paramAIOContext.a();
    this.g = paramAIOContext.O();
  }
  
  private MessageRecord a(List<ChatMessage> paramList)
  {
    BaseSessionInfo localBaseSessionInfo = this.a.O();
    QQAppInterface localQQAppInterface = this.a.a();
    if ((1000 != localBaseSessionInfo.a) && (1004 != localBaseSessionInfo.a) && (1022 != localBaseSessionInfo.a)) {
      return ChatActivityUtils.a(paramList, localBaseSessionInfo, localQQAppInterface);
    }
    return ChatActivityUtils.b(paramList, localBaseSessionInfo, localQQAppInterface);
  }
  
  @Nullable
  private CharSequence a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    BaseSessionInfo localBaseSessionInfo = this.a.O();
    QQAppInterface localQQAppInterface = this.a.a();
    Object localObject;
    if ((1000 != localBaseSessionInfo.a) && (1004 != localBaseSessionInfo.a))
    {
      localObject = paramCharSequence;
      if (localBaseSessionInfo.a != 10008) {}
    }
    else
    {
      CharSequence localCharSequence = paramCharSequence;
      if (paramList.size() >= 15)
      {
        localCharSequence = paramCharSequence;
        if (!((ChatMessage)paramList.get(0)).mNeedGrayTips) {
          localCharSequence = null;
        }
      }
      localObject = localCharSequence;
      if (!paramList.isEmpty())
      {
        localObject = localCharSequence;
        if (((ChatMessage)paramList.get(0)).mMessageSource == null)
        {
          localObject = localCharSequence;
          if (((ChatMessage)paramList.get(0)).mNeedGrayTips)
          {
            localObject = localCharSequence;
            if (localCharSequence == null)
            {
              ((ChatMessage)paramList.get(0)).mNeedGrayTips = false;
              localObject = localCharSequence;
            }
          }
        }
      }
    }
    paramList = (List<ChatMessage>)localObject;
    if (1001 == localBaseSessionInfo.a)
    {
      paramList = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      if (!IFaceScoreUtils.sNeedInsertGrayMsgUins.contains(localBaseSessionInfo.b))
      {
        paramList = (List<ChatMessage>)localObject;
        if (!((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).getHasInsertMsgFlag(localQQAppInterface, localBaseSessionInfo.b)) {}
      }
      else
      {
        paramList = null;
      }
    }
    paramCharSequence = paramList;
    if (10002 == localBaseSessionInfo.a)
    {
      paramCharSequence = paramList;
      if (((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).getHasInsertMsgFlag(localQQAppInterface, localBaseSessionInfo.b)) {
        paramCharSequence = null;
      }
    }
    if (UinTypeUtil.e(localBaseSessionInfo.a) == 1032) {
      paramCharSequence = null;
    }
    if (10010 == localBaseSessionInfo.a) {
      paramCharSequence = null;
    }
    if (localBaseSessionInfo.a == 10008) {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  private List<ChatMessage> a(List<ChatMessage> paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshListAdapter refreshFlag: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.a.O();
    paramInt = this.j & 0xFFFF0000;
    if (paramInt != 65536)
    {
      if ((paramInt != 131072) && (paramInt != 196608) && (paramInt != 262144)) {
        return paramList;
      }
      paramList = this.a.e().c();
      Object localObject2 = this.a;
      paramList = paramList.a((AIOContext)localObject2, ((AIOContext)localObject2).m());
      localObject2 = a(paramList);
      if (localObject2 != null) {
        this.k = ((MessageRecord)localObject2).shmsgseq;
      }
      this.a.a(paramList, (MessageRecord)localObject2);
      localObject1 = a(paramList, ChatActivityUtils.a(this.a.a(), this.a.b(), (BaseSessionInfo)localObject1, (MessageRecord)localObject2, this.k));
      localObject2 = this.a.e().a().c().iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList = ((IReloadFilter)((Iterator)localObject2).next()).a(this.a, paramList);
      }
      this.a.a(paramList, (CharSequence)localObject1, this.j);
      this.a.o();
      ChatFragment.a(true);
      this.a.u();
      a(paramList, this.h);
      return paramList;
    }
    this.h.i();
    return paramList;
  }
  
  private void a(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    if (this.a.j())
    {
      this.a.e().e().a(paramChatMessage);
      paramMessageRecord = this.a.e().b();
      if ((this.g.a == 1008) && (((PAListUI)paramMessageRecord).a) && (paramMessageRecord.j() == paramMessageRecord.w() - 1))
      {
        this.a.g().postDelayed(new MsgListRefresher.3(this), 800L);
      }
      else
      {
        paramChatMessage.mMsgAnimFlag = true;
        a(196608);
      }
    }
    this.a.a(true);
  }
  
  private boolean b(Object paramObject, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -1004) && (!this.g.b.equals(paramMessageRecord.frienduin))) {
      return true;
    }
    if (a(paramMessageRecord)) {
      a((ChatMessage)paramObject, paramMessageRecord);
    } else {
      a(paramObject, paramMessageRecord);
    }
    this.a.y();
    if (((paramObject instanceof MessageForStructing)) || ((paramObject instanceof MessageForText))) {
      AIOUtils.a(this.f, this.a.O().a, this.a.e().b().d(), (ChatMessage)paramObject);
    }
    return false;
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    Object localObject = this.a.e().e();
    ((UnreadTask)localObject).c();
    ((UnreadTask)localObject).b(true);
    this.a.a(true);
    c(paramMessageRecord);
    localObject = this.a.e().a().e().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IMsgUpdateCallback)((Iterator)localObject).next()).e(this.a, (ChatMessage)paramMessageRecord);
    }
  }
  
  public long a()
  {
    return this.m;
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null, -1L);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.l = paramInt;
    this.m = paramLong;
  }
  
  public void a(int paramInt, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams, long paramLong)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh with dirty: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uniseq: ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" currentPauseRefreshFlag: ");
      ((StringBuilder)localObject).append(this.i);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.i) && (this.j == paramInt)) {
      return;
    }
    int i1 = 0xFFFF0000 & paramInt;
    paramInt = Math.max(paramInt & 0xFFFF, 0xFFFF & this.j);
    this.j = (i1 | paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh with refreshFlag: ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" scrollFlag: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = this.a.j();
    int n = 0;
    if ((!bool) && (this.a.k() != 6) && (this.a.k() != 5) && (this.a.k() != 35) && (!c())) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (paramInt != 0)
    {
      localObject = this.a.g();
      if (i1 == 262144)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgListRefresher", 2, "refresh post MSG_REFRESH_LIST_ITEM");
        }
        localMessage = new Message();
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramLong);
        localMessage.setData(localBundle);
        localMessage.what = 78;
        localMessage.obj = paramMsgSendCostParams;
        localMessage.arg1 = 0;
        paramInt = n;
        if (CommonFunctionPublishConfigProcessor.a().g) {
          paramInt = 400;
        }
        ((MqqHandler)localObject).sendMessageDelayed(localMessage, paramInt);
        return;
      }
      Message localMessage = new Message();
      localMessage.what = 12;
      if (paramMsgSendCostParams != null) {
        localMessage.obj = paramMsgSendCostParams;
      }
      if (i1 >= 196608)
      {
        if (!((MqqHandler)localObject).hasMessages(12))
        {
          paramLong = SystemClock.uptimeMillis();
          long l1 = this.b;
          if (paramLong - l1 > 1000L)
          {
            ((MqqHandler)localObject).sendMessage(localMessage);
            return;
          }
          ((MqqHandler)localObject).sendMessageDelayed(localMessage, 1000L - (paramLong - l1));
        }
      }
      else
      {
        paramMsgSendCostParams = (ChatPieSelectableHelper)this.a.a(4);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          this.a.b().runOnUiThread(new MsgListRefresher.1(this, paramMsgSendCostParams));
        } else if (!paramMsgSendCostParams.d()) {
          this.h.h();
        }
        ((MqqHandler)localObject).removeMessages(12);
        ((MqqHandler)localObject).sendMessage(localMessage);
      }
    }
  }
  
  public void a(ListUI paramListUI)
  {
    this.h = paramListUI;
    this.a.d().a(this);
  }
  
  public final void a(ChatMessage paramChatMessage, int paramInt)
  {
    this.h.a(paramChatMessage, paramInt);
  }
  
  public final void a(Object paramObject)
  {
    MessageRecord localMessageRecord = (MessageRecord)paramObject;
    if ((paramObject instanceof ChatMessage))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update mr.msgseq");
        ((StringBuilder)localObject).append(localMessageRecord.msgseq);
        ((StringBuilder)localObject).append(",time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        ((StringBuilder)localObject).append(" status:");
        ((StringBuilder)localObject).append(localMessageRecord.extraflag);
        QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
      }
      if (this.a.j()) {
        AioAnimationDetector.a().a(this.f, this.g, localMessageRecord, this.a.h());
      }
      Object localObject = this.a.e().a().e().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((IMsgUpdateCallback)((Iterator)localObject).next()).a(this.a, (ChatMessage)paramObject)) {
          return;
        }
      }
      if (!localMessageRecord.isSendFromLocal())
      {
        if (!b(paramObject, localMessageRecord)) {}
      }
      else {
        d(localMessageRecord);
      }
      FightMsgReporter.a(0, 0, localMessageRecord.istroop, 1);
      return;
    }
    if (((paramObject instanceof DataLineMsgRecord)) && (!localMessageRecord.isread) && (!localMessageRecord.isSendFromLocal())) {
      this.a.z().a(localMessageRecord, this.f.getMessageFacade().B());
    }
    ThreadManagerV2.excute(new MsgListRefresher.2(this), 32, null, true);
  }
  
  protected void a(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (this.a.j())
    {
      if (paramMessageRecord.isread) {
        return;
      }
      paramObject = this.f.getMessageFacade().B();
      this.a.z().a(paramMessageRecord, paramObject);
    }
  }
  
  protected void a(List<ChatMessage> paramList, ListUI paramListUI) {}
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = QLog.isColorLevel();
    int n = 2;
    StringBuilder localStringBuilder;
    if (bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("instantUpdate: ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(paramBoolean2);
      QLog.d("MsgListRefresher", 2, localStringBuilder.toString());
    }
    if (c())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("instantUpdate: blockRefreshJumpBottom TRUE ");
      localStringBuilder.append(false);
      localStringBuilder.append(" / ");
      localStringBuilder.append(false);
      QLog.d("MsgListRefresher", 1, localStringBuilder.toString());
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        n = 3;
      }
    }
    else {
      n = 0;
    }
    a(0x20000 | n);
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.g.b != null) && (this.g.b.equals(paramMessageRecord.frienduin)) && ((this.g.a == paramMessageRecord.istroop) || ((UinTypeUtil.b(this.g.a)) && (UinTypeUtil.b(paramMessageRecord.istroop))));
  }
  
  public int b()
  {
    return this.l;
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.frienduin.equals(this.g.b);
  }
  
  protected int c(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshlistadapter dirtyFlag=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = this.d;
    int i2 = 0;
    int i1 = 0;
    int n;
    if ((bool) && (this.e))
    {
      n = 9;
    }
    else if (paramInt == 0)
    {
      int i3;
      if (this.h.j() >= 0)
      {
        localObject = this.h;
        localObject = ((ListUI)localObject).a(((ListUI)localObject).k() - 1);
        n = paramInt;
        if (localObject != null)
        {
          n = paramInt;
          if (this.h.s() > 0)
          {
            n = paramInt;
            if (((View)localObject).getId() == 2131428029)
            {
              n = paramInt;
              if (!((ChatPieSelectableHelper)this.a.a(4)).d()) {
                n = 2;
              }
            }
          }
          i1 = ((View)localObject).getBottom();
        }
        int i4 = this.h.l();
        i3 = i4;
        i2 = i1;
        paramInt = n;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshlistadapter=====lastbuttom=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(" listHeight=");
          ((StringBuilder)localObject).append(i4);
          QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
          i3 = i4;
          i2 = i1;
          paramInt = n;
        }
      }
      else
      {
        i3 = 0;
      }
      localObject = (AIOLongShotHelper)this.a.a(15);
      n = paramInt;
      if (i2 <= i3)
      {
        n = paramInt;
        if (!((AIOLongShotHelper)localObject).c())
        {
          n = paramInt;
          if (paramInt == 0)
          {
            n = paramInt;
            if (!((ChatPieSelectableHelper)this.a.a(4)).d()) {
              n = 2;
            }
          }
        }
      }
    }
    else if (!this.a.o())
    {
      n = 0;
    }
    else if ((paramInt & 0x11) == 17)
    {
      n = 17;
    }
    else
    {
      n = paramInt;
      if ((paramInt & 0x10) == 16) {
        n = 16;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshlistadapter after set dirtyFlag=");
      ((StringBuilder)localObject).append(n);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    return n;
  }
  
  protected void c(MessageRecord paramMessageRecord)
  {
    if (b(paramMessageRecord))
    {
      Object localObject = this.a.e().a().e().iterator();
      boolean bool1 = false;
      while (((Iterator)localObject).hasNext()) {
        bool1 |= ((IMsgUpdateCallback)((Iterator)localObject).next()).d(this.a, (ChatMessage)paramMessageRecord);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("update need instantUpdate, msg= ");
        ((StringBuilder)localObject).append(paramMessageRecord.toString());
        QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
      }
      boolean bool3 = true;
      boolean bool2;
      if (!bool1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (bool1) {
        bool3 = false;
      }
      a(bool2, bool3);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean c()
  {
    boolean bool1;
    if (SystemClock.uptimeMillis() - this.c <= 1000L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    Object localObject;
    if (!bool1)
    {
      localObject = this.a.b();
      bool2 = bool1;
      if (localObject != null)
      {
        localObject = ((BaseActivity)localObject).getIntent();
        bool2 = bool1;
        if (localObject != null)
        {
          bool2 = ((Intent)localObject).getBooleanExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false);
          if (bool2)
          {
            ((Intent)localObject).removeExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM");
            this.c = SystemClock.uptimeMillis();
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("blockRefreshJumpBottom() block = ");
      ((StringBuilder)localObject).append(bool2);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    return bool2;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public void e()
  {
    if (this.i) {
      return;
    }
    if (this.j == 0) {
      return;
    }
    this.a.e().e().c(false);
    if (TextUtils.isEmpty(this.a.O().b)) {
      return;
    }
    Object localObject1 = this.a.e().b();
    ((ListUI)localObject1).b(0);
    List localList = ((ListUI)localObject1).d();
    int i1 = ((ListUI)localObject1).t();
    int i2 = ((ListUI)localObject1).u();
    int i3 = ((ListUI)localObject1).v();
    int i4 = this.j;
    int n = i4 & 0xFFFF0000;
    i4 &= 0xFFFF;
    if ((i4 == 2) || (i4 == 3)) {
      if ((localObject1 instanceof TroopListUI))
      {
        localObject2 = ((TroopListUI)localObject1).y();
        if (localObject2 != null)
        {
          ((JumpStateMachineController)localObject2).a(1);
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("JumpStateMachineController is null, mCurrentAIOState = ");
          ((StringBuilder)localObject2).append(this.a.F());
          QLog.d("MsgListRefresher", 1, ((StringBuilder)localObject2).toString());
        }
      }
      else if (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeListUiIsGuildListUI(localObject1))
      {
        localObject2 = (JumpStateMachineController)((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildListUIJumpStateController(localObject1);
        if (localObject2 != null)
        {
          ((JumpStateMachineController)localObject2).a(1);
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("guild JumpStateMachineController is null, mCurrentAIOState = ");
          ((StringBuilder)localObject2).append(this.a.F());
          QLog.d("MsgListRefresher", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    Object localObject2 = a(localList, n);
    int i5 = this.l;
    int i6 = localList.size();
    i4 = ((List)localObject2).size();
    int i7 = c(this.j & 0xFFFF);
    i1 = this.a.e().d().a(localList, (List)localObject2, i1, i2 - i3, i5, i6, i4, i7);
    this.j = 0;
    this.b = SystemClock.uptimeMillis();
    this.l = i1;
    if ((i1 > 0) && (i1 <= ((List)localObject2).size())) {
      this.m = ((ChatMessage)((List)localObject2).get(i1 - 1)).uniseq;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListAdapter, read count: ");
      localStringBuilder.append(this.l);
      localStringBuilder.append(" newsize ");
      localStringBuilder.append(i4);
      QLog.i("MsgListRefresher", 2, localStringBuilder.toString());
    }
    if (((n == 131072) || (n == 196608)) && (this.a.w()))
    {
      this.a.c().a(1001, new Object[0]);
      this.a.a(false);
    }
    if ((i1 == i4) && (!((ChatPieSelectableHelper)this.a.a(4)).d())) {
      ((ListUI)localObject1).h();
    }
    localObject1 = this.a.e().a().d().iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IRefreshCallback)((Iterator)localObject1).next()).a((List)localObject2, localList);
    }
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = this.a.O();
    QQAppInterface localQQAppInterface = this.a.a();
    int n = paramMessage.what;
    if (n != 12)
    {
      if (n != 78) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgListRefresher", 2, "handleMessage MSG_REFRESH_LIST_ITEM");
      }
      long l1 = paramMessage.getData().getLong("messageUniseq");
      n = paramMessage.arg1;
      localObject = (ChatMessage)localQQAppInterface.getMessageProxy(((BaseSessionInfo)localObject).a).b(((BaseSessionInfo)localObject).b, ((BaseSessionInfo)localObject).a, l1);
      if ((localObject != null) && ((paramMessage.obj instanceof MessageHandlerConstants.MsgSendCostParams)))
      {
        paramMessage = (MessageHandlerConstants.MsgSendCostParams)paramMessage.obj;
        paramMessage.e = (System.currentTimeMillis() - paramMessage.d);
        Report.a(paramMessage, localQQAppInterface);
        ((ChatMessage)localObject).setIsSentByXG(paramMessage.i);
      }
      a((ChatMessage)localObject, n);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgListRefresher", 2, "handleMessage MSG_REFRESH_LIST");
    }
    if ((paramMessage.obj instanceof MessageHandlerConstants.MsgSendCostParams))
    {
      paramMessage = (MessageHandlerConstants.MsgSendCostParams)paramMessage.obj;
      paramMessage.e = (System.currentTimeMillis() - paramMessage.d);
      Report.a(paramMessage, localQQAppInterface);
    }
    e();
    if (this.a.x() == 0)
    {
      BubbleDiyFetcher.a().a(this.a.a(), 1500);
      DiyPendantFetcher.a().a(this.a.a(), 1500);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher
 * JD-Core Version:    0.7.0.1
 */