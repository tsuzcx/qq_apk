package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder;
import com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ThumbItemBuilder
  extends AbstractChatItemBuilder
{
  public static int f = 1;
  Handler e = new ThumbItemBuilder.1(this, Looper.getMainLooper());
  DownloadListener g = new ThumbItemBuilder.3(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private DownloaderFactory h = null;
  
  public ThumbItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.h = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY));
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (ThumbItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramMessageRecord.getExtInfoFromExtStr("callId");
    int i;
    try
    {
      if (!TextUtils.isEmpty(paramViewHolder)) {
        i = Integer.parseInt(paramViewHolder);
      }
    }
    catch (Exception paramViewHolder)
    {
      paramLinearLayout = new StringBuilder();
      paramLinearLayout.append("ThumbItemBuilder getItemView err:");
      paramLinearLayout.append(paramViewHolder.getMessage());
      QLog.e("ChatItemBuilder", 1, paramLinearLayout.toString());
      i = 0;
    }
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.c).inflate(2131624420, null);
      paramOnLongClickAndTouchListener.e = ((AnyScaleTypeImageView)paramViewHolder.findViewById(2131430978));
      paramOnLongClickAndTouchListener.d = ((TextView)paramViewHolder.findViewById(2131430981));
      paramOnLongClickAndTouchListener.f = ((ViewGroup)paramViewHolder.findViewById(2131430977));
      paramOnLongClickAndTouchListener.f.setOnClickListener(new ThumbItemBuilder.2(this, i));
    }
    else
    {
      paramViewHolder = paramView;
    }
    String str = ContactUtils.c(this.a, paramMessageRecord.frienduin);
    File localFile;
    if (i != 0)
    {
      paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
      paramView = VipFunCallUtil.a(this.a, i, 8, paramLinearLayout);
      localFile = new File(paramView);
      if (!FileUtils.fileExists(paramView)) {}
    }
    try
    {
      try
      {
        paramOnLongClickAndTouchListener.e.setImageBitmap(BitmapFactory.decodeFile(paramView));
      }
      catch (Exception paramView)
      {
        paramLinearLayout = new StringBuilder();
        paramLinearLayout.append("colorRingCover err:");
        paramLinearLayout.append(paramView.getMessage());
        QLog.e("ChatItemBuilder", 1, paramLinearLayout.toString());
      }
    }
    catch (OutOfMemoryError paramView)
    {
      label268:
      break label268;
    }
    QLog.e("ChatItemBuilder", 1, "decodeFile funcall thum Bitmap OOM.");
    break label371;
    paramOnLongClickAndTouchListener.e.setImageDrawable(this.c.getResources().getDrawable(2130848966));
    paramView = paramLinearLayout;
    if (TextUtils.isEmpty(paramLinearLayout)) {
      paramView = VipFunCallUtil.b(this.a, i, 8, null);
    }
    paramLinearLayout = new Bundle();
    paramLinearLayout.putInt("type", 1);
    paramView = new DownloadTask(paramView, localFile);
    this.h.a(1).startDownload(paramView, this.g, paramLinearLayout);
    label371:
    paramView = paramMessageRecord.getExtInfoFromExtStr("name");
    if (!TextUtils.isEmpty(paramView))
    {
      try
      {
        paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("tipsType");
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          i = Integer.parseInt(paramMessageRecord);
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramLinearLayout = new StringBuilder();
        paramLinearLayout.append("ThumbItemBuilder getItemView tipsType err:");
        paramLinearLayout.append(paramMessageRecord.getMessage());
        QLog.e("ChatItemBuilder", 1, paramLinearLayout.toString());
        i = 2;
      }
      if (2 == i)
      {
        paramMessageRecord = paramOnLongClickAndTouchListener.d;
        paramLinearLayout = new StringBuilder();
        paramLinearLayout.append(str);
        paramLinearLayout.append(HardCodeUtil.a(2131912239));
        paramLinearLayout.append(this.c.getString(2131887861, new Object[] { paramView }));
        paramMessageRecord.setText(paramLinearLayout.toString());
        return paramViewHolder;
      }
      paramMessageRecord = paramOnLongClickAndTouchListener.d;
      paramLinearLayout = new StringBuilder();
      paramLinearLayout.append(str);
      paramLinearLayout.append(HardCodeUtil.a(2131912240));
      paramLinearLayout.append(this.c.getString(2131887861, new Object[] { paramView }));
      paramMessageRecord.setText(paramLinearLayout.toString());
      return paramViewHolder;
      paramOnLongClickAndTouchListener.e.setImageDrawable(this.c.getResources().getDrawable(2130848966));
      paramMessageRecord = paramOnLongClickAndTouchListener.d;
      paramView = new StringBuilder();
      paramView.append(str);
      paramView.append(this.c.getString(2131887861, new Object[] { this.c.getResources().getString(2131887642) }));
      paramMessageRecord.setText(paramView.toString());
    }
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new ThumbItemBuilder.Holder(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void c()
  {
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder
 * JD-Core Version:    0.7.0.1
 */