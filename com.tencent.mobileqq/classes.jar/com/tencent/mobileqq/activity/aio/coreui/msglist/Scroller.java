package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import mqq.os.MqqHandler;

public class Scroller
{
  private static boolean jdField_b_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 0;
  protected long a;
  private ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private MoveToBottomScroller jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller;
  AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  public TroopAioTips a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = -1L;
  
  public Scroller()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new Scroller.2(this), 300L);
      return paramInt;
    }
    this.jdField_a_of_type_Int += 1;
    if (QLog.isColorLevel()) {
      QLog.d("Scroller", 2, "[refreshListAdapter]: refreshBottomCount=" + this.jdField_a_of_type_Int + ",refreshDelayForNextPie=" + jdField_b_of_type_Boolean);
    }
    if (jdField_b_of_type_Boolean)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a()) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.3(this));
      }
      jdField_b_of_type_Boolean = false;
      return paramInt;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1, 0);
      return paramInt;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.4(this));
    return paramInt;
  }
  
  private static int a(ChatXListView paramChatXListView)
  {
    int i = paramChatXListView.getHeight();
    try
    {
      int j = paramChatXListView.getChildAt(paramChatXListView.getHeaderViewsCount()).getBottom();
      return i - j;
    }
    catch (NullPointerException localNullPointerException) {}
    return paramChatXListView.getHeight();
  }
  
  public static int a(String paramString, ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString, 2, "keepPostionScroll readedCnt " + paramInt);
    }
    int k = paramList1.size();
    int i1 = paramList2.size();
    int n = paramChatXListView.getScrollY();
    int m = paramChatXListView.getFirstVisiblePosition();
    int i = b(paramChatXListView);
    int j = paramInt;
    if (k > 0)
    {
      j = paramInt;
      if (m >= 0)
      {
        if (i1 <= 0) {
          break label667;
        }
        if (i < k) {
          break label660;
        }
        j = k - 1;
        i = j;
        if (j >= 0) {
          break label657;
        }
        j += paramChatXListView.getHeaderViewsCount();
        i = j;
        if (j >= 0) {
          break label657;
        }
        i = 0;
        label129:
        long l = ((ChatMessage)paramList1.get(i)).uniseq;
        j = 0;
        if (j >= i1) {
          break label651;
        }
        if (((ChatMessage)paramList2.get(j)).uniseq != l) {
          break label398;
        }
        label176:
        if ((j >= 0) || (paramList1.size() <= i + 1)) {
          break label633;
        }
        l = ((ChatMessage)paramList1.get(i + 1)).uniseq;
        k = 0;
        label215:
        if (k >= i1) {
          break label633;
        }
        if (((ChatMessage)paramList2.get(k)).uniseq != l) {
          break label407;
        }
        j = i;
        m = 1;
        i = k;
        k = j;
        j = m;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramString, 2, "refreshListAdapter newTop:" + i + " oldScorllY " + n + " oldFirst " + k);
      }
      if (i >= 0)
      {
        k = paramInt + i;
        paramInt = k;
        if (j != 0) {
          paramInt = k - 1;
        }
        if ((n < 0) && (i == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i(paramString, 2, "springBackOverScrollHeaderView newTop:" + i + " oldScorllY " + n);
          }
          paramChatXListView.springBackOverScrollHeaderView();
          j = paramInt;
        }
        label398:
        label407:
        do
        {
          return j;
          j += 1;
          break;
          k += 1;
          break label215;
          if (n >= 0) {
            break label508;
          }
          k = a(paramChatXListView);
          paramChatXListView.hideOverScrollHeaderView();
          paramChatXListView.setSelectionFromBottom(paramChatXListView.getHeaderViewsCount() + i, k + n - paramChatXListView.getPaddingBottom());
          j = paramInt;
        } while (!QLog.isColorLevel());
        QLog.i(paramString, 2, "setSelectionFromBottom_1 newTop:" + i + " oldScorllY " + n + " bottom " + k);
        return paramInt;
        label508:
        j = a(paramChatXListView);
        if (QLog.isColorLevel()) {
          QLog.i(paramString, 2, "setSelectionFromBottom_2 newTop:" + i + " oldScorllY " + n + " bottom " + j);
        }
        paramChatXListView.setSelectionFromBottom(i + paramChatXListView.getHeaderViewsCount(), j - paramChatXListView.getPaddingBottom());
        return paramInt;
      }
      if (QLog.isColorLevel()) {
        QLog.i(paramString, 2, "hideOverScrollHeaderView newTop:" + i + " oldScorllY " + n);
      }
      paramChatXListView.hideOverScrollHeaderView();
      return i1;
      label633:
      k = i;
      m = 0;
      i = j;
      j = m;
      continue;
      label651:
      j = -1;
      break label176;
      label657:
      break label129;
      label660:
      j = i;
      break;
      label667:
      j = -1;
      k = i;
      m = 0;
      i = j;
      j = m;
    }
  }
  
  private int a(List<ChatMessage> paramList, long paramLong)
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    int i = 0;
    while (i < paramList.size())
    {
      if ((localSessionInfo.jdField_a_of_type_Int == 3000) || (localSessionInfo.jdField_a_of_type_Int == 1))
      {
        if (((ChatMessage)paramList.get(i)).shmsgseq != paramLong) {}
      }
      else {
        while (((ChatMessage)paramList.get(i)).time == paramLong) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    long l;
    if (paramList1 != paramList2)
    {
      if ((paramInt2 <= 0) || (paramInt3 <= 0)) {
        break label156;
      }
      l = ((ChatMessage)paramList1.get(paramInt2 - 1)).uniseq;
      i = paramInt3 - 1;
      if (i < 0) {
        break label156;
      }
      if ((i != paramInt3 - 1) || (!UniteGrayTipUtil.a((MessageRecord)paramList2.get(i)))) {
        break label113;
      }
      i = -1;
    }
    for (;;)
    {
      label76:
      if (i >= 0) {
        i = paramInt3 - (paramInt2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a() + paramInt3 - 1 - i);
      }
      label113:
      do
      {
        return i;
        if (((ChatMessage)paramList2.get(i)).uniseq == l) {
          break label76;
        }
        i -= 1;
        break;
        i = paramInt1;
      } while (paramInt3 <= 0);
      return paramInt3;
      label156:
      i = -1;
    }
  }
  
  private int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    int i = paramInt3;
    boolean bool;
    if (paramInt4 > 0)
    {
      i = paramInt3;
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() + paramInt2 >= 0)
      {
        paramInt4 = -1;
        paramInt3 = paramInt4;
        bool = paramBoolean;
        if (paramInt5 > 0)
        {
          if (paramInt2 < paramList1.size()) {
            break label646;
          }
          paramInt2 = paramList1.size() - 1;
        }
      }
    }
    label646:
    for (;;)
    {
      if (paramInt2 < 0) {}
      for (i = paramInt2 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();; i = paramInt2)
      {
        long l = ((ChatMessage)paramList1.get(i)).uniseq;
        paramInt3 = 0;
        paramInt2 = paramInt4;
        if (paramInt3 < paramInt5)
        {
          if (((ChatMessage)paramList2.get(paramInt3)).uniseq == l) {
            paramInt2 = paramInt3;
          }
        }
        else
        {
          paramInt3 = paramInt2;
          bool = paramBoolean;
          if (paramInt2 < 0)
          {
            paramInt3 = paramInt2;
            bool = paramBoolean;
            if (paramList1.size() > i + 1)
            {
              l = ((ChatMessage)paramList1.get(i + 1)).uniseq;
              paramInt4 = 0;
              label189:
              paramInt3 = paramInt2;
              bool = paramBoolean;
              if (paramInt4 < paramInt5)
              {
                if (((ChatMessage)paramList2.get(paramInt4)).uniseq != l) {
                  break label442;
                }
                bool = true;
                paramInt3 = paramInt4;
              }
            }
          }
          if (paramInt3 < 0) {
            break label629;
          }
          i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
          l = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
          paramInt2 = 0;
          label269:
          paramInt4 = i;
          if (paramInt2 < paramInt5)
          {
            if (((ChatMessage)paramList2.get(paramInt2)).uniseq != l) {
              break label451;
            }
            paramInt4 = paramInt2 + 1;
          }
          paramInt2 = paramInt4;
          if (bool) {
            paramInt2 = paramInt4 - 1;
          }
          if ((paramInt1 >= 0) || (paramInt3 != 0)) {
            break label460;
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.springBackOverScrollHeaderView();
        }
        for (;;)
        {
          i = paramInt2;
          if (this.jdField_a_of_type_Boolean)
          {
            QLog.d("Scroller", 2, new Object[] { "jumpTop - newTop = " + paramInt3, ",oldScorllY = " + paramInt1, ",newTop = " + paramInt3 });
            i = paramInt2;
          }
          return i;
          paramInt3 += 1;
          break;
          label442:
          paramInt4 += 1;
          break label189;
          label451:
          paramInt2 += 1;
          break label269;
          label460:
          if (paramInt1 < 0)
          {
            paramInt4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
            try
            {
              paramInt5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()).getBottom();
              paramInt4 -= paramInt5;
            }
            catch (NullPointerException paramList1)
            {
              for (;;)
              {
                paramInt4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() + paramInt3, paramInt4 + paramInt1 - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom());
            continue;
          }
          paramInt4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
          try
          {
            paramInt5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()).getBottom();
            paramInt4 -= paramInt5;
          }
          catch (NullPointerException paramList1)
          {
            for (;;)
            {
              paramInt4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() + paramInt3, paramInt4 - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom());
        }
        label629:
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
        return paramInt5;
      }
    }
  }
  
  private static int b(ChatXListView paramChatXListView)
  {
    if (paramChatXListView.isOverscrollHeadVisiable()) {
      return paramChatXListView.getFirstVisiblePosition() - paramChatXListView.getHeaderViewsCount();
    }
    return paramChatXListView.getFirstVisiblePosition();
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private void i()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l;
    Object localObject;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Scroller", 2, "do jumpToSpecifiedMsg");
      }
      l = System.currentTimeMillis();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
      if (((List)localObject).size() > 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("jump_from_shmsgseq", false))) {
          break label212;
        }
        int j = ((List)localObject).size();
        i = 0;
        if (i >= j) {
          break label345;
        }
        if (((ChatMessage)((List)localObject).get(i)).shmsgseq != this.jdField_a_of_type_Long) {
          break label205;
        }
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.7(this, i));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().c(false);
        return;
        label205:
        i += 1;
        break;
        label212:
        i = a((List)localObject, this.jdField_a_of_type_Long);
        continue;
      }
      List localList = localQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_Int).a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      if (1000 == localSessionInfo.jdField_a_of_type_Int) {}
      for (localObject = ChatActivityUtils.b(localList, localSessionInfo, localQQAppInterface);; localObject = ChatActivityUtils.a(localList, localSessionInfo, localQQAppInterface))
      {
        localObject = ChatActivityUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localSessionInfo, (MessageRecord)localObject, -1L);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(localList, (CharSequence)localObject);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.8(this));
        break;
      }
      label345:
      i = -1;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Scroller", 2, "jumpToSpecifiedMsgSimply, refreshScrollMsg = " + this.jdField_b_of_type_Long);
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if ((localList.size() > 0) && (this.jdField_b_of_type_Long >= 0L))
    {
      int i = a(localList, this.jdField_b_of_type_Long);
      if (i >= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.9(this, i));
        this.jdField_b_of_type_Long = -1L;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
  }
  
  public final int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.jdField_a_of_type_Boolean) {
      QLog.d("Scroller", 1, String.format("refreshListAdapterScroll- start oldScorllY = %d,oldFirst = %d,readed = %d,oldSize = %d,newSize = %d,dirtyFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) }));
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    switch (paramInt6)
    {
    case 5: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      paramInt3 = a(paramList1, paramList2, paramInt3, paramInt4, paramInt5);
    }
    label726:
    for (;;)
    {
      if (paramInt6 == 6)
      {
        paramInt3 = paramInt5 - (paramInt4 - j);
        a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount(), -1, null, 7);
        if ((a() == 22) || (a() == 103)) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697788), 3000).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b());
        }
      }
      while (paramInt6 != 7) {
        for (;;)
        {
          if (this.jdField_a_of_type_Boolean) {
            QLog.d("Scroller", 1, String.format("refreshListAdapterScroll- end oldScorllY = %d,oldFirst = %d,readed = %d,oldSize = %d,newSize = %d,dirtyFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) }));
          }
          return paramInt3;
          paramInt3 = a(paramInt5);
          break;
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a()) {
            a();
          }
          paramInt3 = paramInt5;
          break;
          if (paramInt4 == 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() + paramInt5 - 1, 0);
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
            paramInt3 = paramInt5;
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
          paramInt3 = a(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
          break;
          paramInt3 = a(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
          break;
          i();
          break;
          paramList1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
          if ((paramList1.size() <= 0) || (this.jdField_b_of_type_Long < 0L)) {
            break label726;
          }
          i = a(paramList1, this.jdField_b_of_type_Long);
          if (i >= 0)
          {
            a(i, 1);
            this.jdField_b_of_type_Long = -1L;
          }
          break;
          a("Scroller", this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, 0, paramList1, paramList2);
          paramInt3 = j + paramInt5 - paramInt4;
          break;
          j();
          break;
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131697789), 3000).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b());
        }
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
      paramInt3 = 0;
      label639:
      if (paramInt3 < i)
      {
        paramList1 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(paramInt3);
        if ((paramList1 == null) || (paramList1.msgtype != -4009)) {}
      }
      for (;;)
      {
        if (paramInt3 == 0) {}
        for (i = 0;; i = -1)
        {
          a(paramInt3, i, null, 8);
          paramInt3 = paramInt5 - (paramInt4 - j);
          break;
          paramInt3 += 1;
          break label639;
        }
        paramInt3 = 0;
      }
    }
  }
  
  public long a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
        if (!MsgProxyUtils.a(localChatMessage)) {
          return localChatMessage.shmsgseq;
        }
      }
    }
    return 0L;
  }
  
  public TroopAioTips a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
  }
  
  public TroopAioMsgNavigateBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.a();
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(i + paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt, 250L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, null, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt3, paramRunnable, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, MqqHandler paramMqqHandler, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt3, paramRunnable, paramMqqHandler, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramRunnable, paramInt3);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Scroller.troop.special_msg", 2, "refreshHeadMessage==>type = " + paramInt1 + ", value = " + paramLong + ", unreadMsgCount = " + paramInt2 + ", flushType = " + paramInt3);
    }
    long l = a();
    Scroller.1 local1 = new Scroller.1(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt3);
    a(paramInt1, paramLong, paramInt2, paramInt4, l, local1);
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, Runnable paramRunnable)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() == 9) {
      i = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Scroller.troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + paramLong2 + "|value:" + paramLong1 + "|type:" + paramInt1);
    }
    if (i == 0)
    {
      IHeadMsgRefresher localIHeadMsgRefresher = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(paramInt1);
      if (localIHeadMsgRefresher != null) {
        localIHeadMsgRefresher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramRunnable);
      }
    }
    else
    {
      return;
    }
    QLog.e("Scroller", 1, "no refresher found for type: " + paramInt1);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramLong1, paramLong2, paramBoolean);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("searched_timeorseq", -1L);
  }
  
  public void a(AIOContext paramAIOContext, ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1, AIOFooterViewDetector paramAIOFooterViewDetector)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramChatXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(paramChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller = new MoveToBottomScroller(paramChatXListView, paramAIOFooterViewDetector);
  }
  
  public void a(Observer paramObserver, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = new TroopAioTips();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
      if (QLog.isColorLevel()) {
        QLog.d("Scroller", 2, "Base#onShow_troopType#setTroopTips");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.h();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramRelativeLayout, paramChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() != 9)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.b());
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, 250L);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2);
  }
  
  public void b(long paramLong)
  {
    long l = System.currentTimeMillis();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (((List)localObject).size() > 0)
    {
      int i = a((List)localObject, paramLong);
      if (i >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.5(this, i));
      }
    }
    else
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
      return;
    }
    List localList = localQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_Int).a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, paramLong);
    if (1000 == localSessionInfo.jdField_a_of_type_Int) {}
    for (localObject = ChatActivityUtils.b(localList, localSessionInfo, localQQAppInterface);; localObject = ChatActivityUtils.a(localList, localSessionInfo, localQQAppInterface))
    {
      localObject = ChatActivityUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localSessionInfo, (MessageRecord)localObject, -1L);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(localList, (CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.6(this));
      break;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt);
  }
  
  public void c(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(65552);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.b();
    }
  }
  
  public void d(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void e()
  {
    c();
    d();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.d();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void h()
  {
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller
 * JD-Core Version:    0.7.0.1
 */