package com.tencent.mobileqq.activity.aio.coreui.msglist;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
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
  protected QQMessageFacade.RefreshMessageContext a;
  protected ChatAdapter1 a;
  protected AIOContext a;
  public ChatXListView a;
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
    long l2 = 0L;
    List localList = a();
    long l1 = l2;
    if (paramInt > 0)
    {
      l1 = l2;
      if (paramInt <= localList.size()) {
        l1 = ((ChatMessage)localList.get(paramInt - 1)).uniseq;
      }
    }
    return l1;
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt);
  }
  
  public List<ChatMessage> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(paramInt);
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
      int i = paramChatXListView.getContext().getResources().getDimensionPixelSize(2131299166);
      this.b.setLayoutParams(new AbsListView.LayoutParams(-1, i));
      this.b.setId(2131362466);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    paramObject = (QQMessageFacade.RefreshMessageContext)paramObject;
    ChatContext localChatContext = (ChatContext)paramObject.jdField_a_of_type_JavaLangObject;
    if (!TextUtils.equals(((SessionInfo)localObject).jdField_a_of_type_JavaLangString, localChatContext.a())) {}
    do
    {
      return;
      if ((((SessionInfo)localObject).jdField_a_of_type_Int == paramObject.jdField_d_of_type_Int) && (this.jdField_a_of_type_Long != localChatContext.a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ListUI", 2, "refreshMessageContext sync other MiniAIO");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(131073);
        return;
      }
    } while ((this.jdField_a_of_type_Long != localChatContext.a()) || (!paramObject.jdField_d_of_type_Boolean) || (!ConfessMsgUtil.a(paramObject.jdField_d_of_type_Int, paramObject.jdField_f_of_type_Int, ((SessionInfo)localObject).jdField_a_of_type_Int, ((SessionInfo)localObject).e)));
    localObject = paramObject.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      this.jdField_a_of_type_Int += 1;
    }
    long l = this.jdField_a_of_type_Long + 300L - SystemClock.uptimeMillis();
    if (l > 0L) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().postDelayed(new ListUI.1(this, paramObject), l);
      return;
      l = 0L;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559007, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader(null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.c();
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
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext = new QQMessageFacade.RefreshMessageContext();
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject = new ChatContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e;
  }
  
  public final int d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public int e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.d();
    }
  }
  
  public final int f()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public int g()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
  }
  
  public int h()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
  }
  
  public int i()
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
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)) || ((paramView.jdField_a_of_type_Int == 0) && (!Utils.b(paramView.jdField_a_of_type_JavaLangString))))
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Boolean = true;
      if (paramView.jdField_a_of_type_Int == 1008)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, 21, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramView.jdField_a_of_type_JavaLangString, paramView.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    a(false);
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI
 * JD-Core Version:    0.7.0.1
 */