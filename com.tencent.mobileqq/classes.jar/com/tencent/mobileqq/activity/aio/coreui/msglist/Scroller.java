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
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller.OnScrollerListener;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observer;
import mqq.os.MqqHandler;

public class Scroller
  implements MoveToBottomScroller.OnScrollerListener
{
  private static boolean j = false;
  protected AIOContext a;
  ChatXListView b;
  ChatAdapter1 c;
  ScrollerRunnable d;
  public AioTips e;
  protected long f = 0L;
  private MoveToBottomScroller g;
  private int h = 0;
  private boolean i = false;
  private long k = -1L;
  
  private static int a(ChatXListView paramChatXListView)
  {
    int m = paramChatXListView.getHeight();
    try
    {
      int n = paramChatXListView.getChildAt(paramChatXListView.getHeaderViewsCount()).getBottom();
      return m - n;
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
    int i3 = paramInt;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("keepPostionScroll readedCnt ");
      localStringBuilder.append(i3);
      QLog.i(paramString, 2, localStringBuilder.toString());
    }
    int i6 = paramList1.size();
    int i4 = paramList2.size();
    int i5 = paramChatXListView.getScrollY();
    int m = paramChatXListView.getFirstVisiblePosition();
    int i1 = b(paramChatXListView);
    paramInt = i3;
    if (i6 > 0)
    {
      paramInt = i3;
      if (m >= 0)
      {
        int i2 = -1;
        m = i2;
        int n = i1;
        if (i4 > 0)
        {
          m = i1;
          if (i1 >= i6) {
            m = i6 - 1;
          }
          paramInt = m;
          if (m < 0)
          {
            m += paramChatXListView.getHeaderViewsCount();
            paramInt = m;
            if (m < 0) {
              paramInt = 0;
            }
          }
          long l = ((ChatMessage)paramList1.get(paramInt)).uniseq;
          m = 0;
          for (;;)
          {
            i1 = i2;
            if (m >= i4) {
              break;
            }
            if (((ChatMessage)paramList2.get(m)).uniseq == l)
            {
              i1 = m;
              break;
            }
            m += 1;
          }
          m = i1;
          n = paramInt;
          if (i1 < 0)
          {
            i2 = paramList1.size();
            i6 = paramInt + 1;
            m = i1;
            n = paramInt;
            if (i2 > i6)
            {
              l = ((ChatMessage)paramList1.get(i6)).uniseq;
              i2 = 0;
              for (;;)
              {
                m = i1;
                n = paramInt;
                if (i2 >= i4) {
                  break;
                }
                if (((ChatMessage)paramList2.get(i2)).uniseq == l)
                {
                  n = i2;
                  m = 1;
                  i1 = paramInt;
                  paramInt = m;
                  break label349;
                }
                i2 += 1;
              }
            }
          }
        }
        paramInt = 0;
        i1 = n;
        n = m;
        label349:
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("refreshListAdapter newTop:");
          paramList1.append(n);
          paramList1.append(" oldScorllY ");
          paramList1.append(i5);
          paramList1.append(" oldFirst ");
          paramList1.append(i1);
          QLog.i(paramString, 2, paramList1.toString());
        }
        if (n >= 0)
        {
          i1 = i3 + n;
          m = i1;
          if (paramInt != 0) {
            m = i1 - 1;
          }
          if ((i5 < 0) && (n == 0))
          {
            if (QLog.isColorLevel())
            {
              paramList1 = new StringBuilder();
              paramList1.append("springBackOverScrollHeaderView newTop:");
              paramList1.append(n);
              paramList1.append(" oldScorllY ");
              paramList1.append(i5);
              QLog.i(paramString, 2, paramList1.toString());
            }
            paramChatXListView.springBackOverScrollHeaderView();
            return m;
          }
          if (i5 < 0)
          {
            i1 = a(paramChatXListView);
            paramChatXListView.hideOverScrollHeaderView();
            paramChatXListView.setSelectionFromBottom(paramChatXListView.getHeaderViewsCount() + n, i1 + i5 - paramChatXListView.getPaddingBottom());
            paramInt = m;
            if (QLog.isColorLevel())
            {
              paramChatXListView = new StringBuilder();
              paramChatXListView.append("setSelectionFromBottom_1 newTop:");
              paramChatXListView.append(n);
              paramChatXListView.append(" oldScorllY ");
              paramChatXListView.append(i5);
              paramChatXListView.append(" bottom ");
              paramChatXListView.append(i1);
              QLog.i(paramString, 2, paramChatXListView.toString());
              return m;
            }
          }
          else
          {
            paramInt = a(paramChatXListView);
            if (QLog.isColorLevel())
            {
              paramList1 = new StringBuilder();
              paramList1.append("setSelectionFromBottom_2 newTop:");
              paramList1.append(n);
              paramList1.append(" oldScorllY ");
              paramList1.append(i5);
              paramList1.append(" bottom ");
              paramList1.append(paramInt);
              QLog.i(paramString, 2, paramList1.toString());
            }
            paramChatXListView.setSelectionFromBottom(n + paramChatXListView.getHeaderViewsCount(), paramInt - paramChatXListView.getPaddingBottom());
            return m;
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramList1 = new StringBuilder();
            paramList1.append("hideOverScrollHeaderView newTop:");
            paramList1.append(n);
            paramList1.append(" oldScorllY ");
            paramList1.append(i5);
            QLog.i(paramString, 2, paramList1.toString());
          }
          paramChatXListView.hideOverScrollHeaderView();
          paramInt = i4;
        }
      }
    }
    return paramInt;
  }
  
  private int a(List<ChatMessage> paramList, long paramLong)
  {
    BaseSessionInfo localBaseSessionInfo = this.a.O();
    int m = 0;
    while (m < paramList.size())
    {
      if ((localBaseSessionInfo.a != 3000) && (localBaseSessionInfo.a != 1))
      {
        if (((ChatMessage)paramList.get(m)).time == paramLong) {
          return m;
        }
      }
      else if (((ChatMessage)paramList.get(m)).shmsgseq == paramLong) {
        return m;
      }
      m += 1;
    }
    return -1;
  }
  
  private int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = paramInt1;
    if (paramList1 != paramList2)
    {
      if ((paramInt2 > 0) && (paramInt3 > 0))
      {
        long l = ((ChatMessage)paramList1.get(paramInt2 - 1)).uniseq;
        int n = paramInt3 - 1;
        m = n;
        while ((m >= 0) && ((m != n) || (!UniteGrayTipMsgUtil.b((MessageRecord)paramList2.get(m)))))
        {
          if (((ChatMessage)paramList2.get(m)).uniseq == l) {
            break label113;
          }
          m -= 1;
        }
      }
      m = -1;
      label113:
      if (m >= 0) {
        return paramInt3 - (paramInt2 - this.a.e().f().b() + paramInt3 - 1 - m);
      }
      m = paramInt1;
      if (paramInt3 > 0) {
        m = paramInt3;
      }
    }
    return m;
  }
  
  private int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if ((paramInt4 > 0) && (this.b.getHeaderViewsCount() + paramInt2 >= 0))
    {
      paramInt4 = -1;
      paramInt3 = paramInt4;
      boolean bool = paramBoolean;
      int m;
      long l;
      if (paramInt5 > 0)
      {
        paramInt3 = paramInt2;
        if (paramInt2 >= paramList1.size()) {
          paramInt3 = paramList1.size() - 1;
        }
        m = paramInt3;
        if (paramInt3 < 0) {
          m = paramInt3 + this.b.getHeaderViewsCount();
        }
        l = ((ChatMessage)paramList1.get(m)).uniseq;
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
          m += 1;
          paramInt3 = paramInt2;
          bool = paramBoolean;
          if (paramInt4 > m)
          {
            l = ((ChatMessage)paramList1.get(m)).uniseq;
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
        m = this.a.e().f().b();
        l = this.a.e().f().a();
        paramInt2 = 0;
        for (;;)
        {
          paramInt4 = m;
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
          this.b.springBackOverScrollHeaderView();
        } else if (paramInt1 < 0) {
          paramInt4 = this.b.getHeight();
        }
      }
    }
    try
    {
      paramInt5 = this.b.getChildAt(this.b.getHeaderViewsCount()).getBottom();
      paramInt4 -= paramInt5;
    }
    catch (NullPointerException paramList1)
    {
      label424:
      break label424;
    }
    paramInt4 = this.b.getHeight();
    this.b.hideOverScrollHeaderView();
    paramList1 = this.b;
    paramList1.setSelectionFromBottom(paramList1.getHeaderViewsCount() + paramInt3, paramInt4 + paramInt1 - this.b.getPaddingBottom());
    break label544;
    paramInt4 = this.b.getHeight();
    try
    {
      paramInt5 = this.b.getChildAt(this.b.getHeaderViewsCount()).getBottom();
      paramInt4 -= paramInt5;
    }
    catch (NullPointerException paramList1)
    {
      label509:
      StringBuilder localStringBuilder;
      break label509;
    }
    paramInt4 = this.b.getHeight();
    paramList1 = this.b;
    paramList1.setSelectionFromBottom(paramList1.getHeaderViewsCount() + paramInt3, paramInt4 - this.b.getPaddingBottom());
    label544:
    paramInt4 = paramInt2;
    if (this.i)
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
      this.b.hideOverScrollHeaderView();
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
    j = paramBoolean;
  }
  
  private void c()
  {
    BaseSessionInfo localBaseSessionInfo = this.a.O();
    QQAppInterface localQQAppInterface = this.a.a();
    if (this.a.e().f().f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Scroller", 2, "do jumpToSpecifiedMsg");
      }
      long l = System.currentTimeMillis();
      Object localObject = this.a.e().b().d();
      if (((List)localObject).size() > 0)
      {
        int i1 = -1;
        if ((this.a.b().getIntent() != null) && (this.a.b().getIntent().getBooleanExtra("jump_from_shmsgseq", false)))
        {
          int i2 = ((List)localObject).size();
          int m = 0;
          for (;;)
          {
            n = i1;
            if (m >= i2) {
              break;
            }
            if (((ChatMessage)((List)localObject).get(m)).shmsgseq == this.f)
            {
              n = m;
              break;
            }
            m += 1;
          }
        }
        int n = a((List)localObject, this.f);
        if (n >= 0)
        {
          this.b.post(new Scroller.7(this, n));
        }
        else
        {
          List localList = localQQAppInterface.getMessageFacade().a(localBaseSessionInfo.a).a(localBaseSessionInfo.b, localBaseSessionInfo.a, this.f);
          if (1000 == localBaseSessionInfo.a) {
            localObject = ChatActivityUtils.b(localList, localBaseSessionInfo, localQQAppInterface);
          } else {
            localObject = ChatActivityUtils.a(localList, localBaseSessionInfo, localQQAppInterface);
          }
          localObject = ChatActivityUtils.a(localQQAppInterface, this.a.b(), localBaseSessionInfo, (MessageRecord)localObject, -1L);
          this.a.a(localList, (CharSequence)localObject);
          this.b.post(new Scroller.8(this));
        }
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
      this.a.e().f().c(false);
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToSpecifiedMsgSimply, refreshScrollMsg = ");
      ((StringBuilder)localObject).append(this.k);
      QLog.d("Scroller", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c.a();
    if (((List)localObject).size() > 0)
    {
      long l = this.k;
      if (l >= 0L)
      {
        int m = a((List)localObject, l);
        if (m >= 0)
        {
          this.b.post(new Scroller.9(this, m));
          this.k = -1L;
        }
      }
    }
  }
  
  private int e(int paramInt)
  {
    if (this.a.O().a == 1008)
    {
      this.b.postDelayed(new Scroller.2(this), 300L);
      return paramInt;
    }
    this.h += 1;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[refreshListAdapter]: refreshBottomCount=");
      ((StringBuilder)localObject).append(this.h);
      ((StringBuilder)localObject).append(",refreshDelayForNextPie=");
      ((StringBuilder)localObject).append(j);
      QLog.d("Scroller", 2, ((StringBuilder)localObject).toString());
    }
    if (j)
    {
      if (!this.a.e().f().c()) {
        this.b.post(new Scroller.3(this));
      }
      j = false;
      return paramInt;
    }
    if (this.h == 1)
    {
      localObject = this.b;
      ((ChatXListView)localObject).setSelectionFromBottom(((ChatXListView)localObject).getCount() - 1, 0);
      return paramInt;
    }
    this.b.postDelayed(new Scroller.4(this), 100L);
    return paramInt;
  }
  
  private int f(int paramInt)
  {
    this.b.setSelection(0);
    return paramInt;
  }
  
  protected int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return paramInt5;
  }
  
  public final int a(List<ChatMessage> paramList1, List<ChatMessage> paramList2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (this.i) {
      QLog.d("Scroller", 1, String.format("refreshListAdapterScroll- start oldScorllY = %d,oldFirst = %d,readed = %d,oldSize = %d,newSize = %d,dirtyFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) }));
    }
    int n = this.a.e().f().b();
    int m;
    if (paramInt6 != 1)
    {
      if (paramInt6 != 2)
      {
        if (paramInt6 != 3)
        {
          if (paramInt6 != 4)
          {
            if (paramInt6 != 5)
            {
              if ((paramInt6 != 7) && (paramInt6 != 8))
              {
                if (paramInt6 != 9) {
                  if (paramInt6 != 16) {
                    if (paramInt6 != 17) {
                      if (paramInt6 != 32) {
                        paramInt3 = a(paramList1, paramList2, paramInt3, paramInt4, paramInt5);
                      }
                    }
                  }
                }
                label258:
                for (;;)
                {
                  break;
                  paramInt3 = f(paramInt5);
                  continue;
                  d();
                  break label258;
                  paramList1 = this.c.a();
                  if (paramList1.size() > 0)
                  {
                    long l = this.k;
                    if (l >= 0L)
                    {
                      m = a(paramList1, l);
                      if (m >= 0)
                      {
                        a(m, 1);
                        this.k = -1L;
                        break label258;
                        c();
                      }
                    }
                  }
                }
              }
              paramInt3 = a(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
              break label432;
            }
            this.b.hideOverScrollerFooterView();
            paramInt3 = a(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
            break label432;
          }
          if (paramInt4 == 0)
          {
            paramList1 = this.b;
            paramList1.setSelectionFromBottom(paramList1.getHeaderViewsCount() + paramInt5 - 1, 0);
            this.b.hideOverScrollHeaderView();
          }
          else
          {
            this.b.hideOverScrollHeaderView();
            paramInt3 = a(paramList1, paramList2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, false);
            break label432;
          }
        }
        else
        {
          paramInt3 = e(paramInt5);
          break label432;
        }
      }
      else if (!this.a.e().f().c()) {
        g();
      }
      paramInt3 = paramInt5;
    }
    else
    {
      a("Scroller", this.b, 0, paramList1, paramList2);
      paramInt3 = n + paramInt5 - paramInt4;
    }
    label432:
    if (paramInt6 == 7)
    {
      paramInt3 = paramInt5 - (paramInt4 - n);
      a(this.b.getHeaderViewsCount(), -1, null, 7);
      if ((i() != 22) && (i() != 103)) {
        QQToast.makeText(this.a.a().getApp(), 1, this.a.b().getString(2131895568), 3000).show(this.a.v());
      } else {
        QQToast.makeText(this.a.a().getApp(), 1, this.a.b().getString(2131895567), 3000).show(this.a.v());
      }
    }
    else if (paramInt6 == 8)
    {
      m = this.c.getCount();
      paramInt3 = 0;
      while (paramInt3 < m)
      {
        paramList1 = (ChatMessage)this.c.getItem(paramInt3);
        if ((paramList1 != null) && (paramList1.msgtype == -4009))
        {
          bool = true;
          break label647;
        }
        paramInt3 += 1;
      }
      paramInt3 = 0;
      boolean bool = false;
      if (paramInt3 == 0) {
        m = 0;
      } else {
        m = -1;
      }
      a(paramInt3, m, null, 8, bool);
      paramInt3 = paramInt5 - (paramInt4 - n);
    }
    label647:
    if (this.i) {
      QLog.d("Scroller", 1, String.format("refreshListAdapterScroll- end oldScorllY = %d,oldFirst = %d,readed = %d,oldSize = %d,newSize = %d,dirtyFlag = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6) }));
    }
    return paramInt3;
  }
  
  public void a()
  {
    JumpStateMachineController localJumpStateMachineController = ((TroopListUI)this.a.e().b()).y();
    if ((localJumpStateMachineController != null) && (localJumpStateMachineController.a() == JumpState.JUMP_SUCCESS) && (localJumpStateMachineController.b() == JumpState.GRAY_TIP_CLICK)) {
      this.a.e().d().r();
    }
  }
  
  public void a(int paramInt)
  {
    this.d.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d.a(paramInt1, 0, null, paramInt2, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, int paramInt4)
  {
    this.d.a(paramInt1, paramInt2, paramInt3, paramRunnable, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, Runnable paramRunnable, MqqHandler paramMqqHandler, int paramInt4)
  {
    this.d.a(paramInt1, paramInt2, paramInt3, paramRunnable, paramMqqHandler, paramInt4);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable, int paramInt3)
  {
    this.d.a(paramInt1, paramInt2, paramRunnable, paramInt3, false);
  }
  
  public void a(int paramInt1, int paramInt2, Runnable paramRunnable, int paramInt3, boolean paramBoolean)
  {
    this.d.a(paramInt1, paramInt2, paramRunnable, paramInt3, paramBoolean);
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
    long l = n();
    Object localObject = new Scroller.1(this);
    this.d.c(paramInt3);
    a(paramInt1, paramLong, paramInt2, paramInt4, l, (Runnable)localObject);
  }
  
  public void a(int paramInt1, long paramLong1, int paramInt2, int paramInt3, long paramLong2, Runnable paramRunnable)
  {
    int m;
    if (this.a.c().b() == 9) {
      m = 1;
    } else {
      m = 0;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshHeadMessage==>firstSeq:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("|value:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("|type:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Scroller.troop.special_msg", 2, ((StringBuilder)localObject).toString());
    }
    if (m == 0)
    {
      localObject = this.a.e().a().a(paramInt1);
      if (localObject != null)
      {
        ((IHeadMsgRefresher)localObject).a(this.a, paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramRunnable);
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
    this.d.a(paramLong);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AioTips localAioTips = this.e;
    if (localAioTips != null) {
      localAioTips.a(paramLong1, paramLong2, paramBoolean);
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.f = paramIntent.getLongExtra("searched_timeorseq", -1L);
  }
  
  public void a(AIOContext paramAIOContext, ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1, AIOFooterViewDetector paramAIOFooterViewDetector)
  {
    this.a = paramAIOContext;
    this.b = paramChatXListView;
    this.c = paramChatAdapter1;
    this.d = new ScrollerRunnable(paramChatXListView);
    this.g = new MoveToBottomScroller(paramChatXListView, paramAIOFooterViewDetector);
    if ((paramAIOContext instanceof TroopAIOContext)) {
      this.g.a(this);
    }
  }
  
  public void a(Observer paramObserver, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1)
  {
    AioTips localAioTips = this.e;
    if (localAioTips == null) {
      return;
    }
    localAioTips.j();
    this.e.a(this.a.a(), this.a.b(), paramObserver, this.a.O(), paramRelativeLayout, paramChatAdapter1, this.b, this.d);
    if (this.a.c().b() != 9) {
      this.e.d();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ScrollerRunnable localScrollerRunnable = this.d;
    if (localScrollerRunnable != null) {
      localScrollerRunnable.a(paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    int m = this.b.getHeaderViewsCount();
    this.b.setSelectionFromTop(m + paramInt, this.a.b().getTitleBarHeight());
    this.d.a(paramInt, 250L);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.d.a(paramInt1, paramInt2);
  }
  
  public void b(long paramLong)
  {
    long l = System.currentTimeMillis();
    BaseSessionInfo localBaseSessionInfo = this.a.O();
    QQAppInterface localQQAppInterface = this.a.a();
    Object localObject = this.c.a();
    if (((List)localObject).size() > 0)
    {
      int m = a((List)localObject, paramLong);
      if (m >= 0)
      {
        this.b.post(new Scroller.5(this, m));
      }
      else
      {
        List localList = localQQAppInterface.getMessageFacade().a(localBaseSessionInfo.a).a(localBaseSessionInfo.b, localBaseSessionInfo.a, paramLong);
        if (1000 == localBaseSessionInfo.a) {
          localObject = ChatActivityUtils.b(localList, localBaseSessionInfo, localQQAppInterface);
        } else {
          localObject = ChatActivityUtils.a(localList, localBaseSessionInfo, localQQAppInterface);
        }
        localObject = ChatActivityUtils.a(localQQAppInterface, this.a.b(), localBaseSessionInfo, (MessageRecord)localObject, -1L);
        this.a.a(localList, (CharSequence)localObject);
        this.b.post(new Scroller.6(this));
      }
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l, 0L, null, null);
  }
  
  public boolean b()
  {
    AioTips localAioTips = this.e;
    return (localAioTips != null) && (localAioTips.cB_());
  }
  
  public void c(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void c(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    this.k = paramLong;
    this.a.e().f().a(65552);
  }
  
  public void d(int paramInt)
  {
    this.d.c(paramInt);
  }
  
  public void d(long paramLong)
  {
    this.k = paramLong;
  }
  
  public BaseAioMsgNavigateBar e()
  {
    return this.e.k();
  }
  
  public AioTips f()
  {
    return this.e;
  }
  
  public void g()
  {
    this.g.a();
  }
  
  public void h()
  {
    this.b.setSelection(0);
    this.d.a(0, 250L);
  }
  
  public int i()
  {
    return this.d.g();
  }
  
  public void j()
  {
    ScrollerRunnable localScrollerRunnable = this.d;
    if (localScrollerRunnable != null) {
      localScrollerRunnable.b();
    }
  }
  
  public void k()
  {
    MoveToBottomScroller localMoveToBottomScroller = this.g;
    if (localMoveToBottomScroller != null) {
      localMoveToBottomScroller.b();
    }
  }
  
  public void l()
  {
    j();
    k();
  }
  
  public void m()
  {
    ScrollerRunnable localScrollerRunnable = this.d;
    if (localScrollerRunnable != null) {
      localScrollerRunnable.e();
    }
  }
  
  public long n()
  {
    List localList = this.a.e().b().d();
    if (localList != null)
    {
      int n = localList.size();
      int m = 0;
      while (m < n)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(m);
        if ((MsgProxyUtils.a(localChatMessage)) || (((localChatMessage instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localChatMessage).tipParam.i == 1) && (m < n - 1) && (((ChatMessage)localList.get(m + 1)).shmsgseq - localChatMessage.shmsgseq > 1L))) {
          m += 1;
        } else {
          return localChatMessage.shmsgseq;
        }
      }
    }
    return 0L;
  }
  
  public long o()
  {
    List localList = this.a.e().b().d();
    if (localList != null)
    {
      int m = localList.size() - 1;
      while (m >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(m);
        if ((MsgProxyUtils.a(localChatMessage)) || (((localChatMessage instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localChatMessage).tipParam.i == 1) && (m > 0) && (localChatMessage.shmsgseq - ((ChatMessage)localList.get(m - 1)).shmsgseq > 1L))) {
          m -= 1;
        } else {
          return localChatMessage.shmsgseq;
        }
      }
    }
    return 0L;
  }
  
  public long p()
  {
    return this.f;
  }
  
  public void q()
  {
    this.f = 0L;
  }
  
  public void r()
  {
    this.b.post(new Scroller.10(this));
  }
  
  public void s()
  {
    this.h = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller
 * JD-Core Version:    0.7.0.1
 */