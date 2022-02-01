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
import java.util.List;
import mqq.os.MqqHandler;

public class ListUI
  implements OverScrollViewListener
{
  private int a;
  protected long a;
  protected View a;
  protected RefreshMessageContext a;
  protected ChatAdapter1 a;
  protected AIOContext a;
  protected ChatXListView a;
  private View b;
  
  public ListUI(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramLong);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage);
  }
  
  public long a(int paramInt)
  {
    List localList = a();
    if ((paramInt > 0) && (paramInt <= localList.size())) {
      return ((ChatMessage)localList.get(paramInt - 1)).uniseq;
    }
    return 0L;
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt);
  }
  
  public ViewGroup.LayoutParams a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
  }
  
  public List<ChatMessage> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(ChatXListView.OnMeasureListener paramOnMeasureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnMeasureListener(paramOnMeasureListener);
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
    paramChatXListView.a();
    paramChatXListView.setOverScrollListener(this);
    if (this.b == null)
    {
      this.b = new View(paramChatXListView.getContext());
      int i = paramChatXListView.getContext().getResources().getDimensionPixelSize(2131299168);
      this.b.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.b.setId(2131362422);
      paramChatXListView.addHeaderView(this.b, null, false);
      paramChatXListView.setOverscrollHeaderTop(i);
    }
    paramChatXListView.setAdapter(paramChatAdapter1);
    paramChatAdapter1.a(paramChatXListView);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage, paramInt);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    paramObject = (RefreshMessageContext)paramObject;
    ChatContext localChatContext = (ChatContext)paramObject.jdField_a_of_type_JavaLangObject;
    if (!TextUtils.equals(((BaseSessionInfo)localObject).jdField_a_of_type_JavaLangString, localChatContext.a())) {
      return;
    }
    if ((((BaseSessionInfo)localObject).jdField_a_of_type_Int == paramObject.jdField_d_of_type_Int) && (this.jdField_a_of_type_Long != localChatContext.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ListUI", 2, "refreshMessageContext sync other MiniAIO");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(131073);
      return;
    }
    if ((this.jdField_a_of_type_Long == localChatContext.a()) && (paramObject.jdField_d_of_type_Boolean) && (ConfessMsgUtil.a(paramObject.jdField_d_of_type_Int, paramObject.jdField_f_of_type_Int, ((BaseSessionInfo)localObject).jdField_a_of_type_Int, ((BaseSessionInfo)localObject).e)))
    {
      localObject = paramObject.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.jdField_a_of_type_Int += 1;
      }
      long l = this.jdField_a_of_type_Long + 300L - SystemClock.uptimeMillis();
      if (l <= 0L) {
        l = 0L;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().postDelayed(new ListUI.1(this, paramObject), l);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()).inflate(2131558901, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(null);
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
  }
  
  public int b(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b(paramLong);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    if (localObject != null)
    {
      ((ChatXListView)localObject).setRecyclerListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnMeasureListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (localObject != null) {
      ((ChatAdapter1)localObject).c();
    }
  }
  
  public void b(ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramChatXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = paramChatAdapter1;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
  }
  
  public int c(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.c(paramLong);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext = new RefreshMessageContext();
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.jdField_a_of_type_JavaLangObject = new ChatContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().e;
  }
  
  public final int d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public final int e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom();
  }
  
  public void e()
  {
    ChatAdapter1 localChatAdapter1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (localChatAdapter1 != null) {
      localChatAdapter1.d();
    }
  }
  
  public final int f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public final int g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop();
  }
  
  public final void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.requestLayout();
  }
  
  public final int h()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight();
  }
  
  public final int i()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft();
  }
  
  public int j()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
  }
  
  public final int k()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
  }
  
  public int l()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
  }
  
  public int m()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
  }
  
  public int n()
  {
    return a().size();
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListUI", 2, "listView onViewCompleteVisableAndReleased");
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    paramListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
    if (((paramListView != null) && (paramListView.getCount() > 0)) || ((paramView.jdField_a_of_type_Int == 0) && (!Utils.b(paramView.jdField_a_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Long);
      paramListView = this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext;
      paramListView.e = false;
      paramListView.jdField_f_of_type_Boolean = true;
      if (paramView.jdField_a_of_type_Int == 1008)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, 21, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
      return true;
    }
    a(false);
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI
 * JD-Core Version:    0.7.0.1
 */