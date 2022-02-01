package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.imcore.message.PublicAccountRefresher;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.rebuild.PAContext;
import com.tencent.mobileqq.app.BaseActivity;
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
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()).inflate(2131559623, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376350));
    if (!((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).l()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376344));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376342));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_b_of_type_AndroidViewView.findViewById(2131376345));
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
    if (((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).k())
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
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
      }
    }
    else {
      super.a(paramBoolean);
    }
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
    this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.jdField_a_of_type_ComTencentImcoreMessageIMessageRefresher = new PublicAccountRefresher(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMessageFacade().a());
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt == 2) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695220);
          }
        }
        else {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719247);
        }
      }
      else {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(2131719253);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().runOnUiThread(new PAListUI.1(this));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).k()) {
      b(2131695225);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).k()) {
      b(2131695237);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PAListUI", 2, "listView onViewCompleteVisableAndReleased");
    }
    if (!((PAContext)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).k()) {
      return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0))
    {
      this.jdField_a_of_type_Boolean = true;
      a(System.currentTimeMillis());
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.e = false;
      this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext.f = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().jdField_a_of_type_Int, 21, this.jdField_a_of_type_ComTencentImcoreMessageRefreshMessageContext);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI
 * JD-Core Version:    0.7.0.1
 */