package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.imcore.message.PublicAccountRefresher;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.rebuild.PAContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class PAListUI
  extends ListUI
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public boolean a;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public PAListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131559747, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376859));
    if (!((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).g()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376853));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376851));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131376854));
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(boolean paramBoolean)
  {
    if (((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).f())
    {
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
        {
          if (this.jdField_b_of_type_AndroidViewView == null) {
            a();
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_b_of_type_AndroidViewView);
        }
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
      return;
    }
    super.a(paramBoolean);
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramInt);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIMessageRefresher = new PublicAccountRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a());
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new PAListUI.1(this));
        return;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719535);
        continue;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719529);
        continue;
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695224);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).f()) {
      b(2131695229);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).f()) {
      b(2131695241);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAListUI", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (!((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).f()) {
      return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0))
    {
      this.jdField_a_of_type_Boolean = true;
      a(System.currentTimeMillis());
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext.f = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 21, this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade$RefreshMessageContext);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI
 * JD-Core Version:    0.7.0.1
 */