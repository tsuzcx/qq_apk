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
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
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
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
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
  private int jdField_a_of_type_Int = 131075;
  long jdField_a_of_type_Long = -1L;
  private final BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  @NonNull
  protected final AIOContext a;
  private ListUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = -1L;
  boolean jdField_b_of_type_Boolean = true;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  private long d = 0L;
  
  public MsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
  }
  
  private MessageRecord a(List<ChatMessage> paramList)
  {
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if ((1000 != localBaseSessionInfo.jdField_a_of_type_Int) && (1004 != localBaseSessionInfo.jdField_a_of_type_Int) && (1022 != localBaseSessionInfo.jdField_a_of_type_Int)) {
      return ChatActivityUtils.a(paramList, localBaseSessionInfo, localQQAppInterface);
    }
    return ChatActivityUtils.b(paramList, localBaseSessionInfo, localQQAppInterface);
  }
  
  @Nullable
  private CharSequence a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    Object localObject;
    if ((1000 != localBaseSessionInfo.jdField_a_of_type_Int) && (1004 != localBaseSessionInfo.jdField_a_of_type_Int))
    {
      localObject = paramCharSequence;
      if (localBaseSessionInfo.jdField_a_of_type_Int != 10008) {}
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
    if (1001 == localBaseSessionInfo.jdField_a_of_type_Int)
    {
      paramList = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
      if (!IFaceScoreUtils.sNeedInsertGrayMsgUins.contains(localBaseSessionInfo.jdField_a_of_type_JavaLangString))
      {
        paramList = (List<ChatMessage>)localObject;
        if (!((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).getHasInsertMsgFlag(localQQAppInterface, localBaseSessionInfo.jdField_a_of_type_JavaLangString)) {}
      }
      else
      {
        paramList = null;
      }
    }
    paramCharSequence = paramList;
    if (10002 == localBaseSessionInfo.jdField_a_of_type_Int)
    {
      paramCharSequence = paramList;
      if (((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).getHasInsertMsgFlag(localQQAppInterface, localBaseSessionInfo.jdField_a_of_type_JavaLangString)) {
        paramCharSequence = null;
      }
    }
    if (UinTypeUtil.a(localBaseSessionInfo.jdField_a_of_type_Int) == 1032) {
      paramCharSequence = null;
    }
    if (10010 == localBaseSessionInfo.jdField_a_of_type_Int) {
      paramCharSequence = null;
    }
    if (localBaseSessionInfo.jdField_a_of_type_Int == 10008) {
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    paramInt = this.jdField_a_of_type_Int & 0xFFFF0000;
    if (paramInt != 65536)
    {
      if ((paramInt != 131072) && (paramInt != 196608) && (paramInt != 262144)) {
        return paramList;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
      paramList = paramList.a((AIOContext)localObject2, ((AIOContext)localObject2).c());
      localObject2 = a(paramList);
      if (localObject2 != null) {
        this.jdField_c_of_type_Long = ((MessageRecord)localObject2).shmsgseq;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(paramList, (MessageRecord)localObject2);
      localObject1 = a(paramList, ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (BaseSessionInfo)localObject1, (MessageRecord)localObject2, this.jdField_c_of_type_Long));
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().c().iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramList = ((IReloadFilter)((Iterator)localObject2).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramList);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(paramList, (CharSequence)localObject1, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.d();
      ChatFragment.a(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b();
      return paramList;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.f();
    return paramList;
  }
  
  private void a(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a())
    {
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().e();
      Object localObject = paramMessageRecord.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IMsgUpdateCallback)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramChatMessage);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
      ((UnreadTask)localObject).b();
      ((UnreadTask)localObject).b(true);
      ((UnreadTask)localObject).a(true);
      paramMessageRecord = paramMessageRecord.iterator();
      while (paramMessageRecord.hasNext()) {
        ((IMsgUpdateCallback)paramMessageRecord.next()).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramChatMessage);
      }
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == 1008) && (((PAListUI)paramMessageRecord).jdField_a_of_type_Boolean) && (paramMessageRecord.b() == paramMessageRecord.n() - 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().postDelayed(new MsgListRefresher.3(this), 800L);
      }
      else
      {
        paramChatMessage.mMsgAnimFlag = true;
        a(196608);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(true);
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
    ((UnreadTask)localObject).b();
    ((UnreadTask)localObject).b(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(true);
    b(paramMessageRecord);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().e().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IMsgUpdateCallback)((Iterator)localObject).next()).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, (ChatMessage)paramMessageRecord);
    }
  }
  
  private boolean a(Object paramObject, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype == -1004) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin))) {
      return true;
    }
    if (a(paramMessageRecord)) {
      a((ChatMessage)paramObject, paramMessageRecord);
    } else {
      a(paramObject, paramMessageRecord);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.c();
    if (((paramObject instanceof MessageForStructing)) || ((paramObject instanceof MessageForText))) {
      AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(), (ChatMessage)paramObject);
    }
    return false;
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    if (b(paramMessageRecord))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().e().iterator();
      boolean bool1 = false;
      while (((Iterator)localObject).hasNext()) {
        bool1 |= ((IMsgUpdateCallback)((Iterator)localObject).next()).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, (ChatMessage)paramMessageRecord);
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
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected int a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshlistadapter dirtyFlag=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    int k = 0;
    int j = 0;
    int i;
    if ((bool) && (this.jdField_b_of_type_Boolean))
    {
      i = 8;
    }
    else if (paramInt == 0)
    {
      int m;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.b() >= 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI;
        localObject = ((ListUI)localObject).a(((ListUI)localObject).c() - 1);
        i = paramInt;
        if (localObject != null)
        {
          i = paramInt;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.j() > 0)
          {
            i = paramInt;
            if (((View)localObject).getId() == 2131362421)
            {
              i = paramInt;
              if (!((ChatPieSelectableHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4)).b()) {
                i = 2;
              }
            }
          }
          j = ((View)localObject).getBottom();
        }
        int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.d();
        m = n;
        k = j;
        paramInt = i;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshlistadapter=====lastbuttom=");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(" listHeight=");
          ((StringBuilder)localObject).append(n);
          QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
          m = n;
          k = j;
          paramInt = i;
        }
      }
      else
      {
        m = 0;
      }
      localObject = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(15);
      i = paramInt;
      if (k <= m)
      {
        i = paramInt;
        if (!((AIOLongShotHelper)localObject).a())
        {
          i = paramInt;
          if (paramInt == 0)
          {
            i = paramInt;
            if (!((ChatPieSelectableHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4)).b()) {
              i = 2;
            }
          }
        }
      }
    }
    else if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.d())
    {
      i = 0;
    }
    else if ((paramInt & 0x11) == 17)
    {
      i = 17;
    }
    else
    {
      i = paramInt;
      if ((paramInt & 0x10) == 16) {
        i = 16;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshlistadapter after set dirtyFlag=");
      ((StringBuilder)localObject).append(i);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public long a()
  {
    return this.d;
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().c(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
    ((ListUI)localObject).a(0);
    List localList1 = ((ListUI)localObject).a();
    int k = ((ListUI)localObject).k();
    int m = ((ListUI)localObject).l();
    int n = ((ListUI)localObject).m();
    int i = this.jdField_a_of_type_Int & 0xFFFF0000;
    List localList2 = a(localList1, i);
    int i1 = this.jdField_b_of_type_Int;
    int i2 = localList1.size();
    int j = localList2.size();
    int i3 = a(this.jdField_a_of_type_Int & 0xFFFF);
    k = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(localList1, localList2, k, m - n, i1, i2, j, i3);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Int = k;
    if ((k > 0) && (k <= localList2.size())) {
      this.d = ((ChatMessage)localList2.get(k - 1)).uniseq;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshListAdapter, read count: ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" newsize ");
      localStringBuilder.append(j);
      QLog.i("MsgListRefresher", 2, localStringBuilder.toString());
    }
    if (((i == 131072) || (i == 196608)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.f()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(1001, new Object[0]);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(false);
    }
    if ((k == j) && (!((ChatPieSelectableHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4)).b())) {
      ((ListUI)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().d().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IRefreshCallback)((Iterator)localObject).next()).a(localList2, localList1);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, null, -1L);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.d = paramLong;
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
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int == paramInt)) {
      return;
    }
    int i = 0xFFFF0000 & paramInt;
    paramInt = Math.max(paramInt & 0xFFFF, 0xFFFF & this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = (i | paramInt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refresh with refreshFlag: ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" scrollFlag: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("MsgListRefresher", 2, ((StringBuilder)localObject).toString());
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != 6) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != 5) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() != 35) && (!a())) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (paramInt != 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
      if (i == 262144)
      {
        localMessage = new Message();
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramLong);
        localMessage.setData(localBundle);
        localMessage.what = 78;
        localMessage.obj = paramMsgSendCostParams;
        localMessage.arg1 = 0;
        ((MqqHandler)localObject).sendMessageDelayed(localMessage, 400L);
        return;
      }
      Message localMessage = new Message();
      localMessage.what = 12;
      if (paramMsgSendCostParams != null) {
        localMessage.obj = paramMsgSendCostParams;
      }
      if (i >= 196608)
      {
        if (!((MqqHandler)localObject).hasMessages(12))
        {
          paramLong = SystemClock.uptimeMillis();
          long l = this.jdField_a_of_type_Long;
          if (paramLong - l > 1000L)
          {
            ((MqqHandler)localObject).sendMessage(localMessage);
            return;
          }
          ((MqqHandler)localObject).sendMessageDelayed(localMessage, 1000L - (paramLong - l));
        }
      }
      else
      {
        paramMsgSendCostParams = (ChatPieSelectableHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4);
        if (Looper.myLooper() != Looper.getMainLooper()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().runOnUiThread(new MsgListRefresher.1(this, paramMsgSendCostParams));
        } else if (!paramMsgSendCostParams.b()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.e();
        }
        ((MqqHandler)localObject).removeMessages(12);
        ((MqqHandler)localObject).sendMessage(localMessage);
      }
    }
  }
  
  public void a(ListUI paramListUI)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI = paramListUI;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this);
  }
  
  public final void a(ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.a(paramChatMessage, paramInt);
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
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()) {
        AioAnimationDetector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().e().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((IMsgUpdateCallback)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, (ChatMessage)paramObject)) {
          return;
        }
      }
      if (!localMessageRecord.isSendFromLocal())
      {
        if (!a(paramObject, localMessageRecord)) {}
      }
      else {
        a(localMessageRecord);
      }
      FightMsgReporter.a(0, 0, localMessageRecord.istroop, 1);
      return;
    }
    if (((paramObject instanceof DataLineMsgRecord)) && (!localMessageRecord.isread) && (!localMessageRecord.isSendFromLocal())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(localMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a());
    }
    ThreadManagerV2.excute(new MsgListRefresher.2(this), 32, null, true);
  }
  
  protected void a(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a())
    {
      if (paramMessageRecord.isread) {
        return;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(paramMessageRecord, paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
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
    if (a())
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
        i = 3;
      }
    }
    else {
      i = 0;
    }
    a(0x20000 | i);
  }
  
  public boolean a()
  {
    boolean bool1;
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long <= 1000L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    Object localObject;
    if (!bool1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
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
            this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
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
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(paramMessageRecord.istroop))));
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    int i = paramMessage.what;
    if (i != 12)
    {
      if (i != 78) {
        return false;
      }
      long l = paramMessage.getData().getLong("messageUniseq");
      i = paramMessage.arg1;
      localObject = (ChatMessage)localQQAppInterface.getMessageProxy(((BaseSessionInfo)localObject).jdField_a_of_type_Int).a(((BaseSessionInfo)localObject).jdField_a_of_type_JavaLangString, ((BaseSessionInfo)localObject).jdField_a_of_type_Int, l);
      if ((localObject != null) && ((paramMessage.obj instanceof MessageHandlerConstants.MsgSendCostParams)))
      {
        paramMessage = (MessageHandlerConstants.MsgSendCostParams)paramMessage.obj;
        paramMessage.e = (System.currentTimeMillis() - paramMessage.d);
        Report.a(paramMessage, localQQAppInterface);
        ((ChatMessage)localObject).setIsSentByXG(paramMessage.jdField_b_of_type_Boolean);
      }
      a((ChatMessage)localObject, i);
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
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.c() == 0)
    {
      BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), 1500);
      DiyPendantFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), 1500);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher
 * JD-Core Version:    0.7.0.1
 */