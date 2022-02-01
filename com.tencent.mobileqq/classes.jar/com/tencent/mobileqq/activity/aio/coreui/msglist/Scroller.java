package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
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
  ChatAdapter1 jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  private MoveToBottomScroller jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller;
  protected AIOContext a;
  ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_Int == 1008)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new Scroller.2(this), 300L);
      return paramInt;
    }
    this.jdField_a_of_type_Int += 1;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[refreshListAdapter]: refreshBottomCount=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",refreshDelayForNextPie=");
      ((StringBuilder)localObject).append(jdField_b_of_type_Boolean);
      QLog.d("Scroller", 2, ((StringBuilder)localObject).toString());
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      ((ChatXListView)localObject).setSelectionFromBottom(((ChatXListView)localObject).getCount() - 1, 0);
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
    catch (NullPointerException localNullPointerException)
    {
      label21:
      break label21;
    }
    return paramChatXListView.getHeight();
  }
  
  public static int a(String paramString, ChatXListView paramChatXListView, int paramInt, List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int n = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("keepPostionScroll readedCnt ");
      localStringBuilder.append(n);
      QLog.i(paramString, 2, localStringBuilder.toString());
    }
    int i3 = paramList1.size();
    int i1 = paramList2.size();
    int i2 = paramChatXListView.getScrollY();
    int i = paramChatXListView.getFirstVisiblePosition();
    int k = b(paramChatXListView);
    paramInt = n;
    if (i3 > 0)
    {
      paramInt = n;
      if (i >= 0)
      {
        int m = -1;
        i = m;
        int j = k;
        if (i1 > 0)
        {
          i = k;
          if (k >= i3) {
            i = i3 - 1;
          }
          paramInt = i;
          if (i < 0)
          {
            i += paramChatXListView.getHeaderViewsCount();
            paramInt = i;
            if (i < 0) {
              paramInt = 0;
            }
          }
          long l = ((ChatMessage)paramList1.get(paramInt)).uniseq;
          i = 0;
          for (;;)
          {
            k = m;
            if (i >= i1) {
              break;
            }
            if (((ChatMessage)paramList2.get(i)).uniseq == l)
            {
              k = i;
              break;
            }
            i += 1;
          }
          i = k;
          j = paramInt;
          if (k < 0)
          {
            m = paramList1.size();
            i3 = paramInt + 1;
            i = k;
            j = paramInt;
            if (m > i3)
            {
              l = ((ChatMessage)paramList1.get(i3)).uniseq;
              m = 0;
              for (;;)
              {
                i = k;
                j = paramInt;
                if (m >= i1) {
                  break;
                }
                if (((ChatMessage)paramList2.get(m)).uniseq == l)
                {
                  j = m;
                  i = 1;
                  k = paramInt;
                  paramInt = i;
                  break label349;
                }
                m += 1;
              }
            }
          }
        }
        paramInt = 0;
        k = j;
        j = i;
        label349:
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("refreshListAdapter newTop:");
          paramList1.append(j);
          paramList1.append(" oldScorllY ");
          paramList1.append(i2);
          paramList1.append(" oldFirst ");
          paramList1.append(k);
          QLog.i(paramString, 2, paramList1.toString());
        }
        if (j >= 0)
        {
          k = n + j;
          i = k;
          if (paramInt != 0) {
            i = k - 1;
          }
          if ((i2 < 0) && (j == 0))
          {
            if (QLog.isColorLevel())
            {
              paramList1 = new StringBuilder();
              paramList1.append("springBackOverScrollHeaderView newTop:");
              paramList1.append(j);
              paramList1.append(" oldScorllY ");
              paramList1.append(i2);
              QLog.i(paramString, 2, paramList1.toString());
            }
            paramChatXListView.springBackOverScrollHeaderView();
            return i;
          }
          if (i2 < 0)
          {
            k = a(paramChatXListView);
            paramChatXListView.hideOverScrollHeaderView();
            paramChatXListView.setSelectionFromBottom(paramChatXListView.getHeaderViewsCount() + j, k + i2 - paramChatXListView.getPaddingBottom());
            paramInt = i;
            if (QLog.isColorLevel())
            {
              paramChatXListView = new StringBuilder();
              paramChatXListView.append("setSelectionFromBottom_1 newTop:");
              paramChatXListView.append(j);
              paramChatXListView.append(" oldScorllY ");
              paramChatXListView.append(i2);
              paramChatXListView.append(" bottom ");
              paramChatXListView.append(k);
              QLog.i(paramString, 2, paramChatXListView.toString());
              return i;
            }
          }
          else
          {
            paramInt = a(paramChatXListView);
            if (QLog.isColorLevel())
            {
              paramList1 = new StringBuilder();
              paramList1.append("setSelectionFromBottom_2 newTop:");
              paramList1.append(j);
              paramList1.append(" oldScorllY ");
              paramList1.append(i2);
              paramList1.append(" bottom ");
              paramList1.append(paramInt);
              QLog.i(paramString, 2, paramList1.toString());
            }
            paramChatXListView.setSelectionFromBottom(j + paramChatXListView.getHeaderViewsCount(), paramInt - paramChatXListView.getPaddingBottom());
            return i;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramList1 = new StringBuilder();
            paramList1.append("hideOverScrollHeaderView newTop:");
            paramList1.append(j);
            paramList1.append(" oldScorllY ");
            paramList1.append(i2);
            QLog.i(paramString, 2, paramList1.toString());
          }
          paramChatXListView.hideOverScrollHeaderView();
          paramInt = i1;
        }
      }
    }
    return paramInt;
  }
  
  private int a(List<ChatMessage> paramList, long paramLong)
  {
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    int i = 0;
    while (i < paramList.size())
    {
      if ((localBaseSessionInfo.jdField_a_of_type_Int != 3000) && (localBaseSessionInfo.jdField_a_of_type_Int != 1))
      {
        if (((ChatMessage)paramList.get(i)).time == paramLong) {
          return i;
        }
      }
      else if (((ChatMessage)paramList.get(i)).shmsgseq == paramLong) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramList1 != paramList2)
    {
      if ((paramInt2 > 0) && (paramInt3 > 0))
      {
        long l = ((ChatMessage)paramList1.get(paramInt2 - 1)).uniseq;
        int j = paramInt3 - 1;
        i = j;
        while ((i >= 0) && ((i != j) || (!UniteGrayTipMsgUtil.a((MessageRecord)paramList2.get(i)))))
        {
          if (((ChatMessage)paramList2.get(i)).uniseq == l) {
            break label113;
          }
          i -= 1;
        }
      }
      i = -1;
      label113:
      if (i >= 0) {
        return paramInt3 - (paramInt2 - this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a() + paramInt3 - 1 - i);
      }
      i = paramInt1;
      if (paramInt3 > 0) {
        i = paramInt3;
      }
    }
    return i;
  }
  
  private int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((paramInt4 > 0) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() + paramInt2 >= 0))
    {
      paramInt4 = -1;
      paramInt3 = paramInt4;
      boolean bool = paramBoolean;
      int i;
      long l;
      if (paramInt5 > 0)
      {
        paramInt3 = paramInt2;
        if (paramInt2 >= paramList1.size()) {
          paramInt3 = paramList1.size() - 1;
        }
        i = paramInt3;
        if (paramInt3 < 0) {
          i = paramInt3 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        }
        l = ((ChatMessage)paramList1.get(i)).uniseq;
        paramInt3 = 0;
        for (;;)
        {
          paramInt2 = paramInt4;
          if (paramInt3 >= paramInt5) {
            break;
          }
          if (((ChatMessage)paramList2.get(paramInt3)).uniseq == l)
          {
            paramInt2 = paramInt3;
            break;
          }
          paramInt3 += 1;
        }
        paramInt3 = paramInt2;
        bool = paramBoolean;
        if (paramInt2 < 0)
        {
          paramInt4 = paramList1.size();
          i += 1;
          paramInt3 = paramInt2;
          bool = paramBoolean;
          if (paramInt4 > i)
          {
            l = ((ChatMessage)paramList1.get(i)).uniseq;
            paramInt4 = 0;
            for (;;)
            {
              paramInt3 = paramInt2;
              bool = paramBoolean;
              if (paramInt4 >= paramInt5) {
                break;
              }
              if (((ChatMessage)paramList2.get(paramInt4)).uniseq == l)
              {
                paramInt3 = paramInt4;
                bool = true;
                break;
              }
              paramInt4 += 1;
            }
          }
        }
      }
      if (paramInt3 >= 0)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
        l = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
        paramInt2 = 0;
        for (;;)
        {
          paramInt4 = i;
          if (paramInt2 >= paramInt5) {
            break;
          }
          if (((ChatMessage)paramList2.get(paramInt2)).uniseq == l)
          {
            paramInt4 = paramInt2 + 1;
            break;
          }
          paramInt2 += 1;
        }
        paramInt2 = paramInt4;
        if (bool) {
          paramInt2 = paramInt4 - 1;
        }
        if ((paramInt1 < 0) && (paramInt3 == 0)) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.springBackOverScrollHeaderView();
        } else if (paramInt1 < 0) {
          paramInt4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
        }
      }
    }
    try
    {
      paramInt5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()).getBottom();
      paramInt4 -= paramInt5;
    }
    catch (NullPointerException paramList1)
    {
      label424:
      break label424;
    }
    paramInt4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
    paramList1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    paramList1.setSelectionFromBottom(paramList1.getHeaderViewsCount() + paramInt3, paramInt4 + paramInt1 - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom());
    break label544;
    paramInt4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
    try
    {
      paramInt5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()).getBottom();
      paramInt4 -= paramInt5;
    }
    catch (NullPointerException paramList1)
    {
      label509:
      StringBuilder localStringBuilder;
      break label509;
    }
    paramInt4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
    paramList1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    paramList1.setSelectionFromBottom(paramList1.getHeaderViewsCount() + paramInt3, paramInt4 - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom());
    label544:
    paramInt4 = paramInt2;
    if (this.jdField_a_of_type_Boolean)
    {
      paramList1 = new StringBuilder();
      paramList1.append("jumpTop - newTop = ");
      paramList1.append(paramInt3);
      paramList1 = paramList1.toString();
      paramList2 = new StringBuilder();
      paramList2.append(",oldScorllY = ");
      paramList2.append(paramInt1);
      paramList2 = paramList2.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(",newTop = ");
      localStringBuilder.append(paramInt3);
      QLog.d("Scroller", 2, new Object[] { paramList1, paramList2, localStringBuilder.toString() });
      return paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
      return paramInt5;
      paramInt4 = paramInt3;
    }
    return paramInt4;
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
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Scroller", 2, "do jumpToSpecifiedMsg");
      }
      long l = System.currentTimeMillis();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
      if (((List)localObject).size() > 0)
      {
        int k = -1;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getIntent() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getIntent().getBooleanExtra("jump_from_shmsgseq", false)))
        {
          int m = ((List)localObject).size();
          int i = 0;
          for (;;)
          {
            j = k;
            if (i >= m) {
              break;
            }
            if (((ChatMessage)((List)localObject).get(i)).shmsgseq == this.jdField_a_of_type_Long)
            {
              j = i;
              break;
            }
            i += 1;
          }
        }
        int j = a((List)localObject, this.jdField_a_of_type_Long);
        if (j >= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.7(this, j));
        }
        else
        {
          List localList = localQQAppInterface.getMessageFacade().a(localBaseSessionInfo.jdField_a_of_type_Int).a(localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
          if (1000 == localBaseSessionInfo.jdField_a_of_type_Int) {
            localObject = ChatActivityUtils.b(localList, localBaseSessionInfo, localQQAppInterface);
          } else {
            localObject = ChatActivityUtils.a(localList, localBaseSessionInfo, localQQAppInterface);
          }
          localObject = ChatActivityUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), localBaseSessionInfo, (MessageRecord)localObject, -1L);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(localList, (CharSequence)localObject);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.8(this));
        }
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().c(false);
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToSpecifiedMsgSimply, refreshScrollMsg = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
      QLog.d("Scroller", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (((List)localObject).size() > 0)
    {
      long l = this.jdField_b_of_type_Long;
      if (l >= 0L)
      {
        int i = a((List)localObject, l);
        if (i >= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.9(this, i));
          this.jdField_b_of_type_Long = -1L;
        }
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
    int i;
    if (paramInt6 != 1)
    {
      if (paramInt6 != 2)
      {
        if (paramInt6 != 3)
        {
          if (paramInt6 != 4)
          {
            if ((paramInt6 != 6) && (paramInt6 != 7))
            {
              if (paramInt6 != 8) {
                if (paramInt6 != 16) {
                  if (paramInt6 != 17) {
                    paramInt3 = a(paramList1, paramList2, paramInt3, paramInt4, paramInt5);
                  }
                }
              }
              label234:
              for (;;)
              {
                break;
                j();
                break label234;
                paramList1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
                if (paramList1.size() > 0)
                {
                  long l = this.jdField_b_of_type_Long;
                  if (l >= 0L)
                  {
                    i = a(paramList1, l);
                    if (i >= 0)
                    {
                      a(i, 1);
                      this.jdField_b_of_type_Long = -1L;
                      break label234;
                      i();
                    }
                  }
                }
              }
            }
            paramInt3 = a(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
            break label381;
          }
          if (paramInt4 == 0)
          {
            paramList1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
            paramList1.setSelectionFromBottom(paramList1.getHeaderViewsCount() + paramInt5 - 1, 0);
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
            paramInt3 = a(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
            break label381;
          }
        }
        else
        {
          paramInt3 = a(paramInt5);
          break label381;
        }
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a()) {
        a();
      }
      paramInt3 = paramInt5;
    }
    else
    {
      a("Scroller", this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, 0, paramList1, paramList2);
      paramInt3 = j + paramInt5 - paramInt4;
    }
    label381:
    if (paramInt6 == 6)
    {
      paramInt3 = paramInt5 - (paramInt4 - j);
      a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount(), -1, null, 7);
      if ((a() != 22) && (a() != 103)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getString(2131697795), 3000).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b());
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getApp(), 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getString(2131697794), 3000).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.b());
      }
    }
    else if (paramInt6 == 7)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
      paramInt3 = 0;
      while (paramInt3 < i)
      {
        paramList1 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(paramInt3);
        if ((paramList1 != null) && (paramList1.msgtype == -4009))
        {
          bool = true;
          break label596;
        }
        paramInt3 += 1;
      }
      paramInt3 = 0;
      boolean bool = false;
      if (paramInt3 == 0) {
        i = 0;
      } else {
        i = -1;
      }
      a(paramInt3, i, null, 8, bool);
      paramInt3 = paramInt5 - (paramInt4 - j);
    }
    label596:
    if (this.jdField_a_of_type_Boolean) {
      QLog.d("Scroller", 1, String.format("refreshListAdapterScroll- end oldScorllY = %d,oldFirst = %d,readed = %d,oldSize = %d,newSize = %d,dirtyFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) }));
    }
    return paramInt3;
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
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(i + paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt, 250L);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, null, paramInt2, false);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramRunnable, paramInt3, false);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramRunnable, paramInt3, paramBoolean);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    a(paramInt1, paramLong, paramInt2, 0, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==>type = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", value = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", unreadMsgCount = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", flushType = ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.d("Scroller.troop.special_msg", 2, ((StringBuilder)localObject).toString());
    }
    long l = a();
    Object localObject = new Scroller.1(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(paramInt3);
    a(paramInt1, paramLong, paramInt2, paramInt4, l, (Runnable)localObject);
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, Runnable paramRunnable)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() == 9) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==>fistseq:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("|value:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("|type:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Scroller.troop.special_msg", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(paramInt1);
      if (localObject != null)
      {
        ((IHeadMsgRefresher)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramRunnable);
        return;
      }
      paramRunnable = new StringBuilder();
      paramRunnable.append("no refresher found for type: ");
      paramRunnable.append(paramInt1);
      QLog.e("Scroller", 1, paramRunnable.toString());
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    TroopAioTips localTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    if (localTroopAioTips != null) {
      localTroopAioTips.a(paramLong1, paramLong2, paramBoolean);
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
    ScrollerRunnable localScrollerRunnable = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
    if (localScrollerRunnable != null)
    {
      localScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips);
      if (QLog.isColorLevel()) {
        QLog.d("Scroller", 2, "Base#onShow_troopType#setTroopTips");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.h();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), paramObserver, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), paramRelativeLayout, paramChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a() != 9)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ScrollerRunnable localScrollerRunnable = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
    if (localScrollerRunnable != null) {
      localScrollerRunnable.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    TroopAioTips localTroopAioTips = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    return (localTroopAioTips != null) && (localTroopAioTips.b());
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
    BaseSessionInfo localBaseSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    if (((List)localObject).size() > 0)
    {
      int i = a((List)localObject, paramLong);
      if (i >= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.5(this, i));
      }
      else
      {
        List localList = localQQAppInterface.getMessageFacade().a(localBaseSessionInfo.jdField_a_of_type_Int).a(localBaseSessionInfo.jdField_a_of_type_JavaLangString, localBaseSessionInfo.jdField_a_of_type_Int, paramLong);
        if (1000 == localBaseSessionInfo.jdField_a_of_type_Int) {
          localObject = ChatActivityUtils.b(localList, localBaseSessionInfo, localQQAppInterface);
        } else {
          localObject = ChatActivityUtils.a(localList, localBaseSessionInfo, localQQAppInterface);
        }
        localObject = ChatActivityUtils.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), localBaseSessionInfo, (MessageRecord)localObject, -1L);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(localList, (CharSequence)localObject);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new Scroller.6(this));
      }
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
  }
  
  public void c()
  {
    ScrollerRunnable localScrollerRunnable = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
    if (localScrollerRunnable != null) {
      localScrollerRunnable.b();
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
    MoveToBottomScroller localMoveToBottomScroller = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller;
    if (localMoveToBottomScroller != null) {
      localMoveToBottomScroller.b();
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
    ScrollerRunnable localScrollerRunnable = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
    if (localScrollerRunnable != null) {
      localScrollerRunnable.d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller
 * JD-Core Version:    0.7.0.1
 */