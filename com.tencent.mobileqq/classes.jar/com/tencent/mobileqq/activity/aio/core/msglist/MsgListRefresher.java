package com.tencent.mobileqq.activity.aio.core.msglist;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
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
  @NonNull
  protected final AIOContext a;
  private ListUI jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI;
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
  }
  
  private MessageRecord a(List<ChatMessage> paramList)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((1000 == localSessionInfo.jdField_a_of_type_Int) || (1004 == localSessionInfo.jdField_a_of_type_Int) || (1022 == localSessionInfo.jdField_a_of_type_Int)) {
      return ChatActivityUtils.b(paramList, localSessionInfo, localQQAppInterface);
    }
    return ChatActivityUtils.a(paramList, localSessionInfo, localQQAppInterface);
  }
  
  @Nullable
  private CharSequence a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject;
    if ((1000 != localSessionInfo.jdField_a_of_type_Int) && (1004 != localSessionInfo.jdField_a_of_type_Int))
    {
      localObject = paramCharSequence;
      if (localSessionInfo.jdField_a_of_type_Int != 10008) {}
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
    if (1001 == localSessionInfo.jdField_a_of_type_Int) {
      if (!FaceScoreUtils.a.contains(localSessionInfo.jdField_a_of_type_JavaLangString))
      {
        paramList = (List<ChatMessage>)localObject;
        if (!FaceScoreUtils.a(localQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString)) {}
      }
      else
      {
        paramList = null;
      }
    }
    paramCharSequence = paramList;
    if (10002 == localSessionInfo.jdField_a_of_type_Int)
    {
      paramCharSequence = paramList;
      if (FaceScoreUtils.a(localQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString)) {
        paramCharSequence = null;
      }
    }
    if (UinTypeUtil.a(localSessionInfo.jdField_a_of_type_Int) == 1032) {
      paramCharSequence = null;
    }
    if (10010 == localSessionInfo.jdField_a_of_type_Int) {
      paramCharSequence = null;
    }
    if (localSessionInfo.jdField_a_of_type_Int == 10008) {
      return null;
    }
    return paramCharSequence;
  }
  
  private List<ChatMessage> a(List<ChatMessage> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgListRefresher", 2, "refreshListAdapter refreshFlag: " + paramInt);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    switch (this.jdField_a_of_type_Int & 0xFFFF0000)
    {
    default: 
      return paramList;
    case 65536: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.f();
      return paramList;
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.c());
    Object localObject2 = a(paramList);
    if (localObject2 != null) {
      this.jdField_c_of_type_Long = ((MessageRecord)localObject2).shmsgseq;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(paramList, (MessageRecord)localObject2);
    localObject1 = a(paramList, ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (SessionInfo)localObject1, (MessageRecord)localObject2, this.jdField_c_of_type_Long));
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
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected int a(int paramInt)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MsgListRefresher", 2, "refreshlistadapter dirtyFlag=" + paramInt);
    }
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      i = 8;
      if (QLog.isColorLevel()) {
        QLog.d("MsgListRefresher", 2, "refreshlistadapter after set dirtyFlag=" + i);
      }
      return i;
    }
    Object localObject;
    int k;
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.b() < 0) {
        break label342;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.c() - 1);
      i = paramInt;
      if (localObject != null)
      {
        i = paramInt;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.e() > 0)
        {
          i = paramInt;
          if (((View)localObject).getId() == 2131362465)
          {
            i = paramInt;
            if (!((ChatPieSelectableHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4)).b()) {
              i = 2;
            }
          }
        }
        j = ((View)localObject).getBottom();
      }
      int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.d();
      if (QLog.isColorLevel()) {
        QLog.d("MsgListRefresher", 2, "refreshlistadapter=====lastbuttom=" + j + " listHeight=" + m);
      }
      paramInt = i;
      k = j;
      j = m;
    }
    for (;;)
    {
      localObject = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(15);
      i = paramInt;
      if (k > j) {
        break;
      }
      i = paramInt;
      if (((AIOLongShotHelper)localObject).a()) {
        break;
      }
      i = paramInt;
      if (paramInt != 0) {
        break;
      }
      i = paramInt;
      if (((ChatPieSelectableHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4)).b()) {
        break;
      }
      i = 2;
      break;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.d())
      {
        i = 0;
        break;
      }
      if ((paramInt & 0x11) == 17)
      {
        i = 17;
        break;
      }
      i = paramInt;
      if ((paramInt & 0x10) != 16) {
        break;
      }
      i = 16;
      break;
      label342:
      j = 0;
      k = 0;
    }
  }
  
  public long a()
  {
    return this.d;
  }
  
  public void a()
  {
    if (this.jdField_c_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Int == 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().c(false);
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
    ((ListUI)localObject).a(0);
    List localList1 = ((ListUI)localObject).a();
    int k = ((ListUI)localObject).f();
    int m = ((ListUI)localObject).g();
    int n = ((ListUI)localObject).h();
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
    if (QLog.isColorLevel()) {
      QLog.i("MsgListRefresher", 2, "refreshListAdapter, read count: " + this.jdField_b_of_type_Int + " newsize " + j);
    }
    switch (i)
    {
    }
    for (;;)
    {
      if ((k == j) && (!((ChatPieSelectableHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4)).b())) {
        ((ListUI)localObject).e();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().d().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IRefreshCallback)((Iterator)localObject).next()).a(localList2, localList1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(1001, new Object[0]);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(false);
      }
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
  
  public void a(int paramInt, MessageHandler.MsgSendCostParams paramMsgSendCostParams, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgListRefresher", 2, "refresh with dirty: " + paramInt + " uniseq: " + paramLong + " currentPauseRefreshFlag: " + this.jdField_c_of_type_Boolean);
    }
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int == paramInt)) {}
    MqqHandler localMqqHandler;
    Message localMessage;
    label290:
    do
    {
      int i;
      for (;;)
      {
        return;
        i = paramInt & 0xFFFF0000;
        paramInt = Math.max(paramInt & 0xFFFF, this.jdField_a_of_type_Int & 0xFFFF);
        this.jdField_a_of_type_Int = (i | paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("MsgListRefresher", 2, "refresh with refreshFlag: " + i + " scrollFlag: " + paramInt);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() == 6) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() == 5) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() == 35) || (a())) {}
        for (paramInt = 1; paramInt != 0; paramInt = 0)
        {
          localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
          if (i != 262144) {
            break label290;
          }
          localMessage = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", paramLong);
          localMessage.setData(localBundle);
          localMessage.what = 78;
          localMessage.obj = paramMsgSendCostParams;
          localMessage.arg1 = 0;
          localMqqHandler.sendMessageDelayed(localMessage, 400L);
          return;
        }
      }
      localMessage = new Message();
      localMessage.what = 12;
      if (paramMsgSendCostParams != null) {
        localMessage.obj = paramMsgSendCostParams;
      }
      if (i < 196608) {
        break;
      }
    } while (localMqqHandler.hasMessages(12));
    paramLong = SystemClock.uptimeMillis();
    if (paramLong - this.jdField_a_of_type_Long > 1000L)
    {
      localMqqHandler.sendMessage(localMessage);
      return;
    }
    localMqqHandler.sendMessageDelayed(localMessage, 1000L - (paramLong - this.jdField_a_of_type_Long));
    return;
    paramMsgSendCostParams = (ChatPieSelectableHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(4);
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new MsgListRefresher.1(this, paramMsgSendCostParams));
    }
    for (;;)
    {
      localMqqHandler.removeMessages(12);
      localMqqHandler.sendMessage(localMessage);
      return;
      if (!paramMsgSendCostParams.b()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistListUI.e();
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
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("MsgListRefresher", 2, "instantUpdate: " + paramBoolean1 + " / " + paramBoolean2);
    }
    if (a())
    {
      QLog.d("MsgListRefresher", 1, "instantUpdate: blockRefreshJumpBottom TRUE " + false + " / " + false);
      paramBoolean2 = false;
      paramBoolean1 = false;
    }
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    for (;;)
    {
      a(i | 0x20000);
      return;
      i = 3;
      continue;
      i = 0;
    }
  }
  
  public boolean a()
  {
    if (SystemClock.uptimeMillis() - this.jdField_b_of_type_Long <= 1000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
        bool2 = bool1;
        if (localObject != null)
        {
          localObject = ((BaseActivity)localObject).getIntent();
          bool2 = bool1;
          if (localObject != null)
          {
            bool1 = ((Intent)localObject).getBooleanExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false);
            bool2 = bool1;
            if (bool1)
            {
              ((Intent)localObject).removeExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM");
              this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
              bool2 = bool1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgListRefresher", 2, "blockRefreshJumpBottom() block = " + bool2);
      }
      return bool2;
    }
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
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 78: 
      long l = paramMessage.getData().getLong("messageUniseq");
      int i = paramMessage.arg1;
      localObject = (ChatMessage)localQQAppInterface.getMessageProxy(((SessionInfo)localObject).jdField_a_of_type_Int).a(((SessionInfo)localObject).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject).jdField_a_of_type_Int, l);
      if ((localObject != null) && ((paramMessage.obj instanceof MessageHandler.MsgSendCostParams)))
      {
        paramMessage = (MessageHandler.MsgSendCostParams)paramMessage.obj;
        paramMessage.e = (System.currentTimeMillis() - paramMessage.d);
        MessageHandler.a(paramMessage, localQQAppInterface);
        ((ChatMessage)localObject).setIsSentByXG(paramMessage.jdField_b_of_type_Boolean);
      }
      a((ChatMessage)localObject, i);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgListRefresher", 2, "handleMessage MSG_REFRESH_LIST");
    }
    if ((paramMessage.obj instanceof MessageHandler.MsgSendCostParams))
    {
      paramMessage = (MessageHandler.MsgSendCostParams)paramMessage.obj;
      paramMessage.e = (System.currentTimeMillis() - paramMessage.d);
      MessageHandler.a(paramMessage, localQQAppInterface);
    }
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.c() == 0)
    {
      BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1500);
      DiyPendantFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1500);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher
 * JD-Core Version:    0.7.0.1
 */