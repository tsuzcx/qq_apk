package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.beancurd.BeancurdView;
import com.tencent.mobileqq.beancurd.BeancurdView.OnClickBeancurdListener;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;

public class BeancurdItemBuilder
  extends AbstractChatItemBuilder
  implements BeancurdView.OnClickBeancurdListener
{
  public BeancurdItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramLinearLayout = (MessageForBeancurd)paramMessageRecord;
    paramOnLongClickAndTouchListener = (BeancurdItemBuilder.BeancurdViewHolder)paramViewHolder;
    if (paramView == null) {
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqBeancurdBeancurdView = BeancurdView.a(this.a, paramView, paramLinearLayout.getBeancurdStyle());
    }
    if (paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqBeancurdBeancurdView != null)
    {
      paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqBeancurdBeancurdView.a(this);
      paramViewHolder = paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqBeancurdBeancurdView.a(paramLinearLayout);
      paramView = paramViewHolder;
      if (!paramOnLongClickAndTouchListener.jdField_a_of_type_Boolean)
      {
        paramOnLongClickAndTouchListener.jdField_a_of_type_Boolean = true;
        paramView = paramViewHolder;
        if (paramLinearLayout.getBusiid() == 13L)
        {
          ReportController.b(null, "dc00898", "", paramMessageRecord.frienduin, "0X800BBAF", "0X800BBAF", 0, 0, "", "", "", "");
          paramView = paramViewHolder;
        }
      }
    }
    return paramView;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new BeancurdItemBuilder.BeancurdViewHolder(this);
  }
  
  public void a(MessageForBeancurd paramMessageForBeancurd)
  {
    if (paramMessageForBeancurd.getBusiid() == 13L)
    {
      AnonymousViewHelper.jumpToQuestionListAndAnswer((BaseActivity)this.a, paramMessageForBeancurd.frienduin, 9);
      ReportController.b(null, "dc00898", "", paramMessageForBeancurd.frienduin, "0X800BBB0", "0X800BBB0", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.BeancurdItemBuilder
 * JD-Core Version:    0.7.0.1
 */