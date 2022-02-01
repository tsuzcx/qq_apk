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
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;

public class FileTimDocGrayTipsItemBuilder
  extends GrayTipsItemBuilder
  implements QQFileManagerUtil.TipsClickedInterface
{
  private String g;
  
  public FileTimDocGrayTipsItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = (FileTimDocGrayTipsItemBuilder.TipHolder)paramViewHolder;
    if (paramView == null)
    {
      paramMessageRecord = LayoutInflater.from(this.c).inflate(2131627106, null);
      paramViewHolder.d = ((TextView)paramMessageRecord.findViewById(2131434371));
    }
    else
    {
      paramMessageRecord = paramView;
    }
    paramView = paramViewHolder.q.getExtInfoFromExtStr("tim_aio_show");
    this.g = paramViewHolder.q.getExtInfoFromExtStr("tim_aio_tips_type");
    if (!paramView.equalsIgnoreCase("showed"))
    {
      if (this.g.equalsIgnoreCase("keyword")) {
        ReportController.b(this.a, "dc00898", "", "", "0X8009077", "0X8009077", 0, 0, "", "", "", "");
      } else if (this.g.equalsIgnoreCase("precent")) {
        ReportController.b(this.a, "dc00898", "", "", "0X800907A", "0X800907A", 0, 0, "", "", "", "");
      } else if (this.g.equalsIgnoreCase("text_keyword")) {
        ReportController.b(this.a, "dc00898", "", "", "0X8009071", "0X800907A", 0, 0, "", "", "", "");
      }
      paramViewHolder.q.saveExtInfoToExtStr("tim_aio_show", "showed");
      ThreadManager.executeOnSubThread(new FileTimDocGrayTipsItemBuilder.1(this, paramViewHolder));
    }
    paramView = FileManagerUtil.a(paramViewHolder.q.getExtInfoFromExtStr("tim_aio_file_tips"), paramViewHolder.q.getExtInfoFromExtStr("tim_aio_file_link"), this);
    paramViewHolder.d.setText(paramView);
    paramViewHolder.d.setMovementMethod(LinkMovementMethod.getInstance());
    paramViewHolder.d.setHighlightColor(17170445);
    return paramMessageRecord;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new FileTimDocGrayTipsItemBuilder.TipHolder(this);
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    ((AIOMessageSpreadManager)this.a.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(localChatMessage, paramView.getContext(), this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.FileTimDocGrayTipsItemBuilder
 * JD-Core Version:    0.7.0.1
 */