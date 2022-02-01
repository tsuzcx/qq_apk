package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnMeasureListener;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.os.MqqHandler;

public class ListUI
  implements OverScrollViewListener
{
  protected AIOContext b;
  protected ChatXListView c;
  protected View d;
  protected View e;
  protected ChatAdapter1 f;
  protected View g;
  protected RefreshMessageContext h;
  protected long i = -1L;
  protected int j = 0;
  
  public ListUI(AIOContext paramAIOContext)
  {
    this.b = paramAIOContext;
  }
  
  public int a(long paramLong)
  {
    return this.f.a(paramLong);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return this.f.b(paramChatMessage);
  }
  
  public View a(int paramInt)
  {
    return this.c.getChildAt(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.c.setSelectionFromBottom(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(ChatXListView.OnMeasureListener paramOnMeasureListener)
  {
    this.c.setOnMeasureListener(paramOnMeasureListener);
  }
  
  public void a(ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1)
  {
    b(paramChatXListView, paramChatAdapter1);
    paramChatXListView.setActTAG("actFPSAIO");
    paramChatXListView.setStackFromBottom(true);
    paramChatXListView.setTranscriptMode(0);
    paramChatXListView.setLongClickable(true);
    paramChatXListView.setDelAnimationDuration(300L);
    paramChatXListView.setChoiceMode(2);
    paramChatXListView.b();
    paramChatXListView.setOverScrollListener(this);
    if (this.g == null)
    {
      this.g = new View(paramChatXListView.getContext());
      int k = paramChatXListView.getContext().getResources().getDimensionPixelSize(2131299920) + ImmersiveUtils.getStatusBarHeight(paramChatXListView.getContext());
      this.g.setLayoutParams(new AbsListView.LayoutParams(-1, k));
      this.g.setId(2131428030);
      paramChatXListView.addHeaderView(this.g, null, false);
      paramChatXListView.setOverscrollHeaderTop(k);
    }
    paramChatXListView.setAdapter(paramChatAdapter1);
    paramChatAdapter1.a(paramChatXListView);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    this.f.a(paramChatMessage, paramInt);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = this.b.O();
    paramObject = (RefreshMessageContext)paramObject;
    ChatContext localChatContext = (ChatContext)paramObject.a;
    if (!TextUtils.equals(((BaseSessionInfo)localObject).b, localChatContext.a())) {
      return;
    }
    if ((((BaseSessionInfo)localObject).a == paramObject.q) && (this.i != localChatContext.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListUI", 2, "refreshMessageContext sync other MiniAIO");
      }
      this.b.c(131073);
      return;
    }
    if ((this.i == localChatContext.b()) && (paramObject.f) && (ConfessMsgUtil.a(paramObject.q, paramObject.w, ((BaseSessionInfo)localObject).a, ((BaseSessionInfo)localObject).v)))
    {
      localObject = paramObject.b;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.j += 1;
      }
      long l = this.i + 300L - SystemClock.uptimeMillis();
      if (l <= 0L) {
        l = 0L;
      }
      this.b.g().postDelayed(new ListUI.1(this, paramObject), l);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c.getOverScrollFooterView() == null)
      {
        if (this.e == null) {
          this.e = LayoutInflater.from(this.b.b()).inflate(2131624523, null);
        }
        this.c.setOverScrollFooter(this.e);
      }
    }
    else
    {
      this.c.setOverScrollFooter(null);
      this.c.setOverscrollFooter(null);
    }
  }
  
  public int b(long paramLong)
  {
    return this.f.b(paramLong);
  }
  
  public void b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((ChatXListView)localObject).setRecyclerListener(null);
      this.c.setChatPie(null);
      this.c.setOverScrollListener(null);
      this.c.setShowPanelListener(null);
      this.c.setAdapter(null);
      this.c.setOnScrollListener(null);
      this.c.setOnScrollToButtomListener(null);
      this.c.setOnMeasureListener(null);
      this.c.setOverscrollHeader(null);
      this.c.setOverScrollHeader(null);
    }
    localObject = this.f;
    if (localObject != null) {
      ((ChatAdapter1)localObject).d();
    }
  }
  
  public void b(int paramInt)
  {
    this.c.setVisibility(paramInt);
  }
  
  public void b(ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1)
  {
    this.c = paramChatXListView;
    this.f = paramChatAdapter1;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c.getOverScrollHeaderView() == null)
      {
        if (this.d == null) {
          this.d = LayoutInflater.from(this.b.b()).inflate(2131624523, null);
        }
        this.c.setOverScrollHeader(this.d);
      }
    }
    else
    {
      this.c.setOverscrollHeader(null);
      this.c.setOverScrollHeader(null);
    }
  }
  
  public int c(long paramLong)
  {
    return this.f.c(paramLong);
  }
  
  public long c(int paramInt)
  {
    List localList = d();
    if ((paramInt > 0) && (paramInt <= localList.size())) {
      return ((ChatMessage)localList.get(paramInt - 1)).uniseq;
    }
    return 0L;
  }
  
  public void c()
  {
    this.h = new RefreshMessageContext();
    this.h.a = new ChatContext(this.b.O().b);
    this.h.w = this.b.O().v;
  }
  
  public void c(boolean paramBoolean)
  {
    this.c.setConsiderFooterWhenDrawOverScrollFooter(paramBoolean);
  }
  
  public List<ChatMessage> d()
  {
    return this.f.a();
  }
  
  public boolean e()
  {
    return (this.c.getOverScrollFooterView() != null) && (this.c.getOverScrollFooterView().getVisibility() == 0);
  }
  
  public int f()
  {
    return this.j;
  }
  
  public void g()
  {
    this.j = 0;
  }
  
  public void h()
  {
    ChatAdapter1 localChatAdapter1 = this.f;
    if (localChatAdapter1 != null) {
      localChatAdapter1.e();
    }
  }
  
  public void i()
  {
    this.f.notifyDataSetChanged();
  }
  
  public int j()
  {
    return this.c.getLastVisiblePosition();
  }
  
  public int k()
  {
    return this.c.getChildCount();
  }
  
  public final int l()
  {
    return this.c.getHeight();
  }
  
  public final int m()
  {
    return this.c.getBottom();
  }
  
  public final int n()
  {
    return this.c.getPaddingBottom();
  }
  
  public final int o()
  {
    return this.c.getPaddingTop();
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListUI", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (paramInt == 1) {
      return true;
    }
    paramView = this.b.O();
    paramListView = this.f;
    if (((paramListView != null) && (paramListView.getCount() > 0)) || ((paramView.a == 0) && (!Utils.c(paramView.b))))
    {
      this.i = SystemClock.uptimeMillis();
      ((ChatContext)this.h.a).a(this.i);
      paramListView = this.h;
      paramListView.g = false;
      paramListView.h = true;
      if (paramView.a == 1008)
      {
        this.b.a().getMessageFacade().a(paramView.b, paramView.a, 21, this.h);
        return true;
      }
      this.b.a().getMessageFacade().a(paramView.b, paramView.a, 20, this.h);
      return true;
    }
    b(false);
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public final int p()
  {
    return this.c.getPaddingRight();
  }
  
  public final int q()
  {
    return this.c.getPaddingLeft();
  }
  
  public final void r()
  {
    this.c.requestLayout();
  }
  
  public int s()
  {
    return this.c.getFooterViewsCount();
  }
  
  public final int t()
  {
    return this.c.getScrollY();
  }
  
  public int u()
  {
    return this.c.getFirstVisiblePosition();
  }
  
  public int v()
  {
    return this.c.getHeaderViewsCount();
  }
  
  public int w()
  {
    return d().size();
  }
  
  public ViewGroup.LayoutParams x()
  {
    return this.c.getLayoutParams();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI
 * JD-Core Version:    0.7.0.1
 */