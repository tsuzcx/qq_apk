package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;

public class FileTimDocGrayTipsItemBuilder
  extends GrayTipsItemBuilder
  implements FileManagerUtil.TipsClickedInterface
{
  private String b;
  
  public FileTimDocGrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  public View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (FileTimDocGrayTipsItemBuilder.TipHolder)paramViewHolder;
    paramMessageRecord = paramView;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560973, null);
      paramViewHolder.b = ((TextView)paramMessageRecord.findViewById(2131368045));
    }
    paramView = paramViewHolder.a.getExtInfoFromExtStr("tim_aio_show");
    this.b = paramViewHolder.a.getExtInfoFromExtStr("tim_aio_tips_type");
    if (!paramView.equalsIgnoreCase("showed"))
    {
      if (!this.b.equalsIgnoreCase("keyword")) {
        break label184;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009077", "0X8009077", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      paramViewHolder.a.saveExtInfoToExtStr("tim_aio_show", "showed");
      ThreadManager.executeOnSubThread(new FileTimDocGrayTipsItemBuilder.1(this, paramViewHolder));
      paramView = FileManagerUtil.a(paramViewHolder.a.getExtInfoFromExtStr("tim_aio_file_tips"), paramViewHolder.a.getExtInfoFromExtStr("tim_aio_file_link"), this);
      paramViewHolder.b.setText(paramView);
      paramViewHolder.b.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.b.setHighlightColor(17170445);
      return paramMessageRecord;
      label184:
      if (this.b.equalsIgnoreCase("precent")) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800907A", "0X800907A", 0, 0, "", "", "", "");
      } else if (this.b.equalsIgnoreCase("text_keyword")) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009071", "0X800907A", 0, 0, "", "", "", "");
      }
    }
  }
  
  public AbstractChatItemBuilder.ViewHolder a()
  {
    return new FileTimDocGrayTipsItemBuilder.TipHolder(this);
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    ((AIOMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(localChatMessage, paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileTimDocGrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */