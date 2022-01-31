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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import vfx;
import vfy;
import vfz;
import vga;

public class ThumbItemBuilder
  extends AbstractChatItemBuilder
{
  public static int a;
  public Handler a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new vfz(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public ThumbItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidOsHandler = new vfx(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(46));
  }
  
  protected View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (vga)paramViewHolder;
    int i = 0;
    paramViewHolder = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramViewHolder)) {
        i = Integer.parseInt(paramViewHolder);
      }
      paramViewHolder = paramView;
      if (paramView == null)
      {
        paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968743, null);
        paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramViewHolder.findViewById(2131363512));
        paramOnLongClickAndTouchListener.b = ((TextView)paramViewHolder.findViewById(2131363514));
        paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewHolder.findViewById(2131363511));
        paramOnLongClickAndTouchListener.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new vfy(this, i));
      }
      str = ContactUtils.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = VipFunCallManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!FileUtils.a(paramView)) {}
      }
    }
    catch (Exception paramViewHolder)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
          paramView = paramMessageRecord.getExtInfoFromExtStr("name");
          if (!TextUtils.isEmpty(paramView)) {
            j = 2;
          }
          try
          {
            paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("tipsType");
            i = j;
            if (!TextUtils.isEmpty(paramMessageRecord)) {
              i = Integer.parseInt(paramMessageRecord);
            }
          }
          catch (Exception paramMessageRecord)
          {
            QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView tipsType err:" + paramMessageRecord.getMessage());
            i = j;
            continue;
            paramOnLongClickAndTouchListener.b.setText(str + "更新" + this.jdField_a_of_type_AndroidContentContext.getString(2131436183, new Object[] { paramView }));
            return paramViewHolder;
          }
          if (2 != i) {
            break;
          }
          paramOnLongClickAndTouchListener.b.setText(str + "设置" + this.jdField_a_of_type_AndroidContentContext.getString(2131436183, new Object[] { paramView }));
          return paramViewHolder;
          paramViewHolder = paramViewHolder;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramViewHolder.getMessage());
          i = 0;
        }
        catch (OutOfMemoryError paramView)
        {
          QLog.e("ChatItemBuilder", 1, "decodeFile funcall thum Bitmap OOM.");
          continue;
        }
        catch (Exception paramView)
        {
          QLog.e("ChatItemBuilder", 1, "colorRingCover err:" + paramView.getMessage());
          continue;
        }
        paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843806));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = VipFunCallManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new DownloadTask(paramView, localFile);
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramView, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramLinearLayout);
      }
    }
    paramOnLongClickAndTouchListener.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843806));
    paramOnLongClickAndTouchListener.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131436183, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131436180) }));
    return paramViewHolder;
  }
  
  protected AbstractChatItemBuilder.ViewHolder a()
  {
    return new vga(this);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public QQCustomMenuItem[] a(View paramView)
  {
    return new QQCustomMenuItem[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ThumbItemBuilder
 * JD-Core Version:    0.7.0.1
 */